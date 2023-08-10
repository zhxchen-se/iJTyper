public class ad2 {
    public static void hideKeyboard(android.app.Activity activity) {
        android.view.inputmethod.InputMethodManager imm = ((android.view.inputmethod.InputMethodManager) (activity.getSystemService(Activity.INPUT_METHOD_SERVICE)));
        android.view.View view = activity.getCurrentFocus();
    }
}

