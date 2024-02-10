package com.unity3d.services.core.webview;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WebView$$ExternalSyntheticLambda0 implements WebViewCompat.WebMessageListener {
    public final /* synthetic */ WebViewBridgeInterface f$0;

    public /* synthetic */ WebView$$ExternalSyntheticLambda0(WebViewBridgeInterface webViewBridgeInterface) {
        this.f$0 = webViewBridgeInterface;
    }

    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        this.f$0.onHandleInvocation(webView, webMessageCompat, uri, z, javaScriptReplyProxy);
    }
}
