public class Android35 {
    private void recordVideoStart() {
        android.media.MediaRecorder recorder = new android.media.MediaRecorder();
        if (recorder != null) {
            recorder.stop();
            recorder.release();
        }
        java.io.File file = new java.io.File("/sdcard/videoTest.3gpp");
        try {
            file.createNewFile();
        } catch (java.io.IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        recorder = new android.media.MediaRecorder();
        recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(file.getAbsolutePath());
        recorder.setVideoSize(176, 144);
        recorder.setVideoFrameRate(15);
        recorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            recorder.prepare();
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        recorder.start();
    }
}

