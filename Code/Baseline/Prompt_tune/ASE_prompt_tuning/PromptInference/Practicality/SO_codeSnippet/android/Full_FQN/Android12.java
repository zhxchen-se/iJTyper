public class Android12 extends android.app.Activity {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    android.widget.LinearLayout l = new android.widget.LinearLayout(this);
    android.widget.LinearLayout.LayoutParams lp = new android.widget.LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    android.widget.LinearLayout.LayoutParams mlp = new android.widget.LinearLayout.LayoutParams(new android.view.ViewGroup.MarginLayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    LinearLayout.LayoutParams.setMargins(int,int,int,int)
    for (int i = 0; i < 10; i++) {
      android.widget.TextView t = new android.widget.TextView(this);
      android.widget.TextView.setText(java.lang.String)
      android.widget.TextView.setBackgroundColor()
      android.widget.TextView.setSingleLine(boolean)
      android.widget.LinearLayout.addView(android.widget.TextView,LinearLayout.LayoutParams)
    }
    <unknown>.setContentView(<unknown>,<unknown>)
  }
}
