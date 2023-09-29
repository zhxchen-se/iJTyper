public class Android33 {
    private void init(android.content.Context context) {
        boolean mRecording = false;
        int frameCount = 0;
        android.hardware.Camera mCamera = null;
        if (mCamera == null) {
            mCamera = android.hardware.Camera.open();
        }
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        mCamera.setParameters(parameters);
        try {
            android.view.SurfaceHolder surfaceHolder = null;
            mCamera.setPreviewDisplay(surfaceHolder);
        } catch (java.io.IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mCamera.startPreview();
    }
}

