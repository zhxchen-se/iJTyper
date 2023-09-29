public class Class_3 {
  private static final java.lang.String SYMBOL_INFINITE = "∞";

  private static final char SYMBOL_MINUS = '-';

  private static final char SYMBOL_ZERO = '0';

  private static final int DECIMAL_LEADING_GROUPS = 10;

  private static final int EXPONENTIAL_INT_THRESHOLD = 1000000000;// After this value switch to exponential notation


  private static final double EXPONENTIAL_DEC_THRESHOLD = 1.0E-4;// Below this value switch to exponential notation


  private java.text.DecimalFormat decimalFormat;

  private java.text.DecimalFormat decimalFormatLong;

  private java.text.DecimalFormat exponentialFormat;

  private char groupSeparator;

  public void NumberFormatter(int decimalPlaces) {
    Class_.Class_3.configureDecimalPlaces(int)
  }

  public void configureDecimalPlaces(int decimalPlaces) {
    if (decimalPlaces <= 0) {
      throw new java.lang.IllegalArgumentException("Invalid decimal places");
    }
    java.text.DecimalFormatSymbols separators = new java.text.DecimalFormatSymbols(java.util.Locale.getDefault());
    java.text.DecimalFormatSymbols.setMinusSign(char)
    java.text.DecimalFormatSymbols.setZeroDigit(char)
    groupSeparator = java.text.DecimalFormatSymbols.getGroupingSeparator();
    java.lang.StringBuilder decimal = new java.lang.StringBuilder();
    java.lang.StringBuilder exponential = new java.lang.StringBuilder("0.");
    for (int i = 0; i < Class_.Class_3.DECIMAL_LEADING_GROUPS; i++) {
      java.lang.StringBuilder.append(java.lang.String)###java.lang.StringBuilder.append(java.lang.String)
    }
    for (int i = 0; i < decimalPlaces; i++) {
      java.lang.StringBuilder.append(java.lang.String)
      java.lang.StringBuilder.append(java.lang.String)
    }
    java.lang.StringBuilder.append(java.lang.String)
    decimalFormat = new java.text.DecimalFormat(java.lang.StringBuilder.toString(), separators);
    decimalFormatLong = new java.text.DecimalFormat(java.lang.StringBuilder.append(java.lang.String)###java.lang.StringBuilder.toString(), separators);
    exponentialFormat = new java.text.DecimalFormat(java.lang.StringBuilder.toString(), separators);
    java.text.DecimalFormat.setRoundingMode(java.math.RoundingMode)
    java.text.DecimalFormat.setRoundingMode(java.math.RoundingMode)
    java.text.DecimalFormat.setRoundingMode(java.math.RoundingMode)
  }

  public java.lang.String format(double value) {
    java.lang.String result;
    if (java.lang.Double.isNaN(double)) {
      result = "";
    } else if (java.lang.Double.isInfinite(double)) {
      result = java.lang.String.valueOf(java.lang.Object);
    } else {
      double absValue = java.lang.Math.abs(double);
      if (absValue >= 1) {
        if (absValue >= Class_.Class_3.EXPONENTIAL_INT_THRESHOLD) {
          value = java.lang.Math.floor(double);
          result = java.text.NumberFormat.format(double);
        } else {
          result = java.text.NumberFormat.format(double);
        }
      } else if ((absValue < 1) && (absValue > 0)) {
        if (absValue >= Class_.Class_3.EXPONENTIAL_DEC_THRESHOLD) {
          result = java.text.NumberFormat.format(double);
          if (java.lang.String.equalsIgnoreCase(java.lang.String)) {
            result = java.text.NumberFormat.format(double);
          }
        } else {
          result = java.text.NumberFormat.format(double);
        }
      } else {
        result = "0";
      }
    }
    return result;
  }

  public java.lang.String formatWithoutGroupSeparators(double value) {
    return Class_.Class_3.removeGroupSeparators(java.lang.String);
  }

  public double parse(java.lang.String value, double defValue) {
    try {
      return java.text.NumberFormat.parse(java.lang.String)###java.lang.Number.doubleValue();
    } catch (java.text.ParseException e) {
      java.lang.Throwable.printStackTrace()
    }
    return defValue;
  }

  private java.lang.String removeGroupSeparators(java.lang.String number) {
    return java.lang.String.replace(java.lang.CharSequence,java.lang.CharSequence);
  }
}
