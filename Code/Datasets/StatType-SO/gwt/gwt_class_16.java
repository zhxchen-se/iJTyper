
//ID = 1795474
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class gwt_class_16 {
 public static void main(String arg[]){
	 try
	 {
	     RequestBuilder rb = new RequestBuilder(
	     RequestBuilder.POST, "AuthenticationChecker.html");
	             rb.sendRequest(null, new RequestCallback() 
	             {
	                 public void onError(Request request, Throwable exception)
	                 {
	                     RootPanel.get().add(new HTML("[error]" + exception.getMessage()));
	                 }
	                 public void onResponseReceived(Request request, Response response)
	                 {
	                     RootPanel.get()
	                    .add(new HTML("[success (" + response.getStatusCode() + "," + response.getStatusText() + ")]"));
	                 }
	             }
	     );
	 }
	 catch (Exception e)
	 {
	     RootPanel.get().add(new HTML("Error sending request " + e.getMessage()));
	 }
 }
}
