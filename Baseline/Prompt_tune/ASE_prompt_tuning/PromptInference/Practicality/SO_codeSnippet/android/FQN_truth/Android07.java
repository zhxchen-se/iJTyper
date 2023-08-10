// ID = 288044
public class Android07 extends android.app.Activity {
    java.lang.String[] mainItems = new java.lang.String[]{ "Inbox", "Projects", "Contexts", "Next Actions" };

    @java.lang.Override
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_list_item);
        setListAdapter(new android.widget.ArrayAdapter<java.lang.String>(this, R.layout.simple_list_item_1, mainItems));
        registerForContextMenu(getListView());
    }

    private void setListAdapter(android.widget.ArrayAdapter<java.lang.String> arrayAdapter) {
    }

    private android.view.View getListView() {
        return null;
    }
}

