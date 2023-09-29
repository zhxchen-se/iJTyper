public class JodaTime13 {
  // ID = 4585883
  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
  }

  @org.junit.Test
  public void second() {
    <unknown>.assertEquals(java.lang.String,java.lang.String)
  }

  @org.junit.Test
  public void minute() {
    <unknown>.assertEquals(java.lang.String,java.lang.String)
  }

  @org.junit.Test
  public void hour() {
    <unknown>.assertEquals(java.lang.String,java.lang.String)
  }

  @org.junit.Test
  public void almostMidnight() {
    final int secondsInDay = (60 * 60) * 24;
    <unknown>.assertEquals(java.lang.String,java.lang.String)
  }

  @org.junit.Test
  public void twoDaysAndAHalf() {
    final int secondsInDay = (60 * 60) * 24;
    <unknown>.assertEquals(java.lang.String,java.lang.String)
  }

  public static class OurDateTimeFormatter {
    public OurDateTimeFormatter() {
    }

    private static final org.joda.time.format.PeriodFormatter dateFormat = org.joda.time.format.PeriodFormatterBuilder.appendDays()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendHours()###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendMinutes()###org.joda.time.format.PeriodFormatterBuilder.minimumPrintedDigits(int)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeconds()###org.joda.time.format.PeriodFormatterBuilder.minimumPrintedDigits(int)###org.joda.time.format.PeriodFormatterBuilder.toFormatter();

    public static java.lang.String format(long millis) {
      return org.joda.time.format.PeriodFormatter.print(org.joda.time.ReadablePeriod);
    }
  }
}
