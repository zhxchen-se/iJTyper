public class Class_17 {
    public static void main(java.lang.String[] arg) {
        try {
            java.text.SimpleDateFormat sourceDateFormat = new java.text.SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
            java.util.Date date = sourceDateFormat.parse("2011-01-18 00:00:00.0");
            java.text.SimpleDateFormat targetDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.lang.System.out.println(targetDateFormat.format(date));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        java.lang.String date = "2011-01-18 00:00:00.0";
        java.time.temporal.TemporalAccessor temporal = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S").parse(date);

        java.lang.String output = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd").format(temporal);
    }
}

