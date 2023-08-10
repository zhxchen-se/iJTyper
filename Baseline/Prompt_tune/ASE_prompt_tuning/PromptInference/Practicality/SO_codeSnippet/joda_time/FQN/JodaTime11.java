public class JodaTime11 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss z yyyy");
        java.lang.System.out.println(dtf.parseDateTime("Fri Nov 11 12:13:14 JST 2010"));
        try {
            java.lang.System.out.println(new java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse("Fri Nov 11 12:13:14 JST 2010"));
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

