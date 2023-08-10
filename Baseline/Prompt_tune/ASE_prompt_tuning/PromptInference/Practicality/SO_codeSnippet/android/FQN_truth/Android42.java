// ID = 1188346
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        mPreview = ((android.view.SurfaceView) (findViewById(R.id.message)));
        btnPlay = ((android.widget.Button) (findViewById(100)));
        btnPause = ((android.widget.Button) (findViewById(101)));
        btnReset = ((android.widget.Button) (findViewById(102)));
        btnStop = ((android.widget.Button) (findViewById(103)));
        getPathFromParentDialog();
        btnPlay.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                playVideo();
            }
        });
        btnPause.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                if (mp != null) {
                    mp.pause();
                }
            }
        });
        btnReset.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                if (mp != null) {
                    mp.seekTo(0);
                }
            }
        });
        btnStop.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                if (mp != null) {
                    mp.stop();
                    mp.release();
                }
            }
        });
        getWindow().setFormat(PixelFormat.TRANSPARENT);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setFixedSize(400, 300);
    }

    @java.lang.Override
    protected void onResume() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onResume();
    }

    @java.lang.Override
    public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
        return false;
    }

    @java.lang.Override
    public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
    }

    @java.lang.Override
    public void onCompletion(android.media.MediaPlayer mp) {
    }

    @java.lang.Override
    public void onPrepared(android.media.MediaPlayer mp) {
    }

    @java.lang.Override
    public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) {
    }

    @java.lang.Override
    public void surfaceCreated(android.view.SurfaceHolder holder) {
    }

    @java.lang.Override
    public void surfaceDestroyed(android.view.SurfaceHolder holder) {
    }

    private void playVideo() {
        try {
            mp = new android.media.MediaPlayer();
            mp.setOnErrorListener(this);
            mp.setOnBufferingUpdateListener(this);
            mp.setOnCompletionListener(this);
            mp.setOnPreparedListener(this);
            mp.setAudioStreamType(2);
            mp.setDisplay(mPreview.getHolder());
            java.lang.Runnable r = new java.lang.Runnable() {
                @java.lang.Override
                public void run() {
                    try {
                        setDataSource(mPath);
                    } catch (java.lang.Exception ex) {
                        android.util.Log.e(android.Android42.TAG, ex.getMessage());
                    }
                    try {
                        mp.prepare();
                        android.util.Log.v(android.Android42.TAG, "Duration: ===> " + mp.getDuration());
                    } catch (java.lang.IllegalStateException e) {
                        e.printStackTrace();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        android.util.Log.e(android.Android42.TAG, e.getMessage());
                    }
                    mp.start();
                }
            };
            new java.lang.Thread(r).start();
        } catch (java.lang.Exception ex) {
            java.lang.String sDummy = ex.toString();
            if (mp != null) {
                mp.stop();
                mp.release();
            }
        }
    }

    private void setDataSource(java.lang.String path) throws java.io.IOException {
        if (!android.webkit.URLUtil.isNetworkUrl(mPath)) {
            mp.setDataSource(mPath);
        } else {
            java.net.URL url = new java.net.URL(mPath);
            java.net.URLConnection cn = url.openConnection();
            cn.connect();
            java.io.InputStream stream = cn.getInputStream();
            if (stream == null) {
                throw new java.lang.RuntimeException("stream is null");
            }
            java.io.File fileTemp = java.io.File.createTempFile("mediaplayerTmp", "dat");
            java.lang.String tempPath = fileTemp.getAbsolutePath();
            java.io.FileOutputStream out = new java.io.FileOutputStream(fileTemp);
            byte[] buf = new byte[128];
            do {
                int numRead = stream.read(buf);
                if (numRead <= 0) {
                    break;
                }
                out.write(buf, 0, numRead);
            } while (true );
            mp.setDataSource(tempPath);
            try {
                stream.close();
            } catch (java.lang.Exception ex) {
                java.lang.String sDummy = ex.toString();
            }
        }
    }

    private void getPathFromParentDialog() {
        android.content.Intent intent = getIntent();
        mPath = intent.getExtras().getString("Path");
    }
}

