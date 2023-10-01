public class Android48 {
    public void captureImage() {
        android.hardware.Camera camera = null;
        android.hardware.Camera.Parameters params = camera.getParameters();
        camera.setParameters(params);
        android.hardware.Camera.PictureCallback jpgCallback = new android.hardware.Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
                android.content.Context c = null;
                try {
                    android.app.Dialog d = new android.app.Dialog(c);
                    d.setContentView(0x7f030000);
                    android.graphics.BitmapFactory.Options opts = new android.graphics.BitmapFactory.Options();
                    android.graphics.Bitmap bitmap = android.graphics.BitmapFactory.decodeByteArray(data, 0, data.length, opts);
                    android.widget.TextView tv = ((android.widget.TextView) (d.findViewById(0x7f050001)));
                    android.widget.ImageView i = ((android.widget.ImageView) (d.findViewById(0x7f050000)));
                    i.setImageBitmap(bitmap);
                    tv.setText("Hai" + data.length);
                    d.show();
                } catch (java.lang.Exception e) {
                    android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(c);
                    alert.setMessage("Exception1" + e.getMessage());
                    alert.create();
                    alert.show();
                }
            }
        };
        camera.takePicture(null, null, jpgCallback);
    }
}

