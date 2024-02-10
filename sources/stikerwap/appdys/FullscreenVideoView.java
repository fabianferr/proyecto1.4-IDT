package stikerwap.appdys;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class FullscreenVideoView extends RelativeLayout implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    protected Context context;
    protected ViewGroup.LayoutParams currentLayoutParams;
    protected State currentState;
    protected boolean detachedByFullscreen;
    protected MediaPlayer.OnErrorListener errorListener;
    protected boolean fullscreen;
    config globales;
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

    public FullscreenVideoView(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    public FullscreenVideoView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public FullscreenVideoView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        resize();
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
            int i = AnonymousClass3.$SwitchMap$stikerwap$appdys$FullscreenVideoView$State[this.lastState.ordinal()];
            if (i == 1) {
                start();
            } else if (i == 2) {
                this.currentState = State.PLAYBACKCOMPLETED;
            } else if (i == 3) {
                this.currentState = State.PREPARED;
            }
        }
    }

    /* renamed from: stikerwap.appdys.FullscreenVideoView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$stikerwap$appdys$FullscreenVideoView$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                stikerwap.appdys.FullscreenVideoView$State[] r0 = stikerwap.appdys.FullscreenVideoView.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$stikerwap$appdys$FullscreenVideoView$State = r0
                stikerwap.appdys.FullscreenVideoView$State r1 = stikerwap.appdys.FullscreenVideoView.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$stikerwap$appdys$FullscreenVideoView$State     // Catch:{ NoSuchFieldError -> 0x001d }
                stikerwap.appdys.FullscreenVideoView$State r1 = stikerwap.appdys.FullscreenVideoView.State.PLAYBACKCOMPLETED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$stikerwap$appdys$FullscreenVideoView$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                stikerwap.appdys.FullscreenVideoView$State r1 = stikerwap.appdys.FullscreenVideoView.State.PREPARED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.FullscreenVideoView.AnonymousClass3.<clinit>():void");
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
            this.globales = (config) this.context.getApplicationContext();
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
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color((ProgressBar) this.onProgressView, this.globales.c_icos);
        }
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
            boolean z2 = false;
            if (!ViewConfiguration.get(getContext()).hasPermanentMenuKey()) {
                ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(z ? 5894 : 0);
            } else if (z) {
                ((Activity) getContext()).getWindow().setFlags(1024, 1024);
            } else {
                ((Activity) getContext()).getWindow().clearFlags(1024);
            }
            if (this.fullscreen != z) {
                this.fullscreen = z;
                final boolean isPlaying = this.mediaPlayer.isPlaying();
                if (isPlaying) {
                    pause();
                }
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
                    }
                } else {
                    ViewParent parent2 = getParent();
                    if (parent2 instanceof ViewGroup) {
                        ViewGroup viewGroup = this.parentView;
                        if (!(viewGroup == null || viewGroup.getParent() == null)) {
                            this.detachedByFullscreen = true;
                            z2 = true;
                        }
                        ((ViewGroup) parent2).removeView(this);
                        if (z2) {
                            this.parentView.addView(this);
                            setLayoutParams(this.currentLayoutParams);
                        }
                    }
                }
                resize();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (isPlaying && FullscreenVideoView.this.mediaPlayer != null) {
                            FullscreenVideoView.this.start();
                        }
                    }
                });
            }
        }
    }

    public void resize() {
        if (this.initialMovieHeight != -1 && this.initialMovieWidth != -1 && this.surfaceView != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    View view = (View) FullscreenVideoView.this.getParent();
                    if (view != null) {
                        float f = ((float) FullscreenVideoView.this.initialMovieWidth) / ((float) FullscreenVideoView.this.initialMovieHeight);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        float f2 = (float) width;
                        float f3 = (float) height;
                        if (f > f2 / f3) {
                            height = (int) (f2 / f);
                        } else {
                            width = (int) (f * f3);
                        }
                        ViewGroup.LayoutParams layoutParams = FullscreenVideoView.this.surfaceView.getLayoutParams();
                        layoutParams.width = width;
                        layoutParams.height = height;
                        FullscreenVideoView.this.surfaceView.setLayoutParams(layoutParams);
                        try {
                            ((LinearLayout) FullscreenVideoView.this.findViewById(R.id.ll_btns)).setLayoutParams(layoutParams);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
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

    public void setVideoURI(Uri uri, String str, List<String[]> list) throws IOException, IllegalStateException, SecurityException, IllegalArgumentException, RuntimeException {
        if (this.mediaPlayer == null) {
            throw new RuntimeException("Media Player is not initialized");
        } else if (this.currentState == State.IDLE) {
            if ((str == null || str.isEmpty()) && (list == null || list.size() <= 0)) {
                this.mediaPlayer.setDataSource(this.context, uri);
            } else {
                HashMap hashMap = new HashMap();
                if (str != null && !str.isEmpty()) {
                    hashMap.put("User-Agent", str);
                }
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        hashMap.put(list.get(i)[0], list.get(i)[1]);
                    }
                }
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
