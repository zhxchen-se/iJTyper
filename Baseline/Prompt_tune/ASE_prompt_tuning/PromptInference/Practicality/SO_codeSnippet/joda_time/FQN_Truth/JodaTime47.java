public class JodaTime47 {
    public static void main(java.lang.String[] args) {
        final org.joda.time.format.DateTimeFormatter df = org.joda.time.format.DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss 'GMT'Z yyyy");
        final org.joda.time.DateTime dateTime = df.withOffsetParsed().parseDateTime("Mon Aug 24 12:36:46 GMT+1000 2009");
        java.lang.System.out.println("dateTime = " + dateTime);
    }
}

