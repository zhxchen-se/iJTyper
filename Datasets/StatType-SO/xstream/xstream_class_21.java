
//ID=7608007
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class xstream_class_21 {
	static class MyConverter implements Converter {

	    private final Map<String, String> attributes;

	    private final Class<?> clazz;

	    private final Mapper mapper;

	    private final ReflectionProvider reflectionProvider;

	    public MyConverter(Mapper mapper,
	            ReflectionProvider reflectionProvider, Class<?> clazz,
	            Map<String, String> attributes) {
	        super();
	        this.mapper = mapper;
	        this.reflectionProvider = reflectionProvider;
	        this.attributes = attributes;
	        this.clazz = clazz;
	    }

	    @Override
	    public boolean canConvert(Class cls) {
	        return cls == clazz;
	    }

	    @Override
	    public void marshal(Object value, HierarchicalStreamWriter writer,
	            MarshallingContext context) {
	        for (String key : attributes.keySet()) {
	            writer.addAttribute(key, attributes.get(key));
	        }

	        Converter converter = new ReflectionConverter(mapper,
	                reflectionProvider);
	        Object p = null;
			context.convertAnother(p, converter);
	    }

	    @Override
	    public Object unmarshal(HierarchicalStreamReader arg0,
	            UnmarshallingContext arg1) {
	        // TODO Auto-generated method stub
	        return null;
	    }

	}
}
