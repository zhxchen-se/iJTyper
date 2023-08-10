public class Android32 {
  public void start() throws java.io.IOException {
    java.lang.String state = android.os.Environment.getExternalStorageState();
    if (!java.lang.String.equals(java.lang.Object)) {
      throw new java.io.IOException(("SD card is not mounted. It is " + state) + ".");
    }
    java.lang.String path = "Root";
    java.io.File directory = java.io.File.getParentFile();
    if ((!java.io.File.exists()) && (!java.io.File.mkdirs())) {
      throw new java.io.IOException("Path to file could not be created.");
    }
    android.media.MediaRecorder recorder = new android.media.MediaRecorder();
    android.media.MediaRecorder.setVideoSource()
    android.media.MediaRecorder.setOutputFormat()
    android.media.MediaRecorder.setVideoEncoder()
    android.media.MediaRecorder.setVideoFrameRate(int)
    android.media.MediaRecorder.setVideoSize(int,int)
    android.media.MediaRecorder.setOutputFile(java.lang.String)
    android.media.MediaRecorder.prepare()
    android.media.MediaRecorder.start()
  }
}
