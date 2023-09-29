public class Android47 extends android.app.Activity {
    /**
     * Called when the activity is first created.
     */
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        org.apache.http.impl.client.DefaultHttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
        org.apache.http.client.methods.HttpGet method = new org.apache.http.client.methods.HttpGet("http://www.google.com");
        try {
            client.execute(method);
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.lay)));
            t.setText("Ok");
        } catch (org.apache.http.client.ClientProtocolException e) {
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.lay)));
            t.setText(e.getMessage());
        } catch (java.io.IOException e) {
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.lay)));
            t.setText(e.getMessage());
        }
    }
}

