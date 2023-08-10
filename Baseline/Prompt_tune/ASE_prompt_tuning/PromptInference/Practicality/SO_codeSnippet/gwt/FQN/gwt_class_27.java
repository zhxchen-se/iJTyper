public class gwt_class_27 {
    public static void main(java.lang.String[] arg) {
        final com.google.gwt.user.client.ui.Button sendButton = new com.google.gwt.user.client.ui.Button("Send");
        sendButton.getElement().setId("button");
        com.google.gwt.user.client.ui.RootPanel.get().getElement().appendChild(sendButton.getElement());
        com.google.gwt.dom.client.NodeList buttonElement = com.google.gwt.dom.client.Document.get().getElementsByTagName("button");
        if ((buttonElement != null) && (buttonElement.getLength() > 0)) {
            buttonElement.getItem(0).setNodeValue("Changed");
        } else {
            com.google.gwt.core.client.GWT.log("Can't select button");
        }
    }
}

