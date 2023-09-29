public class Android15 {
    public static void main(java.lang.String[] args) {
        android.content.Intent sendIntent = new android.content.Intent(android.content.Intent.ACTION_SEND);
        sendIntent.setType("image/jpeg");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Photo");
        sendIntent.putExtra(Intent.EXTRA_STREAM, android.net.Uri.parse("file://sdcard/dcim/Camera/filename.jpg"));
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Enjoy the photo");
        android.Android15.startActivity(android.content.Intent.createChooser(sendIntent, "Email:"));
    }

    private static void startActivity(android.content.Intent createChooser) {
    }
}

