// ID = 7471775
public class JodaTime19 {
  public static void main(java.lang.String[] args) {
    org.joda.time.Instant now = new org.joda.time.Instant(java.util.Date.getTime());
    org.joda.time.Interval i2 = new org.joda.time.Interval(now, ((org.joda.time.ReadableInstant) (null)));
    org.joda.time.Interval i1 = new org.joda.time.Interval(now, ((org.joda.time.ReadableInstant) (null)));
    boolean overlapping = org.joda.time.base.AbstractInterval.overlaps(org.joda.time.ReadableInterval);
  }
}
