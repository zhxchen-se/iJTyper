public class Android45 extends android.app.Activity {
  private static final java.lang.String TAG = "MyActivity";

  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
    android.content.IntentFilter.addAction()
    android.content.IntentFilter.addCategory()
    try {
      android.content.IntentFilter.addDataType(java.lang.String)
    } catch (android.content.IntentFilter.MalformedMimeTypeException e) {
      android.util.Log.e(java.lang.String)
    }
    android.content.Intent x = <unknown>.registerReceiver(androidExamples.Android45$1,<unknown>);
    if (x == null)
      android.util.Log.i(java.lang.String,java.lang.String)
    else
      android.util.Log.i(java.lang.String,java.lang.String)

  }

  class Uploader {}
}
