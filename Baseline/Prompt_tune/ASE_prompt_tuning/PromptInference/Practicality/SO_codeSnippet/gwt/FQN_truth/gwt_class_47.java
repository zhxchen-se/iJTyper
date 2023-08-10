public class gwt_class_47 implements EntryPoint {
    private static final Unit PCT = null;

    @java.lang.Override
    public void onModuleLoad() {
        Widget childone = new HTML("left");
        Widget childtwo = new HTML("right");
        LayoutPanel p = new LayoutPanel();
        p.add(childone);
        p.add(childtwo);
        p.setWidgetLeftWidth(childone, 0, gwt_class_47.PCT, 50, gwt_class_47.PCT);
        p.setWidgetRightWidth(childtwo, 0, gwt_class_47.PCT, 50, gwt_class_47.PCT);
        RootLayoutPanel rp = RootLayoutPanel.get();
        rp.add(p);
    }
}

