public class jt17 {
    public static void h1() {
        java.lang.String dateTime = "2015-07-18T13:32:56.971-0400";
        org.joda.time.format.DateTimeFormatter formatter = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").withLocale(java.util.Locale.ROOT).withChronology(org.joda.time.chrono.ISOChronology.getInstanceUTC());
        org.joda.time.DateTime dt = formatter.parseDateTime(dateTime);
    }
}

