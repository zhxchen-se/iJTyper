public class Android18 extends android.app.Activity implements android.content.DialogInterface.OnClickListener {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    <unknown>.setTitle(java.lang.String)
  }

  @java.lang.Override
  public void onClick(android.content.DialogInterface arg0, int arg1) {
    <unknown>.startActivity(<unknown>)
  }
}class ChildActivity extends android.app.Activity {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    <unknown>.setTitle(java.lang.String)
  }
}
