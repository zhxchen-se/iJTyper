public class Android22 extends android.app.ListActivity {
    private android.widget.ListAdapter mAdapter;

    public android.widget.TextView pbContact;

    public static java.lang.String PBCONTACT;

    public static final int ACTIVITY_EDIT = 1;

    private static final int ACTIVITY_CREATE = 0;

    // Called when the activity is first created.
    @java.lang.Override
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        android.database.Cursor C = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);
        java.lang.String[] columns = new java.lang.String[]{ android.provider.Contacts.People.NAME };
        int[] names = new int[]{ R.id.lay };
        mAdapter = new android.widget.SimpleCursorAdapter(this, R.layout.mycontacts, C, columns, names);
        setListAdapter(mAdapter);
    }// end onCreate()


    // Called when contact is pressed
    @java.lang.Override
    protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        android.database.Cursor C = ((android.database.Cursor) (mAdapter.getItem(position)));
        androidExamples.Android22.PBCONTACT = C.getString(C.getColumnIndex(People.NAME));
        // RHS 05/06
        // pbContact = (TextView) findViewById(R.id.myContact);
        // pbContact.setText(new StringBuilder().append("b"));
        android.content.Intent i = new android.content.Intent(this, android.provider.ContactsContract.CommonDataKinds.Note.class);
        startActivityForResult(i, androidExamples.Android22.ACTIVITY_CREATE);
    }
}

