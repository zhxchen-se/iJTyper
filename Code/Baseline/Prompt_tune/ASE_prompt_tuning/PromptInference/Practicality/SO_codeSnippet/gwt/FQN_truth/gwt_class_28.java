public class gwt_class_28 {
    public class Test implements EntryPoint {
        private static final java.lang.String SERVER_URL = "http://localhost:8094";

        private static final java.lang.String SERVER_ERROR = "An error occurred while " + ("attempting to contact the server. Please check your network " + "connection and try again.");

        public void onModuleLoad() {
            RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, gwt_class_28.Test.SERVER_URL);
            try {
                requestBuilder.sendRequest(null, new gwt_class_28.Test.Jazz10RequestCallback());
            } catch (RequestException e) {
                Window.alert("Failed to send the message: " + e.getMessage());
            }
        }

        class Jazz10RequestCallback implements RequestCallback {
            public void onError(Request request, java.lang.Throwable exception) {
                Window.alert("Failed to send the message: " + exception.getMessage());
            }

            public void onResponseReceived(Request request, Response response) {
                Window.alert(response.getText());
            }
        }
    }
}

