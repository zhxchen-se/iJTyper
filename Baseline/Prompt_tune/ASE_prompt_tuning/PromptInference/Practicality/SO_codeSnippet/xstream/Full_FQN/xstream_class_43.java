public class xstream_class_43 {
  public java.util.List<xstream_class_43.Book> books;

  public xstream_class_43(java.util.List<xstream_class_43.Book> books) {
    this.books = books;
  }

  @java.lang.Override
  public java.lang.String toString() {
    java.lang.StringBuilder b = new java.lang.StringBuilder();
    java.lang.StringBuilder.append(java.lang.String)
    for (xstream_class_43.Book book : books) {
      java.lang.StringBuilder.append(java.lang.String)
      java.lang.StringBuilder.append(java.lang.String)
    }
    return java.lang.StringBuilder.toString();
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
    java.util.List<xstream_class_43.Book> books = new java.util.ArrayList<xstream_class_43.Book>();
    java.util.List.add(java.lang.Object)
    xstream_class_43 lib = new xstream_class_43(books);
    // Handles conversion of our objects into XML
    com.thoughtworks.xstream.XStream stream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
    java.lang.String xml = com.thoughtworks.xstream.XStream.toXML(xstream_class_43);
    // fromXML returns a general Object; need to cast it into a Library
    xstream_class_43 lib2 = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(java.lang.Object)
    java.io.PrintStream.println(java.lang.Object)
    java.io.PrintStream.println(java.lang.String)
  }
}
