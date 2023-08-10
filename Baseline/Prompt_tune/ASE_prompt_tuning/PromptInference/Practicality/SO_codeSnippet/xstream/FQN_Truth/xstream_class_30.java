public class xstream_class_30 implements com.thoughtworks.xstream.converters.Converter {
    @java.lang.Override
    public void marshal(java.lang.Object o, com.thoughtworks.xstream.io.HierarchicalStreamWriter hierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext marshallingContext) {
        // implement logic for marshalling to xml
    }

    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader hierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext unmarshallingContext) {
        xstream.xstream_class_30.Items items = new xstream.xstream_class_30.Items();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            final java.lang.String currentAttribute = hierarchicalStreamReader.getAttribute("name");
            if ("id".equals(currentAttribute)) {
                items.setId(hierarchicalStreamReader.getValue());
            } else if ("first-name".equals(currentAttribute)) {
                items.setFirstName(hierarchicalStreamReader.getValue());
            } else if ("last-name".equals(currentAttribute)) {
                items.setLastName(hierarchicalStreamReader.getValue());
            } else if ("address".equals(currentAttribute)) {
                items.setAddress(hierarchicalStreamReader.getValue());
            } else if ("zip".equals(currentAttribute)) {
                items.setZip(hierarchicalStreamReader.getValue());
            }
            hierarchicalStreamReader.moveUp();
        } 
        return items;
    }

    @java.lang.Override
    public boolean canConvert(java.lang.Class aClass) {
        return aClass == xstream.xstream_class_30.Items.class;
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

