public class Android12 extends android.app.Activity {
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.widget.LinearLayout l = new android.widget.LinearLayout(this);
        android.widget.LinearLayout.LayoutParams lp = new android.widget.LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        android.widget.LinearLayout.LayoutParams mlp = new android.widget.LinearLayout.LayoutParams(new android.view.ViewGroup.MarginLayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mlp.setMargins(0, 0, 2, 0);
        for (int i = 0; i < 10; i++) {
            android.widget.TextView t = new android.widget.TextView(this);
            t.setText("Hello");
            t.setBackgroundColor(Color.RED);
            t.setSingleLine(true);
            l.addView(t, mlp);
        }
        setContentView(l, lp);
    }
}

