public class gwt_class_49 {
  private void putElementLinkIDsInList(com.google.gwt.dom.client.BodyElement elt, java.util.ArrayList list) {
  }

  /* -{


  /**
  Find all anchor tags and if any point outside the site, redirect them to a
  "blocked" page.
   */
  private void rewriteLinksIterative() {
    java.util.ArrayList links = new java.util.ArrayList();
    gwt_class_49.putElementLinkIDsInList(com.google.gwt.dom.client.BodyElement,java.util.ArrayList)
    for (int i = 0; i < java.util.ArrayList.size(); i++) {
      com.google.gwt.user.client.Element elt = com.google.gwt.user.client.DOM.getElementById(java.lang.String);
      gwt_class_49.rewriteLink(com.google.gwt.user.client.Element,java.lang.String)
    }
  }

  /**
   * Block all accesses out of the website that don't match 'sitename'
   *
   * @param element
   * 		An anchor link element
   * @param sitename
   * 		name of the website to check. e.g. "www.example.com"
   */
  private void rewriteLink(com.google.gwt.user.client.Element element, java.lang.String sitename) {
    java.lang.String href = com.google.gwt.user.client.DOM.getElementProperty(com.google.gwt.user.client.Element,java.lang.String);
    if (null == href) {
      return;
    }
    // We want to re-write absolute URLs that go outside of this site
    if (java.lang.String.startsWith(java.lang.String) && (!java.lang.String.startsWith(java.lang.String))) {
      com.google.gwt.user.client.DOM.setElementProperty(com.google.gwt.user.client.Element,java.lang.String,java.lang.String)
    }
  }
}
