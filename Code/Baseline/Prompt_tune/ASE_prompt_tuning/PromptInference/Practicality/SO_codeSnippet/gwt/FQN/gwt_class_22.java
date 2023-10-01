public class gwt_class_22 extends com.google.gwt.user.client.ui.Composite {
    private static gwt_class_22.TestViewUiBinder uiBinder = com.google.gwt.core.client.GWT.create(gwt_class_22.TestViewUiBinder.class);

    interface TestViewUiBinder extends com.google.gwt.uibinder.client.UiBinder<com.google.gwt.user.client.ui.VerticalPanel, gwt_class_22> {}

    @com.google.gwt.uibinder.client.UiField
    com.google.gwt.user.client.ui.Label testObjectStringLabel;

    @com.google.gwt.uibinder.client.UiField
    com.google.gwt.user.client.ui.Label innerObjectStringLabel;

    @com.google.gwt.uibinder.client.UiField
    com.google.gwt.user.client.ui.VerticalPanel listObjectsPanel;

    @com.google.gwt.uibinder.client.UiField
    com.google.gwt.user.client.ui.Button button;

    @com.google.gwt.uibinder.client.UiField
    com.google.gwt.user.client.ui.Label errorMessageLabel;

    public gwt_class_22(java.lang.String firstName) {
        initWidget(gwt_class_22.uiBinder.createAndBindUi(this));
    }

    @com.google.gwt.uibinder.client.UiHandler("button")
    void onClick(com.google.gwt.event.dom.client.ClickEvent e) {
    }
}

