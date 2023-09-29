public class JodaTime27 {
    public static void main(java.lang.String[] args) {

        java.util.ArrayList<org.joda.time.DateTime> monthStarts = new java.util.ArrayList<org.joda.time.DateTime>();
        int firstYear = 0;
        int lastYear = 0;
        for (int y = firstYear; y <= lastYear; y++) {
            for (int m = 1; m <= 12; m++) {
                monthStarts.add(new org.joda.time.DateTime(((y + "-") + m) + "-01"));
            }
        }
    }
}

