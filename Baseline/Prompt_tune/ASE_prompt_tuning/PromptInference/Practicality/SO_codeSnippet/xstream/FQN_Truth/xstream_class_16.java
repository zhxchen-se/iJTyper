public class xstream_class_16 {
    public static void main(java.lang.String[] arg) {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream() {
            @java.lang.Override
            protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(com.thoughtworks.xstream.mapper.MapperWrapper next) {
                return new com.thoughtworks.xstream.mapper.MapperWrapper(next) {
                    @java.lang.Override
                    public boolean shouldSerializeMember(java.lang.Class definedIn, java.lang.String fieldName) {
                        if (definedIn == java.lang.Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
    }
}

