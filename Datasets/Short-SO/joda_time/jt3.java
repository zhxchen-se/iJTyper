package java.joda_time;

import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class jt3 {
    public static void f1(){
        LocalDateTime java8LocalDateTime = LocalDateTime.now();
        ZonedDateTime java8ZonedDateTime = java8LocalDateTime.atZone(ZoneId.systemDefault());
        Instant java8Instant = java8ZonedDateTime.toInstant();
    }



}
