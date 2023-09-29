public class JodaTime03 {
  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
  }

  public static java.lang.String formatDuration(long start, long end) {
    org.joda.time.Interval interval = new org.joda.time.Interval(start, end);
    return jodatime.JodaTime03.getPeriodFormatter()###org.joda.time.format.PeriodFormatter.print(org.joda.time.ReadablePeriod)###java.lang.String.trim();
  }

  private static org.joda.time.format.PeriodFormatter getPeriodFormatter() {
    org.joda.time.format.PeriodFormatter pf = org.joda.time.format.PeriodFormatterBuilder.printZeroRarelyFirst()###org.joda.time.format.PeriodFormatterBuilder.appendYears()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendMonths()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendDays()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendHours()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendMinutes()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeconds()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String,java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.toFormatter();
    return pf;
  }
}
