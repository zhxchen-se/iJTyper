package java.android;

import android.os.Build;

public class ad7 {
    public static String h1(){
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release +")";
    }
}
