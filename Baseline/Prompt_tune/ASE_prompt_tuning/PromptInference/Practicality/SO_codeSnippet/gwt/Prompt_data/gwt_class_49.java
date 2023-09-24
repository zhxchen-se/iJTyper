[
  {
    "maskCode": "private void putElementLinkIDsInList(<mask><mask><mask>.BodyElement elt, ArrayList list) {",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(<mask><mask><mask>.BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i));"
  },
  {
    "maskCode": "private void putElementLinkIDsInList(BodyElement elt, <mask><mask><mask>.ArrayList list) {",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, <mask><mask><mask>.ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i));"
  },
  {
    "maskCode": "<mask><mask><mask>.ArrayList links = new ArrayList();",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { <mask><mask><mask>.ArrayList links = new ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i));"
  },
  {
    "maskCode": "ArrayList links = new <mask><mask><mask>.ArrayList();",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new <mask><mask><mask>.ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i));"
  },
  {
    "maskCode": "putElementLinkIDsInList(<mask><mask><mask>.Document.get().getBody(), links);",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new ArrayList(); putElementLinkIDsInList(<mask><mask><mask>.Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i)); rewriteLink(elt, String);"
  },
  {
    "maskCode": "<mask><mask><mask>.Element elt = DOM.getElementById((String) links.get(i));",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { <mask><mask><mask>.Element elt = DOM.getElementById((String) links.get(i)); rewriteLink(elt, String); } } /** * Block all accesses out of the website that don't match 'sitename' * * @param element * An anchor link element * @param sitename * name of the website to check. e.g. String */ private void rewriteLink(Element element, String sitename) { String href = DOM.getElementProperty(element, String);"
  },
  {
    "maskCode": "Element elt = <mask><mask><mask>.DOM.getElementById((String) links.get(i));",
    "Glob_context": "//ID = 3954392 public class gwt_class_49 { private void putElementLinkIDsInList(BodyElement elt, ArrayList list) { }/*-{ /** * Find all anchor tags and if any point outside the site, redirect them to a * String page. */ private void rewriteLinksIterative() { ArrayList links = new ArrayList(); putElementLinkIDsInList(Document.get().getBody(), links); for (int i = 0; i < links.size(); i++) { Element elt = <mask><mask><mask>.DOM.getElementById((String) links.get(i)); rewriteLink(elt, String); } } /** * Block all accesses out of the website that don't match 'sitename' * * @param element * An anchor link element * @param sitename * name of the website to check. e.g. String */ private void rewriteLink(Element element, String sitename) { String href = DOM.getElementProperty(element, String);"
  },
  {
    "maskCode": "private void rewriteLink(<mask><mask><mask>.Element element, String sitename) {",
    "Glob_context": "for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i)); rewriteLink(elt, String); } } /** * Block all accesses out of the website that don't match 'sitename' * * @param element * An anchor link element * @param sitename * name of the website to check. e.g. String */ private void rewriteLink(<mask><mask><mask>.Element element, String sitename) { String href = DOM.getElementProperty(element, String); if (null == href) { return; } // We want to re-write absolute URLs that go outside of this site if (href.startsWith(String) && !href.startsWith(String + sitename + String)) { DOM.setElementProperty(element, String, String + sitename + String);"
  },
  {
    "maskCode": "String href = <mask><mask><mask>.DOM.getElementProperty(element, String);",
    "Glob_context": "for (int i = 0; i < links.size(); i++) { Element elt = DOM.getElementById((String) links.get(i)); rewriteLink(elt, String); } } /** * Block all accesses out of the website that don't match 'sitename' * * @param element * An anchor link element * @param sitename * name of the website to check. e.g. String */ private void rewriteLink(Element element, String sitename) { String href = <mask><mask><mask>.DOM.getElementProperty(element, String); if (null == href) { return; } // We want to re-write absolute URLs that go outside of this site if (href.startsWith(String) && !href.startsWith(String + sitename + String)) { DOM.setElementProperty(element, String, String + sitename + String);"
  },
  {
    "maskCode": "<mask><mask><mask>.DOM.setElementProperty(element, String, String + sitename",
    "Glob_context": "} } /** * Block all accesses out of the website that don't match 'sitename' * * @param element * An anchor link element * @param sitename * name of the website to check. e.g. String */ private void rewriteLink(Element element, String sitename) { String href = DOM.getElementProperty(element, String); if (null == href) { return; } // We want to re-write absolute URLs that go outside of this site if (href.startsWith(String) && !href.startsWith(String + sitename + String)) { <mask><mask><mask>.DOM.setElementProperty(element, String, String + sitename + String); } } };"
  }
]