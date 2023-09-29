public class xstream_class_38 {
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();

    @com.thoughtworks.xstream.annotations.XStreamAlias("bookdetails")
    public class BookDetails {
        private int bookId;

        private java.lang.String bookName;

        private int amount;
    }

    @com.thoughtworks.xstream.annotations.XStreamAlias("Books")
    public class Books {
        private java.util.List<xstream_class_38.BookDetails> bookDetails = new java.util.ArrayList<xstream_class_38.BookDetails>();
    }

    public xstream_class_38.BookDetails convertXml(java.lang.String xml) {
        xstream.processAnnotations(xstream_class_38.Books.class);
        xstream.processAnnotations(xstream_class_38.BookDetails.class);
        xstream.addImplicitCollection(xstream_class_38.Books.class, "bookDetails");
        xstream_class_38.Books b = ((xstream_class_38.Books) (xstream.fromXML(xml)));
        // and now you can return your BookDetails element (in case you want only first one)
        return b.bookDetails.get(0);
    }
}

