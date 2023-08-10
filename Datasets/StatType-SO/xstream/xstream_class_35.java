
//http://www.programcreek.com/java-api-examples/index.php?source_dir=sandboxes-master/sandbox-xstream/src/test/java/tryanderror/xstream/EntsoeStyleConverter_Test.java
import org.junit.Test; 
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup; 
import com.thoughtworks.xstream.converters.SingleValueConverter; 
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider; 
import com.thoughtworks.xstream.mapper.Mapper; 
import com.thoughtworks.xstream.mapper.MapperWrapper; 

public class xstream_class_35 { 
    
   public static class AClass{ 
       public String value = "This should be in an attribute"; 
       public CompositeClass  anotherValue = new CompositeClass(); 
   } 
    
   public static class CompositeClass { 
       public Integer value = 42; 
   } 
    
   public static class ToSingleValue implements SingleValueConverter{ 

       @Override 
       public boolean canConvert(Class type) { 
           return CompositeClass.class == type; 
       } 

       @Override 
       public String toString(Object obj) { 
           CompositeClass cCompositeClass = (CompositeClass)obj; 
           return cCompositeClass.value.toString(); 
       } 

       @Override 
       public Object fromString(String str) { 
           return new CompositeClass(); 
       } 
        
   } 
    
   @Test 
   public void testName() throws Exception { 
       XStream xStream = new XStream(); 
       xStream.registerConverter(new ToSingleValue()); 
        
       Mapper mapper = xStream.getMapper(); 
       ReflectionProvider reflectionProvider = xStream.getReflectionProvider(); 
       ConverterLookup converterLookup = xStream.getConverterLookup(); 
       String valueField = null; 
       Converter converter = null;
       xStream.registerConverter(converter); 
       System.out.println(xStream.toXML(new AClass())); 
   } 
    
   protected MapperWrapper wrapMapper(MapperWrapper next) { 
       return next; 
   } 
}