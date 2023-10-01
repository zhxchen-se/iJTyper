@java.lang.SuppressWarnings("deprecation")
public class gwt_class_13 {
    public class ERD1 implements com.google.gwt.core.client.EntryPoint {
        public void onModuleLoad() {
            com.google.gwt.user.client.ui.AbsolutePanel boundaryPanel = new com.google.gwt.user.client.ui.AbsolutePanel();
            boundaryPanel.setPixelSize(1000, 1000);
            // final Diagram d = new Diagram(boundaryPanel);
            com.google.gwt.user.client.ui.Button b = new com.google.gwt.user.client.ui.Button();
            b.addClickListener(new com.google.gwt.user.client.ui.ClickListener() {
                public void onClick1(com.google.gwt.user.client.ui.Widget sender) {
                }

                @java.lang.Override
                public void onClick(com.google.gwt.user.client.ui.Widget sender) {
                    // TODO Auto-generated method stub
                }
            });
            boundaryPanel.add(b, 10, 40);
            com.google.gwt.user.client.ui.RootPanel.get().add(boundaryPanel);
        }
    }
}

