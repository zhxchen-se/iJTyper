public class Android11 extends com.google.android.maps.MyLocationOverlay {
    public Android11(android.content.Context arg0, com.google.android.maps.MapView arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    @java.lang.Override
    public void drawMyLocation(android.graphics.Canvas canvas, com.google.android.maps.MapView mapView, android.location.Location lastFix, com.google.android.maps.GeoPoint myLocation, long when) {
        super.drawMyLocation(canvas, mapView, lastFix, myLocation, when);
        android.location.Location bLocation = new android.location.Location("reverseGeocoded");
        bLocation.setLatitude(androidExamples.Android11.FindList.gpslat);// Value = 3.294391E7

        bLocation.setLongitude(androidExamples.Android11.FindList.gpslong);// Value = -9.6564615E7

        android.location.Location aLocation = new android.location.Location("reverseGeocoded");
        aLocation.setLatitude(myLocation.getLatitudeE6());// Value = 3.2946164E7

        aLocation.setLongitude(myLocation.getLongitudeE6());// Value = -9.6505141E7

        aLocation.set(aLocation);// Don't think I need this

        bLocation.set(bLocation);// Don't think I need this either

        int distance = ((int) (aLocation.distanceTo(bLocation)));// Value = 12637795 ???

        java.lang.String str = (" (" + java.lang.String.valueOf(distance)) + " meters)";
    }

    static final class FindList {
        public static int gpslat = 1;

        public static int gpslong = 1;
    }
}

