public class JodaTime16 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateTime d1 = new org.joda.time.DateTime(2011, 6, 17, 13, 13, 5, 0);
        org.joda.time.DateTime d2 = new org.joda.time.DateTime(2011, 6, 17, 10, 17, 3, 0);
        org.joda.time.Period negativePeriod = new org.joda.time.Period(d1, d2);
        org.joda.time.Period positivePeriod = new org.joda.time.Period(d2, d1);
        org.joda.time.format.PeriodFormatter pf = // Does this do anything?
        new org.joda.time.format.PeriodFormatterBuilder().minimumPrintedDigits(2).appendHours().appendSuffix(":").rejectSignedValues(true).appendMinutes().appendSuffix(":").appendSeconds().toFormatter();
        java.lang.System.out.printf("Negative Period: %s\n", pf.print(negativePeriod));
        java.lang.System.out.printf("Positive Period: %s\n", pf.print(positivePeriod));
    }
}

