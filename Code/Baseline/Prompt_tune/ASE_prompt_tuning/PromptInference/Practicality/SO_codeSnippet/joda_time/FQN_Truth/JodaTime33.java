public class JodaTime33 {
    public static void main(java.lang.String[] args) {

        org.joda.time.format.PeriodFormatter hoursMinutesSeconds = new org.joda.time.format.PeriodFormatterBuilder().appendHours().appendSuffix(" hour", " hours").appendSeparator(", ", " and ").appendMinutes().appendSuffix(" minute", " minutes").appendSeparator(" and ").printZeroRarelyFirst().appendSeconds().appendSuffix(" second", " seconds").toFormatter();
        java.lang.System.out.println(hoursMinutesSeconds.print(new org.joda.time.Period(0, 0, 0, 500)));
    }
}

