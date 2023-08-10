package java.joda_time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class jt1 {
    public static void f1(){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        DateTime jodatime = dtf.parseDateTime("");
    }

}
