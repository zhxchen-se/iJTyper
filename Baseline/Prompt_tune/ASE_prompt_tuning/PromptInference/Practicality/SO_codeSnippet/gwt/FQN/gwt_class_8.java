public class gwt_class_8 {
    public void main() throws com.google.gwt.http.client.RequestException {
        com.google.gwt.http.client.RequestBuilder requestBuilder = new com.google.gwt.http.client.RequestBuilder(com.google.gwt.http.client.RequestBuilder.POST, "j_spring_security_check");
        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        // -- sending the username and the password in designated fields.
        // Hard coding values for testing reasons:
        requestBuilder.setRequestData("j_username=test1" + "&j_password=abc");
        requestBuilder.setCallback(new com.google.gwt.http.client.RequestCallback() {
            public void onError1(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                com.google.gwt.user.client.Window.alert("ERROR !!!" + exception.getMessage());
            }

            public void onResponseReceived1(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                if ((response.getStatusCode() != com.google.gwt.http.client.Response.SC_UNAUTHORIZED) && (response.getStatusCode() != com.google.gwt.http.client.Response.SC_OK)) {
                    onError1(request, new com.google.gwt.http.client.RequestException((response.getStatusText() + ":\n") + response.getText()));
                    return;
                }
                if (response.getStatusCode() == com.google.gwt.http.client.Response.SC_UNAUTHORIZED) {
                    // This code is never encountered !! :((
                    com.google.gwt.user.client.Window.alert("You have entered an incorrect username or password. Please try again.");
                } else {
                    java.lang.String height = 800 + "";
                    java.lang.String width = 600 + "";
                    com.google.gwt.user.client.Window.alert("Authorisation succeeded, you may enter....");
                    com.google.gwt.user.client.Window.open("MainScreen.html", "Main screen!!", ((("height=" + height) + ",width=") + width) + ",scrollbars=yes,resizable=yes,titlebar=no,toolbar=no,status=yes,close=no,left=0,top=0");
                }
            }

            @java.lang.Override
            public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                // TODO Auto-generated method stub
            }

            @java.lang.Override
            public void onError(com.google.gwt.http.client.Request request, java.lang.Throwable exception) {
                // TODO Auto-generated method stub
            }
        });
        requestBuilder.send();
    }
}

