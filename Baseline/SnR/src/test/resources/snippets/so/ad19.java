package java.android;

import android.content.Intent;
import android.os.Bundle;

public class ad19 {
    public static void h1(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
        }
    }
    private static Intent getIntent() {
        return null;
    }
}
