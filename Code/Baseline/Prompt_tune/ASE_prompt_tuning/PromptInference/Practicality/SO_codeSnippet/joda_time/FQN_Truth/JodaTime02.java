public class JodaTime02 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateMidnight today = new org.joda.time.DateMidnight(2009, 2, 24);
        org.joda.time.DateTimeZone zone = today.getZone();
        org.joda.time.DateTime previousTransition = new org.joda.time.DateTime(zone.previousTransition(today.getMillis()));
        java.lang.System.out.println(previousTransition);
        org.joda.time.DateTime nextTransition = new org.joda.time.DateTime(zone.nextTransition(today.getMillis()));
        java.lang.System.out.println(nextTransition);
    }
}

