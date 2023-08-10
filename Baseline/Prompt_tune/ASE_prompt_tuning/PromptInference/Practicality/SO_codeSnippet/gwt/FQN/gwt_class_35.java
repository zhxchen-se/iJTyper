public class gwt_class_35 {
    public class Scroller extends com.google.gwt.animation.client.Animation {
        private com.google.gwt.user.client.ui.FlowPanel scroller;

        private final com.google.gwt.dom.client.Element e;

        public Scroller() {
            scroller = new com.google.gwt.user.client.ui.FlowPanel();
            e = scroller.getElement();
        }

        public void scrollTo(int position, int milliseconds) {
            int scrollStart = e.getOffsetLeft();
            int scrollStop = position;
            com.google.gwt.core.client.GWT.log((("ScrollStart: " + scrollStart) + " scrollStop: ") + scrollStop);
            run(milliseconds);
        }

        @java.lang.Override
        protected void onUpdate(double progress) {
            int scrollStart = 0;
            int scrollStop = 0;
            double position = scrollStart + (progress * (scrollStop - scrollStart));
            com.google.gwt.dom.client.Style.Unit u = null;
            e.getStyle().setLeft(position, u);
        }
    }
}

