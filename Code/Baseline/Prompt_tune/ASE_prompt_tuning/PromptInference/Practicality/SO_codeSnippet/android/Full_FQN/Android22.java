public class Android22 extends android.app.ListActivity {
  private android.widget.ListAdapter mAdapter;

  public android.widget.TextView pbContact;

  public static java.lang.String PBCONTACT;

  public static final int ACTIVITY_EDIT = 1;

  private static final int ACTIVITY_CREATE = 0;

  // Called when the activity is first created.
  @java.lang.Override
  public void onCreate(android.os.Bundle icicle) {
    android.app.ListActivity.onCreate(android.os.Bundle)
    android.database.Cursor C = <unknown>.getContentResolver()###<unknown>.query(<unknown>,<unknown>,<unknown>,<unknown>);
    <unknown>.startManagingCursor(<unknown>)
    java.lang.String[] columns = new java.lang.String[]{ android.provider.Contacts.People.NAME };
    int[] names = new int[]{ R.id.lay };
    mAdapter = new android.widget.SimpleCursorAdapter(this, R.layout.mycontacts, C, columns, names);
    <unknown>.setListAdapter(<unknown>)
  }// end onCreate()


  // Called when contact is pressed
  @java.lang.Override
  protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
    android.app.ListActivity.onListItemClick(android.widget.ListView,android.view.View,int,long)
    android.database.Cursor C = android.widget.ListAdapter.getItem(int);
    androidExamples.Android22.PBCONTACT = android.database.Cursor.getString();
    // RHS 05/06
    // pbContact = (TextView) findViewById(R.id.myContact);
    // pbContact.setText(new StringBuilder().append("b"));
    android.content.Intent i = new android.content.Intent(this, android.provider.ContactsContract.CommonDataKinds.Note.class);
    <unknown>.startActivityForResult(<unknown>,int)
  }
}
