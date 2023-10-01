public class JodaTime39 {
    public static void main(java.lang.String[] args) {
        org.joda.time.DateTime d1 = new org.joda.time.DateTime();
        org.joda.time.DateTime d2 = new org.joda.time.DateTime();
        long diffInMillis = d2.getMillis() - d1.getMillis();
    }
}

