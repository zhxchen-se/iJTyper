
//ID = 3353405
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


public class gwt_class_45  implements EntryPoint{

    @Override
    public void onModuleLoad(){
        Label label=new Label("hello world");
        Button button=new Button("say something");
        button.addClickHandler(new ClickHandler(){
     @Override
     public void onClick (ClickEvent event){
         Window.alert("hello again");

            }



        });

    RootPanel.get().add(label);
    RootPanel.get().add(button);



    }
}