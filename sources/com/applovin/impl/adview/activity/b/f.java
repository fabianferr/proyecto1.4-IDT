package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.m;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.t;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
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
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends a implements AppLovinCommunicatorSubscriber {
    protected long A;
    protected boolean B;
    private final com.applovin.impl.adview.activity.a.c C = new com.applovin.impl.adview.activity.a.c(this.a, this.e, this.b);
    /* access modifiers changed from: private */
    public MediaPlayer D;
    /* access modifiers changed from: private */
    public final b E;
    private final a F;
    private final Handler G;
    private final boolean H;
    private int I;
    private int J;
    /* access modifiers changed from: private */
    public boolean K;
    private final AtomicBoolean L;
    private final AtomicBoolean M;
    /* access modifiers changed from: private */
    public long N;
    /* access modifiers changed from: private */
    public long O;
    protected final AppLovinVideoView s;
    protected final com.applovin.impl.adview.a t;
    protected final m u;
    protected final ImageView v;
    protected final t w;
    protected final ProgressBar x;
    protected final j y;
    protected boolean z;

    private class a implements u.a {
        private a() {
        }

        public void a(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                f.this.c.b("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            f.this.a(tVar.getAndClearLastClickLocation());
        }

        public void b(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                f.this.c.b("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            f.this.h();
        }

        public void c(t tVar) {
            if (com.applovin.impl.sdk.u.a()) {
                f.this.c.b("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            f.this.c();
        }
    }

    private class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private b() {
        }

        public void onClick(View view, PointF pointF) {
            f.this.a(pointF);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (com.applovin.impl.sdk.u.a()) {
                f.this.c.b("AppLovinFullscreenActivity", "Video completed");
            }
            boolean unused = f.this.K = true;
            f.this.y();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            f fVar = f.this;
            fVar.c("Video view error (" + i + "," + i2 + ")");
            f.this.s.start();
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = f.this.c;
                uVar.b("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            }
            if (i == 701) {
                f.this.v();
                f.this.d.g();
                return false;
            } else if (i == 3) {
                f.this.y.a();
                if (f.this.u != null) {
                    f.this.A();
                }
                f.this.w();
                if (!f.this.q.c()) {
                    return false;
                }
                f.this.e();
                return false;
            } else if (i != 702) {
                return false;
            } else {
                f.this.w();
                return false;
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = f.this.D = mediaPlayer;
            mediaPlayer.setOnInfoListener(f.this.E);
            mediaPlayer.setOnErrorListener(f.this.E);
            float f = f.this.z ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            f.this.c((long) mediaPlayer.getDuration());
            f.this.u();
            if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = f.this.c;
                uVar.b("AppLovinFullscreenActivity", "MediaPlayer prepared: " + f.this.D);
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            if (view == f.this.u) {
                if (f.this.s()) {
                    f.this.e();
                    f.this.p();
                    f.this.q.b();
                    return;
                }
                f.this.c();
            } else if (view == f.this.v) {
                f.this.x();
            } else if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = f.this.c;
                uVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public f(e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        b bVar = new b();
        this.E = bVar;
        a aVar = new a();
        this.F = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.G = handler;
        j jVar = new j(handler, this.b);
        this.y = jVar;
        boolean f = this.a.f();
        this.H = f;
        this.z = Utils.isVideoMutedInitially(this.b);
        this.J = -1;
        this.L = new AtomicBoolean();
        this.M = new AtomicBoolean();
        this.N = -2;
        this.O = 0;
        if (eVar.hasVideoUrl()) {
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
            this.s = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(bVar);
            appLovinVideoView.setOnCompletionListener(bVar);
            appLovinVideoView.setOnErrorListener(bVar);
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(mVar, com.applovin.impl.sdk.d.b.aO, activity, bVar));
            c cVar = new c();
            if (eVar.r() >= 0) {
                m mVar2 = new m(eVar.x(), activity);
                this.u = mVar2;
                mVar2.setVisibility(8);
                mVar2.setOnClickListener(cVar);
            } else {
                this.u = null;
            }
            if (a(this.z, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.v = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                e(this.z);
            } else {
                this.v = null;
            }
            String C2 = eVar.C();
            if (StringUtils.isValidString(C2)) {
                u uVar = new u(mVar);
                uVar.a(new WeakReference(aVar));
                t tVar = new t(uVar, activity);
                this.w = tVar;
                tVar.a(C2);
            } else {
                this.w = null;
            }
            if (f) {
                com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(com.applovin.impl.sdk.d.b.cC)).intValue(), 16842874);
                this.t = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.t = null;
            }
            if (eVar.O()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.x = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (g.d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(eVar.P()));
                }
                jVar.a("PROGRESS_BAR", ((Long) mVar.a(com.applovin.impl.sdk.d.b.cz)).longValue(), (j.a) new j.a() {
                    public void a() {
                        if (f.this.B) {
                            f.this.x.setVisibility(8);
                            return;
                        }
                        f.this.x.setProgress((int) ((((float) f.this.s.getCurrentPosition()) / ((float) f.this.A)) * 10000.0f));
                    }

                    public boolean b() {
                        return !f.this.B;
                    }
                });
                return;
            }
            this.x = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* access modifiers changed from: private */
    public void A() {
        if (this.M.compareAndSet(false, true)) {
            a(this.u, this.a.r(), new Runnable() {
                public void run() {
                    long unused = f.this.N = -1;
                    long unused2 = f.this.O = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    private void B() {
        t tVar;
        s D2 = this.a.D();
        if (D2 != null && D2.e() && !this.B && (tVar = this.w) != null) {
            final boolean z2 = tVar.getVisibility() == 4;
            final long f = D2.f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z2) {
                        q.a((View) f.this.w, f, (Runnable) null);
                    } else {
                        q.b(f.this.w, f, (Runnable) null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        if (this.B) {
            if (com.applovin.impl.sdk.u.a()) {
                this.c.d("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
            }
        } else if (this.b.ad().a()) {
            if (com.applovin.impl.sdk.u.a()) {
                this.c.d("AppLovinFullscreenActivity", "Skip video resume - app paused");
            }
        } else if (this.J >= 0) {
            if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u uVar = this.c;
                uVar.b("AppLovinFullscreenActivity", "Resuming video at position " + this.J + "ms for MediaPlayer: " + this.D);
            }
            this.s.seekTo(this.J);
            this.s.start();
            this.y.a();
            this.J = -1;
            a((Runnable) new Runnable() {
                public void run() {
                    if (f.this.t != null) {
                        f.this.t.a();
                        f.this.a((Runnable) new Runnable() {
                            public void run() {
                                f.this.t.b();
                            }
                        }, 2000);
                    }
                }
            }, 250);
        } else if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Invalid last video position");
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

    private void d(boolean z2) {
        this.I = z();
        if (z2) {
            this.s.pause();
        } else {
            this.s.stopPlayback();
        }
    }

    private void e(boolean z2) {
        if (g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.e.getDrawable(z2 ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.v.setScaleType(ImageView.ScaleType.FIT_XY);
                this.v.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.a.aC() : this.a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.v.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public void a() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(long j) {
        a((Runnable) new Runnable() {
            public void run() {
                f.this.C();
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
        B();
    }

    public void a(ViewGroup viewGroup) {
        String str;
        this.C.a(this.v, this.u, this.w, this.t, this.x, this.s, this.f, viewGroup);
        if (g.g() && (str = this.b.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.AUDIO_FOCUS_REQUEST)) != null) {
            this.s.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        a(!this.H);
        this.s.setVideoURI(this.a.h());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.a.am()) {
            this.q.a(this.a, (Runnable) new Runnable() {
                public void run() {
                    f.this.a(250);
                }
            });
        }
        this.s.start();
        if (this.H) {
            v();
        }
        this.f.renderAd(this.a);
        this.d.b(this.H ? 1 : 0);
        if (this.u != null) {
            this.b.S().a(new z(this.b, new Runnable() {
                public void run() {
                    f.this.A();
                }
            }), o.a.MAIN, this.a.s(), true);
        }
        super.b(this.z);
    }

    public void b() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        c();
    }

    public void c() {
        this.N = SystemClock.elapsedRealtime() - this.O;
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.N + "ms");
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
        this.A = j;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        if (com.applovin.impl.sdk.u.a()) {
            com.applovin.impl.sdk.u uVar = this.c;
            uVar.e("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.a);
        }
        if (this.L.compareAndSet(false, true)) {
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
        } else if (!this.B) {
            e();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Pausing video");
        }
        this.J = this.s.getCurrentPosition();
        this.s.pause();
        this.y.c();
        if (com.applovin.impl.sdk.u.a()) {
            com.applovin.impl.sdk.u uVar = this.c;
            uVar.b("AppLovinFullscreenActivity", "Paused video at position " + this.J + "ms");
        }
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    public void h() {
        this.y.b();
        this.G.removeCallbacksAndMessages((Object) null);
        m();
        super.h();
    }

    public void k() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.c("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (this.H) {
                AppLovinCommunicator.getInstance(this.e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.s;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.s.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.D;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            Log.e("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.k();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a(z(), this.H, r(), this.N);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.eP)).booleanValue() && j == this.a.getAdIdNumber() && this.H) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.K && !this.s.isPlaying()) {
                    c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return z() >= this.a.Q();
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
            e eVar = this.a;
            if (i >= 0) {
                j = eVar.ad();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                long j3 = this.A;
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
                if (f.this.t != null) {
                    f.this.t.a();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void w() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (f.this.t != null) {
                    f.this.t.b();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void x() {
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            try {
                boolean z2 = false;
                float f = (float) (!this.z ? 0 : 1);
                mediaPlayer.setVolume(f, f);
                if (!this.z) {
                    z2 = true;
                }
                this.z = z2;
                e(z2);
                a(this.z, 0);
            } catch (Throwable unused) {
            }
        }
    }

    public void y() {
        if (com.applovin.impl.sdk.u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Showing postitial...");
        }
        d(this.a.aJ());
        this.C.a(this.g, this.f);
        a("javascript:al_onPoststitialShow(" + this.j + "," + this.k + ");", (long) this.a.S());
        if (this.g != null) {
            int i = (this.a.t() > 0 ? 1 : (this.a.t() == 0 ? 0 : -1));
            m mVar = this.g;
            if (i >= 0) {
                a(mVar, this.a.t(), new Runnable() {
                    public void run() {
                        f.this.i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public int z() {
        long currentPosition = (long) this.s.getCurrentPosition();
        if (this.K) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.A)) * 100.0f) : this.I;
    }
}
