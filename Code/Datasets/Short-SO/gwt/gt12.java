package java.gwt;


import com.google.gwt.user.client.History;
import javafx.scene.control.Labeled;


public class gt12 {

    public void h1() {
        Labeled label = null;
        if (History.getToken().equals("browse")) {
            label.setText("Here would be some books");
        }
    }

}
