
//http://www.programcreek.com/java-api-examples/index.php?api=com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter;
import com.thoughtworks.xstream.hibernate.mapper.HibernateMapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_32{
	public static XStream instanciateXstreamForHibernate() {
	    XStream xstream1 =new XStream() {
	        protected MapperWrapper wrapMapper(final MapperWrapper next) {
	            return new HibernateMapper(next);
	        }
	    };
	    xstream1.registerConverter(new HibernateProxyConverter());
	    xstream1.registerConverter(new HibernatePersistentCollectionConverter(xstream1.getMapper()));
	    xstream1.registerConverter(new HibernatePersistentMapConverter(xstream1.getMapper()));
	    xstream1.registerConverter(new HibernatePersistentSortedMapConverter(xstream1.getMapper()));
	    xstream1.registerConverter(new HibernatePersistentSortedSetConverter(xstream1.getMapper()));
	    return xstream1;
	}
	 
}
