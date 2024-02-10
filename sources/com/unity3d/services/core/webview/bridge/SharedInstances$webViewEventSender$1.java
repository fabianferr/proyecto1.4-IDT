package com.unity3d.services.core.webview.bridge;

import com.facebook.internal.NativeProtocol;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J9\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/unity3d/services/core/webview/bridge/SharedInstances$webViewEventSender$1", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "canSend", "", "sendEvent", "eventCategory", "", "eventId", "params", "", "", "(Ljava/lang/Enum;Ljava/lang/Enum;[Ljava/lang/Object;)Z", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedInstances.kt */
public final class SharedInstances$webViewEventSender$1 implements IEventSender {
    SharedInstances$webViewEventSender$1() {
    }

    public boolean sendEvent(Enum<?> enumR, Enum<?> enumR2, Object... objArr) {
        Intrinsics.checkNotNullParameter(enumR, "eventCategory");
        Intrinsics.checkNotNullParameter(enumR2, "eventId");
        Intrinsics.checkNotNullParameter(objArr, NativeProtocol.WEB_DIALOG_PARAMS);
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            return currentApp.sendEvent(enumR, enumR2, Arrays.copyOf(objArr, objArr.length));
        }
        return false;
    }

    public boolean canSend() {
        return WebViewApp.getCurrentApp() != null;
    }
}
