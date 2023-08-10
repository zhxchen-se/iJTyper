public class Android45 extends android.app.Activity {
    private static final java.lang.String TAG = "MyActivity";

    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SEND);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        try {
            intentFilter.addDataType("image/*");
        } catch (android.content.IntentFilter.MalformedMimeTypeException e) {
            android.util.Log.e(android.Android45.TAG, e.toString());
        }
        Intent x = registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                android.util.Log.d(android.Android45.TAG, "Received intent " + intent);
                intent.setComponent(new ComponentName(context, android.Android45.Uploader.class));
                startActivity(intent);
            }
        }, intentFilter);
        if (x == null) {
            android.util.Log.i(android.Android45.TAG, "failed to regist a receiver");
        } else {
            android.util.Log.i(android.Android45.TAG, "registed a receiver successfully");
        }
    }

    class Uploader {}
}

