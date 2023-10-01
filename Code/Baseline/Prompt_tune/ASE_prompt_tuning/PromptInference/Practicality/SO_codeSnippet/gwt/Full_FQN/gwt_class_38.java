public class gwt_class_38 {
  public class AdminMenuAreaView extends com.google.gwt.user.client.ui.Composite {
    private com.google.gwt.user.client.ui.VerticalPanel vPanel;

    private com.google.gwt.user.client.ui.Hyperlink registerUserLink;

    public AdminMenuAreaView() {
      vPanel = new com.google.gwt.user.client.ui.VerticalPanel();
      <unknown>.initWidget(<unknown>)
    }

    public com.google.gwt.user.client.ui.Widget asWidget() {
      return this;
    }

    public void addLink(java.lang.String s) {
      registerUserLink = new com.google.gwt.user.client.ui.Hyperlink(s, "this is new target");
      com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Hyperlink)
      com.google.gwt.user.client.ui.Hyperlink.setVisible(boolean)
    }

    public com.google.gwt.event.dom.client.HasClickHandlers getRegisterUserLink() {
      return registerUserLink;
    }
  }
}
