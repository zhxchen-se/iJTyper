public class gwt_class_19 {
    private void addStartupBox() {
        com.extjs.gxt.ui.client.widget.VerticalPanel boxPanel = null;
        com.google.gwt.user.client.ui.Label title = null;
        // Create second panel for the content of a box
        com.google.gwt.user.client.ui.VerticalPanel boxContent = new com.google.gwt.user.client.ui.VerticalPanel();
        boxContent.setSpacing(10);
        boxContent.setHorizontalAlignment(com.extjs.gxt.ui.client.widget.VerticalPanel);
        // Create content for the box
        com.extjs.gxt.ui.client.widget.button.Button but1 = new com.extjs.gxt.ui.client.widget.button.Button("A");
        but1.setPixelSize(280, 25);
        com.extjs.gxt.ui.client.widget.button.Button but2 = new com.extjs.gxt.ui.client.widget.button.Button("B");
        but2.setPixelSize(280, 25);
        com.extjs.gxt.ui.client.widget.button.Button but3 = new com.extjs.gxt.ui.client.widget.button.Button("C");
        but3.setPixelSize(280, 25);
        // Add buttons to boxContent
        boxContent.add(but1);
        boxContent.add(but2);
        boxContent.add(but3);
        // Add title and boxContent to boxPanel
        boxPanel.add(title);
        boxPanel.add(boxContent);
        com.google.gwt.user.client.ui.RootPanel.get("boxPanelContainer").add(boxPanel);
    }
}

