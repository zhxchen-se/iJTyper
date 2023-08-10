public class gwt_class_26 {
    public static void main(java.lang.String[] arg) {
        final com.google.gwt.user.client.ui.FormPanel formPanel = new com.google.gwt.user.client.ui.FormPanel();
        com.google.gwt.user.client.ui.RootPanel.get("openId").add(formPanel);
        com.google.gwt.user.client.ui.VerticalPanel openIdContainer = new com.google.gwt.user.client.ui.VerticalPanel();
        formPanel.add(openIdContainer);
        com.google.gwt.user.client.ui.TextBox url = new com.google.gwt.user.client.ui.TextBox();
        url.setText("https://www.google.com/accounts/o8/id");
        url.setName("j_username");
        openIdContainer.add(url);
        formPanel.setAction("j_spring_openid_security_check");
        formPanel.setMethod(FormPanel.METHOD_POST);
        com.google.gwt.user.client.ui.Button btn = new com.google.gwt.user.client.ui.Button("Open ID");
        btn.addClickListener(new com.google.gwt.user.client.ui.ClickListener() {
            public void onClick(com.google.gwt.user.client.ui.Widget sender) {
                formPanel.submit();
            }
        });
        openIdContainer.add(btn);
        formPanel.addFormHandler(new com.google.gwt.user.client.ui.FormHandler() {
            public void onSubmit(com.google.gwt.user.client.ui.FormSubmitEvent event) {
                java.lang.System.out.println("On Submit invoked " + event.isCancelled());
            }

            public void onSubmitComplete(com.google.gwt.user.client.ui.FormSubmitCompleteEvent event) {
                java.lang.System.out.println("On Submit Complete invoked " + event.toString());
            }
        });
    }
}

