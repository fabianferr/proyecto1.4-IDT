package com.vungle.ads.internal.presenter;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InternalError;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.util.SuspendableTimer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/util/SuspendableTimer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
final class MRAIDPresenter$suspendableTimer$2 extends Lambda implements Function0<SuspendableTimer> {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MRAIDPresenter$suspendableTimer$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    public final SuspendableTimer invoke() {
        final MRAIDPresenter mRAIDPresenter = this.this$0;
        return new SuspendableTimer(6.0d, true, (Function0) null, new Function0<Unit>() {
            public final void invoke() {
                AnalyticsClient.INSTANCE.logError$vungle_ads_release(318, "Error ad template missing Heartbeat", mRAIDPresenter.placement.getReferenceId(), mRAIDPresenter.advertisement.getCreativeId(), mRAIDPresenter.advertisement.eventId());
                mRAIDPresenter.reportErrorAndCloseAd(new InternalError(VungleError.HEARTBEAT_ERROR, (String) null, 2, (DefaultConstructorMarker) null));
            }
        }, 4, (DefaultConstructorMarker) null);
    }
}
