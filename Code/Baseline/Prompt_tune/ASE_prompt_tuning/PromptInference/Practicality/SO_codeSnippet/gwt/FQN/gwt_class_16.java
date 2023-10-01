public class gwt_class_16 {
    public static void main(java.lang.String[] arg) {
        try {
            com.google.gwt.http.client.RequestBuilder rb = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.POST, "AuthenticationChecker.html");
            rb.sendRequest(null, new com.google.gwt.http.client.RequestCallback() {
                public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                    com.google.gwt.user.client.ui.RootPanel.get().add(new com.google.gwt.user.client.ui.HTML("[error]" + exception.getMessage()));
                }

                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                    com.google.gwt.user.client.ui.RootPanel.get().add(new com.google.gwt.user.client.ui.HTML(((("[success (" + response.getStatusCode()) + ",") + response.getStatusText()) + ")]"));
                }
            });
        } catch (java.lang.Exception e) {
            com.google.gwt.user.client.ui.RootPanel.get().add(new com.google.gwt.user.client.ui.HTML("Error sending request " + e.getMessage()));
        }
    }
}

