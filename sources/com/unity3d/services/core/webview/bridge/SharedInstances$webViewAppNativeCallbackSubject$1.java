package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/unity3d/services/core/webview/bridge/SharedInstances$webViewAppNativeCallbackSubject$1", "Lcom/unity3d/services/core/webview/bridge/INativeCallbackSubject;", "getCallback", "Lcom/unity3d/services/core/webview/bridge/NativeCallback;", "callbackId", "", "remove", "", "callback", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedInstances.kt */
public final class SharedInstances$webViewAppNativeCallbackSubject$1 implements INativeCallbackSubject {
    SharedInstances$webViewAppNativeCallbackSubject$1() {
    }

    public void remove(NativeCallback nativeCallback) {
        Intrinsics.checkNotNullParameter(nativeCallback, "callback");
        WebViewApp.getCurrentApp().removeCallback(nativeCallback);
    }

    public NativeCallback getCallback(String str) {
        Intrinsics.checkNotNullParameter(str, "callbackId");
        NativeCallback callback = WebViewApp.getCurrentApp().getCallback(str);
        Intrinsics.checkNotNullExpressionValue(callback, "getCurrentApp().getCallback(callbackId)");
        return callback;
    }
}
