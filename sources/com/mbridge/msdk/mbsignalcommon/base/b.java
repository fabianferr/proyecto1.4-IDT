package com.mbridge.msdk.mbsignalcommon.base;

import android.net.http.SslError;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.d;

/* compiled from: BaseWebViewClient */
public class b extends WebViewClient {
    private a a;
    private d b;

    public final void a(a aVar) {
        this.a = aVar;
    }

    public final a b() {
        return this.a;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.a;
        if (aVar != null && aVar.a(str)) {
            return true;
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(webView, i, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(webView, sslErrorHandler, sslError);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(webView, str);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        aa.d("BaseWebViewClient", "WebView called onRenderProcessGone");
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WindVaneWebView) {
                    ((WindVaneWebView) webView).release();
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                aa.d("BaseWebViewClient", th.getMessage());
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
        }
        d dVar = this.b;
        if (dVar == null) {
            return true;
        }
        dVar.a(webView);
        return true;
    }

    public final void a(d dVar) {
        this.b = dVar;
    }
}
