package jodatime;
//ID = 8321537
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class JodaTime23 {

	LocalDate getNearestDayOfWeek(LocalDate ld, String day) {
        LocalDate target = ld.dayOfWeek().setCopy(day);
        if (ld.getDayOfWeek() > DateTimeConstants.SATURDAY) {
            target = target.plusWeeks(1);
        }
        return target;
    }
}
