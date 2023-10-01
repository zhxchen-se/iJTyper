// ID = 288044
public class Android07 extends android.app.Activity {
    java.lang.String[] mainItems = new java.lang.String[]{ "Inbox", "Projects", "Contexts", "Next Actions" };

    @java.lang.Override
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        setListAdapter(new android.widget.ArrayAdapter<java.lang.String>(this, android.R.layout.simple_list_item_1, mainItems));
        registerForContextMenu(getListView());
    }

    private void setListAdapter(android.widget.ArrayAdapter<java.lang.String> arrayAdapter) {
        // TODO Auto-generated method stub
    }

    private android.view.View getListView() {
        // TODO Auto-generated method stub
        return null;
    }
}

