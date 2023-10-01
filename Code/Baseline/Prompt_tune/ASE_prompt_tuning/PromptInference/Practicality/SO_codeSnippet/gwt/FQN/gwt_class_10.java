// import com.google.gwt.user.client.ui.FormPanel;
// import com.google.gwt.user.client.ui.VerticalPanel;
public class gwt_class_10 {
    public void main() {
        final com.google.gwt.user.client.ui.FormPanel form = new com.google.gwt.user.client.ui.FormPanel();
        com.google.gwt.user.client.ui.VerticalPanel holder = new com.google.gwt.user.client.ui.VerticalPanel();
        holder.add(new com.google.gwt.user.client.ui.Label("User ID"));
        com.google.gwt.user.client.ui.TextBox nameTextBox = new com.google.gwt.user.client.ui.TextBox();
        nameTextBox.setName("userid");
        holder.add(nameTextBox);
        com.google.gwt.user.client.ui.Button submitButton = new com.google.gwt.user.client.ui.Button("Submit");
        holder.add(submitButton);
        form.add(holder);
        submitButton.addClickListener(new com.google.gwt.user.client.ui.ClickListener() {
            public void onClick1(com.google.gwt.user.client.ui.Widget sender) {
                form.submit();
            }

            @java.lang.Override
            public void onClick(com.google.gwt.user.client.ui.Widget sender) {
                // TODO Auto-generated method stub
            }
        });
    }
}

