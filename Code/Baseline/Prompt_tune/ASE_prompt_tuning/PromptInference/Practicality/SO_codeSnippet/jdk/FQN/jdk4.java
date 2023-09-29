public class jdk4 {
    public static void h1(java.lang.String oldDate, java.lang.String format) throws java.text.ParseException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        java.util.Date dt = sdf.parse(oldDate);
        long epoch = dt.getTime();
    }
}

