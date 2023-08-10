public class Android40 extends android.app.Activity {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
    }

    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        android.widget.SlidingDrawer drawer = ((android.widget.SlidingDrawer) (findViewById(R.id.lay)));
        android.widget.ImageView handle = ((android.widget.ImageView) (findViewById(R.id.myImage)));
        handle.setFocusable(true);
        handle.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                // TODO Auto-generated method stub
                android.util.Log.i("test", "onClick");
            }
        });
    }
}

