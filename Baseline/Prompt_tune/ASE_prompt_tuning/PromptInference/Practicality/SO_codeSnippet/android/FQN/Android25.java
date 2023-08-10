public class Android25 extends android.app.ListActivity {
    /**
     * Called when the activity is first created.
     */
    private final java.lang.String MY_DATABASE_NAME = "myCoolUserDB.db";

    private final java.lang.String MY_DATABASE_TABLE = "t_Users";

    android.content.Context c;

    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        java.util.ArrayList<java.lang.String> results = new java.util.ArrayList<java.lang.String>();
        setContentView(R.layout.main);
        android.database.sqlite.SQLiteDatabase mydb = null;
        try {
            mydb.openOrCreateDatabase(MY_DATABASE_NAME, null);
        } catch (java.lang.Exception e) {
        }
    }
}

