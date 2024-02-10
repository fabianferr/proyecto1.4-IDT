package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bykv.vk.openvk.component.video.api.renderview.b;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.layout.TTVideoDetailLayout;
import com.bytedance.sdk.openadsdk.layout.TTVideoPlayLayoutForLiveLayout;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: NativeVideoController */
public class c extends com.bytedance.sdk.openadsdk.core.video.a.a {
    /* access modifiers changed from: private */
    public long D = 0;
    /* access modifiers changed from: private */
    public long E = 0;
    /* access modifiers changed from: private */
    public final boolean F;
    private final String G;
    private final boolean H;
    private final boolean I;
    private boolean J = true;
    /* access modifiers changed from: private */
    public WeakReference<c.d> K;
    /* access modifiers changed from: private */
    public WeakReference<a> L;
    private int M = 0;
    private int N = 0;
    /* access modifiers changed from: private */
    public g O;
    private b P;
    private final a.C0034a Q = new a.C0034a() {
        public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
        }

        public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
            c.this.b.post(new Runnable() {
                public void run() {
                    c.this.H();
                    e.a(c.this.g, 5);
                    if (c.this.A != null) {
                        c.this.A.a(9);
                    }
                }
            });
            c.this.c(4);
            if (c.this.g.au() != null && c.this.g.au().a() != null) {
                c.this.g.au().a().d(c.this.h);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
            boolean unused = c.this.w = false;
            c.this.b.removeCallbacks(c.this.S);
            c.this.b.post(new Runnable() {
                public void run() {
                    if (c.this.f != null) {
                        c.this.f.b();
                    }
                    if (c.this.n && c.this.L != null && c.this.L.get() != null) {
                        ((a) c.this.L.get()).f();
                    }
                }
            });
            c.this.E();
            e.a(c.this.g, 0);
            if (c.this.A != null) {
                c.this.A.c();
            }
            c cVar = c.this;
            cVar.a(cVar.O);
        }

