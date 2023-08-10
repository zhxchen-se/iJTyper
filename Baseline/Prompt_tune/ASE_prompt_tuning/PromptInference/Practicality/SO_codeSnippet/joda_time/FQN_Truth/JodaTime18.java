public class JodaTime18 {
    private static final org.joda.time.DateTimeZone LOCAL_TZ = org.joda.time.DateTimeZone.getDefault();

    private static final org.joda.time.format.DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLIS_FORMATTER = new org.joda.time.format.DateTimeFormatterBuilder().appendYear(4, 4).appendLiteral('-').appendMonthOfYear(1).appendLiteral('-').appendDayOfMonth(1).appendLiteral(' ').appendHourOfDay(2).appendLiteral(':').appendMinuteOfDay(1).appendLiteral(':').appendSecondOfDay(1).appendLiteral('.').appendMillisOfDay(1).toFormatter().withZone(joda_time.JodaTime18.LOCAL_TZ);
}

