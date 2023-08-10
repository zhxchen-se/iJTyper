// ID = 9543331
public class JodaTime31 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        org.joda.time.DateTime s = new org.joda.time.DateTime(java.lang.Long.parseLong("1330573027000"));// 2012-02-29

        org.joda.time.DateTime e = new org.joda.time.DateTime(java.lang.Long.parseLong("1331005027000"));// 2012-03-05

        org.joda.time.Weeks weeks = org.joda.time.Weeks.weeksBetween(s, e).plus(1);
        org.joda.time.DateTime start = new org.joda.time.DateTime(java.lang.Long.parseLong("1330659427000"));
        org.joda.time.DateTime end = new org.joda.time.DateTime(java.lang.Long.parseLong("1530659427000"));
        org.joda.time.DateTime finalStart = start.dayOfWeek().withMinimumValue();
        org.joda.time.DateTime finalEnd = end.dayOfWeek().withMaximumValue();
    }
}

