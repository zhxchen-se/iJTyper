/**
 * Helper class for handling a most common subset of ISO 8601 strings
 * (in the following format: "2008-03-01T13:00:00+01:00"). It supports
 * parsing the "Z" timezone, but many other less-used features are
 * missing.
 */
public final class Class_12 {
  /**
   * Transform Calendar to ISO 8601 string.
   */
  public static java.lang.String fromCalendar(final java.util.Calendar calendar) {
    java.util.Date date = java.util.Calendar.getTime();
    java.lang.String formatted = java.text.DateFormat.format(java.util.Date);
    return (java.lang.String.substring(int,int) + ":") + java.lang.String.substring(int);
  }

  /**
   * Get current date and time formatted as ISO 8601 string.
   */
  public static java.lang.String now() {
    return Class_.Class_12.fromCalendar(java.util.Calendar);
  }

  /**
   * Transform ISO 8601 string to Calendar.
   */
  public static java.util.Calendar toCalendar(final java.lang.String iso8601string) throws java.text.ParseException {
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    java.lang.String s = java.lang.String.replace(java.lang.CharSequence,java.lang.CharSequence);
    try {
      s = java.lang.String.substring(int,int) + java.lang.String.substring(int);// to get rid of the ":"

    } catch (java.lang.IndexOutOfBoundsException e) {
      throw new java.text.ParseException("Invalid length", 0);
    }
    java.util.Date date = java.text.DateFormat.parse(java.lang.String);
    java.util.Calendar.setTime(java.util.Date)
    return calendar;
  }

  public class ISO8601DateFormatter {
    private final java.text.DateFormat DATE_FORMAT_1 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    private final java.text.DateFormat DATE_FORMAT_2 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");

    private static final java.lang.String UTC_PLUS = "+";

    private static final java.lang.String UTC_MINUS = "-";

    public java.util.Date toDate(java.lang.String iso8601string) throws java.text.ParseException {
      iso8601string = java.lang.String.trim();
      if (java.lang.String.toUpperCase()###java.lang.String.indexOf(java.lang.String) > 0) {
        iso8601string = java.lang.String.toUpperCase()###java.lang.String.replace(java.lang.CharSequence,java.lang.CharSequence);
      } else if (java.lang.String.indexOf(java.lang.String) > 0) {
        iso8601string = Class_.Class_12$ISO8601DateFormatter.replaceColon(java.lang.String,int);
        iso8601string = Class_.Class_12$ISO8601DateFormatter.appendZeros(java.lang.String,int,java.lang.String);
      } else if (java.lang.String.indexOf(java.lang.String) > 0) {
        iso8601string = Class_.Class_12$ISO8601DateFormatter.replaceColon(java.lang.String,int);
        iso8601string = Class_.Class_12$ISO8601DateFormatter.appendZeros(java.lang.String,int,java.lang.String);
      }
      java.util.Date date = null;
      if (java.lang.String.contains(java.lang.CharSequence))
        date = java.text.DateFormat.parse(java.lang.String);
      else {
        date = java.text.DateFormat.parse(java.lang.String);
      }
      return date;
    }

    public java.lang.String toISO8601String(java.util.Date date) {
      return java.text.DateFormat.format(java.util.Date);
    }

    private java.lang.String replaceColon(java.lang.String sourceStr, int offsetIndex) {
      if (java.lang.String.substring(int)###java.lang.String.contains(java.lang.CharSequence))
        return java.lang.String.substring(int,int) + java.lang.String.substring(int)###java.lang.String.replace(java.lang.CharSequence,java.lang.CharSequence);

      return sourceStr;
    }

    private java.lang.String appendZeros(java.lang.String sourceStr, int offsetIndex, java.lang.String offsetChar) {
      if (((java.lang.String.length() - 1) - java.lang.String.indexOf(java.lang.String,int)) <= 2)
        return sourceStr + "00";

      return sourceStr;
    }
  }
}
