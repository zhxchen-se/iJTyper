public class gwt_class_30 {
    static com.google.gwt.user.client.ui.TextBox firstName = new com.google.gwt.user.client.ui.TextBox();

    static com.google.gwt.user.client.ui.TextBox surName = new com.google.gwt.user.client.ui.TextBox();

    static com.google.gwt.user.client.ui.DialogBox box;

    public static com.google.gwt.user.client.ui.DialogBox buildNewElecPopup() {
        com.google.gwt.user.client.ui.DialogBox box = new com.google.gwt.user.client.ui.DialogBox();
        box.setAutoHideEnabled(true);
        box.setText("Add a New Candidate");
        box.setAnimationEnabled(true);
        box.setGlassEnabled(true);
        com.google.gwt.user.client.ui.Grid dialogGrid = new com.google.gwt.user.client.ui.Grid(2, 3);
        dialogGrid.setPixelSize(250, 125);
        dialogGrid.setCellPadding(10);
        dialogGrid.setWidget(0, 0, new com.google.gwt.user.client.ui.HTML("<strong>First Name</strong>"));
        dialogGrid.setWidget(0, 1, gwt_class_30.firstName);
        dialogGrid.setWidget(1, 0, new com.google.gwt.user.client.ui.HTML("<strong>Surname</strong>"));
        dialogGrid.setWidget(1, 1, gwt_class_30.surName);
        box.add(dialogGrid);
        return box;
    }
}

