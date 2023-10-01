public class gwt_class_2 implements com.google.gwt.core.client.EntryPoint {
  public void onModuleLoad() {
    // Create a FormPanel and point it at a service.
    final com.google.gwt.user.client.ui.FormPanel form = new com.google.gwt.user.client.ui.FormPanel();
    com.google.gwt.user.client.ui.FormPanel.setAction(java.lang.String)
    com.google.gwt.user.client.ui.FormPanel.setEncoding()
    com.google.gwt.user.client.ui.FormPanel.setMethod()
    // Create a panel to hold all of the form widgets.
    com.google.gwt.user.client.ui.VerticalPanel panel = new com.google.gwt.user.client.ui.VerticalPanel();
    com.google.gwt.user.client.ui.VerticalPanel.setSpacing(int)
    com.google.gwt.user.client.ui.FormPanel.setWidget(com.google.gwt.user.client.ui.VerticalPanel)
    // Create a TextBox, giving it a name so that it will be submitted.
    final com.google.gwt.user.client.ui.TextBox tb = new com.google.gwt.user.client.ui.TextBox();
    com.google.gwt.user.client.ui.TextBox.setWidth(java.lang.String)
    com.google.gwt.user.client.ui.TextBox.setName(java.lang.String)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.TextBox)
    // Create a ListBox, giving it a name and
    // some values to be associated with its options.
    com.google.gwt.user.client.ui.ListBox lb = new com.google.gwt.user.client.ui.ListBox();
    com.google.gwt.user.client.ui.ListBox.setName(java.lang.String)
    com.google.gwt.user.client.ui.ListBox.addItem(java.lang.String,java.lang.String)
    com.google.gwt.user.client.ui.ListBox.addItem(java.lang.String,java.lang.String)
    com.google.gwt.user.client.ui.ListBox.addItem(java.lang.String,java.lang.String)
    com.google.gwt.user.client.ui.ListBox.setWidth(java.lang.String)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.ListBox)
    // Create a FileUpload widget.
    com.google.gwt.user.client.ui.FileUpload upload = new com.google.gwt.user.client.ui.FileUpload();
    com.google.gwt.user.client.ui.FileUpload.setName(java.lang.String)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.FileUpload)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.FormPanel.addSubmitHandler(gwt_class_2$2)
    com.google.gwt.user.client.ui.FormPanel.addSubmitCompleteHandler(gwt_class_2$3)
    com.google.gwt.user.client.ui.DecoratorPanel decoratorPanel = new com.google.gwt.user.client.ui.DecoratorPanel();
    com.google.gwt.user.client.ui.DecoratorPanel.add(com.google.gwt.user.client.ui.FormPanel)
    com.google.gwt.user.client.ui.RootPanel.get()###<unknown>.add(com.google.gwt.user.client.ui.DecoratorPanel)
  }
}
