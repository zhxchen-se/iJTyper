
//ID = 1738530
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class gwt_class_14 {
	public void main(String arg[]){
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET,"http://myweb.com/test.php?id=65472");
	     try {
	        rb.sendRequest(null, new RequestCallback() {
	             public void onError1(final Request request, final Throwable exception) {
	                 Window.alert(exception.getMessage());
	             }
	             public void onResponseReceived1(final Request request, final Response response) {
	                 //do something
	                 GWT.log("response: (" + response.getText() + ")", null);
	             }
				@Override
				public void onResponseReceived(Request request, Response response) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub
					
				}
	        });
	     } catch (final Exception e) {
	             Window.alert(e.getMessage());
	     }	
	}

}
