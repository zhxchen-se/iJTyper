public class gwt_class_5 {
    private final JsArray<JsArrayInteger> popItemFromArray(final JsArray<JsArrayInteger> oldArray) {
        JsArray<JsArrayInteger> newArray = null;
        for (int i = 0; i < (oldArray.length() - 1); i++) {
            newArray.set(i, oldArray.get(i));
        }
        return newArray;
    }
}

