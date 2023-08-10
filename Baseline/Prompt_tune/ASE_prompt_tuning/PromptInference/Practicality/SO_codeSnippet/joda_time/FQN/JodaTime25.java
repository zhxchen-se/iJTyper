// ID = 8654398
public class JodaTime25 {
    public static int getDaysBetweenTwoDates(final org.joda.time.LocalDateTime oldDate, final org.joda.time.LocalDateTime newDate) {
        java.lang.System.out.println((("--Calculate days between: " + oldDate.toString()) + "->") + newDate);
        org.joda.time.Days days = org.joda.time.Days.daysBetween(new org.joda.time.DateMidnight(oldDate.toDateTime()), new org.joda.time.DateMidnight(newDate.toDateTime()));
        java.lang.System.out.println("----DIFF: " + days.size());
        return days.size();
    }
}

