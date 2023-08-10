package java.gwt;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.RootPanel;


public class gt10 {
       public void onModuleLoad()
       {
           HorizontalSplitPanel split = new HorizontalSplitPanel();
           DecoratorPanel dp = new DecoratorPanel();
           RootPanel.get().add(dp);
       }
}
