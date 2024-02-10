package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.executor.FutureResult;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u0002"}, d2 = {"Lcom/vungle/ads/internal/VungleInternal;", "", "()V", "getAvailableBidTokens", "", "context", "Landroid/content/Context;", "getSdkVersion", "vungle-ads_release", "provider", "Lcom/vungle/ads/internal/util/ConcurrencyTimeoutProvider;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/SDKExecutors;", "bidTokenEncoder", "Lcom/vungle/ads/internal/bidding/BidTokenEncoder;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleInternal.kt */
public final class VungleInternal {
    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* renamed from: getAvailableBidTokens$lambda-0  reason: not valid java name */
    private static final ConcurrencyTimeoutProvider m2289getAvailableBidTokens$lambda0(Lazy<ConcurrencyTimeoutProvider> lazy) {
        return lazy.getValue();
    }

    public final String getAvailableBidTokens(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInternal$getAvailableBidTokens$$inlined$inject$1(context));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInternal$getAvailableBidTokens$$inlined$inject$2(context));
        ServiceLocator.Companion companion3 = ServiceLocator.Companion;
        return (String) new FutureResult(m2290getAvailableBidTokens$lambda1(lazy2).getIoExecutor().submit(new VungleInternal$$ExternalSyntheticLambda0(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInternal$getAvailableBidTokens$$inlined$inject$3(context))))).get(m2289getAvailableBidTokens$lambda0(lazy).getTimeout(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: getAvailableBidTokens$lambda-1  reason: not valid java name */
    private static final SDKExecutors m2290getAvailableBidTokens$lambda1(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: getAvailableBidTokens$lambda-2  reason: not valid java name */
    private static final BidTokenEncoder m2291getAvailableBidTokens$lambda2(Lazy<BidTokenEncoder> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getAvailableBidTokens$lambda-3  reason: not valid java name */
    public static final String m2292getAvailableBidTokens$lambda3(Lazy lazy) {
        Intrinsics.checkNotNullParameter(lazy, "$bidTokenEncoder$delegate");
        return m2291getAvailableBidTokens$lambda2(lazy).encode();
    }
}
