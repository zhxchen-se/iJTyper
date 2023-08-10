public class JodaTime34 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        java.util.Locale.setDefault(java.util.Locale.GERMAN);
        final org.joda.time.format.PeriodFormatter periodFormatter = org.joda.time.format.PeriodFormat.wordBased(java.util.Locale.ENGLISH);
        final org.joda.time.Period period = new org.joda.time.Period(6, 5, 4, 3);
        final java.lang.String s = period.toString(periodFormatter);
        java.lang.System.out.println("s = " + s);
    }
}

