public class Android41 extends android.view.View {
    public Android41(android.content.Context context) {
        super(context);
        setBackgroundColor(java.awt.Color.RED);
    }

    private void setBackgroundColor(java.awt.Color red) {
    }

    android.widget.TextView tv;

    public void adText(android.widget.TextView tv) {
        this.tv = tv;
        tv.setVisibility(tv.VISIBLE);
    }
}

