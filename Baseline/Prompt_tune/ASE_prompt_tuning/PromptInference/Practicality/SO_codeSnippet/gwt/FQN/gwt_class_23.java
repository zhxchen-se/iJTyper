public class gwt_class_23 {
    public static void main(java.lang.String[] arg) {
        final java.lang.String filename = java.util.UUID.randomUUID().toString() + ".txt";
        com.google.gwt.http.client.RequestBuilder rb = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.POST, "http://localhost/upload");
        java.lang.Object selected;
        rb.setRequestData("aaa");// getBody() is plain-text

        rb.setHeader("Content-Type", "application/x-www-form-urlencodeddata");
        rb.setCallback(new com.google.gwt.http.client.RequestCallback() {
            @java.lang.Override
            public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
            }

            @java.lang.Override
            public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                exception.printStackTrace();
            }
        });
        // Checked Exceptions sucks *sigh*
        try {
            rb.send();
        } catch (com.google.gwt.http.client.RequestException e) {
            e.printStackTrace();
        }
    }
}

