public class JodaTime50 {
    public static void main(java.lang.String[] args) {

    }

    public static int daysOfMonth(int year, int month) {
        org.joda.time.DateTime dateTime = new org.joda.time.DateTime(year, month, 14, 12, 0, 0, 00);
        return dateTime.dayOfMonth().getMaximumValue();
    }
}

