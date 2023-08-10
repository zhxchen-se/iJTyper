public class gwt_class_34 {
    public static void main(java.lang.String[] arg) {
        FormPanel form = null;
        Button submit = null;
        form = FormPanel.wrap(DOM.getElementById("MyForm"));
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        submit = Button.wrap(DOM.getElementById("OK"));
        submit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        HandlerRegistration formSubmitHandler = form.addSubmitHandler(new SubmitHandler() {
            public void onSubmit(SubmitEvent event) {
            }
        });
    }
}

