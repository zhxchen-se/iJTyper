public class gwt_class_6 {
  public class TitledPanel extends com.google.gwt.user.client.ui.Widget {
    private com.google.gwt.user.client.Element legend;

    private com.google.gwt.user.client.ui.Widget content = null;

    public TitledPanel() {
      com.google.gwt.user.client.Element fieldset = com.google.gwt.user.client.DOM.createFieldSet();
      legend = com.google.gwt.user.client.DOM.createLegend();
      com.google.gwt.user.client.DOM.appendChild(com.google.gwt.user.client.Element,com.google.gwt.user.client.Element)
      <unknown>.setElement(<unknown>)
    }

    public TitledPanel(java.lang.String title) {
      gwt_class_6$TitledPanel.gwt_class_6$TitledPanel()
      gwt_class_6$TitledPanel.setTitle(java.lang.String)
    }

    @java.lang.Override
    public java.lang.String getTitle() {
      return com.google.gwt.user.client.DOM.getInnerHTML(com.google.gwt.user.client.Element);
    }

    @java.lang.Override
    public void setTitle(java.lang.String html) {
      com.google.gwt.user.client.DOM.setInnerHTML(com.google.gwt.user.client.Element,java.lang.String)
    }

    public com.google.gwt.user.client.ui.Widget getContent() {
      return content;
    }

    public void setContent(com.google.gwt.user.client.ui.Widget content) {
      if (this.content != null) {
        com.google.gwt.user.client.DOM.removeChild()
      }
      this.content = content;
      com.google.gwt.user.client.DOM.appendChild()
    }
  }
}
