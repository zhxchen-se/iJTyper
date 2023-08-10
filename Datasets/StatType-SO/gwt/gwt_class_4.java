
//ID = 1318732
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
public class gwt_class_4{
	public class MyView extends Composite
	{
	    private VerticalSplitPanel mainPanel=new VerticalSplitPanel();

	    public void CountryFilterView()
	    {    

	     mainPanel.setSize("100%", "100%");
	     mainPanel.setSplitPosition("50%");
	     // Add some content
	        String randomText = "This is some text to show how the contents on either "
	            + "side of the splitter flow.   "
	            + "This is some text to show how the contents on either "
	            + "side of the splitter flow.   "
	            + "This is some text to show how the contents on either "
	            + "side of the splitter flow.   ";
	        mainPanel.setTopWidget(new HTML(randomText));
	        mainPanel.setBottomWidget(new HTML(randomText));
	        initWidget(mainPanel);
	    }
	}
}
