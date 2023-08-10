public class JodaTime16 {
  public static void main(java.lang.String[] args) {
    org.joda.time.DateTime d1 = new org.joda.time.DateTime(2011, 6, 17, 13, 13, 5, 0);
    org.joda.time.DateTime d2 = new org.joda.time.DateTime(2011, 6, 17, 10, 17, 3, 0);
    org.joda.time.Period negativePeriod = new org.joda.time.Period(d1, d2);
    org.joda.time.Period positivePeriod = new org.joda.time.Period(d2, d1);
    org.joda.time.format.PeriodFormatter pf = org.joda.time.format.PeriodFormatterBuilder.minimumPrintedDigits(int)###org.joda.time.format.PeriodFormatterBuilder.appendHours()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.rejectSignedValues(boolean)###org.joda.time.format.PeriodFormatterBuilder.appendMinutes()###org.joda.time.format.PeriodFormatterBuilder.appendSuffix(java.lang.String)###org.joda.time.format.PeriodFormatterBuilder.appendSeconds()###org.joda.time.format.PeriodFormatterBuilder.toFormatter();
    java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
    java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
  }
}
