public class gwt_class_49 {
    private void putElementLinkIDsInList(BodyElement elt, ArrayList list) {
    }

    private void rewriteLinksIterative() {
        ArrayList links = new ArrayList();
        putElementLinkIDsInList(Document.get().getBody(), links);
        for (int i = 0; i < links.size(); i++) {
            Element elt = DOM.getElementById(((java.lang.String) (links.get(i))));
            rewriteLink(elt, "www.example.com");
        }
    }

    private void rewriteLink(Element element, java.lang.String sitename) {
        java.lang.String href = DOM.getElementProperty(element, "href");
        if (null == href) {
            return;
        }
        if (href.startsWith("http://") && (!href.startsWith(("http://" + sitename) + "/"))) {
            DOM.setElementProperty(element, "href", ("http://" + sitename) + "/Blocked.html");
        }
    }
}

