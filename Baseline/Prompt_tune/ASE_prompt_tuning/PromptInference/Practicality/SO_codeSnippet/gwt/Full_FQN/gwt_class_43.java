public class gwt_class_43 {
  public class GroupLbl extends com.google.gwt.user.client.ui.Composite implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.MouseOutHandler {
    private com.google.gwt.user.client.ui.Label lbl;

    // private GroupLblHandler lblHandler = null;
    private com.google.gwt.user.client.ui.HorizontalPanel hp;

    public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
      com.google.gwt.user.client.ui.HorizontalPanel.setStyleName(java.lang.String)
      java.lang.Object folder = null;
      if (com.google.gwt.event.dom.client.ClickEvent.getSource()###<unknown>.equals(java.lang.Object) || com.google.gwt.event.dom.client.ClickEvent.getSource()###<unknown>.equals(com.google.gwt.user.client.ui.Label)) {
        // lblHandler.onGroupLabelSelect(this);
      }
    }

    @java.lang.Override
    public com.google.gwt.user.client.ui.Widget getWidget() {
      return hp;
    }

    public void onMouseOut(com.google.gwt.event.dom.client.MouseOutEvent event) {
      com.google.gwt.user.client.ui.HorizontalPanel.removeStyleName(java.lang.String)
    }
  }
}
