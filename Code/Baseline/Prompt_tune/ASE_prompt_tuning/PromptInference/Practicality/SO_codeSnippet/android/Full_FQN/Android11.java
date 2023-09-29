public class Android11 extends com.google.android.maps.MyLocationOverlay {
  public Android11(android.content.Context arg0, com.google.android.maps.MapView arg1) {
    java.lang.Object.java.lang.Object()
    // TODO Auto-generated constructor stub
  }

  @java.lang.Override
  public void drawMyLocation(android.graphics.Canvas canvas, com.google.android.maps.MapView mapView, android.location.Location lastFix, com.google.android.maps.GeoPoint myLocation, long when) {
    com.google.android.maps.MyLocationOverlay.drawMyLocation(android.graphics.Canvas,com.google.android.maps.MapView,android.location.Location,com.google.android.maps.GeoPoint,long)
    android.location.Location bLocation = new android.location.Location("reverseGeocoded");
    android.location.Location.setLatitude(int)
    android.location.Location.setLongitude(int)
    android.location.Location aLocation = new android.location.Location("reverseGeocoded");
    android.location.Location.setLatitude()
    android.location.Location.setLongitude()
    android.location.Location.set(android.location.Location)
    android.location.Location.set(android.location.Location)
    int distance = android.location.Location.distanceTo(android.location.Location);// Value = 12637795 ???

    java.lang.String str = (" (" + java.lang.String.valueOf(int)) + " meters)";
  }

  static final class FindList {
    public static int gpslat = 1;

    public static int gpslong = 1;
  }
}
