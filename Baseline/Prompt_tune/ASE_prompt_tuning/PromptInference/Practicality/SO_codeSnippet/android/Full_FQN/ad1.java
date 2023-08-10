public class ad1 {
  public static void hideKeyboard(android.app.Activity activity) {
    sun.awt.im.InputMethodManager imm = android.app.Activity.getSystemService();
    android.view.View view = android.app.Activity.getCurrentFocus();
  }
}
