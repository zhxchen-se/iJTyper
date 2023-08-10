
//ID = 2598154
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;

public class gwt_class_34 {
	public static void main(String arg[]){
		FormPanel form = null;
		Button submit = null;

		form = FormPanel.wrap(DOM.getElementById("MyForm"));
		form.setEncoding(FormPanel.ENCODING_MULTIPART);

		submit = Button.wrap(DOM.getElementById("OK"));
		submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// button clicked confirmed
			}
		});


		HandlerRegistration formSubmitHandler = form.addSubmitHandler(new SubmitHandler(){
			public void onSubmit(SubmitEvent event) {
			}
		});
	}

}
