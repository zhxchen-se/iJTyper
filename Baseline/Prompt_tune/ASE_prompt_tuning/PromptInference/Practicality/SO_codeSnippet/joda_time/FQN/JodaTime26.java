public class JodaTime26 {
    public static void main(java.lang.String[] args) {
        org.joda.time.Duration duration = new org.joda.time.Duration(1328223198241L - 1326308781131L);
        org.joda.time.Period p2 = new org.joda.time.Period(duration.getMillis());
        java.lang.System.out.println(p2.getDays());// prints 0, should print 22 days

        java.lang.System.out.println(p2.getHours());// prints  531 which is expected.}

    }
}

