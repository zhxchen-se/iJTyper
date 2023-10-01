// ID= 1163812
public class Android40 extends android.app.Activity {
    public static void main(java.lang.String[] args) {
    }

    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        android.widget.SlidingDrawer drawer = ((android.widget.SlidingDrawer) (findViewById(R.id.background)));
        android.widget.ImageView handle = ((android.widget.ImageView) (findViewById(R.id.cut)));
        handle.setFocusable(true);
        handle.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                android.util.Log.i("test", "onClick");
            }
        });
    }
}

