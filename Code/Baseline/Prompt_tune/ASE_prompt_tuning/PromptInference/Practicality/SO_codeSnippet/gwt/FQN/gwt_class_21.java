public class gwt_class_21 {
    private static class PopUpPanel extends com.google.gwt.user.client.ui.PopupPanel {
        com.google.gwt.user.client.ui.Button connect = new com.google.gwt.user.client.ui.Button("Connect");

        com.google.gwt.user.client.ui.Button delete = new com.google.gwt.user.client.ui.Button("Delete");

        com.google.gwt.user.client.ui.Button detail = new com.google.gwt.user.client.ui.Button("Detail");

        public PopUpPanel(final com.google.gwt.user.client.ui.Widget widget) {
            super(true);
            com.google.gwt.user.client.ui.VerticalPanel vp = new com.google.gwt.user.client.ui.VerticalPanel();
            vp.add(connect);
            vp.add(delete);
            vp.add(detail);
            setWidget(vp);
        }
    }
}

