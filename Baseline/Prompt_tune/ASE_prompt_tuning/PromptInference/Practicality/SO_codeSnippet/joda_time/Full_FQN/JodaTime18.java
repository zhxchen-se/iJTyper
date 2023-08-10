// ID = 7423886
public class JodaTime18 {
  // default our time zone to the machine local one.
  private static final org.joda.time.DateTimeZone LOCAL_TZ = org.joda.time.DateTimeZone.getDefault();

  // format of date (i.e., timestamp) is yyyy-MM-dd HH:mm:ss.S
  private static final org.joda.time.format.DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLIS_FORMATTER = org.joda.time.format.DateTimeFormatterBuilder.appendYear(int,int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendMonthOfYear(int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendDayOfMonth(int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendHourOfDay(int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendMinuteOfDay(int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendSecondOfDay(int)###org.joda.time.format.DateTimeFormatterBuilder.appendLiteral(char)###org.joda.time.format.DateTimeFormatterBuilder.appendMillisOfDay(int)###org.joda.time.format.DateTimeFormatterBuilder.toFormatter()###org.joda.time.format.DateTimeFormatter.withZone(org.joda.time.DateTimeZone);
}
