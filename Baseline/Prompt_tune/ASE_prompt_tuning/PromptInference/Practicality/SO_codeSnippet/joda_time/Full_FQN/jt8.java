public class jt8 {
  public static int getFirstDayOfWeek() {
    return ((java.util.Calendar.getInstance()###java.util.Calendar.getFirstDayOfWeek() + 5) % 7) + 1;
  }
}
