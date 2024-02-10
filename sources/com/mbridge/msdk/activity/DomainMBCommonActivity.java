package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.NativeListener;

public class DomainMBCommonActivity extends Activity {
    String a = "";
    private CampaignEx b;
    protected BrowserView browserView;
    private BrowserView.a c = new BrowserView.a() {
        public final void a(WebView webView, int i, String str, String str2) {
        }

        public final void a(WebView webView, String str) {
        }

        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        public final void a(WebView webView, String str, Bitmap bitmap) {
            aa.d("MBCommonActivity", "onPageStarted  " + str);
        }

        public final boolean b(WebView webView, String str) {
            aa.d("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (ae.a.a(str) && ae.a.a(DomainMBCommonActivity.this, str, (NativeListener.NativeTrackingListener) null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        public final void c(WebView webView, String str) {
            aa.d("MBCommonActivity", "onPageFinished  " + str);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            aa.d("MBCommonActivity", th.getMessage());
        }
        if (b.d().g() == null) {
            b.d().b(getApplicationContext());
        }
        b.d().a((Context) this);
        String stringExtra = getIntent().getStringExtra("url");
        this.a = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.b = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            if (com.mbridge.msdk.foundation.webview.b.a.containsKey(this.a)) {
                BrowserView browserView2 = com.mbridge.msdk.foundation.webview.b.a.get(this.a);
                this.browserView = browserView2;
                if (browserView2 != null) {
                    browserView2.setListener(this.c);
                }
            } else {
                BrowserView browserView3 = new BrowserView((Context) this, this.b);
                this.browserView = browserView3;
                browserView3.setListener(this.c);
                this.browserView.loadUrl(this.a);
            }
            BrowserView browserView4 = this.browserView;
            if (browserView4 != null) {
                ao.a(browserView4);
                setContentView(this.browserView);
                return;
            }
            return;
        }
        Toast.makeText(this, "Error: no data", 0).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[Catch:{ all -> 0x005e, all -> 0x00c4 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[Catch:{ all -> 0x005e, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0090 A[Catch:{ all -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "http"
            java.lang.String r1 = "MBCommonActivity"
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x000c
            return r2
        L_0x000c:
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = r3.getScheme()     // Catch:{ all -> 0x00c4 }
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = "https"
            r6 = 1
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = r3.getScheme()     // Catch:{ all -> 0x00c4 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00c4 }
            if (r4 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r4 = 0
            goto L_0x002b
        L_0x002a:
            r4 = 1
        L_0x002b:
            if (r4 == 0) goto L_0x002e
            return r2
        L_0x002e:
            java.lang.String r3 = r3.getScheme()     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = "intent"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x009e
            android.content.Intent r3 = android.content.Intent.parseUri(r10, r6)     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = r3.getPackage()     // Catch:{ all -> 0x005e }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x005e }
            if (r7 != 0) goto L_0x0066
            android.content.pm.PackageManager r7 = r8.getPackageManager()     // Catch:{ all -> 0x005e }
            android.content.Intent r4 = r7.getLaunchIntentForPackage(r4)     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0066
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r3.setFlags(r4)     // Catch:{ all -> 0x005e }
            r8.startActivityForResult(r3, r2)     // Catch:{ all -> 0x005e }
            r8.finish()     // Catch:{ all -> 0x005e }
            return r6
        L_0x005e:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00c4 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r4)     // Catch:{ all -> 0x00c4 }
        L_0x0066:
            java.lang.String r4 = "browser_fallback_url"
            java.lang.String r3 = r3.getStringExtra(r4)     // Catch:{ all -> 0x0096 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0096 }
            if (r4 != 0) goto L_0x009e
            android.net.Uri r4 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x0096 }
            java.lang.String r7 = r4.getScheme()     // Catch:{ all -> 0x0096 }
            boolean r7 = r7.equals(r0)     // Catch:{ all -> 0x0096 }
            if (r7 != 0) goto L_0x008d
            java.lang.String r4 = r4.getScheme()     // Catch:{ all -> 0x0096 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0096 }
            if (r4 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r4 = 0
            goto L_0x008e
        L_0x008d:
            r4 = 1
        L_0x008e:
            if (r4 == 0) goto L_0x0094
            r9.loadUrl(r3)     // Catch:{ all -> 0x0096 }
            return r2
        L_0x0094:
            r10 = r3
            goto L_0x009e
        L_0x0096:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00c4 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r9)     // Catch:{ all -> 0x00c4 }
        L_0x009e:
            boolean r9 = com.mbridge.msdk.click.b.d(r8, r10)     // Catch:{ all -> 0x00c4 }
            if (r9 == 0) goto L_0x00ad
            java.lang.String r9 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.aa.d(r1, r9)     // Catch:{ all -> 0x00c4 }
            r8.finish()     // Catch:{ all -> 0x00c4 }
            return r6
        L_0x00ad:
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x00c3
            boolean r9 = r10.startsWith(r0)     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x00bf
            boolean r9 = r10.startsWith(r5)     // Catch:{ all -> 0x00c4 }
            if (r9 == 0) goto L_0x00c0
        L_0x00bf:
            r2 = 1
        L_0x00c0:
            r9 = r2 ^ 1
            return r9
        L_0x00c3:
            return r2
        L_0x00c4:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }
}
