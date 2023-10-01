package androidExamples;

//ID = 1305388
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.widget.ImageView;
import android.widget.TextView;

public class Android48 {
	public void captureImage() {
		Camera camera = null;
		Camera.Parameters params = camera.getParameters();
		camera.setParameters(params);
		PictureCallback jpgCallback = new PictureCallback() {
			public void onPictureTaken(byte[] data, Camera camera) {
				Context c = null;
				try {
					Dialog d = new Dialog(c);
					d.setContentView(0x7f030000);
					BitmapFactory.Options opts = new BitmapFactory.Options();
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, opts);
					TextView tv = (TextView) d.findViewById(0x7f050001);
					ImageView i = (ImageView) d.findViewById(0x7f050000);
					i.setImageBitmap(bitmap);
					tv.setText("Hai" + data.length);
					d.show();
				} catch (Exception e) {
					AlertDialog.Builder alert = new AlertDialog.Builder(c);
					alert.setMessage("Exception1" + e.getMessage());
					alert.create();
					alert.show();
				}
			}

		};
		camera.takePicture(null, null, jpgCallback);
	}
}
