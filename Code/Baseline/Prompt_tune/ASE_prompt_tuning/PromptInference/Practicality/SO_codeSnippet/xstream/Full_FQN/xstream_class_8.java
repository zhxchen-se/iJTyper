public class xstream_class_8 extends android.app.Activity {
  private java.lang.String METHOD_NAME = "getName";// our webservice method name


  private java.lang.String NAMESPACE = "http://webservice.app";// Here package


  // name in
  // webservice
  // with reverse
  // order.
  private java.lang.String SOAP_ACTION = "http://webservice.app/getName";// NAMESPACE


  // +
  // method
  public android.widget.TextView t;// name


  private static java.lang.String URL = "http://ip/WS/services/Service?wsdl";

  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    // Initialize soap request + add parameters
    org.ksoap2.serialization.SoapObject request = new org.ksoap2.serialization.SoapObject(NAMESPACE, METHOD_NAME);
    org.ksoap2.serialization.SoapObject.addProperty(java.lang.String,java.lang.String)
    org.ksoap2.serialization.SoapObject.addProperty(java.lang.String,java.lang.String)
    org.ksoap2.serialization.SoapSerializationEnvelope envelope = new org.ksoap2.serialization.SoapSerializationEnvelope(org.ksoap2.SoapEnvelope.VER11);
    org.ksoap2.serialization.SoapSerializationEnvelope.setOutputSoapObject(org.ksoap2.serialization.SoapObject)
    // Make the soap call.
    org.ksoap2.transport.HttpTransportSE androidHttpTransport = new org.ksoap2.transport.HttpTransportSE(xstream_class_8.URL);
    // this is the actual part that will call the webservice
    try {
      org.ksoap2.transport.HttpTransportSE.call(java.lang.String,org.ksoap2.serialization.SoapSerializationEnvelope)
      org.ksoap2.serialization.SoapObject result = ((org.ksoap2.serialization.SoapObject) (envelope.bodyIn));
      // SoapObject result = (SoapObject) envelope.response();
      if (result != null) {
        com.thoughtworks.xstream.XStream xstreams = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
        java.lang.String text = org.ksoap2.serialization.SoapObject.getProperty(int)###<unknown>.toString();
      }
    } catch (java.lang.Exception e) {
      android.widget.TextView.setText(java.lang.String)
    }
  }
}
