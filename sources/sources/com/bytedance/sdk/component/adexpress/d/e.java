package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.a.z;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.a.a.c;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WebViewPool */
public class e {
    private static final byte[] d = new byte[0];
    private static int e = 10;
    private static volatile e g;
    private List<SSWebView> a = new ArrayList();
    private Map<Integer, c> b = new HashMap();
    private Map<Integer, d> c = new HashMap();
    private final AtomicBoolean f = new AtomicBoolean(false);

    private e() {
        c c2 = a.a().c();
        if (c2 != null) {
            e = c2.j();
        }
    }

    public static e a() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e();
                }
            }
        }
        return g;
    }

    public SSWebView a(Context context, String str) {
        if (c() <= 0) {
            return null;
        }
        if (!com.bytedance.sdk.component.adexpress.c.c.a(str) || c() > 1) {
            SSWebView remove = this.a.remove(0);
            if (remove == null) {
                return null;
            }
            try {
                ((MutableContextWrapper) remove.getContext()).setBaseContext(context);
                remove.setRecycler(false);
                l.a("WebViewPool", "get WebView from pool; current available count: ", Integer.valueOf(c()));
                return remove;
            } catch (Exception unused) {
                l.a("WebViewPool", "get WebView from pool exception; current available count: ", Integer.valueOf(c()));
                return null;
            }
        } else {
            l.a("WebViewPool", "get WebView from pool; but ad type is does not meet the requirement ", Integer.valueOf(c()));
            return null;
        }
    }

    public void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            e(sSWebView);
            sSWebView.b_("SDK_INJECT_GLOBAL");
            d(sSWebView);
            b(sSWebView);
        }
    }

    public void b(SSWebView sSWebView) {
        if (sSWebView != null) {
            if (this.a.size() >= e) {
                l.b("WebViewPool", "WebView pool is full，destroy webview");
                sSWebView.l();
            } else if (!this.a.contains(sSWebView)) {
                try {
                    ((MutableContextWrapper) sSWebView.getContext()).setBaseContext(d.a());
                    sSWebView.setRecycler(true);
                    this.a.add(sSWebView);
                    l.a("WebViewPool", "recycle WebView，current available count: ", Integer.valueOf(c()));
                } catch (Exception e2) {
                    l.a("WebViewPool", "recycle WebView fail，current available count: ", Integer.valueOf(c()), "exception is ", e2.getMessage());
                }
            }
        }
    }

    public boolean c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        l.b("WebViewPool", "WebView render fail and abandon");
        sSWebView.l();
        return true;
    }

    public void b() {
        for (SSWebView next : this.a) {
            if (next != null) {
                next.l();
            }
        }
        this.a.clear();
    }

    public int c() {
        return this.a.size();
    }

    public int d() {
        return this.a.size();
    }

    private void e(SSWebView sSWebView) {
        sSWebView.removeAllViews();
        sSWebView.c();
        sSWebView.setWebChromeClient((WebChromeClient) null);
        sSWebView.setWebViewClient((WebViewClient) null);
        sSWebView.setDownloadListener((DownloadListener) null);
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setAppCacheEnabled(false);
        sSWebView.setSupportZoom(false);
        sSWebView.setUseWideViewPort(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setBuiltInZoomControls(false);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.setLoadWithOverviewMode(false);
        sSWebView.setDefaultTextEncodingName("UTF-8");
        sSWebView.setDefaultFontSize(16);
    }

    public void a(SSWebView sSWebView, b bVar) {
        if (sSWebView != null && bVar != null) {
            c cVar = this.b.get(Integer.valueOf(sSWebView.hashCode()));
            if (cVar != null) {
                cVar.a(bVar);
            } else {
                cVar = new c(bVar);
                this.b.put(Integer.valueOf(sSWebView.hashCode()), cVar);
            }
            sSWebView.a((Object) cVar, "SDK_INJECT_GLOBAL");
        }
    }

    public void d(SSWebView sSWebView) {
        if (sSWebView != null) {
            c cVar = this.b.get(Integer.valueOf(sSWebView.hashCode()));
            if (cVar != null) {
                cVar.a((b) null);
            }
            sSWebView.b_("SDK_INJECT_GLOBAL");
        }
    }

    public void a(WebView webView, z zVar, String str) {
        if (webView != null && zVar != null && !TextUtils.isEmpty(str)) {
            d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
            if (dVar != null) {
                dVar.a(zVar);
            } else {
                dVar = new d(zVar);
                this.c.put(Integer.valueOf(webView.hashCode()), dVar);
            }
            webView.addJavascriptInterface(dVar, str);
        }
    }

    public void a(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
            if (dVar != null) {
                dVar.a((z) null);
            }
            webView.removeJavascriptInterface(str);
        }
    }

    public void a(int i) {
        synchronized (d) {
            e = i;
        }
    }
}
