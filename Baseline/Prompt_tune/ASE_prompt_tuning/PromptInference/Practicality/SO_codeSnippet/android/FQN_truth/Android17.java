public class Android17 {
    private void Login() {
        org.apache.http.client.HttpClient httpClient = new org.apache.http.impl.client.DefaultHttpClient();
        try {
            java.lang.String url = "http://192.168.1.5:8000/Login?username=test&password=test";
            org.apache.http.client.methods.HttpGet method = new org.apache.http.client.methods.HttpGet(new java.net.URI(url));
            org.apache.http.HttpResponse response = httpClient.execute(method);
            if (response != null) {
                android.util.Log.i("login", "received " + getResponse(response.getEntity()));
            } else {
                android.util.Log.i("login", "got a null response");
            }
        } catch (java.io.IOException e) {
            android.util.Log.e("error", e.getMessage());
        } catch (java.net.URISyntaxException e) {
            android.util.Log.e("error", e.getMessage());
        }
    }

    private java.lang.String getResponse(org.apache.http.HttpEntity entity) {
        java.lang.String response = "";
        try {
            int length = ((int) (entity.getContentLength()));
            java.lang.StringBuffer sb = new java.lang.StringBuffer(length);
            java.io.InputStreamReader isr = new java.io.InputStreamReader(entity.getContent(), "UTF-8");
            char[] buff = new char[length];
            int cnt;
            while ((cnt = isr.read(buff, 0, length - 1)) > 0) {
                sb.append(buff, 0, cnt);
            } 
            response = sb.toString();
            isr.close();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        return response;
    }
}

