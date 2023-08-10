public class Class_3 {
    private static final java.lang.String SYMBOL_INFINITE = "∞";

    private static final char SYMBOL_MINUS = '-';

    private static final char SYMBOL_ZERO = '0';

    private static final int DECIMAL_LEADING_GROUPS = 10;

    private static final int EXPONENTIAL_INT_THRESHOLD = 1000000000;


    private static final double EXPONENTIAL_DEC_THRESHOLD = 1.0E-4;


    private java.text.DecimalFormat decimalFormat;

    private java.text.DecimalFormat decimalFormatLong;

    private java.text.DecimalFormat exponentialFormat;

    private char groupSeparator;

    public void NumberFormatter(int decimalPlaces) {
        configureDecimalPlaces(decimalPlaces);
    }

    public void configureDecimalPlaces(int decimalPlaces) {
        if (decimalPlaces <= 0) {
            throw new java.lang.IllegalArgumentException("Invalid decimal places");
        }
        java.text.DecimalFormatSymbols separators = new java.text.DecimalFormatSymbols(java.util.Locale.getDefault());
        separators.setMinusSign(Class_.Class_3.SYMBOL_MINUS);
        separators.setZeroDigit(Class_.Class_3.SYMBOL_ZERO);
        groupSeparator = separators.getGroupingSeparator();
        java.lang.StringBuilder decimal = new java.lang.StringBuilder();
        java.lang.StringBuilder exponential = new java.lang.StringBuilder("0.");
        for (int i = 0; i < Class_.Class_3.DECIMAL_LEADING_GROUPS; i++) {
            decimal.append("###").append(i == (Class_.Class_3.DECIMAL_LEADING_GROUPS - 1) ? "." : ",");
        }
        for (int i = 0; i < decimalPlaces; i++) {
            decimal.append("#");
            exponential.append("0");
        }
        exponential.append("E0");
        decimalFormat = new java.text.DecimalFormat(decimal.toString(), separators);
        decimalFormatLong = new java.text.DecimalFormat(decimal.append("####").toString(), separators);
        exponentialFormat = new java.text.DecimalFormat(exponential.toString(), separators);
        decimalFormat.setRoundingMode(java.math.RoundingMode.HALF_UP);
        decimalFormatLong.setRoundingMode(java.math.RoundingMode.HALF_UP);
        exponentialFormat.setRoundingMode(java.math.RoundingMode.HALF_UP);
    }

    public java.lang.String format(double value) {
        java.lang.String result;
        if (java.lang.Double.isNaN(value)) {
            result = "";
        } else if (java.lang.Double.isInfinite(value)) {
            result = java.lang.String.valueOf(Class_.Class_3.SYMBOL_INFINITE);
        } else {
            double absValue = java.lang.Math.abs(value);
            if (absValue >= 1) {
                if (absValue >= Class_.Class_3.EXPONENTIAL_INT_THRESHOLD) {
                    value = java.lang.Math.floor(value);
                    result = exponentialFormat.format(value);
                } else {
                    result = decimalFormat.format(value);
                }
            } else if ((absValue < 1) && (absValue > 0)) {
                if (absValue >= Class_.Class_3.EXPONENTIAL_DEC_THRESHOLD) {
                    result = decimalFormat.format(value);
                    if (result.equalsIgnoreCase("0")) {
                        result = decimalFormatLong.format(value);
                    }
                } else {
                    result = exponentialFormat.format(value);
                }
            } else {
                result = "0";
            }
        }
        return result;
    }

    public java.lang.String formatWithoutGroupSeparators(double value) {
        return removeGroupSeparators(format(value));
    }

    public double parse(java.lang.String value, double defValue) {
        try {
            return decimalFormat.parse(value).doubleValue();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return defValue;
    }

    private java.lang.String removeGroupSeparators(java.lang.String number) {
        return number.replace(java.lang.String.valueOf(groupSeparator), "");
    }
}

