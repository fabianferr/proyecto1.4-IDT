package com.mbridge.msdk.click;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;

/* compiled from: WebViewSpider */
public class l {
    public static long a = 0;
    /* access modifiers changed from: private */
    public static final String d = "l";
    boolean b;
    boolean c;
    private int e = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
    private int f = 3000;
    private Handler g = new Handler(Looper.getMainLooper());
    private e h;
    /* access modifiers changed from: private */
    public a i;
    /* access modifiers changed from: private */
    public String j;
    private String k;
    /* access modifiers changed from: private */
    public WebView l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q;
    private final Runnable r = new Runnable() {
        public final void run() {
            boolean unused = l.this.p = true;
            int unused2 = l.this.o = 1;
            l.m(l.this);
        }
    };
    private final Runnable s = new Runnable() {
        public final void run() {
            boolean unused = l.this.p = true;
            int unused2 = l.this.o = 2;
            l.m(l.this);
        }
    };

    /* compiled from: WebViewSpider */
    interface a {
        void a(int i, String str, String str2, String str3);

        void a(String str, boolean z, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public l() {
        e b2 = f.a().b(b.d().h());
        this.h = b2;
        if (b2 == null) {
            this.h = f.a().b();
        }
        this.m = this.h.V();
        this.e = (int) this.h.aa();
        this.f = (int) this.h.aa();
    }

    public final void a(String str, String str2, Context context, String str3, String str4, a aVar) {
        if (aVar != null) {
            this.k = str4;
            this.j = str3;
            this.i = aVar;
            a(str, str2, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    public final void a(String str, String str2, Context context, String str3, a aVar) {
        if (aVar != null) {
            this.j = str3;
            this.i = aVar;
            a(str, str2, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    private void a(final String str, final String str2, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.j);
        } else {
            this.g.post(new Runnable() {
                public final void run() {
                    l lVar = l.this;
                    lVar.a(str, str2, context, lVar.j);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.k)) {
                this.l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f = 2000;
                this.e = 2000;
                aa.b(d, this.k);
                this.l.loadDataWithBaseURL(str3, this.k, "*/*", "utf-8", str3);
            } else if (this.m) {
                HashMap hashMap = new HashMap();
                if (this.l.getUrl() != null) {
                    hashMap.put("Referer", this.l.getUrl());
                }
                this.l.loadUrl(str3, hashMap);
            } else {
                this.l.loadUrl(str3);
            }
        } catch (Throwable th) {
            try {
                a aVar = this.i;
                if (aVar != null) {
                    aVar.a(0, this.j, th.getMessage(), this.n);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(final Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.l.getSettings().setCacheMode(2);
        this.l.getSettings().setLoadsImagesAutomatically(false);
        this.l.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (l.this.q) {
                        int unused = l.this.o = 0;
                        l.c(l.this);
                        return;
                    }
                    l.this.c = false;
                    if (webView.getTag() == null) {
                        webView.setTag("has_first_started");
                    } else {
                        l.this.b = true;
                    }
                    synchronized (l.d) {
                        String unused2 = l.this.j = str;
                        if (l.this.i == null || !l.this.i.a(str)) {
                            l.e(l.this);
                        } else {
                            boolean unused3 = l.this.q = true;
                            l.c(l.this);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
                if (com.mbridge.msdk.click.l.h(r3.d) == false) goto L_0x0080;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
                r4 = new java.util.HashMap();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
                if (com.mbridge.msdk.click.l.i(r3.d).getUrl() == null) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
                r4.put("Referer", com.mbridge.msdk.click.l.i(r3.d).getUrl());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
                com.mbridge.msdk.click.l.i(r3.d).loadUrl(r5, r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
                com.mbridge.msdk.click.l.i(r3.d).loadUrl(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
                return true;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
                /*
                    r3 = this;
                    java.lang.String r4 = com.mbridge.msdk.click.l.d
                    monitor-enter(r4)
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    r1 = 1
                    r0.c = r1     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    r0.d()     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    boolean r0 = r0.q     // Catch:{ all -> 0x008a }
                    if (r0 == 0) goto L_0x0023
                    com.mbridge.msdk.click.l r5 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    r5.c()     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r5 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l.c(r5)     // Catch:{ all -> 0x008a }
                    monitor-exit(r4)     // Catch:{ all -> 0x008a }
                    return r1
                L_0x0023:
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    java.lang.String unused = r0.j = r5     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l$a r0 = r0.i     // Catch:{ all -> 0x008a }
                    if (r0 == 0) goto L_0x004d
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l$a r0 = r0.i     // Catch:{ all -> 0x008a }
                    boolean r0 = r0.b(r5)     // Catch:{ all -> 0x008a }
                    if (r0 == 0) goto L_0x004d
                    com.mbridge.msdk.click.l r5 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    boolean unused = r5.q = r1     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r5 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    r5.c()     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r5 = com.mbridge.msdk.click.l.this     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l.c(r5)     // Catch:{ all -> 0x008a }
                    monitor-exit(r4)     // Catch:{ all -> 0x008a }
                    return r1
                L_0x004d:
                    monitor-exit(r4)     // Catch:{ all -> 0x008a }
                    com.mbridge.msdk.click.l r4 = com.mbridge.msdk.click.l.this
                    boolean r4 = r4.m
                    if (r4 == 0) goto L_0x0080
                    java.util.HashMap r4 = new java.util.HashMap
                    r4.<init>()
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this
                    android.webkit.WebView r0 = r0.l
                    java.lang.String r0 = r0.getUrl()
                    if (r0 == 0) goto L_0x0076
                    java.lang.String r0 = "Referer"
                    com.mbridge.msdk.click.l r2 = com.mbridge.msdk.click.l.this
                    android.webkit.WebView r2 = r2.l
                    java.lang.String r2 = r2.getUrl()
                    r4.put(r0, r2)
                L_0x0076:
                    com.mbridge.msdk.click.l r0 = com.mbridge.msdk.click.l.this
                    android.webkit.WebView r0 = r0.l
                    r0.loadUrl(r5, r4)
                    goto L_0x0089
                L_0x0080:
                    com.mbridge.msdk.click.l r4 = com.mbridge.msdk.click.l.this
                    android.webkit.WebView r4 = r4.l
                    r4.loadUrl(r5)
                L_0x0089:
                    return r1
                L_0x008a:
                    r5 = move-exception
                    monitor-exit(r4)     // Catch:{ all -> 0x008a }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.l.AnonymousClass2.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                synchronized (l.d) {
                    boolean unused = l.this.q = true;
                    l.this.b();
                    l.c(l.this);
                }
                if (l.this.i != null) {
                    l.this.i.a(i, webView.getUrl(), str, l.this.n);
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        new p(context).a(str, str2, webView.getUrl());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.l.setWebChromeClient(new WebChromeClient() {
            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            public final void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    try {
                        webView.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!l.this.q && !l.this.c) {
                            l.l(l.this);
                        }
                        if (l.this.i != null) {
                            l.this.i.c(webView.getUrl());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.g.removeCallbacks(this.s);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.g.removeCallbacks(this.r);
    }

    static /* synthetic */ void c(l lVar) {
        synchronized (d) {
            try {
                lVar.b();
                a aVar = lVar.i;
                if (aVar != null) {
                    aVar.a(lVar.j, lVar.p, lVar.n);
                }
            } catch (Exception e2) {
                aa.d(d, e2.getMessage());
            } catch (Throwable th) {
                aa.d(d, th.getMessage());
            }
        }
    }

    static /* synthetic */ void e(l lVar) {
        lVar.c();
        lVar.g.postDelayed(lVar.s, (long) lVar.e);
    }

    static /* synthetic */ void l(l lVar) {
        lVar.d();
        lVar.g.postDelayed(lVar.r, (long) lVar.f);
    }

    static /* synthetic */ void m(l lVar) {
        synchronized (d) {
            try {
                lVar.b();
                lVar.l.destroy();
                a aVar = lVar.i;
                if (aVar != null) {
                    aVar.a(lVar.j, lVar.p, lVar.n);
                }
            } catch (Exception e2) {
                aa.d(d, e2.getMessage());
            } catch (Throwable th) {
                aa.d(d, th.getMessage());
            }
        }
    }
}
