public class JodaTime20 {
    public static void main(java.lang.String[] args) {
        java.lang.String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        org.joda.time.format.DateTimeFormatter DATETIME_FORMATTER = org.joda.time.format.DateTimeFormat.forPattern(DATE_FORMAT);
        org.joda.time.DateTimeZone dateTimeZone = org.joda.time.DateTimeZone.forID("-03:00");
        org.joda.time.DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime("2000-01-01 00:00:00");
        java.lang.System.out.println("Current date is: " + date.toString());
        org.joda.time.DateTime convertedDate = date.toDateTime(org.joda.time.DateTimeZone.UTC);
        java.lang.System.out.println("Converted date: " + date.toString());

    }
}

