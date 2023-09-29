public class Android33 {
  private void init(android.content.Context context) {
    boolean mRecording = false;
    int frameCount = 0;
    android.hardware.Camera mCamera = null;
    if (mCamera == null) {
      mCamera = android.hardware.Camera.open();
    }
    android.hardware.Camera.Parameters parameters = android.hardware.Camera.getParameters();
    android.hardware.Camera.Parameters.setPictureFormat()
    android.hardware.Camera.setParameters(android.hardware.Camera.Parameters)
    try {
      android.view.SurfaceHolder surfaceHolder = null;
      android.hardware.Camera.setPreviewDisplay(android.view.SurfaceHolder)
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
    android.hardware.Camera.startPreview()
  }
}