        public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
            c.this.b.removeCallbacks(c.this.S);
            c.this.b.post(new Runnable() {
                public void run() {
                    if (!(c.this.K == null || c.this.K.get() == null)) {
                        ((c.d) c.this.K.get()).g_();
                    }
                    if (c.this.f != null) {
                        c.this.f.b();
                    }
                }
            });
            if (!c.this.F) {
                c cVar = c.this;
                cVar.a(cVar.O);
            }
            if (c.this.A != null) {
                c.this.A.a(c.this.h(), c.this.n());
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, final com.bykv.vk.openvk.component.video.api.c.a aVar2) {
            String D = c.this.a;
            l.e(D, "onError: " + aVar2.a() + ", " + aVar2.b() + ", " + aVar2.c());
            c.this.b.post(new Runnable() {
                public void run() {
                    int a2 = aVar2.a();
                    int b2 = aVar2.b();
                    if (!c.this.z() || b2 == -1004) {
                        if (c.this.c(a2, b2)) {
                            l.e(c.this.a, "Play video error，show result page、、、、、、、");
                            c.this.f.a(c.this.g, (WeakReference<Context>) null, false);
                            c.this.c(true);
                            c.this.d();
                        }
                        if (c.this.f != null) {
                            c.this.f.b();
                        }
                        if (c.this.z != null) {
                            c.this.z.b(c.this.E, com.bykv.vk.openvk.component.video.a.e.a.a(c.this.h, c.this.B));
                        }
                        if (c.this.K != null && c.this.K.get() != null && !c.this.z()) {
                            ((c.d) c.this.K.get()).a(a2, b2);
                        }
                    }
                }
            });
            c.this.a(aVar2);
            com.bytedance.sdk.openadsdk.core.g.a au = c.this.g.au();
            if (!(au == null || au.a() == null)) {
                au.a().a(com.bytedance.sdk.openadsdk.core.g.a.a.GENERAL_LINEAR_AD_ERROR);
            }
            e.a(c.this.g, 6);
            if (c.this.A != null) {
                c.this.A.a(14);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
            c.this.b.post(new Runnable() {
                public void run() {
                    if (c.this.f != null) {
                        c.this.f.b();
                    }
                }
            });
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
            h.a().post(new Runnable() {
                public void run() {
                    c.this.J();
                }
            });
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
            boolean unused = c.this.w = true;
            c.this.b.post(new Runnable() {
                public void run() {
                    if (c.this.f != null) {
                        c.this.f.q();
                        c.this.b.postDelayed(c.this.S, 8000);
                    }
                }
            });
            e.a(c.this.g, 2);
            if (c.this.A != null) {
                c.this.A.a(4);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            boolean unused = c.this.w = false;
            c.this.b.removeCallbacks(c.this.S);
            c.this.b.post(new Runnable() {
                public void run() {
                    c.this.f.b();
                }
            });
            e.a(c.this.g, 0);
            if (c.this.A != null) {
                c.this.A.a(5);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
            if (Math.abs(j - c.this.h) >= 50) {
                c cVar = c.this;
                cVar.a(cVar.O);
                final long j3 = j;
                final long j4 = j2;
                c.this.b.post(new Runnable() {
                    public void run() {
                        c.this.a(j3, j4);
                    }
                });
            }
        }

        public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
            com.bytedance.sdk.openadsdk.core.g.a au = c.this.g.au();
            if (!(au == null || au.a() == null)) {
                au.a().b(c.this.h);
            }
            e.a(c.this.g, 3);
            if (c.this.A != null) {
                c.this.A.a(0);
            }
        }

        public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
            com.bytedance.sdk.openadsdk.core.g.a au = c.this.g.au();
            if (!(au == null || au.a() == null)) {
                au.a().c(c.this.h);
            }
            if (c.this.A != null) {
                c.this.A.a(1);
            }
        }
    };
    private int R = 0;
    /* access modifiers changed from: private */
    public final Runnable S = new Runnable() {
        public void run() {
            if (c.this.f != null) {
                c.this.f.a(c.this.g, (WeakReference<Context>) null, false);
                c.this.f.b();
                c.this.c(true);
                l.e(c.this.a, "Show result page after error.......showAdCard");
            }
        }
    };
    private final v.a T = new v.a() {
        public void a(Context context, Intent intent, boolean z, final int i) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    c.this.f(i);
                }
            });
        }
    };
    private int U;
    private boolean V = false;

    /* compiled from: NativeVideoController */
    public interface a {
        void a(int i);

        void f();
    }

    public void g(boolean z) {
        this.J = z;
    }

    public void a(final NativeVideoTsView.a aVar) {
        if (this.n && this.f != null) {
            this.f.a((NativeVideoTsView.a) new NativeVideoTsView.a() {
                public void a(View view, int i) {
                    NativeVideoTsView.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(view, i);
                    }
                }
            });
        }
    }

    public void a(PAGNativeAd pAGNativeAd) {
        if (this.n && this.f != null) {
            this.f.a(pAGNativeAd);
        }
    }

    public void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.M = i;
            this.N = i2;
            String str = this.a;
            l.b(str, "width=" + i + "height=" + i2);
        }
    }

    public void a(b bVar) {
        this.P = bVar;
    }

    private void a(Context context) {
        ViewGroup viewGroup;
        if (this.n) {
            viewGroup = new TTVideoPlayLayoutForLiveLayout(context);
        } else {
            viewGroup = new TTVideoDetailLayout(context);
        }
        ViewGroup viewGroup2 = viewGroup;
        if (this.n) {
            this.f = new e(context, viewGroup2, true, 17, this.g, this, w());
        } else {
            this.f = new d(context, viewGroup2, true, 17, this.g, this, false);
        }
        this.f.a((com.bykv.vk.openvk.component.video.api.d.a) this);
    }

    public c(Context context, ViewGroup viewGroup, q qVar, String str, boolean z, boolean z2, boolean z3, g gVar) {
        super(context, qVar, viewGroup);
        this.U = o.c(context);
        a(z);
        this.G = str;
        try {
            this.M = viewGroup.getWidth();
            this.N = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        a(context);
        this.F = true;
        this.H = z2;
        this.I = z3;
        if (gVar != null) {
            this.O = gVar;
        }
    }

    public f a(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.g.at()) {
            return null;
        }
        if (this.A == null) {
            this.A = f.a();
        }
        this.A.a(view, this.g.au().n());
        if (list != null && list.size() > 0) {
            for (Pair next : list) {
                if (next != null) {
                    this.A.a((View) next.first, next.second == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) next.second);
                }
            }
        }
        return this.A;
    }

    public void a(c.d dVar) {
        this.K = new WeakReference<>(dVar);
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (this.e != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        } else if (TextUtils.isEmpty(cVar.m())) {
            l.e(this.a, "[video] play video stop , because no video info");
            return false;
        } else {
            b bVar = this.P;
            if (bVar != null) {
                bVar.a();
            }
            c(false);
            String str = this.a;
            l.b(str, "url is " + cVar.m());
            b(cVar);
            C();
            if (this.A != null) {
                this.A.a(false, 0.0f);
            }
            if (!p.b(this.G) || this.h <= 0) {
                this.h = cVar.g();
            }
            if (cVar.g() <= 0) {
                this.t = false;
                this.s.set(false);
            } else {
                this.h = cVar.g();
                this.i = Math.max(this.i, this.h);
            }
            if (this.f != null) {
                this.f.a();
                if (this.R == 0) {
                    this.f.g();
                }
                this.f.c(cVar.e(), cVar.f());
                this.f.c(this.x);
                this.f.a(cVar.e(), cVar.f());
            }
            if (this.e == null) {
                this.e = new d();
                this.e.a(this.Q);
            }
            s();
            this.E = 0;
            try {
                c(cVar);
                return true;
            } catch (Exception e) {
                String str2 = this.a;
                l.e(str2, "[video] invoke NativeVideoController#playVideo cause exception :" + e);
                return false;
            }
        }
    }

    private void c(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        l.b(this.a, "[video] playVideo has invoke !");
        cVar.c(0);
        this.e.a(cVar);
        this.D = System.currentTimeMillis();
        this.f.c(8);
        this.f.c(0);
        a((Runnable) new Runnable() {
            public void run() {
                if (c.this.e != null) {
                    long unused = c.this.D = System.currentTimeMillis();
                    c.this.f.d(0);
                    c.this.e.a(true, c.this.h, c.this.o);
                }
            }
        });
        if (this.n) {
            r();
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        this.R++;
        if (this.f != null) {
            this.f.b();
            if (this.z != null) {
                this.z.a(this.E, com.bykv.vk.openvk.component.video.a.e.a.a(this.h, this.B));
            }
            this.E = System.currentTimeMillis() - this.D;
            if (this.J) {
                this.f.a(this.g, (WeakReference<Context>) null, true);
            }
            if (!this.t) {
                this.t = true;
                a(this.B, this.B);
                long j = this.B;
                this.h = j;
                this.i = j;
                b(this.O);
            }
            if (!this.n && this.r) {
                e(this.f, (View) null);
            }
            this.m = true;
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.a();
        }
        if (this.f != null) {
            this.f.r();
        }
        I();
    }

    public void h(boolean z) {
        if (this.f != null) {
            this.f.a();
        }
        if (this.f != null && z) {
            this.f.r();
        }
        I();
    }

    private void I() {
        l.b(this.a, "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.l));
        if (this.e != null) {
            if (this.e.g()) {
                if (this.l) {
                    u();
                } else {
                    b(this.C);
                }
                l.b(this.a, "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.l));
            } else {
                this.e.a(false, this.h, this.o);
            }
        }
        if (this.s.get()) {
            A();
        }
    }

    public void c() {
        a(true, 3);
    }

    public void a(boolean z, int i) {
        if (this.n) {
            c(1);
        }
        if (!this.t && this.s.get()) {
            if (z) {
                o.a aVar = new o.a();
                aVar.a(e());
                aVar.c(h());
                aVar.b(f());
                aVar.c(i);
                aVar.d(g());
                com.bytedance.sdk.openadsdk.b.d.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.f, aVar, this.O);
                this.t = false;
            } else {
                B();
            }
        }
        d();
        if (this.A != null) {
            this.A.d();
        }
    }

    public void d() {
        if (this.e != null) {
            this.e.l();
            this.e = null;
        }
        if (this.J) {
            if (!"embeded_ad".equals(this.G)) {
                this.f.a(this.g, (WeakReference<Context>) null, true);
            } else {
                this.f.t();
            }
            this.b.removeCallbacksAndMessages((Object) null);
            this.k.clear();
            if (this.n) {
                F();
            }
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        int i;
        int i2;
        l.b(this.a, "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (!(K() == null || this.e == null)) {
                if (this.x != null) {
                    int d = this.e.d();
                    int e = this.e.e();
                    final int width = this.x.getWidth();
                    final int height = this.x.getHeight();
                    if (width <= 0 || height <= 0 || e <= 0 || d <= 0) {
                        l.b(this.a, " container or video exist size <= 0");
                        return;
                    }
                    if (d == e) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (d > e) {
                        double d2 = (double) width;
                        Double.isNaN(d2);
                        double d3 = (double) ((((float) d) * 1.0f) / ((float) e));
                        Double.isNaN(d3);
                        i2 = (int) ((d2 * 1.0d) / d3);
                        i = width;
                    } else {
                        double d4 = (double) height;
                        Double.isNaN(d4);
                        double d5 = (double) ((((float) e) * 1.0f) / ((float) d));
                        Double.isNaN(d5);
                        i = (int) ((d4 * 1.0d) / d5);
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    if (i <= width && i > 0) {
                        width = i;
                    }
                    this.b.post(new Runnable() {
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (c.this.K() instanceof TextureView) {
                                    ((TextureView) c.this.K()).setLayoutParams(layoutParams);
                                    l.b(c.this.a, "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                                } else if (c.this.K() instanceof SurfaceView) {
                                    ((SurfaceView) c.this.K()).setLayoutParams(layoutParams);
                                    l.b(c.this.a, "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                                }
                            } catch (Throwable unused) {
                                l.b(c.this.a, "[step-9] setLayoutParams exception");
                            }
                        }
                    });
                    return;
                }
            }
            String str = this.a;
            l.b(str, "[step-1] >>>>> mContextRef=" + this.j + ",getIRenderView() =" + K());
            String str2 = this.a;
            StringBuilder sb = new StringBuilder("[step-1] >>>>> mMediaPlayerProxy == null:");
            boolean z = true;
            sb.append(this.e == null);
            sb.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            if (this.e == null) {
                z = false;
            }
            sb.append(z);
            l.b(str2, sb.toString());
        } catch (Throwable th) {
            String str3 = this.a;
            l.b(str3, "[step-11] >>>>> changeVideoSize error !!!!! ：" + th);
        }
    }

    /* access modifiers changed from: private */
    public b K() {
        if (this.j.getResources().getConfiguration().orientation != 1 || this.f == null) {
            return null;
        }
        return this.f.m();
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.b bVar, View view) {
        if (this.e != null) {
            if (this.e.f()) {
                a();
                this.f.b(true, false);
                this.f.f();
            } else if (!this.e.g()) {
                if (this.f != null) {
                    this.f.c(this.x);
                }
                d(this.h);
                if (this.f != null) {
                    this.f.b(false, false);
                }
            } else {
                h(false);
                if (this.f != null) {
                    this.f.b(false, false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(long j, long j2) {
        this.g.c(j);
        this.h = j;
        this.B = j2;
        this.f.a(j, j2);
        this.f.a(com.bykv.vk.openvk.component.video.a.e.a.a(j, j2));
        try {
            if (this.z != null) {
                this.z.a(j, j2);
            }
        } catch (Throwable th) {
            l.c(this.a, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.g.a au = this.g.au();
        if (au != null && au.a() != null) {
            au.a().a(j, j2, this.A);
        }
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.b bVar, View view, boolean z) {
        f(!this.r);
        if (!(this.j instanceof Activity)) {
            l.b(this.a, "context is not activity, not support this function.");
            return;
        }
        if (this.f != null) {
            this.f.b(this.x);
            this.f.c(false);
        }
        a(1);
        c.b bVar2 = this.y != null ? (c.b) this.y.get() : null;
        if (bVar2 != null) {
            bVar2.a(this.r);
        }
    }

    private boolean b(int i, int i2) {
        if (i2 == 0) {
            a();
            this.p = true;
            if (this.f != null) {
                this.f.a(this.g, (WeakReference<Context>) null, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            if (this.f != null) {
                this.f.a();
            }
            a();
            this.p = true;
            this.q = false;
            if (this.f != null) {
                return this.f.a(i, this.g.K(), this.I);
            }
        } else if (i2 == 4) {
            this.p = false;
            if (this.f != null) {
                this.f.o();
            }
        }
        return true;
    }

    private void e(int i) {
        if (this.U != i) {
            this.U = i;
            if (!(i == 4 || i == 0)) {
                this.q = false;
            }
            if (!this.q && !o() && this.H) {
                b(2, i);
            }
            WeakReference<a> weakReference = this.L;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.L.get()).a(this.U);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(int i) {
        e(i);
        if (i == 4) {
            this.p = false;
        }
    }

    public void d(int i) {
        e(i);
        if (i == 4) {
            this.p = false;
            b();
        }
    }

    public void r() {
        if (!this.V && this.u) {
            Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
            this.V = true;
            v.a(this.T, applicationContext);
        }
    }

    public void F() {
        if (this.V && this.u) {
            this.V = false;
            v.a(this.T);
        }
    }

    public void a(a aVar) {
        this.L = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: private */
    public boolean c(int i, int i2) {
        String str = this.a;
        l.b(str, "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public void G() {
        if (this.A != null) {
            this.A.a(13);
        }
    }
}
