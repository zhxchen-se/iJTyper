package java.joda_time;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class jt9 {
    public static void h1() {
        LocalDate today = LocalDate.now();
        ZonedDateTime zdt = today.atStartOfDay().atZone(ZoneId.systemDefault());
        OffsetDateTime odt = zdt.toOffsetDateTime();
    }
}
