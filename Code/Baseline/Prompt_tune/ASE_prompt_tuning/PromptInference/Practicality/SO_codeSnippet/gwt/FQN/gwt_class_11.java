public class gwt_class_11 implements com.google.gwt.core.client.EntryPoint {
    com.google.gwt.user.client.ui.HorizontalPanel dictionaryPanel;

    com.google.gwt.user.client.ui.Label wordLabel;

    public gwt_class_11() {
        dictionaryPanel = new com.google.gwt.user.client.ui.HorizontalPanel();
        wordLabel = new com.google.gwt.user.client.ui.Label("Word");
    }

    @java.lang.Override
    public void onModuleLoad() {
        dictionaryPanel.add(wordLabel);
        com.google.gwt.user.client.ui.RootPanel.get("dictionary").add(dictionaryPanel);
    }
}

