public class gwt_class_6 {
    public class TitledPanel extends com.google.gwt.user.client.ui.Widget {
        private com.google.gwt.user.client.Element legend;

        private com.google.gwt.user.client.ui.Widget content = null;

        public TitledPanel() {
            com.google.gwt.user.client.Element fieldset = com.google.gwt.user.client.DOM.createFieldSet();
            legend = com.google.gwt.user.client.DOM.createLegend();
            com.google.gwt.user.client.DOM.appendChild(fieldset, legend);
            setElement(fieldset);
        }

        public TitledPanel(java.lang.String title) {
            this();
            setTitle(title);
        }

        @java.lang.Override
        public java.lang.String getTitle() {
            return com.google.gwt.user.client.DOM.getInnerHTML(legend);
        }

        @java.lang.Override
        public void setTitle(java.lang.String html) {
            com.google.gwt.user.client.DOM.setInnerHTML(legend, html);
        }

        public com.google.gwt.user.client.ui.Widget getContent() {
            return content;
        }

        public void setContent(com.google.gwt.user.client.ui.Widget content) {
            if (this.content != null) {
                com.google.gwt.user.client.DOM.removeChild(getElement(), this.content.getElement());
            }
            this.content = content;
            com.google.gwt.user.client.DOM.appendChild(getElement(), content.getElement());
        }
    }
}

