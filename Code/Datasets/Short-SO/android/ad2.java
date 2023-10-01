package java.android;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ad2 {
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
    }
}
