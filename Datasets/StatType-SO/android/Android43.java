package androidExamples;
//ID = 1200688
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Android43 {

	public static String main(String[] args) {
		HttpHost target = new HttpHost("google.com", 80);
	HttpGet get = new HttpGet("/");
	String result = null;
	HttpEntity entity = null;
	HttpClient client = new DefaultHttpClient();
	try {
	    HttpResponse response=client.execute(target, get);
	    entity = response.getEntity();
	    result = EntityUtils.toString(entity);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (entity!=null){}
	     try {
	      entity.consumeContent();
	     } catch (IOException e) {}
	}
	return result;}

}
