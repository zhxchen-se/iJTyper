public class gwt_class_25 {
  public void onModuleLoad() {
    final com.google.gwt.user.client.ui.Button sendButton = new com.google.gwt.user.client.ui.Button("Send");
    final com.google.gwt.user.client.ui.TextBox nameField = new com.google.gwt.user.client.ui.TextBox();
    com.google.gwt.user.client.ui.TextBox.setText(java.lang.String)
    final com.google.gwt.user.client.ui.Label errorLabel = new com.google.gwt.user.client.ui.Label();
    com.google.gwt.user.client.ui.Button.addStyleName(java.lang.String)
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.TextBox)
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.Label)
    com.google.gwt.user.client.ui.TextBox.setFocus(boolean)
    com.google.gwt.user.client.ui.TextBox.selectAll()
    // Create the popup dialog box
    final com.google.gwt.user.client.ui.DialogBox dialogBox = new com.google.gwt.user.client.ui.DialogBox();
    com.google.gwt.user.client.ui.DialogBox.setText(java.lang.String)
    com.google.gwt.user.client.ui.DialogBox.setAnimationEnabled(boolean)
    final com.google.gwt.user.client.ui.Button closeButton = new com.google.gwt.user.client.ui.Button("Close");
    com.google.gwt.user.client.ui.Button.getElement()###<unknown>.setId(java.lang.String)
    final com.google.gwt.user.client.ui.Label textToServerLabel = new com.google.gwt.user.client.ui.Label();
    final com.google.gwt.user.client.ui.HTML serverResponseLabel = new com.google.gwt.user.client.ui.HTML();
    com.google.gwt.user.client.ui.VerticalPanel dialogVPanel = new com.google.gwt.user.client.ui.VerticalPanel();
    com.google.gwt.user.client.ui.VerticalPanel.addStyleName(java.lang.String)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Label)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.VerticalPanel.setHorizontalAlignment()
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.DialogBox.setWidget(com.google.gwt.user.client.ui.VerticalPanel)
    com.google.gwt.user.client.ui.Button.addClickHandler(gwt_class_25$1)
    // Create a handler for the sendButton and nameField
    class MyHandler implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.KeyUpHandler {
      /**
       * Fired when the user clicks on the sendButton.
       */
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        gwt_class_25$1MyHandler.sendNameToServer()
      }

      /**
       * Fired when the user types in the nameField.
       */
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        if (com.google.gwt.event.dom.client.KeyUpEvent.getNativeKeyCode() == com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER) {
          gwt_class_25$1MyHandler.sendNameToServer()
        }
      }

      /**
       * Send the name from the nameField to the server and wait for a response.
       */
      private void sendNameToServer() {
        com.google.gwt.user.client.ui.Label.setText(java.lang.String)
        java.lang.String textToServer = com.google.gwt.user.client.ui.TextBox.getText();
        com.google.gwt.user.client.ui.Button.setEnabled(boolean)
        com.google.gwt.user.client.ui.Label.setText(java.lang.String)
        com.google.gwt.user.client.ui.HTML.setText(java.lang.String)
        // greetingService.greetServer(textToServer,
        // new AsyncCallback<String>() {
        // public void onFailure(Throwable caught) {
        // // Show the RPC error message to the user
        // dialogBox
        // .setText("Remote Procedure Call - Failure");
        // serverResponseLabel
        // .addStyleName("serverResponseLabelError");
        // serverResponseLabel.setHTML(SERVER_ERROR);
        // dialogBox.center();
        // closeButton.setFocus(true);
        // }
        // 
        // public void onSuccess(String result) {
        // dialogBox.setText("Remote Procedure Call");
        // serverResponseLabel
        // .removeStyleName("serverResponseLabelError");
        // serverResponseLabel.setHTML(result);
        // dialogBox.center();
        // closeButton.setFocus(true);
        // }
        // });
      }
    }
    // Add a handler to send the name to the server
    MyHandler handler = new MyHandler();
    com.google.gwt.user.client.ui.Button.addClickHandler(gwt_class_25$1MyHandler)
    com.google.gwt.user.client.ui.TextBox.addKeyUpHandler(gwt_class_25$1MyHandler)
  }
}
