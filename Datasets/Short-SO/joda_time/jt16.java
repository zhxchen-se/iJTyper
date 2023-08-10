package java.joda_time;

import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

public class jt16 {
    public static int getDaysBetween(DateTime earlier, DateTime later)
    {
        return (int) TimeUnit.MILLISECONDS.toDays(later.getMillis()- earlier.getMillis());
    }

}
