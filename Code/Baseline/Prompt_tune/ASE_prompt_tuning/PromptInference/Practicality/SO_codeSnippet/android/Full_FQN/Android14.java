public class Android14 {
  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
    try {
      java.net.URL u = new java.net.URL("http://www.path.to/a.mp4?video");
      java.net.HttpURLConnection c = java.net.URL.openConnection();
      java.net.HttpURLConnection.setRequestMethod(java.lang.String)
      java.net.URLConnection.setDoOutput(boolean)
      java.net.URLConnection.connect()
      java.lang.String root = "root";
      java.io.FileOutputStream f = new java.io.FileOutputStream(new java.io.File(root, "Video.mp4"));
      java.io.InputStream in = java.net.URLConnection.getInputStream();
      byte[] buffer = new byte[1024];
      int len1 = 0;
      while ((len1 = java.io.InputStream.read(byte[])) > 0) {
        java.io.FileOutputStream.write(byte[])
      } 
      java.io.FileOutputStream.close()
    } catch (java.net.MalformedURLException e) {
      java.lang.Throwable.printStackTrace()
    } catch (java.net.ProtocolException e) {
      java.lang.Throwable.printStackTrace()
    } catch (java.io.FileNotFoundException e) {
      java.lang.Throwable.printStackTrace()
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
  }
}
