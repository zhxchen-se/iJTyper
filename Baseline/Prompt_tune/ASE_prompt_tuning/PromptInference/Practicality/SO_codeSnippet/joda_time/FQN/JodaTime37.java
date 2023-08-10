public class JodaTime37 {
    public static void main(java.lang.String[] args) {
        // 5am on the 20th to 1pm on the 21st, October 2013, Brazil
        org.joda.time.DateTimeZone BRAZIL = org.joda.time.DateTimeZone.forID("America/Sao_Paulo");
        org.joda.time.DateTime start = new org.joda.time.DateTime(2013, 10, 20, 5, 0, 0, BRAZIL);
        org.joda.time.DateTime end = new org.joda.time.DateTime(2013, 10, 21, 13, 0, 0, BRAZIL);
        java.lang.System.out.println(jodatime.JodaTime37.getDaysBetween(start, end));
        // prints 1
    }

    public static int getDaysBetween(org.joda.time.DateTime earlier, org.joda.time.DateTime later) {
        return ((int) (java.util.concurrent.TimeUnit.MILLISECONDS.toDays(later.getMillis() - earlier.getMillis())));
    }
}

