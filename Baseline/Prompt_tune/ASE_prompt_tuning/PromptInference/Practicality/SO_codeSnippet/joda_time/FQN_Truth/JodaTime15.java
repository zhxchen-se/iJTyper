public class JodaTime15 {
    public static void main(java.lang.String[] args) {
        org.joda.time.MutableDateTime now = new org.joda.time.MutableDateTime();
        now.setHourOfDay(2);
        now.setMinuteOfHour(0);
        now.setSecondOfMinute(0);
        now.setMillisOfSecond(0);
        org.joda.time.DateTime myDate = now.toDateTime();
    }
}

