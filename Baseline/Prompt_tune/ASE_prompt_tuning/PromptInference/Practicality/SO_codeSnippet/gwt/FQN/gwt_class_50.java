public class gwt_class_50 {
    public class ListItem extends com.google.gwt.user.client.ui.ComplexPanel implements com.google.gwt.user.client.ui.HasText , com.google.gwt.user.client.ui.HasHTML , com.google.gwt.event.dom.client.HasClickHandlers , com.google.gwt.event.dom.client.HasKeyDownHandlers , com.google.gwt.event.dom.client.HasBlurHandlers {
        com.google.gwt.event.shared.HandlerRegistration clickHandler;

        public ListItem() {
            setElement(com.google.gwt.user.client.DOM.createElement("LI"));
        }

        public void add(com.google.gwt.user.client.ui.Widget w) {
            super.add(w, getElement());
        }

        public void insert(com.google.gwt.user.client.ui.Widget w, int beforeIndex) {
            super.insert(w, getElement(), beforeIndex, true);
        }

        public java.lang.String getText() {
            return com.google.gwt.user.client.DOM.getInnerText(getElement());
        }

        public void setText(java.lang.String text) {
            com.google.gwt.user.client.DOM.setInnerText(getElement(), text == null ? "" : text);
        }

        public void setId(java.lang.String id) {
            com.google.gwt.user.client.DOM.setElementAttribute(getElement(), "id", id);
        }

        public java.lang.String getHTML() {
            return com.google.gwt.user.client.DOM.getInnerHTML(getElement());
        }

        public void setHTML(java.lang.String html) {
            com.google.gwt.user.client.DOM.setInnerHTML(getElement(), html == null ? "" : html);
        }

        public com.google.gwt.event.shared.HandlerRegistration addClickHandler(com.google.gwt.event.dom.client.ClickHandler handler) {
            return addDomHandler(handler, com.google.gwt.event.dom.client.ClickEvent.getType());
        }

        public com.google.gwt.event.shared.HandlerRegistration addKeyDownHandler(com.google.gwt.event.dom.client.KeyDownHandler handler) {
            return addDomHandler(handler, com.google.gwt.event.dom.client.KeyDownEvent.getType());
        }

        public com.google.gwt.event.shared.HandlerRegistration addBlurHandler(com.google.gwt.event.dom.client.BlurHandler handler) {
            return addDomHandler(handler, com.google.gwt.event.dom.client.BlurEvent.getType());
        }
    }
}

