// ID = 724419
public class Android18 extends android.app.Activity implements android.view.View.OnClickListener {
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        this.setTitle("MainActivity");
    }

    public void onClick(android.content.DialogInterface arg0, int arg1) {
        startActivity(new android.content.Intent(this, android.ChildActivity.class));
    }

    @java.lang.Override
    public void onClick(android.view.View view) {
    }
}

class ChildActivity extends android.app.Activity {
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        this.setTitle("ChildActivity");
    }
}

