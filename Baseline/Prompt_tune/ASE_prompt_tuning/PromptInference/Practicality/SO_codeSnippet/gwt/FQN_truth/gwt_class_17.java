public class gwt_class_17 extends Composite {
    private java.lang.String firstName = null;

    private java.lang.String lastName = null;

    private java.lang.String picSquareUrl = null;

    private Image picSquare = new Image();

    private Image logo = new Image();

    private Button logoutButton = new Button("Logout");

    private DockPanel panel = new DockPanel();

    private HTML html = new HTML("Welcome to Sandpit.");

    public gwt_class_17() {
        this.initProfileImage();
        this.initLogoImage();
        panel.add(picSquare, DockPanel.WEST);
        panel.add(html, DockPanel.CENTER);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(logo);
        verticalPanel.add(logoutButton);
        panel.add(verticalPanel, DockPanel.EAST);
        initWidget(panel);
    }

    private void initProfileImage() {
        gwt_class_17.SandpitImageBundle sib = GWT.create(gwt_class_17.SandpitImageBundle.class);
        AbstractImagePrototype aip = sib.ajaxLoader();
        sib.applyTo(this.picSquare);
    }

    private void initLogoImage() {
        gwt_class_17.SandpitImageBundle sib = GWT.create(gwt_class_17.SandpitImageBundle.class);
        AbstractImagePrototype aip = sib.logo();
        aip.applyTo(this.logo);
    }

    public interface SandpitImageBundle extends ImageBundle {
        public abstract AbstractImagePrototype logo();

        public abstract void applyTo(Image picSquare);

        public abstract AbstractImagePrototype ajaxLoader();
    }
}

