public class JodaTime24 {
  public static java.lang.String getFormattedDateDifference(org.joda.time.DateTime startDate, org.joda.time.DateTime endDate) {
    org.joda.time.Period p = new org.joda.time.Period(startDate, endDate, org.joda.time.PeriodType.standard()###org.joda.time.PeriodType.withSecondsRemoved()###org.joda.time.PeriodType.withMillisRemoved());
    return org.joda.time.format.PeriodFormat.getDefault()###org.joda.time.format.PeriodFormatter.print(org.joda.time.ReadablePeriod);
  }
}
