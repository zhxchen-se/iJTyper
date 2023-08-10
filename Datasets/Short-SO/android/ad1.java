package java.android;

import android.app.Activity;
import android.view.View;
import sun.awt.im.InputMethodManager;

public class ad1 {
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
    }
}
