
//ID = 1692017
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("deprecation")
public class gwt_class_13 {
	public class ERD1 implements EntryPoint {

		public void onModuleLoad() {

		 AbsolutePanel boundaryPanel = new AbsolutePanel();
		    boundaryPanel.setPixelSize(1000, 1000);

//		    final Diagram d = new Diagram(boundaryPanel);

		 Button b = new Button();
		 b.addClickListener(new ClickListener(){

		  public void onClick1(Widget sender) {
		  }

		@Override
		public void onClick(Widget sender) {
			// TODO Auto-generated method stub
			
		}

		 });

		 boundaryPanel.add(b, 10, 40);

		 RootPanel.get().add(boundaryPanel);
		} 
		}
}
