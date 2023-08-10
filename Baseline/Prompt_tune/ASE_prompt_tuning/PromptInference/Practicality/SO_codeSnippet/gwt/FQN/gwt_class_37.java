public class gwt_class_37 {
    public class Tesdb3 implements com.google.gwt.core.client.EntryPoint {
        java.lang.String url = "http://localhost/phpmyadmin/tesdb3/datauser.php";

        public void LoadData() throws com.google.gwt.http.client.RequestException {
            com.google.gwt.http.client.RequestBuilder builder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, com.google.gwt.http.client.URL.encode(url));
            builder.sendRequest(null, new com.google.gwt.http.client.RequestCallback() {
                @java.lang.Override
                public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                    com.google.gwt.user.client.Window.alert("error " + exception);
                }

                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                }
            });
        }

        public void data(com.google.gwt.core.client.JsArray data) {
            com.google.gwt.user.client.ui.Widget w = null;
            com.google.gwt.user.client.ui.RootPanel.get().add(new com.google.gwt.user.client.ui.HTML("my data"));
            com.google.gwt.user.client.ui.RootPanel.get().add(w);
        }

        public void onModuleLoad() {
            try {
                LoadData();
            } catch (com.google.gwt.http.client.RequestException e) {
                e.printStackTrace();
            }
        }
    }
}

