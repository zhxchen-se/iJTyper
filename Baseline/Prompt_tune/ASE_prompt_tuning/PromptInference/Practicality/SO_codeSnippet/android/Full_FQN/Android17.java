public class Android17 {
  private void Login() {
    org.apache.http.client.HttpClient httpClient = new org.apache.http.impl.client.DefaultHttpClient();
    try {
      java.lang.String url = "http://192.168.1.5:8000/Login?username=test&password=test";
      org.apache.http.client.methods.HttpGet method = new org.apache.http.client.methods.HttpGet(new java.net.URI(url));
      org.apache.http.HttpResponse response = org.apache.http.client.HttpClient.execute(org.apache.http.client.methods.HttpGet);
      if (response != null) {
        android.util.Log.i(java.lang.String)
      } else {
        android.util.Log.i(java.lang.String,java.lang.String)
      }
    } catch (java.io.IOException e) {
      android.util.Log.e(java.lang.String,java.lang.String)
    } catch (java.net.URISyntaxException e) {
      android.util.Log.e(java.lang.String,java.lang.String)
    }
  }

  private java.lang.String getResponse(org.apache.http.HttpEntity entity) {
    java.lang.String response = "";
    try {
      int length = org.apache.http.HttpEntity.getContentLength();
      java.lang.StringBuffer sb = new java.lang.StringBuffer(length);
      java.io.InputStreamReader isr = new java.io.InputStreamReader(org.apache.http.HttpEntity.getContent(), "UTF-8");
      char[] buff = new char[length];
      int cnt;
      while ((cnt = java.io.InputStreamReader.read(char[],int,int)) > 0) {
        java.lang.StringBuffer.append(char[],int,int)
      } 
      response = java.lang.StringBuffer.toString();
      java.io.InputStreamReader.close()
    } catch (java.io.IOException ioe) {
      java.lang.Throwable.printStackTrace()
    }
    return response;
  }
}
