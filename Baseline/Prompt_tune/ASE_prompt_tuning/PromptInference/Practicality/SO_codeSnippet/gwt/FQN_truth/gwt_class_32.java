public class gwt_class_32 {
    public static void main(java.lang.String[] arg) {
        java.lang.String url = "http: gd.geobytes.com/gd?after=-1&variables=GeobytesCountry,GeobytesCity";
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, java.lang.Throwable exception) {
                }

                public void onResponseReceived(Request request, Response response) {
                    java.lang.System.out.println(response.getText() + "Response");
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

