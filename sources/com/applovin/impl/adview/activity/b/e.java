package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.m;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.t;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.q;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class e extends a implements AppLovinCommunicatorSubscriber {
    protected boolean A;
    protected long B;
    protected int C;
    protected boolean D;
    protected boolean E;
    private final com.applovin.impl.adview.activity.a.c F = new com.applovin.impl.adview.activity.a.c(this.a, this.e, this.b);
    private final a G;
    private final Handler H;
    private final boolean I;
    private long J;
    private final AtomicBoolean K;
    private final AtomicBoolean L;
    /* access modifiers changed from: private */
    public long M;
    /* access modifiers changed from: private */
    public long N;
    protected final PlayerView s;
    protected final SimpleExoPlayer t;
    protected final com.applovin.impl.adview.a u;
    protected final m v;
    protected final ImageView w;
    protected final t x;
    protected final ProgressBar y;
    protected final j z;

    private class a implements u.a {
        private a() {
        }

        public void a(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                e.this.c.b("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            e.this.a(tVar.getAndClearLastClickLocation());
        }

        public void b(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                e.this.c.b("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            e.this.h();
        }

        public void c(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                e.this.c.b("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            e.this.c();
        }
    }

    private class b implements AppLovinTouchToClickListener.OnClickListener, Player.EventListener, PlayerControlView.VisibilityListener {
        private b() {
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            Player.EventListener.CC.$default$onAvailableCommandsChanged(this, commands);
        }

        public void onClick(View view, PointF pointF) {
            e.this.a(pointF);
        }

        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            Player.EventListener.CC.$default$onEvents(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(int i) {
            Player.EventListener.CC.$default$onMaxSeekToPreviousPositionChanged(this, i);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            Player.EventListener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public void onPlaybackStateChanged(int i) {
            if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = e.this.c;
                uVar.b("AppLovinFullscreenActivity", "Player state changed to state " + i + " and will play when ready: " + e.this.t.getPlayWhenReady());
            }
            if (i == 2) {
                e.this.v();
                e.this.d.g();
            } else if (i == 3) {
                e.this.t.setVolume(e.this.A ^ true ? 1.0f : 0.0f);
                e eVar = e.this;
                eVar.c(eVar.t.getDuration());
                e.this.u();
                if (com.applovin.impl.sdk.u.a()) {
                    com.applovin.impl.sdk.u uVar2 = e.this.c;
                    uVar2.b("AppLovinFullscreenActivity", "MediaPlayer prepared: " + e.this.t);
                }
                e.this.z.a();
                if (e.this.v != null) {
                    e.this.A();
                }
                e.this.w();
                if (e.this.q.c()) {
                    e.this.e();
                }
            } else if (i == 4) {
                if (com.applovin.impl.sdk.u.a()) {
                    e.this.c.b("AppLovinFullscreenActivity", "Video completed");
                }
                e.this.E = true;
                e.this.y();
            }
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public void onPlayerError(PlaybackException playbackException) {
            e eVar = e.this;
            eVar.c("Video view error (" + playbackException + ")");
            e.this.h();
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            Player.EventListener.CC.$default$onPlayerErrorChanged(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            Player.EventListener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            Player.EventListener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            Player.EventListener.CC.$default$onSeekBackIncrementChanged(this, j);
        }

        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            Player.EventListener.CC.$default$onSeekForwardIncrementChanged(this, j);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onStaticMetadataChanged(List list) {
            Player.EventListener.CC.$default$onStaticMetadataChanged(this, list);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        public void onVisibilityChange(int i) {
            if (i == 0) {
                e.this.s.hideController();
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            if (view == e.this.v) {
                if (e.this.s()) {
                    e.this.e();
                    e.this.p();
                    e.this.q.b();
                    return;
                }
                e.this.c();
            } else if (view == e.this.w) {
                e.this.x();
            } else if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = e.this.c;
                uVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public e(com.applovin.impl.sdk.ad.e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        a aVar = new a();
        this.G = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.H = handler;
        j jVar = new j(handler, this.b);
        this.z = jVar;
        boolean f = this.a.f();
        this.I = f;
        this.A = Utils.isVideoMutedInitially(this.b);
        this.J = -1;
        this.K = new AtomicBoolean();
        this.L = new AtomicBoolean();
        this.M = -2;
        this.N = 0;
        if (eVar.hasVideoUrl()) {
            c cVar = new c();
            if (eVar.r() >= 0) {
                m mVar2 = new m(eVar.x(), activity);
                this.v = mVar2;
                mVar2.setVisibility(8);
                mVar2.setOnClickListener(cVar);
            } else {
                this.v = null;
            }
            if (a(this.A, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.w = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                d(this.A);
            } else {
                this.w = null;
            }
            String C2 = eVar.C();
            if (StringUtils.isValidString(C2)) {
                u uVar = new u(mVar);
                uVar.a(new WeakReference(aVar));
                t tVar = new t(uVar, activity);
                this.x = tVar;
                tVar.a(C2);
            } else {
                this.x = null;
            }
            if (f) {
                com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(com.applovin.impl.sdk.d.b.cC)).intValue(), 16842874);
                this.u = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.u = null;
            }
            if (eVar.O()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.y = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (g.d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(eVar.P()));
                }
                jVar.a("PROGRESS_BAR", ((Long) mVar.a(com.applovin.impl.sdk.d.b.cz)).longValue(), (j.a) new j.a() {
                    public void a() {
                        if (e.this.D) {
                            e.this.y.setVisibility(8);
                            return;
                        }
                        e.this.y.setProgress((int) ((((float) e.this.t.getCurrentPosition()) / ((float) e.this.B)) * 10000.0f));
                    }

                    public boolean b() {
                        return !e.this.D;
                    }
                });
            } else {
                this.y = null;
            }
            SimpleExoPlayer build = new SimpleExoPlayer.Builder(activity).build();
            this.t = build;
            b bVar = new b();
            build.addListener((Player.EventListener) bVar);
            build.setRepeatMode(0);
            PlayerView playerView = new PlayerView(activity);
            this.s = playerView;
            playerView.hideController();
            playerView.setControllerVisibilityListener(bVar);
            playerView.setPlayer(build);
            playerView.setOnTouchListener(new AppLovinTouchToClickListener(mVar, com.applovin.impl.sdk.d.b.aO, activity, bVar));
            z();
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    private void E() {
        t tVar;
        s D2 = this.a.D();
        if (D2 != null && D2.e() && !this.D && (tVar = this.x) != null) {
            final boolean z2 = tVar.getVisibility() == 4;
            final long f = D2.f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z2) {
                        q.a((View) e.this.x, f, (Runnable) null);
                    } else {
                        q.b(e.this.x, f, (Runnable) null);
                    }
                }
            });
        }
    }

    private static boolean a(boolean z2, com.applovin.impl.sdk.m mVar) {
        if (!((Boolean) mVar.a(com.applovin.impl.sdk.d.b.cr)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.a(com.applovin.impl.sdk.d.b.cs)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) mVar.a(com.applovin.impl.sdk.d.b.cu)).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void A() {
        if (this.L.compareAndSet(false, true)) {
            a(this.v, this.a.r(), new Runnable() {
                public void run() {
                    long unused = e.this.M = -1;
                    long unused2 = e.this.N = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.C = D();
        this.t.setPlayWhenReady(false);
    }

    /* access modifiers changed from: protected */
    public void C() {
        if (this.D) {
            if (com.applovin.impl.sdk.u.a()) {
                this.c.d("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
            }
        } else if (!this.b.ad().a()) {
            long j = this.J;
            if (j >= 0) {
                if (com.applovin.impl.sdk.u.a()) {
                    com.applovin.impl.sdk.u uVar = this.c;
                    uVar.b("AppLovinFullscreenActivity", "Resuming video at position " + j + "ms for MediaPlayer: " + this.t);
                }
                this.t.setPlayWhenReady(true);
                this.z.a();
                this.J = -1;
                if (!this.t.isPlaying()) {
                    v();
                }
            } else if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar2 = this.c;
                uVar2.b("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.t.isPlaying());
            }
        } else if (com.applovin.impl.sdk.u.a()) {
            this.c.d("AppLovinFullscreenActivity", "Skip video resume - app paused");
        }
    }

    /* access modifiers changed from: protected */
    public int D() {
        SimpleExoPlayer simpleExoPlayer = this.t;
        if (simpleExoPlayer == null) {
            return 0;
        }
        long currentPosition = simpleExoPlayer.getCurrentPosition();
        if (this.E) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.B)) * 100.0f) : this.C;
    }

    public void a() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(long j) {
        a((Runnable) new Runnable() {
            public void run() {
                e.this.C();
            }
        }, j);
    }

    /* access modifiers changed from: protected */
    public void a(PointF pointF) {
        if (this.a.E()) {
            if (com.applovin.impl.sdk.u.a()) {
                this.c.b("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri k = this.a.k();
            if (k != null) {
                this.b.u().trackAndLaunchVideoClick(this.a, k, pointF, this, this.f != null ? this.f.getContext() : this.b.L());
                com.applovin.impl.sdk.utils.j.a(this.n, (AppLovinAd) this.a);
                this.d.b();
                this.k++;
                return;
            }
            return;
        }
        E();
    }

    public void a(ViewGroup viewGroup) {
        this.F.a(this.w, this.v, this.x, this.u, this.y, this.s, this.f, viewGroup);
        this.t.setPlayWhenReady(true);
        if (this.a.am()) {
            this.q.a(this.a, (Runnable) new Runnable() {
                public void run() {
                    e.this.a(250);
                }
            });
        }
        if (this.I) {
            v();
        }
        this.f.renderAd(this.a);
        this.d.b(this.I ? 1 : 0);
        if (this.v != null) {
            this.b.S().a(new z(this.b, new Runnable() {
                public void run() {
                    e.this.A();
                }
            }), o.a.MAIN, this.a.s(), true);
        }
        super.b(this.A);
    }

    public void b() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        c();
    }

    public void c() {
        this.M = SystemClock.elapsedRealtime() - this.N;
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.M + "ms");
        }
        this.d.f();
        this.j++;
        if (this.a.y()) {
            h();
        } else {
            y();
        }
    }

    /* access modifiers changed from: protected */
    public void c(long j) {
        this.B = j;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        if (com.applovin.impl.sdk.u.a()) {
            com.applovin.impl.sdk.u uVar = this.c;
            uVar.e("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.a);
        }
        if (this.K.compareAndSet(false, true)) {
            if (this.o instanceof com.applovin.impl.sdk.ad.g) {
                ((com.applovin.impl.sdk.ad.g) this.o).onAdDisplayFailed(str);
            }
            h();
        }
    }

    public void c(boolean z2) {
        super.c(z2);
        if (z2) {
            a(0);
        } else if (!this.D) {
            e();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    public void d(boolean z2) {
        if (g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.e.getDrawable(z2 ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.w.setScaleType(ImageView.ScaleType.FIT_XY);
                this.w.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.a.aC() : this.a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.w.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public void e() {
        String str;
        com.applovin.impl.sdk.u uVar;
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Pausing video");
        }
        if (this.t.isPlaying()) {
            this.J = this.t.getCurrentPosition();
            this.t.setPlayWhenReady(false);
            this.z.c();
            if (com.applovin.impl.sdk.u.a()) {
                uVar = this.c;
                str = "Paused video at position " + this.J + "ms";
            } else {
                return;
            }
        } else if (com.applovin.impl.sdk.u.a()) {
            uVar = this.c;
            str = "Nothing to pause";
        } else {
            return;
        }
        uVar.b("AppLovinFullscreenActivity", str);
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    public void h() {
        this.z.b();
        this.H.removeCallbacksAndMessages((Object) null);
        m();
        super.h();
    }

    public void k() {
        this.t.release();
        if (this.I) {
            AppLovinCommunicator.getInstance(this.e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        super.k();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a(D(), this.I, r(), this.M);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.eP)).booleanValue() && j == this.a.getAdIdNumber() && this.I) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.E && !this.t.isPlaying()) {
                    c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.a != null && D() >= this.a.Q();
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return t() && !r();
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j;
        int l;
        long j2 = 0;
        if (this.a.ad() >= 0 || this.a.ae() >= 0) {
            int i = (this.a.ad() > 0 ? 1 : (this.a.ad() == 0 ? 0 : -1));
            com.applovin.impl.sdk.ad.e eVar = this.a;
            if (i >= 0) {
                j = eVar.ad();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                long j3 = this.B;
                if (j3 > 0) {
                    j2 = 0 + j3;
                }
                if (aVar.af() && ((l = (int) ((com.applovin.impl.sdk.ad.a) this.a).l()) > 0 || (l = (int) aVar.t()) > 0)) {
                    j2 += TimeUnit.SECONDS.toMillis((long) l);
                }
                double d = (double) j2;
                double ae = (double) this.a.ae();
                Double.isNaN(ae);
                Double.isNaN(d);
                j = (long) (d * (ae / 100.0d));
            }
            b(j);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (e.this.u != null) {
                    e.this.u.a();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void w() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (e.this.u != null) {
                    e.this.u.b();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void x() {
        boolean z2 = !this.A;
        this.A = z2;
        this.t.setVolume(z2 ^ true ? 1.0f : 0.0f);
        d(this.A);
        a(this.A, 0);
    }

    public void y() {
        B();
        this.F.a(this.g, this.f);
        a("javascript:al_onPoststitialShow(" + this.j + "," + this.k + ");", (long) this.a.S());
        if (this.g != null) {
            int i = (this.a.t() > 0 ? 1 : (this.a.t() == 0 ? 0 : -1));
            m mVar = this.g;
            if (i >= 0) {
                a(mVar, this.a.t(), new Runnable() {
                    public void run() {
                        e.this.i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.D = true;
    }

    /* access modifiers changed from: protected */
    public void z() {
        a(!this.I);
        ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory((Context) this.e, Util.getUserAgent(this.e, AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN))).createMediaSource(MediaItem.fromUri(this.a.h()));
        this.t.setVolume(this.A ^ true ? 1.0f : 0.0f);
        this.t.setMediaSource(createMediaSource);
        this.t.prepare();
        this.t.setPlayWhenReady(false);
    }
}
