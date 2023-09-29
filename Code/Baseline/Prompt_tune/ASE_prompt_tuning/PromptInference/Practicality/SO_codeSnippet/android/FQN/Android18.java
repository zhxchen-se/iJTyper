public class Android18 extends android.app.Activity implements android.content.DialogInterface.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("MainActivity");
    }

    @java.lang.Override
    public void onClick(android.content.DialogInterface arg0, int arg1) {
        startActivity(new android.content.Intent(this, androidExamples.ChildActivity.class));
    }
}

class ChildActivity extends android.app.Activity {
    /**
     * Called when the activity is first created.
     */
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        this.setTitle("ChildActivity");
    }
}

