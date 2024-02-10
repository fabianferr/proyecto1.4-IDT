package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.f.b.b;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.PangleWebView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.f;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LandingPageLog */
public class j {
    private static final int[] a = {10, 30, 50, 75, 100};
    private boolean A;
    private i B;
    private volatile long C;
    private final AtomicInteger D;
    private final AtomicInteger E;
    private final AtomicBoolean F;
    private volatile int G;
    private int H;
    private volatile long I;
    private volatile long J;
    private volatile long K;
    private final AtomicBoolean L;
    private String M;
    private long N;
    private int b;
    private long c;
    private int d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private int i;
    private boolean j;
    private String k;
    private String l;
    private final Context m;
    private final q n;
    private String o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private boolean u;
    private final boolean v;
    /* access modifiers changed from: private */
    public final AtomicInteger w;
    /* access modifiers changed from: private */
    public WebView x;
    private boolean y;
    private e z;

    public void a(WebView webView, WebResourceRequest webResourceRequest) {
    }

    public q a() {
        return this.n;
    }

    public j(q qVar, WebView webView, i iVar, int i2) {
        this(qVar, webView);
        this.B = iVar;
        this.H = i2;
    }

    public j(q qVar, WebView webView) {
        this.b = 0;
        this.c = -1;
        this.d = 1;
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = -1;
        this.o = "landingpage";
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.w = new AtomicInteger(0);
        this.y = false;
        this.A = false;
        this.C = 0;
        this.D = new AtomicInteger(0);
        this.E = new AtomicInteger(0);
        this.F = new AtomicBoolean(false);
        this.G = 0;
        this.H = -1;
        this.L = new AtomicBoolean(false);
        this.m = o.a();
        this.n = qVar;
        this.x = webView;
        if (webView != null) {
            if (webView instanceof PangleWebView) {
                this.N = ((PangleWebView) webView).a;
            } else {
                this.N = System.currentTimeMillis();
            }
            try {
                this.x.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e2) {
                l.c("LandingPageLog", "addJavascriptInterface exception", e2);
            }
            if (qVar != null && qVar.aR() != null) {
                this.c = qVar.aR().optLong("page_id", -1);
            }
        }
    }

