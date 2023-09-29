public class gwt_class_29 {
    private static final java.lang.String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";

    private static final java.lang.String SERVER_ERROR = "An error occurred while " + ("attempting to contact the server. Please check your network " + "connection and try again.");

    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
    }

    class Jazz10RequestCallback implements AsyncCallback<Article> {
        @java.lang.Override
        public void onFailure(java.lang.Throwable caught) {
            Window.alert("Failed to send the message: " + caught.getMessage());
        }

        @java.lang.Override
        public void onSuccess(Article result) {
            // TODO Auto-generated method stub
            Window.alert(result.toString());
        }
    }
}

