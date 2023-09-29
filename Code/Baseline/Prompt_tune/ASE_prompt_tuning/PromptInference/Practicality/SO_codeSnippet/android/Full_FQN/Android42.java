public class Android42 extends android.app.Activity implements android.media.MediaPlayer.OnErrorListener , android.media.MediaPlayer.OnBufferingUpdateListener , android.media.MediaPlayer.OnCompletionListener , android.media.MediaPlayer.OnPreparedListener , android.view.SurfaceHolder.Callback {
  private static final java.lang.String TAG = "MediaPreview";

  private android.media.MediaPlayer mp;

  private android.view.SurfaceView mPreview;

  private android.view.SurfaceHolder holder;

  private android.widget.Button btnPlay;

  private android.widget.Button btnPause;

  private android.widget.Button btnReset;

  private android.widget.Button btnStop;

  private java.lang.String mPath;

  @java.lang.Override
  protected void onCreate(android.os.Bundle savedInstanceState) {
    android.app.Activity.onCreate(android.os.Bundle)
    <unknown>.setContentView(<unknown>)
    mPreview = <unknown>.findViewById(<unknown>);
    btnPlay = <unknown>.findViewById(int);
    btnPause = <unknown>.findViewById(int);
    btnReset = <unknown>.findViewById(int);
    btnStop = <unknown>.findViewById(int);
    androidExamples.Android42.getPathFromParentDialog()
    android.widget.Button.setOnClickListener(androidExamples.Android42$1)
    android.widget.Button.setOnClickListener(androidExamples.Android42$2)
    android.widget.Button.setOnClickListener(androidExamples.Android42$3)
    android.widget.Button.setOnClickListener(androidExamples.Android42$4)
    <unknown>.getWindow()###<unknown>.setFormat()
    holder = android.view.SurfaceView.getHolder();
    android.view.SurfaceHolder.addCallback(androidExamples.Android42)
    android.view.SurfaceHolder.setFixedSize(int,int)
  }

  @java.lang.Override
  protected void onResume() {
    <unknown>.setRequestedOrientation(<unknown>)
    <unknown>.onResume()
  }

  @java.lang.Override
  public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
    if (mp != null) {
      android.media.MediaPlayer.stop()
      android.media.MediaPlayer.release()
    }
    return false;
  }

  @java.lang.Override
  public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
    // TODO Auto-generated method stub
  }

  @java.lang.Override
  public void onCompletion(android.media.MediaPlayer mp) {
    // TODO Auto-generated method stub
  }

  @java.lang.Override
  public void onPrepared(android.media.MediaPlayer mp) {
    // TODO Auto-generated method stub
  }

  @java.lang.Override
  public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) {
    // TODO Auto-generated method stub
  }

  @java.lang.Override
  public void surfaceCreated(android.view.SurfaceHolder holder) {
    // TODO Auto-generated method stub
  }

  @java.lang.Override
  public void surfaceDestroyed(android.view.SurfaceHolder holder) {
    // TODO Auto-generated method stub
  }

  private void playVideo() {
    try {
      mp = new android.media.MediaPlayer();
      android.media.MediaPlayer.setOnErrorListener(androidExamples.Android42)
      android.media.MediaPlayer.setOnBufferingUpdateListener(androidExamples.Android42)
      android.media.MediaPlayer.setOnCompletionListener(androidExamples.Android42)
      android.media.MediaPlayer.setOnPreparedListener(androidExamples.Android42)
      android.media.MediaPlayer.setAudioStreamType(int)
      android.media.MediaPlayer.setDisplay()
      java.lang.Runnable r = new java.lang.Runnable() {
        @java.lang.Override
        public void run() {
          try {
            androidExamples.Android42.setDataSource(java.lang.String)
          } catch (java.lang.Exception ex) {
            android.util.Log.e(java.lang.String,java.lang.String)
          }
          try {
            android.media.MediaPlayer.prepare()
            android.util.Log.v(java.lang.String)
          } catch (java.lang.IllegalStateException e) {
            java.lang.Throwable.printStackTrace()
          } catch (java.io.IOException e) {
            java.lang.Throwable.printStackTrace()
            android.util.Log.e(java.lang.String,java.lang.String)
          }
          android.media.MediaPlayer.start()
        }
      };
      java.lang.Thread.start()
    } catch (java.lang.Exception ex) {
      java.lang.String sDummy = java.lang.Throwable.toString();
      if (mp != null) {
        android.media.MediaPlayer.stop()
        android.media.MediaPlayer.release()
      }
    }
  }

  private void setDataSource(java.lang.String path) throws java.io.IOException {
    if (!android.webkit.URLUtil.isNetworkUrl(java.lang.String)) {
      android.media.MediaPlayer.setDataSource(java.lang.String)
    } else {
      java.net.URL url = new java.net.URL(mPath);
      java.net.URLConnection cn = java.net.URL.openConnection();
      java.net.URLConnection.connect()
      java.io.InputStream stream = java.net.URLConnection.getInputStream();
      if (stream == null) {
        throw new java.lang.RuntimeException("stream is null");
      }
      java.io.File fileTemp = java.io.File.createTempFile(java.lang.String,java.lang.String);
      java.lang.String tempPath = java.io.File.getAbsolutePath();
      java.io.FileOutputStream out = new java.io.FileOutputStream(fileTemp);
      byte[] buf = new byte[128];
      do {
        int numRead = java.io.InputStream.read(byte[]);
        if (numRead <= 0) {
          break;
        }
        java.io.FileOutputStream.write(byte[],int,int)
      } while (true );
      android.media.MediaPlayer.setDataSource(java.lang.String)
      try {
        java.io.InputStream.close()
      } catch (java.lang.Exception ex) {
        java.lang.String sDummy = java.lang.Throwable.toString();
      }
    }
  }

  private void getPathFromParentDialog() {
    android.content.Intent intent = <unknown>.getIntent();
    mPath = android.content.Intent.getExtras()###<unknown>.getString(java.lang.String);
  }
}
