public class gwt_class_25 {
    public void onModuleLoad() {
        final com.google.gwt.user.client.ui.Button sendButton = new com.google.gwt.user.client.ui.Button("Send");
        final com.google.gwt.user.client.ui.TextBox nameField = new com.google.gwt.user.client.ui.TextBox();
        nameField.setText("GWT User");
        final com.google.gwt.user.client.ui.Label errorLabel = new com.google.gwt.user.client.ui.Label();
        // We can add style names to widgets
        sendButton.addStyleName("sendButton");
        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        com.google.gwt.user.client.ui.RootPanel.get("nameFieldContainer").add(nameField);
        com.google.gwt.user.client.ui.RootPanel.get("sendButtonContainer").add(sendButton);
        com.google.gwt.user.client.ui.RootPanel.get("errorLabelContainer").add(errorLabel);
        // Focus the cursor on the name field when the app loads
        nameField.setFocus(true);
        nameField.selectAll();
        // Create the popup dialog box
        final com.google.gwt.user.client.ui.DialogBox dialogBox = new com.google.gwt.user.client.ui.DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);
        final com.google.gwt.user.client.ui.Button closeButton = new com.google.gwt.user.client.ui.Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        final com.google.gwt.user.client.ui.Label textToServerLabel = new com.google.gwt.user.client.ui.Label();
        final com.google.gwt.user.client.ui.HTML serverResponseLabel = new com.google.gwt.user.client.ui.HTML();
        com.google.gwt.user.client.ui.VerticalPanel dialogVPanel = new com.google.gwt.user.client.ui.VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new com.google.gwt.user.client.ui.HTML("<b>Sending name to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new com.google.gwt.user.client.ui.HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);
        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                dialogBox.hide();
                sendButton.setEnabled(true);
                sendButton.setFocus(true);
            }
        });
        // Create a handler for the sendButton and nameField
        class MyHandler implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.KeyUpHandler {
            /**
             * Fired when the user clicks on the sendButton.
             */
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                sendNameToServer();
            }

            /**
             * Fired when the user types in the nameField.
             */
            public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
                if (event.getNativeKeyCode() == com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER) {
                    sendNameToServer();
                }
            }

            /**
             * Send the name from the nameField to the server and wait for a response.
             */
            private void sendNameToServer() {
                // First, we validate the input.
                errorLabel.setText("");
                java.lang.String textToServer = nameField.getText();
                // if (!FieldVerifier.isValidName(textToServer)) {
                // errorLabel.setText("Please enter at least four characters");
                // return;
                // }
                // Then, we send the input to the server.
                sendButton.setEnabled(false);
                textToServerLabel.setText(textToServer);
                serverResponseLabel.setText("");
                // greetingService.greetServer(textToServer,
                // new AsyncCallback<String>() {
                // public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
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
        sendButton.addClickHandler(handler);
        nameField.addKeyUpHandler(handler);
    }
}

