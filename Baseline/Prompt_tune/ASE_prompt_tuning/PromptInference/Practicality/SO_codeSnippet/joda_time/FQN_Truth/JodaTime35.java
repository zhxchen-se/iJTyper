public class JodaTime35 {

    private static final org.joda.time.format.PeriodFormatter DURATION_FORMATTER = new org.joda.time.format.PeriodFormatterBuilder().appendYears().appendSuffix("year", "years").appendSeparator(" ").appendMonths().appendSuffix("month", "months").appendSeparator(" ").appendDays().appendSuffix("day", "days").appendSeparator(" ").appendHours().appendSuffix("hour", "hours").appendSeparator(" ").appendMinutes().appendSuffix("minute", "minutes").appendSeparator(" ").appendSeconds().appendSuffix("second", "seconds").toFormatter();

    public static java.lang.String format(java.sql.Date start) {
        java.lang.StringBuffer result = new java.lang.StringBuffer();
        joda_time.JodaTime35.DURATION_FORMATTER.printTo(result, ((org.joda.time.ReadablePeriod) (new org.joda.time.Period(new org.joda.time.DateTime(start), new org.joda.time.DateTime()))));
        return result.toString();
    }

    public static java.lang.String format(java.sql.Date start, java.sql.Date end) {
        java.lang.StringBuffer result = new java.lang.StringBuffer();
        joda_time.JodaTime35.DURATION_FORMATTER.printTo(result, new org.joda.time.Period(new org.joda.time.DateTime(start), end == null ? new org.joda.time.DateTime() : new org.joda.time.DateTime(end)));
        return result.toString();
    }
}

