public class jdk7 {
    public static void h1() throws java.text.ParseException {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        formatter.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        java.util.Date date = formatter.parse("");
    }
}

