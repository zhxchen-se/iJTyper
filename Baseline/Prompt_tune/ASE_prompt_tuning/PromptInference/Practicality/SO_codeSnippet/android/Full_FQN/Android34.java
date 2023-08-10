public class Android34 extends android.app.TabActivity implements android.widget.TabHost.TabContentFactory , android.widget.TabHost.OnTabChangeListener , android.view.View.OnClickListener {
  private static final java.lang.String LOG_KEY = "TEST";

  android.widget.ListView listView;

  @java.lang.Override
  protected void onCreate(android.os.Bundle savedInstanceState) {
    android.app.TabActivity.onCreate(android.os.Bundle)
    final android.widget.TabHost tabHost = <unknown>.getTabHost();
    android.widget.TabHost.TabSpec ts = android.widget.TabHost.newTabSpec(java.lang.String);
    TabHost.TabSpec.setIndicator(java.lang.String)
    TabHost.TabSpec.setContent(androidExamples.Android34)
    android.widget.TabHost.addTab(TabHost.TabSpec)
    ts = android.widget.TabHost.newTabSpec(java.lang.String);
    TabHost.TabSpec.setIndicator(java.lang.String)
    TabHost.TabSpec.setContent(androidExamples.Android34)
    android.widget.TabHost.addTab(TabHost.TabSpec)
    ts = android.widget.TabHost.newTabSpec(java.lang.String);
    TabHost.TabSpec.setIndicator(java.lang.String)
    TabHost.TabSpec.setContent(androidExamples.Android34)
    android.widget.TabHost.addTab(TabHost.TabSpec)
    android.widget.TabHost.setOnClickListener(androidExamples.Android34)
    android.widget.TabHost.setOnTabChangedListener(androidExamples.Android34)
  }

  public void onClick(android.view.View v) {
    android.util.Log.d(java.lang.String,java.lang.String)
  }

  public void onTabChanged(java.lang.String tabId) {
    android.util.Log.d(java.lang.String,java.lang.String)
  }

  @java.lang.Override
  public android.view.View createTabContent(java.lang.String arg0) {
    // TODO Auto-generated method stub
    return null;
  }
}
