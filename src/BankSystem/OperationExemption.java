package BankSystem;

public class OperationExemption extends Throwable {
    String error ="";
    public OperationExemption(String error){
        super(error);
        this.error=error;
    }

    public String toString(){
        return error;
    }

}
