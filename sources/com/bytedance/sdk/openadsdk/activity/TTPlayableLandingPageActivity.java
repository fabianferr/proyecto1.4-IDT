package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.adexpress.c.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.b.d;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.d.b;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.l.a;
import com.bytedance.sdk.openadsdk.l.f;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.com.bytedance.overseas.sdk.a.c;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class TTPlayableLandingPageActivity extends TTBaseActivity implements x.a, d, g {
    private static final f.a O = new f.a() {
        public void a(String str, String str2) {
            l.b(str, str2);
        }

        public void a(String str, String str2, Throwable th) {
            l.c(str, str2, th);
        }
    };
    /* access modifiers changed from: private */
    public boolean A;
    private c B;
    private final AtomicBoolean C = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public final AtomicInteger E = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger F = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger G = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public int H;
    private int I;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.l.g J;
    /* access modifiers changed from: private */
    public ILoader K;
    /* access modifiers changed from: private */
    public boolean L = false;
    /* access modifiers changed from: private */
    public e M;
    /* access modifiers changed from: private */
    public j N;
    t a;
    TTAdDislikeToast b;
    final AtomicBoolean c = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.i.d d = new com.bytedance.sdk.openadsdk.i.d() {
        public void a() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && com.bytedance.sdk.openadsdk.core.model.t.g(TTPlayableLandingPageActivity.this.x) && com.bytedance.sdk.openadsdk.core.model.t.i(TTPlayableLandingPageActivity.this.x)) {
                TTPlayableLandingPageActivity.this.y.removeMessages(2);
                TTPlayableLandingPageActivity.this.y.sendMessage(TTPlayableLandingPageActivity.this.b(1));
            }
        }

        public void b() {
            if (com.bytedance.sdk.openadsdk.core.model.t.g(TTPlayableLandingPageActivity.this.x) && com.bytedance.sdk.openadsdk.core.model.t.h(TTPlayableLandingPageActivity.this.x)) {
                TTPlayableLandingPageActivity.this.y.sendMessageDelayed(TTPlayableLandingPageActivity.this.b(0), 1000);
            }
        }

        public void a(int i) {
            if (com.bytedance.sdk.openadsdk.core.model.t.g(TTPlayableLandingPageActivity.this.x) && TTPlayableLandingPageActivity.this.o != null) {
                TTPlayableLandingPageActivity.this.o.setProgress(i);
            }
        }
    };
    private SSWebView e;
    private SSWebView f;
    /* access modifiers changed from: private */
    public boolean g = true;
    /* access modifiers changed from: private */
    public boolean h = true;
    private RelativeLayout i;
    private ShadowTextView j;
    private ShadowImageView k;
    private Context l;
    private int m;
    /* access modifiers changed from: private */
    public PAGProgressBar n;
    /* access modifiers changed from: private */
    public PlayableLoadingView o;
    private String p;
    private String q;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.x r;
    private com.bytedance.sdk.openadsdk.core.x s;
    private int t;
    /* access modifiers changed from: private */
    public String u;
    private String v;
    private final String w = "embeded_ad";
    /* access modifiers changed from: private */
    public q x;
    /* access modifiers changed from: private */
    public final x y = new x(Looper.getMainLooper(), this);
    /* access modifiers changed from: private */
    public boolean z;

    /* access modifiers changed from: private */
    public Message b(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i2;
        return obtain;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            finish();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            o.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        q qVar = this.x;
        if (qVar != null) {
            int j2 = com.bytedance.sdk.openadsdk.core.model.t.j(qVar);
            int i2 = 0;
            if (j2 == 0) {
                setRequestedOrientation(14);
            } else if (j2 == 1) {
                setRequestedOrientation(1);
            } else if (j2 == 2) {
                setRequestedOrientation(0);
            }
            this.l = this;
            try {
                setContentView(d());
                i();
                f();
                a();
                m();
                g();
                if (!TextUtils.isEmpty(this.D)) {
                    this.K = b.a().b();
                    int a2 = b.a().a(this.K, this.D);
                    this.H = a2;
                    if (a2 > 0) {
                        i2 = 2;
                    }
                    this.I = i2;
                }
                h();
                e eVar = this.M;
                if (eVar != null) {
                    eVar.g();
                }
                c.a.a(SystemClock.elapsedRealtime() - elapsedRealtime, this.x, "embeded_ad", this.K, this.D);
            } catch (Throwable unused2) {
                finish();
            }
        }
    }

    private View d() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        pAGFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e = new SSWebView(this);
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.e.setVisibility(4);
        this.n = new PAGProgressBar(this, (AttributeSet) null, 16973855);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.b((Context) this, 3.0f));
        layoutParams.gravity = 49;
        this.n.setLayoutParams(layoutParams);
        this.n.setProgress(1);
        this.n.setProgressDrawable(s.c(this, "tt_browser_progress_style"));
        this.f = new SSWebView(this);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o = new PlayableLoadingView(this);
        this.o.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o.setClickable(true);
        this.o.setFocusable(true);
        this.k = new ShadowImageView(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ad.b((Context) this, 28.0f), ad.b((Context) this, 28.0f));
        layoutParams2.leftMargin = ad.b((Context) this, 12.0f);
        layoutParams2.topMargin = ad.b((Context) this, 20.0f);
        this.k.setLayoutParams(layoutParams2);
        this.k.setScaleType(ImageView.ScaleType.CENTER);
        this.k.setImageResource(s.d(this, "tt_unmute_wrapper"));
        this.j = new ShadowTextView(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, ad.b((Context) this, 28.0f));
        layoutParams3.gravity = BadgeDrawable.TOP_END;
        layoutParams3.leftMargin = ad.b((Context) this, 16.0f);
        layoutParams3.rightMargin = ad.b((Context) this, 80.0f);
        layoutParams3.topMargin = ad.b((Context) this, 20.0f);
        this.j.setLayoutParams(layoutParams3);
        this.j.setGravity(17);
        this.j.setText(s.a(this, "tt_reward_feedback"));
        this.j.setTextColor(Color.parseColor("#ffffff"));
        this.j.setTextSize(14.0f);
        this.i = new PAGRelativeLayout(this);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(ad.b((Context) this, 28.0f), ad.b((Context) this, 28.0f));
        layoutParams4.gravity = BadgeDrawable.TOP_END;
        layoutParams4.topMargin = ad.b((Context) this, 20.0f);
        layoutParams4.rightMargin = ad.b((Context) this, 24.0f);
        this.i.setLayoutParams(layoutParams4);
        this.i.setBackground(s.c(this, "tt_mute_btn_bg"));
        this.i.setGravity(17);
        this.i.setVisibility(8);
        PAGImageView pAGImageView = new PAGImageView(this);
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(ad.b((Context) this, 12.0f), ad.b((Context) this, 12.0f)));
        pAGImageView.setImageDrawable(s.c(this, "tt_video_close_drawable"));
        pAGImageView.setVisibility(0);
        this.i.addView(pAGImageView);
        pAGFrameLayout.addView(this.e);
        pAGFrameLayout.addView(this.n);
        pAGFrameLayout.addView(this.f);
        pAGFrameLayout.addView(this.o);
        pAGFrameLayout.addView(this.k);
        pAGFrameLayout.addView(this.j);
        pAGFrameLayout.addView(this.i);
        return pAGFrameLayout;
    }

    private void e() {
        if (this.J == null) {
            if (h.b().q()) {
                f.a(O);
            }
            AnonymousClass9 r0 = new a() {
                public com.bytedance.sdk.openadsdk.l.d a() {
                    String f = com.bytedance.sdk.openadsdk.common.a.f();
                    f.hashCode();
                    char c = 65535;
                    switch (f.hashCode()) {
                        case 1653:
                            if (f.equals("2g")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1684:
                            if (f.equals("3g")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1715:
                            if (f.equals("4g")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1746:
                            if (f.equals("5g")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3649301:
                            if (f.equals("wifi")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_2G;
                        case 1:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_3G;
                        case 2:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_4G;
                        case 3:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_5G;
                        case 4:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_WIFI;
                        default:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_UNKNOWN;
                    }
                }

                public void a(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.b.c.b(TTPlayableLandingPageActivity.this.x, "embeded_ad", "playable_track", jSONObject);
                }
            };
            AnonymousClass10 r1 = new com.bytedance.sdk.openadsdk.l.c() {
                public void a(String str, JSONObject jSONObject) {
                    TTPlayableLandingPageActivity.this.r.a(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, this.p);
                jSONObject.put("log_extra", this.q);
                this.J = com.bytedance.sdk.openadsdk.l.g.a(getApplicationContext(), this.e.getWebView(), r1, r0).f(this.u).e(com.bytedance.sdk.openadsdk.common.a.a(o.a())).a(com.bytedance.sdk.openadsdk.common.a.a()).a(jSONObject).b(com.bytedance.sdk.openadsdk.common.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.common.a.c()).d(com.bytedance.sdk.openadsdk.common.a.d()).c(false).a(this.L).b(true);
            } catch (Throwable unused) {
            }
            if (this.J == null) {
                l.e("Pangle", "new PlayablePlugin Object failed, mPlayablePlugin is null");
                return;
            }
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.t.d(this.x))) {
                this.J.c(com.bytedance.sdk.openadsdk.core.model.t.d(this.x));
            }
            Set<String> j2 = this.J.j();
            final WeakReference weakReference = new WeakReference(this.J);
            for (String next : j2) {
                if (!"subscribe_app_ad".equals(next) && !"adInfo".equals(next) && !"webview_time_track".equals(next) && !"download_app_ad".equals(next)) {
                    this.r.a().a(next, (com.bytedance.sdk.component.a.e<?, ?>) new com.bytedance.sdk.component.a.e<JSONObject, JSONObject>() {
                        public JSONObject a(JSONObject jSONObject, com.bytedance.sdk.component.a.f fVar) {
                            try {
                                com.bytedance.sdk.openadsdk.l.g gVar = (com.bytedance.sdk.openadsdk.l.g) weakReference.get();
                                if (gVar == null) {
                                    return null;
                                }
                                return gVar.c(a(), jSONObject);
                            } catch (Throwable unused) {
                                return null;
                            }
                        }
                    });
                }
            }
        }
    }

    private void f() {
        if (this.x.M() == 4) {
            this.B = com.com.bytedance.overseas.sdk.a.d.a(this.l, this.x, "interaction");
        }
    }

    private void g() {
        int i2 = o.d().z(String.valueOf(this.x.aZ())).p;
        if (i2 >= 0) {
            this.y.sendEmptyMessageDelayed(1, ((long) i2) * 1000);
        } else {
            ad.a((View) this.i, 0);
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getIntExtra("sdk_version", 1);
            this.p = intent.getStringExtra("adid");
            this.q = intent.getStringExtra("log_extra");
            this.t = intent.getIntExtra("source", -1);
            this.z = intent.getBooleanExtra("ad_pending_download", false);
            this.u = intent.getStringExtra("url");
            this.D = intent.getStringExtra("gecko_id");
            this.v = intent.getStringExtra("web_title");
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.x = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        l.c("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.x = com.bytedance.sdk.openadsdk.core.s.a().b();
                com.bytedance.sdk.openadsdk.core.s.a().f();
            }
        }
        if (bundle != null) {
            try {
                this.m = bundle.getInt("sdk_version", 1);
                this.p = bundle.getString("adid");
                this.q = bundle.getString("log_extra");
                this.t = bundle.getInt("source", -1);
                this.z = bundle.getBoolean("ad_pending_download", false);
                this.u = bundle.getString("url");
                this.v = bundle.getString("web_title");
                String string = bundle.getString("material_meta", (String) null);
                if (!TextUtils.isEmpty(string)) {
                    this.x = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.x == null) {
            l.e("TTPWPActivity", "material is null, no data to display");
            finish();
            return;
        }
        try {
            this.L = o.d().p(this.x.D().getCodeId());
        } catch (Throwable th) {
            l.e("TTPWPActivity", th.getMessage());
        }
    }

    private void h() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.setLandingPage(true);
            this.e.setTag("landingpage");
            this.e.setMaterialMeta(this.x.aJ());
            j a2 = new j(this.x, this.e.getWebView(), new i() {
                public void a(int i) {
                    c.a.a(TTPlayableLandingPageActivity.this.H, TTPlayableLandingPageActivity.this.G.get(), TTPlayableLandingPageActivity.this.F.get(), TTPlayableLandingPageActivity.this.E.get() - TTPlayableLandingPageActivity.this.F.get(), TTPlayableLandingPageActivity.this.x, "embeded_ad", i);
                }
            }, this.I).a(true);
            this.N = a2;
            a2.a("embeded_ad");
            this.N.a(this.M);
            this.e.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.e(this.l, this.r, this.p, this.N, true) {
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (TTPlayableLandingPageActivity.this.J != null) {
                        TTPlayableLandingPageActivity.this.J.g(str);
                    }
                }

                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
                /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[Catch:{ all -> 0x0055 }] */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ all -> 0x0055 }] */
                /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
                    /*
                        r0 = this;
                        super.onPageFinished(r1, r2)
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        boolean r1 = r1.isFinishing()
                        if (r1 == 0) goto L_0x000c
                        return
                    L_0x000c:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        com.bytedance.sdk.openadsdk.l.g r1 = r1.J
                        if (r1 == 0) goto L_0x001d
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        com.bytedance.sdk.openadsdk.l.g r1 = r1.J
                        r1.h((java.lang.String) r2)
                    L_0x001d:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0024 }
                        com.bytedance.sdk.openadsdk.i.d r1 = r1.d     // Catch:{ all -> 0x0024 }
                        r1.b()     // Catch:{ all -> 0x0024 }
                    L_0x0024:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar r1 = r1.n     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0037
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar r1 = r1.n     // Catch:{ all -> 0x0055 }
                        r2 = 8
                        r1.setVisibility(r2)     // Catch:{ all -> 0x0055 }
                    L_0x0037:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        boolean r1 = r1.g     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0055
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        r1.j()     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        java.lang.String r2 = "py_loading_success"
                        r1.a((java.lang.String) r2)     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.core.x r1 = r0.c     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0055
                        com.bytedance.sdk.openadsdk.core.x r1 = r0.c     // Catch:{ all -> 0x0055 }
                        r2 = 1
                        r1.b((boolean) r2)     // Catch:{ all -> 0x0055 }
                    L_0x0055:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.AnonymousClass13.onPageFinished(android.webkit.WebView, java.lang.String):void");
                }

                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (!(TTPlayableLandingPageActivity.this.u == null || webResourceRequest == null || webResourceRequest.getUrl() == null || !TTPlayableLandingPageActivity.this.u.equals(webResourceRequest.getUrl().toString()))) {
                        boolean unused = TTPlayableLandingPageActivity.this.g = false;
                    }
                    if (!(TTPlayableLandingPageActivity.this.J == null || webResourceRequest == null)) {
                        try {
                            TTPlayableLandingPageActivity.this.J.a(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                        } catch (Throwable unused2) {
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    boolean unused = TTPlayableLandingPageActivity.this.g = false;
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    boolean unused = TTPlayableLandingPageActivity.this.g = false;
                    if (TTPlayableLandingPageActivity.this.J != null) {
                        TTPlayableLandingPageActivity.this.J.a(i, str, str2);
                    }
                }

                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TTPlayableLandingPageActivity.this.J != null) {
                            TTPlayableLandingPageActivity.this.J.i(str);
                        }
                        if (!TextUtils.isEmpty(TTPlayableLandingPageActivity.this.D)) {
                            TTPlayableLandingPageActivity.this.E.incrementAndGet();
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        WebResourceResponseModel a2 = b.a().a(TTPlayableLandingPageActivity.this.K, TTPlayableLandingPageActivity.this.D, str);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (TTPlayableLandingPageActivity.this.M != null) {
                            f.a a3 = com.bytedance.sdk.component.adexpress.c.f.a(str);
                            int i = (a2 == null || a2.getWebResourceResponse() == null) ? 2 : 1;
                            if (a3 == f.a.HTML) {
                                TTPlayableLandingPageActivity.this.M.a(str, currentTimeMillis, currentTimeMillis2, i);
                            } else if (a3 == f.a.JS) {
                                TTPlayableLandingPageActivity.this.M.b(str, currentTimeMillis, currentTimeMillis2, i);
                            }
                        }
                        if (a2 == null || a2.getWebResourceResponse() == null) {
                            if (a2 != null && a2.getMsg() == 2) {
                                TTPlayableLandingPageActivity.this.G.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTPlayableLandingPageActivity.this.F.incrementAndGet();
                        l.b("TTPWPActivity", "GeckoLog: hit++");
                        if (TTPlayableLandingPageActivity.this.J != null) {
                            TTPlayableLandingPageActivity.this.J.j(str);
                        }
                        return a2.getWebResourceResponse();
                    } catch (Exception unused) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            });
            a(this.e);
            a(this.f);
            k();
            com.bytedance.sdk.openadsdk.utils.o.a(this.e, this.u);
            this.e.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.r, this.N) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (!TTPlayableLandingPageActivity.this.isFinishing()) {
                        try {
                            TTPlayableLandingPageActivity.this.d.a(i);
                        } catch (Throwable unused) {
                        }
                        if (TTPlayableLandingPageActivity.this.n == null) {
                            return;
                        }
                        if (i != 100 || !TTPlayableLandingPageActivity.this.n.isShown()) {
                            TTPlayableLandingPageActivity.this.n.setProgress(i);
                            return;
                        }
                        TTPlayableLandingPageActivity.this.n.setVisibility(8);
                        TTPlayableLandingPageActivity.this.j();
                    }
                }
            });
            this.e.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTPlayableLandingPageActivity.this.N == null) {
                        return false;
                    }
                    TTPlayableLandingPageActivity.this.N.a(motionEvent.getActionMasked());
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            q qVar = this.x;
            bundle.putString("material_meta", qVar != null ? qVar.ao().toString() : null);
            bundle.putInt("sdk_version", this.m);
            bundle.putString("adid", this.p);
            bundle.putString("log_extra", this.q);
            bundle.putInt("source", this.t);
            bundle.putBoolean("ad_pending_download", this.z);
            bundle.putString("url", this.u);
            bundle.putString("web_title", this.v);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void i() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTPlayableLandingPageActivity.this.M != null) {
                        TTPlayableLandingPageActivity.this.M.h();
                    }
                    TTPlayableLandingPageActivity.this.a("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        ShadowTextView shadowTextView = this.j;
        if (shadowTextView != null) {
            shadowTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.b();
                }
            });
        }
        ShadowImageView shadowImageView = this.k;
        if (shadowImageView != null) {
            shadowImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                    boolean unused = tTPlayableLandingPageActivity.L = !tTPlayableLandingPageActivity.L;
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity2 = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity2.b(tTPlayableLandingPageActivity2.L);
                    if (TTPlayableLandingPageActivity.this.J != null) {
                        TTPlayableLandingPageActivity.this.J.a(TTPlayableLandingPageActivity.this.L);
                    }
                }
            });
        }
        this.e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        ad.a((View) this.e, 4);
        ad.a((View) this.f, 0);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.o != null) {
            q qVar = this.x;
            if (qVar == null || com.bytedance.sdk.openadsdk.core.model.t.g(qVar)) {
                this.o.b();
                if (this.o.getPlayView() != null) {
                    AnonymousClass5 r1 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.x, "embeded_ad", this.t) {
                        public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                            if (this.e == null || this.e.r() != 1 || z) {
                                super.a(view, f, f2, f3, f4, sparseArray, z);
                                boolean unused = TTPlayableLandingPageActivity.this.z = true;
                                boolean unused2 = TTPlayableLandingPageActivity.this.A = true;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.u);
                                } catch (JSONException e) {
                                    l.c("TTPWPActivity", "onClick JSON ERROR", e);
                                }
                                com.bytedance.sdk.openadsdk.b.c.b(TTPlayableLandingPageActivity.this.x, this.f, "click_playable_download_button_loading", jSONObject);
                            }
                        }
                    };
                    r1.a(this.B);
                    this.o.getPlayView().setOnClickListener(r1);
                }
                if (com.bytedance.sdk.openadsdk.core.model.t.i(this.x)) {
                    this.y.sendMessageDelayed(b(2), 10000);
                    return;
                }
                return;
            }
            this.o.a();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        SSWebView sSWebView;
        if (!this.C.getAndSet(true) && (sSWebView = this.e) != null && this.f != null) {
            ad.a((View) sSWebView, 0);
            ad.a((View) this.f, 8);
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.a.c.a(this.l).a(false).b(false).a(sSWebView.getWebView());
            sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView.getWebView(), this.m));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.b.c.c(this.x, "embeded_ad", str, (JSONObject) null);
    }

    private void k() {
        if (this.f != null) {
            String l2 = l();
            if (!TextUtils.isEmpty(l2)) {
                this.f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.e(this.l, this.s, this.p, (j) null, false) {
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        if (TTPlayableLandingPageActivity.this.h) {
                            TTPlayableLandingPageActivity.this.a("loading_h5_success");
                        }
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        boolean unused = TTPlayableLandingPageActivity.this.h = false;
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        boolean unused = TTPlayableLandingPageActivity.this.h = false;
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        boolean unused = TTPlayableLandingPageActivity.this.h = false;
                    }
                });
                this.f.a_(l2);
            }
        }
    }

    private String l() {
        q qVar;
        String y2 = o.d().y();
        if (TextUtils.isEmpty(y2) || (qVar = this.x) == null || qVar.aa() == null) {
            return y2;
        }
        String b2 = this.x.aa().b();
        double d2 = this.x.aa().d();
        int e2 = this.x.aa().e();
        String a2 = (this.x.N() == null || TextUtils.isEmpty(this.x.N().a())) ? "" : this.x.N().a();
        String Y = this.x.Y();
        String c2 = this.x.aa().c();
        String a3 = this.x.aa().a();
        String b3 = this.x.aa().b();
        return y2 + "?appname=" + b2 + "&stars=" + d2 + "&comments=" + e2 + "&icon=" + a2 + "&downloading=false&id=" + Y + "&pkg_name=" + c2 + "&download_url=" + a3 + "&name=" + b3;
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.x);
        this.M = new com.bytedance.sdk.openadsdk.b.o(3, "embeded_ad", this.x);
        this.r = new com.bytedance.sdk.openadsdk.core.x(this);
        String bb = this.x.bb();
        this.r.b(this.e).a(this.x).a((List<q>) arrayList).d(this.p).e(this.q).c("embeded_ad").b(this.t).a((d) this).a(this.M).a(this.d).a(this.e).f(bb);
        com.bytedance.sdk.openadsdk.core.x xVar = new com.bytedance.sdk.openadsdk.core.x(this);
        this.s = xVar;
        xVar.b(this.f).a(this.x).d(this.p).e(this.q).a((d) this).b(this.t).c(false).a(this.M).a(this.f).f(bb);
        e();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        e eVar = this.M;
        if (eVar != null) {
            eVar.j();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.bytedance.sdk.openadsdk.core.x xVar = this.r;
        if (xVar != null) {
            xVar.k();
            SSWebView sSWebView = this.e;
            if (sSWebView != null) {
                this.r.b(sSWebView.getVisibility() == 0);
            }
        }
        com.bytedance.sdk.openadsdk.core.x xVar2 = this.s;
        if (xVar2 != null) {
            xVar2.k();
        }
        com.bytedance.sdk.openadsdk.l.g gVar = this.J;
        if (gVar != null) {
            gVar.r();
            this.J.b(true);
        }
        j jVar = this.N;
        if (jVar != null) {
            jVar.g();
        }
        DeviceUtils.AudioInfoReceiver.a((g) this);
        if (DeviceUtils.f() == 0) {
            this.L = true;
        }
        b(this.L);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.x xVar = this.r;
        if (xVar != null) {
            xVar.l();
            this.r.b(false);
        }
        com.bytedance.sdk.openadsdk.core.x xVar2 = this.s;
        if (xVar2 != null) {
            xVar2.l();
        }
        com.bytedance.sdk.openadsdk.l.g gVar = this.J;
        if (gVar != null) {
            gVar.a(true);
            this.J.q();
            this.J.b(false);
        }
        DeviceUtils.AudioInfoReceiver.b((g) this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        e eVar = this.M;
        if (eVar != null) {
            eVar.i();
        }
        j jVar = this.N;
        if (jVar != null) {
            jVar.h();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        e eVar = this.M;
        if (eVar != null) {
            eVar.h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.M;
        if (eVar != null) {
            eVar.a(true);
            this.M.l();
        }
        this.y.removeCallbacksAndMessages((Object) null);
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.D)) {
            c.a.a(this.F.get(), this.E.get(), this.x);
        }
        b.a().a(this.K);
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            aa.a(sSWebView.getWebView());
            this.e.l();
        }
        this.e = null;
        com.bytedance.sdk.openadsdk.core.x xVar = this.r;
        if (xVar != null) {
            xVar.m();
        }
        com.bytedance.sdk.openadsdk.core.x xVar2 = this.s;
        if (xVar2 != null) {
            xVar2.m();
        }
        com.bytedance.sdk.openadsdk.l.g gVar = this.J;
        if (gVar != null) {
            gVar.v();
        }
        j jVar = this.N;
        if (jVar != null) {
            jVar.c(true);
        }
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ad.a((View) this.i, 0);
        } else if (i2 == 2) {
            l.b("playable hidden loading , type:" + message.arg1);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                jSONObject.put("playable_url", this.u);
            } catch (JSONException e2) {
                l.c("TTPWPActivity", "handleMsg json error", e2);
            }
            com.bytedance.sdk.openadsdk.b.c.b(this.x, "embeded_ad", "remove_loading_page", jSONObject);
            this.y.removeMessages(2);
            PlayableLoadingView playableLoadingView = this.o;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        }
    }

    public void a(boolean z2) {
        com.com.bytedance.overseas.sdk.a.c cVar;
        this.z = true;
        this.A = z2;
        if (!z2) {
            try {
                Toast.makeText(this.l, s.a(o.a(), "tt_toast_later_download"), 0).show();
            } catch (Throwable unused) {
            }
        }
        if (this.A && (cVar = this.B) != null) {
            cVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.x != null && !isFinishing()) {
            if (this.c.get()) {
                n();
                return;
            }
            if (this.a == null) {
                c();
            }
            this.a.a(new t.a() {
                public void a() {
                }

                public void a(int i, String str) {
                    if (!TTPlayableLandingPageActivity.this.c.get() && !TextUtils.isEmpty(str)) {
                        TTPlayableLandingPageActivity.this.c.set(true);
                        TTPlayableLandingPageActivity.this.o();
                    }
                }
            });
            t tVar = this.a;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        q qVar = this.x;
        if (qVar != null) {
            this.a = new com.bytedance.sdk.openadsdk.dislike.b(this, qVar.ac(), this.x.ae(), this.x.ao().toString());
        }
        if (this.b == null) {
            this.b = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.b);
        }
    }

    private void n() {
        TTAdDislikeToast tTAdDislikeToast = this.b;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeTip());
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        TTAdDislikeToast tTAdDislikeToast = this.b;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        int i2;
        try {
            this.L = z2;
            if (z2) {
                i2 = s.d(this.l, "tt_mute_wrapper");
            } else {
                i2 = s.d(this.l, "tt_unmute_wrapper");
            }
            this.k.setImageResource(i2);
            com.bytedance.sdk.openadsdk.l.g gVar = this.J;
            if (gVar != null) {
                gVar.a(z2);
            }
        } catch (Exception e2) {
            l.e("TTPWPActivity", e2.getMessage());
        }
    }

    public void a(int i2) {
        b(i2 <= 0);
    }
}
