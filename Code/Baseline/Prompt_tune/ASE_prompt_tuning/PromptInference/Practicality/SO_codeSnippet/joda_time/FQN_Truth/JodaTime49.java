public class JodaTime49 {
    public static void main(java.lang.String[] args) {

        org.joda.time.format.DateTimeFormatter FORMATTER = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MMM-dd");
        org.joda.time.DateTime dateTime = FORMATTER.parseDateTime("2005-nov-12");
        org.joda.time.LocalDate localDate = dateTime.toLocalDate();
    }
}

