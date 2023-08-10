public class gwt_class_14 {
    public void main(java.lang.String[] arg) {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, "http://myweb.com/test.php?id=65472");
        try {
            rb.sendRequest(null, new RequestCallback() {
                public void onError1(final Request request, final java.lang.Throwable exception) {
                    Window.alert(exception.getMessage());
                }

                public void onResponseReceived1(final Request request, final Response response) {
                    GWT.log(("response: (" + response.getText()) + ")", null);
                }

                @java.lang.Override
                public void onResponseReceived(Request request, Response response) {
                    // TODO Auto-generated method stub
                }

                @java.lang.Override
                public void onError(Request request, java.lang.Throwable exception) {
                    // TODO Auto-generated method stub
                }
            });
        } catch (final java.lang.Exception e) {
            Window.alert(e.getMessage());
        }
    }
}

