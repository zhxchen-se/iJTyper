
//ID = 1881173
import com.google.gwt.core.client.GWT;    
import com.google.gwt.user.client.ui.AbstractImagePrototype;  
import com.google.gwt.user.client.ui.Button;  
import com.google.gwt.user.client.ui.Composite;  
import com.google.gwt.user.client.ui.DockPanel;  
import com.google.gwt.user.client.ui.HTML;  
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.VerticalPanel;  

public class gwt_class_17 extends Composite {

    // Data  
    private String firstName = null;  
    private String lastName = null;  
    private String picSquareUrl = null;  

    // Elements  
    private Image picSquare = new Image();  
    private Image logo = new Image();  
    private Button logoutButton = new Button("Logout");  
    private DockPanel panel = new DockPanel();  
    private HTML html = new HTML("Welcome to Sandpit.");  

    /**  
     * Create a remote service proxy to talk to the server-side User Data  
     * service.  
     */  
//    private final UserDataServiceAsync userDataService = GWT.create(UserDataService.class);  

    public gwt_class_17() {  

//        this.rpcWidget = new RPCWidget(this);  

        this.initProfileImage();  
        this.initLogoImage();  

        panel.add(picSquare, DockPanel.WEST);  
        panel.add(html, DockPanel.CENTER);  

        VerticalPanel verticalPanel = new VerticalPanel();  
        verticalPanel.add(logo);  
        verticalPanel.add(logoutButton);  

        panel.add(verticalPanel, DockPanel.EAST);  

//        panel.add(rpcWidget, DockPanel.SOUTH);  

        initWidget(panel);  

    }  

    private void initProfileImage() {  

        // Display ajaxLoader.gif  
        SandpitImageBundle sib = (SandpitImageBundle) GWT.create(SandpitImageBundle.class);  
        AbstractImagePrototype aip = sib.ajaxLoader();  
        sib.applyTo(this.picSquare);  

    }  

    private void initLogoImage() {  

        // Display logo.jpg  
        SandpitImageBundle sib = (SandpitImageBundle) GWT.create(SandpitImageBundle.class);  
        AbstractImagePrototype aip = sib.logo();  
        aip.applyTo(this.logo);  

    }  

    // Other methods omitted...  
    public interface SandpitImageBundle extends ImageBundle {  

        /**  
         * Would match the file 'logo.jpg', 'logo.gif', or 'logo.png' located in the  
         * same package as this type.  
         */  
        public AbstractImagePrototype logo();  

        public void applyTo(Image picSquare);

		/**  
         * Would match the file 'ajaxLoader.jpg', 'ajaxLoader.gif', or 'ajaxLoader.png' located in the
         * same package as this type.  
         */  
        public AbstractImagePrototype ajaxLoader();  

    }

}  
