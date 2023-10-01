public class JodaTime38 {
    public static void main(java.lang.String[] args) {

        java.lang.String dateTime = "11/15/2013 08:00:00";
        org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        org.joda.time.DateTime jodatime = dtf.parseDateTime(dateTime);
        org.joda.time.format.DateTimeFormatter dtfOut = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy");
        java.lang.System.out.println(dtfOut.print(jodatime));
    }
}

