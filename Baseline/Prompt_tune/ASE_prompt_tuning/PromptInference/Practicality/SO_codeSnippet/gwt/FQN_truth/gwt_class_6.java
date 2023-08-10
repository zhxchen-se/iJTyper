public class gwt_class_6 {
    public class TitledPanel extends Widget {
        private Element legend;

        private Widget content = null;

        public TitledPanel() {
            Element fieldset = DOM.createFieldSet();
            legend = DOM.createLegend();
            DOM.appendChild(fieldset, legend);
            setElement(fieldset);
        }

        public TitledPanel(java.lang.String title) {
            this();
            setTitle(title);
        }

        @java.lang.Override
        public java.lang.String getTitle() {
            return DOM.getInnerHTML(legend);
        }

        @java.lang.Override
        public void setTitle(java.lang.String html) {
            DOM.setInnerHTML(legend, html);
        }

        public Widget getContent() {
            return content;
        }

        public void setContent(Widget content) {
            if (this.content != null) {
                DOM.removeChild(getElement(), this.content.getElement());
            }
            this.content = content;
            DOM.appendChild(getElement(), content.getElement());
        }
    }
}

