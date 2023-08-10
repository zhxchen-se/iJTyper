public class JodaTime41 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateTime dt4 = new org.joda.time.DateTime("2017-01-01T10:52:07.656-10:00");
        java.lang.System.out.println("Given Date:" + dt4);
        org.joda.time.format.DateTimeFormatter fmt = org.joda.time.format.DateTimeFormat.forPattern("MM/DD/YYYY");
        java.lang.System.out.println("Given Date After Date format: " + fmt.print(dt4));
        org.joda.time.DateTime previousDay = dt4.minusDays(1);
        java.lang.System.out.println("Previous Day: " + previousDay);
        java.lang.System.out.println("Previous Date After Date format: " + fmt.print(previousDay));
    }
}

