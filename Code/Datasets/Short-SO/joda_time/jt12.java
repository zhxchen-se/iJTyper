package java.joda_time;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class jt12 {
    public static void h1(DateTime end,DateTime start){
        Days.daysBetween(new LocalDate(start), new LocalDate(end)).getDays();
    }
}
