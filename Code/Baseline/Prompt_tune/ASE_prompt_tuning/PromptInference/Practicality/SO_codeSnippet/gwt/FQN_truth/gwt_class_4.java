public class gwt_class_4 {
    public class MyView extends Composite {
        private VerticalSplitPanel mainPanel = new VerticalSplitPanel();

        public void CountryFilterView() {
            mainPanel.setSize("100%", "100%");
            mainPanel.setSplitPosition("50%");
            java.lang.String randomText = "This is some text to show how the contents on either " + (((("side of the splitter flow.   " + "This is some text to show how the contents on either ") + "side of the splitter flow.   ") + "This is some text to show how the contents on either ") + "side of the splitter flow.   ");
            mainPanel.setTopWidget(new HTML(randomText));
            mainPanel.setBottomWidget(new HTML(randomText));
            initWidget(mainPanel);
        }
    }
}

