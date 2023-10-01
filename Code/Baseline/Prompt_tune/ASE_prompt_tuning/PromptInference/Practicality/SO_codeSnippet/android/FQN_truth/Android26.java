public class Android26 extends android.widget.ScrollView {
    public Android26(android.content.Context context) {
        super(context);
    }

    @java.lang.Override
    public boolean onInterceptTouchEvent(android.view.MotionEvent ev) {
        return false;
    }

    @java.lang.Override
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        return false;
    }
}

class GameView extends android.view.View implements android.view.View.OnTouchListener {
    public GameView(android.content.Context context) {
        super(context);
    }

    public boolean onKey(android.view.View v, int keyCode, android.view.KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
        }
        invalidate();
        return true;
    }

    @java.lang.Override
    public boolean onTouch(android.view.View arg0, android.view.MotionEvent arg1) {
        return false;
    }
}

