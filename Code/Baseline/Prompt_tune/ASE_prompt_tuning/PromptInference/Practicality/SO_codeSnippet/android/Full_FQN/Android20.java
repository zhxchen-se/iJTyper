public class Android20 extends android.view.View {
  private static final int BOARD_X_OFFSET = 10;

  private static final int BOARD_Y_OFFSET = 10;

  public Android20(android.content.Context context) {
    java.lang.Object.java.lang.Object()
    // TODO Auto-generated constructor stub
  }

  private android.widget.TextView animText;

  private void animText(java.lang.String text, int color, int xBlocks, int yBlocks) {
    android.widget.TextView.setText(java.lang.String)
    android.widget.TextView.setTextColor(int)
    android.widget.TextView.setVisibility()
    int xBlockSize = 2;
    final int x = androidExamples.Android20.BOARD_X_OFFSET + (xBlocks * xBlockSize);
    int yBlockSize = 2;
    final int y = androidExamples.Android20.BOARD_Y_OFFSET + (yBlocks * yBlockSize);
    final float SCALE_FROM = ((float) (0.25));
    final float SCALE_TO = ((float) (5.0));
    android.view.animation.ScaleAnimation anim = new android.view.animation.ScaleAnimation(SCALE_FROM, SCALE_TO, SCALE_FROM, SCALE_TO, x, y);
    android.view.animation.ScaleAnimation.setDuration(int)
    android.widget.TextView.setAnimation(android.view.animation.ScaleAnimation)
    <unknown>.setAnimation(<unknown>)
    <unknown>.startAnimation(<unknown>)
  }
}
