package com.wortise.ads;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0017J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0011H\u0017J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/w3;", "Landroid/webkit/WebViewClient;", "Lcom/wortise/ads/v3;", "view", "", "url", "Landroid/webkit/WebResourceResponse;", "a", "Lcom/wortise/ads/u3;", "request", "", "Landroid/webkit/WebView;", "", "onPageFinished", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "onRenderProcessGone", "Landroid/webkit/WebResourceRequest;", "shouldInterceptRequest", "shouldOverrideUrlLoading", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HtmlWebViewClient.kt */
public final class w3 extends WebViewClient {
    private final WebResourceResponse a(v3 v3Var, String str) {
        WortiseLog.d$default(Intrinsics.stringPlus("[HtmlWebView] Loading resource ", str), (Throwable) null, 2, (Object) null);
        return null;
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        if (webView instanceof v3) {
            ((v3) webView).onReady$sdk_productionRelease();
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(webView, "view");
        if (!(webView instanceof v3)) {
            return true;
        }
        ((v3) webView).onRenderProcessGone$sdk_productionRelease();
        return true;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        Intrinsics.checkNotNullParameter(webView, "view");
        String str = null;
        if (!(webView instanceof v3)) {
            return null;
        }
        v3 v3Var = (v3) webView;
        if (!(webResourceRequest == null || (url = webResourceRequest.getUrl()) == null)) {
            str = url.toString();
        }
        return a(v3Var, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        if (!(webView instanceof v3)) {
            return false;
        }
        return a((v3) webView, new u3(webResourceRequest));
    }

    private final boolean a(v3 v3Var, u3 u3Var) {
        if (!u3Var.a() && !u3Var.c()) {
            return false;
        }
        v3Var.handleUrl$sdk_productionRelease(u3Var.b());
        return true;
    }

    @Deprecated(message = "Deprecated in Java")
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        if (!(webView instanceof v3)) {
            return null;
        }
        return a((v3) webView, str);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        Intrinsics.checkNotNullParameter(webView, "view");
        if (!(webView instanceof v3)) {
            return false;
        }
        if (str == null) {
            uri = null;
        } else {
            uri = h6.b(str);
        }
        Uri uri2 = uri;
        if (uri2 == null) {
            return false;
        }
        v3 v3Var = (v3) webView;
        return a(v3Var, new u3(v3Var.getWasClicked(), (Map) null, (Boolean) null, (Boolean) null, (String) null, uri2, 30, (DefaultConstructorMarker) null));
    }
}
