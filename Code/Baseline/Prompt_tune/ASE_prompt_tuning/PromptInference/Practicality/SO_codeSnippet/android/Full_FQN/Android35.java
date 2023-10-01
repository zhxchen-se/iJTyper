public class Android35 {
  private void recordVideoStart() {
    android.media.MediaRecorder recorder = new android.media.MediaRecorder();
    if (recorder != null) {
      android.media.MediaRecorder.stop()
      android.media.MediaRecorder.release()
    }
    java.io.File file = new java.io.File("/sdcard/videoTest.3gpp");
    try {
      java.io.File.createNewFile()
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
    recorder = new android.media.MediaRecorder();
    android.media.MediaRecorder.setVideoSource()
    android.media.MediaRecorder.setAudioSource()
    android.media.MediaRecorder.setOutputFormat()
    android.media.MediaRecorder.setOutputFile(java.lang.String)
    android.media.MediaRecorder.setVideoSize(int,int)
    android.media.MediaRecorder.setVideoFrameRate(int)
    android.media.MediaRecorder.setVideoEncoder()
    android.media.MediaRecorder.setAudioEncoder()
    try {
      android.media.MediaRecorder.prepare()
    } catch (java.lang.IllegalStateException e) {
      java.lang.Throwable.printStackTrace()
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
    android.media.MediaRecorder.start()
  }
}
