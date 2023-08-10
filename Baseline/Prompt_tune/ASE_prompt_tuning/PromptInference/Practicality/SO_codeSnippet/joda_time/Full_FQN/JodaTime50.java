public class JodaTime50 {
  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
  }

  // days of a month
  public static int daysOfMonth(int year, int month) {
    org.joda.time.DateTime dateTime = new org.joda.time.DateTime(year, month, 14, 12, 0, 0, 00);
    return org.joda.time.DateTime.dayOfMonth()###org.joda.time.field.AbstractReadableInstantFieldProperty.getMaximumValue();
  }
}
