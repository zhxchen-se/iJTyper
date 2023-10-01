public class xstream_class_13 {
    public class MyClassAliasingMapper extends com.thoughtworks.xstream.mapper.ClassAliasingMapper {
        public MyClassAliasingMapper(com.thoughtworks.xstream.mapper.Mapper wrapped) {
            super(wrapped);
        }

        @java.lang.Override
        public java.lang.Class realClass(java.lang.String elementName) {
            try {
            } catch (java.lang.Exception e) {
                // do nothing we fall back on super's implementation
            }
            return super.realClass(elementName);
        }

        @java.lang.Override
        public java.lang.String serializedClass(java.lang.Class type) {
            try {
            } catch (java.lang.Exception e) {
                // do nothing we fall back on super's implementation
            }
            return super.serializedClass(type);
        }
    }
}

