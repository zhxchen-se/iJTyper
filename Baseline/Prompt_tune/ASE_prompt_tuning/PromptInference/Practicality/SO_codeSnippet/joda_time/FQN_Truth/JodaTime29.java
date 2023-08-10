public class JodaTime29 {
    private static final int FIELD_COUNT = 10;

    public static void main(java.lang.String[] args) {
    }

    public org.joda.time.DateTime parseDateTime(final java.lang.String text) {
        org.joda.time.format.DateTimeFormatter[] formatters = new org.joda.time.format.DateTimeFormatter[20];
        if (text.isEmpty()) {
            return null;
        }
        int field = 0;
        org.joda.time.DateTime dateTime = null;
        java.lang.IllegalArgumentException exception = null;
        for (; field < joda_time.JodaTime29.FIELD_COUNT; ++field) {
            if (null != formatters[field]) {
                try {
                    dateTime = formatters[field].parseDateTime(text);
                    break;
                } catch (final java.lang.IllegalArgumentException e) {
                    exception = (null != exception) ? exception : e;
                }
            }
        }
        if (dateTime == null) {
            throw exception;
        }
        return dateTime;
    }
}

