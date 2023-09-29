public class gwt_class_5 {
    private final com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JsArrayInteger> popItemFromArray(final com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JsArrayInteger> oldArray) {
        // the createEmpty...  method is a native method which returns eval("[]")
        com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JsArrayInteger> newArray = null;
        for (int i = 0; i < (oldArray.length() - 1); i++) {
            newArray.set(i, oldArray.get(i));
        }
        return newArray;
    }
}

