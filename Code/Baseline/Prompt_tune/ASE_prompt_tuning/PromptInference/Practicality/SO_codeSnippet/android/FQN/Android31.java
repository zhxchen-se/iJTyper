public class Android31 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        android.os.PowerManager pm = ((android.os.PowerManager) (androidExamples.Android31.getSystemService(Context.POWER_SERVICE)));
        android.os.PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
    }

    private static android.os.PowerManager getSystemService(java.lang.String powerService) {
        // TODO Auto-generated method stub
        return null;
    }
}

