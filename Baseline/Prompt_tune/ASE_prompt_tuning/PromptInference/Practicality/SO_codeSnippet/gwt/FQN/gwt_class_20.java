/**
 * Hello World application.
 */
public class gwt_class_20 implements com.google.gwt.core.client.EntryPoint {
    public void onModuleLoad() {
        com.google.gwt.user.client.ui.Button b = new com.google.gwt.user.client.ui.Button("Click me", new com.google.gwt.event.dom.client.ClickHandler() {
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                com.google.gwt.user.client.Window.alert("Hello, AJAX");
            }
        });
        com.google.gwt.user.client.ui.RootPanel.get().add(b);
    }
}

