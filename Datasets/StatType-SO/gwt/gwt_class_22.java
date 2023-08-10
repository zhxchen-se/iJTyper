
//ID = 2237142
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class gwt_class_22 extends Composite {

    private static TestViewUiBinder uiBinder = GWT.create(TestViewUiBinder.class);

    interface TestViewUiBinder extends UiBinder<VerticalPanel, gwt_class_22> {}

    @UiField Label testObjectStringLabel;
    @UiField Label innerObjectStringLabel;
    @UiField VerticalPanel listObjectsPanel;
    @UiField Button button;
    @UiField Label errorMessageLabel;

    public gwt_class_22(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("button")
    void onClick(ClickEvent e) {

    }

}