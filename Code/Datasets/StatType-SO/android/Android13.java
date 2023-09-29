package androidExamples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;

//ID = 559902
public class Android13 {
	public static void main(String[] args) {
			Uri imageUri = null;
			Bitmap bitmap = null;
			try {
				bitmap = Media.getBitmap(getContentResolver(), imageUri);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
			ByteArrayInputStream fileInputStream = new ByteArrayInputStream(bytes.toByteArray());
	}

	private static ContentResolver getContentResolver() {
		// TODO Auto-generated method stub
		return null;
	}
}
