public class jt2 {
  public static void f1() {
    java.util.Date past = new java.util.Date(110, 5, 20);// June 20th, 2010

    java.util.Date today = new java.util.Date(110, 6, 24);// July 24th

    int days = org.joda.time.Days.daysBetween(org.joda.time.ReadableInstant,org.joda.time.ReadableInstant)###org.joda.time.Days.getDays();// => 34

  }
}
