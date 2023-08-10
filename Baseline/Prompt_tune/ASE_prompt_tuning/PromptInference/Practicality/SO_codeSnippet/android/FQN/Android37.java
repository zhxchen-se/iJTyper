public class Android37 extends android.app.Activity implements java.lang.Runnable {
    public android.app.ProgressDialog mProgress;

    // UI has a button that when pressed calls send
    public void send() {
        mProgress = android.app.ProgressDialog.show(this, "Please wait", "Please wait", true, true);
        java.lang.Thread thread = new java.lang.Thread(this);
        thread.start();
    }

    public void run() {
        try {
            java.lang.Thread.sleep(10000);
        } catch (java.lang.InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        android.os.Message msg = new android.os.Message();
        mHandler.sendMessage(msg);
    }

    private final android.os.Handler mHandler = new android.os.Handler() {
        @java.lang.Override
        public void handleMessage(android.os.Message msg) {
            mProgress.dismiss();
        }
    };
}

