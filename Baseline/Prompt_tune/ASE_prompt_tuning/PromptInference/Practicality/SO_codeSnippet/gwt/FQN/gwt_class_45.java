public class gwt_class_45 implements com.google.gwt.core.client.EntryPoint {
    @java.lang.Override
    public void onModuleLoad() {
        com.google.gwt.user.client.ui.Label label = new com.google.gwt.user.client.ui.Label("hello world");
        com.google.gwt.user.client.ui.Button button = new com.google.gwt.user.client.ui.Button("say something");
        button.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
            @java.lang.Override
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                com.google.gwt.user.client.Window.alert("hello again");
            }
        });
        com.google.gwt.user.client.ui.RootPanel.get().add(label);
        com.google.gwt.user.client.ui.RootPanel.get().add(button);
    }
}

