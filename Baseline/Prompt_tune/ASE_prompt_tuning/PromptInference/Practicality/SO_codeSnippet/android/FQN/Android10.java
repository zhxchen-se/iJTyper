public class Android10 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        android.widget.Chronometer t = ((android.widget.Chronometer) (androidExamples.Android10.findViewById(R.id.toptime)));
        long time = android.os.SystemClock.elapsedRealtime() - t.getBase();
        android.util.Log.d(null, "Was: " + time);// time is not the proper time for some reason - it is a random number between 0 and 50

        t.setBase(android.os.SystemClock.elapsedRealtime());
        t.start();
    }

    private static android.widget.Chronometer findViewById(int toptime) {
        // TODO Auto-generated method stub
        return null;
    }
}

