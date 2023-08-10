public class Android47 extends android.app.Activity {
    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        org.apache.http.impl.client.DefaultHttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
        org.apache.http.client.methods.HttpGet method = new org.apache.http.client.methods.HttpGet("http://www.google.com");
        try {
            client.execute(method);
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.background)));
            t.setText("Ok");
        } catch (org.apache.http.client.ClientProtocolException e) {
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.background)));
            t.setText(e.getMessage());
        } catch (java.io.IOException e) {
            android.widget.TextView t = ((android.widget.TextView) (findViewById(R.id.background)));
            t.setText(e.getMessage());
        }
    }
}

