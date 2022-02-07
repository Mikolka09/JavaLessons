package BankSystem;

import static BankSystem.Banking.loggers;

public class CrossAccountOperation extends Operation {
    private Bank.Account outAccount;
    private Bank.Account inAccount;

    public CrossAccountOperation(Bank.Account outAccount, Bank.Account inAccount, double amount) {
        super.amount = amount;
        this.outAccount = outAccount;
        this.inAccount = inAccount;

    }

    public void doWork() throws OperationExemption {
        double outBalance = outAccount.getBalance();
        double inBalance = inAccount.getBalance();
        if (outBalance < amount) {
            loggers.add(new Logger("Недостаточно средств на счету " + outAccount));
            throw new OperationExemption("Недостаточно средств на счету " + outAccount);
        }
        inAccount.setBalance(inBalance + amount);
        outAccount.setBalance(outBalance - amount);
    }

}
