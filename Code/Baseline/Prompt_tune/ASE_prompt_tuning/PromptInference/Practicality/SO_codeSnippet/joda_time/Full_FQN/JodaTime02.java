public class JodaTime02 {
  public static void main(java.lang.String[] args) {
    org.joda.time.DateMidnight today = new org.joda.time.DateMidnight(2009, 2, 24);
    org.joda.time.DateTimeZone zone = org.joda.time.base.AbstractInstant.getZone();
    org.joda.time.DateTime previousTransition = new org.joda.time.DateTime(org.joda.time.DateTimeZone.previousTransition(long));
    java.io.PrintStream.println(java.lang.Object)
    org.joda.time.DateTime nextTransition = new org.joda.time.DateTime(org.joda.time.DateTimeZone.nextTransition(long));
    java.io.PrintStream.println(java.lang.Object)
  }
}
