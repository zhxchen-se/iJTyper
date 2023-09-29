public class gwt_class_22 extends Composite {
    private static gwt_class_22.TestViewUiBinder uiBinder = GWT.create(gwt_class_22.TestViewUiBinder.class);

    interface TestViewUiBinder extends UiBinder<VerticalPanel, gwt_class_22> {}

    @UiField
    Label testObjectStringLabel;

    @UiField
    Label innerObjectStringLabel;

    @UiField
    VerticalPanel listObjectsPanel;

    @UiField
    Button button;

    @UiField
    Label errorMessageLabel;

    public gwt_class_22(java.lang.String firstName) {
        initWidget(gwt_class_22.uiBinder.createAndBindUi(this));
    }

    @UiHandler("button")
    void onClick(ClickEvent e) {
    }
}

