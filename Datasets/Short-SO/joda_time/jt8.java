package java.joda_time;

import org.joda.time.DateTime;

import java.util.Calendar;

public class jt8 {
    public static  int getFirstDayOfWeek() {
        return ((Calendar.getInstance().getFirstDayOfWeek() + 5) % 7) + 1;
    }

}
