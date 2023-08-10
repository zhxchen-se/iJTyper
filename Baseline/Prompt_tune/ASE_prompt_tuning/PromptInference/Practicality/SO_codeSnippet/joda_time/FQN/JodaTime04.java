public class JodaTime04 {
    private org.joda.time.ReadableInstant[] startTime;

    private org.joda.time.ReadableInstant[] endTime;

    public java.lang.String foobar(int dayIndex) {
        org.joda.time.Period p = new org.joda.time.Period(this.startTime[dayIndex], this.endTime[dayIndex]);
        long hours = p.getHours();
        long minutes = p.getMinutes();
        java.lang.String format = java.lang.String.format("%%0%dd", 2);// Ensures that the minutes will always display as two digits.

        return (java.lang.Long.toString(hours) + ":") + java.lang.String.format(format, minutes);
    }
}

