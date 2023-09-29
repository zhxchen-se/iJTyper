public class JodaTime08 {
  public boolean testIfJodaTimePeriodsHandlesPeriodTypesOtherThanMinutesAndHours() {
    long twentyDaysInMillis = java.util.concurrent.TimeUnit.convert(long,java.util.concurrent.TimeUnit);
    org.joda.time.Period twoWeeks = new org.joda.time.Period(twentyDaysInMillis, org.joda.time.PeriodType.weeks());
    return 2 == org.joda.time.Period.getWeeks() ? true : false;
  }
}
