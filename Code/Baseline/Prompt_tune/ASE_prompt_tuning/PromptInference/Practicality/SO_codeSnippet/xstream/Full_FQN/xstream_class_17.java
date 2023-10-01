public final class xstream_class_17 {
  public static void main(java.lang.String[] args) {
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
    com.thoughtworks.xstream.XStream.autodetectAnnotations(boolean)
    com.thoughtworks.xstream.XStream.registerConverter(xstream_class_17$PositionConverter)
    final xstream_class_17.Position position = new xstream_class_17.Position();
    xstream_class_17$Position.setTitle(java.lang.String)
    xstream_class_17$Position.setStartDate(java.lang.String)
    xstream_class_17$Position.setEndDate(java.lang.String)
    final java.lang.String xml = com.thoughtworks.xstream.XStream.toXML(xstream_class_17$Position);
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(java.lang.String)
    final xstream_class_17.Position genPosition = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(java.lang.String)
  }

  @com.thoughtworks.xstream.annotations.XStreamAlias("Position")
  private static class Position {
    public java.lang.String getEndDate() {
      return endDate;
    }

    public void setEndDate(java.lang.String endDate) {
      this.endDate = endDate;
    }

    public java.lang.String getStartDate() {
      return startDate;
    }

    public void setStartDate(java.lang.String startDate) {
      this.startDate = startDate;
    }

    public java.lang.String getTitle() {
      return title;
    }

    public void setTitle(java.lang.String title) {
      this.title = title;
    }

    private java.lang.String title;

    private java.lang.String startDate;

    private java.lang.String endDate;
  }

  private static class PositionConverter implements com.thoughtworks.xstream.converters.Converter {
    public boolean canConvert(java.lang.Class clazz) {
      return xstream_class_17.Position.class == clazz;
    }

    public void marshal(java.lang.Object value, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      xstream_class_17.Position position = ((xstream_class_17.Position) (value));
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
    }

    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      xstream_class_17.Position position = new xstream_class_17.Position();
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      java.lang.String title = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
      xstream_class_17$Position.setTitle(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveUp()
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      java.lang.String startDate = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
      xstream_class_17$Position.setStartDate(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveUp()
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      java.lang.String endDate = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
      xstream_class_17$Position.setEndDate(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveUp()
      return position;
    }
  }
}
