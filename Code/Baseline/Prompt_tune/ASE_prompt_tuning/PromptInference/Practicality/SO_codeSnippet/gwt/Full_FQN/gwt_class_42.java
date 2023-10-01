public class gwt_class_42 {
  public class Tesdb3 implements com.google.gwt.core.client.EntryPoint {
    java.lang.String url = "http://localhost/phpmyadmin/tesdb3/datauser.php";

    public void LoadData() throws com.google.gwt.http.client.RequestException {
      com.google.gwt.http.client.RequestBuilder builder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, com.google.gwt.http.client.URL.encode(java.lang.String));
      com.google.gwt.http.client.RequestBuilder.sendRequest(<unknown>,gwt_class_42$Tesdb3$1)
    }

    public void onModuleLoad() {
      try {
        gwt_class_42$Tesdb3.LoadData()
      } catch (com.google.gwt.http.client.RequestException e) {
        com.google.gwt.http.client.RequestException.printStackTrace()
      }
    }
  }
}
