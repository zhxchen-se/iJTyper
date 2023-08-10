public class Android16 extends android.widget.SeekBar {
    private int oHeight = 320;

    private int oWidth = 29;

    private int oProgress = -1;

    private int oOffset = -1;

    private float xPos = -1;

    private float yPos = -1;

    private int top = -1;

    private int bottom = -1;

    private int left = -1;

    private int right = -1;

    public Android16(android.content.Context context) {
        super(context);
    }

    public Android16(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        oOffset = this.getThumbOffset();
        oProgress = this.getProgress();
    }

    public Android16(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        oHeight = height;
        this.setMeasuredDimension(oWidth, oHeight);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldw, oldh);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        left = l;
        right = r;
        top = t;
        bottom = b;
    }

    protected void onDraw(android.graphics.Canvas c) {
        c.rotate(90);
        c.translate(0, -29);
        super.onDraw(c);
    }

    public boolean onTouchEvent(android.view.MotionEvent event) {
        xPos = event.getX();
        yPos = event.getY();
        float progress = (yPos - this.getTop()) / (this.getBottom() - this.getTop());
        oOffset = this.getThumbOffset();
        oProgress = this.getProgress();
        android.util.Log.d("offset" + java.lang.System.nanoTime(), new java.lang.Integer(oOffset).toString());
        android.util.Log.d("progress" + java.lang.System.nanoTime(), new java.lang.Integer(oProgress).toString());
        float offset;
        offset = progress * (this.getBottom() - this.getTop());
        this.setThumbOffset(((int) (offset)));
        android.util.Log.d("offset_postsetprogress" + java.lang.System.nanoTime(), new java.lang.Integer(oOffset).toString());
        android.util.Log.d("progress_postsetprogress" + java.lang.System.nanoTime(), new java.lang.Integer(oProgress).toString());
        this.setProgress(((int) ((100 * event.getY()) / this.getBottom())));
        return true;
    }
}

