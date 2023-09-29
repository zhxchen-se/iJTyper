public class JodaTime02 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateMidnight today = new org.joda.time.DateMidnight(2009, 2, 24);
        org.joda.time.DateTimeZone zone = today.getZone();
        org.joda.time.DateTime previousTransition = new org.joda.time.DateTime(zone.previousTransition(today.getMillis()));
        // 2008-10-26T02:59:59.999+02:00 for Europe/Berlin
        java.lang.System.out.println(previousTransition);
        org.joda.time.DateTime nextTransition = new org.joda.time.DateTime(zone.nextTransition(today.getMillis()));
        // 2009-03-29T03:00:00.000+02:00 for Europe/Berlin
        java.lang.System.out.println(nextTransition);
    }
}

