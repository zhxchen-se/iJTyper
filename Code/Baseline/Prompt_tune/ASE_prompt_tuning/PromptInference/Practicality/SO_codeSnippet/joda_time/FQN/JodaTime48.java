public class JodaTime48 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
    }

    private final org.joda.time.DateTimeUtils.MillisProvider millisProvider;

    private final org.joda.time.DateTime someDate;

    public JodaTime48(org.joda.time.DateTimeUtils.MillisProvider millisProvider, org.joda.time.DateTime someDate) {
        this.millisProvider = millisProvider;
        this.someDate = someDate;
    }

    public boolean isAvailable() {
        long now = millisProvider.getMillis();
        return someDate.isBefore(now);
    }
}