    public void a(long j2) {
        this.q = j2;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.o = str;
        }
    }

    public e b() {
        return this.z;
    }

    public void a(e eVar) {
        this.z = eVar;
    }

    public j a(boolean z2) {
        this.y = z2;
        return this;
    }

    public boolean c() {
        return this.A;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.M = str;
        }
    }

    public void b(boolean z2) {
        this.A = z2;
    }

    public void d() {
        if (i()) {
            this.I = SystemClock.elapsedRealtime();
            c.a(this.n, this.M);
        }
    }

    public void e() {
        if (i()) {
            this.J = SystemClock.elapsedRealtime();
            f();
        }
    }

    public void f() {
        if (i() && this.J > 0 && this.K > 0 && !this.L.getAndSet(true)) {
            c.a(this.K - this.J, this.n, this.M);
        }
    }

    public void a(WebView webView, int i2) {
        if (webView != null) {
            l.b("LandingPageLog", "onWebProgress: " + i2);
            if (this.C == 0) {
                this.C = SystemClock.elapsedRealtime();
            }
            if (this.r == 0 && i2 > 0) {
                this.r = System.currentTimeMillis();
            } else if (this.s == 0 && i2 == 100) {
                this.s = System.currentTimeMillis();
            }
            if (this.b != a.length && ("landingpage".equals(this.o) || "landingpage_endcard".equals(this.o) || "landingpage_split_screen".equals(this.o) || "landingpage_direct".equals(this.o))) {
                int i3 = this.b;
                while (true) {
                    int[] iArr = a;
                    if (i3 >= iArr.length || i2 < iArr[this.b]) {
                        break;
                    }
                    int i4 = i3 + 1;
                    this.b = i4;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", webView.getUrl());
                        long j2 = this.c;
                        if (j2 != -1) {
                            jSONObject.put("page_id", j2);
                        }
                        jSONObject.putOpt("render_type", "h5");
                        jSONObject.putOpt("render_type_2", 0);
                        jSONObject.put("pct", iArr[i3]);
                    } catch (Exception unused) {
                    }
                    a("progress_load_finish", jSONObject);
                    i3 = i4;
                }
            }
            if (i2 == 100) {
                a(webView.getUrl(), "progress", Math.min(this.s - this.r, 600000));
            }
        }
    }

    private void a(String str, String str2, long j2) {
        if (this.g.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            a("load_finish_progress", jSONObject, j2);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        WebView webView2 = this.x;
        if (webView2 != null) {
            try {
                WebBackForwardList copyBackForwardList = webView2.copyBackForwardList();
                if (copyBackForwardList != null && copyBackForwardList.getCurrentIndex() > this.G) {
                    this.D.incrementAndGet();
                }
                this.G = copyBackForwardList.getCurrentIndex();
            } catch (Exception e2) {
                l.c("LandingPageLog", "copyBackForwardList exception", e2);
            }
        }
        if (this.C == 0) {
            this.C = SystemClock.elapsedRealtime();
        }
        e eVar = this.z;
        if (eVar != null) {
            eVar.e();
        }
        if (this.e.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i2 = this.H;
                if (i2 >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
            a("load_start", jSONObject);
        }
    }

    public void a(WebView webView, String str, boolean z2) {
        WebView webView2 = webView;
        boolean z3 = z2;
        e eVar = this.z;
        if (eVar != null) {
            eVar.f();
        }
        boolean z4 = true;
        if (webView2 != null && !this.u && this.y) {
            this.u = true;
            k.a(webView2, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.f.compareAndSet(false, true)) {
            if (this.d != 3) {
                this.d = 2;
            }
            this.p = System.currentTimeMillis();
            if (this.d != 2) {
                z4 = false;
            }
            int j2 = j();
            if (z4) {
                String str2 = "url";
                long j3 = this.s - this.r;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.i);
                    jSONObject.put("error_msg", this.k);
                    jSONObject.put("error_url", this.l);
                    int i2 = this.H;
                    if (i2 >= 0) {
                        jSONObject.put("preload_status", i2);
                    }
                    jSONObject.put("first_page", j2);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put(str2, this.n.P());
                } catch (Exception unused) {
                }
                a(z3, "0");
                long min = Math.min(j3, 600000);
                a("load_finish", jSONObject, min);
                if (i()) {
                    this.K = SystemClock.elapsedRealtime();
                    f();
                    c.a(this.n, this.M, this.K - this.I);
                }
                a(str, "load_finish", min);
                i iVar = this.B;
                if (iVar != null) {
                    iVar.a(j2);
                    return;
                }
                return;
            }
            String str3 = "url";
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.i);
                jSONObject2.put("error_msg", this.k);
                jSONObject2.put("error_url", this.l);
                jSONObject2.put("first_page", j2);
                int i3 = this.H;
                if (i3 >= 0) {
                    jSONObject2.put("preload_status", i3);
                }
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put(str3, this.n.P());
            } catch (Exception unused2) {
            }
            a(z3, "2");
            a("load_fail", jSONObject2);
            if (i()) {
                c.a(this.n, this.M, SystemClock.elapsedRealtime() - this.I, this.i, this.k);
            }
            if (this.j) {
                jSONObject2.remove("render_type");
                jSONObject2.remove("render_type_2");
                a("load_fail_main", jSONObject2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i() {
        /*
            r1 = this;
            boolean r0 = r1.A
            if (r0 == 0) goto L_0x0010
            com.bytedance.sdk.openadsdk.core.model.q r0 = r1.n
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.bu()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.j.i():boolean");
    }

    private String c(String str) {
        return "javascript:" + str;
    }

    public void a(WebView webView, int i2, String str, String str2, String str3, boolean z2) {
        e eVar = this.z;
        if (eVar != null) {
            eVar.a((JSONObject) null);
        }
        if (!(str3 != null && str3.startsWith("image")) && this.d != 2) {
            this.d = 3;
        }
        this.i = i2;
        this.k = str;
        this.l = str2;
        this.j = z2;
    }

    public void g() {
        l.b("LandingPageLog", "onResume");
        if (this.t == 0) {
            this.t = System.currentTimeMillis();
        }
        this.p = System.currentTimeMillis();
    }

    public void h() {
        l.b("LandingPageLog", "onStop");
        if ("landingpage".equals(this.o) || "landingpage_endcard".equals(this.o) || "landingpage_split_screen".equals(this.o) || "landingpage_direct".equals(this.o)) {
            if (!(this.d == 2)) {
                return;
            }
            if (this.q > 0 || !c()) {
                long currentTimeMillis = System.currentTimeMillis() - Math.max(this.p, this.q);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.d);
                    jSONObject.put("max_scroll_percent", this.w.get());
                    jSONObject.put("jump_times", this.D.getAndSet(0));
                    jSONObject.put("click_times", this.E.getAndSet(0));
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                this.h.set(true);
                a("stay_page", jSONObject, Math.min(currentTimeMillis, 600000));
            }
        }
    }

    public void a(SSWebView sSWebView) {
        int ab;
        Bitmap a2;
        q qVar;
        if (("landingpage".equals(this.o) || "landingpage_endcard".equals(this.o) || "landingpage_split_screen".equals(this.o) || "landingpage_direct".equals(this.o)) && (ab = o.d().ab()) != 0 && new Random().nextInt(100) + 1 <= ab && sSWebView != null && sSWebView.getWebView() != null && sSWebView.getVisibility() == 0 && (a2 = ad.a(sSWebView)) != null && (qVar = this.n) != null) {
            ad.a(qVar, this.o, "landing_page_blank", a2, sSWebView.getUrl(), this.c);
        }
    }

    public void c(boolean z2) {
        l.b("LandingPageLog", "onDestroy");
        WebView webView = this.x;
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e2) {
                l.c("LandingPageLog", "removeJavascriptInterface exception", e2);
            }
        }
        if (this.f.compareAndSet(false, true)) {
            a(z2, "1");
            c.a(this.n, this.o, System.currentTimeMillis() - this.t, this.H, j());
        } else if (this.d == 2 && !this.h.get()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.d);
                jSONObject.put("max_scroll_percent", this.w.get());
                jSONObject.put("jump_times", this.D.getAndSet(0));
                jSONObject.put("click_times", this.E.getAndSet(0));
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            a("stay_page", jSONObject, 0);
        }
        this.x = null;
    }

    private void a(String str, JSONObject jSONObject) {
        a(str, jSONObject, -1);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[Catch:{ JSONException -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, org.json.JSONObject r8, long r9) {
        /*
            r6 = this;
            boolean r0 = r6.y
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r6.n
            if (r0 == 0) goto L_0x0059
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            r0 = 0
            if (r8 == 0) goto L_0x0052
            java.lang.String r1 = "is_playable"
            com.bytedance.sdk.openadsdk.core.model.q r2 = r6.n     // Catch:{ JSONException -> 0x0038 }
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.t.b(r2)     // Catch:{ JSONException -> 0x0038 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0021
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            r8.put(r1, r2)     // Catch:{ JSONException -> 0x0038 }
            java.lang.String r1 = "usecache"
            com.bytedance.sdk.openadsdk.core.video.b.a r2 = com.bytedance.sdk.openadsdk.core.video.b.a.a()     // Catch:{ JSONException -> 0x0038 }
            com.bytedance.sdk.openadsdk.core.model.q r5 = r6.n     // Catch:{ JSONException -> 0x0038 }
            boolean r2 = r2.a((com.bytedance.sdk.openadsdk.core.model.q) r5)     // Catch:{ JSONException -> 0x0038 }
            if (r2 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0038 }
        L_0x0038:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0052 }
            r1.<init>()     // Catch:{ JSONException -> 0x0052 }
            java.lang.String r0 = "ad_extra_data"
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0051 }
            r1.put(r0, r8)     // Catch:{ JSONException -> 0x0051 }
            r2 = 0
            int r8 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0051
            java.lang.String r8 = "duration"
            r1.put(r8, r9)     // Catch:{ JSONException -> 0x0051 }
        L_0x0051:
            r0 = r1
        L_0x0052:
            com.bytedance.sdk.openadsdk.core.model.q r8 = r6.n
            java.lang.String r9 = r6.o
            com.bytedance.sdk.openadsdk.b.c.c(r8, r9, r7, r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.j.a(java.lang.String, org.json.JSONObject, long):void");
    }

    /* compiled from: LandingPageLog */
    private class a {
        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        private a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            j.this.w.set(i);
        }
    }

    public void a(int i2) {
        if (this.C == 0) {
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.E.incrementAndGet();
            if (!this.F.getAndSet(true)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.n.P());
                } catch (JSONException unused) {
                }
                a("click_time", jSONObject, Math.max(SystemClock.elapsedRealtime() - this.C, 0));
            }
        }
    }

    private void a(boolean z2, final String str) {
        if (z2) {
            final int j2 = j();
            c.a((h) new h("sendPrefLog") {
                public void run() {
                    try {
                        f z = o.d().z();
                        boolean a2 = j.this.a(z, str);
                        if (a2) {
                            if (!TextUtils.isEmpty(f.b)) {
                                j.this.a(j2, str);
                            } else if (!TextUtils.isEmpty(z.c) && a2) {
                                String str = z.c;
                                b c2 = c.a().b().c();
                                c2.a(str);
                                HashMap hashMap = new HashMap();
                                hashMap.put("content-type", "application/json; charset=utf-8");
                                c2.d(hashMap);
                                c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                                    public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                                        try {
                                            f.b = bVar.d();
                                            j.this.a(j2, str);
                                        } catch (Exception e) {
                                            l.c("LandingPageLog", "TTWebViewClient : onPageFinished", e);
                                        }
                                    }

                                    public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                                        l.b("send landing page js error", iOException.toString());
                                    }
                                });
                            }
                        }
                    } catch (Throwable th) {
                        l.d(th.getMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        try {
            if (!TextUtils.isEmpty(f.b)) {
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder(f.b);
                jSONObject.putOpt(CmcdConfiguration.KEY_CONTENT_ID, a().Y());
                jSONObject.putOpt("ad_id", a().Y());
                jSONObject.put("log_extra", a().ac());
                ac.a(sb, "\"/** adInfo **/\"", jSONObject.toString());
                ac.a(sb, "\"/** first_page **/\"", String.valueOf(i2));
                String str2 = "0";
                ac.a(sb, "\"/** ix_to_externalurl **/\"", this.c != -1 ? "1" : str2);
                if (this.H == 2) {
                    str2 = "2";
                }
                ac.a(sb, "\"/** preload_status **/\"", str2);
                ac.a(sb, "\"/** scene_state **/\"", str);
                ac.a(sb, "\"/** web_init_time **/\"", String.valueOf(this.N));
                ac.a(sb, "\"/** channel_name **/\"", "\"" + a().af() + "\"");
                ac.a(sb, "\"/** session_id **/\"", "\"" + UUID.randomUUID().toString() + "\"");
                ac.a(sb, "\"/** web_url **/\"", "\"" + a().P() + "\"");
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    final String c2 = c(sb2);
                    if (!TextUtils.isEmpty(c2) && this.x != null) {
                        aa.a((Runnable) new Runnable() {
                            public void run() {
                                k.a(j.this.x, c2);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
    }

    private int j() {
        WebView webView = this.x;
        if (webView == null) {
            return 0;
        }
        try {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            if (copyBackForwardList == null || copyBackForwardList.getCurrentIndex() != 0) {
                return 0;
            }
            return 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(f fVar, String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return fVar.d;
            case 1:
                return fVar.e;
            case 2:
                return fVar.f;
            default:
                return false;
        }
    }
}
