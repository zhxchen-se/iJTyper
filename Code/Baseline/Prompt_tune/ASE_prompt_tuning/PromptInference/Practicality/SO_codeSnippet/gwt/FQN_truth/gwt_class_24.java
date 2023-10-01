public class gwt_class_24 {
    public abstract class AbstractNotificationWidget extends Composite implements ClickHandler , HasClickHandlers {
        protected abstract java.lang.String getUniqueId();

        @java.lang.Override
        public HandlerRegistration addClickHandler(ClickHandler handler) {
            return addDomHandler(handler, ClickEvent.getType());
        }

        @java.lang.Override
        public void onClick(ClickEvent event) {
            doClick(getUniqueId());
        }

        protected native void doClick(java.lang.String name);
    }

    public class ErrorNotificationWidget extends gwt_class_24.AbstractNotificationWidget {
        private final java.lang.String uniqueId;

        public ErrorNotificationWidget(java.lang.String title, java.lang.String message) {
            uniqueId = DOM.createUniqueId();
            Widget w = null;
            initWidget(w);
            this.getElement().setId(uniqueId);
            this.addClickHandler(this);
        }

        @java.lang.Override
        protected java.lang.String getUniqueId() {
            return this.uniqueId;
        }
    }
}

