public class JodaTime24 {
    public static java.lang.String getFormattedDateDifference(org.joda.time.DateTime startDate, org.joda.time.DateTime endDate) {
        org.joda.time.Period p = new org.joda.time.Period(startDate, endDate, org.joda.time.PeriodType.standard().withSecondsRemoved().withMillisRemoved());
        return org.joda.time.format.PeriodFormat.getDefault().print(p);
    }
}

