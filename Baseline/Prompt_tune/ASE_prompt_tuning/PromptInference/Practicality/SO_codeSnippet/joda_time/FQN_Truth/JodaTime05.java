public class JodaTime05 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateTimeZone zone = org.joda.time.DateTimeZone.forID("Europe/London");
        org.joda.time.Chronology coptic = org.joda.time.chrono.GJChronology.getInstance(zone);
        org.joda.time.DateTime dt = new org.joda.time.DateTime(coptic);
        org.joda.time.DateTime minusOneDay = dt.minusDays(1);
        java.lang.System.out.println(minusOneDay);
    }
}

