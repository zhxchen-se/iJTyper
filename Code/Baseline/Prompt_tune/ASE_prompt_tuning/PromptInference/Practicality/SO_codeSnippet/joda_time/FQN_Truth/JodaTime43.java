public class JodaTime43 {
    public static void main(java.lang.String[] args) {

        org.joda.time.format.DateTimeParser[] parsers = new org.joda.time.format.DateTimeParser[]{ org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH").getParser(), org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").getParser() };
        org.joda.time.format.DateTimeFormatter formatter = new org.joda.time.format.DateTimeFormatterBuilder().append(null, parsers).toFormatter();
        org.joda.time.DateTime date1 = formatter.parseDateTime("2010-01-01");
        org.joda.time.DateTime date2 = formatter.parseDateTime("2010-01-01 01");
    }
}

