public class gwt_class_19 {
    private void addStartupBox() {
        VerticalPanel boxPanel = null;
        com.google.gwt.user.client.ui.Label title = null;
        com.google.gwt.user.client.ui.VerticalPanel boxContent = new com.google.gwt.user.client.ui.VerticalPanel();
        boxContent.setSpacing(10);
        boxContent.setHorizontalAlignment(VerticalPanel);
        Button but1 = new Button("A");
        but1.setPixelSize(280, 25);
        Button but2 = new Button("B");
        but2.setPixelSize(280, 25);
        Button but3 = new Button("C");
        but3.setPixelSize(280, 25);
        boxContent.add(but1);
        boxContent.add(but2);
        boxContent.add(but3);
        boxPanel.add(title);
        boxPanel.add(boxContent);
        RootPanel.get("boxPanelContainer").add(boxPanel);
    }
}

