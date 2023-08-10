package java.gwt;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.History;

import java.awt.*;

public class gt2 {

public final void onValueChange(final ValueChangeEvent<String> event) {
    String token = event.getValue();
    if (token != null) {
        String[] tokens = History.getToken().split(":");
        }
    }
}
