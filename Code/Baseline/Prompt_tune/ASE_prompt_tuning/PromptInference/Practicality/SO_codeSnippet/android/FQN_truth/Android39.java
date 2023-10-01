public class Android39 extends MapActivity {
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_list_item);
        MapView myMapView = ((MapView) (findViewById(R.id.background)));
        MapController mapController = myMapView.getController();
        java.util.List<Overlay> overlays = myMapView.getOverlays();
        MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, myMapView);
        overlays.add(myLocationOverlay);
        myLocationOverlay.enableMyLocation();
    }

    protected boolean isRouteDisplayed() {
        return false;
    }
}

