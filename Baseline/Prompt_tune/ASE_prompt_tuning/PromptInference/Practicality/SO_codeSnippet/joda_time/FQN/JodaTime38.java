public class JodaTime38 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        java.lang.String dateTime = "11/15/2013 08:00:00";
        // Format for input
        org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        // Parsing the date
        org.joda.time.DateTime jodatime = dtf.parseDateTime(dateTime);
        // Format for output
        org.joda.time.format.DateTimeFormatter dtfOut = org.joda.time.format.DateTimeFormat.forPattern("MM/dd/yyyy");
        // Printing the date
        java.lang.System.out.println(dtfOut.print(jodatime));
    }
}

