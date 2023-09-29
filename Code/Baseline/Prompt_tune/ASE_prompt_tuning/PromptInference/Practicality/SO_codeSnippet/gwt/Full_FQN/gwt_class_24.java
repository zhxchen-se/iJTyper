public class gwt_class_24 {
  public abstract class AbstractNotificationWidget extends com.google.gwt.user.client.ui.Composite implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.HasClickHandlers {
    protected abstract java.lang.String getUniqueId();

    @java.lang.Override
    public com.google.gwt.event.shared.HandlerRegistration addClickHandler(com.google.gwt.event.dom.client.ClickHandler handler) {
      return <unknown>.addDomHandler(<unknown>,<unknown>);
    }

    @java.lang.Override
    public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
      gwt_class_24$AbstractNotificationWidget.doClick(java.lang.String)
    }

    /* -{
    $wnd.$("#" + name).click(function () {
    $wnd.$(this).slideUp("slow");
    $wnd.$("div", this).fadeOut("slow");
    });
    }-
     */
    protected native void doClick(java.lang.String name);
  }

  public class ErrorNotificationWidget extends gwt_class_24.AbstractNotificationWidget {
    private final java.lang.String uniqueId;

    public ErrorNotificationWidget(java.lang.String title, java.lang.String message) {
      uniqueId = com.google.gwt.user.client.DOM.createUniqueId();
      com.google.gwt.user.client.ui.Widget w = null;
      <unknown>.initWidget(<unknown>)
      <unknown>.getElement()###<unknown>.setId(java.lang.String)
      gwt_class_24$AbstractNotificationWidget.addClickHandler(com.google.gwt.event.dom.client.ClickHandler)
    }

    @java.lang.Override
    protected java.lang.String getUniqueId() {
      return this.uniqueId;
    }
  }
}
