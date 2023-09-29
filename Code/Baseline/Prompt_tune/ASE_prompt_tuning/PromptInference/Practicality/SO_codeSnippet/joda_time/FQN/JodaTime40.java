public class JodaTime40 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        @java.lang.SuppressWarnings("deprecation")
        java.util.Date past = new java.util.Date(110, 5, 20);// June 20th, 2010

        java.util.Date today = new java.util.Date(110, 6, 24);// July 24th

        int days = org.joda.time.Days.daysBetween(new org.joda.time.DateTime(past), new org.joda.time.DateTime(today)).getDays();// => 34

    }
}

