public class gwt_class_23 {
  public static void main(java.lang.String[] arg) {
    final java.lang.String filename = java.util.UUID.randomUUID()###java.util.UUID.toString() + ".txt";
    com.google.gwt.http.client.RequestBuilder rb = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.POST, "http://localhost/upload");
    java.lang.Object selected;
    com.google.gwt.http.client.RequestBuilder.setRequestData(java.lang.String)
    com.google.gwt.http.client.RequestBuilder.setHeader(java.lang.String,java.lang.String)
    com.google.gwt.http.client.RequestBuilder.setCallback(gwt_class_23$1)
    // Checked Exceptions sucks *sigh*
    try {
      com.google.gwt.http.client.RequestBuilder.send()
    } catch (com.google.gwt.http.client.RequestException e) {
      com.google.gwt.http.client.RequestException.printStackTrace()
    }
  }
}
