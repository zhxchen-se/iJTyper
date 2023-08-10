public class JodaTime14 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        java.lang.String start = "Sunday, January 09, 2011 6:15:00 PM";
        org.joda.time.format.DateTimeFormatter parser1 = org.joda.time.format.DateTimeFormat.forPattern("EEEE, MMMM dd, yyyy H:mm:ss aa");
        org.joda.time.DateTime startTime = parser1.parseDateTime(start);
    }
}

