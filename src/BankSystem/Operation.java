package BankSystem;

public abstract class Operation{
    protected double amount;
    public abstract void doWork() throws OperationExemption;
}
