public class xstream_class_43 {
    public java.util.List<xstream.xstream_class_43.Book> books;

    public xstream_class_43(java.util.List<xstream.xstream_class_43.Book> books) {
        this.books = books;
    }

    @java.lang.Override
    public java.lang.String toString() {
        java.lang.StringBuilder b = new java.lang.StringBuilder();
        b.append(("Library with " + books.size()) + " books:\n");
        for (xstream.xstream_class_43.Book book : books) {
            b.append(book.toString());
            // Skip a line
            b.append("\n");
        }
        return b.toString();
    }

    public static class Book {
        private java.lang.String title;

        private java.lang.String author;

        public Book(java.lang.String title, java.lang.String author) {
            this.title = title;
            this.author = author;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return (("\"" + title) + "\" by ") + author;
        }
    }

    public static void main(java.lang.String[] args) {
        java.util.List<xstream.xstream_class_43.Book> books = new java.util.ArrayList<xstream.xstream_class_43.Book>();
        books.add(new xstream.xstream_class_43.Book("The Talent Code: Greatness Isn't Born. It's Grown. Here's How", "Daniel Coyle"));
        xstream.xstream_class_43 lib = new xstream.xstream_class_43(books);
        // Handles conversion of our objects into XML
        com.thoughtworks.xstream.XStream stream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
        java.lang.String xml = stream.toXML(lib);
        // fromXML returns a general Object; need to cast it into a Library
        xstream.xstream_class_43 lib2 = ((xstream.xstream_class_43) (stream.fromXML(xml)));
        java.lang.System.out.println(xml);
        java.lang.System.out.println(lib);
        java.lang.System.out.println(lib2);
        java.lang.System.out.println("Libraries equal: " + lib.toString().equals(lib2.toString()));
    }
}

