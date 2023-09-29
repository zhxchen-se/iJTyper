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
    java.lang.Object.java.lang.Object()
  }

  public Android16(android.content.Context context, android.util.AttributeSet attrs) {
    java.lang.Object.java.lang.Object()
    oOffset = <unknown>.getThumbOffset();
    oProgress = <unknown>.getProgress();
  }

  public Android16(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
    java.lang.Object.java.lang.Object()
  }

  protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int height = View.MeasureSpec.getSize(int);
    oHeight = height;
    <unknown>.setMeasuredDimension(int,int)
  }

  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    <unknown>.onSizeChanged(int,int,int,int)
  }

  protected void onLayout(boolean changed, int l, int t, int r, int b) {
    <unknown>.onLayout(boolean,int,int,int,int)
    left = l;
    right = r;
    top = t;
    bottom = b;
  }

  protected void onDraw(android.graphics.Canvas c) {
    android.graphics.Canvas.rotate(int)
    android.graphics.Canvas.translate(int,int)
    android.widget.SeekBar.onDraw(android.graphics.Canvas)
  }

  public boolean onTouchEvent(android.view.MotionEvent event) {
    xPos = android.view.MotionEvent.getX();
    yPos = android.view.MotionEvent.getY();
    float progress = (yPos - <unknown>.getTop()) / (<unknown>.getBottom() - <unknown>.getTop());
    oOffset = <unknown>.getThumbOffset();
    oProgress = <unknown>.getProgress();
    android.util.Log.d(java.lang.String,java.lang.String)
    android.util.Log.d(java.lang.String,java.lang.String)
    float offset;
    offset = progress * (<unknown>.getBottom() - <unknown>.getTop());
    <unknown>.setThumbOffset(int)
    android.util.Log.d(java.lang.String,java.lang.String)
    android.util.Log.d(java.lang.String,java.lang.String)
    <unknown>.setProgress(int)
    return true;
  }
}
