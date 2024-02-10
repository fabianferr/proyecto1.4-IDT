package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.util.HandlerScheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/util/HandlerScheduler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
final class MRAIDPresenter$scheduler$2 extends Lambda implements Function0<HandlerScheduler> {
    public static final MRAIDPresenter$scheduler$2 INSTANCE = new MRAIDPresenter$scheduler$2();

    MRAIDPresenter$scheduler$2() {
        super(0);
    }

    public final HandlerScheduler invoke() {
        return new HandlerScheduler();
    }
}
