public class gwt_class_36 {
    public static void main(java.lang.String[] arg) {
        int width = 200;
        int height = 200;
        int overHeight = 40;
        AbsolutePanel absPanel = new AbsolutePanel();
        absPanel.setSize(width + "px", height + "px");
        SimplePanel underPanel = new SimplePanel();
        underPanel.setWidth(width + "px");
        underPanel.setHeight(height + "px");
        underPanel.getElement().getStyle().setBackgroundColor("red");
        SimplePanel overPanel = new SimplePanel();
        overPanel.setWidth(width + "px");
        overPanel.setHeight(overHeight + "px");
        overPanel.getElement().getStyle().setBackgroundColor("black");
        overPanel.getElement().getStyle().setProperty("filter", "alpha(opacity=20)");
        absPanel.add(underPanel, 0, 0);
        absPanel.add(overPanel, 0, 0);
        RootPanel.get("test").add(absPanel);
        absPanel.getElement().getStyle().setProperty("filter", "alpha(opacity=100)");
    }
}

