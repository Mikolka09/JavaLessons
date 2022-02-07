package BankSystem;

public class Client implements Comparable<Client> {
    private String passport;
    private String name;
    private Bank.Account account;

    public Client(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + " " + this.passport;
    }

    public int compareTo(Client c){

        return name.compareTo(c.getName());
    }
}
