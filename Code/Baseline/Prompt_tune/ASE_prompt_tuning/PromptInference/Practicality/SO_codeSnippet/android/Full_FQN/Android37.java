public class Android37 extends android.app.Activity implements java.lang.Runnable {
  public android.app.ProgressDialog mProgress;

  // UI has a button that when pressed calls send
  public void send() {
    mProgress = android.app.ProgressDialog.show(androidExamples.Android37,java.lang.String,java.lang.String,boolean,boolean);
    java.lang.Thread thread = new java.lang.Thread(this);
    java.lang.Thread.start()
  }

  public void run() {
    try {
      java.lang.Thread.sleep(long)
    } catch (java.lang.InterruptedException e) {
      java.lang.Throwable.printStackTrace()
    }
    android.os.Message msg = new android.os.Message();
    android.os.Handler.sendMessage(android.os.Message)
  }

  private final android.os.Handler mHandler = new android.os.Handler() {
    @java.lang.Override
    public void handleMessage(android.os.Message msg) {
      android.app.ProgressDialog.dismiss()
    }
  };
}
