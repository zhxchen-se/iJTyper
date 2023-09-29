public class Android43 {
  public static java.lang.String main(java.lang.String[] args) {
    org.apache.http.HttpHost target = new org.apache.http.HttpHost("google.com", 80);
    org.apache.http.client.methods.HttpGet get = new org.apache.http.client.methods.HttpGet("/");
    java.lang.String result = null;
    org.apache.http.HttpEntity entity = null;
    org.apache.http.client.HttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
    try {
      org.apache.http.HttpResponse response = org.apache.http.client.HttpClient.execute(org.apache.http.HttpHost,org.apache.http.client.methods.HttpGet);
      entity = org.apache.http.HttpResponse.getEntity();
      result = org.apache.http.util.EntityUtils.toString(org.apache.http.HttpEntity);
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    } finally {
      if (entity != null) {
      }
      try {
        org.apache.http.HttpEntity.consumeContent()
      } catch (java.io.IOException e) {
      }
    }
    return result;
  }
}
