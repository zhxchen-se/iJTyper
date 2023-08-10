public class JodaTime30 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateTimeZone dtz = org.joda.time.DateTimeZone.forOffsetHours(0);
        org.joda.time.DateTime dt = new org.joda.time.DateTime(dtz);
        java.lang.System.out.println(dt);
        java.lang.System.out.println(dt.toDate());
    }
}

