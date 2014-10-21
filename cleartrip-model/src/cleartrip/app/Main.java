package cleartrip.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String r = dateFormat.format(date);
        date = dateFormat.parse(r);
        System.out.println("Resultado: " + date);
    }

}
