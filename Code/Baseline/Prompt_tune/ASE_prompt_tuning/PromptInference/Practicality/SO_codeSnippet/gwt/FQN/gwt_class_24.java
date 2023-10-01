public class gwt_class_24 {
    public abstract class AbstractNotificationWidget extends com.google.gwt.user.client.ui.Composite implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.HasClickHandlers {
        protected abstract java.lang.String getUniqueId();

        @java.lang.Override
        public com.google.gwt.event.shared.HandlerRegistration addClickHandler(com.google.gwt.event.dom.client.ClickHandler handler) {
            return addDomHandler(handler, com.google.gwt.event.dom.client.ClickEvent.getType());
        }

        @java.lang.Override
        public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
            doClick(getUniqueId());
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

