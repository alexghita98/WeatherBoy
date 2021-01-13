package ro.mta.se.lab;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValuesConverter {
    public static float convertTemperature(float k_value) {
        return (float) (k_value - 273.15);
    }

    public static String convertToDate(long timeStamp) {
        Date date = new Date((long)timeStamp*1000);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return dateFormat.format(date);
    }
}