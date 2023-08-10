public class jdk8 {
    public static void h1() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.00", new java.text.DecimalFormatSymbols(java.util.Locale.FRANCE));
        java.lang.System.out.println(df.format(""));
    }
}

