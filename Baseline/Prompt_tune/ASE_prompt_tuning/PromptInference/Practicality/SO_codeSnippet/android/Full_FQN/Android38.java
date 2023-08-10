public class Android38 {
  static java.lang.String serviceDomain = "http://staging.abaqus.net";

  static java.lang.String postUrl = androidExamples.Android38.serviceDomain + "/geo/upl/wupload/pictures";

  static java.lang.String CRLF = "\r\n";

  static java.lang.String twoHyphens = "--";

  static java.lang.String boundary = "*****mgd*****";

  private java.lang.String name = null;

  private java.lang.String password = null;

  private java.io.DataOutputStream dataStream = null;

  enum ReturnCode {

    noPicture,
    unknown,
    http201,
    http400,
    http401,
    http403,
    http404,
    http500;}

  public Android38(java.lang.String name, java.lang.String password) {
    this.name = name;
    this.password = password;
  }

  public static void setServiceDomain(java.lang.String domainName) {
    androidExamples.Android38.serviceDomain = domainName;
  }

  public static java.lang.String getServiceDomain() {
    return androidExamples.Android38.serviceDomain;
  }

  public androidExamples.Android38.ReturnCode uploadPicture(java.lang.String pictureFileName) {
    java.io.File uploadFile = new java.io.File(pictureFileName);
    if (java.io.File.exists())
      try {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(uploadFile);
        java.net.URL connectURL = new java.net.URL(androidExamples.Android38.postUrl);
        java.net.HttpURLConnection conn = java.net.URL.openConnection();
        java.net.URLConnection.setDoInput(boolean)
        java.net.URLConnection.setDoOutput(boolean)
        java.net.URLConnection.setUseCaches(boolean)
        java.net.HttpURLConnection.setRequestMethod(java.lang.String)
        java.net.URLConnection.setRequestProperty(java.lang.String,java.lang.String)
        java.net.URLConnection.setRequestProperty(java.lang.String,java.lang.String)
        java.net.URLConnection.setRequestProperty(java.lang.String,java.lang.String)
        java.net.URLConnection.connect()
        dataStream = new java.io.DataOutputStream(java.net.URLConnection.getOutputStream());
        androidExamples.Android38.writeFormField(java.lang.String,java.lang.String)
        androidExamples.Android38.writeFormField(java.lang.String,java.lang.String)
        androidExamples.Android38.writeFileField(java.lang.String,java.lang.String,java.lang.String,java.io.FileInputStream)
        java.io.DataOutputStream.writeBytes(java.lang.String)
        java.io.FileInputStream.close()
        java.io.DataOutputStream.flush()
        java.io.FilterOutputStream.close()
        dataStream = null;
        java.lang.String response = androidExamples.Android38.getResponse(java.net.HttpURLConnection);
        java.net.HttpURLConnection.getResponseCode()
        if (java.lang.String.contains(java.lang.CharSequence))
          return androidExamples.Android38.ReturnCode.http201;
        else// for now assume bad name/password

          return androidExamples.Android38.ReturnCode.http401;

      } catch (java.net.MalformedURLException mue) {
        java.io.PrintStream.println(java.lang.String)
        return androidExamples.Android38.ReturnCode.http400;
      } catch (java.io.IOException ioe) {
        java.io.PrintStream.println(java.lang.String)
        return androidExamples.Android38.ReturnCode.http500;
      } catch (java.lang.Exception e) {
        java.io.PrintStream.println(java.lang.String)
        return androidExamples.Android38.ReturnCode.unknown;
      }
    else {
      return androidExamples.Android38.ReturnCode.noPicture;
    }
  }

  /**
   *
   *
   * @param conn
   * 		
   * @return 
   */
  private java.lang.String getResponse(java.net.HttpURLConnection conn) {
    try {
      java.io.DataInputStream dis = new java.io.DataInputStream(java.net.URLConnection.getInputStream());
      byte[] data = new byte[1024];
      int len = java.io.DataInputStream.read(byte[],int,int);
      java.io.FilterInputStream.close()
      java.net.HttpURLConnection.getResponseCode()
      if (len > 0)
        return new java.lang.String(data, 0, len);
      else
        return "";

    } catch (java.lang.Exception e) {
      java.io.PrintStream.println(java.lang.String)
      // Log.e(TAG, "GeoPictureUploader: biffed it getting HTTPResponse");
      return "";
    }
  }

  /**
   * this mode of reading response no good either
   */
  private java.lang.String getResponseOrig(java.net.HttpURLConnection conn) {
    java.io.InputStream is = null;
    try {
      is = java.net.URLConnection.getInputStream();
      // scoop up the reply from the server
      int ch;
      java.lang.StringBuffer sb = new java.lang.StringBuffer();
      while ((ch = java.io.InputStream.read()) != (-1)) {
        java.lang.StringBuffer.append(char)
      } 
      return java.lang.StringBuffer.toString();
    } catch (java.lang.Exception e) {
      java.io.PrintStream.println(java.lang.String)
      // Log.e(TAG, "GeoPictureUploader: biffed it getting HTTPResponse");
    } finally {
      try {
        if (is != null)
          java.io.InputStream.close()

      } catch (java.lang.Exception e) {
      }
    }
    return "";
  }

  /**
   * write one form field to dataSream
   *
   * @param fieldName
   * 		
   * @param fieldValue
   * 		
   */
  private void writeFormField(java.lang.String fieldName, java.lang.String fieldValue) {
    try {
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
    } catch (java.lang.Exception e) {
      java.io.PrintStream.println(java.lang.String)
      // Log.e(TAG, "GeoPictureUploader.writeFormField: got: " + e.getMessage());
    }
  }

  /**
   * write one file field to dataSream
   *
   * @param fieldName
   * 		- name of file field
   * @param fieldValue
   * 		- file name
   * @param type
   * 		- mime type
   * @param fileInputStream
   * 		- stream of bytes that get sent up
   */
  private void writeFileField(java.lang.String fieldName, java.lang.String fieldValue, java.lang.String type, java.io.FileInputStream fis) {
    try {
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      java.io.DataOutputStream.writeBytes(java.lang.String)
      // create a buffer of maximum size
      int bytesAvailable = java.io.FileInputStream.available();
      int maxBufferSize = 1024;
      int bufferSize = java.lang.Math.min(int,int);
      byte[] buffer = new byte[bufferSize];
      // read file and write it into form...
      int bytesRead = java.io.FileInputStream.read(byte[],int,int);
      while (bytesRead > 0) {
        java.io.DataOutputStream.write(byte[],int,int)
        bytesAvailable = java.io.FileInputStream.available();
        bufferSize = java.lang.Math.min(int,int);
        bytesRead = java.io.FileInputStream.read(byte[],int,int);
      } 
      java.io.DataOutputStream.writeBytes(java.lang.String)
    } catch (java.lang.Exception e) {
      java.io.PrintStream.println(java.lang.String)
      // Log.e(TAG, "GeoPictureUploader.writeFormField: got: " + e.getMessage());
    }
  }

  /**
   *
   *
   * @param args
   * 		
   */
  public static void main(java.lang.String[] args) {
    if (args.length >= 0) {
      androidExamples.Android38 gpu = new androidExamples.Android38("john", "notmyrealpassword");
      java.lang.String picName = args[0];
      androidExamples.Android38.uploadPicture(java.lang.String)
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
    }
  }
}
