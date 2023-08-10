public class JodaTime42 {
    public static final int JANUARY = 1;

    public static final int DECEMBER = 12;

    public static final int FIRST_OF_THE_MONTH = 1;

    public final int getLastDayOfMonth(final int month, final int year) {
        int lastDay = 0;
        if ((month >= jodatime.JodaTime42.JANUARY) && (month <= jodatime.JodaTime42.DECEMBER)) {
            org.joda.time.LocalDate aDate = new org.joda.time.LocalDate(year, month, jodatime.JodaTime42.FIRST_OF_THE_MONTH);
            lastDay = aDate.dayOfMonth().getMaximumValue();
        }
        return lastDay;
    }

    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
    }
}

