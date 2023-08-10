package java.joda_time;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class jt6 {
    public static void h1(){
        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime time = format.parseDateTime("04/02/2011 20:27:05");
    }
}
