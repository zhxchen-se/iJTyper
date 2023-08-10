// ID = 526524
public class Android10 {
    public static void main(java.lang.String[] args) {
        android.widget.Chronometer t = ((android.widget.Chronometer) (android.Android10.findViewById(R.id.copy)));
        long time = android.os.SystemClock.elapsedRealtime() - t.getBase();
        android.util.Log.d(null, "Was: " + time);
        t.setBase(android.os.SystemClock.elapsedRealtime());
        t.start();
    }

    private static android.widget.Chronometer findViewById(int toptime) {
        return null;
    }
}

