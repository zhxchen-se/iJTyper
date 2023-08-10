public class gwt_class_15 {
    public static void main(java.lang.String[] arg) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode("http://localhost:8080/xxxx/yyyy"));
        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, java.lang.Throwable exception) {
                }

                public void onResponseReceived1(Request request, Response response) {
                }

                @java.lang.Override
                public void onResponseReceived(Request request, Response response) {
                    // TODO Auto-generated method stub
                }
            });
        } catch (RequestException e) {
        }
    }
}

