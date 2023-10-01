
//ID = 5377380
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_16 {
	public static void main(String arg[]){
		XStream xstream = new XStream() {
		    @Override
		    protected MapperWrapper wrapMapper(MapperWrapper next) {
		        return new MapperWrapper(next) {
		            @Override
		            public boolean shouldSerializeMember(Class definedIn, String fieldName) {
		                if (definedIn == Object.class) {
		                    return false;
		                }
		                return super.shouldSerializeMember(definedIn, fieldName);
		            }
		        };
		    }
		};
	}
}
