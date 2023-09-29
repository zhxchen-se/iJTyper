public class gwt_class_3 implements com.google.gwt.core.client.EntryPoint {
  private static final java.lang.String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection and try again.";

  // private final RPCCallsServiceAsync rpccallService = GWT.create(RPCCallsService.class);
  com.google.gwt.user.client.ui.TextBox nameTxt = new com.google.gwt.user.client.ui.TextBox();

  com.google.gwt.user.client.ui.Button btnSave = gwt_class_3.getBtnSave();

  public void onModuleLoad() {
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.TextBox)
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.Button)
  }

  private com.google.gwt.user.client.ui.Button getBtnSave() {
    com.google.gwt.user.client.ui.Button btnSave = new com.google.gwt.user.client.ui.Button("SAVE");
    return btnSave;
  }

  void saveData2DB(java.lang.String name) {
    com.google.gwt.user.client.rpc.AsyncCallback<java.lang.String> callback = new com.google.gwt.user.client.rpc.AsyncCallback<java.lang.String>() {
      public void onFailure(java.lang.Throwable caught) {
        com.google.gwt.user.client.Window.alert(java.lang.String)
        // TODO: Do something with errors.
      }

      public void onSuccess(java.lang.String result) {
        com.google.gwt.user.client.Window.alert(java.lang.String)
      }
    };
    // ArrayList<Address> aa = new ArrayList<Address>();
    // aa.add(new Address("123 sasdf","", "Some City", "AZ", "93923-2321"));
    // aa.add(new Address("23432 asdf", "Appt 34", "Another City", "AZ", "43434-4432"));
    // 
    // Person p = new Person();
    // p.setName(name);
    // p.setAge(23);
    // p.setGender('m');
    // p.setAddresses(aa);
    // 
    // // !!!!!!!!!!!!!!!!!!  SERVER CALL !!!!!!!!!!!!!!!!!!
    // rpccallService.saveName(p, callback);
    // // !!!!!!!!!!!!!!!!!!  SERVER CALL !!!!!!!!!!!!!!!!!!
  }
}
