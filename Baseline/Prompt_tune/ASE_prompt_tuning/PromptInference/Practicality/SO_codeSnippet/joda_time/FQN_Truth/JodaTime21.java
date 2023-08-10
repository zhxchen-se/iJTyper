public class JodaTime21 {
    public static void main(java.lang.String[] args) {
        java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date dt = null;
        try {
            dt = ((java.sql.Date) (formatter.parse("2011-10-23 12:00:00")));
        } catch (java.text.ParseException e) {

            e.printStackTrace();
        }
        org.joda.time.LocalDateTime ldt = new org.joda.time.DateTime(dt).withZone(org.joda.time.DateTimeZone.UTC).toLocalDateTime();
        java.lang.System.out.println("Original date: " + ldt.toDateTime().toDate().toString());
        org.joda.time.DateTime cvtldt = ldt.toDateTime(org.joda.time.DateTimeZone.forID("-05:00"));
        java.lang.System.out.println("Converted date: " + cvtldt.toLocalDateTime().toDateTime().toDate().toString());
    }
}

