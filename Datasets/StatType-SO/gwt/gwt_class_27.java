
//ID = 2385802
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class gwt_class_27 {
	public static void main(String arg[]){
		final Button sendButton = new Button("Send");
		sendButton.getElement().setId("button");
		RootPanel.get().getElement().appendChild(sendButton.getElement());

		NodeList buttonElement = Document.get().getElementsByTagName("button");
		if(buttonElement != null && buttonElement.getLength() > 0){
		buttonElement.getItem(0).setNodeValue("Changed");
		}else{
		GWT.log("Can't select button");
		}
	}
}
