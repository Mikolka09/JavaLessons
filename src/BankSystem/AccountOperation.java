package BankSystem;

import static BankSystem.Banking.loggers;

public class AccountOperation extends Operation {
    private Bank.Account account;

    public AccountOperation(Bank.Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void doWork() throws OperationExemption {
        double balance = account.getBalance();
        double result = balance + amount;
        if (result < 0) {
            loggers.add(new Logger("Недостаточно средств на счету " + account));
            throw new OperationExemption("Недостаточно средств на счету " + account);
        }

        account.setBalance(result);
    }
}
