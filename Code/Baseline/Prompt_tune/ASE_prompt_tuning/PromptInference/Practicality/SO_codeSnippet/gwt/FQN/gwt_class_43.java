public class gwt_class_43 {
    public class GroupLbl extends com.google.gwt.user.client.ui.Composite implements com.google.gwt.event.dom.client.ClickHandler , com.google.gwt.event.dom.client.MouseOutHandler {
        private com.google.gwt.user.client.ui.Label lbl;

        // private GroupLblHandler lblHandler = null;
        private com.google.gwt.user.client.ui.HorizontalPanel hp;

        public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
            hp.setStyleName("background-GroupLbl");
            java.lang.Object folder = null;
            if (event.getSource().equals(folder) || event.getSource().equals(lbl)) {
                // lblHandler.onGroupLabelSelect(this);
            }
        }

        @java.lang.Override
        public com.google.gwt.user.client.ui.Widget getWidget() {
            return hp;
        }

        public void onMouseOut(com.google.gwt.event.dom.client.MouseOutEvent event) {
            hp.removeStyleName("background-GroupLbl");
        }
    }
}

