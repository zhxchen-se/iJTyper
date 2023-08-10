public class JodaTime03 {
    public static void main(java.lang.String[] args) {

    }

    public static java.lang.String formatDuration(long start, long end) {
        org.joda.time.Interval interval = new org.joda.time.Interval(start, end);
        return joda_time.JodaTime03.getPeriodFormatter().print(interval.toPeriod()).trim();
    }

    private static org.joda.time.format.PeriodFormatter getPeriodFormatter() {
        org.joda.time.format.PeriodFormatter pf = new org.joda.time.format.PeriodFormatterBuilder().printZeroRarelyFirst().appendYears().appendSuffix("y ", "y ").appendMonths().appendSuffix("m", "m ").appendDays().appendSuffix("d ", "d ").appendHours().appendSuffix("h ", "h ").appendMinutes().appendSuffix("m ", "m ").appendSeconds().appendSuffix("s ", "s ").toFormatter();
        return pf;
    }
}

