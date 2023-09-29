public class gwt_class_15 {
    public static void main(java.lang.String[] arg) {
        com.google.gwt.http.client.RequestBuilder builder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, com.google.gwt.http.client.URL.encode("http://localhost:8080/xxxx/yyyy"));
        try {
            com.google.gwt.http.client.Request request = builder.sendRequest(null, new com.google.gwt.http.client.RequestCallback() {
                public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                }

                public void onResponseReceived1(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                }

                @java.lang.Override
                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                    // TODO Auto-generated method stub
                }
            });
        } catch (com.google.gwt.http.client.RequestException e) {
            // possiblePages.clear(); possiblePages.addItem("could not connect to server");
        }
    }
}

