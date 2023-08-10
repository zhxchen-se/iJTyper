public class ad1 {
    public static void hideKeyboard(android.app.Activity activity) {
        sun.awt.im.InputMethodManager imm = ((sun.awt.im.InputMethodManager) (activity.getSystemService(Activity.INPUT_METHOD_SERVICE)));
        android.view.View view = activity.getCurrentFocus();
    }
}

