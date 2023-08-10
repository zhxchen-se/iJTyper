public class gwt_class_38 {
    public class AdminMenuAreaView extends Composite {
        private VerticalPanel vPanel;

        private Hyperlink registerUserLink;

        public AdminMenuAreaView() {
            vPanel = new VerticalPanel();
            initWidget(vPanel);
        }

        public Widget asWidget() {
            return this;
        }

        public void addLink(java.lang.String s) {
            registerUserLink = new Hyperlink(s, "this is new target");
            this.vPanel.add(registerUserLink);
            registerUserLink.setVisible(true);
        }

        public HasClickHandlers getRegisterUserLink() {
            return registerUserLink;
        }
    }
}

