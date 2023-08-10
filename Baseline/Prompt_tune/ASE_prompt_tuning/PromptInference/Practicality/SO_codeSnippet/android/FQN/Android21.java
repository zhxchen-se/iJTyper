public class Android21 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        android.widget.ImageButton b2 = new android.widget.ImageButton(androidExamples.Android21.getApplicationContext());
        b2.setBackgroundResource(R.drawable.img);
        android.widget.LinearLayout container = ((android.widget.LinearLayout) (androidExamples.Android21.findViewById(R.id.lay)));
        container.addView(b2);
    }

    private static android.widget.LinearLayout findViewById(int lay) {
        // TODO Auto-generated method stub
        return null;
    }

    private static android.content.Context getApplicationContext() {
        // TODO Auto-generated method stub
        return null;
    }
}

