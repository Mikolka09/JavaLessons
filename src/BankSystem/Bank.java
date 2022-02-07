package BankSystem;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

import static BankSystem.Banking.loggers;

public class Bank {
    private static int accountNum = 1;

    public class Account implements Comparable<Account> {
        private double balance;
        private final String number;
        private Client client;

        public Account(Client client, double startbalance) {
            this(client);
            balance = startbalance;
        }

        public Account(Client client) {
            this.client = client;
            balance = 0;
            number = "Acc " + accountNum++;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String toString() {
            return "Счет № " + number + " Владелец: " + client.toString() + " Баланс: " + balance;
        }

        public int compareTo(Account a) {

            return number.compareTo(a.number);
        }
    }

    private Tree<Client> clients = new Tree<Client>();
    private Vector<Account> accounts = new Vector<Account>();
    private Vector<Operation> operations = new Vector<Operation>();

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void runOperation() {
        for (int i = 0; i < operations.size(); i++) {
            try {
                operations.get(i).doWork();
            } catch (OperationExemption ex) {
                loggers.add(new Logger(ex.getMessage()));
                System.out.println(ex.getMessage());
            }
        }
        operations.clear();
    }

    public Bank.Account createAccount(String clientName, String passport, double initialBalance) {
        Client cl = null;
        for (int i = 0; i < clients.size(); i++) {
            if (Objects.equals(clients.find(i).getData().getPassport(), passport)) {
                cl = clients.find(i).getData();
                break;
            }
        }
        if (cl == null) {
            cl = new Client(clientName, passport);
            int key = new Random().nextInt() * 1000;
            clients.add(key, cl);
        }
        Account acc = new Account(cl, initialBalance);
        accounts.add(acc);

        return acc;
    }

    public Bank.Account createAccount(String clientName, String passport) {
        return createAccount(clientName, passport, 0);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("Состояние счета \n----------\n");
        for (int i = 0; i < accounts.size(); i++) {
            builder.append(accounts.get(i));
            builder.append("\n");
        }

        return builder.toString();
    }

}
