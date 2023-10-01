public class Android44 extends android.app.Service {
  public volatile java.lang.Thread runner;

  @java.lang.Override
  public android.os.IBinder onBind(android.content.Intent intent) {
    return null;
  }

  @java.lang.Override
  public void onCreate() {
    <unknown>.onCreate()
    androidExamples.Android44.startThread()
  }

  @java.lang.Override
  public void onDestroy() {
    <unknown>.onDestroy()
    android.util.Log.v(java.lang.String,java.lang.String)
    androidExamples.Android44.stopThread()
  }

  public synchronized void startThread() {
    if (runner == null) {
      android.util.Log.v(java.lang.String,java.lang.String)
      java.lang.Thread.start()
    }
  }

  /* use a handler in a loop cycling through most of oncreate. the
  scanningthread does the work, then notifies the svc's uithread
   */
  public synchronized void stopThread() {
    if (runner != null) {
      android.util.Log.v(java.lang.String,java.lang.String)
      java.lang.Thread moribund = runner;
      runner = null;
      java.lang.Thread.interrupt()
      android.util.Log.v(java.lang.String,java.lang.String)
    }
  }
}
