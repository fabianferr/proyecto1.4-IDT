package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a.d;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.e.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class e extends WebViewClient {
    /* access modifiers changed from: private */
    public final m a;
    private final u b;
    /* access modifiers changed from: private */
    public final b c;

    public e(b bVar, m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        this.c = bVar;
    }

    private void a(PointF pointF) {
        this.c.a(pointF);
    }

    private void a(Uri uri, d dVar) {
        String str;
        u uVar;
        final String queryParameter = uri.getQueryParameter("n");
        if (StringUtils.isValidString(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                if (u.a()) {
                    u uVar2 = this.b;
                    uVar2.b("AdWebView", "Loading new page externally: " + queryParameter);
                }
                Utils.openUri(dVar.getContext(), Uri.parse(queryParameter), this.a);
                j.c(this.c.g(), (AppLovinAd) this.c.p(), this.c.r());
                return;
            } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                if (u.a()) {
                    u uVar3 = this.b;
                    uVar3.b("AdWebView", "Loading new page in WebView: " + queryParameter);
                }
                dVar.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (StringUtils.isValidString(queryParameter3)) {
                    dVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                if (u.a()) {
                    u uVar4 = this.b;
                    uVar4.b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                }
                this.a.af().a(new a() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                            j.a(e.this.c.g(), (AppLovinAd) e.this.c.p(), e.this.c.r());
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            j.b(e.this.c.g(), (AppLovinAd) e.this.c.p(), e.this.c.r());
                            e.this.a.af().b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.a.L(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.a.z());
                intent.setFlags(268435456);
                this.a.L().startActivity(intent);
                return;
            } else if (u.a()) {
                uVar = this.b;
                str = "Could not find load type in original uri";
            } else {
                return;
            }
        } else if (u.a()) {
            uVar = this.b;
            str = "Could not find url to load from query in original uri";
        } else {
            return;
        }
        uVar.e("AdWebView", str);
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.e eVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            String appendQueryParameter = StringUtils.appendQueryParameter(queryParameter, "clcode", eVar.getClCode());
            this.a.U().a(h.o().c(appendQueryParameter).a(false).c(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
        } else if (u.a()) {
            u uVar = this.b;
            uVar.e("AdWebView", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    private void a(com.applovin.impl.a.a aVar, d dVar) {
        d aO = aVar.aO();
        if (aO != null) {
            l.a(aO.c(), this.c.q());
            a(dVar, aO.a());
        }
    }

    private void a(d dVar, Uri uri) {
        com.applovin.impl.sdk.ad.e currentAd = dVar.getCurrentAd();
        AppLovinAdView r = this.c.r();
        if (r != null && currentAd != null) {
            com.applovin.impl.sdk.e.d statsManagerHelper = dVar.getStatsManagerHelper();
            if (statsManagerHelper != null) {
                statsManagerHelper.b();
            }
            if (currentAd instanceof com.applovin.impl.a.a) {
                ((com.applovin.impl.a.a) currentAd).o().o();
            }
            this.c.a(currentAd, r, uri, dVar.getAndClearLastClickLocation());
        } else if (u.a()) {
            u uVar = this.b;
            uVar.e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void b() {
        this.c.l();
    }

    private void c() {
        this.c.k();
    }

    /* access modifiers changed from: protected */
    public b a() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0239, code lost:
        if (r6.aP() != false) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0143, code lost:
        if (r6.aP() != false) goto L_0x023b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.webkit.WebView r11, java.lang.String r12) {
        /*
            r10 = this;
            com.applovin.impl.adview.b r0 = r10.c
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = com.applovin.impl.sdk.u.a()
            java.lang.String r2 = "AdWebView"
            if (r0 == 0) goto L_0x0026
            com.applovin.impl.sdk.u r0 = r10.b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Processing click on ad URL \""
            r3.<init>(r4)
            r3.append(r12)
            java.lang.String r4 = "\""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.c(r2, r3)
        L_0x0026:
            if (r12 == 0) goto L_0x0242
            boolean r0 = r11 instanceof com.applovin.impl.adview.d
            if (r0 == 0) goto L_0x0242
            android.net.Uri r0 = android.net.Uri.parse(r12)
            com.applovin.impl.adview.d r11 = (com.applovin.impl.adview.d) r11
            java.lang.String r3 = r0.getScheme()
            java.lang.String r4 = r0.getHost()
            java.lang.String r5 = r0.getPath()
            com.applovin.impl.adview.b r6 = r10.c
            com.applovin.impl.sdk.ad.e r6 = r6.p()
            if (r6 != 0) goto L_0x0054
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x0053
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "Unable to process click, ad not found!"
            r11.e(r2, r12)
        L_0x0053:
            return r1
        L_0x0054:
            android.graphics.PointF r7 = r11.getLastClickLocation()
            android.graphics.PointF r8 = new android.graphics.PointF
            r8.<init>()
            boolean r7 = r7.equals(r8)
            r7 = r7 ^ r1
            boolean r8 = r6.K()
            if (r8 == 0) goto L_0x006c
            if (r7 != 0) goto L_0x006c
            r8 = 0
            goto L_0x006d
        L_0x006c:
            r8 = 1
        L_0x006d:
            java.lang.String r9 = "applovin"
            boolean r9 = r9.equals(r3)
            if (r9 == 0) goto L_0x01fe
            java.lang.String r9 = "com.applovin.sdk"
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x01fe
            java.lang.String r3 = "/adservice/close_ad"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00ad
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.sdk.AppLovinSdkSettings r11 = r11.p()
            java.util.Map r11 = r11.getExtraParameters()
            java.lang.String r0 = "enable_close_URL_ad_value"
            java.lang.Object r11 = r11.get(r0)
            java.lang.String r11 = (java.lang.String) r11
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r11)
            if (r0 == 0) goto L_0x00a8
            boolean r11 = java.lang.Boolean.parseBoolean(r11)
            if (r11 == 0) goto L_0x00a8
            java.lang.String r11 = "close_url"
            r6.setMaxAdValue(r11, r12)
        L_0x00a8:
            r10.b()
            goto L_0x0242
        L_0x00ad:
            java.lang.String r3 = "/adservice/expand_ad"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00ce
            boolean r12 = r6.J()
            if (r12 == 0) goto L_0x00c5
            if (r7 != 0) goto L_0x00c5
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "Skipping expand command without user interaction"
        L_0x00c1:
            r11.e(r2, r12)
            return r1
        L_0x00c5:
            android.graphics.PointF r11 = r11.getAndClearLastClickLocation()
            r10.a((android.graphics.PointF) r11)
            goto L_0x0242
        L_0x00ce:
            java.lang.String r3 = "/adservice/contract_ad"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00db
            r10.c()
            goto L_0x0242
        L_0x00db:
            java.lang.String r3 = "/adservice/no_op"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00e4
            return r1
        L_0x00e4:
            java.lang.String r3 = "/adservice/load_url"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00fe
            boolean r12 = r6.J()
            if (r12 == 0) goto L_0x00f9
            if (r7 != 0) goto L_0x00f9
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "Skipping URL load command without user interaction"
            goto L_0x00c1
        L_0x00f9:
            r10.a((android.net.Uri) r0, (com.applovin.impl.adview.d) r11)
            goto L_0x0242
        L_0x00fe:
            java.lang.String r3 = "/adservice/track_click_now"
            boolean r4 = r3.equals(r5)
            if (r4 == 0) goto L_0x0124
            boolean r12 = r6.J()
            if (r12 == 0) goto L_0x0113
            if (r7 != 0) goto L_0x0113
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "Skipping click tracking command without user interaction"
            goto L_0x00c1
        L_0x0113:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x011b
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
            goto L_0x023b
        L_0x011b:
            android.net.Uri r12 = android.net.Uri.parse(r3)
            r10.a((com.applovin.impl.adview.d) r11, (android.net.Uri) r12)
            goto L_0x0242
        L_0x0124:
            java.lang.String r3 = "/adservice/deeplink"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0147
            boolean r12 = r6.J()
            if (r12 == 0) goto L_0x0139
            if (r7 != 0) goto L_0x0139
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "Skipping deep link plus command without user interaction"
            goto L_0x00c1
        L_0x0139:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x023f
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
            boolean r12 = r6.aP()
            if (r12 == 0) goto L_0x023f
            goto L_0x023b
        L_0x0147:
            java.lang.String r11 = "/adservice/postback"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0154
            r10.a((android.net.Uri) r0, (com.applovin.impl.sdk.ad.e) r6)
            goto L_0x0242
        L_0x0154:
            com.applovin.impl.adview.b r11 = r10.c
            com.applovin.impl.adview.g r11 = r11.h()
            if (r11 == 0) goto L_0x01d1
            java.lang.String r11 = "/video_began"
            boolean r11 = r11.equals(r5)
            r2 = 0
            if (r11 == 0) goto L_0x017b
            java.lang.String r11 = "duration"
            java.lang.String r11 = r0.getQueryParameter(r11)
            double r11 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r11, r2)
            com.applovin.impl.adview.b r0 = r10.c
            com.applovin.impl.adview.g r0 = r0.h()
            r0.a(r11)
            goto L_0x0242
        L_0x017b:
            java.lang.String r11 = "/video_completed"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x018e
            com.applovin.impl.adview.b r11 = r10.c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.a_()
            goto L_0x0242
        L_0x018e:
            java.lang.String r11 = "/video_progress"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x01ab
            java.lang.String r11 = "percent_viewed"
            java.lang.String r11 = r0.getQueryParameter(r11)
            double r11 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r11, r2)
            com.applovin.impl.adview.b r0 = r10.c
            com.applovin.impl.adview.g r0 = r0.h()
            r0.b(r11)
            goto L_0x0242
        L_0x01ab:
            java.lang.String r11 = "/video_waiting"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x01be
            com.applovin.impl.adview.b r11 = r10.c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.b_()
            goto L_0x0242
        L_0x01be:
            java.lang.String r11 = "/video_resumed"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0242
            com.applovin.impl.adview.b r11 = r10.c
            com.applovin.impl.adview.g r11 = r11.h()
            r11.c()
            goto L_0x0242
        L_0x01d1:
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x0242
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown URL: "
            r0.<init>(r3)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.d(r2, r12)
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Path: "
            r12.<init>(r0)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            r11.d(r2, r12)
            goto L_0x0242
        L_0x01fe:
            if (r8 == 0) goto L_0x0242
            java.util.List r12 = r6.aA()
            java.util.List r5 = r6.aB()
            boolean r7 = r12.isEmpty()
            if (r7 != 0) goto L_0x0214
            boolean r12 = r12.contains(r3)
            if (r12 == 0) goto L_0x0221
        L_0x0214:
            boolean r12 = r5.isEmpty()
            if (r12 != 0) goto L_0x022f
            boolean r12 = r5.contains(r4)
            if (r12 == 0) goto L_0x0221
            goto L_0x022f
        L_0x0221:
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x0242
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.String r12 = "URL is not whitelisted - bypassing click"
            r11.e(r2, r12)
            goto L_0x0242
        L_0x022f:
            boolean r12 = r6 instanceof com.applovin.impl.a.a
            if (r12 == 0) goto L_0x023f
            com.applovin.impl.a.a r6 = (com.applovin.impl.a.a) r6
            boolean r12 = r6.aP()
            if (r12 == 0) goto L_0x023f
        L_0x023b:
            r10.a((com.applovin.impl.a.a) r6, (com.applovin.impl.adview.d) r11)
            goto L_0x0242
        L_0x023f:
            r10.a((com.applovin.impl.adview.d) r11, (android.net.Uri) r0)
        L_0x0242:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.e.a(android.webkit.WebView, java.lang.String):boolean");
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (u.a()) {
            u uVar = this.b;
            uVar.c("AdWebView", "Loaded resource: " + str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        b bVar = this.c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p = bVar.p();
            String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
            if (p != null) {
                this.a.ac().a(p).a(b.y, str3).a();
            }
            if (u.a()) {
                this.b.e("AdWebView", str3 + " for ad: " + p);
            }
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        b bVar = this.c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p = bVar.p();
            this.a.ac().a(p).a(b.z).a();
            if (u.a()) {
                u uVar = this.b;
                uVar.e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + p);
            }
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        b bVar = this.c;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e p = bVar.p();
            String str = "Received SSL error: " + sslError;
            this.a.ac().a(p).a(b.B, str).a();
            if (u.a()) {
                this.b.e("AdWebView", str + " for ad: " + p);
            }
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.c == null) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (u.a()) {
            u.i("AdWebView", "Render process gone for ad: " + this.c.p() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        }
        com.applovin.impl.sdk.ad.e p = this.c.p();
        if (p != null) {
            this.a.ac().a(p).a(b.A).a();
        }
        if (!((Boolean) this.a.a(com.applovin.impl.sdk.d.b.eI)).booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash() && ((Boolean) this.a.a(com.applovin.impl.sdk.d.b.eK)).booleanValue()) {
            String valueOf = p != null ? String.valueOf(p.getAdIdNumber()) : AbstractJsonLexerKt.NULL;
            throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + valueOf);
        } else if (webView == null || !webView.equals(this.c.s())) {
            return true;
        } else {
            this.c.f();
            AppLovinAdSize b2 = this.c.b();
            if (!Utils.isBML(b2)) {
                return true;
            }
            this.c.a(b2);
            this.c.e();
            return true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return a(webView, url.toString());
        }
        if (!u.a()) {
            return false;
        }
        this.b.e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(webView, str);
    }
}
