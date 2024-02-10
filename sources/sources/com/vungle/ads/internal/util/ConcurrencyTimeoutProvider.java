package com.vungle.ads.internal.util;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/util/ConcurrencyTimeoutProvider;", "", "()V", "OPERATION_TIMEOUT", "", "getTimeout", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConcurrencyTimeoutProvider.kt */
public final class ConcurrencyTimeoutProvider {
    private final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    public final long getTimeout() {
        if (ThreadUtil.INSTANCE.isMainThread()) {
            return this.OPERATION_TIMEOUT;
        }
        return Long.MAX_VALUE;
    }
}
