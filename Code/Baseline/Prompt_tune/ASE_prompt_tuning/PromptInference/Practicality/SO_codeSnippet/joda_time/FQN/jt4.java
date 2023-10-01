public class jt4 {
    public static boolean isLonger(org.joda.time.Period p1, org.joda.time.Period p2) {
        org.joda.time.Instant now = org.joda.time.Instant.now();
        org.joda.time.Duration d1 = p1.toDurationTo(now);
        org.joda.time.Duration d2 = p2.toDurationTo(now);
        return d1.isLongerThan(d2);
    }
}

