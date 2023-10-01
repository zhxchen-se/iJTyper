public class xstream_class_8 extends android.app.Activity {

	private String METHOD_NAME = "getName"; // our webservice method name
	private String NAMESPACE = "http://webservice.app"; // Here package
														// name in
														// webservice
														// with reverse
														// order.
	private String SOAP_ACTION = "http://webservice.app/getName"; // NAMESPACE
																	// +
																	// method
	public android.widget.TextView t; // name

	private static String URL = "http://ip/WS/services/Service?wsdl";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Initialize soap request + add parameters
		org.ksoap2.serialization.SoapObject request = new org.ksoap2.serialization.SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("user", "user");
		request.addProperty("passwort", "passwort");

		org.ksoap2.serialization.SoapSerializationEnvelope envelope = new org.ksoap2.serialization.SoapSerializationEnvelope(org.ksoap2.SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);

		// Make the soap call.
		org.ksoap2.transport.HttpTransportSE androidHttpTransport = new org.ksoap2.transport.HttpTransportSE(URL);
		// this is the actual part that will call the webservice
		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			org.ksoap2.serialization.SoapObject result = (org.ksoap2.serialization.SoapObject) envelope.bodyIn;

			//SoapObject result = (SoapObject) envelope.response();

			if (result != null) {

				com.thoughtworks.xstream.XStream xstreams = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
				String text = result.getProperty(0).toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.setText("FEHLER");

		}

	}

}