package java.android;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ad13 {
    public void onClick(View view) {
        ((InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE))
                .toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
    }

    private Object getSystemService(String inputMethodService) {
        return null;
    }
}