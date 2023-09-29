public class gwt_class_23 {
    public static void main(java.lang.String[] arg) {
        final java.lang.String filename = UUID.randomUUID().toString() + ".txt";
        RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, "http://localhost/upload");
        java.lang.Object selected;
        rb.setRequestData("aaa");
        rb.setHeader("Content-Type", "application/x-www-form-urlencodeddata");
        rb.setCallback(new RequestCallback() {
            @java.lang.Override
            public void onResponseReceived(Request request, Response response) {
            }

            @java.lang.Override
            public void onError(Request request, java.lang.Throwable exception) {
                exception.printStackTrace();
            }
        });
        try {
            rb.send();
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}

