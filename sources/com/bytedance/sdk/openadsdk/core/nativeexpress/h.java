package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.adexpress.a.b.a;
import com.bytedance.sdk.component.adexpress.c.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.b;
import com.bytedance.sdk.openadsdk.core.widget.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.d;
import java.io.InputStream;
import java.util.Iterator;

/* compiled from: ExpressClient */
public class h extends e {
    private final q a;

    public h(Context context, x xVar, q qVar, j jVar) {
        super(context, xVar, qVar.Y(), jVar, false);
        this.a = qVar;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            l.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse a2 = a(webView, str);
            a(currentTimeMillis, System.currentTimeMillis(), str, a2 != null ? 1 : 2);
            if (a2 != null) {
                return a2;
            }
        } catch (Throwable th) {
            l.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        this.g = false;
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.h = false;
        super.onPageStarted(webView, str, bitmap);
    }

    private WebResourceResponse a(WebView webView, String str) {
        n nVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f.a a2 = f.a(str);
        if (a2 != f.a.IMAGE) {
            Iterator<n> it = this.a.Q().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String a3 = next.a();
                    if (a3.startsWith(ProxyConfig.MATCH_HTTPS)) {
                        a3 = a3.replaceFirst(ProxyConfig.MATCH_HTTPS, "http");
                    }
                    if ((str.startsWith(ProxyConfig.MATCH_HTTPS) ? str.replaceFirst(ProxyConfig.MATCH_HTTPS, "http") : str).equals(a3)) {
                        nVar = next;
                        break;
                    }
                }
            }
        }
        if (a2 == f.a.IMAGE || nVar != null) {
            return a(str, b.a(this.a, str));
        }
        return a.a(str, a2, "");
    }

    private WebResourceResponse a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream a2 = d.a(str, str2);
            if (a2 != null) {
                return new WebResourceResponse(f.a.IMAGE.a(), "utf-8", a2);
            }
            return null;
        } catch (Throwable th) {
            l.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j, long j2, String str, int i) {
        if (this.f != null && this.f.b() != null) {
            f.a a2 = f.a(str);
            if (a2 == f.a.HTML) {
                this.f.b().a(str, j, j2, i);
            } else if (a2 == f.a.JS) {
                this.f.b().b(str, j, j2, i);
            }
        }
    }
}
