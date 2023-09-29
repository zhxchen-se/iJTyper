public class gwt_class_34 {
    public static void main(java.lang.String[] arg) {
        com.google.gwt.user.client.ui.FormPanel form = null;
        com.google.gwt.user.client.ui.Button submit = null;
        form = com.google.gwt.user.client.ui.FormPanel.wrap(com.google.gwt.user.client.DOM.getElementById("MyForm"));
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        submit = com.google.gwt.user.client.ui.Button.wrap(com.google.gwt.user.client.DOM.getElementById("OK"));
        submit.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                // button clicked confirmed
            }
        });
        com.google.gwt.event.shared.HandlerRegistration formSubmitHandler = form.addSubmitHandler(new com.google.gwt.user.client.ui.FormPanel.SubmitHandler() {
            public void onSubmit(com.google.gwt.user.client.ui.FormPanel.SubmitEvent event) {
            }
        });
    }
}

