public class gwt_class_28 {
  /**
   * Entry point classes define <code>onModuleLoad()</code>.
   */
  public class Test implements com.google.gwt.core.client.EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final java.lang.String SERVER_URL = "http://localhost:8094";

    private static final java.lang.String SERVER_ERROR = "An error occurred while " + ("attempting to contact the server. Please check your network " + "connection and try again.");

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
      com.google.gwt.http.client.RequestBuilder requestBuilder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.GET, gwt_class_28.Test.SERVER_URL);
      try {
        com.google.gwt.http.client.RequestBuilder.sendRequest(<unknown>,gwt_class_28$Test$Jazz10RequestCallback)
      } catch (com.google.gwt.http.client.RequestException e) {
        com.google.gwt.user.client.Window.alert()
      }
    }

    class Jazz10RequestCallback implements com.google.gwt.http.client.RequestCallback {
      public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
        com.google.gwt.user.client.Window.alert(java.lang.String)
      }

      public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
        com.google.gwt.user.client.Window.alert()
      }
    }
  }
}
