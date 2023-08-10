public class Android36 {
  private static final java.lang.String KEY_NAME = "My Key";

  private static final java.lang.String VALUE = "My Value";

  private static final java.lang.String DATABASE_TABLE = "DB";

  private long insertRow(int rowParameter, java.lang.String rowValue, android.database.sqlite.SQLiteDatabase db) {
    long res = -1;
    android.content.ContentValues settingsParameterValues = new android.content.ContentValues();
    android.content.ContentValues.put(java.lang.String,int)
    android.content.ContentValues.put(java.lang.String,java.lang.String)
    if (db != null) {
      res = android.database.sqlite.SQLiteDatabase.insert(java.lang.String,<unknown>,android.content.ContentValues);
    }
    return res;
  }

  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
  }
}
