public class gwt_class_2 implements com.google.gwt.core.client.EntryPoint {
    public void onModuleLoad() {
        // Create a FormPanel and point it at a service.
        final com.google.gwt.user.client.ui.FormPanel form = new com.google.gwt.user.client.ui.FormPanel();
        form.setAction("/myFormHandler");
        // Because we're going to add a FileUpload widget,
        // we'll need to set the form to use the POST method,
        // and multipart MIME encoding.
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        // Create a panel to hold all of the form widgets.
        com.google.gwt.user.client.ui.VerticalPanel panel = new com.google.gwt.user.client.ui.VerticalPanel();
        panel.setSpacing(10);
        form.setWidget(panel);
        // Create a TextBox, giving it a name so that it will be submitted.
        final com.google.gwt.user.client.ui.TextBox tb = new com.google.gwt.user.client.ui.TextBox();
        tb.setWidth("220");
        tb.setName("textBoxFormElement");
        panel.add(tb);
        // Create a ListBox, giving it a name and
        // some values to be associated with its options.
        com.google.gwt.user.client.ui.ListBox lb = new com.google.gwt.user.client.ui.ListBox();
        lb.setName("listBoxFormElement");
        lb.addItem("item1", "item1");
        lb.addItem("item2", "item2");
        lb.addItem("item3", "item3");
        lb.setWidth("220");
        panel.add(lb);
        // Create a FileUpload widget.
        com.google.gwt.user.client.ui.FileUpload upload = new com.google.gwt.user.client.ui.FileUpload();
        upload.setName("uploadFormElement");
        panel.add(upload);
        // Add a 'submit' button.
        panel.add(new com.google.gwt.user.client.ui.Button("Submit", new com.google.gwt.event.dom.client.ClickHandler() {
            @java.lang.Override
            public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
                form.submit();
            }
        }));
        // Add an event handler to the form.
        form.addSubmitHandler(new com.google.gwt.user.client.ui.FormPanel.SubmitHandler() {
            @java.lang.Override
            public void onSubmit(com.google.gwt.user.client.ui.FormPanel.SubmitEvent event) {
                // This event is fired just before the form is submitted.
                // We can take this opportunity to perform validation.
                if (tb.getText().length() == 0) {
                    com.google.gwt.user.client.Window.alert("The text box must not be empty");
                    event.cancel();
                }
            }
        });
        form.addSubmitCompleteHandler(new com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler() {
            @java.lang.Override
            public void onSubmitComplete(com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent event) {
                // When the form submission is successfully completed,
                // this event is fired. Assuming the service returned
                // a response of type text/html, we can get the result
                // here.
                com.google.gwt.user.client.Window.alert(event.getResults());
            }
        });
        com.google.gwt.user.client.ui.DecoratorPanel decoratorPanel = new com.google.gwt.user.client.ui.DecoratorPanel();
        decoratorPanel.add(form);
        // Add the widgets to the root panel.
        com.google.gwt.user.client.ui.RootPanel.get().add(decoratorPanel);
    }
}

