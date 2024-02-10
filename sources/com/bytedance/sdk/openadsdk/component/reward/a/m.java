package com.bytedance.sdk.openadsdk.component.reward.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.adexpress.c.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.common.f;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.widget.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardFullWebViewManager */
public class m implements g {
    /* access modifiers changed from: private */
    public long A;
    /* access modifiers changed from: private */
    public SparseArray<c.a> B = new SparseArray<>();
    /* access modifiers changed from: private */
    public boolean C = true;
    /* access modifiers changed from: private */
    public float D = -1.0f;
    /* access modifiers changed from: private */
    public float E = -1.0f;
    /* access modifiers changed from: private */
    public f F;
    /* access modifiers changed from: private */
    public boolean G;
    /* access modifiers changed from: private */
    public final a H;
    /* access modifiers changed from: private */
    public boolean I = false;
    /* access modifiers changed from: private */
    public e J;
    /* access modifiers changed from: private */
    public boolean K;
    private boolean L;
    private boolean M;
    /* access modifiers changed from: private */
    public boolean N;
    private long O = -1;
    private long P;
    /* access modifiers changed from: private */
    public volatile int Q = 0;
    /* access modifiers changed from: private */
    public int R;
    private int S;
    /* access modifiers changed from: private */
    public String T;
    /* access modifiers changed from: private */
    public ILoader U;
    /* access modifiers changed from: private */
    public volatile int V = 0;
    /* access modifiers changed from: private */
    public volatile int W = 0;
    private long X = 0;
    /* access modifiers changed from: private */
    public String Y;
    /* access modifiers changed from: private */
    public int Z = -1;
    x a;
    x b;
    protected boolean c = true;
    protected String d;
    j e;
    int f = 0;
    String g = "";
    protected com.bytedance.sdk.openadsdk.b.c.e h;
    boolean i = false;
    /* access modifiers changed from: private */
    public final q j;
    private final String k;
    private int l;
    /* access modifiers changed from: private */
    public final boolean m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public SSWebView p;
    private SSWebView q;
    /* access modifiers changed from: private */
    public boolean r = false;
    /* access modifiers changed from: private */
    public final AtomicBoolean s = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public boolean u;
    private boolean v;
    /* access modifiers changed from: private */
    public View w;
    /* access modifiers changed from: private */
    public View x;
    /* access modifiers changed from: private */
    public float y;
    /* access modifiers changed from: private */
    public float z;

