public class gwt_class_1 extends Composite implements MouseDownHandler {
    AbsolutePanel abs = new AbsolutePanel();

    public gwt_class_1(int width) {
        java.lang.System.out.println("MousyAbsolutePanel being created with width:" + width);
        initWidget(abs);
        abs.setWidth(java.lang.String.valueOf(width));
        abs.setHeight("100%");
        abs.setStyleName("mousyAbsolutePanel");
    }

    public void onMouseDown(MouseDownEvent event) {
        java.lang.System.out.println("onMouseDown()");
    }
}

