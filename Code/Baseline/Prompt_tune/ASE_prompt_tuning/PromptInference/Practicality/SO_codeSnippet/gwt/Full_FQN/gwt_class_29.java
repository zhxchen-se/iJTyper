public class gwt_class_29 {
  // private static final String SERVER_URL = "http://localhost:8094/data/view/";
  private static final java.lang.String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";

  private static final java.lang.String SERVER_ERROR = "An error occurred while " + ("attempting to contact the server. Please check your network " + "connection and try again.");

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    com.google.gwt.jsonp.client.JsonpRequestBuilder requestBuilder = new com.google.gwt.jsonp.client.JsonpRequestBuilder();
    // requestBuilder.setTimeout(10000);
    // requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
  }

  class Jazz10RequestCallback implements com.google.gwt.user.client.rpc.AsyncCallback<org.apache.commons.net.nntp.Article> {
    @java.lang.Override
    public void onFailure(java.lang.Throwable caught) {
      com.google.gwt.user.client.Window.alert(java.lang.String)
    }

    @java.lang.Override
    public void onSuccess(org.apache.commons.net.nntp.Article result) {
      com.google.gwt.user.client.Window.alert()
    }
  }
}
