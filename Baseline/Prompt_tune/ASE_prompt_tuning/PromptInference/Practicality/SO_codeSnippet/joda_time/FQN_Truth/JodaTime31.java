public class JodaTime31 {
    public static void main(java.lang.String[] args) {

        org.joda.time.DateTime s = new org.joda.time.DateTime(java.lang.Long.parseLong("1330573027000"));
        org.joda.time.DateTime e = new org.joda.time.DateTime(java.lang.Long.parseLong("1331005027000"));
        org.joda.time.Weeks weeks = org.joda.time.Weeks.weeksBetween(s, e).plus(1);
        org.joda.time.DateTime start = new org.joda.time.DateTime(java.lang.Long.parseLong("1330659427000"));
        org.joda.time.DateTime end = new org.joda.time.DateTime(java.lang.Long.parseLong("1530659427000"));
        org.joda.time.DateTime finalStart = start.dayOfWeek().withMinimumValue();
        org.joda.time.DateTime finalEnd = end.dayOfWeek().withMaximumValue();
    }
}

