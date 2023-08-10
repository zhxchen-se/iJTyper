package java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.ClassAliasingMapper;
import junit.framework.Test;

public class xt20 {
    public static void h1(){
        XStream xstream = new XStream();
        ClassAliasingMapper mapper = new ClassAliasingMapper(xstream.getMapper());
        xstream.registerLocalConverter(Test.class, "tags", new CollectionConverter(mapper));
    }
}
