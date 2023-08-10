public class Android34 extends android.app.TabActivity implements android.widget.TabHost.TabContentFactory , android.widget.TabHost.OnTabChangeListener , android.view.View.OnClickListener {
    private static final java.lang.String LOG_KEY = "TEST";

    android.widget.ListView listView;

    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.widget.TabHost tabHost = getTabHost();
        android.widget.TabHost.TabSpec ts = tabHost.newTabSpec("ID_1");
        ts.setIndicator("1");
        ts.setContent(this);
        tabHost.addTab(ts);
        ts = tabHost.newTabSpec("ID_2");
        ts.setIndicator("2");
        ts.setContent(this);
        tabHost.addTab(ts);
        ts = tabHost.newTabSpec("ID_3");
        ts.setIndicator("3");
        ts.setContent(this);
        tabHost.addTab(ts);
        tabHost.setOnClickListener(this);
        tabHost.setOnTabChangedListener(this);
    }

    public void onClick(android.view.View v) {
        android.util.Log.d(android.Android34.LOG_KEY, "OnClick");
    }

    public void onTabChanged(java.lang.String tabId) {
        android.util.Log.d(android.Android34.LOG_KEY, "OnTabChanged");
    }

    @java.lang.Override
    public android.view.View createTabContent(java.lang.String arg0) {
        return null;
    }
}

