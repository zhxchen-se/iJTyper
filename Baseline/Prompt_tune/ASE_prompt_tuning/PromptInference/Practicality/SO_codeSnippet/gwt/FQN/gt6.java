public class gt6 {
    public static void h1() {
        long time = java.lang.System.currentTimeMillis();
        long milisPerYear = new java.math.BigInteger("31536000000").longValue();
        java.lang.String currentYear = java.lang.String.valueOf(((int) (java.lang.Math.floor(time / milisPerYear))) + 1970);
    }
}

