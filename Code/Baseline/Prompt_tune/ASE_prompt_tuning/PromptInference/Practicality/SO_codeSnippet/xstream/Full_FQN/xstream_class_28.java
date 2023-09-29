public class xstream_class_28 {
  public class MapEntryConverter implements com.thoughtworks.xstream.converters.Converter {
    public class java {}

    public boolean canConvert(java.lang.Class clazz) {
      return java.lang.Class.isAssignableFrom(java.lang.Class);
    }

    public void marshal(java.lang.Object value, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      java.util.Map<java.lang.String, java.lang.Integer> map = ((java.util.Map<java.lang.String, java.lang.Integer>) (value));
      for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : java.util.Map.entrySet()) {
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
      }
    }

    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      java.util.Map<java.lang.String, java.lang.Integer> map = new java.util.HashMap<java.lang.String, java.lang.Integer>();
      while (com.thoughtworks.xstream.io.HierarchicalStreamReader.hasMoreChildren()) {
        com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
        java.util.Map.put(java.lang.Object,java.lang.Object)
        com.thoughtworks.xstream.io.HierarchicalStreamReader.moveUp()
      } 
      return map;
    }
  }
}
