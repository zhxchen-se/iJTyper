package java.joda_time;

import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Period;

public class jt4 {
    public static boolean isLonger(Period p1, Period p2) {
        Instant now = Instant.now();
        Duration d1 = p1.toDurationTo(now);
        Duration d2 = p2.toDurationTo(now);
        return d1.isLongerThan(d2);
    }
}
