public class gwt_class_47 implements com.google.gwt.core.client.EntryPoint {
    private static final com.google.gwt.dom.client.Style.Unit PCT = null;

    @java.lang.Override
    public void onModuleLoad() {
        com.google.gwt.user.client.ui.Widget childone = new com.google.gwt.user.client.ui.HTML("left");
        com.google.gwt.user.client.ui.Widget childtwo = new com.google.gwt.user.client.ui.HTML("right");
        com.google.gwt.user.client.ui.LayoutPanel p = new com.google.gwt.user.client.ui.LayoutPanel();
        p.add(childone);
        p.add(childtwo);
        p.setWidgetLeftWidth(childone, 0, gwt_class_47.PCT, 50, gwt_class_47.PCT);
        p.setWidgetRightWidth(childtwo, 0, gwt_class_47.PCT, 50, gwt_class_47.PCT);
        com.google.gwt.user.client.ui.RootLayoutPanel rp = com.google.gwt.user.client.ui.RootLayoutPanel.get();
        rp.add(p);
    }
}

