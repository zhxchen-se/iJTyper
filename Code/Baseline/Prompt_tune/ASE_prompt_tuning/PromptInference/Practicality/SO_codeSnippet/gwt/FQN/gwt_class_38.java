public class gwt_class_38 {
    public class AdminMenuAreaView extends com.google.gwt.user.client.ui.Composite {
        private com.google.gwt.user.client.ui.VerticalPanel vPanel;

        private com.google.gwt.user.client.ui.Hyperlink registerUserLink;

        public AdminMenuAreaView() {
            vPanel = new com.google.gwt.user.client.ui.VerticalPanel();
            initWidget(vPanel);
        }

        public com.google.gwt.user.client.ui.Widget asWidget() {
            return this;
        }

        public void addLink(java.lang.String s) {
            registerUserLink = new com.google.gwt.user.client.ui.Hyperlink(s, "this is new target");
            this.vPanel.add(registerUserLink);
            registerUserLink.setVisible(true);
        }

        public com.google.gwt.event.dom.client.HasClickHandlers getRegisterUserLink() {
            return registerUserLink;
        }
    }
}

