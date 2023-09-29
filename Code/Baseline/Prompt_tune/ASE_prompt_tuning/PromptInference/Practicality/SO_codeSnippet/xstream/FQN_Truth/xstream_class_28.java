public class xstream_class_28 {
	public class MapEntryConverter{
		public class java {

		}

		public boolean canConvert(Class clazz) {
			return java.util.Map.class.isAssignableFrom(clazz);
		}

		public void marshal(Object value, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
			java.util.Map<String, Integer> map = (java.util.Map<String, Integer>) value;
			for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
				writer.startNode(entry.getKey().toString());
				writer.setValue(entry.getValue().toString());
				writer.endNode();
			}
		}

		public Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext context) {
			java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();

			while (reader.hasMoreChildren()) {
				reader.moveDown();
				map.put(reader.getNodeName(), new Integer(reader.getValue()));
				reader.moveUp();
			}
			return map;
		}
	}
}