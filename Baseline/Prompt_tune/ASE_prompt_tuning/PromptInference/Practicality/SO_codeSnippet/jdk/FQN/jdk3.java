public class jdk3 {
    public static void h1(java.lang.String oldDate, java.lang.String format) throws java.text.ParseException {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern(format);
        java.time.LocalDateTime dt = java.time.LocalDateTime.parse(oldDate, dtf);
        java.time.ZonedDateTime zdtzone = dt.atZone(java.time.ZoneId.of("America/Los_Angeles"));
    }
}

