public class gwt_class_43 {
    public class GroupLbl extends Composite implements ClickHandler , MouseOutHandler {
        private Label lbl;

        private HorizontalPanel hp;

        public void onClick(ClickEvent event) {
            hp.setStyleName("background-GroupLbl");
            java.lang.Object folder = null;
            if (event.getSource().equals(folder) || event.getSource().equals(lbl)) {
            }
        }

        @java.lang.Override
        public Widget getWidget() {
            return hp;
        }

        public void onMouseOut(MouseOutEvent event) {
            hp.removeStyleName("background-GroupLbl");
        }
    }
}

