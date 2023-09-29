
//ID = 2764988
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_38 {
	public class AdminMenuAreaView extends Composite{


	    private VerticalPanel vPanel;
	    private Hyperlink registerUserLink;

	    public AdminMenuAreaView(){ 
	        vPanel = new VerticalPanel();           
	        initWidget(vPanel);
	    }

	    public Widget asWidget() {
	        return this;
	    }

	        public void addLink(String s){

	    registerUserLink = new Hyperlink(s, "this is new target");
	    this.vPanel.add(registerUserLink);
	    registerUserLink.setVisible(true);  
	}

	public HasClickHandlers getRegisterUserLink(){
	    return registerUserLink;
	}
	}
}
