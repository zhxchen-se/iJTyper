public class JodaTime06 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        jodatime.JodaTime06.printDuration(new org.joda.time.Duration(5000));// Prints "5" => OK

        jodatime.JodaTime06.printDuration(new org.joda.time.Duration(4900));// Prints "4" => need "5"

        jodatime.JodaTime06.printDuration(new org.joda.time.Duration(1000));// Prints "1" => OK

        jodatime.JodaTime06.printDuration(new org.joda.time.Duration(900));// Prints "0" => need "1"

        jodatime.JodaTime06.printDuration(new org.joda.time.Duration(0));// Prints "0" => OK

    }

    static void printDuration(org.joda.time.Duration d) {
        java.lang.System.out.println(d.toPeriod(org.joda.time.PeriodType.time()).toString(new org.joda.time.format.PeriodFormatterBuilder().printZeroAlways().appendSeconds().toFormatter()));
    }
}

