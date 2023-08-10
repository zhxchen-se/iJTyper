public class xstream_class_32 {
  public static com.thoughtworks.xstream.XStream instanciateXstreamForHibernate() {
    com.thoughtworks.xstream.XStream xstream1 = new com.thoughtworks.xstream.XStream() {
      protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(final com.thoughtworks.xstream.mapper.MapperWrapper next) {
        return new com.thoughtworks.xstream.hibernate.mapper.HibernateMapper(next);
      }
    };
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter)
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter)
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter)
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter)
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter)
    return xstream1;
  }
}
