package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.util.Timer;
import java.util.TimerTask;

public class VideoNativePlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final int INTERVAL_TIME_PLAY_TIME_PROGRESS = 100;
    public static final String TAG = "VideoNativePlayer";
    /* access modifiers changed from: private */
    public SimpleExoPlayer exoPlayer;
    private int mBufferTime = 5;
    private Timer mBufferTimeoutTimer;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    private boolean mHasChaoDi = false;
    /* access modifiers changed from: private */
    public boolean mHasPrepare = false;
    /* access modifiers changed from: private */
    public VideoPlayerStatusListener mInnerVFPLisener;
    private boolean mIsAllowLoopPlay = true;
    /* access modifiers changed from: private */
    public boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public boolean mIsComplete = false;
    private boolean mIsFrontDesk = true;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsOpenSound = true;
    private boolean mIsPlaying = false;
    /* access modifiers changed from: private */
    public boolean mIsStartPlay = true;
    /* access modifiers changed from: private */
    public View mLoadingView;
    private String mNetUrl;
    /* access modifiers changed from: private */
    public VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private Surface mSurfaceHolder;
    private MediaSource mediaSource;
    private Runnable playProgressMSRunnable = new Runnable() {
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer != null && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                    long unused = videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                    long access$100 = VideoNativePlayer.this.mCurrentPosition / 100;
                    long duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0 : VideoNativePlayer.this.exoPlayer.getDuration() / 100;
                    if (access$100 >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                        VideoNativePlayer videoNativePlayer2 = VideoNativePlayer.this;
                        videoNativePlayer2.postOnPlayProgressMSOnMainThread(videoNativePlayer2.mCurrentPosition / 100, duration);
                    }
                    VideoNativePlayer.this.mHandler.postDelayed(this, 100);
                }
            } catch (Exception e) {
                aa.d(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };
    private Runnable playProgressRunnable = new Runnable() {
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer != null && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                    long unused = videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                    int access$100 = (int) (VideoNativePlayer.this.mCurrentPosition / 1000);
                    int duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0 : (int) (VideoNativePlayer.this.exoPlayer.getDuration() / 1000);
                    if (VideoNativePlayer.this.mIsStartPlay) {
                        VideoNativePlayer.this.postOnPlayStartOnMainThread(duration);
                        boolean unused2 = VideoNativePlayer.this.mIsStartPlay = false;
                    }
                    if (access$100 >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                        VideoNativePlayer.this.postOnPlayProgressOnMainThread(access$100, duration);
                    }
                    boolean unused3 = VideoNativePlayer.this.mIsComplete = false;
                    if (!VideoNativePlayer.this.mIsBuffering) {
                        VideoNativePlayer.this.hideLoading();
                    }
                    VideoNativePlayer.this.mHandler.postDelayed(this, 1000);
                }
            } catch (Exception e) {
                aa.d(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };

    public void onLoadingChanged(boolean z) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void play(Context context, String str, int i) {
        try {
            this.mCurrentPosition = (long) i;
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            setDataSource(context);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void play(Context context, String str, Surface surface) {
        try {
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            this.mSurfaceHolder = surface;
            setDataSource(context);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void replaySameSource(Context context, String str, Surface surface) {
        MediaSource mediaSource2;
        try {
            showLoading();
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null || (mediaSource2 = this.mediaSource) == null) {
                play(context, str, surface);
                return;
            }
            simpleExoPlayer.prepare(mediaSource2);
            this.exoPlayer.setPlayWhenReady(true);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
            this.mHandler.post(this.playProgressMSRunnable);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
            this.mHandler.removeCallbacks(this.playProgressMSRunnable);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void cancelBufferTimeoutTimer() {
        try {
            Timer timer = this.mBufferTimeoutTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void startBufferingTimer(final String str) {
        if (this.mIsNeedBufferingTimeout) {
            cancelBufferTimeoutTimer();
            Timer timer = new Timer();
            this.mBufferTimeoutTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    try {
                        if (!VideoNativePlayer.this.mHasPrepare || VideoNativePlayer.this.mIsBuffering) {
                            VideoNativePlayer.this.postOnBufferingStarOnMainThread(str);
                        }
                    } catch (Exception e) {
                        aa.d(VideoNativePlayer.TAG, e.getMessage());
                    }
                }
            }, (long) (this.mBufferTime * 1000));
        }
    }

    public void initBufferIngParam(int i) {
        if (i > 0) {
            this.mBufferTime = i;
        }
        this.mIsNeedBufferingTimeout = true;
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0;
            hideLoading();
            postOnPlayCompletedOnMainThread();
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void onPrepared() {
        try {
            if (this.mIsFrontDesk) {
                this.mHasPrepare = true;
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
                if (this.exoPlayer != null) {
                    this.mIsPlaying = true;
                }
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public void showLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mLoadingView != null) {
                            VideoNativePlayer.this.mLoadingView.setVisibility(0);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mLoadingView != null) {
                            VideoNativePlayer.this.mLoadingView.setVisibility(8);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i, final int i2) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgress(i, i2);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgress(i, i2);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayProgressMSOnMainThread(long j, long j2) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                final long j3 = j;
                final long j4 = j2;
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgressMS((int) j3, (int) j4);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgressMS((int) j3, (int) j4);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingStart(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingStart(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingEnd();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingEnd();
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayStartOnMainThread(final int i) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayStarted(i);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayStarted(i);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayError(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayError(str);
                        }
                    }
                });
            }
            q.a(42, this.mPlayUrl, str);
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                        }
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayCompleted();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayCompleted();
                        }
                    }
                });
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                hideLoading();
                this.exoPlayer.setPlayWhenReady(false);
                this.mIsPlaying = false;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                hideLoading();
                this.exoPlayer.stop();
                cancelPlayProgressTimer();
                this.mIsPlaying = false;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void start() {
        start((Surface) null);
    }

    public void start(Surface surface) {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && !exoPlayerIsPlaying()) {
                showLoading();
                if (surface != null) {
                    this.mSurfaceHolder = surface;
                    this.exoPlayer.setVideoSurface(surface);
                }
                play();
                startPlayProgressTimer();
                this.mIsPlaying = true;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void play() {
        try {
            this.exoPlayer.setPlayWhenReady(true);
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void start(int i) {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && !exoPlayerIsPlaying()) {
                if (i > 0) {
                    this.exoPlayer.seekTo((long) i);
                }
                play();
                startPlayProgressTimer();
                this.mIsPlaying = true;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public boolean initParameter(String str, boolean z, boolean z2, View view, VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } else if (view == null) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } else {
                this.mIsOpenSound = z;
                this.mIsAllowLoopPlay = z2;
                this.mLoadingView = view;
                this.mNetUrl = str;
                this.mOutterVFListener = videoPlayerStatusListener;
                return true;
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[Catch:{ Exception -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[Catch:{ Exception -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "VideoNativePlayer"
            r1 = 1
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            if (r2 == 0) goto L_0x0020
            boolean r2 = r6.exoPlayerIsPlaying()     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0012
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ all -> 0x0018 }
            r2.stop()     // Catch:{ all -> 0x0018 }
        L_0x0012:
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ all -> 0x0018 }
            r2.release()     // Catch:{ all -> 0x0018 }
            goto L_0x0020
        L_0x0018:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.foundation.tools.aa.d(r0, r2)     // Catch:{ Exception -> 0x00ae }
        L_0x0020:
            boolean r2 = r6.mIsOpenSound     // Catch:{ Exception -> 0x00ae }
            if (r2 != 0) goto L_0x0027
            r6.closeSound()     // Catch:{ Exception -> 0x00ae }
        L_0x0027:
            java.lang.String r2 = r6.mPlayUrl     // Catch:{ Exception -> 0x00ae }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00ae }
            if (r2 != 0) goto L_0x009f
            com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory r2 = new com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory     // Catch:{ Exception -> 0x00ae }
            r2.<init>(r7)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector r3 = new com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector     // Catch:{ Exception -> 0x00ae }
            r3.<init>()     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl r4 = new com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl     // Catch:{ Exception -> 0x00ae }
            r4.<init>()     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory.newSimpleInstance((com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory) r2, (com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector) r3, (com.mbridge.msdk.playercommon.exoplayer2.LoadControl) r4)     // Catch:{ Exception -> 0x00ae }
            r6.exoPlayer = r2     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = r6.mPlayUrl     // Catch:{ Exception -> 0x00ae }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r3 = r6.mPlayUrl     // Catch:{ Exception -> 0x00ae }
            java.lang.String r4 = "http"
            boolean r3 = r3.startsWith(r4)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r4 = "MBridge_ExoPlayer"
            if (r3 != 0) goto L_0x0072
            java.lang.String r3 = r6.mPlayUrl     // Catch:{ Exception -> 0x00ae }
            java.lang.String r5 = "https"
            boolean r3 = r3.startsWith(r5)     // Catch:{ Exception -> 0x00ae }
            if (r3 == 0) goto L_0x0061
            goto L_0x0072
        L_0x0061:
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory r3 = new com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory     // Catch:{ Exception -> 0x00ae }
            r5.<init>(r7, r4)     // Catch:{ Exception -> 0x00ae }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource r2 = r3.createMediaSource((android.net.Uri) r2)     // Catch:{ Exception -> 0x00ae }
            r6.mediaSource = r2     // Catch:{ Exception -> 0x00ae }
            goto L_0x0082
        L_0x0072:
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory r3 = new com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource$Factory     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory r5 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory     // Catch:{ Exception -> 0x00ae }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00ae }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource r2 = r3.createMediaSource((android.net.Uri) r2)     // Catch:{ Exception -> 0x00ae }
            r6.mediaSource = r2     // Catch:{ Exception -> 0x00ae }
        L_0x0082:
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            boolean r3 = r6.mIsAllowLoopPlay     // Catch:{ Exception -> 0x00ae }
            if (r3 == 0) goto L_0x008a
            r3 = 2
            goto L_0x008b
        L_0x008a:
            r3 = 0
        L_0x008b:
            r2.setRepeatMode(r3)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource r3 = r6.mediaSource     // Catch:{ Exception -> 0x00ae }
            r2.prepare(r3)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            r2.setPlayWhenReady(r1)     // Catch:{ Exception -> 0x00ae }
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r2 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            r2.addListener(r6)     // Catch:{ Exception -> 0x00ae }
        L_0x009f:
            android.view.Surface r2 = r6.mSurfaceHolder     // Catch:{ Exception -> 0x00ae }
            if (r2 == 0) goto L_0x00a8
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer r3 = r6.exoPlayer     // Catch:{ Exception -> 0x00ae }
            r3.setVideoSurface(r2)     // Catch:{ Exception -> 0x00ae }
        L_0x00a8:
            java.lang.String r2 = "mediaplayer prepare timeout"
            r6.startBufferingTimer(r2)     // Catch:{ Exception -> 0x00ae }
            goto L_0x00eb
        L_0x00ae:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r2)
            r6.hideLoading()
            java.lang.String r0 = r6.mPlayUrl
            boolean r0 = android.webkit.URLUtil.isNetworkUrl(r0)
            java.lang.String r2 = "set data source error"
            java.lang.String r3 = "mediaplayer cannot play"
            if (r0 == 0) goto L_0x00cc
            r6.postOnPlayErrorOnMainThread(r3)
            r6.postOnPlaySetDataSourceError2MainThread(r2)
            goto L_0x00e8
        L_0x00cc:
            java.lang.String r0 = r6.mNetUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00e5
            boolean r0 = r6.mHasChaoDi
            if (r0 != 0) goto L_0x00e5
            r6.mHasChaoDi = r1
            java.lang.String r0 = r6.mNetUrl
            r6.mPlayUrl = r0
            r6.showLoading()
            r6.setDataSource(r7)
            goto L_0x00e8
        L_0x00e5:
            r6.postOnPlayErrorOnMainThread(r3)
        L_0x00e8:
            r6.postOnPlaySetDataSourceError2MainThread(r2)
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.VideoNativePlayer.setDataSource(android.content.Context):void");
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void releasePlayer() {
        try {
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.exoPlayer = null;
                this.mIsPlaying = false;
            }
            if (this.mOutterVFListener != null) {
                this.mOutterVFListener = null;
            }
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
        hideLoading();
    }

    public void closeSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(0.0f);
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public void openSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(1.0f);
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
            return false;
        }
    }

    public boolean onError(int i, String str) {
        try {
            hideLoading();
            this.mHasPrepare = false;
            this.mIsPlaying = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
            return true;
        }
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void setIsFrontDesk(boolean z) {
        try {
            this.mIsFrontDesk = z;
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public void setIsComplete(boolean z) {
        this.mIsComplete = z;
    }

    public boolean isPlaying() {
        return exoPlayerIsPlaying();
    }

    public boolean loadingViewIsVisible() {
        try {
            View view = this.mLoadingView;
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return false;
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.getPlaybackState() == 3 && this.exoPlayer.getPlayWhenReady();
    }

    public void onPlayerStateChanged(boolean z, int i) {
        aa.d(TAG, "onPlaybackStateChanged : " + i);
        if (i == 1) {
            aa.d(TAG, "onPlaybackStateChanged : IDLE");
        } else if (i == 2) {
            aa.d(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferingTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
        } else if (i == 3) {
            aa.d(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
        } else if (i == 4) {
            aa.d(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
            cancelPlayProgressTimer();
            onCompletion();
            if (!this.mIsAllowLoopPlay) {
                this.mHasPrepare = false;
            }
        }
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        String str;
        if (exoPlaybackException != null) {
            int i = exoPlaybackException.type;
            if (i == 0) {
                str = "Play error, because have a SourceException.";
            } else if (i == 1) {
                str = "Play error, because have a RendererException.";
            } else if (i == 2) {
                str = "Play error, because have a UnexpectedException.";
            }
            if (exoPlaybackException.getCause() != null && !TextUtils.isEmpty(exoPlaybackException.getCause().getMessage())) {
                str = exoPlaybackException.getCause().getMessage();
            }
            aa.d(TAG, "onPlayerError : " + str);
            onError(exoPlaybackException.type, str);
        }
        str = "Play error and ExoPlayer have not message.";
        str = exoPlaybackException.getCause().getMessage();
        aa.d(TAG, "onPlayerError : " + str);
        onError(exoPlaybackException.type, str);
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        aa.d(TAG, "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    public void onPositionDiscontinuity(int i) {
        aa.d(TAG, "onPositionDiscontinuity : " + i);
        if (i == 0) {
            onCompletion();
        }
    }
}
