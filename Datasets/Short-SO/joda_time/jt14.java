package java.joda_time;

import org.joda.time.DateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class jt14 {
    public static void h1(){
        ZoneId z = ZoneId.of( "America/Montreal" );
        ZonedDateTime start = ZonedDateTime.of( 2017 , 1 , 17 , 14 , 45 , 0 , 0 , z );
        ZonedDateTime stop = ZonedDateTime.of( 2017 , 1 , 17 , 15 , 12 , 0 , 0 , z );
    }
}
