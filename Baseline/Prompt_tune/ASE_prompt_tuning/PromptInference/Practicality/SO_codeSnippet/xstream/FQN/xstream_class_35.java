public class xstream_class_35 {
    public static class AClass {
        public java.lang.String value = "This should be in an attribute";

        public xstream_class_35.CompositeClass anotherValue = new xstream_class_35.CompositeClass();
    }

    public static class CompositeClass {
        public java.lang.Integer value = 42;
    }

    public static class ToSingleValue implements com.thoughtworks.xstream.converters.SingleValueConverter {
        @java.lang.Override
        public boolean canConvert(java.lang.Class type) {
            return xstream_class_35.CompositeClass.class == type;
        }

        @java.lang.Override
        public java.lang.String toString(java.lang.Object obj) {
            xstream_class_35.CompositeClass cCompositeClass = ((xstream_class_35.CompositeClass) (obj));
            return cCompositeClass.value.toString();
        }

        @java.lang.Override
        public java.lang.Object fromString(java.lang.String str) {
            return new xstream_class_35.CompositeClass();
        }
    }

    @org.junit.Test
    public void testName() throws java.lang.Exception {
        com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream();
        xStream.registerConverter(new xstream_class_35.ToSingleValue());
        com.thoughtworks.xstream.mapper.Mapper mapper = xStream.getMapper();
        com.thoughtworks.xstream.converters.reflection.ReflectionProvider reflectionProvider = xStream.getReflectionProvider();
        com.thoughtworks.xstream.converters.ConverterLookup converterLookup = xStream.getConverterLookup();
        java.lang.String valueField = null;
        com.thoughtworks.xstream.converters.Converter converter = null;
        xStream.registerConverter(converter);
        java.lang.System.out.println(xStream.toXML(new xstream_class_35.AClass()));
    }

    protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(com.thoughtworks.xstream.mapper.MapperWrapper next) {
        return next;
    }
}

