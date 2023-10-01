public class JodaTime36 {
    public static void main(java.lang.String[] args) {

        org.joda.time.format.PeriodFormatter pf = new org.joda.time.format.PeriodFormatterBuilder().append(org.joda.time.format.ISOPeriodFormat.standard()).toFormatter();
        org.joda.time.Period period = pf.parsePeriod("PT01H00M");
    }
}

