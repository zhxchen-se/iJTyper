public class gwt_class_3 implements EntryPoint {
    private static final java.lang.String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection and try again.";

    TextBox nameTxt = new TextBox();

    Button btnSave = getBtnSave();

    public void onModuleLoad() {
        RootPanel.get("inputName").add(nameTxt);
        RootPanel.get("btnSave").add(btnSave);
    }

    private Button getBtnSave() {
        Button btnSave = new Button("SAVE");
        return btnSave;
    }

    void saveData2DB(java.lang.String name) {
        AsyncCallback<java.lang.String> callback = new AsyncCallback<java.lang.String>() {
            public void onFailure(java.lang.Throwable caught) {
                Window.alert("WOOOHOOO, ERROR: " + gwt_class_3.SERVER_ERROR);
            }

            public void onSuccess(java.lang.String result) {
                Window.alert(("Server is saying: ' " + result) + "'");
            }
        };
    }
}

