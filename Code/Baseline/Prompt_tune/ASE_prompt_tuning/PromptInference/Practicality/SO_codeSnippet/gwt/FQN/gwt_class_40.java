public class gwt_class_40 {
    private com.google.gwt.user.client.ui.HorizontalPanel getSomeGWT() {
        com.google.gwt.user.client.ui.HorizontalPanel pointsLogoPanel = new com.google.gwt.user.client.ui.HorizontalPanel();
        for (int i = 0; i < 350; i++) {
            com.google.gwt.user.client.ui.HorizontalPanel innerContainer = new com.google.gwt.user.client.ui.HorizontalPanel();
            innerContainer.add(new com.google.gwt.user.client.ui.Label("some GWT text"));
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }

    private com.extjs.gxt.ui.client.widget.LayoutContainer getSomeGXT() {
        com.extjs.gxt.ui.client.widget.LayoutContainer pointsLogoPanel = new com.extjs.gxt.ui.client.widget.LayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i = 0; i < 350; i++) {
            com.extjs.gxt.ui.client.widget.LayoutContainer innerContainer = new com.extjs.gxt.ui.client.widget.LayoutContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}

