package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.NativeListener;

/* compiled from: BackPointBrowserViewListener */
public class a implements BrowserView.a {
    /* access modifiers changed from: private */
    public static String a = "a";
    /* access modifiers changed from: private */
    public Context b;
    /* access modifiers changed from: private */
    public BaseTrackingListener c;
    /* access modifiers changed from: private */
    public CampaignEx d;
    private boolean e = true;
    private BrowserView f;
    private Handler g;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.click.a h;
    private long i;
    /* access modifiers changed from: private */
    public int j = 10000;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public JumpLoaderResult l = null;
    /* access modifiers changed from: private */
    public String m;
    private boolean n;
    private final Runnable o = new Runnable() {
        public final void run() {
            String b = a.a;
            aa.d(b, "webview js！超时上限：" + a.this.j + "ms");
            if (!(a.this.h == null || a.this.l == null)) {
                a.this.l.setSuccess(false);
                a.this.l.setUrl(a.this.m);
                a.this.l.setType(2);
                a.this.l.setExceptionMsg("linktype 8 time out");
                a.this.h.a(a.this.l, a.this.d, 1, false);
            }
            a aVar = a.this;
            if (aVar.d((WebView) null, aVar.m) && !a.this.k) {
                boolean unused = a.this.k = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.b, a.this.m, a.this.d);
            }
            if (a.this.c != null) {
                a.this.c.onFinishRedirection(a.this.d, a.this.m);
            }
        }
    };

    public final void a() {
    }

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.b = context;
        this.d = campaignEx;
        this.f = browserView;
        this.c = baseTrackingListener;
        this.g = new Handler(Looper.getMainLooper());
        e b2 = f.a().b(b.d().h());
        b2 = b2 == null ? f.a().b() : b2;
        this.h = aVar;
        this.l = new JumpLoaderResult();
        this.j = (int) b2.aa();
    }

    public final void a(WebView webView, String str) {
        if (this.i == 0) {
            this.i = System.currentTimeMillis();
            if (!this.n) {
                this.n = true;
                c();
            }
        }
        this.m = str;
        this.e = true;
    }

    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.i == 0) {
            this.i = System.currentTimeMillis();
            if (!this.n) {
                this.n = true;
                c();
            }
            this.k = false;
        }
        this.m = str;
        this.e = true;
    }

    public final boolean b(WebView webView, final String str) {
        String str2 = a;
        aa.d(str2, "shouldOverrideUrlLoading1  " + str);
        this.e = false;
        if (ae.a.a(str) && ae.a.a(this.b, str, (NativeListener.NativeTrackingListener) null)) {
            this.k = true;
        }
        boolean e2 = e(webView, str);
        if (e2) {
            this.i = 0;
            this.e = false;
            d();
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    if (!(a.this.h == null || a.this.l == null)) {
                        a.this.l.setSuccess(true);
                        a.this.l.setUrl(str);
                        a.this.l.setType(2);
                        a.this.h.a(a.this.l, a.this.d, 1, true);
                    }
                    if (a.this.c != null) {
                        a.this.c.onFinishRedirection(a.this.d, str);
                    }
                }
            });
        }
        return e2;
    }

    public final void c(WebView webView, final String str) {
        String str2 = a;
        aa.d(str2, "onPageFinished1  " + str);
        if (this.e) {
            this.i = 0;
            boolean z = false;
            this.e = false;
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    if (a.this.c != null) {
                        a.this.c.onFinishRedirection(a.this.d, str);
                    }
                    if (a.this.h != null && a.this.l != null) {
                        a.this.l.setSuccess(true);
                        a.this.l.setUrl(str);
                        a.this.l.setType(2);
                        a.this.h.a(a.this.l, a.this.d, 1, true);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                d();
                Uri parse = Uri.parse(str);
                if (parse.getScheme().equals("http") || parse.getScheme().equals(ProxyConfig.MATCH_HTTPS)) {
                    z = true;
                }
                if (z && !this.k) {
                    this.k = true;
                    a(this.b, str, this.d);
                }
            }
        }
    }

    public final void a(WebView webView, int i2, final String str, final String str2) {
        aa.c(a, str);
        d();
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
            public final void run() {
                if (a.this.c != null) {
                    a.this.c.onFinishRedirection(a.this.d, str2);
                }
                if (a.this.h != null && a.this.l != null) {
                    a.this.l.setSuccess(false);
                    a.this.l.setUrl(str2);
                    a.this.l.setType(2);
                    a.this.l.setExceptionMsg(str);
                    a.this.h.a(a.this.l, a.this.d, 1, true);
                }
            }
        });
        if (d(webView, str2) && !this.k) {
            this.k = true;
            a(this.b, str2, this.d);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context != null) {
            try {
                Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
                Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
                if (!TextUtils.isEmpty(str)) {
                    b.a.put(str, this.f);
                    if (ae.a.b(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    aa.b("url", "webview url = " + str);
                    intent.setFlags(805306368);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                }
            } catch (Exception unused) {
                ae.a(context, str, this.c, campaignEx != null ? campaignEx.getCurrentLRid() : "");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[Catch:{ all -> 0x0053, all -> 0x00a5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[Catch:{ all -> 0x0053, all -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(android.webkit.WebView r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r7 = "http"
            r0 = 1
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x000a
            return r0
        L_0x000a:
            android.net.Uri r1 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = r1.getScheme()     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "https"
            r4 = 0
            if (r2 != 0) goto L_0x0028
            java.lang.String r2 = r1.getScheme()     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r2 = 0
            goto L_0x0029
        L_0x0028:
            r2 = 1
        L_0x0029:
            if (r2 == 0) goto L_0x002c
            return r0
        L_0x002c:
            java.lang.String r1 = r1.getScheme()     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = "intent"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0094
            android.content.Intent r1 = android.content.Intent.parseUri(r8, r0)     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = r1.getPackage()     // Catch:{ all -> 0x0053 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0053 }
            if (r5 != 0) goto L_0x005d
            android.content.Context r5 = r6.b     // Catch:{ all -> 0x0053 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x0053 }
            android.content.Intent r2 = r5.getLaunchIntentForPackage(r2)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x005d
            return r4
        L_0x0053:
            r2 = move-exception
            java.lang.String r5 = a     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00a5 }
            com.mbridge.msdk.foundation.tools.aa.d(r5, r2)     // Catch:{ all -> 0x00a5 }
        L_0x005d:
            java.lang.String r2 = "browser_fallback_url"
            java.lang.String r1 = r1.getStringExtra(r2)     // Catch:{ all -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x008a }
            if (r2 != 0) goto L_0x0094
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x008a }
            java.lang.String r5 = r2.getScheme()     // Catch:{ all -> 0x008a }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x0084
            java.lang.String r7 = r2.getScheme()     // Catch:{ all -> 0x008a }
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r7 = 0
            goto L_0x0085
        L_0x0084:
            r7 = 1
        L_0x0085:
            if (r7 == 0) goto L_0x0088
            return r0
        L_0x0088:
            r8 = r1
            goto L_0x0094
        L_0x008a:
            r7 = move-exception
            java.lang.String r1 = a     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00a5 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r7)     // Catch:{ all -> 0x00a5 }
        L_0x0094:
            android.content.Context r7 = r6.b     // Catch:{ all -> 0x00a5 }
            boolean r7 = com.mbridge.msdk.click.b.d(r7, r8)     // Catch:{ all -> 0x00a5 }
            if (r7 == 0) goto L_0x00a4
            java.lang.String r7 = a     // Catch:{ all -> 0x00a5 }
            java.lang.String r8 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.aa.d(r7, r8)     // Catch:{ all -> 0x00a5 }
            return r4
        L_0x00a4:
            return r0
        L_0x00a5:
            r7 = move-exception
            java.lang.String r8 = a
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.a.d(android.webkit.WebView, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[Catch:{ all -> 0x005f, all -> 0x00b6 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[Catch:{ all -> 0x005f, all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093 A[Catch:{ all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(android.webkit.WebView r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "http"
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x000a
            return r1
        L_0x000a:
            android.net.Uri r2 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = r2.getScheme()     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = "https"
            r5 = 1
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = r2.getScheme()     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r3 = 0
            goto L_0x0029
        L_0x0028:
            r3 = 1
        L_0x0029:
            if (r3 == 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.String r2 = r2.getScheme()     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = "intent"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x00a3
            android.content.Intent r2 = android.content.Intent.parseUri(r9, r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = r2.getPackage()     // Catch:{ all -> 0x005f }
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x005f }
            if (r6 != 0) goto L_0x0069
            android.content.Context r6 = r7.b     // Catch:{ all -> 0x005f }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ all -> 0x005f }
            android.content.Intent r3 = r6.getLaunchIntentForPackage(r3)     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0069
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r2.setFlags(r3)     // Catch:{ all -> 0x005f }
            android.content.Context r3 = r7.b     // Catch:{ all -> 0x005f }
            r3.startActivity(r2)     // Catch:{ all -> 0x005f }
            r7.k = r5     // Catch:{ all -> 0x005f }
            return r5
        L_0x005f:
            r3 = move-exception
            java.lang.String r6 = a     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00b6 }
            com.mbridge.msdk.foundation.tools.aa.d(r6, r3)     // Catch:{ all -> 0x00b6 }
        L_0x0069:
            java.lang.String r3 = "browser_fallback_url"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ all -> 0x0099 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x00a3
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = r3.getScheme()     // Catch:{ all -> 0x0099 }
            boolean r0 = r6.equals(r0)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0090
            java.lang.String r0 = r3.getScheme()     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            r0 = 0
            goto L_0x0091
        L_0x0090:
            r0 = 1
        L_0x0091:
            if (r0 == 0) goto L_0x0097
            r8.loadUrl(r2)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x0097:
            r9 = r2
            goto L_0x00a3
        L_0x0099:
            r8 = move-exception
            java.lang.String r0 = a     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00b6 }
            com.mbridge.msdk.foundation.tools.aa.d(r0, r8)     // Catch:{ all -> 0x00b6 }
        L_0x00a3:
            android.content.Context r8 = r7.b     // Catch:{ all -> 0x00b6 }
            boolean r8 = com.mbridge.msdk.click.b.d(r8, r9)     // Catch:{ all -> 0x00b6 }
            if (r8 == 0) goto L_0x00b5
            java.lang.String r8 = a     // Catch:{ all -> 0x00b6 }
            java.lang.String r9 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.aa.d(r8, r9)     // Catch:{ all -> 0x00b6 }
            r7.k = r5     // Catch:{ all -> 0x00b6 }
            return r5
        L_0x00b5:
            return r1
        L_0x00b6:
            r8 = move-exception
            java.lang.String r9 = a
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.a.e(android.webkit.WebView, java.lang.String):boolean");
    }

    private void c() {
        this.g.postDelayed(this.o, (long) this.j);
    }

    private void d() {
        this.g.removeCallbacks(this.o);
    }
}
