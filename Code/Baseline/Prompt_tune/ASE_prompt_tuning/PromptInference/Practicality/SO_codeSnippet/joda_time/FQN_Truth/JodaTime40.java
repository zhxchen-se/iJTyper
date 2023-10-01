public class JodaTime40 {
    public static void main(java.lang.String[] args) {

        @java.lang.SuppressWarnings("deprecation")
        java.sql.Date past = new java.sql.Date(110, 5, 20);
        java.sql.Date today = new java.sql.Date(110, 6, 24);
        int days = org.joda.time.Days.daysBetween(new org.joda.time.DateTime(past), new org.joda.time.DateTime(today)).getDays();
    }
}

