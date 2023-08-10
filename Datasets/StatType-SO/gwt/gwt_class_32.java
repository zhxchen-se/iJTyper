
//ID = 2482222
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;

public class gwt_class_32 {
	public static void main(String arg[]){
	String url = "http: gd.geobytes.com/gd?after=-1&variables=GeobytesCountry,GeobytesCity";
    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
    try {
        Request request = builder.sendRequest(null, new RequestCallback() {
            public void onError(Request request, Throwable exception) {
            }

            public void onResponseReceived(Request request,
                    Response response) {

                System.out.println(response.getText() + "Response");

                if (200 == response.getStatusCode()) {
                    Window.alert(response.getText());
                } else {
                    Window.alert(response.getText());
                }
            }
        });
    } catch (RequestException e) {
        e.printStackTrace();
    }
}
}
