public class Android32 {
    public void start() throws java.io.IOException {
        java.lang.String state = android.os.Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            throw new java.io.IOException(("SD card is not mounted. It is " + state) + ".");
        }
        java.lang.String path = "Root";
        java.io.File directory = new java.io.File(path).getParentFile();
        if ((!directory.exists()) && (!directory.mkdirs())) {
            throw new java.io.IOException("Path to file could not be created.");
        }
        android.media.MediaRecorder recorder = new android.media.MediaRecorder();
        recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setVideoEncoder(MediaRecorder.VideoEncoder.H263);
        recorder.setVideoFrameRate(15);
        recorder.setVideoSize(176, 144);
        recorder.setOutputFile(path);
        recorder.prepare();
        recorder.start();
    }
}

