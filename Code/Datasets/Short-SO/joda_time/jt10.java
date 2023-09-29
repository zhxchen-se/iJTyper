package java.joda_time;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class jt10 {
    public static void h1(){
        DateTime now = DateTime.now();
        DateTime dateTime = now.plusMinutes(10);
        Seconds seconds = Seconds.secondsBetween(now, dateTime);
    }
}
