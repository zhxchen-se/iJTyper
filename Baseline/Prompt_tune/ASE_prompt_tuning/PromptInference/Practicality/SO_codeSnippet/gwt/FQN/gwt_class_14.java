public class gwt_class_14 {
    public void main(java.lang.String[] arg) {
        com.google.gwt.http.client.RequestBuilder rb = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, "http://myweb.com/test.php?id=65472");
        try {
            rb.sendRequest(null, new com.google.gwt.http.client.RequestCallback() {
                public void onError1(final com.google.gwt.http.client.Request request, final java.lang.Throwable exception) {
                    com.google.gwt.user.client.Window.alert(exception.getMessage());
                }

                public void onResponseReceived1(final com.google.gwt.http.client.Request request, final com.google.gwt.http.client.Response response) {
                    // do something
                    com.google.gwt.core.client.GWT.log(("response: (" + response.getText()) + ")", null);
                }

                @java.lang.Override
                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                    // TODO Auto-generated method stub
                }

                @java.lang.Override
                public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                    // TODO Auto-generated method stub
                }
            });
        } catch (final java.lang.Exception e) {
            com.google.gwt.user.client.Window.alert(e.getMessage());
        }
    }
}

