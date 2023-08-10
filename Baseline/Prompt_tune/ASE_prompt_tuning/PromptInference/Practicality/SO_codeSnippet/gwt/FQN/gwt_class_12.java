public class gwt_class_12 implements com.google.gwt.core.client.EntryPoint {
    public void onModuleLoad() {
        com.google.gwt.user.client.ui.AbsolutePanel ap = new com.google.gwt.user.client.ui.AbsolutePanel();
        ap.setSize("600px", "600px");
        com.google.gwt.user.client.ui.RootPanel.get().add(ap, 10, 10);
        // Diagram diagram = new Diagram(ap);
        com.google.gwt.user.client.ui.Label l = new com.google.gwt.user.client.ui.Label("Example");
        ap.add(l);
        // Connector c = new Connector(50, 80, 100, 100);
        // c.showOnDiagram(diagram);
        com.google.gwt.user.client.ui.Label l1 = new com.google.gwt.user.client.ui.Label("Label for VP");
        com.google.gwt.user.client.ui.TextBox t1 = new com.google.gwt.user.client.ui.TextBox();
        t1.setText("Hello");
        com.google.gwt.user.client.ui.VerticalPanel vp = new com.google.gwt.user.client.ui.VerticalPanel();
        vp.add(t1);
        vp.add(l1);
        ap.add(vp);
        // Shape shaperforVP = new Shape(vp);
        // shaperforVP.showOnDiagram(diagram);
    }
}

