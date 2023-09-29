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
        putElementLinkIDsInList(com.google.gwt.dom.client.Document.get().getBody(), links);
        for (int i = 0; i < links.size(); i++) {
            com.google.gwt.user.client.Element elt = com.google.gwt.user.client.DOM.getElementById(((java.lang.String) (links.get(i))));
            rewriteLink(elt, "www.example.com");
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
        java.lang.String href = com.google.gwt.user.client.DOM.getElementProperty(element, "href");
        if (null == href) {
            return;
        }
        // We want to re-write absolute URLs that go outside of this site
        if (href.startsWith("http://") && (!href.startsWith(("http://" + sitename) + "/"))) {
            com.google.gwt.user.client.DOM.setElementProperty(element, "href", ("http://" + sitename) + "/Blocked.html");
        }
    }
}

