package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderSurfaceView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.renderview.a;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.com.bytedance.overseas.sdk.a.c;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: NativeVideoLayout */
public class e implements b<q>, a, x.a, a.C0061a, d.a, e.b {
    boolean A;
    c B;
    com.bykv.vk.openvk.component.video.api.d.c C;
    com.bytedance.sdk.openadsdk.core.b.a D;
    com.bytedance.sdk.openadsdk.core.b.a E;
    boolean F;
    /* access modifiers changed from: private */
    public NativeVideoTsView.a G;
    private long H;
    private final String I;
    ViewGroup a;
    com.bykv.vk.openvk.component.video.api.renderview.b b;
    ImageView c;
    View d;
    View e;
    ImageView f;
    View g;
    View h;
    ImageView i;
    View j;
    CornerIV k;
    TextView l;
    TextView m;
    TextView n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    int u;
    int v;
    q w;
    Context x;
    com.bytedance.sdk.openadsdk.core.widget.e y;
    a z;

    public void a(long j2) {
    }

    public void a(long j2, long j3) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z2) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void b(SurfaceTexture surfaceTexture) {
    }

    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(boolean z2) {
    }

    public boolean b(int i2) {
        return false;
    }

    public void c(boolean z2) {
    }

    public void e() {
    }

    public void f() {
    }

    public boolean j() {
        return false;
    }

    public e(Context context, ViewGroup viewGroup, boolean z2, int i2, q qVar, com.bykv.vk.openvk.component.video.api.d.c cVar, boolean z3) {
        this.s = true;
        this.A = true;
        this.F = true;
        this.I = Build.MODEL;
        if (!(this instanceof d)) {
            this.x = o.a().getApplicationContext();
            d(z3);
            this.a = viewGroup;
            this.s = z2;
            this.v = i2;
            this.C = cVar;
            this.w = qVar;
            d(8);
            a(context, (View) this.a);
            d();
            l();
        }
    }

    public e(Context context, ViewGroup viewGroup, boolean z2, int i2, q qVar, com.bykv.vk.openvk.component.video.api.d.c cVar) {
        this(context, viewGroup, z2, i2, qVar, cVar, true);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        int i2;
        String str;
        com.bytedance.sdk.openadsdk.core.b.a aVar;
        String str2 = this.A ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.w.aW()) {
            str = "rewarded_video";
            i2 = 7;
        } else if (this.w.aX()) {
            str = "fullscreen_interstitial_ad";
            i2 = 5;
        } else if (this.w.aY()) {
            str = "banner_ad";
            i2 = 2;
        } else {
            str = str2;
            i2 = 1;
        }
        if (this.w.M() == 4) {
            this.B = com.com.bytedance.overseas.sdk.a.d.a(this.x, this.w, str);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this.x, this.w, str, i2);
        this.D = aVar2;
        aVar2.a((a.C0061a) this);
        this.D.b(true);
        if (this.A) {
            this.D.a(true);
        } else {
            this.D.a(false);
            this.D.c(true);
        }
        this.D.a(this.C);
        this.D.d(true);
        this.D.a((b.a) new b.a() {
            public void a(View view, int i) {
                if (e.this.G != null) {
                    e.this.G.a(view, i);
                }
            }
        });
        c cVar = this.B;
        if (!(cVar == null || (aVar = this.D) == null)) {
            aVar.a(cVar);
        }
        if (y()) {
            AnonymousClass2 r3 = new com.bytedance.sdk.openadsdk.core.b.a(this.x, this.w, str, i2) {
                public boolean b() {
                    boolean a2 = e.this.y != null ? e.this.y.a() : false;
                    StringBuilder sb = new StringBuilder("isVisible=");
                    sb.append(a2);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(e.this.c.getVisibility() == 0);
                    l.c("ClickCreativeListener", sb.toString());
                    if (a2 || e.this.c.getVisibility() == 0) {
                        return true;
                    }
                    return false;
                }

                public boolean c() {
                    return (e.this.h != null && e.this.h.getVisibility() == 0) || (e.this.j != null && e.this.j.getVisibility() == 0) || ((e.this.k != null && e.this.k.getVisibility() == 0) || (e.this.l != null && e.this.l.getVisibility() == 0));
                }
            };
            this.E = r3;
            r3.a((b.a) new b.a() {
                public void a(View view, int i) {
                    if (e.this.G != null) {
                        e.this.G.a(view, i);
                    }
                }
            });
            this.E.b(true);
            this.E.a(this.A);
            this.E.a(this.C);
            this.E.d(true);
            c cVar2 = this.B;
            if (cVar2 != null) {
                this.E.a(cVar2);
            }
            this.E.a((a.C0061a) this);
        }
    }

    private boolean y() {
        return q.c(this.w) && this.w.I() == null && this.w.w() == 1;
    }

    public void a(NativeVideoTsView.a aVar) {
        this.G = aVar;
    }

    public void a(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.D;
        if (aVar != null) {
            aVar.a(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.a(pAGNativeAd);
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b m() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, View view) {
        View view2;
        long currentTimeMillis = System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.C;
        if (cVar == null || !cVar.q()) {
            view2 = new SSRenderSurfaceView(this.x);
            l.b("NewLiveViewLayout", "use SurfaceView......");
        } else {
            view2 = new SSRenderTextureView(this.x);
            l.b("NewLiveViewLayout", "use TextureView......");
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(view2, 0, layoutParams);
        }
        ad.a(view2, 8);
        this.b = (com.bykv.vk.openvk.component.video.api.renderview.b) view2;
        this.c = (ImageView) view.findViewById(i.aJ);
        this.d = view.findViewById(i.aG);
        this.e = view.findViewById(i.aI);
        this.f = (ImageView) view.findViewById(i.aH);
        this.g = view.findViewById(i.aD);
        l.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: package-private */
    public void a(View view, Context context) {
        View view2;
        if (view != null && context != null && (view2 = this.g) != null && view2.getParent() != null && this.h == null) {
            this.h = this.g;
            this.i = (ImageView) view.findViewById(i.aF);
            this.j = view.findViewById(i.aE);
            this.k = (CornerIV) view.findViewById(i.K);
            this.l = (TextView) view.findViewById(i.L);
            this.m = (TextView) view.findViewById(i.M);
            this.n = (TextView) view.findViewById(i.N);
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (this.z != null && this.y == null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.widget.e eVar = new com.bytedance.sdk.openadsdk.core.widget.e();
            this.y = eVar;
            eVar.a(this.x, this.a);
            this.y.a(this.z, (e.b) this);
            l.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean a(int i2, com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z2) {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.y;
        return eVar == null || eVar.a(i2, bVar, z2);
    }

    public void o() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.y;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.a aVar) {
        if (aVar instanceof a) {
            this.z = (a) aVar;
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        if (this.z != null) {
            return true;
        }
        l.e("NewLiveViewLayout", "callback is null");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.b.a(this);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!e.this.p()) {
                    return;
                }
                if (e.this.n == null || e.this.n.getVisibility() != 0) {
                    e.this.z.a((com.bykv.vk.openvk.component.video.api.d.b) e.this, view);
                }
            }
        });
    }

    public void c(int i2) {
        ad.a((View) this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void d(boolean z2) {
        this.A = z2;
        if (z2) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = this.D;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.E;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar3 = this.D;
        if (aVar3 != null) {
            aVar3.a(false);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar4 = this.E;
        if (aVar4 != null) {
            aVar4.a(false);
        }
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = ad.c(this.x);
        }
        if (i2 > 0) {
            this.o = i2;
            if (u() || j() || (this.v & 8) == 8) {
                this.p = i3;
            } else {
                this.p = e(i2);
            }
            b(this.o, this.p);
        }
    }

    public void b(boolean z2, boolean z3) {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageResource(s.d(this.x, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(s.d(this.x, "tt_stop_movebar_textpage"));
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.a.setLayoutParams(layoutParams);
    }

    private int e(int i2) {
        if (this.q <= 0 || this.r <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.x.getResources().getDimensionPixelSize(s.g(this.x, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.x.getResources().getDimensionPixelSize(s.g(this.x, "tt_video_container_minheight"));
        int i3 = (int) (((float) this.r) * ((((float) i2) * 1.0f) / ((float) this.q)));
        if (i3 > dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    public void c(int i2, int i3) {
        this.q = i2;
        this.r = i3;
    }

    public void a(int i2) {
        l.c("Progress", "setSeekProgress-percent=" + i2);
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.a.getParent() == null) {
                viewGroup.addView(this.a);
            }
            d(0);
        }
    }

    public View c() {
        return this.a;
    }

    public void g() {
        q qVar;
        ad.f(this.d);
        ad.f(this.e);
        if (!(this.f == null || (qVar = this.w) == null || qVar.K() == null || this.w.K().j() == null)) {
            ad.f((View) this.f);
            com.bytedance.sdk.openadsdk.k.c.a().a(this.w.K().j(), this.w.K().c(), this.w.K().b(), this.f, this.w);
        }
        if (this.c.getVisibility() == 0) {
            ad.a((View) this.c, 8);
        }
    }

    public void q() {
        ad.f(this.d);
        ad.f(this.e);
        if (this.c.getVisibility() == 0) {
            ad.a((View) this.c, 8);
        }
    }

    public void a() {
        a(false, this.s);
        s();
    }

    public void r() {
        ad.a((View) this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.b;
        if (bVar != null) {
            ad.a(bVar.getView(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        try {
            ad.a(this.h, 8);
            ad.a((View) this.i, 8);
            ad.a(this.j, 8);
            ad.a((View) this.k, 8);
            ad.a((View) this.l, 8);
            ad.a((View) this.m, 8);
            ad.a((View) this.n, 8);
        } catch (Exception unused) {
        }
    }

    public void t() {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setImageBitmap((Bitmap) null);
        }
        CornerIV cornerIV = this.k;
        if (cornerIV != null) {
            cornerIV.setImageBitmap((Bitmap) null);
        }
    }

    private void f(int i2) {
        ad.a(this.j, i2);
    }

    public void a(boolean z2) {
        this.F = z2;
    }

    public void a(final q qVar, WeakReference<Context> weakReference, boolean z2) {
        String str;
        q qVar2;
        q qVar3;
        if (qVar != null) {
            a(false, this.s);
            a((View) this.a, o.a());
            View view = this.h;
            if (view != null) {
                ad.a(view, 0);
            }
            ImageView imageView = this.i;
            if (imageView != null) {
                ad.a((View) imageView, 0);
            }
            ad.a(this.j, 0);
            if (!(this.i == null || (qVar3 = this.w) == null || qVar3.K() == null || this.w.K().j() == null)) {
                com.bytedance.sdk.openadsdk.k.c.a().a(this.w.K().j(), this.w.K().c(), this.w.K().b(), this.i, qVar);
            }
            if (!TextUtils.isEmpty(qVar.L())) {
                str = qVar.L();
            } else if (!TextUtils.isEmpty(qVar.V())) {
                str = qVar.V();
            } else {
                str = !TextUtils.isEmpty(qVar.W()) ? qVar.W() : "";
            }
            if (this.k != null && (qVar2 = this.w) != null && qVar2.N() != null && this.w.N().a() != null) {
                ad.a((View) this.k, 0);
                ad.a((View) this.l, 4);
                q qVar4 = this.w;
                if (qVar4 == null || !qVar4.at()) {
                    com.bytedance.sdk.openadsdk.k.c.a().a(this.w.N(), (ImageView) this.k, qVar);
                } else {
                    com.bytedance.sdk.openadsdk.f.d.a(this.w.N()).a(u.BITMAP).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.openadsdk.f.b(qVar, this.w.N().a(), new com.bytedance.sdk.component.d.o<Bitmap>() {
                        public void a(k<Bitmap> kVar) {
                            if (kVar != null && kVar.b() != null) {
                                if (e.this.k != null) {
                                    e.this.k.setImageBitmap(kVar.b());
                                }
                                com.bytedance.sdk.openadsdk.b.c.b(e.this.w, e.this.w != null ? ac.c(qVar.aS()) : null, "load_vast_icon_success", (JSONObject) null);
                            }
                        }

                        public void a(int i, String str, Throwable th) {
                            e.this.a(i, str, qVar);
                        }
                    }));
                    if (!(this.w.au() == null || this.w.au().b() == null)) {
                        this.w.au().b().b(0);
                    }
                }
                q qVar5 = this.w;
                if (qVar5 != null && qVar5.at()) {
                    try {
                        this.k.setTag(570425345, "VAST_ICON");
                    } catch (Throwable unused) {
                    }
                }
                q qVar6 = this.w;
                if (!(qVar6 == null || qVar6.au() == null || this.w.au().b() == null)) {
                    final com.bytedance.sdk.openadsdk.core.g.b b2 = this.w.au().b();
                    CornerIV cornerIV = this.k;
                    if (cornerIV != null) {
                        cornerIV.post(new Runnable() {
                            public void run() {
                                com.bytedance.sdk.openadsdk.core.g.b bVar;
                                if (e.this.k != null && e.this.k.isShown() && (bVar = b2) != null) {
                                    bVar.b(e.this.getVideoProgress());
                                }
                            }
                        });
                    }
                }
                if (y()) {
                    this.k.setOnClickListener(this.E);
                    this.k.setOnTouchListener(this.E);
                } else {
                    this.k.setOnClickListener(this.D);
                    this.k.setOnTouchListener(this.D);
                }
            } else if (!TextUtils.isEmpty(str)) {
                ad.a((View) this.k, 4);
                ad.a((View) this.l, 0);
                TextView textView = this.l;
                if (textView != null) {
                    textView.setText(str.substring(0, 1));
                    if (y()) {
                        this.l.setOnClickListener(this.E);
                        this.l.setOnTouchListener(this.E);
                    } else {
                        this.l.setOnClickListener(this.D);
                        this.l.setOnTouchListener(this.D);
                    }
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
                this.m.setTag(570425345, "VAST_TITLE");
            }
            ad.a((View) this.m, 0);
            ad.a((View) this.n, 0);
            String X = qVar.X();
            if (TextUtils.isEmpty(X)) {
                int M = qVar.M();
                if (M == 2 || M == 3) {
                    X = s.a(this.x, "tt_video_mobile_go_detail");
                } else if (M != 4) {
                    X = M != 5 ? s.a(this.x, "tt_video_mobile_go_detail") : s.a(this.x, "tt_video_dial_phone");
                } else {
                    X = s.a(this.x, "tt_video_download_apk");
                }
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setText(X);
                this.n.setOnClickListener(this.D);
                this.n.setOnTouchListener(this.D);
            }
            if (!this.F) {
                f(4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, q qVar) {
        final int i3 = i2;
        final String str2 = str;
        final q qVar2 = qVar;
        com.bytedance.sdk.openadsdk.b.c.a((h) new h("load_vast_icon_fail") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i3);
                    jSONObject.put("description", i3 + CertificateUtil.DELIMITER + str2);
                    jSONObject.put("url", e.this.w.N().a());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.b.c.b(e.this.w, e.this.w != null ? ac.c(qVar2.aS()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    public void b() {
        ad.e(this.d);
        ad.e(this.e);
        ImageView imageView = this.f;
        if (imageView != null) {
            ad.e((View) imageView);
        }
    }

    public void h() {
        ad.e(this.d);
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.t = true;
            if (p()) {
                this.z.a((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceHolder);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.b.getHolder() && p()) {
            this.z.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.t = false;
            if (p()) {
                this.z.b((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceHolder);
            }
        }
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.t = true;
        if (p()) {
            this.z.a((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceTexture);
        }
    }

    public boolean a(SurfaceTexture surfaceTexture) {
        this.t = false;
        if (!p()) {
            return true;
        }
        this.z.b((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceTexture);
        return true;
    }

    public void i() {
        d(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageDrawable((Drawable) null);
        }
        d(8);
        ad.a(this.h, 8);
        ad.a((View) this.i, 8);
        ad.a(this.j, 8);
        ad.a((View) this.k, 8);
        ad.a((View) this.l, 8);
        ad.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.y;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public boolean u() {
        return this.s;
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        ad.a((View) this.c, (!z2 || this.d.getVisibility() == 0) ? 8 : 0);
    }

    public void a(boolean z2, boolean z3) {
        ad.a((View) this.c, 8);
    }

    public void k() {
        a(true, false);
    }

    public boolean v() {
        return this.t;
    }

    public void d(int i2) {
        this.u = i2;
        ad.a((View) this.a, i2);
    }

    public boolean w() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.y;
        return eVar != null && eVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return (this.v & 4) != 4 || this.s;
    }

    public void a(Drawable drawable) {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    public long getVideoProgress() {
        if (this.H <= 0) {
            q qVar = this.w;
            if (!(qVar == null || qVar.K() == null)) {
                this.H = (long) (this.w.K().f() * 1000.0d);
            }
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.C;
            if (cVar != null) {
                this.H = cVar.h();
            }
        }
        return this.H;
    }
}
