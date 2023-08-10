public class Android24 extends android.app.Activity {
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        android.location.LocationManager l = ((android.location.LocationManager) (getSystemService(Context.LOCATION_SERVICE)));
        java.util.List<java.lang.String> li = l.getAllProviders();
        for (java.util.Iterator<java.lang.String> iterator = li.iterator(); iterator.hasNext();) {
            java.lang.String string = iterator.next();
            android.util.Log.d("gps", string);
        }
        if (l.getLastKnownLocation("gps") == null) {
            android.util.Log.d("gps", "null");
        }
    }
}

