public class gwt_class_31 {
    public static void main(java.lang.String[] arg) throws RequestException {
        java.lang.String serverUrl = null;
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, URL.encode(serverUrl));
        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        requestBuilder.setHeader("Expires", "0");
        java.lang.String postData = null;
        requestBuilder.sendRequest(postData, new RequestCallback() {
            public void onError(Request request, java.lang.Throwable exception) {
            }

            public void onResponseReceived(Request request, Response response) {
            }
        });
    }
}

