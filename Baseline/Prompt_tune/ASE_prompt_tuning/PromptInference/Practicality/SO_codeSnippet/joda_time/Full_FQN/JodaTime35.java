public class JodaTime35 {
  // TODO Auto-generated method stub
  private static final org.joda.time.format.PeriodFormatter DURATION_FORMATTER = org.joda.time.format.PeriodFormatterBuilder.appendYears()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendMonths()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendDays()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendHours()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendMinutes()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeparator(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeconds()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.toFormatter();

  public static java.lang.String format(java.util.Date start) {
    java.lang.StringBuffer result = new java.lang.StringBuffer();
    org.joda.time.format.PeriodFormatter.printTo(java.lang.StringBuffer,org.joda.time.ReadablePeriod)
    return java.lang.StringBuffer.toString();
  }

  public static java.lang.String format(java.util.Date start, java.util.Date end) {
    java.lang.StringBuffer result = new java.lang.StringBuffer();
    org.joda.time.format.PeriodFormatter.printTo(java.lang.StringBuffer,org.joda.time.ReadablePeriod)
    return java.lang.StringBuffer.toString();
  }
}
