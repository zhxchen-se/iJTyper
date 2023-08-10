public class JodaTime23 {
    org.joda.time.LocalDate getNearestDayOfWeek(org.joda.time.LocalDate ld, java.lang.String day) {
        org.joda.time.LocalDate target = ld.dayOfWeek().setCopy(day);
        if (ld.getDayOfWeek() > org.joda.time.DateTimeConstants.SATURDAY) {
            target = target.plusWeeks(1);
        }
        return target;
    }
}

