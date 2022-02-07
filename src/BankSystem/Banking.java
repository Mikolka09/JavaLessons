package BankSystem;

import java.util.LinkedList;

public class Banking {
    static LinkedList<Logger> loggers = new LinkedList<Logger>();
    public static void main(String[] args) {
        Bank bnk = new Bank();
        Bank.Account acc = bnk.createAccount("Sasha", "AK123456");
        Bank.Account acc1 = bnk.createAccount("Sasha2", "AK123999", 500);
        System.out.println(bnk);
        AccountOperation op = new AccountOperation(acc, 100);
        CrossAccountOperation op2 = new CrossAccountOperation(acc, acc1, 500);
        bnk.addOperation(op);
        bnk.runOperation();
        bnk.addOperation(op2);
        bnk.runOperation();
        System.out.println(bnk);
    }
}
