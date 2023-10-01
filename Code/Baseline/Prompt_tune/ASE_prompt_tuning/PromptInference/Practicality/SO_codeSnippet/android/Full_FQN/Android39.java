public class Android39 extends com.google.android.maps.MapActivity {
  public void onCreate(android.os.Bundle icicle) {
    com.google.android.maps.MapActivity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    com.google.android.maps.MapView myMapView = <unknown>.findViewById(<unknown>);
    com.google.android.maps.MapController mapController = com.google.android.maps.MapView.getController();
    java.util.List<com.google.android.maps.Overlay> overlays = com.google.android.maps.MapView.getOverlays();
    com.google.android.maps.MyLocationOverlay myLocationOverlay = new com.google.android.maps.MyLocationOverlay(this, myMapView);
    java.util.List.add(com.google.android.maps.MyLocationOverlay)
    com.google.android.maps.MyLocationOverlay.enableMyLocation()
  }

  protected boolean isRouteDisplayed() {
    return false;
  }
}
