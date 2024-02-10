package com.unity3d.services.core.cache;

import com.facebook.internal.NativeProtocol;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/unity3d/services/core/cache/CacheEventSender;", "Ljava/io/Serializable;", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "(Lcom/unity3d/services/core/webview/bridge/IEventSender;)V", "sendEvent", "", "eventId", "Lcom/unity3d/services/core/cache/CacheEvent;", "params", "", "", "(Lcom/unity3d/services/core/cache/CacheEvent;[Ljava/lang/Object;)Z", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CacheEventSender.kt */
public final class CacheEventSender implements Serializable {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender iEventSender) {
        Intrinsics.checkNotNullParameter(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public final boolean sendEvent(CacheEvent cacheEvent, Object... objArr) {
        Intrinsics.checkNotNullParameter(cacheEvent, "eventId");
        Intrinsics.checkNotNullParameter(objArr, NativeProtocol.WEB_DIALOG_PARAMS);
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, cacheEvent, Arrays.copyOf(objArr, objArr.length));
    }
}
