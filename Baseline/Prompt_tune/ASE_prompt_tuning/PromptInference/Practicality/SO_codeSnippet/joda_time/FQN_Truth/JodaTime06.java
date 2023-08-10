public class JodaTime06 {
    public static void main(java.lang.String[] args) {

        joda_time.JodaTime06.printDuration(new org.joda.time.Duration(5000));
        joda_time.JodaTime06.printDuration(new org.joda.time.Duration(4900));
        joda_time.JodaTime06.printDuration(new org.joda.time.Duration(1000));
        joda_time.JodaTime06.printDuration(new org.joda.time.Duration(900));
        joda_time.JodaTime06.printDuration(new org.joda.time.Duration(0));
    }

    static void printDuration(org.joda.time.Duration d) {
        java.lang.System.out.println(d.toPeriod(org.joda.time.PeriodType.time()).toString(new org.joda.time.format.PeriodFormatterBuilder().printZeroAlways().appendSeconds().toFormatter()));
    }
}

