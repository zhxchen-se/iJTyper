public class Android03 extends com.google.android.maps.ItemizedOverlay<com.google.android.maps.OverlayItem> {
    public Android03(android.graphics.drawable.Drawable defaultMarker) {
        super(defaultMarker);
        populate();
    }

    @java.lang.Override
    protected com.google.android.maps.OverlayItem createItem(int index) {
        java.lang.Double lat = (index + 37.422006) * 1000000.0;
        java.lang.Double lng = (-122.084095) * 1000000.0;
        com.google.android.maps.GeoPoint point = new com.google.android.maps.GeoPoint(lat.intValue(), lng.intValue());
        com.google.android.maps.OverlayItem oi = new com.google.android.maps.OverlayItem(point, "Marker", "Marker Text");
        return oi;
    }

    @java.lang.Override
    public int size() {
        return 5;
    }
}

