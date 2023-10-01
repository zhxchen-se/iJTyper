public class JodaTime01 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.DateTimeFormatter timeParser = org.joda.time.format.ISODateTimeFormat.timeParser();
        java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
        java.lang.System.out.println(timeZone.getID());
        java.lang.System.out.println(timeZone.getDisplayName());
        org.joda.time.DateTimeZone defaultTimeZone = org.joda.time.DateTimeZone.getDefault();
        java.lang.System.out.println(defaultTimeZone.getID());
        java.lang.System.out.println(defaultTimeZone.getName(0L));
        org.joda.time.DateTime currentTime = new org.joda.time.DateTime();
        org.joda.time.DateTimeZone currentZone = currentTime.getZone();
        java.lang.System.out.println(currentZone.getID());
        java.lang.System.out.println(currentZone.getName(0L));
    }
}

