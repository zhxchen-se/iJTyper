package java.joda_time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class jt11 {
    public static void h1(){
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime start = new DateTime(2013, 10, 20, 5, 0, 0, BRAZIL);
        DateTime end = new DateTime(2013, 10, 21, 13, 0, 0, BRAZIL);
    }
}
