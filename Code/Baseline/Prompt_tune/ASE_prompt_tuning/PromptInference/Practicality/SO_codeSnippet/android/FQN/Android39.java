public class Android39 extends com.google.android.maps.MapActivity {
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        com.google.android.maps.MapView myMapView = ((com.google.android.maps.MapView) (findViewById(R.id.lay)));
        com.google.android.maps.MapController mapController = myMapView.getController();
        java.util.List<com.google.android.maps.Overlay> overlays = myMapView.getOverlays();
        com.google.android.maps.MyLocationOverlay myLocationOverlay = new com.google.android.maps.MyLocationOverlay(this, myMapView);
        overlays.add(myLocationOverlay);
        myLocationOverlay.enableMyLocation();
    }

    protected boolean isRouteDisplayed() {
        return false;
    }
}

