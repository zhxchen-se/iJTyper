public class JodaTime04 {
  private org.joda.time.ReadableInstant[] startTime;

  private org.joda.time.ReadableInstant[] endTime;

  public java.lang.String foobar(int dayIndex) {
    org.joda.time.Period p = new org.joda.time.Period(this.startTime[dayIndex], this.endTime[dayIndex]);
    long hours = org.joda.time.Period.getHours();
    long minutes = org.joda.time.Period.getMinutes();
    java.lang.String format = java.lang.String.format(java.lang.String,java.lang.Object[]);// Ensures that the minutes will always display as two digits.

    return (java.lang.Long.toString(long) + ":") + java.lang.String.format(java.lang.String,java.lang.Object[]);
  }
}
