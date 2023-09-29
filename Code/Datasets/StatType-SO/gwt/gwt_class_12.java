
//ID = 1690154
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class gwt_class_12 implements EntryPoint {
   public void onModuleLoad() {

           AbsolutePanel ap = new AbsolutePanel();
           ap.setSize("600px", "600px");
           RootPanel.get().add(ap, 10, 10);

//           Diagram diagram = new Diagram(ap);
           Label l = new Label("Example");
           ap.add(l);

//           Connector c = new Connector(50, 80, 100, 100);
//           c.showOnDiagram(diagram);

           Label l1 = new Label("Label for VP");
           TextBox t1 = new TextBox();
           t1.setText("Hello");
           VerticalPanel vp = new VerticalPanel();
           vp.add(t1);
           vp.add(l1);
           ap.add(vp);

//           Shape shaperforVP = new Shape(vp);
//           shaperforVP.showOnDiagram(diagram);

   }
}