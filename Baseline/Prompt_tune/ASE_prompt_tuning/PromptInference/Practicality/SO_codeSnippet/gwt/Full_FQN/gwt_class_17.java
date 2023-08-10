public class gwt_class_17 extends com.google.gwt.user.client.ui.Composite {
  // Data
  private java.lang.String firstName = null;

  private java.lang.String lastName = null;

  private java.lang.String picSquareUrl = null;

  // Elements
  private com.google.gwt.user.client.ui.Image picSquare = new com.google.gwt.user.client.ui.Image();

  private com.google.gwt.user.client.ui.Image logo = new com.google.gwt.user.client.ui.Image();

  private com.google.gwt.user.client.ui.Button logoutButton = new com.google.gwt.user.client.ui.Button("Logout");

  private com.google.gwt.user.client.ui.DockPanel panel = new com.google.gwt.user.client.ui.DockPanel();

  private com.google.gwt.user.client.ui.HTML html = new com.google.gwt.user.client.ui.HTML("Welcome to Sandpit.");

  /**
   * Create a remote service proxy to talk to the server-side User Data
   * service.
   */
  // private final UserDataServiceAsync userDataService = GWT.create(UserDataService.class);
  public gwt_class_17() {
    gwt_class_17.initProfileImage()
    gwt_class_17.initLogoImage()
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.Image)
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.VerticalPanel verticalPanel = new com.google.gwt.user.client.ui.VerticalPanel();
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Image)
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.VerticalPanel)
    <unknown>.initWidget(<unknown>)
  }

  private void initProfileImage() {
    // Display ajaxLoader.gif
    gwt_class_17.SandpitImageBundle sib = com.google.gwt.core.client.GWT.create(java.lang.Class);
    com.google.gwt.user.client.ui.AbstractImagePrototype aip = gwt_class_17$SandpitImageBundle.ajaxLoader();
    gwt_class_17$SandpitImageBundle.applyTo(com.google.gwt.user.client.ui.Image)
  }

  private void initLogoImage() {
    // Display logo.jpg
    gwt_class_17.SandpitImageBundle sib = com.google.gwt.core.client.GWT.create(java.lang.Class);
    com.google.gwt.user.client.ui.AbstractImagePrototype aip = gwt_class_17$SandpitImageBundle.logo();
    com.google.gwt.user.client.ui.AbstractImagePrototype.applyTo(com.google.gwt.user.client.ui.Image)
  }

  // Other methods omitted...
  public interface SandpitImageBundle extends com.google.gwt.user.client.ui.ImageBundle {
    /**
     * Would match the file 'logo.jpg', 'logo.gif', or 'logo.png' located in the
     * same package as this type.
     */
    public com.google.gwt.user.client.ui.AbstractImagePrototype logo();

    public void applyTo(com.google.gwt.user.client.ui.Image picSquare);

    /**
     * Would match the file 'ajaxLoader.jpg', 'ajaxLoader.gif', or 'ajaxLoader.png' located in the
     * same package as this type.
     */
    public com.google.gwt.user.client.ui.AbstractImagePrototype ajaxLoader();
  }
}
