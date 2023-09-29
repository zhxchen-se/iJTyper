public class JodaTime32 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.DateTimeFormatter dtf = null;
        // TODO Auto-generated method stub
        final org.joda.time.DateTime date1 = dtf.parseDateTime("1979-04-29");
        final org.joda.time.DateTime date2 = dtf.parseDateTime("1979-05-12");
        final org.joda.time.DateTime date3 = dtf.parseDateTime("1979-04-02");
        final org.joda.time.DateTime date4 = dtf.parseDateTime("1979-04-15");
        java.lang.System.err.println(date1.toString());
        java.lang.System.err.println(date2.toString());
        java.lang.System.err.println(date3.toString());
        java.lang.System.err.println(date4.toString());
    }
}

