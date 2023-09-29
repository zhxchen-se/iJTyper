public class Android30 {
    public static java.lang.String main(java.lang.String[] args) {
        org.apache.http.HttpHost target = new org.apache.http.HttpHost("http://" + android.ServiceWrapper.SERVER_HOST, android.ServiceWrapper.SERVER_PORT);
        org.apache.http.client.methods.HttpGet get = new org.apache.http.client.methods.HttpGet("/list");
        java.lang.String result = null;
        org.apache.http.HttpEntity entity = null;
        org.apache.http.client.HttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
        try {
            org.apache.http.HttpResponse response = client.execute(target, get);
            entity = response.getEntity();
            result = org.apache.http.util.EntityUtils.toString(entity);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (java.io.IOException e) {
                }
            }
        }
        return result;
    }
}

class ServiceWrapper {
    static java.lang.String SERVER_HOST = "host";

    static int SERVER_PORT = 8080;
}

