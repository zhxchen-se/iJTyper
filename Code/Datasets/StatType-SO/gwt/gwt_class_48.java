
//ID = 3635828
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TabBar;
public class gwt_class_48  implements EntryPoint{
    @Override
    public void onModuleLoad(){
        TabBar bar=new TabBar();
        bar.addTab("foo");
        bar.addTab("bar");
        bar.addTab("baz");
         bar.addSelectionHandler(new SelectionHandler(){

             public void onSelection(SelectionEvent event){
                 //let user know what you just did
                 Window.alert("you clicked tab"+event.getSelectedItem());
             }

         });
        // Just for fun, let's disallow selection of 'bar'.
         bar.addBeforeSelectionHandler(new BeforeSelectionHandler() {
          public void onBeforeSelection(BeforeSelectionEvent event) {
          event.cancel();
            }


         });

    }
}