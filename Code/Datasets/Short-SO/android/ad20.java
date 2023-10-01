package java.android;

import org.joda.time.Instant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ad20 {
    public static void h1(){
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        Instant instant = Instant.now();
    }

}
