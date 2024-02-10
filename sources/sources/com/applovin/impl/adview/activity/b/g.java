package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.adview.activity.a.d;
import com.applovin.impl.adview.m;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends a implements com.applovin.impl.adview.g {
    private AtomicBoolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public long D;
    private final d s = new d(this.a, this.e, this.b);
    /* access modifiers changed from: private */
    public final m t;
    /* access modifiers changed from: private */
    public final ImageView u;
    private final com.applovin.impl.adview.a v;
    private final boolean w;
    private double x;
    private double y;
    private AtomicBoolean z;

    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            if (view == g.this.t) {
                if (g.this.s()) {
                    g.this.p();
                    g.this.q.b();
                    return;
                }
                g.this.v();
            } else if (view == g.this.u) {
                g.this.x();
            } else if (u.a()) {
                u uVar = g.this.c;
                uVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public g(e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        boolean f = this.a.f();
        this.w = f;
        this.z = new AtomicBoolean();
        this.A = new AtomicBoolean();
        this.B = Utils.isVideoMutedInitially(this.b);
        this.C = -2;
        this.D = 0;
        a aVar = new a();
        if (eVar.r() >= 0) {
            m mVar2 = new m(eVar.x(), activity);
            this.t = mVar2;
            mVar2.setVisibility(8);
            mVar2.setOnClickListener(aVar);
        } else {
            this.t = null;
        }
        if (a(this.B, mVar)) {
            ImageView imageView = new ImageView(activity);
            this.u = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(aVar);
            d(this.B);
        } else {
            this.u = null;
        }
        if (f) {
            com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(b.cC)).intValue(), 16842874);
            this.v = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            return;
        }
        this.v = null;
    }

    private static boolean a(boolean z2, com.applovin.impl.sdk.m mVar) {
        if (!((Boolean) mVar.a(b.cr)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.a(b.cs)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) mVar.a(b.cu)).booleanValue();
    }

    private void d(boolean z2) {
        if (com.applovin.impl.sdk.utils.g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.e.getDrawable(z2 ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.u.setScaleType(ImageView.ScaleType.FIT_XY);
                this.u.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.a.aC() : this.a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.u.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.A.compareAndSet(false, true)) {
            a(this.t, this.a.r(), new Runnable() {
                public void run() {
                    long unused = g.this.C = -1;
                    long unused2 = g.this.D = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public void a() {
        if (u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(double d) {
        b("javascript:al_setVideoMuted(" + this.B + ");");
        com.applovin.impl.adview.a aVar = this.v;
        if (aVar != null) {
            aVar.b();
        }
        if (this.t != null) {
            y();
        }
        this.f.getController().m();
        this.y = d;
        u();
        if (this.a.am()) {
            this.q.a(this.a, (Runnable) null);
        }
    }

    public void a(long j) {
    }

    public void a(ViewGroup viewGroup) {
        this.s.a(this.u, this.t, this.g, this.v, this.f, viewGroup);
        this.f.getController().a((com.applovin.impl.adview.g) this);
        a(false);
        com.applovin.impl.adview.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        this.f.renderAd(this.a);
        if (this.t != null) {
            this.b.S().a(new z(this.b, new Runnable() {
                public void run() {
                    g.this.y();
                }
            }), o.a.MAIN, this.a.s(), true);
        }
        this.b.S().a((com.applovin.impl.sdk.f.a) new z(this.b, new Runnable() {
            public void run() {
                if (g.this.g != null) {
                    g.this.a.o().a((View) g.this.f, (List<com.applovin.impl.sdk.b.d>) Collections.singletonList(new com.applovin.impl.sdk.b.d(g.this.g, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
                } else {
                    g.this.a.o().a((View) g.this.f);
                }
            }
        }), o.a.MAIN, 500);
        super.b(this.B);
    }

    public void a_() {
        w();
    }

    public void b() {
        if (u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        v();
    }

    public void b(double d) {
        this.x = d;
    }

    public void b_() {
        com.applovin.impl.adview.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c() {
        com.applovin.impl.adview.a aVar = this.v;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
    }

    public void h() {
        m();
        super.h();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a((int) this.x, this.w, r(), this.C);
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.x >= ((double) this.a.Q());
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
                if (this.y > 0.0d) {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) this.y);
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

    public void v() {
        this.C = SystemClock.elapsedRealtime() - this.D;
        if (u.a()) {
            this.c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.C + "ms");
        }
        this.d.f();
        this.j++;
        if (this.a.y()) {
            h();
        } else {
            w();
        }
    }

    public void w() {
        if (this.z.compareAndSet(false, true)) {
            if (u.a()) {
                this.c.b("AppLovinFullscreenActivity", "Showing postitial...");
            }
            b("javascript:al_showPostitial();");
            m mVar = this.t;
            if (mVar != null) {
                mVar.setVisibility(8);
            }
            ImageView imageView = this.u;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            com.applovin.impl.adview.a aVar = this.v;
            if (aVar != null) {
                aVar.b();
            }
            if (this.g != null) {
                int i = (this.a.t() > 0 ? 1 : (this.a.t() == 0 ? 0 : -1));
                m mVar2 = this.g;
                if (i >= 0) {
                    a(mVar2, this.a.t(), new Runnable() {
                        public void run() {
                            g.this.i = SystemClock.elapsedRealtime();
                        }
                    });
                } else {
                    mVar2.setVisibility(0);
                }
            }
            this.f.getController().n();
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        this.B = !this.B;
        b("javascript:al_setVideoMuted(" + this.B + ");");
        d(this.B);
        a(this.B, 0);
    }
}
