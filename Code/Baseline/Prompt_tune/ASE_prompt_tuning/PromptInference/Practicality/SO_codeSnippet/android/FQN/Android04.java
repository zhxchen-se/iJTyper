public class Android04 extends android.app.Activity {
    /**
     * Called when the activity is first created.
     */
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextView = new android.widget.TextView(this);
        if (savedInstanceState == null) {
            mTextView.setText("Welcome to HelloAndroid!");
        } else {
            mTextView.setText("Welcome back.");
        }
        setContentView(mTextView);
    }

    private android.widget.TextView mTextView = null;
}

