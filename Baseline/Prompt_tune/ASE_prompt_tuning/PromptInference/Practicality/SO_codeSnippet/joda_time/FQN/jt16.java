public class jt16 {
    public static int getDaysBetween(org.joda.time.DateTime earlier, org.joda.time.DateTime later) {
        return ((int) (java.util.concurrent.TimeUnit.MILLISECONDS.toDays(later.getMillis() - earlier.getMillis())));
    }
}

