package com.unity3d.services.core.webview.bridge;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\nJ=\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"com/unity3d/services/core/webview/bridge/SharedInstances$webViewBridge$1", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "handleCallback", "", "callbackId", "", "callbackStatus", "parameters", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "handleInvocation", "className", "methodName", "callback", "Lcom/unity3d/services/core/webview/bridge/WebViewCallback;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Lcom/unity3d/services/core/webview/bridge/WebViewCallback;)V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedInstances.kt */
public final class SharedInstances$webViewBridge$1 implements IWebViewBridge {
    SharedInstances$webViewBridge$1() {
    }

    public void handleInvocation(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) throws Exception {
        WebViewBridge.getInstance().handleInvocation(str, str2, objArr, webViewCallback);
    }

    public void handleCallback(String str, String str2, Object[] objArr) throws Exception {
        WebViewBridge.getInstance().handleCallback(str, str2, objArr);
    }
}
