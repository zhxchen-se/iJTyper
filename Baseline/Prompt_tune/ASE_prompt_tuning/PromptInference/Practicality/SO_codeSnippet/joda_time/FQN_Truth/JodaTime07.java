public class JodaTime07 {
    public static void main(java.lang.String[] args) {

        java.text.DateFormat formatter = new java.text.SimpleDateFormat("mm/dd/yyyy");
        java.util.Date someDate = new java.util.Date();
        java.util.Date today = java.util.Calendar.getInstance().getTime();
        try {
            someDate = formatter.parse("06/22/2010");
        } catch (java.text.ParseException pe) {
            java.lang.System.out.println("Parser Exception");
        }
        int days = org.joda.time.Days.daysBetween(new org.joda.time.DateTime(someDate), new org.joda.time.DateTime(today)).getDays();
        java.lang.System.out.println(((((" Days Between " + someDate) + " : ") + today) + " - ") + days);
    }
}

