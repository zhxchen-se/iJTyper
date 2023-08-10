public class gwt_class_37 {
  public class Tesdb3 implements com.google.gwt.core.client.EntryPoint {
    java.lang.String url = "http://localhost/phpmyadmin/tesdb3/datauser.php";

    public void LoadData() throws com.google.gwt.http.client.RequestException {
      com.google.gwt.http.client.RequestBuilder builder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, com.google.gwt.http.client.URL.encode(java.lang.String));
      com.google.gwt.http.client.RequestBuilder.sendRequest(<unknown>,gwt_class_37$Tesdb3$1)
    }

    public void data(com.google.gwt.core.client.JsArray data) {
      com.google.gwt.user.client.ui.Widget w = null;
      com.google.gwt.user.client.ui.RootPanel.get()###<unknown>.add(com.google.gwt.user.client.ui.HTML)
      com.google.gwt.user.client.ui.RootPanel.get()###<unknown>.add(com.google.gwt.user.client.ui.Widget)
    }

    public void onModuleLoad() {
      try {
        gwt_class_37$Tesdb3.LoadData()
      } catch (com.google.gwt.http.client.RequestException e) {
        com.google.gwt.http.client.RequestException.printStackTrace()
      }
    }
  }
}
