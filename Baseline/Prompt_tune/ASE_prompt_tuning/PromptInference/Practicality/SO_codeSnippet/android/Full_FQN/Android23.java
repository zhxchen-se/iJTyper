public class Android23 extends android.app.Activity {
  android.widget.ImageView imView;

  android.widget.ImageView imViewLine;

  java.lang.String imageUrl = "http://www.web.com/app/";

  java.lang.String FileType = ".png";

  int imageNum = 0;

  java.util.Random r;

  int count = 0;

  /**
   * Called when the activity is first created.
   */
  @java.lang.Override
  public void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    r = new java.util.Random();
    android.widget.ListView myListView = <unknown>.findViewById(<unknown>);
    final java.util.ArrayList<java.lang.String> todoItems = new java.util.ArrayList<java.lang.String>();
    final android.widget.ArrayAdapter<java.lang.String> aa = new android.widget.ArrayAdapter<java.lang.String>(this, R.layout.main, todoItems);
    android.widget.ListView.setAdapter(android.widget.ArrayAdapter)
    for (count = 0; count < 2; count++) {
      java.util.ArrayList.add(int,java.lang.Object)
      androidExamples.Android23.downloadFile(java.lang.String)
      android.widget.ArrayAdapter.notifyDataSetChanged()
    }
  }

  android.graphics.Bitmap bmImg;

  void downloadFile(java.lang.String fileUrl) {
    java.net.URL myFileUrl = null;
    try {
      myFileUrl = new java.net.URL(fileUrl);
    } catch (java.net.MalformedURLException e) {
      java.lang.Throwable.printStackTrace()
    }
    try {
      java.net.HttpURLConnection conn = java.net.URL.openConnection();
      java.net.URLConnection.setDoInput(boolean)
      java.net.URLConnection.connect()
      int length = java.net.URLConnection.getContentLength();
      java.io.InputStream is = java.net.URLConnection.getInputStream();
      bmImg = android.graphics.BitmapFactory.decodeStream(java.io.InputStream);
      android.widget.ImageView.setImageBitmap(android.graphics.Bitmap)
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
  }
}
