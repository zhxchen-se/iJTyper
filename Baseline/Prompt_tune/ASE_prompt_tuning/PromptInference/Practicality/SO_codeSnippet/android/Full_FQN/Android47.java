public class Android47 extends android.app.Activity {
  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    org.apache.http.impl.client.DefaultHttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
    org.apache.http.client.methods.HttpGet method = new org.apache.http.client.methods.HttpGet("http://www.google.com");
    try {
      org.apache.http.impl.client.DefaultHttpClient.execute(org.apache.http.client.methods.HttpGet)
      android.widget.TextView t = <unknown>.findViewById(<unknown>);
      android.widget.TextView.setText(java.lang.String)
    } catch (org.apache.http.client.ClientProtocolException e) {
      android.widget.TextView t = <unknown>.findViewById(<unknown>);
      android.widget.TextView.setText()
    } catch (java.io.IOException e) {
      android.widget.TextView t = <unknown>.findViewById(<unknown>);
      android.widget.TextView.setText(java.lang.String)
    }
  }
}
