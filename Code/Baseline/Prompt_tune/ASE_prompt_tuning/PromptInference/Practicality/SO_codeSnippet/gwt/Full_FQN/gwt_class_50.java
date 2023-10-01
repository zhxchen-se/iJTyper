public class gwt_class_50 {
  public class ListItem extends com.google.gwt.user.client.ui.ComplexPanel implements com.google.gwt.user.client.ui.HasText , com.google.gwt.user.client.ui.HasHTML , com.google.gwt.event.dom.client.HasClickHandlers , com.google.gwt.event.dom.client.HasKeyDownHandlers , com.google.gwt.event.dom.client.HasBlurHandlers {
    com.google.gwt.event.shared.HandlerRegistration clickHandler;

    public ListItem() {
      <unknown>.setElement(<unknown>)
    }

    public void add(com.google.gwt.user.client.ui.Widget w) {
      com.google.gwt.user.client.ui.ComplexPanel.add(com.google.gwt.user.client.ui.Widget)
    }

    public void insert(com.google.gwt.user.client.ui.Widget w, int beforeIndex) {
      com.google.gwt.user.client.ui.ComplexPanel.insert(com.google.gwt.user.client.ui.Widget,int,boolean)
    }

    public java.lang.String getText() {
      return com.google.gwt.user.client.DOM.getInnerText();
    }

    public void setText(java.lang.String text) {
      com.google.gwt.user.client.DOM.setInnerText()
    }

    public void setId(java.lang.String id) {
      com.google.gwt.user.client.DOM.setElementAttribute(java.lang.String,java.lang.String)
    }

    public java.lang.String getHTML() {
      return com.google.gwt.user.client.DOM.getInnerHTML();
    }

    public void setHTML(java.lang.String html) {
      com.google.gwt.user.client.DOM.setInnerHTML()
    }

    public com.google.gwt.event.shared.HandlerRegistration addClickHandler(com.google.gwt.event.dom.client.ClickHandler handler) {
      return <unknown>.addDomHandler(<unknown>,<unknown>);
    }

    public com.google.gwt.event.shared.HandlerRegistration addKeyDownHandler(com.google.gwt.event.dom.client.KeyDownHandler handler) {
      return <unknown>.addDomHandler(<unknown>,<unknown>);
    }

    public com.google.gwt.event.shared.HandlerRegistration addBlurHandler(com.google.gwt.event.dom.client.BlurHandler handler) {
      return <unknown>.addDomHandler(<unknown>,<unknown>);
    }
  }
}
