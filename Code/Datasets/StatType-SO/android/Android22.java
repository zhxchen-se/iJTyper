package androidExamples;
//ID = 866769
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import gen.R;

public class Android22 extends ListActivity {

    private ListAdapter mAdapter;
    public TextView pbContact;
    public static String PBCONTACT;
    public static final int ACTIVITY_EDIT=1;
    private static final int ACTIVITY_CREATE=0;

    // Called when the activity is first created. 
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Cursor C = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);

        String[] columns = new String[] {People.NAME};
        int[] names = new int[] {R.id.lay};

        mAdapter = new SimpleCursorAdapter(this, R.layout.mycontacts, C, columns, names);
        setListAdapter(mAdapter);
    } // end onCreate()
    // Called when contact is pressed
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor C = (Cursor) mAdapter.getItem(position);
        PBCONTACT = C.getString(C.getColumnIndex(People.NAME));

        // RHS 05/06
        //pbContact = (TextView) findViewById(R.id.myContact);
        //pbContact.setText(new StringBuilder().append("b"));

        Intent i = new Intent(this, Note.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }
}


