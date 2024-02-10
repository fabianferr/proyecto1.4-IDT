package com.bytedance.sdk.openadsdk.core.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.a.d;
import com.bytedance.sdk.openadsdk.core.widget.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LandingPageModel */
public class o {
    private View A;
    /* access modifiers changed from: private */
    public long B;
    /* access modifiers changed from: private */
    public final AtomicBoolean C = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final Activity D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public c F;
    /* access modifiers changed from: private */
    public j G;
    private boolean H;
    private final AtomicBoolean I = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean J;
    /* access modifiers changed from: private */
    public e K;
    /* access modifiers changed from: private */
    public String L;
    /* access modifiers changed from: private */
    public ILoader M;
    /* access modifiers changed from: private */
    public volatile int N = 0;
    /* access modifiers changed from: private */
    public volatile int O = 0;
    /* access modifiers changed from: private */
    public volatile int P = 0;
    /* access modifiers changed from: private */
    public int Q;
    private int R;
    ImageView a;
    FrameLayout b;
    TextView c;
    FrameLayout d;
    TextView e;
    RelativeLayout f;
    final q g;
    FrameLayout h;
    ObjectAnimator i;
    ValueAnimator j;
    ObjectAnimator k;
    ObjectAnimator l;
    c.a m;
    a n;
    b o;
    private View p;
    private TextView q;
    private TextView r;
    private TTRoundRectImageView s;
    private TextView t;
    private x u;
    /* access modifiers changed from: private */
    public SSWebView v;
    /* access modifiers changed from: private */
    public FrameLayout w;
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout x;
    /* access modifiers changed from: private */
    public View y;
    private ImageView z;

    static /* synthetic */ int n(o oVar) {
        int i2 = oVar.N;
        oVar.N = i2 + 1;
        return i2;
    }

    static /* synthetic */ int p(o oVar) {
        int i2 = oVar.O;
        oVar.O = i2 + 1;
        return i2;
    }

    static /* synthetic */ int q(o oVar) {
        int i2 = oVar.P;
        oVar.P = i2 + 1;
        return i2;
    }

