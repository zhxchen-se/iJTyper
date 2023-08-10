
//12672541
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

public class xstream_class_25 {
	public static void main(String arg[]){
		@XStreamAlias("Object")
		@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" }) class ResponseObject {

		    @XStreamAlias("Type")
		    private String type;

		    private String value;

		    public ResponseObject() {
		    }

		    public String getType() {
		        return type;
		    }

		    public String getValue() {
		        return value;
		    }
		}
	}
}
