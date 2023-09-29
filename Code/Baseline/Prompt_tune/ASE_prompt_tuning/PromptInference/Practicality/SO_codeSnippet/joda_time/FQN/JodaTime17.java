public class JodaTime17 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SSS z");
        java.lang.String dts = dtf.print(java.lang.System.currentTimeMillis());
        java.lang.System.out.println(dts);
        org.joda.time.DateTime dt = dtf.parseDateTime(dts);
    }
}

