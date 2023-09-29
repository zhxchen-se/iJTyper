public class gwt_class_44 extends com.google.gwt.user.client.ui.ResizeComposite {
    private static gwt_class_44 instance = null;

    public static void getInstance(final com.google.gwt.user.client.rpc.AsyncCallback<gwt_class_44> callback) {
        com.google.gwt.core.client.GWT.runAsync(new com.google.gwt.core.client.RunAsyncCallback() {
            @java.lang.Override
            public void onSuccess() {
                if (gwt_class_44.instance == null) {
                    gwt_class_44.instance = new gwt_class_44();
                }
                callback.onSuccess(gwt_class_44.instance);
            }

            @java.lang.Override
            public void onFailure(java.lang.Throwable reason) {
                callback.onFailure(reason);
            }
        });
    }

    private gwt_class_44() {
        com.google.gwt.user.client.ui.DockLayoutPanel dockLayoutPanel = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.EM);
        dockLayoutPanel.addNorth(new com.google.gwt.user.client.ui.Label("North!"), 7);
        dockLayoutPanel.addWest(new com.google.gwt.user.client.ui.Label("West!"), 15);
        dockLayoutPanel.add(new com.google.gwt.user.client.ui.Label("Center! :D"));
        initWidget(dockLayoutPanel);
    }
}

