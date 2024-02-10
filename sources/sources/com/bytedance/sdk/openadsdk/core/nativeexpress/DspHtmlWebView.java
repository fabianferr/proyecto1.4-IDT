package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.g.e;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.facebook.internal.NativeProtocol;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class DspHtmlWebView extends SSWebView implements b.c {
    protected boolean a = false;
    protected boolean b = false;
    AtomicBoolean c = new AtomicBoolean(false);
    AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public o e;
    private c f;
    /* access modifiers changed from: private */
    public q g;
    /* access modifiers changed from: private */
    public String h;
    private int i = 0;
    /* access modifiers changed from: private */
    public List<String> j;
    private b k;
    /* access modifiers changed from: private */
    public int l;
    private long m;

    public interface b {
        View a();

        void a(int i, int i2);

        void a(View view, int i);

        View b();

        void b_();
    }

    public DspHtmlWebView(Context context) {
        super(context);
    }

    public void a(q qVar, b bVar, String str) {
        this.k = bVar;
        this.g = qVar;
        this.h = str;
        this.f = new c();
        this.e = new o(getContext());
        setWebViewClient(new a(this));
        setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                int unused = DspHtmlWebView.this.l = i;
                super.onProgressChanged(webView, i);
                if (i >= 100) {
                    DspHtmlWebView.this.a();
                }
            }
        });
        h.b().post(new Runnable() {
            public void run() {
                WebView webView = DspHtmlWebView.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            DspHtmlWebView.this.e.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    private void q() {
        if (this.j == null) {
            com.bytedance.sdk.openadsdk.b.c.b(this.g, this.h, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.component.g.h) new com.bytedance.sdk.component.g.h("dsp_html_error_url") {
                public void run() {
                    try {
                        if (DspHtmlWebView.this.j != null && DspHtmlWebView.this.d.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            for (String put : DspHtmlWebView.this.j) {
                                jSONArray.put(put);
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.b.c.b(DspHtmlWebView.this.g, DspHtmlWebView.this.h, "dsp_html_error_url", jSONObject);
                            List unused = DspHtmlWebView.this.j = null;
                        }
                    } catch (Exception unused2) {
                    }
                }
            });
        }
    }

    public void l() {
        super.l();
        this.f.b();
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.f.a(view, friendlyObstructionPurpose);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a) {
            this.f.a(getWebView());
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        boolean z = i2 == 0;
        this.b = z;
        this.f.a(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", (double) (((float) this.l) / 100.0f));
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.b.c.b(this.g, this.h, "load_rate", jSONObject);
        this.f.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r21) {
        /*
            r20 = this;
            r0 = r20
            boolean r1 = android.text.TextUtils.isEmpty(r21)
            if (r1 != 0) goto L_0x0119
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.g
            if (r1 != 0) goto L_0x000e
            goto L_0x0119
        L_0x000e:
            com.bytedance.sdk.openadsdk.core.nativeexpress.o r1 = r0.e
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.String r1 = r0.h
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.a((java.lang.String) r1)
            boolean r2 = com.bytedance.sdk.component.utils.o.a((java.lang.String) r21)
            r10 = 0
            if (r2 != 0) goto L_0x004d
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.g
            com.bytedance.sdk.openadsdk.core.model.j r2 = r2.ab()
            if (r2 == 0) goto L_0x003c
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.g
            com.bytedance.sdk.openadsdk.core.model.j r2 = r2.ab()
            java.lang.String r2 = r2.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x004d
        L_0x003c:
            com.bytedance.sdk.openadsdk.core.model.j r2 = new com.bytedance.sdk.openadsdk.core.model.j
            r2.<init>()
            r3 = r21
            r2.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.g
            r3.a((com.bytedance.sdk.openadsdk.core.model.j) r2)
            r8 = r10
            goto L_0x0050
        L_0x004d:
            r3 = r21
            r8 = r3
        L_0x0050:
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.g
            r11 = 1
            r2.a((boolean) r11)
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.g
            if (r2 == 0) goto L_0x00a6
            com.bytedance.sdk.openadsdk.core.model.j r2 = r2.ab()
            if (r2 == 0) goto L_0x00a6
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.g
            com.bytedance.sdk.openadsdk.core.model.j r2 = r2.ab()
            java.lang.String r2 = r2.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00a6
            android.content.Context r2 = r20.getContext()
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.g
            java.lang.String r5 = r0.h
            r6 = 1
            r7 = 0
            r4 = r1
            boolean r2 = com.bytedance.sdk.openadsdk.core.z.a((android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.q) r3, (int) r4, (java.lang.String) r5, (boolean) r6, (java.util.Map<java.lang.String, java.lang.Object>) r7)
            if (r2 != 0) goto L_0x00a7
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.g
            com.bytedance.sdk.openadsdk.core.model.j r3 = r3.ab()
            java.lang.String r3 = r3.b()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00a7
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.g
            com.bytedance.sdk.openadsdk.core.model.j r3 = r3.ab()
            java.lang.String r3 = r3.b()
            com.bytedance.sdk.openadsdk.core.model.q r4 = r0.g
            java.lang.String r5 = r0.h
            java.lang.String r6 = "open_fallback_url"
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r4, (java.lang.String) r5, (java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.Object>) r10)
            r9 = r3
            goto L_0x00a8
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            r9 = r8
        L_0x00a8:
            if (r2 != 0) goto L_0x00c1
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x00c0
            android.content.Context r2 = r20.getContext()
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.g
            r5 = 0
            r6 = 0
            java.lang.String r7 = r0.h
            r8 = 1
            r4 = r1
            com.bytedance.sdk.openadsdk.core.z.a((android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.q) r3, (int) r4, (com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r5, (com.bytedance.sdk.openadsdk.api.PangleAd) r6, (java.lang.String) r7, (boolean) r8, (java.lang.String) r9)
            goto L_0x00c1
        L_0x00c0:
            return
        L_0x00c1:
            com.bytedance.sdk.openadsdk.core.nativeexpress.o r1 = r0.e
            if (r1 == 0) goto L_0x0112
            com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView$b r1 = r0.k
            r2 = 2
            if (r1 == 0) goto L_0x00df
            android.view.View r10 = r1.a()
            com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView$b r1 = r0.k
            android.view.View r1 = r1.b()
            com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView$b r3 = r0.k
            r3.a((android.view.View) r0, (int) r2)
            r19 = r10
            r10 = r1
            r1 = r19
            goto L_0x00e0
        L_0x00df:
            r1 = r10
        L_0x00e0:
            com.bytedance.sdk.openadsdk.core.nativeexpress.o r3 = r0.e
            android.content.Context r4 = r20.getContext()
            com.bytedance.sdk.openadsdk.core.model.i r14 = r3.a(r4, r10, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "click_scence"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r1.put(r3, r4)
            java.lang.String r12 = "click"
            com.bytedance.sdk.openadsdk.core.model.q r13 = r0.g
            java.lang.String r15 = r0.h
            r16 = 1
            com.bytedance.sdk.openadsdk.core.nativeexpress.o r3 = r0.e
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x010b
            r18 = 1
            goto L_0x010d
        L_0x010b:
            r18 = 2
        L_0x010d:
            r17 = r1
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r12, (com.bytedance.sdk.openadsdk.core.model.q) r13, (com.bytedance.sdk.openadsdk.core.model.i) r14, (java.lang.String) r15, (boolean) r16, (java.util.Map<java.lang.String, java.lang.Object>) r17, (int) r18)
        L_0x0112:
            com.bytedance.sdk.openadsdk.core.nativeexpress.o r1 = r0.e
            if (r1 == 0) goto L_0x0119
            r1.a()
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.a(java.lang.String):void");
    }

    public void o() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.b_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.m);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.b.c.b(this.g, this.h, "render_html_success", jSONObject);
    }

    public void a(int i2, int i3) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
        this.i = i3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i3);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.m);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.b.c.b(this.g, this.h, "render_html_fail", jSONObject);
    }

    public void b(String str) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(str);
    }

    public void a() {
        if (this.c.compareAndSet(false, true)) {
            this.a = true;
            this.f.a(getWebView());
            this.f.a(this.b);
            o();
            q();
        }
    }

    public void p() {
        this.c.set(false);
        String aw = this.g.aw();
        if (!TextUtils.isEmpty(aw)) {
            String a2 = e.a(aw);
            String str = TextUtils.isEmpty(a2) ? aw : a2;
            this.i = 0;
            a((String) null, str, "text/html", "UTF-8", (String) null);
            this.m = SystemClock.elapsedRealtime();
        }
    }

    static class a extends SSWebView.a {
        public static final Set<String> a = new HashSet<String>() {
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        b.c b;

        public a(b.c cVar) {
            this.b = cVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.b.a(str);
            return true;
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest != null && webResourceResponse != null && Build.VERSION.SDK_INT >= 21 && webResourceRequest.getUrl() != null) {
                if (webResourceRequest.isForMainFrame()) {
                    a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
                }
                a(webResourceRequest.getUrl().toString());
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (Build.VERSION.SDK_INT < 21) {
                a(str2, i, str);
                a(str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 21 && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                a(webResourceRequest.getUrl().toString());
            }
        }

        private void a(String str) {
            int lastIndexOf;
            b.c cVar;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) > 0) {
                if (a.contains(str.substring(lastIndexOf).toLowerCase()) && (cVar = this.b) != null) {
                    cVar.b(str);
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b.c cVar = this.b;
            if (cVar != null) {
                cVar.a();
            }
        }

        private void a(String str, int i, String str2) {
            b.c cVar = this.b;
            if (cVar != null) {
                cVar.a(106, i);
            }
        }
    }

    public static class c {
        protected int a = 0;
        private f b = f.a();

        c() {
        }

        public void a(WebView webView) {
            if (webView != null && this.a == 0) {
                if (this.b == null) {
                    this.b = f.a();
                }
                this.b.a(webView);
                this.b.b();
                this.a = 1;
            }
        }

        public void a(boolean z) {
            f fVar;
            if (this.a == 1 && z && (fVar = this.b) != null) {
                fVar.c();
                this.a = 3;
            }
        }

        public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            f fVar = this.b;
            if (fVar != null) {
                fVar.a(view, friendlyObstructionPurpose);
            }
        }

        public void a() {
            f fVar;
            int i = this.a;
            if (!(i == 0 || i == 4 || (fVar = this.b) == null)) {
                fVar.d();
            }
            this.a = 4;
            this.b = null;
        }

        public void b() {
            a();
        }
    }
}
