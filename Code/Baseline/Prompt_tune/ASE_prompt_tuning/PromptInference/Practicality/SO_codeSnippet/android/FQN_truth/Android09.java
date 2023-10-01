public class Android09 {
    float seconds;

    public java.util.Timer gametimer;

    void updatecount() {
        android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.copy)));
        t.setText(("Score: 10 - Time: " + seconds) + " seconds");
        t.postInvalidate();
    }

    private android.widget.TextView findViewById(int topscore) {
        return null;
    }

    public void onCreate(android.os.Bundle sis) {
        gametimer.schedule(new java.util.TimerTask() {
            public void run() {
                seconds += 0.1;
                updatecount();
            }
        }, 100, 100);
    }
}

