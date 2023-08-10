public class JodaTime44 {
    public static void main(java.lang.String[] args) {
        org.joda.time.format.PeriodFormatter daysHoursMinutes = new org.joda.time.format.PeriodFormatterBuilder().appendDays().appendSuffix(" day", " days").appendSeparator(" and ").appendMinutes().appendSuffix(" minute", " minutes").appendSeparator(" and ").appendSeconds().appendSuffix(" second", " seconds").toFormatter();
        org.joda.time.Period period = new org.joda.time.Period(72, 24, 12, 0);
        java.lang.System.out.println(daysHoursMinutes.print(period));
        java.lang.System.out.println(daysHoursMinutes.print(period.normalizedStandard()));
    }
}

