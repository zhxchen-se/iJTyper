

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.Mapper;

import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.MessageBody;
import flex.messaging.io.amf.MessageHeader;
import flex.messaging.messages.AcknowledgeMessage;
import flex.messaging.messages.AcknowledgeMessageExt;
import flex.messaging.messages.AsyncMessage;
import flex.messaging.messages.CommandMessage;
import flex.messaging.messages.CommandMessageExt;
import flex.messaging.messages.ErrorMessage;
import flex.messaging.messages.RemotingMessage;

public class xstream_class_33 {
	private static XStream xstream; 
	public static XStream getXStream() {
		if (xstream == null) {
			xstream = new XStream(new DomDriver());

			xstream.alias("ActionMessage", ActionMessage.class);
			xstream.alias("MessageHeader", MessageHeader.class);
			xstream.alias("MessageBody", MessageBody.class);
			xstream.alias("RemotingMessage", RemotingMessage.class);
			xstream.alias("CommandMessage", CommandMessage.class);
			xstream.alias("AcknowledgeMessage", AcknowledgeMessage.class);
			xstream.alias("ErrorMessage", ErrorMessage.class);
			xstream.alias("ASObject", ASObject.class);
			xstream.alias("AsyncMessage", AsyncMessage.class);
			xstream.alias("DSC", CommandMessageExt.class);
			xstream.alias("DSK", AcknowledgeMessageExt.class);

			// Better ASObject Converter
			Mapper mapper = xstream.getMapper();
		}

		return xstream;
	}
}
