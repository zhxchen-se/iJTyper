public class jt12 {
    public static void h1(org.joda.time.DateTime end, org.joda.time.DateTime start) {
        org.joda.time.Days.daysBetween(new org.joda.time.LocalDate(start), new org.joda.time.LocalDate(end)).getDays();
    }
}

