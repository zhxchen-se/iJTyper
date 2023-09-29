public class Android20 extends android.view.View {
    private static final int BOARD_X_OFFSET = 10;

    private static final int BOARD_Y_OFFSET = 10;

    public Android20(android.content.Context context) {
        super(context);
    }

    private android.widget.TextView animText;

    private void animText(java.lang.String text, int color, int xBlocks, int yBlocks) {
        animText.setText(text);
        animText.setTextColor(color);
        animText.setVisibility(View.VISIBLE);
        int xBlockSize = 2;
        final int x = android.Android20.BOARD_X_OFFSET + (xBlocks * xBlockSize);
        int yBlockSize = 2;
        final int y = android.Android20.BOARD_Y_OFFSET + (yBlocks * yBlockSize);
        final float SCALE_FROM = ((float) (0.25));
        final float SCALE_TO = ((float) (5.0));
        android.view.animation.ScaleAnimation anim = new android.view.animation.ScaleAnimation(SCALE_FROM, SCALE_TO, SCALE_FROM, SCALE_TO, x, y);
        anim.setDuration(500);
        animText.setAnimation(anim);
        this.setAnimation(null);
        startAnimation(anim);
    }
}

