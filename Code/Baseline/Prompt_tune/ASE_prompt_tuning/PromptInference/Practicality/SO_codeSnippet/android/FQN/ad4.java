public class ad4 {
    public static void hideKeyboardFrom(android.content.Context context, android.view.View view) {
        android.view.inputmethod.InputMethodManager imm = ((android.view.inputmethod.InputMethodManager) (context.getSystemService(Activity.INPUT_METHOD_SERVICE)));
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

