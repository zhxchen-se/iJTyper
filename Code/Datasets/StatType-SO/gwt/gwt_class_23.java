
//ID = 2279782
import java.util.UUID;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class gwt_class_23 {
	public static void main(String arg[]){
		final String filename = UUID.randomUUID().toString() + ".txt";

		RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, "http://localhost/upload");
		Object selected;
		rb.setRequestData("aaa"); // getBody() is plain-text
		rb.setHeader("Content-Type", "application/x-www-form-urlencodeddata");
		rb.setCallback(new RequestCallback() {
		    @Override
		    public void onResponseReceived(Request request, Response response) {
                         
		    }

		    @Override
		    public void onError(Request request, Throwable exception) {
		        exception.printStackTrace();
		    }
		});

		// Checked Exceptions sucks *sigh*
		try {
		    rb.send();
		}
		catch (RequestException e) {
		    e.printStackTrace();
		}
	}

}
