public class gwt_class_48 implements com.google.gwt.core.client.EntryPoint {
    @java.lang.Override
    public void onModuleLoad() {
        com.google.gwt.user.client.ui.TabBar bar = new com.google.gwt.user.client.ui.TabBar();
        bar.addTab("foo");
        bar.addTab("bar");
        bar.addTab("baz");
        bar.addSelectionHandler(new com.google.gwt.event.logical.shared.SelectionHandler() {
            public void onSelection(com.google.gwt.event.logical.shared.SelectionEvent event) {
                // let user know what you just did
                com.google.gwt.user.client.Window.alert("you clicked tab" + event.getSelectedItem());
            }
        });
        // Just for fun, let's disallow selection of 'bar'.
        bar.addBeforeSelectionHandler(new com.google.gwt.event.logical.shared.BeforeSelectionHandler() {
            public void onBeforeSelection(com.google.gwt.event.logical.shared.BeforeSelectionEvent event) {
                event.cancel();
            }
        });
    }
}

