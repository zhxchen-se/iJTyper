public class Android05 {
    public static void main(java.lang.String[] args) {
        android.widget.TabHost mTabs = null;
        android.widget.TabHost.TabSpec ts = mTabs.newTabSpec("tab");
        android.graphics.drawable.Drawable iconResource = null;
        ts.setIndicator("TabTitle", iconResource);
        mTabs.addTab(ts);
        mTabs.getTabWidget().removeAllViews();
        mTabs.clearAllTabs();
    }
}

