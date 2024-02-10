package com.startapp.sdk.ads.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.login.LoginLogger;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.startio.adsession.media.InteractionType;
import com.iab.omid.library.startio.adsession.media.Position;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.a0;
import com.startapp.a5;
import com.startapp.b6;
import com.startapp.d4;
import com.startapp.f9;
import com.startapp.fb;
import com.startapp.fc;
import com.startapp.ga;
import com.startapp.gc;
import com.startapp.h0;
import com.startapp.ha;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.j4;
import com.startapp.ja;
import com.startapp.k9;
import com.startapp.ka;
import com.startapp.l;
import com.startapp.la;
import com.startapp.lc;
import com.startapp.ma;
import com.startapp.na;
import com.startapp.oa;
import com.startapp.p0;
import com.startapp.pa;
import com.startapp.qa;
import com.startapp.rb;
import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.ads.video.tracking.AbsoluteTrackingLink;
import com.startapp.sdk.ads.video.tracking.ActionTrackingLink;
import com.startapp.sdk.ads.video.tracking.FractionTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoClickedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoPausedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoProgressTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationView;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.omsdk.VerificationDetails;
import com.startapp.t9;
import com.startapp.w4;
import com.startapp.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class VideoMode extends d4 {
    public static final /* synthetic */ int q0 = 0;
    public VideoPlayerInterface K;
    public VideoView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public ProgressBar O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T = 1;
    public boolean U;
    public boolean V;
    public int W = 0;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public int a0 = 0;
    public int b0;
    public boolean c0;
    public boolean d0;
    public int e0;
    public long f0;
    public String g0 = null;
    public final Handler h0 = new Handler();
    public final Map<Integer, Boolean> i0 = new HashMap();
    public final Map<Integer, Boolean> j0 = new HashMap();
    public final Map<Integer, List<FractionTrackingLink>> k0 = new HashMap();
    public final Map<Integer, List<AbsoluteTrackingLink>> l0 = new HashMap();
    public final Handler m0 = new Handler();
    public final Runnable n0 = new b();
    public boolean o0;
    public final BroadcastReceiver p0 = new c();

    /* compiled from: Sta */
    public enum HtmlMode {
        POST_ROLL
    }

    /* compiled from: Sta */
    public enum VideoFinishedReason {
        COMPLETE,
        CLICKED,
        SKIPPED
    }

    /* compiled from: Sta */
    public class a implements Runnable {

        /* renamed from: com.startapp.sdk.ads.video.VideoMode$a$a  reason: collision with other inner class name */
        /* compiled from: Sta */
        public class C0164a implements Runnable {
            public C0164a() {
            }

            public void run() {
                try {
                    VideoMode videoMode = VideoMode.this;
                    int i = VideoMode.q0;
                    videoMode.N();
                    VideoMode videoMode2 = VideoMode.this;
                    videoMode2.a(new VideoPlayerInterface.f(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT, "Buffering timeout reached", videoMode2.x()));
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }

        public a() {
        }

        public void run() {
            try {
                ProgressBar progressBar = VideoMode.this.O;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                VideoMode.this.h0.postDelayed(new C0164a(), AdsCommonMetaData.h.G().c());
            } catch (Throwable th) {
                VideoMode.this.N();
                i3.a(th);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            VideoMode videoMode = VideoMode.this;
            if (videoMode.Q && videoMode.F()) {
                VideoMode videoMode2 = VideoMode.this;
                if (videoMode2.R) {
                    int x = videoMode2.x();
                    VideoMode videoMode3 = VideoMode.this;
                    int y = videoMode3.y();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long seconds = timeUnit.toSeconds((long) x);
                    if (seconds > videoMode3.f0) {
                        videoMode3.f0 = seconds;
                        k9.a(videoMode3.w, true, "videoApi.setVideoCurrentPosition", Long.valueOf(seconds));
                        if (x != y || videoMode3.d0) {
                            y -= x;
                        }
                        k9.a(videoMode3.w, true, "videoApi.setVideoRemainingTimer", Long.valueOf(timeUnit.toSeconds((long) y)));
                        if (videoMode3.I()) {
                            k9.a(videoMode3.w, true, "videoApi.setSkipTimer", Long.valueOf(videoMode3.c(x)));
                        }
                    }
                    VideoMode.this.e(x);
                }
            }
            VideoMode.this.m0.postDelayed(this, 200);
        }
    }

    /* compiled from: Sta */
    public class c extends BroadcastReceiver {
        public c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!VideoMode.this.p0.isInitialStickyBroadcast()) {
                VideoMode videoMode = VideoMode.this;
                boolean unused = videoMode.P = !videoMode.P;
                VideoMode.this.J();
                VideoMode videoMode2 = VideoMode.this;
                videoMode2.a(videoMode2.P);
            }
        }
    }

    /* compiled from: Sta */
    public class d extends d4.h {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            VideoMode.this.j();
            VideoMode.this.v();
        }
    }

    public VideoAdDetails A() {
        return ((VideoEnabledAd) this.l).x();
    }

    public final void B() {
        if (!this.h.equals("back")) {
            return;
        }
        if (AdsCommonMetaData.h.G().a().equals(VideoConfig.BackMode.BOTH)) {
            this.U = true;
            this.V = true;
        } else if (AdsCommonMetaData.h.G().a().equals(VideoConfig.BackMode.SKIP)) {
            this.U = true;
            this.V = false;
        } else if (AdsCommonMetaData.h.G().a().equals(VideoConfig.BackMode.CLOSE)) {
            this.U = false;
            this.V = true;
        } else if (AdsCommonMetaData.h.G().a().equals(VideoConfig.BackMode.DISABLED)) {
            this.U = false;
            this.V = false;
        } else {
            this.U = false;
            this.V = false;
        }
    }

    public final void C() {
        String e = A().e();
        if (e != null) {
            this.w.setWebViewClient(new d());
            k9.a(this.w, e);
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.K != null);
        k9.a(this.w, true, "videoApi.setReplayEnabled", objArr);
        k9.a(this.w, true, "videoApi.setMode", HtmlMode.POST_ROLL + "_" + A().f());
        k9.a(this.w, true, "videoApi.setCloseable", Boolean.TRUE);
    }

    public final void D() {
        FractionTrackingLink[] c2 = A().i().c();
        if (c2 != null) {
            for (FractionTrackingLink fractionTrackingLink : c2) {
                List list = this.k0.get(Integer.valueOf(fractionTrackingLink.e()));
                if (list == null) {
                    list = new ArrayList();
                    this.k0.put(Integer.valueOf(fractionTrackingLink.e()), list);
                }
                list.add(fractionTrackingLink);
            }
        }
        AbsoluteTrackingLink[] a2 = A().i().a();
        if (a2 != null) {
            for (AbsoluteTrackingLink absoluteTrackingLink : a2) {
                List list2 = this.l0.get(Integer.valueOf(absoluteTrackingLink.e()));
                if (list2 == null) {
                    list2 = new ArrayList();
                    this.l0.put(Integer.valueOf(absoluteTrackingLink.e()), list2);
                }
                list2.add(absoluteTrackingLink);
            }
        }
    }

    public boolean E() {
        if (!this.X) {
            if (!F() || !this.Q) {
                return false;
            }
            return true;
        } else if (this.W < AdsCommonMetaData.h.G().i() || !F() || !this.Q) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean F() {
        VideoPlayerInterface videoPlayerInterface = this.K;
        return videoPlayerInterface != null && ((NativeVideoPlayer) videoPlayerInterface).a();
    }

    public final boolean G() {
        ProgressBar progressBar = this.O;
        return progressBar != null && progressBar.isShown();
    }

    public final boolean H() {
        VideoPlayerInterface videoPlayerInterface;
        boolean n = A().n();
        Long h = A().h();
        if (h == null || (videoPlayerInterface = this.K) == null || !((NativeVideoPlayer) videoPlayerInterface).a()) {
            return n;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return n && timeUnit.toSeconds((long) ((NativeVideoPlayer) this.K).h.getDuration()) > timeUnit.toSeconds(h.longValue());
    }

    public final boolean I() {
        return this.D > 0 || H() || this.U;
    }

    public void J() {
        VideoPlayerInterface videoPlayerInterface = this.K;
        if (videoPlayerInterface != null) {
            try {
                boolean z = this.P;
                MediaPlayer mediaPlayer = ((NativeVideoPlayer) videoPlayerInterface).g;
                if (mediaPlayer != null) {
                    if (z) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        mediaPlayer.setVolume(1.0f, 1.0f);
                    }
                }
            } catch (Throwable th) {
                i3.a(th);
            }
        }
        Object[] objArr = new Object[1];
        objArr[0] = this.P ? "OFF" : "ON";
        k9.a(this.w, true, "videoApi.setSound", objArr);
    }

    public void K() {
        if (this.K != null) {
            boolean p = AdsCommonMetaData.h.G().p();
            String c2 = A().c();
            if (c2 != null) {
                VideoPlayerInterface videoPlayerInterface = this.K;
                if (videoPlayerInterface != null) {
                    ((NativeVideoPlayer) videoPlayerInterface).a(c2);
                }
                if (p && c2.endsWith(".temp")) {
                    this.X = true;
                    this.Z = true;
                    this.W = AdsCommonMetaData.h.G().i();
                }
            } else if (p) {
                String j = A().j();
                d dVar = d.b.a;
                if (j != null && j.equals(dVar.c)) {
                    dVar.a = false;
                }
                VideoPlayerInterface videoPlayerInterface2 = this.K;
                if (videoPlayerInterface2 != null) {
                    ((NativeVideoPlayer) videoPlayerInterface2).a(j);
                }
                this.X = true;
                L();
            } else {
                a(VideoFinishedReason.SKIPPED);
            }
            if (this.g0 == null) {
                this.g0 = this.X ? "2" : "1";
            }
        }
    }

    public final void L() {
        if (!G()) {
            this.h0.postDelayed(new a(), AdsCommonMetaData.h.G().g());
        }
    }

    public final void M() {
        VideoView videoView;
        b6 b6Var;
        this.Y = true;
        if (this.d0) {
            VideoPlayerInterface videoPlayerInterface = this.K;
            if (videoPlayerInterface != null) {
                ((NativeVideoPlayer) videoPlayerInterface).h.pause();
                return;
            }
            return;
        }
        if (x() == 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            k9.a(this.w, true, "videoApi.setVideoDuration", Long.valueOf(timeUnit.toSeconds((long) y())));
            k9.a(this.w, true, "videoApi.setVideoRemainingTimer", 0);
            k9.a(this.w, true, "videoApi.setSkipTimer", Long.valueOf(timeUnit.toSeconds(z())));
            k9.a(this.w, true, "videoApi.setVideoCurrentPosition", Long.valueOf(timeUnit.toSeconds((long) x())));
        }
        if (this.K != null) {
            if (x() == 0) {
                a((View) null);
            }
            VideoPlayerInterface videoPlayerInterface2 = this.K;
            if (videoPlayerInterface2 != null) {
                ((NativeVideoPlayer) videoPlayerInterface2).h.start();
                this.w.setBackgroundColor(33554431);
            }
            int y = y();
            if (y > 0 && (b6Var = this.G) != null) {
                float f = (float) y;
                float f2 = this.P ? 0.0f : 1.0f;
                a5 a5Var = b6Var.c;
                if (a5Var != null) {
                    if (f > 0.0f) {
                        a5Var.a(f2);
                        gc.a(a5Var.a);
                        JSONObject jSONObject = new JSONObject();
                        rb.a(jSONObject, "duration", Float.valueOf(f));
                        rb.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
                        rb.a(jSONObject, "deviceVolume", Float.valueOf(lc.a().a));
                        fc.a.a(a5Var.a.e.c(), "start", jSONObject);
                    } else {
                        throw new IllegalArgumentException("Invalid Media duration");
                    }
                }
            }
            N();
            if (this.Y && (videoView = this.L) != null) {
                b((View) videoView);
            }
        }
        this.c.b.setVisibility(4);
        J();
    }

    public final void N() {
        ProgressBar progressBar;
        this.h0.removeCallbacksAndMessages((Object) null);
        if (G() && (progressBar = this.O) != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void O() {
        if (G()) {
            N();
        }
        a(VideoFinishedReason.SKIPPED);
        a(A().i().p(), new VideoTrackingParams(this.p, b(this.e0), this.D, this.g0), this.e0, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
    }

    public final int d(int i) {
        return (y() * i) / 100;
    }

    public void e() {
        a5 a5Var;
        if (!this.d0 && !this.b.isFinishing() && !this.V && !this.U) {
            VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
            VideoPlayerInterface videoPlayerInterface = this.K;
            if (videoPlayerInterface != null) {
                ((NativeVideoPlayer) videoPlayerInterface).h.pause();
                b6 b6Var = this.G;
                if (!(b6Var == null || (a5Var = b6Var.c) == null)) {
                    gc.a(a5Var.a);
                    fc.a.a(a5Var.a.e.c(), CampaignEx.JSON_NATIVE_VIDEO_PAUSE, (JSONObject) null);
                }
            }
            a(A().i().j(), new VideoPausedTrackingParams(this.p, b(this.e0), this.D, this.T, pauseOrigin, this.g0), this.e0, "paused");
        }
        VideoPlayerInterface videoPlayerInterface2 = this.K;
        if (videoPlayerInterface2 != null) {
            NativeVideoPlayer nativeVideoPlayer = (NativeVideoPlayer) videoPlayerInterface2;
            MediaPlayer mediaPlayer = nativeVideoPlayer.g;
            if (mediaPlayer != null) {
                mediaPlayer.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener) null);
                nativeVideoPlayer.g = null;
            }
            d.b.a.b = null;
            this.K = null;
        }
        N();
        if (this.o0) {
            this.b.unregisterReceiver(this.p0);
            this.o0 = false;
        }
        this.m0.removeCallbacksAndMessages((Object) null);
        super.e();
    }

    public void f() {
        super.f();
        if (!this.b.isFinishing()) {
            this.b.registerReceiver(this.p0, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
            this.o0 = true;
            if (this.L == null) {
                Context a2 = h0.a(this.b);
                if (a2 == null) {
                    a2 = this.b;
                }
                this.N = (RelativeLayout) this.b.findViewById(1475346432);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                VideoView videoView = new VideoView(a2);
                this.L = videoView;
                videoView.setId(100);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                ProgressBar progressBar = new ProgressBar(a2, (AttributeSet) null, 16843399);
                this.O = progressBar;
                progressBar.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(14);
                layoutParams3.addRule(15);
                RelativeLayout relativeLayout = new RelativeLayout(a2);
                this.M = relativeLayout;
                relativeLayout.setId(1475346436);
                this.b.setContentView(this.M);
                this.M.addView(this.L, layoutParams2);
                this.M.addView(this.N, layoutParams);
                this.M.addView(this.O, layoutParams3);
                if (AdsConstants.g.booleanValue()) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(12);
                    layoutParams4.addRule(14);
                    RelativeLayout relativeLayout2 = this.M;
                    TextView textView = new TextView(a2);
                    textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    int i = a0.a;
                    textView.setAlpha(0.5f);
                    textView.setTextColor(-7829368);
                    textView.setSingleLine(false);
                    textView.setText("url=" + A().j());
                    relativeLayout2.addView(textView, layoutParams4);
                }
                this.c.b.setVisibility(4);
            }
            if (this.K == null) {
                this.K = new NativeVideoPlayer(this.L);
            }
            this.R = false;
            RelativeLayout relativeLayout3 = this.M;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            K();
            if (this.d0) {
                this.c.b.setVisibility(0);
                this.L.setVisibility(4);
            }
            VideoPlayerInterface videoPlayerInterface = this.K;
            com.startapp.sdk.ads.video.player.a aVar = (com.startapp.sdk.ads.video.player.a) videoPlayerInterface;
            aVar.e = new na(this);
            aVar.b = new oa(this);
            aVar.d = new i(this);
            pa paVar = new pa(this);
            aVar.c = new qa(this);
            videoPlayerInterface.getClass();
            VideoPlayerInterface videoPlayerInterface2 = this.K;
            ((com.startapp.sdk.ads.video.player.a) videoPlayerInterface2).f = paVar;
            videoPlayerInterface2.getClass();
            VideoView videoView2 = this.L;
            ja jaVar = new ja(this);
            int i2 = a0.a;
            videoView2.addOnLayoutChangeListener(new z(jaVar));
            this.m0.post(this.n0);
        }
    }

    public void h() {
        if (!this.S) {
            w4.a((Context) this.b).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
        }
    }

    public void i() {
        if (this.S) {
            return;
        }
        if (this.d0 || this.L == null) {
            a(A().i().l(), new VideoTrackingParams(this.p, b(this.e0), this.D, this.g0), this.e0, "postrollClosed");
            super.i();
            return;
        }
        VideoPlayerInterface videoPlayerInterface = this.K;
        int currentPosition = videoPlayerInterface != null ? ((NativeVideoPlayer) videoPlayerInterface).h.getCurrentPosition() : 0;
        a(A().i().i(), new VideoTrackingParams(this.p, b(currentPosition), this.D, this.g0), currentPosition, "closed");
    }

    public long k() {
        return TimeUnit.MILLISECONDS.toSeconds((long) x());
    }

    public j4 l() {
        Activity activity = this.b;
        Runnable runnable = this.H;
        return new ha(activity, runnable, runnable, new ma(this), new la(this), new ka(this), new TrackingParams(this.p), a(0));
    }

    public long m() {
        Long l = this.q;
        if (l != null) {
            return TimeUnit.SECONDS.toMillis(l.longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.k.t());
    }

    public TrackingParams n() {
        return new VideoTrackingParams(this.p, 0, this.D, this.g0);
    }

    public void onClick(View view) {
        this.H.run();
    }

    public boolean p() {
        return this.l.getType() == Ad.AdType.REWARDED_VIDEO;
    }

    public void q() {
    }

    public void r() {
        this.Q = true;
        if (this.d0) {
            b((View) this.w);
            C();
            return;
        }
        k9.a(this.w, true, "videoApi.setClickableVideo", Boolean.valueOf(A().l()));
        k9.a(this.w, true, "videoApi.setMode", "PLAYER");
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(A().m() || this.V);
        k9.a(this.w, true, "videoApi.setCloseable", objArr);
        k9.a(this.w, true, "videoApi.setSkippable", Boolean.valueOf(I()));
        if (E()) {
            M();
        }
    }

    public void s() {
        int k = AdsCommonMetaData.h.G().k();
        a(A().i().o(), new VideoTrackingParams(this.p, k, this.D, this.g0), d(k), "rewarded");
    }

    public final void w() {
        Intent intent = new Intent("com.startapp.android.ShowFailedDisplayBroadcastListener");
        intent.putExtra("showFailedReason", NotDisplayedReason.VIDEO_ERROR);
        w4.a((Context) this.b).a(intent);
        this.S = true;
    }

    public final int x() {
        VideoPlayerInterface videoPlayerInterface = this.K;
        if (videoPlayerInterface == null) {
            return this.e0;
        }
        int currentPosition = ((NativeVideoPlayer) videoPlayerInterface).h.getCurrentPosition();
        if (currentPosition > this.e0) {
            this.e0 = currentPosition;
        }
        return this.e0;
    }

    public final int y() {
        VideoPlayerInterface videoPlayerInterface = this.K;
        if (videoPlayerInterface != null) {
            return ((NativeVideoPlayer) videoPlayerInterface).h.getDuration();
        }
        return -1;
    }

    public final long z() {
        long g = A().g();
        VideoPlayerInterface videoPlayerInterface = this.K;
        return (videoPlayerInterface == null || !((NativeVideoPlayer) videoPlayerInterface).a()) ? g : Math.min(g, (long) ((NativeVideoPlayer) this.K).h.getDuration());
    }

    public void a(Bundle bundle) {
        boolean z;
        super.a(bundle);
        try {
            this.b0 = 100 / AdsCommonMetaData.h.G().h();
            B();
            D();
            if (!A().o()) {
                if (!AdsCommonMetaData.h.G().l().equals("muted")) {
                    z = false;
                    this.P = z;
                }
            }
            z = true;
            this.P = z;
        } catch (Throwable th) {
            i3.a(th);
            w();
            b();
        }
    }

    public void b(WebView webView) {
        this.B = false;
        webView.setOnTouchListener(new d4.e());
        a0.a(webView, (Paint) null);
    }

    public final long c(int i) {
        if (this.U || this.D > 0) {
            return 0;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long seconds = timeUnit.toSeconds(z()) - timeUnit.toSeconds((long) i);
        if (seconds <= 0) {
            return 0;
        }
        return seconds;
    }

    public final void b(View view) {
        k9.a(this.w, true, "videoApi.setVideoFrame", Integer.valueOf(f9.b(this.b, view.getLeft())), Integer.valueOf(f9.b(this.b, view.getTop())), Integer.valueOf(f9.b(this.b, view.getWidth())), Integer.valueOf(f9.b(this.b, view.getHeight())));
    }

    public boolean c() {
        if (this.d0) {
            i();
            return false;
        } else if (this.K == null) {
            return false;
        } else {
            long c2 = c(x());
            if (I() && c2 == 0) {
                O();
                return true;
            } else if (!A().m() && !this.V) {
                return true;
            } else {
                i();
                return false;
            }
        }
    }

    public void a(VideoFinishedReason videoFinishedReason) {
        a5 a5Var;
        b6 b6Var;
        a5 a5Var2;
        VideoFinishedReason videoFinishedReason2 = VideoFinishedReason.SKIPPED;
        if (!(videoFinishedReason != videoFinishedReason2 || (b6Var = this.G) == null || (a5Var2 = b6Var.c) == null)) {
            gc.a(a5Var2.a);
            fc.a.a(a5Var2.a.e.c(), LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, (JSONObject) null);
        }
        VideoFinishedReason videoFinishedReason3 = VideoFinishedReason.COMPLETE;
        if (videoFinishedReason == videoFinishedReason3) {
            int y = y();
            this.e0 = y;
            e(y);
            t();
            b6 b6Var2 = this.G;
            if (!(b6Var2 == null || (a5Var = b6Var2.c) == null)) {
                gc.a(a5Var.a);
                fc.a.a(a5Var.a.e.c(), CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, (JSONObject) null);
            }
        } else {
            VideoPlayerInterface videoPlayerInterface = this.K;
            if (videoPlayerInterface != null) {
                ((NativeVideoPlayer) videoPlayerInterface).h.pause();
            }
        }
        if (videoFinishedReason == videoFinishedReason3 || videoFinishedReason == videoFinishedReason2) {
            if (A().k()) {
                C();
                this.c.b.setVisibility(0);
            } else {
                b();
            }
            this.d0 = true;
            if (A().k()) {
                a(A().i().m(), new VideoTrackingParams(this.p, b(this.e0), this.D, this.g0), this.e0, "postrollImression");
            }
        }
    }

    public void b() {
        super.b();
        if (this.Z) {
            String c2 = A().c();
            if (c2 != null && c2.endsWith(".temp")) {
                new File(c2).delete();
            }
        }
    }

    public final int b(int i) {
        if (y() > 0) {
            return (i * 100) / y();
        }
        return 0;
    }

    public final void e(int i) {
        List list;
        a5 a5Var;
        if (!this.c0 && this.D <= 0 && i != 0) {
            this.c0 = true;
            this.A.c();
            a(A().i().d(), new VideoTrackingParams(this.p, 0, this.D, this.g0), 0, "impression");
            a(A().i().b(), new VideoTrackingParams(this.p, 0, this.D, this.g0), 0, "creativeView");
            b6 b6Var = this.G;
            if (b6Var != null) {
                b6Var.b();
            }
        }
        for (Integer intValue : this.k0.keySet()) {
            int intValue2 = intValue.intValue();
            if (i > 0 && i >= d(intValue2) && this.i0.get(Integer.valueOf(intValue2)) == null) {
                if (this.k0.containsKey(Integer.valueOf(intValue2))) {
                    List list2 = this.k0.get(Integer.valueOf(intValue2));
                    if (list2 != null) {
                        a((VideoTrackingLink[]) list2.toArray(new FractionTrackingLink[0]), new VideoProgressTrackingParams(this.p, intValue2, this.D, this.g0), (y() * intValue2) / 100, "fraction");
                    }
                    b6 b6Var2 = this.G;
                    if (b6Var2 != null) {
                        if (intValue2 == 25) {
                            a5 a5Var2 = b6Var2.c;
                            if (a5Var2 != null) {
                                gc.a(a5Var2.a);
                                fc.a.a(a5Var2.a.e.c(), "firstQuartile", (JSONObject) null);
                            }
                        } else if (intValue2 == 50) {
                            a5 a5Var3 = b6Var2.c;
                            if (a5Var3 != null) {
                                gc.a(a5Var3.a);
                                fc.a.a(a5Var3.a.e.c(), CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, (JSONObject) null);
                            }
                        } else if (intValue2 == 75 && (a5Var = b6Var2.c) != null) {
                            gc.a(a5Var.a);
                            fc.a.a(a5Var.a.e.c(), "thirdQuartile", (JSONObject) null);
                        }
                    }
                }
                this.i0.put(Integer.valueOf(intValue2), Boolean.TRUE);
            }
        }
        for (Integer intValue3 : this.l0.keySet()) {
            int intValue4 = intValue3.intValue();
            if (i > 0 && i >= intValue4 && this.j0.get(Integer.valueOf(intValue4)) == null) {
                if (this.l0.containsKey(Integer.valueOf(intValue4)) && (list = this.l0.get(Integer.valueOf(intValue4))) != null) {
                    a((VideoTrackingLink[]) list.toArray(new AbsoluteTrackingLink[0]), new VideoProgressTrackingParams(this.p, intValue4, this.D, this.g0), intValue4, Constants.PATH_TYPE_ABSOLUTE);
                }
                this.j0.put(Integer.valueOf(intValue4), Boolean.TRUE);
            }
        }
        if (i >= d(AdsCommonMetaData.h.G().k())) {
            t();
        }
        if (this.X && i >= d(AdsCommonMetaData.h.G().k())) {
            t();
        }
    }

    public void a(View view) {
        VideoAdDetails A;
        List<VerificationDetails> a2;
        t9 t9Var;
        if (MetaData.k.V() && (A = A()) != null && (a2 = A.a()) != null) {
            b6 b6Var = new b6(this.w.getContext(), a2, true);
            this.G = b6Var;
            if (b6Var.c()) {
                try {
                    AdInformationView adInformationView = this.c.b;
                    if (adInformationView != null) {
                        this.G.a(adInformationView, FriendlyObstructionPurpose.OTHER, (String) null);
                    }
                    if (view != null) {
                        this.G.a(view, FriendlyObstructionPurpose.CLOSE_AD, (String) null);
                    }
                    this.G.a(this.w, FriendlyObstructionPurpose.VIDEO_CONTROLS, (String) null);
                    this.G.a(this.N, FriendlyObstructionPurpose.OTHER, (String) null);
                } catch (RuntimeException unused) {
                }
                this.G.a(this.L);
                this.G.e();
                b6 b6Var2 = this.G;
                boolean I = I();
                long z = H() ? z() : 0;
                if (b6Var2.b != null && b6Var2.e.compareAndSet(false, true)) {
                    if (I) {
                        t9Var = new t9(true, Float.valueOf((float) z), true, Position.STANDALONE);
                    } else {
                        t9Var = new t9(false, (Float) null, true, Position.STANDALONE);
                    }
                    l lVar = b6Var2.b;
                    lVar.getClass();
                    gc.a(lVar.a);
                    gc.c(lVar.a);
                    fb fbVar = lVar.a;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("skippable", t9Var.a);
                        if (t9Var.a) {
                            jSONObject.put("skipOffset", t9Var.b);
                        }
                        jSONObject.put("autoPlay", t9Var.c);
                        jSONObject.put("position", t9Var.d);
                    } catch (JSONException e) {
                        Log.e("OMIDLIB", "VastProperties: JSON error", e);
                    }
                    if (!fbVar.j) {
                        fc.a.a(fbVar.e.c(), "publishLoadedEvent", jSONObject);
                        fbVar.j = true;
                        return;
                    }
                    throw new IllegalStateException("Loaded event can only be sent once");
                }
            }
        }
    }

    public void a(VideoPlayerInterface.f fVar) {
        VASTErrorCodes vASTErrorCodes;
        i3 i3Var = new i3(j3.e);
        StringBuilder a2 = p0.a("Video player error: ");
        a2.append(fVar.a);
        i3Var.d = a2.toString();
        i3Var.e = fVar.b;
        i3Var.g = a();
        i3Var.a();
        int ordinal = fVar.a.ordinal();
        boolean z = true;
        if (ordinal == 1) {
            vASTErrorCodes = VASTErrorCodes.GeneralLinearError;
        } else if (ordinal == 2) {
            vASTErrorCodes = VASTErrorCodes.TimeoutMediaFileURI;
        } else if (ordinal != 3) {
            vASTErrorCodes = VASTErrorCodes.UndefinedError;
        } else {
            vASTErrorCodes = VASTErrorCodes.MediaFileDisplayError;
        }
        ga gaVar = new ga(A().i().e(), new VideoTrackingParams(this.p, b(this.e0), this.D, this.g0), A().j(), this.e0);
        gaVar.f = vASTErrorCodes;
        gaVar.e = "error";
        VideoUtil.a((Context) this.b, gaVar.a());
        if (x() == 0) {
            com.startapp.sdk.adsbase.a.a((Context) this.b, this.i, this.p, this.D, "VIDEO_ERROR", (JSONObject) null);
            if (!this.X) {
                VideoUtil.b(this.b);
            } else if (!fVar.a.equals(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT)) {
                VideoUtil.b(this.b);
            }
        }
        if (this.l.getType() != Ad.AdType.REWARDED_VIDEO) {
            z = false;
        }
        if ((!z || this.C) && A().k()) {
            a(VideoFinishedReason.SKIPPED);
            return;
        }
        w();
        b();
    }

    public boolean a(String str, boolean z) {
        String str2;
        ActionTrackingLink[] actionTrackingLinkArr;
        if (this.d0) {
            str2 = A().d();
        } else {
            str2 = A().b();
        }
        if (!TextUtils.isEmpty(str2)) {
            z = true;
            str = str2;
        }
        if (!this.d0) {
            a(VideoFinishedReason.CLICKED);
        }
        boolean z2 = this.d0;
        if (z2) {
            actionTrackingLinkArr = A().i().k();
        } else {
            actionTrackingLinkArr = A().i().h();
        }
        a(actionTrackingLinkArr, new VideoClickedTrackingParams(this.p, b(this.e0), this.D, z2, this.g0), this.e0, "clicked");
        b6 b6Var = this.G;
        if (b6Var != null) {
            InteractionType interactionType = InteractionType.CLICK;
            a5 a5Var = b6Var.c;
            if (a5Var != null) {
                gc.a(a5Var.a);
                JSONObject jSONObject = new JSONObject();
                rb.a(jSONObject, "interactionType", interactionType);
                fc.a.a(a5Var.a.e.c(), "adUserInteraction", jSONObject);
            }
        }
        return super.a(str, z);
    }

    public void a(boolean z) {
        ActionTrackingLink[] actionTrackingLinkArr;
        if (this.K != null) {
            if (z) {
                actionTrackingLinkArr = A().i().f();
            } else {
                actionTrackingLinkArr = A().i().g();
            }
            a(actionTrackingLinkArr, new VideoTrackingParams(this.p, b(((NativeVideoPlayer) this.K).h.getCurrentPosition()), this.D, this.g0), ((NativeVideoPlayer) this.K).h.getCurrentPosition(), "sound");
            b6 b6Var = this.G;
            if (b6Var != null) {
                float f = z ? 0.0f : 1.0f;
                a5 a5Var = b6Var.c;
                if (a5Var != null) {
                    a5Var.a(f);
                    gc.a(a5Var.a);
                    JSONObject jSONObject = new JSONObject();
                    rb.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
                    rb.a(jSONObject, "deviceVolume", Float.valueOf(lc.a().a));
                    fc.a.a(a5Var.a.e.c(), "volumeChange", jSONObject);
                }
            }
        }
    }

    public final void a(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, int i, String str) {
        ga gaVar = new ga(videoTrackingLinkArr, videoTrackingParams, A().j(), i);
        gaVar.e = str;
        VideoUtil.a((Context) this.b, gaVar.a());
    }
}
