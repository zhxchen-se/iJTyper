public class jt10 {
    public static void h1() {
        org.joda.time.DateTime now = org.joda.time.DateTime.now();
        org.joda.time.DateTime dateTime = now.plusMinutes(10);
        org.joda.time.Seconds seconds = org.joda.time.Seconds.secondsBetween(now, dateTime);
    }
}

