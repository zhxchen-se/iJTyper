public class Android11 extends com.google.android.maps.MyLocationOverlay {
    public Android11(android.content.Context arg0, com.google.android.maps.MapView arg1) {
        super(arg0, arg1);
    }

    @java.lang.Override
    public void drawMyLocation(android.graphics.Canvas canvas, com.google.android.maps.MapView mapView, android.location.Location lastFix, com.google.android.maps.GeoPoint myLocation, long when) {
        super.drawMyLocation(canvas, mapView, lastFix, myLocation, when);
        android.location.Location bLocation = new android.location.Location("reverseGeocoded");
        bLocation.setLatitude(android.Android11.FindList.gpslat);
        bLocation.setLongitude(android.Android11.FindList.gpslong);
        android.location.Location aLocation = new android.location.Location("reverseGeocoded");
        aLocation.setLatitude(myLocation.getLatitudeE6());
        aLocation.setLongitude(myLocation.getLongitudeE6());
        aLocation.set(aLocation);
        bLocation.set(bLocation);
        int distance = ((int) (aLocation.distanceTo(bLocation)));
        java.lang.String str = (" (" + java.lang.String.valueOf(distance)) + " meters)";
    }

    static final class FindList {
        public static int gpslat = 1;

        public static int gpslong = 1;
    }
}

