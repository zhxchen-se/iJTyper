
public class Class_10 {
    public static final java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(java.util.Locale.US);

    public static final void main(java.lang.String[] tryCount_inParamIdx0) {
        int testCount;

        try {
            testCount = java.lang.Integer.parseInt(tryCount_inParamIdx0[0]);
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.NumberFormatException x) {
            throw new java.lang.IllegalArgumentException("Missing or invalid command line parameter: The number of testCount for each test. " + x);
        }

        int[] intArray = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
        long lStart = java.lang.System.nanoTime();
        for (int i = 0; i < testCount; i++) {
            Class_.Class_10.testIterator(intArray);
        }
        long lADuration = Class_.Class_10.outputGetNanoDuration("A", lStart);
        lStart = java.lang.System.nanoTime();
        for (int i = 0; i < testCount; i++) {
            Class_.Class_10.testFor(intArray);
        }
        long lBDuration = Class_.Class_10.outputGetNanoDuration("B", lStart);
        Class_.Class_10.outputGetABTestNanoDifference(lADuration, lBDuration, "A", "B");
    }

    private static final void testIterator(int[] int_array) {
        int total = 0;
        for (int i = 0; i < int_array.length; i++) {
            total += int_array[i];
        }
    }

    private static final void testFor(int[] int_array) {
        int total = 0;
        for (int i : int_array) {
            total += i;
        }
    }

    public static final long outputGetNanoDuration(java.lang.String s_testName, long l_nanoStart) {
        long lDuration = java.lang.System.nanoTime() - l_nanoStart;
        java.lang.System.out.println(((("Test " + s_testName) + ": ") + Class_.Class_10.nf.format(lDuration)) + " nanoseconds");
        return lDuration;
    }

    public static final long outputGetABTestNanoDifference(long l_aDuration, long l_bDuration, java.lang.String s_aTestName, java.lang.String s_bTestName) {
        long lDiff = -1;
        double dPct = -1.0;
        java.lang.String sFaster = null;
        if (l_aDuration > l_bDuration) {
            lDiff = l_aDuration - l_bDuration;
            dPct = 100.0 - (((l_bDuration * 100.0) / l_aDuration) + 0.5);
            sFaster = "B";
        } else {
            lDiff = l_bDuration - l_aDuration;
            dPct = 100.0 - (((l_aDuration * 100.0) / l_bDuration) + 0.5);
            sFaster = "A";
        }
        java.lang.System.out.println(((((sFaster + " faster by ") + Class_.Class_10.nf.format(lDiff)) + " nanoseconds (") + dPct) + "% faster)");
        return lDiff;
    }
}

