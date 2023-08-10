public class Android29 extends android.app.Service {
    @java.lang.Override
    public android.os.IBinder onBind(android.content.Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @java.lang.Override
    public void onCreate() {
        android.os.PowerManager pm = ((android.os.PowerManager) (getSystemService(Context.POWER_SERVICE)));
        android.os.PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
        wl.acquire();
    }

    @java.lang.Override
    public void onDestroy() {
        android.os.PowerManager.WakeLock wl = null;
        wl.release();
    }
}

