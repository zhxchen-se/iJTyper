public class gwt_class_8 {
    public void main() throws RequestException {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, "j_spring_security_check");
        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        requestBuilder.setRequestData("j_username=test1" + "&j_password=abc");
        requestBuilder.setCallback(new RequestCallback() {
            public void onError1(Request request, java.lang.Throwable exception) {
                Window.alert("ERROR !!!" + exception.getMessage());
            }

            public void onResponseReceived1(Request request, Response response) {
                if ((response.getStatusCode() != Response.SC_UNAUTHORIZED) && (response.getStatusCode() != Response.SC_OK)) {
                    onError1(request, new RequestException((response.getStatusText() + ":\n") + response.getText()));
                    return;
                }
                if (response.getStatusCode() == Response.SC_UNAUTHORIZED) {
                    Window.alert("You have entered an incorrect username or password. Please try again.");
                } else {
                    java.lang.String height = 800 + "";
                    java.lang.String width = 600 + "";
                    Window.alert("Authorisation succeeded, you may enter....");
                    Window.open("MainScreen.html", "Main screen!!", ((("height=" + height) + ",width=") + width) + ",scrollbars=yes,resizable=yes,titlebar=no,toolbar=no,status=yes,close=no,left=0,top=0");
                }
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
        requestBuilder.send();
    }
}

