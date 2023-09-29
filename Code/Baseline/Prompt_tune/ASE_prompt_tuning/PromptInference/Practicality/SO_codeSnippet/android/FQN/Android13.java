// ID = 559902
public class Android13 {
    public static void main(java.lang.String[] args) {
        android.net.Uri imageUri = null;
        android.graphics.Bitmap bitmap = null;
        try {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(androidExamples.Android13.getContentResolver(), imageUri);
        } catch (java.io.FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.io.IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        java.io.ByteArrayInputStream fileInputStream = new java.io.ByteArrayInputStream(bytes.toByteArray());
    }

    private static android.content.ContentResolver getContentResolver() {
        // TODO Auto-generated method stub
        return null;
    }
}

