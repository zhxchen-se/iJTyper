public class Android04 extends android.app.Activity {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    mTextView = new android.widget.TextView(this);
    if (savedInstanceState == null) {
      android.widget.TextView.setText(java.lang.String)
    } else {
      android.widget.TextView.setText(java.lang.String)
    }
    <unknown>.setContentView(<unknown>)
  }

  private android.widget.TextView mTextView = null;
}
