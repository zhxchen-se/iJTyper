
//http://www.dreamincode.net/forums/topic/240464-xstream-attribute-and-values-not-clear/
import java.util.ArrayList;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class xstream_class_37 {
	public class FieldDtoConvertor implements Converter {

		public boolean canConvert(Class clazz) {
			return clazz.equals(FieldDto.class);
		}

		public void marshal(final Object value,
	            final HierarchicalStreamWriter writer,
	            final MarshallingContext context) {
	    final FieldDto fieldDto = (FieldDto) value;
	    for (int i = 0; i < fieldDto.getSize(); i++){
	    	writer.addAttribute(fieldDto.getAttributeName(i), fieldDto.getAttributeValue(i));
	    }
	    writer.setValue(fieldDto.getText());
	}

		public Object unmarshal(HierarchicalStreamReader reader,
				UnmarshallingContext context) {
			FieldDto fieldDto = new FieldDto();
			for (int i = 0; i < reader.getAttributeCount(); i++){
				fieldDto.addAttribute(reader.getAttributeName(i), reader.getAttribute(i));
			}
			fieldDto.setText(reader.getValue());
			return fieldDto;
		}
	}
	public class FieldDto {
		private ArrayList<String> attributeName = null;
		private ArrayList<String> attributeValue = null;
		private String text;

		public FieldDto(){
			attributeName = new ArrayList<String>();
			attributeValue = new ArrayList<String>();
		}
		
		public String getAttributeName(int index) {
			return attributeName.get(index);
		}

		public void addAttribute(String attributeName, String attributeValue) {
			this.attributeName.add(attributeName);
			this.attributeValue.add(attributeValue);
		}

		public String getAttributeValue(int index) {
			return attributeValue.get(index);
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
		public int getSize(){
			return attributeName.size();
		}	
	}


}
