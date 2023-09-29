public class xstream_class_1 implements com.thoughtworks.xstream.converters.Converter {
  @java.lang.Override
  public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
    while (com.thoughtworks.xstream.io.HierarchicalStreamReader.hasMoreChildren()) {
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      java.lang.String a;
      if (com.thoughtworks.xstream.io.HierarchicalStreamReader.getNodeName()###<unknown>.equals(java.lang.String)) {
        a = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
      } else if (com.thoughtworks.xstream.io.HierarchicalStreamReader.getNodeName()###<unknown>.equals(java.lang.String)) {
        java.lang.Object b = com.thoughtworks.xstream.converters.UnmarshallingContext.convertAnother(com.thoughtworks.xstream.io.HierarchicalStreamReader,java.lang.Class);
      } else if (com.thoughtworks.xstream.io.HierarchicalStreamReader.getNodeName()###<unknown>.equals(java.lang.String)) {
        a = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
      }
    } 
    return context;
  }

  @java.lang.Override
  public boolean canConvert(java.lang.Class arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @java.lang.Override
  public void marshal(java.lang.Object arg0, com.thoughtworks.xstream.io.HierarchicalStreamWriter arg1, com.thoughtworks.xstream.converters.MarshallingContext arg2) {
    // TODO Auto-generated method stub
  }
}
