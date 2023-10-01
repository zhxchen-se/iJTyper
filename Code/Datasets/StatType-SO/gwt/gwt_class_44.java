
//ID = 3313553
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeComposite;

public class gwt_class_44 extends ResizeComposite {

    private static gwt_class_44 instance = null;

    public static void getInstance(final AsyncCallback<gwt_class_44> callback) {
        GWT.runAsync(new RunAsyncCallback() {

            @Override
            public void onSuccess() {
                if (instance == null) {
                    instance = new gwt_class_44();
                }
                callback.onSuccess(instance);
            }

            @Override
            public void onFailure(Throwable reason) {
                callback.onFailure(reason);
            }
        });
    }

    private gwt_class_44() {
        DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
        dockLayoutPanel.addNorth(new Label("North!"), 7);
        dockLayoutPanel.addWest(new Label("West!"), 15);
        dockLayoutPanel.add(new Label("Center! :D"));
        initWidget(dockLayoutPanel);
    }

}
