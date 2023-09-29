
public final class Class_12 {

    public static java.lang.String fromCalendar(final java.util.Calendar calendar) {
        java.util.Date date = calendar.getTime();
        java.lang.String formatted = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(date);
        return (formatted.substring(0, 22) + ":") + formatted.substring(22);
    }

    public static java.lang.String now() {
        return Class_.Class_12.fromCalendar(java.util.GregorianCalendar.getInstance());
    }

    public static java.util.Calendar toCalendar(final java.lang.String iso8601string) throws java.text.ParseException {
        java.util.Calendar calendar = java.util.GregorianCalendar.getInstance();
        java.lang.String s = iso8601string.replace("Z", "+00:00");
        try {
            s = s.substring(0, 22) + s.substring(23);// to get rid of the ":"

        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new java.text.ParseException("Invalid length", 0);
        }
        java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
        calendar.setTime(date);
        return calendar;
    }

    public class ISO8601DateFormatter {
        private final java.text.DateFormat DATE_FORMAT_1 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        private final java.text.DateFormat DATE_FORMAT_2 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");

        private static final java.lang.String UTC_PLUS = "+";

        private static final java.lang.String UTC_MINUS = "-";

        public java.util.Date toDate(java.lang.String iso8601string) throws java.text.ParseException {
            iso8601string = iso8601string.trim();
            if (iso8601string.toUpperCase().indexOf("Z") > 0) {
                iso8601string = iso8601string.toUpperCase().replace("Z", "+0000");
            } else if (iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_PLUS) > 0) {
                iso8601string = replaceColon(iso8601string, iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_PLUS));
                iso8601string = appendZeros(iso8601string, iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_PLUS), Class_.Class_12.ISO8601DateFormatter.UTC_PLUS);
            } else if (iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_MINUS) > 0) {
                iso8601string = replaceColon(iso8601string, iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_MINUS));
                iso8601string = appendZeros(iso8601string, iso8601string.indexOf(Class_.Class_12.ISO8601DateFormatter.UTC_MINUS), Class_.Class_12.ISO8601DateFormatter.UTC_MINUS);
            }
            java.util.Date date = null;
            if (iso8601string.contains(":")) {
                date = DATE_FORMAT_1.parse(iso8601string);
            } else {
                date = DATE_FORMAT_2.parse(iso8601string);
            }
            return date;
        }

        public java.lang.String toISO8601String(java.util.Date date) {
            return DATE_FORMAT_1.format(date);
        }

        private java.lang.String replaceColon(java.lang.String sourceStr, int offsetIndex) {
            if (sourceStr.substring(offsetIndex).contains(":")) {
                return sourceStr.substring(0, offsetIndex) + sourceStr.substring(offsetIndex).replace(":", "");
            }
            return sourceStr;
        }

        private java.lang.String appendZeros(java.lang.String sourceStr, int offsetIndex, java.lang.String offsetChar) {
            if (((sourceStr.length() - 1) - sourceStr.indexOf(offsetChar, offsetIndex)) <= 2) {
                return sourceStr + "00";
            }
            return sourceStr;
        }
    }
}

