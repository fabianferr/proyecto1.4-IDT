package com.bytedance.sdk.openadsdk.core.widget.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.Utils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.x;
import com.com.bytedance.overseas.sdk.a.a;
import com.com.bytedance.overseas.sdk.a.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TTWebViewClient */
public class e extends SSWebView.a {
    private static final HashSet<String> n;
    private final boolean a;
    private String b;
    protected final x c;
    protected final Context d;
    protected final String e;
    protected j f;
    protected boolean g = true;
    protected boolean h = true;
    private i i;
    private Map<String, Object> j;
    private boolean k;
    private JSONObject l;
    private q m;

    public void a(i iVar) {
        this.i = iVar;
    }

    public void a(Map<String, Object> map) {
        this.j = map;
    }

    public void a(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(q qVar) {
        this.m = qVar;
    }

    public e(Context context, x xVar, String str, j jVar, boolean z) {
        this.d = context;
        this.c = xVar;
        this.e = str;
        this.f = jVar;
        this.a = z;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.f;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        l.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            Uri parse = Uri.parse(str);
            String lowerCase = parse.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                com.bytedance.sdk.openadsdk.utils.l.a(parse, this.c);
                return true;
            } else if (c(str)) {
                return true;
            } else {
                if (!o.a(str)) {
                    if (com.bytedance.sdk.openadsdk.core.model.o.f(this.m)) {
                        a(lowerCase, str);
                        return true;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(parse);
                        intent.addFlags(268435456);
                        this.d.startActivity(intent);
                    } catch (Throwable unused) {
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        } catch (Throwable th) {
            l.b("WebChromeClient", "shouldOverrideUrlLoading", th);
            x xVar = this.c;
            if (xVar != null && xVar.d()) {
                return true;
            }
        }
    }

    private void a(String str, String str2) {
        if ((e(str) || Utils.PLAY_STORE_SCHEME.equals(str)) && (!(this.i == null && this.l == null) && b(str2))) {
            a();
        }
        this.i = null;
        this.l = null;
    }

    public boolean b(String str) {
        String str2;
        String str3;
        if (this.d == null) {
            return false;
        }
        q qVar = this.m;
        if (qVar == null || qVar.aa() == null) {
            str3 = "";
            str2 = str3;
        } else {
            str3 = this.m.aa().c();
            str2 = this.m.aa().a();
        }
        if (a.a(str, this.d, this.b, this.m, (Map<String, Object>) null) || a.a(this.m, str3, this.d, this.b, (Map<String, Object>) null) || b.a(this.d, str2, str3, this.b, this.m)) {
            return true;
        }
        return false;
    }

    private boolean e(String str) {
        if (!com.bytedance.sdk.openadsdk.core.model.o.f(this.m)) {
            return false;
        }
        return TextUtils.equals(this.m.aO(), str);
    }

    public void a() {
        if (!TextUtils.isEmpty(this.b) && com.bytedance.sdk.openadsdk.core.model.o.e(this.m) && !this.k) {
            i iVar = this.i;
            if (iVar != null) {
                c.a(CampaignEx.JSON_NATIVE_VIDEO_CLICK, this.m, iVar, this.b, true, this.j, 1);
                this.k = true;
                return;
            }
            JSONObject jSONObject = this.l;
            if (jSONObject != null) {
                c.a(this.m, this.b, CampaignEx.JSON_NATIVE_VIDEO_CLICK, jSONObject);
                this.k = true;
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (l.a()) {
            l.a("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.a(webView, str, this.a);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.f;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.h) {
            c.a(this.d).a(true).b(webView.getSettings().getBuiltInZoomControls()).a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        if (Build.VERSION.SDK_INT < 23 && this.f != null) {
            this.f.a(webView, i2, str, str2, d(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23 && this.f != null && webResourceError != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.f.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str, webResourceRequest != null && webResourceRequest.isForMainFrame());
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.f != null && webResourceResponse != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.f.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str, webResourceRequest != null && webResourceRequest.isForMainFrame());
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.f != null) {
            int i2 = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i2 = sslError.getPrimaryError();
                    str = "SslError: " + sslError;
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str3 = str2;
            this.f.a(webView, i2, str, str3, d(str3), true);
        }
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if ("play.google.com".equals(parse.getHost())) {
                if (com.bytedance.sdk.openadsdk.core.model.o.f(this.m) && this.l == null && this.i == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.d instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(parse);
                intent.setPackage("com.android.vending");
                this.d.startActivity(intent);
                a();
                this.l = null;
                this.i = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        n = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    protected static String d(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !n.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + substring;
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            com.bytedance.sdk.component.adexpress.d.e.a().b();
        } catch (Exception unused) {
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }
}
