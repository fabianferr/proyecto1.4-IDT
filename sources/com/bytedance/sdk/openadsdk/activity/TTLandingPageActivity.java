package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserDownloadButton;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewBottomBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewTitleBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserTitleBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserTitleBarForDark;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.g;
import com.bytedance.sdk.openadsdk.common.i;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.widget.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class TTLandingPageActivity extends TTBaseActivity implements d {
    private int A;
    /* access modifiers changed from: private */
    public final AtomicInteger B = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public i D;
    /* access modifiers changed from: private */
    public g E;
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout F;
    private boolean G;
    private String H = "ダウンロード";
    j a;
    TTAdDislikeDialog b;
    TTAdDislikeToast c;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public SSWebView f;
    /* access modifiers changed from: private */
    public ImageView g;
    private TextView h;
    private Context i;
    private PangleViewStub j;
    /* access modifiers changed from: private */
    public Button k;
    /* access modifiers changed from: private */
    public PAGProgressBar l;
    private String m;
    private String n;
    private x o;
    private int p;
    private String q;
    /* access modifiers changed from: private */
    public q r;
    /* access modifiers changed from: private */
    public c s;
    private String t;
    private final AtomicBoolean u = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public ILoader w;
    /* access modifiers changed from: private */
    public final AtomicInteger x = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger y = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public int z;

    public void a(boolean z2, JSONArray jSONArray) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SSWebView sSWebView;
        a(3);
        super.onCreate(bundle);
        if (!l.e()) {
            finish();
            return;
        }
        try {
            o.a(this);
        } catch (Throwable unused) {
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            setContentView(b());
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("sdk_version", 1);
            this.m = intent.getStringExtra("adid");
            this.n = intent.getStringExtra("log_extra");
            this.p = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.t = stringExtra;
            b(4);
            String stringExtra2 = intent.getStringExtra("web_title");
            this.q = intent.getStringExtra("event_tag");
            this.v = intent.getStringExtra("gecko_id");
            if (b.c()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.r = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra3));
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.l.c("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.r = s.a().b();
                s.a().f();
            }
            if (this.r == null) {
                finish();
                return;
            }
            this.C = o.d().v();
            e();
            if (!TextUtils.isEmpty(this.v)) {
                this.w = com.bytedance.sdk.openadsdk.d.b.a().b();
                int a2 = com.bytedance.sdk.openadsdk.d.b.a().a(this.w, this.v);
                this.z = a2;
                this.A = a2 > 0 ? 2 : 0;
            }
            this.i = this;
            if (this.f != null) {
                com.bytedance.sdk.openadsdk.core.widget.a.c.a((Context) this).a(false).b(false).a(this.f.getWebView());
            }
            SSWebView sSWebView2 = this.f;
            if (!(sSWebView2 == null || sSWebView2.getWebView() == null)) {
                this.a = new j(this.r, this.f.getWebView(), new com.bytedance.sdk.openadsdk.b.i() {
                    public void a(int i) {
                        c.a.a(TTLandingPageActivity.this.z, TTLandingPageActivity.this.y.get(), TTLandingPageActivity.this.B.get(), TTLandingPageActivity.this.x.get() - TTLandingPageActivity.this.B.get(), TTLandingPageActivity.this.r, "landingpage", i);
                    }
                }, this.A).a(true);
            }
            f();
            this.f.setLandingPage(true);
            this.f.setTag("landingpage");
            this.f.setMaterialMeta(this.r.aJ());
            SSWebView sSWebView3 = this.f;
            AnonymousClass11 r14 = r1;
            AnonymousClass11 r1 = new e(this.i, this.o, this.m, this.a, true) {
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTLandingPageActivity.this.l != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.l.setVisibility(8);
                        }
                    } catch (Throwable unused) {
                    }
                    if (TTLandingPageActivity.this.F != null) {
                        TTLandingPageActivity.this.F.b();
                    }
                }

                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(TTLandingPageActivity.this.v)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTLandingPageActivity.this.x.incrementAndGet();
                        WebResourceResponseModel a2 = com.bytedance.sdk.openadsdk.d.b.a().a(TTLandingPageActivity.this.w, TTLandingPageActivity.this.v, str);
                        if (a2 == null || a2.getWebResourceResponse() == null) {
                            if (a2 != null && a2.getMsg() == 2) {
                                TTLandingPageActivity.this.y.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTLandingPageActivity.this.B.incrementAndGet();
                        com.bytedance.sdk.component.utils.l.b("TTAD.LandingPageAct", "GeckoLog: hit++");
                        return a2.getWebResourceResponse();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.l.c("TTAD.LandingPageAct", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            sSWebView3.setWebViewClient(r14);
            SSWebView sSWebView4 = this.f;
            if (sSWebView4 != null) {
                sSWebView4.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView4.getWebView(), intExtra));
            }
            if (Build.VERSION.SDK_INT >= 21 && (sSWebView = this.f) != null) {
                sSWebView.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.b.c.a(this.r, "landingpage", this.A);
            com.bytedance.sdk.openadsdk.utils.o.a(this.f, stringExtra);
            this.f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.o, this.a) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (TTLandingPageActivity.this.F != null) {
                        TTLandingPageActivity.this.F.a(i);
                    }
                    if (TTLandingPageActivity.this.C) {
                        if (TTLandingPageActivity.this.D != null) {
                            TTLandingPageActivity.this.D.a(i);
                        }
                        if (TTLandingPageActivity.this.E != null && i == 100) {
                            TTLandingPageActivity.this.E.a(webView);
                        }
                    } else if (TTLandingPageActivity.this.l != null && !TTLandingPageActivity.this.isFinishing()) {
                        if (i != 100 || !TTLandingPageActivity.this.l.isShown()) {
                            TTLandingPageActivity.this.l.setProgress(i);
                        } else {
                            TTLandingPageActivity.this.l.setVisibility(8);
                        }
                    }
                }
            });
            if (this.f.getWebView() != null) {
                if (this.C) {
                    this.f.getWebView().setOnTouchListener(new View.OnTouchListener() {
                        float a = 0.0f;

                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (TTLandingPageActivity.this.a != null) {
                                TTLandingPageActivity.this.a.a(motionEvent.getActionMasked());
                            }
                            if (motionEvent.getAction() == 0) {
                                this.a = motionEvent.getY();
                            }
                            if (motionEvent.getAction() == 2) {
                                float y = motionEvent.getY();
                                float f = this.a;
                                if (y - f > 8.0f) {
                                    if (TTLandingPageActivity.this.D != null) {
                                        TTLandingPageActivity.this.D.a();
                                    }
                                    if (TTLandingPageActivity.this.E != null) {
                                        TTLandingPageActivity.this.E.a();
                                    }
                                    return false;
                                } else if (y - f < -8.0f) {
                                    if (TTLandingPageActivity.this.D != null) {
                                        TTLandingPageActivity.this.D.b();
                                    }
                                    if (TTLandingPageActivity.this.E != null) {
                                        TTLandingPageActivity.this.E.b();
                                    }
                                }
                            }
                            return false;
                        }
                    });
                } else {
                    this.f.getWebView().setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (TTLandingPageActivity.this.a == null) {
                                return false;
                            }
                            TTLandingPageActivity.this.a.a(motionEvent.getActionMasked());
                            return false;
                        }
                    });
                }
            }
            this.f.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (TTLandingPageActivity.this.s != null) {
                        TTLandingPageActivity.this.s.d();
                    }
                }
            });
            TextView textView = this.h;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = com.bytedance.sdk.component.utils.s.a(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            c();
            c.a.a(SystemClock.elapsedRealtime() - elapsedRealtime, this.r, "landingpage", this.w, this.v);
        } catch (Throwable unused2) {
            finish();
        }
    }

    private View b() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setOrientation(1);
        pAGFrameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        PangleViewStub pangleViewStub = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserTitleBar(context);
            }
        });
        pangleViewStub.setId(com.bytedance.sdk.openadsdk.utils.i.Y);
        pAGLinearLayout.addView(pangleViewStub, new LinearLayout.LayoutParams(-1, ad.b((Context) this, 44.0f)));
        PangleViewStub pangleViewStub2 = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserTitleBarForDark(context);
            }
        });
        pangleViewStub2.setId(com.bytedance.sdk.openadsdk.utils.i.Z);
        pAGLinearLayout.addView(pangleViewStub2, new LinearLayout.LayoutParams(-1, ad.b((Context) this, 44.0f)));
        PangleViewStub pangleViewStub3 = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserNewTitleBar(context);
            }
        });
        pangleViewStub3.setId(com.bytedance.sdk.openadsdk.utils.i.aa);
        pAGLinearLayout.addView(pangleViewStub3, new LinearLayout.LayoutParams(-1, ad.b((Context) this, 44.0f)));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(pAGFrameLayout2, layoutParams);
        SSWebView sSWebView = new SSWebView(this);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.i.O);
        pAGFrameLayout2.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        PangleViewStub pangleViewStub4 = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserDownloadButton(context);
            }
        });
        pangleViewStub4.setId(com.bytedance.sdk.openadsdk.utils.i.W);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        pAGFrameLayout2.addView(pangleViewStub4, layoutParams2);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(this, (AttributeSet) null, 16973855);
        pAGProgressBar.setId(com.bytedance.sdk.openadsdk.utils.i.ab);
        pAGProgressBar.setProgress(1);
        pAGProgressBar.setVisibility(8);
        pAGProgressBar.setProgressDrawable(com.bytedance.sdk.component.utils.s.c(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, ad.b((Context) this, 3.0f));
        layoutParams3.gravity = 49;
        pAGFrameLayout2.addView(pAGProgressBar, layoutParams3);
        PangleViewStub pangleViewStub5 = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserNewBottomBar(context);
            }
        });
        pangleViewStub5.setId(com.bytedance.sdk.openadsdk.utils.i.X);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ad.b((Context) this, 44.0f));
        layoutParams4.gravity = 80;
        pAGFrameLayout2.addView(pangleViewStub5, layoutParams4);
        LandingPageLoadingLayout landingPageLoadingLayout = new LandingPageLoadingLayout(this);
        landingPageLoadingLayout.setId(520093721);
        pAGFrameLayout.addView(landingPageLoadingLayout, new FrameLayout.LayoutParams(-1, -1));
        return pAGFrameLayout;
    }

    private void a(int i2) {
        if (i2 != 1 && Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
            } else {
                setRequestedOrientation(i2);
            }
        }
    }

    private void c() {
        q qVar = this.r;
        if (qVar != null && qVar.M() == 4) {
            PangleViewStub pangleViewStub = this.j;
            if (pangleViewStub != null) {
                pangleViewStub.setVisibility(0);
            }
            Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.i.am);
            this.k = button;
            if (button != null) {
                a(d());
                if (this.s == null) {
                    this.s = com.com.bytedance.overseas.sdk.a.d.a(this, this.r, TextUtils.isEmpty(this.q) ? ac.b(this.p) : this.q);
                }
                a aVar = new a(this, this.r, this.q, this.p);
                aVar.a(false);
                this.k.setOnClickListener(aVar);
                this.k.setOnTouchListener(aVar);
                aVar.c(true);
                aVar.a(this.s);
            }
        }
    }

    private String d() {
        q qVar = this.r;
        if (qVar != null && !TextUtils.isEmpty(qVar.X())) {
            this.H = this.r.X();
        }
        return this.H;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.k) != null) {
            button.post(new Runnable() {
                public void run() {
                    if (TTLandingPageActivity.this.k != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.k.setText(str);
                    }
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    private void e() {
        this.f = (SSWebView) findViewById(com.bytedance.sdk.openadsdk.utils.i.O);
        this.j = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.i.W);
        PangleViewStub pangleViewStub = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.i.Y);
        PangleViewStub pangleViewStub2 = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.i.Z);
        LandingPageLoadingLayout landingPageLoadingLayout = (LandingPageLoadingLayout) findViewById(520093721);
        this.F = landingPageLoadingLayout;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.r, this.q, true);
            this.F.a();
        }
        if (this.C) {
            ((PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.i.aa)).setVisibility(0);
            ((PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.i.X)).setVisibility(0);
            i iVar = new i(this, (RelativeLayout) findViewById(com.bytedance.sdk.openadsdk.utils.i.ac), this.r);
            this.D = iVar;
            ImageView c2 = iVar.c();
            this.g = c2;
            c2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
            this.E = new g(this, (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.i.ah), this.f, this.r, "landingpage");
            return;
        }
        int m2 = h.b().m();
        if (m2 != 0) {
            if (m2 == 1 && pangleViewStub2 != null) {
                pangleViewStub2.setVisibility(0);
            }
        } else if (pangleViewStub != null) {
            pangleViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.f == null) {
                        return;
                    }
                    if (TTLandingPageActivity.this.f.e()) {
                        TTLandingPageActivity.this.f.f();
                    } else if (TTLandingPageActivity.this.g()) {
                        TTLandingPageActivity.this.onBackPressed();
                    } else {
                        TTLandingPageActivity.this.finish();
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.g = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.h = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.i.ao);
        PAGProgressBar pAGProgressBar = (PAGProgressBar) findViewById(com.bytedance.sdk.openadsdk.utils.i.ab);
        this.l = pAGProgressBar;
        pAGProgressBar.setVisibility(0);
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.i.an);
        textView.setText(com.bytedance.sdk.component.utils.s.a(o.a(), "tt_reward_feedback"));
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTLandingPageActivity.this.a();
            }
        });
    }

    private void f() {
        x xVar = new x(this);
        this.o = xVar;
        xVar.b(this.f).d(this.m).e(this.n).a(this.r).b(this.p).a(this.r.H()).f(this.r.bb()).a(this.f).c("landingpage").a((d) this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        x xVar = this.o;
        if (xVar != null) {
            xVar.k();
        }
        j jVar = this.a;
        if (jVar != null) {
            jVar.g();
        }
        if (!this.G) {
            this.G = true;
            a(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        j jVar = this.a;
        if (jVar != null) {
            jVar.h();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        x xVar = this.o;
        if (xVar != null) {
            xVar.l();
        }
    }

    public void onBackPressed() {
        if (!g() || this.u.getAndSet(true)) {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.l.d("TTAD.LandingPageAct", "onBackPressed: ", th.getMessage());
            }
        } else {
            h();
            b(0);
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        return !TextUtils.isEmpty(this.t) && this.t.contains("__luban_sdk");
    }

    private void b(final int i2) {
        if (this.g != null && g()) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    ad.a((View) TTLandingPageActivity.this.g, i2);
                }
            });
        }
    }

    private void h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.o.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SSWebView sSWebView;
        super.onDestroy();
        j jVar = this.a;
        if (!(jVar == null || (sSWebView = this.f) == null)) {
            jVar.a(sSWebView);
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView2 = this.f;
        if (sSWebView2 != null) {
            com.bytedance.sdk.openadsdk.core.aa.a(sSWebView2.getWebView());
        }
        this.f = null;
        x xVar = this.o;
        if (xVar != null) {
            xVar.m();
        }
        j jVar2 = this.a;
        if (jVar2 != null) {
            jVar2.c(true);
        }
        if (!TextUtils.isEmpty(this.v)) {
            c.a.a(this.B.get(), this.x.get(), this.r);
        }
        com.bytedance.sdk.openadsdk.d.b.a().a(this.w);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (!isFinishing()) {
            if (this.e.get()) {
                j();
                return;
            }
            if (this.b == null) {
                i();
            }
            this.b.a();
        }
    }

    private void i() {
        try {
            if (this.b == null) {
                TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(this.i, this.r);
                this.b = tTAdDislikeDialog;
                tTAdDislikeDialog.setCallback(new TTAdDislikeDialog.a() {
                    public void c(View view) {
                    }

                    public void a(View view) {
                        TTLandingPageActivity.this.d.set(true);
                    }

                    public void b(View view) {
                        TTLandingPageActivity.this.d.set(false);
                    }

                    public void a(int i, FilterWord filterWord) {
                        if (!TTLandingPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                            TTLandingPageActivity.this.e.set(true);
                            TTLandingPageActivity.this.k();
                        }
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            frameLayout.addView(this.b);
            if (this.c == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.i);
                this.c = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeTip());
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        TTAdDislikeToast tTAdDislikeToast;
        if (!isFinishing() && (tTAdDislikeToast = this.c) != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.c.a((Activity) this, this.r);
    }
}
