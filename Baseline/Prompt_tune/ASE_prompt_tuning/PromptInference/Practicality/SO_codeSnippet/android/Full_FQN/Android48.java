public class Android48 {
  public void captureImage() {
    android.hardware.Camera camera = null;
    android.hardware.Camera.Parameters params = android.hardware.Camera.getParameters();
    android.hardware.Camera.setParameters(Camera.Parameters)
    android.hardware.Camera.PictureCallback jpgCallback = new android.hardware.Camera.PictureCallback() {
      public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
        android.content.Context c = null;
        try {
          android.app.Dialog d = new android.app.Dialog(c);
          android.app.Dialog.setContentView(int)
          android.graphics.BitmapFactory.Options opts = new android.graphics.BitmapFactory.Options();
          android.graphics.Bitmap bitmap = android.graphics.BitmapFactory.decodeByteArray(byte[],int,int,BitmapFactory.Options);
          android.widget.TextView tv = android.app.Dialog.findViewById(int);
          android.widget.ImageView i = android.app.Dialog.findViewById(int);
          android.widget.ImageView.setImageBitmap(android.graphics.Bitmap)
          android.widget.TextView.setText(java.lang.String)
          android.app.Dialog.show()
        } catch (java.lang.Exception e) {
          android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(c);
          AlertDialog.Builder.setMessage(java.lang.String)
          AlertDialog.Builder.create()
          AlertDialog.Builder.show()
        }
      }
    };
    android.hardware.Camera.takePicture(<unknown>,<unknown>,android.hardware.Camera.PictureCallback)
  }
}
