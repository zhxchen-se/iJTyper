public class Android36 {
    private static final java.lang.String KEY_NAME = "My Key";

    private static final java.lang.String VALUE = "My Value";

    private static final java.lang.String DATABASE_TABLE = "DB";

    private long insertRow(int rowParameter, java.lang.String rowValue, android.database.sqlite.SQLiteDatabase db) {
        long res = -1;
        android.content.ContentValues settingsParameterValues = new android.content.ContentValues();
        settingsParameterValues.put(android.Android36.KEY_NAME, rowParameter);
        settingsParameterValues.put(android.Android36.VALUE, rowValue);
        if (db != null) {
            res = db.insert(android.Android36.DATABASE_TABLE, null, settingsParameterValues);
        }
        return res;
    }

    public static void main(java.lang.String[] args) {
    }
}

