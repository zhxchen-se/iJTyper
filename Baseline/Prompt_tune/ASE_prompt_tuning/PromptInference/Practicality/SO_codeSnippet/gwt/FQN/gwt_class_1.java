public class gwt_class_1 extends com.google.gwt.user.client.ui.Composite implements com.google.gwt.event.dom.client.MouseDownHandler {
    com.google.gwt.user.client.ui.AbsolutePanel abs = new com.google.gwt.user.client.ui.AbsolutePanel();

    public gwt_class_1(int width) {
        java.lang.System.out.println("MousyAbsolutePanel being created with width:" + width);
        initWidget(abs);
        abs.setWidth(java.lang.String.valueOf(width));
        abs.setHeight("100%");
        abs.setStyleName("mousyAbsolutePanel");
    }

    public void onMouseDown(com.google.gwt.event.dom.client.MouseDownEvent event) {
        java.lang.System.out.println("onMouseDown()");
    }
}

