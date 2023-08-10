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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        r = new java.util.Random();
        android.widget.ListView myListView = ((android.widget.ListView) (findViewById(R.id.lay)));
        final java.util.ArrayList<java.lang.String> todoItems = new java.util.ArrayList<java.lang.String>();
        final android.widget.ArrayAdapter<java.lang.String> aa = new android.widget.ArrayAdapter<java.lang.String>(this, R.layout.main, todoItems);
        // Bind the listview to the array adapter
        myListView.setAdapter(aa);
        for (count = 0; count < 2; count++) {
            todoItems.add(0, "TEST");
            downloadFile((imageUrl + java.lang.Integer.toString(count)) + FileType);
            aa.notifyDataSetChanged();
        }
    }

    android.graphics.Bitmap bmImg;

    void downloadFile(java.lang.String fileUrl) {
        java.net.URL myFileUrl = null;
        try {
            myFileUrl = new java.net.URL(fileUrl);
        } catch (java.net.MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            java.net.HttpURLConnection conn = ((java.net.HttpURLConnection) (myFileUrl.openConnection()));
            conn.setDoInput(true);
            conn.connect();
            int length = conn.getContentLength();
            java.io.InputStream is = conn.getInputStream();
            bmImg = android.graphics.BitmapFactory.decodeStream(is);
            imViewLine.setImageBitmap(bmImg);
        } catch (java.io.IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

