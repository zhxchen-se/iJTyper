public class JodaTime23 {
  org.joda.time.LocalDate getNearestDayOfWeek(org.joda.time.LocalDate ld, java.lang.String day) {
    org.joda.time.LocalDate target = org.joda.time.LocalDate.dayOfWeek()###org.joda.time.LocalDate$Property.setCopy(java.lang.String);
    if (org.joda.time.LocalDate.getDayOfWeek() > org.joda.time.DateTimeConstants.SATURDAY) {
      target = org.joda.time.LocalDate.plusWeeks(int);
    }
    return target;
  }
}
