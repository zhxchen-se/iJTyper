public class gwt_class_31 {
    public static void main(java.lang.String[] arg) throws com.google.gwt.http.client.RequestException {
        java.lang.String serverUrl = null;
        com.google.gwt.http.client.RequestBuilder requestBuilder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.POST, com.google.gwt.http.client.URL.encode(serverUrl));// -- serverUrl is the url to which this call is posted to.

        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        requestBuilder.setHeader("Expires", "0");
        java.lang.String postData = null;
        requestBuilder.sendRequest(postData, new com.google.gwt.http.client.RequestCallback() {
            public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                // Do nothing
            }

            public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                // sometimes when the server is restarted, I get response.getStatusCode() = 304 and the response.getText() as blank
            }
        });
    }
}

