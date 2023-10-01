package java.joda_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class jt13 {
    public static void h1(){
        ZoneId z = ZoneId.of( "Pacific/Auckland" ) ;
        ZonedDateTime now = ZonedDateTime.now( z ) ;
    }
}
