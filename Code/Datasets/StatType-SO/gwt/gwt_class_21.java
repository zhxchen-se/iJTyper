
//ID = 2214891
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_21 {
	private static class PopUpPanel extends PopupPanel{

	    Button connect = new Button("Connect");
	    Button delete = new Button("Delete");
	    Button detail = new Button("Detail");

	    public PopUpPanel(final Widget widget){
	       super(true);
	       VerticalPanel vp = new VerticalPanel();
	       vp.add(connect);
	       vp.add(delete);
	       vp.add(detail);

	       setWidget(vp);
	    }
	}
}
