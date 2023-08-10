public class gwt_class_37 {
    public class Tesdb3 implements EntryPoint {
        java.lang.String url = "http://localhost/phpmyadmin/tesdb3/datauser.php";

        public void LoadData() throws RequestException {
            RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
            builder.sendRequest(null, new RequestCallback() {
                @java.lang.Override
                public void onError(Request request, java.lang.Throwable exception) {
                    Window.alert("error " + exception);
                }

                public void onResponseReceived(Request request, Response response) {
                }
            });
        }

        public void data(JsArray data) {
            Widget w = null;
            RootPanel.get().add(new HTML("my data"));
            RootPanel.get().add(w);
        }

        public void onModuleLoad() {
            try {
                LoadData();
            } catch (RequestException e) {
                e.printStackTrace();
            }
        }
    }
}

