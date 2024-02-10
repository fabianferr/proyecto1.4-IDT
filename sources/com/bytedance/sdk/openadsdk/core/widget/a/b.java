package com.bytedance.sdk.openadsdk.core.widget.a;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.adexpress.a.b.a;
import com.bytedance.sdk.component.adexpress.d.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.x;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PreLoadWebView */
public class b implements a {
    private static volatile b c;
    x a;
    private SSWebView b;
    private AtomicInteger d = new AtomicInteger(o.d().Z());

    public static b b() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public void c() {
        l.a("PreLoadWebView", "preload start", Integer.valueOf(this.d.get()));
        String e = a.e();
        if (!TextUtils.isEmpty(e)) {
            try {
                SSWebView sSWebView = new SSWebView(new MutableContextWrapper(o.a()));
                this.b = sSWebView;
                if (sSWebView.getWebView() != null) {
                    this.b.setWebViewClient(new WebViewClient() {
                        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                            return true;
                        }
                    });
                    a(this.b);
                    Uri build = Uri.parse(e).buildUpon().appendQueryParameter("isPreLoad", "1").build();
                    x xVar = new x(o.a());
                    this.a = xVar;
                    xVar.b(this.b).a((a) this).a(this.b);
                    e.a().a(this.b, (com.bytedance.sdk.component.adexpress.d.b) this.a);
                    this.b.a_(build.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null && sSWebView.getWebView() != null) {
            try {
                c.a(o.a()).a(false).a(sSWebView.getWebView());
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.a(true);
                sSWebView.j();
                sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView.getWebView(), (int) BuildConfig.VERSION_CODE));
                if (Build.VERSION.SDK_INT >= 21) {
                    sSWebView.setMixedContentMode(0);
                }
                sSWebView.setJavaScriptEnabled(true);
                sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
                sSWebView.setDomStorageEnabled(true);
                sSWebView.setDatabaseEnabled(true);
                sSWebView.setAppCacheEnabled(true);
                sSWebView.setAllowFileAccess(false);
                sSWebView.setSupportZoom(true);
                sSWebView.setBuiltInZoomControls(true);
                sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                sSWebView.setUseWideViewPort(true);
            } catch (Exception e) {
                l.e("PreLoadWebView", e.toString());
            }
        }
    }

    public void a() {
        e.a().a(this.b);
        l.a("PreLoadWebView", "preload finish", Integer.valueOf(this.d.get()));
        this.d.decrementAndGet();
        if (this.d.get() != 0) {
            c();
        }
    }
}