    public o(Activity activity, q qVar, String str, FrameLayout frameLayout) {
        Activity activity2 = activity;
        q qVar2 = qVar;
        this.D = activity2;
        this.g = qVar2;
        this.E = str;
        if (qVar2 != null) {
            this.L = qVar.af();
        }
        if (!TextUtils.isEmpty(this.L)) {
            this.M = com.bytedance.sdk.openadsdk.d.b.a().b();
            int a2 = com.bytedance.sdk.openadsdk.d.b.a().a(this.M, this.L);
            this.Q = a2;
            this.R = a2 > 0 ? 2 : 0;
        }
        boolean c2 = c(qVar);
        if (b(qVar)) {
            this.E = "landingpage_split_screen";
        } else if (c2) {
            this.E = "landingpage_direct";
        }
        this.n = new a(com.bytedance.sdk.openadsdk.core.o.a(), qVar2, this.E, ac.a(str));
        View findViewById = activity2.findViewById(16908290);
        this.n.a(findViewById);
        final q qVar3 = qVar;
        AnonymousClass1 r1 = new b(com.bytedance.sdk.openadsdk.core.o.a(), qVar, this.E, ac.a(str), true) {
            public boolean a(i iVar, Map<String, Object> map) {
                if (o.f(qVar3) && o.this.K != null) {
                    o.this.K.a(iVar);
                    o.this.K.a(map);
                    if (o.e(o.this.g) || o.this.J) {
                        return true;
                    }
                }
                return super.a(iVar, map);
            }
        };
        this.o = r1;
        r1.a(findViewById);
        this.h = frameLayout;
        if (c2) {
            try {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (int) (qVar.i().b() * 1000)});
                this.j = ofInt;
                ofInt.setDuration((long) ((((float) qVar.i().b()) / l.d) * 1000.0f));
                this.j.setInterpolator(new LinearInterpolator());
                this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (o.this.m != null) {
                            o.this.m.a(((Integer) valueAnimator.getAnimatedValue()).longValue(), o.this.g.i().b() * 1000);
                        }
                    }
                });
                this.j.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (o.this.m != null) {
                            o.this.m.a(o.this.g.i().b() * 1000, 100);
                        }
                    }
                });
                this.j.start();
            } catch (Exception e2) {
                Log.e("LandingPageModel", "LandingPageModel: ", e2);
            }
        }
    }

    public void a(c.a aVar) {
        this.m = aVar;
    }

    public void a() {
        View view;
        Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
        SSWebView sSWebView = (SSWebView) this.D.findViewById(i.t);
        this.v = sSWebView;
        if (sSWebView == null || q.a(this.g)) {
            ad.a((View) this.v, 8);
        } else {
            this.v.c_();
        }
        this.w = (FrameLayout) this.D.findViewById(i.s);
        this.x = (LandingPageLoadingLayout) this.D.findViewById(i.x);
        this.y = this.D.findViewById(i.u);
        this.z = (ImageView) this.D.findViewById(i.v);
        this.A = this.D.findViewById(i.E);
        this.b = (FrameLayout) this.D.findViewById(i.q);
        this.a = (ImageView) this.D.findViewById(i.r);
        this.f = (RelativeLayout) this.D.findViewById(i.w);
        this.c = (TextView) this.D.findViewById(i.bt);
        this.d = (FrameLayout) this.D.findViewById(i.j);
        View findViewById = this.D.findViewById(i.y);
        this.p = findViewById;
        if (findViewById == null) {
            this.p = this.D.findViewById(i.G);
        }
        this.q = (TextView) this.D.findViewById(i.A);
        this.r = (TextView) this.D.findViewById(i.B);
        this.s = (TTRoundRectImageView) this.D.findViewById(i.z);
        this.t = (TextView) this.D.findViewById(i.C);
        if (!(this.c == null || this.g.i() == null)) {
            this.c.setText(this.g.i().c());
        }
        this.e = (TextView) this.D.findViewById(i.D);
        if ((c(this.g) || b(this.g)) && this.g.i() != null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            l.c().postDelayed(new Runnable() {
                public void run() {
                    if (!o.this.C.get()) {
                        com.bytedance.sdk.openadsdk.b.c.a(o.this.g, o.this.E, System.currentTimeMillis() - o.this.B, false);
                        o.this.m();
                    }
                }
            }, this.g.i().a() * 1000);
        }
        i();
        if (b(this.g)) {
            o();
            if (!c()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.w.setLayoutParams(layoutParams);
            }
        }
        if (c(this.g) && (view = this.A) != null) {
            view.setVisibility(8);
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.x;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.g, this.E);
        }
        c.a.a(SystemClock.elapsedRealtime() - valueOf.longValue(), this.g, this.E, this.M, this.L);
    }

    private void i() {
        LandingPageLoadingLayout landingPageLoadingLayout;
        SSWebView sSWebView = this.v;
        if (!(sSWebView == null || sSWebView.getWebView() == null)) {
            com.bytedance.sdk.openadsdk.core.widget.a.c.a(com.bytedance.sdk.openadsdk.core.o.a()).a(false).b(false).a(this.v.getWebView());
            SSWebView sSWebView2 = this.v;
            if (!(sSWebView2 == null || sSWebView2.getWebView() == null)) {
                j a2 = new j(this.g, this.v.getWebView(), new com.bytedance.sdk.openadsdk.b.i() {
                    public void a(int i) {
                        c.a.a(o.this.Q, o.this.P, o.this.O, o.this.N - o.this.O, o.this.g, o.this.E, i);
                    }
                }, this.R).a(true);
                this.G = a2;
                a2.a(this.E);
            }
            j();
            this.v.setLandingPage(true);
            this.v.setTag(this.E);
            this.v.setMaterialMeta(this.g.aJ());
            AnonymousClass12 r4 = new e(com.bytedance.sdk.openadsdk.core.o.a(), this.u, this.g.Y(), this.G, true) {
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    o.this.k();
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (o.this.D instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) o.this.D).b();
                    }
                    long unused = o.this.B = System.currentTimeMillis();
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    String d = d(str2);
                    boolean z = true;
                    if (this.f != null) {
                        this.f.a(webView, i, str, str2, d(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
                    }
                    boolean z2 = d != null && d.startsWith("image");
                    if (d == null || !d.startsWith("mp4")) {
                        z = false;
                    }
                    if (!z2 && !z && !o.this.C.get()) {
                        o.this.m();
                    }
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        o.this.m();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(o.this.L)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        o.n(o.this);
                        WebResourceResponseModel a2 = com.bytedance.sdk.openadsdk.d.b.a().a(o.this.M, o.this.L, str);
                        if (a2 == null || a2.getWebResourceResponse() == null) {
                            if (a2 != null && a2.getMsg() == 2) {
                                o.q(o.this);
                            }
                            return super.shouldInterceptRequest(webView, str);
                        }
                        o.p(o.this);
                        com.bytedance.sdk.component.utils.l.b("LandingPageModel", "GeckoLog: hit++");
                        return a2.getWebResourceResponse();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.l.c("LandingPageModel", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            this.K = r4;
            this.v.setWebViewClient(r4);
            this.K.a(this.g);
            this.K.a(this.E);
            this.v.setWebChromeClient(new d(this.u, this.G) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (o.this.D != null && !o.this.D.isFinishing() && i == 100) {
                        o.this.k();
                    }
                    if (o.this.x != null) {
                        o.this.x.a(i);
                    }
                }
            });
            if (this.F == null) {
                this.F = com.com.bytedance.overseas.sdk.a.d.a(com.bytedance.sdk.openadsdk.core.o.a(), this.g, this.E);
            }
            this.v.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (o.this.F != null) {
                        o.this.F.d();
                    }
                }
            });
            SSWebView sSWebView3 = this.v;
            sSWebView3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView3.getWebView(), (int) BuildConfig.VERSION_CODE));
            if (Build.VERSION.SDK_INT >= 21) {
                this.v.setMixedContentMode(0);
            }
            this.v.getWebView().setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!o.this.J || o.f(o.this.g)) {
                        o.this.o.onTouch(view, motionEvent);
                    }
                    if ((!o.this.J || o.f(o.this.g)) && motionEvent.getAction() == 1 && o.this.o.g()) {
                        o.this.v.getWebView().performClick();
                        boolean unused = o.this.J = true;
                    }
                    if (o.this.G == null) {
                        return false;
                    }
                    o.this.G.a(motionEvent.getActionMasked());
                    return false;
                }
            });
            this.v.getWebView().setOnClickListener(this.o);
            com.bytedance.sdk.openadsdk.b.c.a(this.g, this.E, this.R);
            com.bytedance.sdk.openadsdk.utils.o.a(this.v, this.g.P());
            this.H = true;
        }
        if (this.v != null && (landingPageLoadingLayout = this.x) != null) {
            landingPageLoadingLayout.a();
        }
    }

    private void j() {
        x xVar = new x(this.D);
        this.u = xVar;
        xVar.b(this.v).d(this.g.Y()).e(this.g.ac()).a(this.g).b(-1).a(this.g.H()).c(this.E).f(this.g.bb()).a(this.v).a((com.bytedance.sdk.openadsdk.core.widget.b) new com.bytedance.sdk.openadsdk.core.widget.b() {
            public void a() {
                if (o.this.K != null) {
                    o.this.K.a();
                }
            }
        });
    }

    public static boolean a(q qVar) {
        if (qVar == null || g(qVar)) {
            return false;
        }
        if (c(qVar) || b(qVar)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void k() {
        if (!this.C.get() && !this.I.get()) {
            this.C.set(true);
            com.bytedance.sdk.openadsdk.b.c.a(this.g, this.E, System.currentTimeMillis() - this.B, true);
            l();
        }
    }

    private void l() {
        this.f.setVisibility(8);
        if (!c(this.g) && c()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "timeVisible", new float[]{0.0f, 1.0f});
            this.l = ofFloat;
            ofFloat.setDuration(100);
            this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o.this.w.getLayoutParams();
                    double floatValue = (double) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    Double.isNaN(floatValue);
                    layoutParams.weight = (float) (floatValue * 0.25d);
                    o oVar = o.this;
                    double floatValue2 = (double) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    Double.isNaN(floatValue2);
                    oVar.a((float) (1.0d - (floatValue2 * 0.2d)));
                    o.this.w.setLayoutParams(layoutParams);
                }
            });
            this.l.start();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (!this.C.get()) {
            n();
            this.I.set(true);
            Activity activity = this.D;
            if (activity instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                ((com.bytedance.sdk.openadsdk.core.video.c.c) activity).c();
            }
            LandingPageLoadingLayout landingPageLoadingLayout = this.x;
            if (landingPageLoadingLayout != null) {
                landingPageLoadingLayout.b();
            }
            this.p.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.addRule(10, 0);
            this.p.setLayoutParams(layoutParams);
            if (this.g.N() != null && !TextUtils.isEmpty(this.g.N().a())) {
                com.bytedance.sdk.openadsdk.k.c.a().a(this.g.N().a(), this.g.N().b(), this.g.N().c(), this.s, this.g);
            }
            this.q.setText(this.g.L());
            this.r.setText(this.g.W());
            if (this.t != null) {
                b();
                this.t.setClickable(true);
                this.t.setOnClickListener(this.n);
                this.t.setOnTouchListener(this.n);
            }
        }
    }

    private void n() {
        if (c(this.g)) {
            Activity activity = this.D;
            if (activity instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                ((com.bytedance.sdk.openadsdk.core.video.c.c) activity).b();
                ((com.bytedance.sdk.openadsdk.core.video.c.c) this.D).i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        q qVar = this.g;
        if (qVar != null && !TextUtils.isEmpty(qVar.X())) {
            this.t.setText(this.g.X());
        }
    }

    private void o() {
        if (c()) {
            this.y.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.z, "translationY", new float[]{16.0f, 0.0f}).setDuration(500);
            this.i = duration;
            duration.setRepeatMode(2);
            this.i.setRepeatCount(-1);
            this.i.start();
            this.y.setClickable(true);
            this.y.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!o.this.J) {
                        o.this.o.onTouch(view, motionEvent);
                    }
                    if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    o.this.k = ObjectAnimator.ofFloat(this, "timeSlide", new float[]{0.0f, 1.0f});
                    o.this.k.setDuration(200);
                    o.this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o.this.w.getLayoutParams();
                            double floatValue = (double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f);
                            Double.isNaN(floatValue);
                            layoutParams.weight = (float) (floatValue + 0.25d);
                            o oVar = o.this;
                            double floatValue2 = (double) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            Double.isNaN(floatValue2);
                            oVar.a((float) (0.800000011920929d - (floatValue2 * 0.5d)));
                            o.this.w.setLayoutParams(layoutParams);
                        }
                    });
                    if (o.this.o.g()) {
                        o.this.y.performClick();
                        boolean unused = o.this.J = true;
                    }
                    o.this.k.start();
                    o.this.y.setVisibility(8);
                    return true;
                }
            });
            this.y.setOnClickListener(this.o);
        }
        if (!p()) {
            this.h.setVisibility(8);
            this.b.setVisibility(0);
            this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.b.c.b(o.this.g, o.this.E);
                }
            });
            q qVar = this.g;
            if (!(qVar == null || qVar.Q() == null || this.g.Q().size() <= 0 || this.g.Q().get(0) == null || TextUtils.isEmpty(this.g.Q().get(0).a()))) {
                com.bytedance.sdk.openadsdk.k.c.a().a(this.g.Q().get(0), this.a, this.g);
            }
        }
        try {
            String a2 = this.g.Q().get(0).a();
            com.bytedance.sdk.openadsdk.f.d.a().a(a2).a(this.g.Q().get(0).b()).b(this.g.Q().get(0).c()).d(ad.d(com.bytedance.sdk.openadsdk.core.o.a())).c(ad.c(com.bytedance.sdk.openadsdk.core.o.a())).a(u.BITMAP).a((h) new h() {
                public Bitmap a(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(com.bytedance.sdk.openadsdk.core.o.a(), bitmap, 25);
                }
            }).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.openadsdk.f.b(this.g, a2, new com.bytedance.sdk.component.d.o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    try {
                        Bitmap b = kVar.b();
                        if (b == null) {
                            return;
                        }
                        if (kVar.c() != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.o.a().getResources(), b);
                            if (!o.this.p()) {
                                o.this.b.setBackground(bitmapDrawable);
                                return;
                            }
                            o.this.d.setBackground(bitmapDrawable);
                            View e = o.this.D instanceof com.bytedance.sdk.openadsdk.core.video.c.c ? ((com.bytedance.sdk.openadsdk.core.video.c.c) o.this.D).e() : null;
                            if (e != null && (e.getParent() instanceof View)) {
                                View view = (View) e.getParent();
                                View view2 = view;
                                view.setBackground(bitmapDrawable);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean p() {
        return q.c(this.g);
    }

    public boolean c() {
        return this.g.ad() == 15 || this.g.ad() == 16;
    }

    public void a(float f2) {
        try {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) this.D).d();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(q qVar) {
        if (qVar == null || qVar.M() != 3 || qVar.o() != 6 || t.b(qVar) || qVar.ak() != 1) {
            return false;
        }
        if (qVar.al() == 0.0f || qVar.al() == 100.0f) {
            return true;
        }
        return false;
    }

    public static boolean c(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (g(qVar)) {
            return true;
        }
        if (qVar.M() != 3 || qVar.o() != 5 || t.b(qVar)) {
            return false;
        }
        if (qVar.al() == 0.0f || qVar.al() == 100.0f) {
            return true;
        }
        return false;
    }

    public static boolean d(q qVar) {
        return c(qVar) && !g(qVar);
    }

    public static boolean e(q qVar) {
        if (qVar == null || qVar.aP() == 1 || !f(qVar)) {
            return false;
        }
        return true;
    }

    public static boolean f(q qVar) {
        return qVar != null && (qVar.o() == 19 || qVar.o() == 20);
    }

    public static boolean g(q qVar) {
        return qVar != null && qVar.o() == 19;
    }

    public static boolean h(q qVar) {
        if (qVar != null && com.bytedance.sdk.openadsdk.core.o.d().v() && qVar.G() && !b(qVar) && !c(qVar)) {
            return true;
        }
        return false;
    }

    public void d() {
        FrameLayout frameLayout = this.w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.A;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void e() {
        SSWebView sSWebView;
        j jVar = this.G;
        if (!(jVar == null || (sSWebView = this.v) == null)) {
            jVar.a(sSWebView);
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.j.removeAllListeners();
            this.j.cancel();
        }
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.k.cancel();
        }
        ObjectAnimator objectAnimator2 = this.l;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.l.cancel();
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.x;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.b();
        }
        ObjectAnimator objectAnimator3 = this.i;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        SSWebView sSWebView2 = this.v;
        if (sSWebView2 != null) {
            aa.a(sSWebView2.getWebView());
        }
        this.v = null;
        x xVar = this.u;
        if (xVar != null) {
            xVar.m();
        }
        j jVar2 = this.G;
        if (jVar2 != null) {
            jVar2.c(true);
        }
        if (!TextUtils.isEmpty(this.L) && this.H) {
            c.a.a(this.O, this.N, this.g);
        }
        com.bytedance.sdk.openadsdk.d.b.a().a(this.M);
    }

    public void f() {
        x xVar = this.u;
        if (xVar != null) {
            xVar.k();
        }
        j jVar = this.G;
        if (jVar != null) {
            jVar.g();
        }
    }

    public void g() {
        j jVar = this.G;
        if (jVar != null) {
            jVar.h();
        }
    }

    public void h() {
        x xVar = this.u;
        if (xVar != null) {
            xVar.l();
        }
    }
}
