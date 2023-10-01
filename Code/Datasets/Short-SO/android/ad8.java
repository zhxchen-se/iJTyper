package java.android;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import javax.naming.Context;
import java.util.Locale;

public class ad8 {
       public static void setLocale(Activity activity, String languageCode) {
           Locale locale = new Locale(languageCode);
           Locale.setDefault(locale);
           Resources resources = activity.getResources();
       }
}
