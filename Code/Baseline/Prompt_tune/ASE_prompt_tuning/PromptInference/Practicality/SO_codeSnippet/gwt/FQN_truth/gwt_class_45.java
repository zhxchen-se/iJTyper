public class gwt_class_45 implements EntryPoint {
    @java.lang.Override
    public void onModuleLoad() {
        Label label = new Label("hello world");
        Button button = new Button("say something");
        button.addClickHandler(new ClickHandler() {
            @java.lang.Override
            public void onClick(ClickEvent event) {
                Window.alert("hello again");
            }
        });
        RootPanel.get().add(label);
        RootPanel.get().add(button);
    }
}

