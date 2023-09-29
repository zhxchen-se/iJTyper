public class xstream_class_32 {
    public static com.thoughtworks.xstream.XStream instanciateXstreamForHibernate() {
        com.thoughtworks.xstream.XStream xstream1 = new com.thoughtworks.xstream.XStream() {
            protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(final com.thoughtworks.xstream.mapper.MapperWrapper next) {
                return new com.thoughtworks.xstream.hibernate.mapper.HibernateMapper(next);
            }
        };
        xstream1.registerConverter(new com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter());
        xstream1.registerConverter(new com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter(xstream1.getMapper()));
        xstream1.registerConverter(new com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter(xstream1.getMapper()));
        xstream1.registerConverter(new com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter(xstream1.getMapper()));
        xstream1.registerConverter(new com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter(xstream1.getMapper()));
        return xstream1;
    }
}

