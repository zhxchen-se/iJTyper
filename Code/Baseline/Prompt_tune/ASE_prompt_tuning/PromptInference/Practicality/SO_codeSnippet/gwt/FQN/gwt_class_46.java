public class gwt_class_46 {
    public static void main(java.lang.String[] arg) {
        com.google.gwt.user.client.ui.VerticalPanel eventDetailWindow = new com.google.gwt.user.client.ui.VerticalPanel();
        final com.google.gwt.user.client.ui.DialogBox dialogBox2 = new com.google.gwt.user.client.ui.DialogBox();
        dialogBox2.setText("Event Detail");
        dialogBox2.setAnimationEnabled(true);
        final com.google.gwt.user.client.ui.HTML serverResponse3 = new com.google.gwt.user.client.ui.HTML("<b> ok, this is working</b>");
        serverResponse3.addStyleName("detailView");
        eventDetailWindow.add(serverResponse3);
        eventDetailWindow.addStyleName("detailWindow");
        dialogBox2.setWidget(eventDetailWindow);
        com.google.gwt.user.client.ui.RootPanel.get("detailWindow").add(eventDetailWindow);
    }
}

