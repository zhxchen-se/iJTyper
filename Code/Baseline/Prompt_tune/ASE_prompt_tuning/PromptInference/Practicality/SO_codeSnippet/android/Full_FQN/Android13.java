// ID = 559902
public class Android13 {
  public static void main(java.lang.String[] args) {
    android.net.Uri imageUri = null;
    android.graphics.Bitmap bitmap = null;
    try {
      bitmap = android.provider.MediaStore.Images.Media.getBitmap(android.content.ContentResolver,android.net.Uri);
    } catch (java.io.FileNotFoundException e) {
      java.lang.Throwable.printStackTrace()
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
    java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
    android.graphics.Bitmap.compress(int,java.io.ByteArrayOutputStream)
    java.io.ByteArrayInputStream fileInputStream = new java.io.ByteArrayInputStream(java.io.ByteArrayOutputStream.toByteArray());
  }

  private static android.content.ContentResolver getContentResolver() {
    // TODO Auto-generated method stub
    return null;
  }
}
