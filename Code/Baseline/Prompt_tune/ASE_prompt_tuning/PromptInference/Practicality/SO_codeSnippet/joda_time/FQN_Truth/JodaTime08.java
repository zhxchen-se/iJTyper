public class JodaTime08 {
    public boolean testIfJodaTimePeriodsHandlesPeriodTypesOtherThanMinutesAndHours() {
        long twentyDaysInMillis = java.util.concurrent.TimeUnit.MILLISECONDS.convert(20, java.util.concurrent.TimeUnit.DAYS);
        org.joda.time.Period twoWeeks = new org.joda.time.Period(twentyDaysInMillis, org.joda.time.PeriodType.weeks());
        return 2 == twoWeeks.getWeeks() ? true : false;
    }
}

