public class gwt_class_32 {
    public static void main(java.lang.String[] arg) {
        java.lang.String url = "http: gd.geobytes.com/gd?after=-1&variables=GeobytesCountry,GeobytesCity";
        com.google.gwt.http.client.RequestBuilder builder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, com.google.gwt.http.client.URL.encode(url));
        try {
            com.google.gwt.http.client.Request request = builder.sendRequest(null, new com.google.gwt.http.client.RequestCallback() {
                public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                }

                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                    java.lang.System.out.println(response.getText() + "Response");
                    if (200 == response.getStatusCode()) {
                        com.google.gwt.user.client.Window.alert(response.getText());
                    } else {
                        com.google.gwt.user.client.Window.alert(response.getText());
                    }
                }
            });
        } catch (com.google.gwt.http.client.RequestException e) {
            e.printStackTrace();
        }
    }
}

