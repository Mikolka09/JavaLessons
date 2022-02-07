package BankSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    String error;
    String date;

    public Logger(String error){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.error =error;
        this.date = dateFormat.format(date);
    }
}
