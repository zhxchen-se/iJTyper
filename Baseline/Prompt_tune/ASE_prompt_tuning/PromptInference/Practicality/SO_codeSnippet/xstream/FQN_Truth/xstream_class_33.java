public class xstream_class_33 {
    private static com.thoughtworks.xstream.XStream xstream;

    public static com.thoughtworks.xstream.XStream getXStream() {
        if (xstream_class_33.xstream == null) {
            xstream_class_33.xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
            xstream_class_33.xstream.alias("ActionMessage", flex.messaging.io.amf.ActionMessage.class);
            xstream_class_33.xstream.alias("MessageHeader", flex.messaging.io.amf.MessageHeader.class);
            xstream_class_33.xstream.alias("MessageBody", flex.messaging.io.amf.MessageBody.class);
            xstream_class_33.xstream.alias("RemotingMessage", flex.messaging.messages.RemotingMessage.class);
            xstream_class_33.xstream.alias("CommandMessage", flex.messaging.messages.CommandMessage.class);
            xstream_class_33.xstream.alias("AcknowledgeMessage", flex.messaging.messages.AcknowledgeMessage.class);
            xstream_class_33.xstream.alias("ErrorMessage", flex.messaging.messages.ErrorMessage.class);
            xstream_class_33.xstream.alias("ASObject", flex.messaging.io.amf.ASObject.class);
            xstream_class_33.xstream.alias("AsyncMessage", flex.messaging.messages.AsyncMessage.class);
            xstream_class_33.xstream.alias("DSC", flex.messaging.messages.CommandMessageExt.class);
            xstream_class_33.xstream.alias("DSK", flex.messaging.messages.AcknowledgeMessageExt.class);
            // Better ASObject Converter
            com.thoughtworks.xstream.mapper.Mapper mapper = xstream_class_33.xstream.getMapper();
        }
        return xstream_class_33.xstream;
    }
}

