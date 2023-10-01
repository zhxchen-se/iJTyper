
//ID = 2284635
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_24 {
	
	public abstract class AbstractNotificationWidget extends Composite implements ClickHandler, HasClickHandlers {

		  protected abstract String getUniqueId();

		  @Override
		  public HandlerRegistration addClickHandler(ClickHandler handler) {
		    return addDomHandler(handler, ClickEvent.getType());
		  }

		  @Override
		  public void onClick(ClickEvent event) {
		    doClick(getUniqueId());
		  }

		  protected native void doClick(String name) /*-{
		    $wnd.$("#" + name).click(function () {
		      $wnd.$(this).slideUp("slow");
		      $wnd.$("div", this).fadeOut("slow");
		      });
		  }-*/;

		}
	public class ErrorNotificationWidget extends AbstractNotificationWidget {

		  private final String uniqueId;

		  public ErrorNotificationWidget (String title, String message) {
		    uniqueId = DOM.createUniqueId();

		    Widget w = null;
			initWidget(w);

		    this.getElement().setId(uniqueId);

		    this.addClickHandler(this);
		  }
		  @Override
		  protected String getUniqueId() {
		    return this.uniqueId;
		  }
	}
}
