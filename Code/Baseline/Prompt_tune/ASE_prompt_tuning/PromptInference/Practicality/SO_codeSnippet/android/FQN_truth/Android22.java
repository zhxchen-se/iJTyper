public class Android22 extends android.app.ListActivity {
    private android.widget.ListAdapter mAdapter;

    public android.widget.TextView pbContact;

    public static java.lang.String PBCONTACT;

    public static final int ACTIVITY_EDIT = 1;

    private static final int ACTIVITY_CREATE = 0;

    @java.lang.Override
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        android.database.Cursor C = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);
        java.lang.String[] columns = new java.lang.String[]{ android.provider.Contacts.People.NAME };
        int[] names = new int[]{ R.id.background };
        mAdapter = new android.widget.SimpleCursorAdapter(this, R.layout.list_content, C, columns, names);
        setListAdapter(mAdapter);
    }

    @java.lang.Override
    protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        android.database.Cursor C = ((android.database.Cursor) (mAdapter.getItem(position)));
        android.Android22.PBCONTACT = C.getString(C.getColumnIndex(People.NAME));
        android.content.Intent i = new android.content.Intent(this, android.provider.ContactsContract.CommonDataKinds.Note.class);
        startActivityForResult(i, android.Android22.ACTIVITY_CREATE);
    }
}

