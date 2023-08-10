public class gwt_class_4 {
    public class MyView extends com.google.gwt.user.client.ui.Composite {
        private com.google.gwt.user.client.ui.VerticalSplitPanel mainPanel = new com.google.gwt.user.client.ui.VerticalSplitPanel();

        public void CountryFilterView() {
            mainPanel.setSize("100%", "100%");
            mainPanel.setSplitPosition("50%");
            // Add some content
            java.lang.String randomText = "This is some text to show how the contents on either " + (((("side of the splitter flow.   " + "This is some text to show how the contents on either ") + "side of the splitter flow.   ") + "This is some text to show how the contents on either ") + "side of the splitter flow.   ");
            mainPanel.setTopWidget(new com.google.gwt.user.client.ui.HTML(randomText));
            mainPanel.setBottomWidget(new com.google.gwt.user.client.ui.HTML(randomText));
            initWidget(mainPanel);
        }
    }
}

