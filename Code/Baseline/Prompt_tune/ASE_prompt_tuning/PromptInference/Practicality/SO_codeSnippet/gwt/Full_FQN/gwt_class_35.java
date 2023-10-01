public class gwt_class_35 {
  public class Scroller extends com.google.gwt.animation.client.Animation {
    private com.google.gwt.user.client.ui.FlowPanel scroller;

    private final com.google.gwt.dom.client.Element e;

    public Scroller() {
      scroller = new com.google.gwt.user.client.ui.FlowPanel();
      e = com.google.gwt.user.client.ui.FlowPanel.getElement();
    }

    public void scrollTo(int position, int milliseconds) {
      int scrollStart = com.google.gwt.dom.client.Element.getOffsetLeft();
      int scrollStop = position;
      com.google.gwt.core.client.GWT.log(java.lang.String)
      <unknown>.run(int)
    }

    @java.lang.Override
    protected void onUpdate(double progress) {
      int scrollStart = 0;
      int scrollStop = 0;
      double position = scrollStart + (progress * (scrollStop - scrollStart));
      com.google.gwt.dom.client.Style.Unit u = null;
      com.google.gwt.dom.client.Element.getStyle()###<unknown>.setLeft(double,com.google.gwt.dom.client.Style.Unit)
    }
  }
}
