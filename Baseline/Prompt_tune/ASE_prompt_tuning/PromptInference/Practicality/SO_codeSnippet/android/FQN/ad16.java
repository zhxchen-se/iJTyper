public class ad16 {
    private void hideKeyboard(android.app.Activity activity) {
        if ((activity != null) && (activity.getWindow() != null)) {
            android.view.inputmethod.InputMethodManager imm = ((android.view.inputmethod.InputMethodManager) (activity.getSystemService(Context.INPUT_METHOD_SERVICE)));
        }
    }
}

