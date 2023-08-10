public class JodaTime13 {
    public static void main(java.lang.String[] args) {

    }

    @org.junit.Test
    public void second() {
        assertEquals("00:00:01", joda_time.JodaTime13.OurDateTimeFormatter.format(1000));
    }

    @org.junit.Test
    public void minute() {
        assertEquals("00:01:00", joda_time.JodaTime13.OurDateTimeFormatter.format(1000 * 60));
    }

    @org.junit.Test
    public void hour() {
        assertEquals("01:00:00", joda_time.JodaTime13.OurDateTimeFormatter.format((1000 * 60) * 60));
    }

    @org.junit.Test
    public void almostMidnight() {
        final int secondsInDay = (60 * 60) * 24;
        assertEquals("23:59:59", joda_time.JodaTime13.OurDateTimeFormatter.format(1000 * (secondsInDay - 1)));
    }

    @org.junit.Test
    public void twoDaysAndAHalf() {
        final int secondsInDay = (60 * 60) * 24;
        assertEquals("12:00:00 and 2 days", joda_time.JodaTime13.OurDateTimeFormatter.format(((1000 * secondsInDay) * 5) / 2));
    }

    public static class OurDateTimeFormatter {
        public OurDateTimeFormatter() {
        }

        private static final org.joda.time.format.PeriodFormatter dateFormat = new org.joda.time.format.PeriodFormatterBuilder().appendDays().appendSuffix(" day", " days").appendSeparator(" ").appendHours().appendSeparator(":").appendMinutes().minimumPrintedDigits(2).appendSeparator(":").appendSeconds().minimumPrintedDigits(2).toFormatter();

        public static java.lang.String format(long millis) {
            return joda_time.JodaTime13.OurDateTimeFormatter.dateFormat.print(new org.joda.time.Period(millis).normalizedStandard());
        }
    }
}

