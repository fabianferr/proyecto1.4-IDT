package stikerwap.appdys;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.HashMap;

public class FullscreenVideoView_pro extends RelativeLayout implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    protected boolean coments;
    protected Context context;
    protected ViewGroup.LayoutParams currentLayoutParams;
    protected State currentState;
    protected boolean descr;
    protected boolean detachedByFullscreen;
    protected MediaPlayer.OnErrorListener errorListener;
    protected boolean fullscreen;
    protected int initialMovieHeight;
    protected int initialMovieWidth;
    protected State lastState;
    protected MediaPlayer mediaPlayer;
    protected View onProgressView;
    protected ViewGroup parentView;
    protected MediaPlayer.OnPreparedListener preparedListener;
    protected boolean shouldAutoplay;
    protected SurfaceHolder surfaceHolder;
    protected boolean surfaceIsReady;
    protected SurfaceView surfaceView;
    protected Uri uri_glob;
    protected boolean videoIsReady;

    public enum State {
        IDLE,
        INITIALIZED,
        PREPARED,
        PREPARING,
        STARTED,
        STOPPED,
        PAUSED,
        PLAYBACKCOMPLETED,
        ERROR,
        END
    }

    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
        return false;
    }

    public FullscreenVideoView_pro(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    public FullscreenVideoView_pro(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public FullscreenVideoView_pro(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.detachedByFullscreen) {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                this.mediaPlayer.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                this.mediaPlayer.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener) null);
                this.mediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                this.mediaPlayer.setOnInfoListener((MediaPlayer.OnInfoListener) null);
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                }
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            this.videoIsReady = false;
            this.surfaceIsReady = false;
            this.currentState = State.END;
        }
        this.detachedByFullscreen = false;
    }

    public synchronized void surfaceCreated(SurfaceHolder surfaceHolder2) {
        this.mediaPlayer.setDisplay(this.surfaceHolder);
        if (!this.surfaceIsReady) {
            this.surfaceIsReady = true;
            if (!(this.currentState == State.PREPARED || this.currentState == State.PAUSED || this.currentState == State.STARTED || this.currentState == State.PLAYBACKCOMPLETED)) {
                tryToPrepare();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder2, int i, int i2, int i3) {
        resize();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
            this.mediaPlayer.pause();
        }
        this.surfaceIsReady = false;
    }

    public synchronized void onPrepared(MediaPlayer mediaPlayer2) {
        this.videoIsReady = true;
        tryToPrepare();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer2) {
        stopLoading();
        if (this.lastState != null) {
            int i = AnonymousClass3.$SwitchMap$stikerwap$appdys$FullscreenVideoView_pro$State[this.lastState.ordinal()];
            if (i == 1) {
                start();
            } else if (i == 2) {
                this.currentState = State.PLAYBACKCOMPLETED;
            } else if (i == 3) {
                this.currentState = State.PREPARED;
            }
        }
    }

    /* renamed from: stikerwap.appdys.FullscreenVideoView_pro$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$stikerwap$appdys$FullscreenVideoView_pro$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                stikerwap.appdys.FullscreenVideoView_pro$State[] r0 = stikerwap.appdys.FullscreenVideoView_pro.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$stikerwap$appdys$FullscreenVideoView_pro$State = r0
                stikerwap.appdys.FullscreenVideoView_pro$State r1 = stikerwap.appdys.FullscreenVideoView_pro.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$stikerwap$appdys$FullscreenVideoView_pro$State     // Catch:{ NoSuchFieldError -> 0x001d }
                stikerwap.appdys.FullscreenVideoView_pro$State r1 = stikerwap.appdys.FullscreenVideoView_pro.State.PLAYBACKCOMPLETED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$stikerwap$appdys$FullscreenVideoView_pro$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                stikerwap.appdys.FullscreenVideoView_pro$State r1 = stikerwap.appdys.FullscreenVideoView_pro.State.PREPARED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.FullscreenVideoView_pro.AnonymousClass3.<clinit>():void");
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer2) {
        if (this.mediaPlayer != null && this.currentState != State.ERROR) {
            if (!this.mediaPlayer.isLooping()) {
                this.currentState = State.PLAYBACKCOMPLETED;
            } else {
                start();
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
        stopLoading();
        this.currentState = State.ERROR;
        MediaPlayer.OnErrorListener onErrorListener = this.errorListener;
        if (onErrorListener != null) {
            return onErrorListener.onError(mediaPlayer2, i, i2);
        }
        return false;
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
        if (this.initialMovieWidth == 0 && this.initialMovieHeight == 0) {
            this.initialMovieWidth = i;
            this.initialMovieHeight = i2;
            resize();
        }
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (!isInEditMode()) {
            this.shouldAutoplay = true;
            this.currentState = State.IDLE;
            this.fullscreen = false;
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            initObjects();
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        this.mediaPlayer = new MediaPlayer();
        this.surfaceView = new SurfaceView(this.context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.surfaceView.setLayoutParams(layoutParams);
        addView(this.surfaceView);
        SurfaceHolder holder = this.surfaceView.getHolder();
        this.surfaceHolder = holder;
        holder.setType(3);
        this.surfaceHolder.addCallback(this);
        if (this.onProgressView == null) {
            this.onProgressView = new ProgressBar(this.context);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.onProgressView.setLayoutParams(layoutParams2);
        addView(this.onProgressView);
    }

    /* access modifiers changed from: protected */
    public void releaseObjects() {
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this);
            this.surfaceHolder = null;
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            this.mediaPlayer = null;
        }
        SurfaceView surfaceView2 = this.surfaceView;
        if (surfaceView2 != null) {
            removeView(surfaceView2);
        }
        View view = this.onProgressView;
        if (view != null) {
            removeView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IllegalStateException {
        startLoading();
        this.videoIsReady = false;
        this.initialMovieHeight = -1;
        this.initialMovieWidth = -1;
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnErrorListener(this);
        this.mediaPlayer.setOnSeekCompleteListener(this);
        this.mediaPlayer.setOnInfoListener(this);
        this.mediaPlayer.setOnVideoSizeChangedListener(this);
        this.mediaPlayer.setAudioStreamType(3);
        this.currentState = State.PREPARING;
        this.mediaPlayer.prepareAsync();
    }

    /* access modifiers changed from: protected */
    public void tryToPrepare() {
        if (this.surfaceIsReady && this.videoIsReady) {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                this.initialMovieWidth = mediaPlayer2.getVideoWidth();
                this.initialMovieHeight = this.mediaPlayer.getVideoHeight();
            }
            resize();
            stopLoading();
            this.currentState = State.PREPARED;
            if (this.shouldAutoplay) {
                start();
            }
            MediaPlayer.OnPreparedListener onPreparedListener = this.preparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(this.mediaPlayer);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startLoading() {
        View view = this.onProgressView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void stopLoading() {
        View view = this.onProgressView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public synchronized State getCurrentState() {
        return this.currentState;
    }

    public boolean isFullscreen() {
        return this.fullscreen;
    }

    public void setFullscreen(boolean z) throws RuntimeException {
        if (this.mediaPlayer == null) {
            throw new RuntimeException("Media Player is not initialized");
        } else if (this.currentState != State.ERROR) {
            if (!ViewConfiguration.get(getContext()).hasPermanentMenuKey()) {
                ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(z ? 4 : 0);
            } else if (z) {
                ((Activity) getContext()).getWindow().setFlags(1024, 1024);
            } else {
                ((Activity) getContext()).getWindow().clearFlags(1024);
            }
            this.fullscreen = z;
            final boolean isPlaying = this.mediaPlayer.isPlaying();
            if (isPlaying) {
                pause();
            }
            boolean z2 = true;
            if (this.fullscreen) {
                View findViewById = getRootView().findViewById(16908290);
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    if (this.parentView == null) {
                        this.parentView = (ViewGroup) parent;
                    }
                    this.detachedByFullscreen = true;
                    this.currentLayoutParams = getLayoutParams();
                    this.parentView.removeView(this);
                }
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).addView(this);
                    setClickable(true);
                }
            } else {
                ViewParent parent2 = getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = this.parentView;
                    if (viewGroup == null || viewGroup.getParent() == null) {
                        z2 = false;
                    } else {
                        this.detachedByFullscreen = true;
                    }
                    ((ViewGroup) parent2).removeView(this);
                    if (z2) {
                        this.parentView.addView(this, 0);
                        setLayoutParams(this.currentLayoutParams);
                    }
                }
            }
            resize();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (FullscreenVideoView_pro.this.mediaPlayer == null) {
                        return;
                    }
                    if (isPlaying) {
                        FullscreenVideoView_pro.this.start();
                        return;
                    }
                    try {
                        FullscreenVideoView_pro fullscreenVideoView_pro = FullscreenVideoView_pro.this;
                        fullscreenVideoView_pro.seekTo(fullscreenVideoView_pro.getCurrentPosition());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void resize() {
        if (this.initialMovieHeight != 0 && this.initialMovieWidth != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0  */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x0124  */
                /* JADX WARNING: Removed duplicated region for block: B:47:0x0127  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r9 = this;
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.view.View r0 = r0.getRootView()
                        if (r0 == 0) goto L_0x012e
                        stikerwap.appdys.FullscreenVideoView_pro r1 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.content.Context r1 = r1.context
                        java.lang.String r2 = "window"
                        java.lang.Object r1 = r1.getSystemService(r2)
                        android.view.WindowManager r1 = (android.view.WindowManager) r1
                        android.view.Display r1 = r1.getDefaultDisplay()
                        android.graphics.Point r2 = new android.graphics.Point
                        r2.<init>()
                        r1.getSize(r2)
                        int r1 = r2.x
                        int r2 = r2.y
                        float r3 = (float) r1
                        float r4 = (float) r2
                        float r3 = r3 / r4
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieHeight
                        r5 = -1
                        if (r4 == r5) goto L_0x0034
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieWidth
                        if (r4 != r5) goto L_0x0041
                    L_0x0034:
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        r5 = 30000(0x7530, float:4.2039E-41)
                        r4.initialMovieWidth = r5
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        r5 = 40000(0x9c40, float:5.6052E-41)
                        r4.initialMovieHeight = r5
                    L_0x0041:
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieWidth
                        float r4 = (float) r4
                        stikerwap.appdys.FullscreenVideoView_pro r5 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r5 = r5.initialMovieHeight
                        float r5 = (float) r5
                        float r4 = r4 / r5
                        r5 = 1
                        r6 = 0
                        r7 = 1065353216(0x3f800000, float:1.0)
                        int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                        if (r4 <= 0) goto L_0x0056
                        r4 = 1
                        goto L_0x0057
                    L_0x0056:
                        r4 = 0
                    L_0x0057:
                        int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                        if (r3 <= 0) goto L_0x005c
                        goto L_0x005d
                    L_0x005c:
                        r5 = 0
                    L_0x005d:
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        boolean r3 = r3.fullscreen
                        if (r3 == 0) goto L_0x0087
                        if (r5 != 0) goto L_0x0076
                        if (r4 == 0) goto L_0x0078
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r0 = r0.initialMovieHeight
                        int r0 = r0 * r1
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r3 = r3.initialMovieWidth
                        int r0 = r0 / r3
                        r3 = r0
                    L_0x0073:
                        r0 = r1
                        goto L_0x00ea
                    L_0x0076:
                        if (r4 == 0) goto L_0x007a
                    L_0x0078:
                        r0 = r1
                        goto L_0x0085
                    L_0x007a:
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r0 = r0.initialMovieWidth
                        int r0 = r0 * r2
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r3 = r3.initialMovieHeight
                        int r0 = r0 / r3
                    L_0x0085:
                        r3 = r2
                        goto L_0x00ea
                    L_0x0087:
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.content.Context r3 = r3.context
                        r5 = 43
                        int r3 = stikerwap.appdys.config.dp_to_px(r3, r5)
                        stikerwap.appdys.FullscreenVideoView_pro r5 = stikerwap.appdys.FullscreenVideoView_pro.this
                        boolean r5 = r5.coments
                        r6 = 2131362638(0x7f0a034e, float:1.8345062E38)
                        if (r5 == 0) goto L_0x00a5
                        android.view.View r0 = r0.findViewById(r6)
                        int r0 = r0.getHeight()
                        int r0 = r0 / 2
                        goto L_0x00c1
                    L_0x00a5:
                        android.view.View r5 = r0.findViewById(r6)
                        int r5 = r5.getHeight()
                        int r5 = r5 - r3
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        boolean r3 = r3.descr
                        if (r3 == 0) goto L_0x00c0
                        r3 = 2131362585(0x7f0a0319, float:1.8344955E38)
                        android.view.View r0 = r0.findViewById(r3)
                        int r0 = r0.getHeight()
                        int r5 = r5 - r0
                    L_0x00c0:
                        r0 = r5
                    L_0x00c1:
                        if (r4 == 0) goto L_0x00dc
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r3 = r3.initialMovieHeight
                        int r3 = r3 * r1
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieWidth
                        int r3 = r3 / r4
                        if (r3 <= r0) goto L_0x0073
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r3 = r3.initialMovieWidth
                        int r3 = r3 * r0
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieHeight
                        int r3 = r3 / r4
                        goto L_0x00e7
                    L_0x00dc:
                        stikerwap.appdys.FullscreenVideoView_pro r3 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r3 = r3.initialMovieWidth
                        int r3 = r3 * r0
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        int r4 = r4.initialMovieHeight
                        int r3 = r3 / r4
                    L_0x00e7:
                        r8 = r3
                        r3 = r0
                        r0 = r8
                    L_0x00ea:
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.view.SurfaceView r4 = r4.surfaceView
                        if (r4 == 0) goto L_0x0116
                        stikerwap.appdys.FullscreenVideoView_pro r4 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.view.SurfaceView r4 = r4.surfaceView
                        android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                        r4.width = r0
                        r4.height = r3
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.view.SurfaceView r0 = r0.surfaceView
                        r0.setLayoutParams(r4)
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this     // Catch:{ Exception -> 0x0112 }
                        r5 = 2131362570(0x7f0a030a, float:1.8344924E38)
                        android.view.View r0 = r0.findViewById(r5)     // Catch:{ Exception -> 0x0112 }
                        android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x0112 }
                        r0.setLayoutParams(r4)     // Catch:{ Exception -> 0x0112 }
                        goto L_0x0116
                    L_0x0112:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0116:
                        stikerwap.appdys.FullscreenVideoView_pro r0 = stikerwap.appdys.FullscreenVideoView_pro.this
                        android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                        r0.width = r1
                        stikerwap.appdys.FullscreenVideoView_pro r1 = stikerwap.appdys.FullscreenVideoView_pro.this
                        boolean r1 = r1.fullscreen
                        if (r1 == 0) goto L_0x0127
                        r0.height = r2
                        goto L_0x0129
                    L_0x0127:
                        r0.height = r3
                    L_0x0129:
                        stikerwap.appdys.FullscreenVideoView_pro r1 = stikerwap.appdys.FullscreenVideoView_pro.this
                        r1.setLayoutParams(r0)
                    L_0x012e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.FullscreenVideoView_pro.AnonymousClass2.run():void");
                }
            });
        }
    }

    @Deprecated
    public void fullscreen() throws IllegalStateException {
        setFullscreen(!this.fullscreen);
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            return mediaPlayer2.getCurrentPosition();
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public int getDuration() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            return mediaPlayer2.getDuration();
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public boolean isPlaying() throws IllegalStateException {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            return mediaPlayer2.isPlaying();
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void pause() throws IllegalStateException {
        if (this.mediaPlayer != null) {
            this.currentState = State.PAUSED;
            this.mediaPlayer.pause();
            return;
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void reset() {
        if (this.mediaPlayer != null) {
            this.currentState = State.IDLE;
            releaseObjects();
            initObjects();
            return;
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void start() throws IllegalStateException {
        if (this.mediaPlayer != null) {
            State state = this.currentState;
            this.currentState = State.STARTED;
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.start();
            if (state == State.PREPARED) {
                ((config) this.context.getApplicationContext()).toca_int_2(this.context, false, false, false);
                return;
            }
            return;
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void seekTo(int i) throws IllegalStateException {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null) {
            throw new RuntimeException("Media Player is not initialized");
        } else if (mediaPlayer2.getDuration() > -1 && i <= this.mediaPlayer.getDuration()) {
            this.lastState = this.currentState;
            pause();
            this.mediaPlayer.seekTo(i);
            startLoading();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.mediaPlayer != null) {
            this.errorListener = onErrorListener;
            return;
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.mediaPlayer != null) {
            this.preparedListener = onPreparedListener;
            return;
        }
        throw new RuntimeException("Media Player is not initialized");
    }

    public void setVideoURI(Uri uri, String str) throws IOException, IllegalStateException, SecurityException, IllegalArgumentException, RuntimeException {
        if (this.mediaPlayer == null) {
            throw new RuntimeException("Media Player is not initialized");
        } else if (this.currentState == State.IDLE) {
            if (str == null || str.isEmpty()) {
                this.mediaPlayer.setDataSource(this.context, uri);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", str);
                this.mediaPlayer.setDataSource(this.context, uri, hashMap);
            }
            this.uri_glob = uri;
            this.currentState = State.INITIALIZED;
            prepare();
        } else {
            throw new IllegalStateException("FullscreenVideoView Invalid State: " + this.currentState);
        }
    }
}
