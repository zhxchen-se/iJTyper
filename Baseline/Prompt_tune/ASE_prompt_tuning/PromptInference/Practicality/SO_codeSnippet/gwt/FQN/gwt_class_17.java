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
        // this.rpcWidget = new RPCWidget(this);
        this.initProfileImage();
        this.initLogoImage();
        panel.add(picSquare, DockPanel.WEST);
        panel.add(html, DockPanel.CENTER);
        com.google.gwt.user.client.ui.VerticalPanel verticalPanel = new com.google.gwt.user.client.ui.VerticalPanel();
        verticalPanel.add(logo);
        verticalPanel.add(logoutButton);
        panel.add(verticalPanel, DockPanel.EAST);
        // panel.add(rpcWidget, DockPanel.SOUTH);
        initWidget(panel);
    }

    private void initProfileImage() {
        // Display ajaxLoader.gif
        gwt_class_17.SandpitImageBundle sib = ((gwt_class_17.SandpitImageBundle) (com.google.gwt.core.client.GWT.create(gwt_class_17.SandpitImageBundle.class)));
        com.google.gwt.user.client.ui.AbstractImagePrototype aip = sib.ajaxLoader();
        sib.applyTo(this.picSquare);
    }

    private void initLogoImage() {
        // Display logo.jpg
        gwt_class_17.SandpitImageBundle sib = ((gwt_class_17.SandpitImageBundle) (com.google.gwt.core.client.GWT.create(gwt_class_17.SandpitImageBundle.class)));
        com.google.gwt.user.client.ui.AbstractImagePrototype aip = sib.logo();
        aip.applyTo(this.logo);
    }

    // Other methods omitted...
    public interface SandpitImageBundle extends com.google.gwt.user.client.ui.ImageBundle {
        /**
         * Would match the file 'logo.jpg', 'logo.gif', or 'logo.png' located in the
         * same package as this type.
         */
        public abstract com.google.gwt.user.client.ui.AbstractImagePrototype logo();

        public abstract void applyTo(com.google.gwt.user.client.ui.Image picSquare);

        /**
         * Would match the file 'ajaxLoader.jpg', 'ajaxLoader.gif', or 'ajaxLoader.png' located in the
         * same package as this type.
         */
        public abstract com.google.gwt.user.client.ui.AbstractImagePrototype ajaxLoader();
    }
}

