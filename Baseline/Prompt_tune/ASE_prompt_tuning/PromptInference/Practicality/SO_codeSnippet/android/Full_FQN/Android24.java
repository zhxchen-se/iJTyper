public class Android24 extends android.app.Activity {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    android.location.LocationManager l = <unknown>.getSystemService(<unknown>);
    java.util.List<java.lang.String> li = android.location.LocationManager.getAllProviders();
    for (java.util.Iterator<java.lang.String> iterator = java.util.List.iterator(); java.util.Iterator.hasNext();) {
      java.lang.String string = java.util.Iterator.next();
      android.util.Log.d(java.lang.String,java.lang.String)
    }
    if (android.location.LocationManager.getLastKnownLocation(java.lang.String) == null)
      android.util.Log.d(java.lang.String,java.lang.String)

  }
}
