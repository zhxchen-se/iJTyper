public class gt13 {
    public final void h1(final com.google.gwt.event.logical.shared.ValueChangeEvent<java.lang.String> event) {
        java.lang.String token = event.getValue();
        if (token != null) {
            java.lang.String[] tokens = com.google.gwt.user.client.History.getToken().split(":");
            final java.lang.String token2 = (tokens.length > 1) ? tokens[1] : "";
        }
    }
}

