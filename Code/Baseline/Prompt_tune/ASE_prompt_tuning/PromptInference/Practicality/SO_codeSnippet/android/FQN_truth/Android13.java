// ID = 559902
public class Android13 {
    public static void main(java.lang.String[] args) {
        android.net.Uri imageUri = null;
        android.graphics.Bitmap bitmap = null;
        try {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(android.Android13.getContentResolver(), imageUri);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        java.io.ByteArrayInputStream fileInputStream = new java.io.ByteArrayInputStream(bytes.toByteArray());
    }

    private static android.content.ContentResolver getContentResolver() {
        return null;
    }
}

