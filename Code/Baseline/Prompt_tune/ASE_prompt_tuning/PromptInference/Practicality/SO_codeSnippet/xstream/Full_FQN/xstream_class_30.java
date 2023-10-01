public class xstream_class_30 implements com.thoughtworks.xstream.converters.Converter {
  @java.lang.Override
  public void marshal(java.lang.Object o, com.thoughtworks.xstream.io.HierarchicalStreamWriter hierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext marshallingContext) {
    // implement logic for marshalling to xml
  }

  @java.lang.Override
  public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader hierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext unmarshallingContext) {
    xstream_class_30.Items items = new xstream_class_30.Items();
    while (com.thoughtworks.xstream.io.HierarchicalStreamReader.hasMoreChildren()) {
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveDown()
      final java.lang.String currentAttribute = com.thoughtworks.xstream.io.HierarchicalStreamReader.getAttribute(java.lang.String);
      if (java.lang.String.equals(java.lang.Object)) {
        xstream_class_30$Items.setId(java.lang.String)
      } else if (java.lang.String.equals(java.lang.Object)) {
        xstream_class_30$Items.setFirstName(java.lang.String)
      } else if (java.lang.String.equals(java.lang.Object)) {
        xstream_class_30$Items.setLastName(java.lang.String)
      } else if (java.lang.String.equals(java.lang.Object)) {
        xstream_class_30$Items.setAddress(java.lang.String)
      } else if (java.lang.String.equals(java.lang.Object)) {
        xstream_class_30$Items.setZip(java.lang.String)
      }
      com.thoughtworks.xstream.io.HierarchicalStreamReader.moveUp()
    } 
    return items;
  }

  @java.lang.Override
  public boolean canConvert(java.lang.Class aClass) {
    return aClass == xstream_class_30.Items.class;
  }

  public class Items {
    private java.lang.String id;

    private java.lang.String firstName;

    private java.lang.String lastName;

    private java.lang.String address;

    private java.lang.String zip;

    public void setId(java.lang.String id) {
      this.id = id;
    }

    public void setFirstName(java.lang.String firstName) {
      this.firstName = firstName;
    }

    public void setLastName(java.lang.String lastName) {
      this.lastName = lastName;
    }

    public void setAddress(java.lang.String address) {
      this.address = address;
    }

    public void setZip(java.lang.String zip) {
      this.zip = zip;
    }
  }
}
