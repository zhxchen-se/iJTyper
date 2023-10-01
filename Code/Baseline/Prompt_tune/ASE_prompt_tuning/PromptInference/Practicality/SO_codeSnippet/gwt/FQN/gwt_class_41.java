public class gwt_class_41 {
    public class DownloadFilePanel extends com.google.gwt.user.client.ui.Composite {
        public DownloadFilePanel(final java.lang.String fileName) {
            final com.google.gwt.dom.client.Element downloadIframe = com.google.gwt.user.client.ui.RootPanel.get("__download").getElement();
            com.google.gwt.user.client.ui.VerticalPanel content = new com.google.gwt.user.client.ui.VerticalPanel();
            content.add(new com.google.gwt.user.client.ui.Label("Download For this File : " + fileName));
            com.google.gwt.user.client.ui.Button button = new com.google.gwt.user.client.ui.Button("Download");
            button.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
                @java.lang.Override
                public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                    // i do not know what to do here
                }
            });
        }
    }
}

