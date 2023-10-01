public class Android45 extends android.app.Activity {
    private static final java.lang.String TAG = "MyActivity";

    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(Intent.ACTION_SEND);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        try {
            intentFilter.addDataType("image/*");
        } catch (android.content.IntentFilter.MalformedMimeTypeException e) {
            android.util.Log.e(androidExamples.Android45.TAG, e.toString());
        }
        android.content.Intent x = registerReceiver(new android.content.BroadcastReceiver() {
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                android.util.Log.d(androidExamples.Android45.TAG, "Received intent " + intent);
                intent.setComponent(new android.content.ComponentName(context, androidExamples.Android45.Uploader.class));
                startActivity(intent);
            }
        }, intentFilter);
        if (x == null) {
            android.util.Log.i(androidExamples.Android45.TAG, "failed to regist a receiver");
        } else {
            android.util.Log.i(androidExamples.Android45.TAG, "registed a receiver successfully");
        }
    }

    class Uploader {}
}

