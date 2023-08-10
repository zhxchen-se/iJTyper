public class gwt_class_50 {
    public class ListItem extends ComplexPanel implements HasText , HasHTML , HasClickHandlers , HasKeyDownHandlers , HasBlurHandlers {
        HandlerRegistration clickHandler;

        public ListItem() {
            setElement(DOM.createElement("LI"));
        }

        public void add(Widget w) {
            super.add(w, getElement());
        }

        public void insert(Widget w, int beforeIndex) {
            super.insert(w, getElement(), beforeIndex, true);
        }

        public java.lang.String getText() {
            return DOM.getInnerText(getElement());
        }

        public void setText(java.lang.String text) {
            DOM.setInnerText(getElement(), text == null ? "" : text);
        }

        public void setId(java.lang.String id) {
            DOM.setElementAttribute(getElement(), "id", id);
        }

        public java.lang.String getHTML() {
            return DOM.getInnerHTML(getElement());
        }

        public void setHTML(java.lang.String html) {
            DOM.setInnerHTML(getElement(), html == null ? "" : html);
        }

        public HandlerRegistration addClickHandler(ClickHandler handler) {
            return addDomHandler(handler, ClickEvent.getType());
        }

        public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
            return addDomHandler(handler, KeyDownEvent.getType());
        }

        public HandlerRegistration addBlurHandler(BlurHandler handler) {
            return addDomHandler(handler, BlurEvent.getType());
        }
    }
}

