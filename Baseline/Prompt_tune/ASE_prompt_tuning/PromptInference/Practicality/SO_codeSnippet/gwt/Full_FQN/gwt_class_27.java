public class gwt_class_27 {
  public static void main(java.lang.String[] arg) {
    final com.google.gwt.user.client.ui.Button sendButton = new com.google.gwt.user.client.ui.Button("Send");
    com.google.gwt.user.client.ui.Button.getElement()###<unknown>.setId(java.lang.String)
    com.google.gwt.user.client.ui.RootPanel.get()###<unknown>.getElement()###<unknown>.appendChild()
    com.google.gwt.dom.client.NodeList buttonElement = com.google.gwt.dom.client.Document.get()###<unknown>.getElementsByTagName(java.lang.String);
    if ((buttonElement != null) && (com.google.gwt.dom.client.NodeList.getLength() > 0)) {
      com.google.gwt.dom.client.NodeList.getItem(int)###<unknown>.setNodeValue(java.lang.String)
    } else {
      com.google.gwt.core.client.GWT.log(java.lang.String)
    }
  }
}
