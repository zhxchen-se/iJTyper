public class gwt_class_48 implements EntryPoint {
    @java.lang.Override
    public void onModuleLoad() {
        TabBar bar = new TabBar();
        bar.addTab("foo");
        bar.addTab("bar");
        bar.addTab("baz");
        bar.addSelectionHandler(new SelectionHandler() {
            public void onSelection(SelectionEvent event) {
                Window.alert("you clicked tab" + event.getSelectedItem());
            }
        });
        bar.addBeforeSelectionHandler(new BeforeSelectionHandler() {
            public void onBeforeSelection(BeforeSelectionEvent event) {
                event.cancel();
            }
        });
    }
}