    /* compiled from: RewardFullWebViewManager */
    public interface d {
        void a(WebView webView, int i);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);
    }

    public void x() {
    }

    static /* synthetic */ int l(m mVar) {
        int i2 = mVar.V;
        mVar.V = i2 + 1;
        return i2;
    }

    static /* synthetic */ int n(m mVar) {
        int i2 = mVar.W;
        mVar.W = i2 + 1;
        return i2;
    }

    static /* synthetic */ int o(m mVar) {
        int i2 = mVar.Q;
        mVar.Q = i2 + 1;
        return i2;
    }

    public m(a aVar) {
        this.H = aVar;
        this.j = aVar.a;
        this.k = aVar.g;
        this.m = aVar.f;
    }

    public void a() {
        if (!this.v) {
            this.v = true;
            this.l = this.H.j;
            this.n = this.H.l;
            this.o = this.H.m;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b();
            this.X = SystemClock.elapsedRealtime() - elapsedRealtime;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        f fVar;
        this.w = this.H.V.findViewById(16908290);
        boolean z2 = this.H.s;
        this.G = z2;
        if (!z2 || (fVar = this.F) == null) {
            SSWebView sSWebView = (SSWebView) this.H.V.findViewById(i.n);
            this.p = sSWebView;
            if (sSWebView == null || q.a(this.j)) {
                ad.a((View) this.p, 8);
            } else {
                this.p.c_();
            }
        } else {
            this.p = fVar.d();
        }
        SSWebView sSWebView2 = (SSWebView) this.H.V.findViewById(i.o);
        this.q = sSWebView2;
        if (sSWebView2 == null || !t.b(this.j)) {
            ad.a((View) this.q, 8);
        } else {
            this.q.c_();
            this.q.setDisplayZoomControls(false);
        }
        SSWebView sSWebView3 = this.p;
        if (sSWebView3 != null) {
            sSWebView3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (m.this.p != null && m.this.p.getViewTreeObserver() != null) {
                        m.this.p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        int measuredWidth = m.this.p.getMeasuredWidth();
                        int measuredHeight = m.this.p.getMeasuredHeight();
                        if (m.this.p.getVisibility() == 0) {
                            m.this.a(measuredWidth, measuredHeight);
                        }
                    }
                }
            });
        }
        SSWebView sSWebView4 = this.q;
        if (sSWebView4 != null) {
            sSWebView4.setLandingPage(true);
            this.q.setTag(t.b(this.j) ? this.k : "landingpage_endcard");
            this.q.setWebViewClient(new SSWebView.a());
            this.q.setMaterialMeta(this.j.aJ());
        }
    }

    public void a(String str, final com.bytedance.sdk.openadsdk.core.video.c.b bVar) {
        a(str, (d) new d() {
            public void a(WebView webView, String str) {
                if (!m.this.H.V.isFinishing()) {
                    m.this.H.I.f(m.this.p());
                }
            }

            public void a(WebView webView, String str, Bitmap bitmap) {
                if (!m.this.I && t.k(m.this.H.a)) {
                    boolean unused = m.this.I = true;
                    m.this.H.I.a(m.this.H.o, m.this.H.a, m.this.H.V.o());
                    if (!t.c(m.this.j)) {
                        m.this.H.X.sendEmptyMessageDelayed(600, ((long) m.this.H.I.j()) * 1000);
                    }
                    m.this.H.I.g();
                    m.this.H.V.b();
                }
            }

            public void a(WebView webView, int i) {
                try {
                    if (t.k(m.this.H.a) && m.this.H.a.aQ() && !m.this.H.V.isFinishing()) {
                        m.this.H.I.c(i);
                    } else if (m.this.H.s && m.this.H.P != null) {
                        m.this.H.P.a(webView, i);
                    }
                } catch (Exception unused) {
                }
            }
        });
        if (t.k(this.H.a)) {
            a(this.q);
            this.H.I.a((DownloadListener) new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    m.this.H.H.b();
                    com.bytedance.sdk.openadsdk.core.video.c.b bVar = bVar;
                    if (bVar != null) {
                        bVar.r();
                    }
                }
            });
        }
        this.H.I.a(this.H.q);
        a((DownloadListener) new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                m.this.H.H.b();
                com.bytedance.sdk.openadsdk.core.video.c.b bVar = bVar;
                if (bVar != null) {
                    bVar.r();
                }
            }
        });
    }

    public void a(Boolean bool, com.bytedance.sdk.openadsdk.i.e eVar, String str) {
        if (this.p != null) {
            HashMap hashMap = new HashMap();
            if (t.b(this.j)) {
                hashMap.put("click_scence", 3);
            } else {
                hashMap.put("click_scence", 2);
            }
            this.h = K();
            this.a = new x(this.H.V);
            String bb = this.j.bb();
            int i2 = 7;
            this.a.b(this.p).a(this.j).d(this.j.Y()).e(this.j.ac()).b(bool.booleanValue() ? 7 : 5).a((com.bytedance.sdk.openadsdk.i.a) new b(this.p)).f(bb).a(this.p).c(o() ? "landingpage_endcard" : str).a((Map<String, Object>) hashMap).a(this.h).a((com.bytedance.sdk.openadsdk.core.widget.b) new com.bytedance.sdk.openadsdk.core.widget.b() {
                public void a() {
                    if (m.this.J != null) {
                        m.this.J.a();
                    }
                }
            });
            HashMap hashMap2 = new HashMap();
            if (t.c(this.j)) {
                hashMap2.put("click_scence", 2);
            }
            x xVar = new x(this.H.V);
            this.b = xVar;
            x e2 = xVar.b(this.q).a(this.j).d(this.j.Y()).e(this.j.ac());
            if (!bool.booleanValue()) {
                i2 = 5;
            }
            x f2 = e2.b(i2).a((com.bytedance.sdk.openadsdk.i.a) new b(this.q)).a(this.q).f(bb);
            if (o()) {
                str = "landingpage_endcard";
            }
            f2.c(str).a((Map<String, Object>) hashMap2).a(this.h).a((com.bytedance.sdk.openadsdk.core.widget.b) new com.bytedance.sdk.openadsdk.core.widget.b() {
                public void a() {
                    if (m.this.J != null) {
                        m.this.J.a();
                    }
                }
            }).a((x.a) new x.a() {
                public void a() {
                    boolean unused = m.this.K = true;
                    m.this.H.X.removeMessages(600);
                    m.this.H.R.d(false);
                    m.this.H.D.set(true);
                    m.this.H.Y.p();
                    l.b("TTAD.RFWVM", "onOverlayRendFinish: hasClicked=" + m.this.j.bj());
                    if (!m.this.j.bj() && ac.h(t.a(m.this.j))) {
                        View j = m.this.H.T.j();
                        View.OnClickListener onClickListener = (View.OnClickListener) j.getTag(j.getId());
                        if (onClickListener != null) {
                            a aVar = new a(m.this.H, j, onClickListener);
                            j.setOnClickListener(aVar);
                            j.setOnTouchListener(aVar);
                        }
                    }
                }
            });
            this.a.a((com.bytedance.sdk.openadsdk.i.i) new c(this.p));
            this.b.a((com.bytedance.sdk.openadsdk.i.i) new c(this.q));
            this.a.a(this.H.T.j()).a(this.H.q).a(eVar).a(this.H.I.o()).a((com.bytedance.sdk.openadsdk.i.b) new com.bytedance.sdk.openadsdk.i.b() {
                public void a(boolean z, int i, String str) {
                    if (z) {
                        m.this.H.I.c();
                    }
                    if (q.b(m.this.H.a) && !t.b(m.this.H.a)) {
                        l.b("TTAD.RFWVM", "TimeTrackLog report from js " + z);
                        m.this.a(z, i, str);
                    }
                }

                public void a() {
                    boolean unused = m.this.N = true;
                    m.this.H.T.j().performClick();
                }
            });
            this.a.f(this.L);
            this.b.a(this.H.T.j()).a((com.bytedance.sdk.openadsdk.i.b) new com.bytedance.sdk.openadsdk.i.b() {
                public void a(boolean z, int i, String str) {
                }

                public void a() {
                    boolean unused = m.this.N = true;
                    m.this.H.T.j().performClick();
                }
            });
        }
    }

    public boolean c() {
        return this.N;
    }

    public boolean d() {
        return this.M;
    }

    public void a(int i2, int i3) {
        if (this.a != null && !this.H.V.isFinishing()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i2);
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i3);
                this.a.a("resize", jSONObject);
            } catch (Exception e2) {
                Log.e("TTAD.RFWVM", "", e2);
            }
        }
    }

    public void a(boolean z2) {
        this.c = z2;
    }

    public void e() {
        q qVar = this.j;
        if (qVar != null && !qVar.bu() && this.U == null && o()) {
            this.T = this.j.af();
            this.U = com.bytedance.sdk.openadsdk.d.b.a().b();
            int a2 = com.bytedance.sdk.openadsdk.d.b.a().a(this.U, this.T);
            this.R = a2;
            this.S = a2 > 0 ? 2 : 0;
            if (!TextUtils.isEmpty(this.T)) {
                c.a.a(this.X, this.j, "landingpage_endcard", this.U, this.T);
            }
        }
        if ((!TextUtils.isEmpty(this.d) && this.d.contains("play.google.com/store")) || o.d(this.j)) {
            this.i = true;
        } else if (this.p != null && this.c && !TextUtils.isEmpty(this.d) && !q.a(this.j)) {
            String str = this.d + "&is_pre_render=1";
            l.b("TTAD.RFWVM", "preLoadEndCard: " + str);
            j jVar = this.e;
            if (jVar != null) {
                jVar.d();
            }
            com.bytedance.sdk.openadsdk.utils.o.a(this.p, str);
        }
    }

    public void f() {
        com.bykv.vk.openvk.component.video.api.c.b K2 = this.j.K();
        if (K2 != null) {
            String l2 = K2.l();
            this.Y = l2;
            if (!TextUtils.isEmpty(l2)) {
                this.Y = a(this.Y, this.j, this.l, this.o, this.n);
                this.q.setWebViewClient(new e(com.bytedance.sdk.openadsdk.core.o.a(), this.b, this.j.Y(), this.e, this.j.G() || t.b(this.j)) {
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        if (!m.this.a(str2)) {
                            boolean unused = m.this.u = false;
                            m.this.f = i;
                            m.this.g = str;
                            if (m.this.h != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        jSONObject.put("code", i);
                                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                                    }
                                    m.this.h.a(jSONObject);
                                } catch (JSONException unused2) {
                                }
                            }
                            super.onReceivedError(webView, i, str, str2);
                        }
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        if (webResourceRequest == null || webResourceRequest.getUrl() == null || !m.this.a(webResourceRequest.getUrl().toString())) {
                            boolean unused = m.this.u = false;
                            if (m.this.h != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                                        jSONObject.put("code", webResourceError.getErrorCode());
                                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                                    }
                                    m.this.h.a(jSONObject);
                                } catch (JSONException unused2) {
                                }
                            }
                            if (webResourceError != null) {
                                m.this.f = webResourceError.getErrorCode();
                                m.this.g = String.valueOf(webResourceError.getDescription());
                            }
                            if (webResourceRequest != null) {
                                super.onReceivedError(webView, webResourceRequest, webResourceError);
                            }
                        }
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        if (webResourceRequest != null && !TextUtils.isEmpty(m.this.Y) && m.this.Y.equals(String.valueOf(webResourceRequest.getUrl()))) {
                            boolean unused = m.this.u = false;
                            if (webResourceResponse != null) {
                                m.this.f = webResourceResponse.getStatusCode();
                                m.this.g = "onReceivedHttpError";
                            }
                        }
                        if (m.this.h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 21 && webResourceResponse != null) {
                                    jSONObject.put("code", webResourceResponse.getStatusCode());
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                                }
                                m.this.h.a(jSONObject);
                            } catch (JSONException unused2) {
                            }
                        }
                        if (webResourceRequest != null) {
                            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        }
                    }

                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        if (m.this.h != null) {
                            m.this.h.f();
                        }
                    }

                    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        super.onPageStarted(webView, str, bitmap);
                        if (m.this.h != null) {
                            m.this.h.e();
                        }
                    }
                });
                this.q.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.b, this.e) {
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        if (m.this.H.s && m.this.H.P != null) {
                            m.this.H.P.a(webView, i);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.utils.o.a(this.q, this.Y);
                this.u = true;
            }
        }
    }

    public void g() {
        this.s.set(this.u);
        if (this.q.getVisibility() != 0 || !this.u) {
            this.H.R.c(false);
            this.H.I.e();
            a(this.a, true, false);
            b(this.a, false);
            a(this.a, false);
            this.p.l();
            if (this.u) {
                this.q.setVisibility(0);
                a(this.b, this.H.d, true);
                b(this.b, true);
                a(this.b, true);
                this.H.X.removeMessages(600);
                if (!this.H.S.a(this.H.Y)) {
                    this.H.Y.x();
                    return;
                }
                return;
            }
            this.H.S.d();
            return;
        }
        J();
    }

    private void J() {
        this.b.a("showPlayableEndCardOverlay", (JSONObject) null);
        this.H.X.sendEmptyMessageDelayed(600, 1000);
    }

    public SSWebView h() {
        return this.p;
    }

    public SSWebView i() {
        return this.q;
    }

    public x j() {
        return this.a;
    }

    public x k() {
        return this.b;
    }

    public j l() {
        return this.e;
    }

    public void m() {
        String f2 = t.f(this.j);
        this.d = f2;
        String a2 = a(f2, this.j, this.l, this.o, this.n);
        this.d = a2;
        if (!TextUtils.isEmpty(a2)) {
            this.L = this.d.contains("use_second_endcard=1");
        }
    }

    private static String a(String str, q qVar, int i2, int i3, int i4) {
        String str2;
        String str3;
        float al = qVar.al();
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 1) {
                if (str.contains("?")) {
                    str3 = str + "&";
                } else {
                    str3 = str + "?";
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains("?")) {
                str2 = str + "&";
            } else {
                str2 = str + "?";
            }
            str = str2 + "height=" + i3 + "&width=" + i4 + "&aspect_ratio=" + al;
        }
        return !t.b(qVar) ? com.bytedance.sdk.openadsdk.utils.d.a(str) : str;
    }

    public void n() {
        SSWebView sSWebView = this.p;
        if (sSWebView != null) {
            aa.a(sSWebView.getWebView());
        }
        SSWebView sSWebView2 = this.q;
        if (sSWebView2 != null) {
            aa.a(sSWebView2.getWebView());
        }
        long j2 = this.P;
        if (j2 > 0) {
            if (this.O > 0) {
                this.P = j2 + (SystemClock.elapsedRealtime() - this.O);
            }
            com.bytedance.sdk.openadsdk.b.c.a(this.H.a, this.k, "second_endcard_duration", (JSONObject) null, this.P);
        }
        this.p = null;
        boolean z2 = true;
        if (this.h != null && !o.c(this.j)) {
            this.h.a(true);
            this.h.l();
        }
        x xVar = this.a;
        if (xVar != null) {
            xVar.m();
        }
        x xVar2 = this.b;
        if (xVar2 != null) {
            xVar2.m();
        }
        j jVar = this.e;
        if (jVar != null) {
            if (!this.j.G() && !t.b(this.j)) {
                z2 = false;
            }
            jVar.c(z2);
        }
        DeviceUtils.AudioInfoReceiver.b((g) this);
    }

    public void b(int i2) {
        ad.a((View) this.p, i2);
        SSWebView sSWebView = this.p;
        if (sSWebView != null) {
            ad.a((View) sSWebView.getWebView(), i2);
        }
        if (this.p != null && (this.j.G() || t.b(this.j))) {
            this.p.setLandingPage(true);
            this.p.setTag(t.b(this.j) ? this.k : "landingpage_endcard");
            this.p.setMaterialMeta(this.j.aJ());
        }
        if (i2 == 0 && t.c(this.j)) {
            f();
        }
    }

    public void a(f fVar) {
        this.F = fVar;
    }

    public void a(float f2) {
        ad.a((View) this.p, f2);
    }

    public void b(boolean z2) {
        a(this.a, z2);
    }

    public void a(x xVar, boolean z2) {
        if (this.a != null && !this.H.V.isFinishing()) {
            xVar.b(z2);
        }
    }

    private void a(String str, final d dVar) {
        SSWebView sSWebView;
        SSWebView sSWebView2 = this.p;
        if (!(sSWebView2 == null || sSWebView2.getWebView() == null)) {
            j a2 = new j(this.j, this.p.getWebView(), new com.bytedance.sdk.openadsdk.b.i() {
                public void a(int i) {
                    if (!TextUtils.isEmpty(m.this.T)) {
                        c.a.a(m.this.R, m.this.Q, m.this.W, m.this.V - m.this.W, m.this.j, "landingpage_endcard", i);
                    }
                }
            }, this.S).a(true);
            this.e = a2;
            if (o()) {
                str = "landingpage_endcard";
            }
            a2.a(str);
            this.e.b(this.k);
            this.e.b(true);
            final d dVar2 = dVar;
            AnonymousClass5 r2 = new e(com.bytedance.sdk.openadsdk.core.o.a(), this.a, this.j.Y(), this.e, this.j.G() || t.b(this.j)) {
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    if (t.b(m.this.j)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WebResourceResponse a2 = com.bytedance.sdk.openadsdk.core.video.b.a.a().a(m.this.j.K().m(), m.this.j.K().l(), str);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (m.this.h != null) {
                            f.a a3 = com.bytedance.sdk.component.adexpress.c.f.a(str);
                            int i = a2 != null ? 1 : 2;
                            if (a3 == f.a.HTML) {
                                m.this.h.a(str, currentTimeMillis, currentTimeMillis2, i);
                            } else if (a3 == f.a.JS) {
                                m.this.h.b(str, currentTimeMillis, currentTimeMillis2, i);
                            }
                        }
                        return a2;
                    }
                    try {
                        if (TextUtils.isEmpty(m.this.T)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        m.l(m.this);
                        WebResourceResponseModel a4 = com.bytedance.sdk.openadsdk.d.b.a().a(m.this.U, m.this.T, str);
                        if (a4 == null || a4.getWebResourceResponse() == null) {
                            if (a4 != null && a4.getMsg() == 2) {
                                m.o(m.this);
                            }
                            return super.shouldInterceptRequest(webView, str);
                        }
                        m.n(m.this);
                        l.b("TTAD.RFWVM", "GeckoLog: hit++");
                        return a4.getWebResourceResponse();
                    } catch (Throwable th) {
                        l.c("TTAD.RFWVM", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    try {
                        return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                    } catch (Throwable th) {
                        l.c("TTAD.RFWVM", "shouldInterceptRequest error1", th);
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    }
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    Log.i("TTAD.RFWVM", "onReceivedError: description=" + str + "  url =" + str2);
                    if (!m.this.a(str2)) {
                        m.this.s.set(false);
                        m.this.f = i;
                        m.this.g = str;
                        m.this.H.I.a(i, str, str2);
                        if (m.this.h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    jSONObject.put("code", i);
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                                }
                                m.this.h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        super.onReceivedError(webView, i, str, str2);
                    }
                }

                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    if (!(webResourceError == null || webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                        Log.i("TTAD.RFWVM", "onReceivedError WebResourceError : description=" + webResourceError.getDescription() + "  url =" + webResourceRequest.getUrl().toString());
                    }
                    if (webResourceRequest == null || webResourceRequest.getUrl() == null || !m.this.a(webResourceRequest.getUrl().toString())) {
                        m.this.s.set(false);
                        if (m.this.h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                                    jSONObject.put("code", webResourceError.getErrorCode());
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                                }
                                m.this.h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        if (webResourceError != null) {
                            m.this.f = webResourceError.getErrorCode();
                            m.this.g = String.valueOf(webResourceError.getDescription());
                        }
                        if (webResourceRequest != null) {
                            super.onReceivedError(webView, webResourceRequest, webResourceError);
                        }
                    }
                }

                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    m.this.H.I.a(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                        Log.i("TTAD.RFWVM", "onReceivedHttpError:url =" + webResourceRequest.getUrl().toString());
                    }
                    if (webResourceRequest != null && !TextUtils.isEmpty(m.this.d) && m.this.d.equals(String.valueOf(webResourceRequest.getUrl()))) {
                        m.this.s.set(false);
                        if (webResourceResponse != null) {
                            m.this.f = webResourceResponse.getStatusCode();
                            m.this.g = "onReceivedHttpError";
                        }
                    }
                    if (m.this.h != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 21 && webResourceResponse != null) {
                                jSONObject.put("code", webResourceResponse.getStatusCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                            }
                            m.this.h.a(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceRequest != null) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }
                }

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    boolean unused = m.this.t = true;
                    DeviceUtils.AudioInfoReceiver.a((g) m.this);
                    int unused2 = m.this.Z = DeviceUtils.f();
                    if (m.this.h != null) {
                        m.this.h.f();
                    }
                    m.this.H.I.b(str);
                    d dVar = dVar2;
                    if (dVar != null) {
                        dVar.a(webView, str);
                    }
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (m.this.h != null) {
                        m.this.h.e();
                    }
                    m.this.H.I.c(str);
                    d dVar = dVar2;
                    if (dVar != null) {
                        dVar.a(webView, str, bitmap);
                    }
                }
            };
            this.J = r2;
            this.p.setWebViewClient(r2);
            this.J.a(this.j);
            this.J.a(this.m ? "rewarded_video" : "fullscreen_interstitial_ad");
            if (!(!this.j.G() || (sSWebView = this.p) == null || sSWebView.getWebView() == null)) {
                this.p.getWebView().setOnTouchListener(new View.OnTouchListener() {
                    private final int b = com.bytedance.sdk.openadsdk.core.o.b();

                    /* JADX WARNING: Can't wrap try/catch for region: R(6:36|37|38|(1:42)|43|44) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0144 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
                        /*
                            r18 = this;
                            r1 = r18
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this
                            com.bytedance.sdk.openadsdk.b.j r0 = r0.e
                            if (r0 == 0) goto L_0x0013
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this
                            com.bytedance.sdk.openadsdk.b.j r0 = r0.e
                            int r2 = r20.getActionMasked()
                            r0.a((int) r2)
                        L_0x0013:
                            r2 = 0
                            int r0 = r20.getActionMasked()     // Catch:{ all -> 0x0357 }
                            r3 = -1
                            r5 = 0
                            r7 = 2
                            r8 = 1
                            if (r0 == 0) goto L_0x00f4
                            r9 = 3
                            if (r0 == r8) goto L_0x00f2
                            if (r0 == r7) goto L_0x002f
                            if (r0 == r9) goto L_0x002b
                            r9 = -1
                            r11 = -1
                            goto L_0x0151
                        L_0x002b:
                            r9 = 4
                            r11 = 4
                            goto L_0x0151
                        L_0x002f:
                            float r0 = r20.getRawX()     // Catch:{ all -> 0x0357 }
                            float r9 = r20.getRawY()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r10 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r10 = r10.y     // Catch:{ all -> 0x0357 }
                            float r0 = r0 - r10
                            float r0 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0357 }
                            int r10 = r1.b     // Catch:{ all -> 0x0357 }
                            float r10 = (float) r10     // Catch:{ all -> 0x0357 }
                            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
                            if (r0 >= 0) goto L_0x005c
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r0 = r0.z     // Catch:{ all -> 0x0357 }
                            float r0 = r9 - r0
                            float r0 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0357 }
                            int r10 = r1.b     // Catch:{ all -> 0x0357 }
                            float r10 = (float) r10     // Catch:{ all -> 0x0357 }
                            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
                            if (r0 < 0) goto L_0x0061
                        L_0x005c:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean unused = r0.C = r2     // Catch:{ all -> 0x0357 }
                        L_0x0061:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r10 = r0.D     // Catch:{ all -> 0x0357 }
                            float r11 = r20.getX()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r12 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r12 = r12.y     // Catch:{ all -> 0x0357 }
                            float r11 = r11 - r12
                            float r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0357 }
                            float r10 = r10 + r11
                            float unused = r0.D = r10     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r10 = r0.E     // Catch:{ all -> 0x0357 }
                            float r11 = r20.getY()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r12 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r12 = r12.z     // Catch:{ all -> 0x0357 }
                            float r11 = r11 - r12
                            float r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0357 }
                            float r10 = r10 + r11
                            float unused = r0.E = r10     // Catch:{ all -> 0x0357 }
                            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            long r12 = r0.A     // Catch:{ all -> 0x0357 }
                            long r10 = r10 - r12
                            r12 = 200(0xc8, double:9.9E-322)
                            r0 = 1090519040(0x41000000, float:8.0)
                            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                            if (r14 <= 0) goto L_0x00bc
                            com.bytedance.sdk.openadsdk.component.reward.a.m r10 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r10 = r10.D     // Catch:{ all -> 0x0357 }
                            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                            if (r10 > 0) goto L_0x00ba
                            com.bytedance.sdk.openadsdk.component.reward.a.m r10 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r10 = r10.E     // Catch:{ all -> 0x0357 }
                            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                            if (r10 <= 0) goto L_0x00bc
                        L_0x00ba:
                            r10 = 1
                            goto L_0x00bd
                        L_0x00bc:
                            r10 = 2
                        L_0x00bd:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r11 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r11 = r11.G     // Catch:{ all -> 0x0357 }
                            if (r11 == 0) goto L_0x00f0
                            com.bytedance.sdk.openadsdk.component.reward.a.m r11 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r11 = r11.z     // Catch:{ all -> 0x0357 }
                            float r11 = r9 - r11
                            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
                            if (r0 <= 0) goto L_0x00da
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.common.f r0 = r0.F     // Catch:{ all -> 0x0357 }
                            r0.a()     // Catch:{ all -> 0x0357 }
                        L_0x00da:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r0 = r0.z     // Catch:{ all -> 0x0357 }
                            float r9 = r9 - r0
                            r0 = -1056964608(0xffffffffc1000000, float:-8.0)
                            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                            if (r0 >= 0) goto L_0x00f0
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.common.f r0 = r0.F     // Catch:{ all -> 0x0357 }
                            r0.b()     // Catch:{ all -> 0x0357 }
                        L_0x00f0:
                            r11 = r10
                            goto L_0x0151
                        L_0x00f2:
                            r11 = 3
                            goto L_0x0151
                        L_0x00f4:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean unused = r0.C = r8     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.util.SparseArray r9 = new android.util.SparseArray     // Catch:{ all -> 0x0357 }
                            r9.<init>()     // Catch:{ all -> 0x0357 }
                            android.util.SparseArray unused = r0.B = r9     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r9 = r20.getRawX()     // Catch:{ all -> 0x0357 }
                            float unused = r0.y = r9     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r9 = r20.getRawY()     // Catch:{ all -> 0x0357 }
                            float unused = r0.z = r9     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0357 }
                            long unused = r0.A = r9     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0144 }
                            com.bytedance.sdk.component.widget.SSWebView r0 = r0.p     // Catch:{ Exception -> 0x0144 }
                            long r9 = r0.getLandingPageClickBegin()     // Catch:{ Exception -> 0x0144 }
                            int r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                            if (r0 <= 0) goto L_0x0144
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0144 }
                            long r11 = r0.A     // Catch:{ Exception -> 0x0144 }
                            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                            if (r0 >= 0) goto L_0x0144
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0144 }
                            long unused = r0.A = r9     // Catch:{ Exception -> 0x0144 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0144 }
                            com.bytedance.sdk.component.widget.SSWebView r0 = r0.p     // Catch:{ Exception -> 0x0144 }
                            r0.setLandingPageClickBegin(r3)     // Catch:{ Exception -> 0x0144 }
                        L_0x0144:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
                            float unused = r0.D = r9     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float unused = r0.E = r9     // Catch:{ all -> 0x0357 }
                            r11 = 0
                        L_0x0151:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.util.SparseArray r0 = r0.B     // Catch:{ all -> 0x0357 }
                            int r9 = r20.getActionMasked()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.b.c$a r14 = new com.bytedance.sdk.openadsdk.core.b.c$a     // Catch:{ all -> 0x0357 }
                            float r10 = r20.getSize()     // Catch:{ all -> 0x0357 }
                            double r12 = (double) r10     // Catch:{ all -> 0x0357 }
                            float r10 = r20.getPressure()     // Catch:{ all -> 0x0357 }
                            double r2 = (double) r10     // Catch:{ all -> 0x0357 }
                            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0357 }
                            r10 = r14
                            r4 = r14
                            r14 = r2
                            r10.<init>(r11, r12, r14, r16)     // Catch:{ all -> 0x0357 }
                            r0.put(r9, r4)     // Catch:{ all -> 0x0357 }
                            int r0 = r20.getAction()     // Catch:{ all -> 0x0357 }
                            if (r0 != r8) goto L_0x035f
                            int r0 = r19.getVisibility()     // Catch:{ all -> 0x0357 }
                            if (r0 != 0) goto L_0x035f
                            float r0 = r19.getAlpha()     // Catch:{ all -> 0x0357 }
                            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0357 }
                            int r0 = r0.intValue()     // Catch:{ all -> 0x0357 }
                            if (r0 != r8) goto L_0x035f
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r0 = r0.r     // Catch:{ all -> 0x0357 }
                            if (r0 == 0) goto L_0x01a2
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.model.q r0 = r0.j     // Catch:{ all -> 0x0357 }
                            boolean r0 = com.bytedance.sdk.openadsdk.core.model.o.f((com.bytedance.sdk.openadsdk.core.model.q) r0)     // Catch:{ all -> 0x0357 }
                            if (r0 == 0) goto L_0x035f
                        L_0x01a2:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r0 = r0.C     // Catch:{ all -> 0x0357 }
                            if (r0 == 0) goto L_0x035f
                            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0357 }
                            r0.<init>()     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "down_x"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r3 = r3.y     // Catch:{ all -> 0x0357 }
                            double r3 = (double) r3     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "down_y"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            float r3 = r3.z     // Catch:{ all -> 0x0357 }
                            double r3 = (double) r3     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "down_time"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            long r3 = r3.A     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "up_x"
                            float r3 = r20.getRawX()     // Catch:{ all -> 0x0357 }
                            double r3 = (double) r3     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "up_y"
                            float r3 = r20.getRawY()     // Catch:{ all -> 0x0357 }
                            double r3 = (double) r3     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r4 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0208 }
                            com.bytedance.sdk.component.widget.SSWebView r4 = r4.p     // Catch:{ Exception -> 0x0208 }
                            long r9 = r4.getLandingPageClickEnd()     // Catch:{ Exception -> 0x0208 }
                            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                            if (r4 <= 0) goto L_0x0208
                            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                            if (r4 >= 0) goto L_0x0208
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ Exception -> 0x0207 }
                            com.bytedance.sdk.component.widget.SSWebView r2 = r2.p     // Catch:{ Exception -> 0x0207 }
                            r3 = -1
                            r2.setLandingPageClickEnd(r3)     // Catch:{ Exception -> 0x0207 }
                        L_0x0207:
                            r2 = r9
                        L_0x0208:
                            java.lang.String r4 = "up_time"
                            r0.put(r4, r2)     // Catch:{ all -> 0x0357 }
                            int[] r2 = new int[r7]     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r3 = r3.G     // Catch:{ all -> 0x0357 }
                            if (r3 == 0) goto L_0x0229
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r3.H     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = r4.V     // Catch:{ all -> 0x0357 }
                            int r5 = com.bytedance.sdk.openadsdk.utils.i.af     // Catch:{ all -> 0x0357 }
                            android.view.View r4 = r4.findViewById(r5)     // Catch:{ all -> 0x0357 }
                            android.view.View unused = r3.x = r4     // Catch:{ all -> 0x0357 }
                            goto L_0x023b
                        L_0x0229:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r3.H     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = r4.V     // Catch:{ all -> 0x0357 }
                            r5 = 520093713(0x1f000011, float:2.710511E-20)
                            android.view.View r4 = r4.findViewById(r5)     // Catch:{ all -> 0x0357 }
                            android.view.View unused = r3.x = r4     // Catch:{ all -> 0x0357 }
                        L_0x023b:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.x     // Catch:{ all -> 0x0357 }
                            if (r3 == 0) goto L_0x0279
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.x     // Catch:{ all -> 0x0357 }
                            r3.getLocationOnScreen(r2)     // Catch:{ all -> 0x0357 }
                            java.lang.String r3 = "button_x"
                            r4 = 0
                            r5 = r2[r4]     // Catch:{ all -> 0x0357 }
                            r0.put(r3, r5)     // Catch:{ all -> 0x0357 }
                            java.lang.String r3 = "button_y"
                            r2 = r2[r8]     // Catch:{ all -> 0x0357 }
                            r0.put(r3, r2)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "button_width"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.x     // Catch:{ all -> 0x0357 }
                            int r3 = r3.getWidth()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "button_height"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.x     // Catch:{ all -> 0x0357 }
                            int r3 = r3.getHeight()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                        L_0x0279:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r2 = r2.w     // Catch:{ all -> 0x0357 }
                            if (r2 == 0) goto L_0x02b9
                            int[] r2 = new int[r7]     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.w     // Catch:{ all -> 0x0357 }
                            r3.getLocationOnScreen(r2)     // Catch:{ all -> 0x0357 }
                            java.lang.String r3 = "ad_x"
                            r4 = 0
                            r5 = r2[r4]     // Catch:{ all -> 0x0357 }
                            r0.put(r3, r5)     // Catch:{ all -> 0x0357 }
                            java.lang.String r3 = "ad_y"
                            r2 = r2[r8]     // Catch:{ all -> 0x0357 }
                            r0.put(r3, r2)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "width"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.w     // Catch:{ all -> 0x0357 }
                            int r3 = r3.getWidth()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "height"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.view.View r3 = r3.w     // Catch:{ all -> 0x0357 }
                            int r3 = r3.getHeight()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                        L_0x02b9:
                            java.lang.String r2 = "toolType"
                            r3 = r20
                            r4 = 0
                            int r5 = r3.getToolType(r4)     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r5)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "deviceId"
                            int r4 = r20.getDeviceId()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r4)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "source"
                            int r3 = r20.getSource()     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "ft"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            android.util.SparseArray r3 = r3.B     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.h r4 = com.bytedance.sdk.openadsdk.core.h.b()     // Catch:{ all -> 0x0357 }
                            boolean r4 = r4.a()     // Catch:{ all -> 0x0357 }
                            if (r4 == 0) goto L_0x02eb
                            r4 = 1
                            goto L_0x02ec
                        L_0x02eb:
                            r4 = 2
                        L_0x02ec:
                            org.json.JSONObject r3 = com.bytedance.sdk.openadsdk.core.model.i.a(r3, r4)     // Catch:{ all -> 0x0357 }
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "user_behavior_type"
                            com.bytedance.sdk.openadsdk.component.reward.a.m r3 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r3 = r3.C     // Catch:{ all -> 0x0357 }
                            if (r3 == 0) goto L_0x02ff
                            r3 = 1
                            goto L_0x0300
                        L_0x02ff:
                            r3 = 2
                        L_0x0300:
                            r0.put(r2, r3)     // Catch:{ all -> 0x0357 }
                            java.lang.String r2 = "click_scence"
                            r0.put(r2, r7)     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.widget.a.e r2 = r2.J     // Catch:{ all -> 0x0357 }
                            if (r2 == 0) goto L_0x0319
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.widget.a.e r2 = r2.J     // Catch:{ all -> 0x0357 }
                            r2.a((org.json.JSONObject) r0)     // Catch:{ all -> 0x0357 }
                        L_0x0319:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r2 = r2.r     // Catch:{ all -> 0x0357 }
                            if (r2 != 0) goto L_0x0355
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.model.q r2 = r2.j     // Catch:{ all -> 0x0357 }
                            boolean r2 = com.bytedance.sdk.openadsdk.core.model.o.e((com.bytedance.sdk.openadsdk.core.model.q) r2)     // Catch:{ all -> 0x0357 }
                            if (r2 == 0) goto L_0x032e
                            goto L_0x0355
                        L_0x032e:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean r2 = r2.m     // Catch:{ all -> 0x0357 }
                            java.lang.String r3 = "click"
                            if (r2 == 0) goto L_0x0344
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.model.q r2 = r2.j     // Catch:{ all -> 0x0357 }
                            java.lang.String r4 = "rewarded_video"
                            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r2, (java.lang.String) r4, (java.lang.String) r3, (org.json.JSONObject) r0)     // Catch:{ all -> 0x0357 }
                            goto L_0x034f
                        L_0x0344:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r2 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            com.bytedance.sdk.openadsdk.core.model.q r2 = r2.j     // Catch:{ all -> 0x0357 }
                            java.lang.String r4 = "fullscreen_interstitial_ad"
                            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r2, (java.lang.String) r4, (java.lang.String) r3, (org.json.JSONObject) r0)     // Catch:{ all -> 0x0357 }
                        L_0x034f:
                            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = com.bytedance.sdk.openadsdk.component.reward.a.m.this     // Catch:{ all -> 0x0357 }
                            boolean unused = r0.r = r8     // Catch:{ all -> 0x0357 }
                            goto L_0x035f
                        L_0x0355:
                            r2 = 0
                            return r2
                        L_0x0357:
                            r0 = move-exception
                            java.lang.String r2 = "TTAD.RFWVM"
                            java.lang.String r3 = "TouchRecordTool onTouch error"
                            android.util.Log.e(r2, r3, r0)
                        L_0x035f:
                            r2 = 0
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.a.m.AnonymousClass6.onTouch(android.view.View, android.view.MotionEvent):boolean");
                    }
                });
            }
            SSWebView sSWebView3 = this.p;
            if (sSWebView3 != null) {
                sSWebView3.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.a, this.e) {
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.a(webView, i);
                        }
                    }
                });
            }
            a(this.p);
            if (Build.VERSION.SDK_INT >= 24) {
                this.p.setLayerType(1, (Paint) null);
            }
            this.p.setBackgroundColor(-1);
            this.p.setDisplayZoomControls(false);
        }
        e();
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!this.j.G() || !str.endsWith(".mp4")) {
            return false;
        }
        return true;
    }

    public boolean o() {
        String str = this.d;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(DownloadListener downloadListener) {
        SSWebView sSWebView = this.p;
        if (sSWebView != null && downloadListener != null) {
            sSWebView.setDownloadListener(downloadListener);
        }
    }

    public boolean p() {
        return this.s.get();
    }

    public void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.a.c.a((Context) this.H.V).a(false).b(false).a(sSWebView.getWebView());
            sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView.getWebView(), (int) BuildConfig.VERSION_CODE));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
        }
    }

    public void q() {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            eVar.i();
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.h();
        }
    }

    public void r() {
        SSWebView sSWebView = this.p;
        if (sSWebView != null) {
            sSWebView.k();
        }
        SSWebView sSWebView2 = this.q;
        if (sSWebView2 != null) {
            sSWebView2.k();
        }
        if (this.O > 0) {
            this.P += SystemClock.elapsedRealtime() - this.O;
            this.O = 0;
        }
        x xVar = this.a;
        if (xVar != null) {
            xVar.l();
            this.a.b(false);
            b(this.a, false);
            a(this.a, true, false);
        }
        if (this.b != null && t.c(this.j)) {
            this.b.l();
            this.b.b(false);
            b(this.b, false);
            a(this.b, true, false);
        }
    }

    public void c(boolean z2) {
        b(this.a, z2);
    }

    public void b(x xVar, boolean z2) {
        try {
            this.H.I.d(z2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z2 ? 1 : 0);
            xVar.a("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z2, boolean z3) {
        a(this.a, z2, z3);
    }

    public void a(x xVar, boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z3);
            xVar.a("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void d(boolean z2) {
        if (this.a != null && !this.H.V.isFinishing()) {
            this.H.I.e(z2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endcard_mute", z2);
                this.a.a("volumeChange", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public void s() {
        SSWebView sSWebView = this.p;
        if (sSWebView != null) {
            sSWebView.i();
        }
        SSWebView sSWebView2 = this.q;
        if (sSWebView2 != null) {
            sSWebView2.i();
        }
        if (this.O == 0) {
            this.O = SystemClock.elapsedRealtime();
        }
        x xVar = this.a;
        if (xVar != null) {
            xVar.k();
            SSWebView sSWebView3 = this.p;
            if (sSWebView3 != null) {
                if (sSWebView3.getVisibility() == 0) {
                    this.a.b(true);
                    b(this.a, true);
                    a(this.a, false, true);
                } else {
                    this.a.b(false);
                    b(this.a, false);
                    a(this.a, true, false);
                }
            }
        }
        if (this.b != null && t.c(this.j)) {
            this.b.k();
            SSWebView sSWebView4 = this.q;
            if (sSWebView4 != null) {
                if (sSWebView4.getVisibility() == 0) {
                    this.b.b(true);
                    b(this.b, true);
                    a(this.b, false, true);
                    if (!this.K && this.H.a.bj()) {
                        J();
                    }
                } else {
                    this.b.b(false);
                    b(this.b, false);
                    a(this.b, true, false);
                }
            }
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.g();
        }
    }

    public int t() {
        return this.f;
    }

    public String u() {
        return this.g;
    }

    public String v() {
        return this.d;
    }

    public boolean w() {
        return this.L && !this.M && this.s.get() && this.t;
    }

    public void y() {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            eVar.h();
        }
    }

    public void a(boolean z2, int i2, String str) {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            if (z2) {
                eVar.b();
            } else {
                eVar.a(i2, str);
            }
        }
    }

    public void z() {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            eVar.g();
        }
    }

    public void A() {
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(System.currentTimeMillis());
        }
    }

    public boolean B() {
        return this.i;
    }

    public void C() {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            eVar.c();
            this.h.d();
        }
    }

    public void D() {
        com.bytedance.sdk.openadsdk.b.c.e eVar = this.h;
        if (eVar != null) {
            eVar.j();
        }
    }

    private com.bytedance.sdk.openadsdk.b.c.e K() {
        return new com.bytedance.sdk.openadsdk.b.o(t.b(this.j) ? 3 : 2, this.m ? "rewarded_video" : "fullscreen_interstitial_ad", this.j);
    }

    public boolean E() {
        x xVar = this.a;
        if (xVar == null) {
            return false;
        }
        return xVar.i();
    }

    public void a(int i2) {
        int i3 = this.Z;
        if (i3 <= 0 && i2 > 0) {
            l.b("TTAD.RFWVM", "onVolumeChanged >>>> become unmuted, notify h5");
            d(false);
        } else if (i3 > 0 && i2 == 0) {
            l.b("TTAD.RFWVM", "onVolumeChanged >>>> become mute notification h5");
            d(true);
        }
        this.Z = i2;
    }

    public void F() {
        ad.a((View) this.p, 0);
        ad.a((View) this.q, 8);
    }

    public void G() {
        com.bytedance.sdk.openadsdk.b.c.b(this.j, this.k, "use_second_endcard", (JSONObject) null);
        this.M = true;
        this.O = SystemClock.elapsedRealtime();
        try {
            this.a.a("click_endcard_close", (JSONObject) null);
        } catch (Exception unused) {
        }
    }

    public boolean H() {
        SSWebView sSWebView = this.p;
        return sSWebView == null || sSWebView.getWebView() == null;
    }

    /* compiled from: RewardFullWebViewManager */
    private static class b implements com.bytedance.sdk.openadsdk.i.a {
        private final View a;

        public b(View view) {
            this.a = view;
        }

        public int a() {
            View view = this.a;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            l.c("TTAndroidObject", "mWebView height is " + measuredHeight);
            return measuredHeight <= 0 ? ad.d(com.bytedance.sdk.openadsdk.core.o.a()) : measuredHeight;
        }

        public int b() {
            View view = this.a;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            l.c("TTAndroidObject", "mWebView width is " + measuredWidth);
            return measuredWidth <= 0 ? ad.c(com.bytedance.sdk.openadsdk.core.o.a()) : measuredWidth;
        }
    }

    /* compiled from: RewardFullWebViewManager */
    private static class c implements com.bytedance.sdk.openadsdk.i.i {
        private final SSWebView a;

        private c(SSWebView sSWebView) {
            this.a = sSWebView;
        }

        public void a() {
            SSWebView sSWebView = this.a;
            if (sSWebView == null) {
                l.b("TTAD.RFWVM", "webView has destroy when onPauseWebView");
                return;
            }
            sSWebView.k();
            l.b("TTAD.RFWVM", "js make webView onPause OK");
        }

        public void b() {
            SSWebView sSWebView = this.a;
            if (sSWebView == null) {
                l.b("TTAD.RFWVM", "webView has destroy when onPauseWebViewTimers");
                return;
            }
            sSWebView.n();
            l.b("TTAD.RFWVM", "js make webView pauseTimers OK");
        }
    }

    public void I() {
        j jVar = this.e;
        if (jVar != null) {
            jVar.e();
        }
    }

    /* compiled from: RewardFullWebViewManager */
    private static class a extends com.bytedance.sdk.openadsdk.core.b.a implements b.a {
        private final View.OnClickListener G;
        private final a a;
        private final View b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(a aVar, View view, View.OnClickListener onClickListener) {
            super(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5);
            this.a = aVar;
            this.b = view;
            this.G = onClickListener;
            HashMap hashMap = new HashMap();
            hashMap.put("close_auto_click", true);
            hashMap.put("click_scence", 2);
            a((Map<String, Object>) hashMap);
            a(aVar.H.c());
            a((b.a) this);
        }

        public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
            if (this.e.bj()) {
                this.G.onClick(view);
                this.b.setOnTouchListener((View.OnTouchListener) null);
                this.b.setOnClickListener(this.G);
                return;
            }
            super.a(view, f, f2, f3, f4, sparseArray, z);
            this.a.V.onRewardBarClick(view);
        }

        public void a(View view, int i) {
            this.b.setOnTouchListener((View.OnTouchListener) null);
            this.b.setOnClickListener(this.G);
        }
    }
}
