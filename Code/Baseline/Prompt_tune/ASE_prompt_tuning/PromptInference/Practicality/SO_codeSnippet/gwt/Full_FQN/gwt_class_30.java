public class gwt_class_30 {
  static com.google.gwt.user.client.ui.TextBox firstName = new com.google.gwt.user.client.ui.TextBox();

  static com.google.gwt.user.client.ui.TextBox surName = new com.google.gwt.user.client.ui.TextBox();

  static com.google.gwt.user.client.ui.DialogBox box;

  public static com.google.gwt.user.client.ui.DialogBox buildNewElecPopup() {
    com.google.gwt.user.client.ui.DialogBox box = new com.google.gwt.user.client.ui.DialogBox();
    com.google.gwt.user.client.ui.DialogBox.setAutoHideEnabled(boolean)
    com.google.gwt.user.client.ui.DialogBox.setText(java.lang.String)
    com.google.gwt.user.client.ui.DialogBox.setAnimationEnabled(boolean)
    com.google.gwt.user.client.ui.DialogBox.setGlassEnabled(boolean)
    com.google.gwt.user.client.ui.Grid dialogGrid = new com.google.gwt.user.client.ui.Grid(2, 3);
    com.google.gwt.user.client.ui.Grid.setPixelSize(int,int)
    com.google.gwt.user.client.ui.Grid.setCellPadding(int)
    com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.TextBox)
    com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.TextBox)
    com.google.gwt.user.client.ui.DialogBox.add(com.google.gwt.user.client.ui.Grid)
    return box;
  }
}
