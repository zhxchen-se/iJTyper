public class JodaTime28 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.DateTimeFormatter dateFromatter = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy");
        org.joda.time.DateTime startDate = dateFromatter.parseDateTime("01/02/2012");
        org.joda.time.DateTime endDate = dateFromatter.parseDateTime("01/31/2012");
        java.util.List<org.joda.time.LocalDate> dates = new java.util.ArrayList<org.joda.time.LocalDate>();
        int days = org.joda.time.Days.daysBetween(startDate, endDate).getDays();
    }
}

