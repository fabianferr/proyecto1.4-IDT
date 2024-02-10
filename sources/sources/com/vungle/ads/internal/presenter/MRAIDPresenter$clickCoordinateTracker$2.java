package com.vungle.ads.internal.presenter;

import android.content.Context;
import com.vungle.ads.internal.ClickCoordinateTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/ClickCoordinateTracker;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
final class MRAIDPresenter$clickCoordinateTracker$2 extends Lambda implements Function0<ClickCoordinateTracker> {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MRAIDPresenter$clickCoordinateTracker$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    public final ClickCoordinateTracker invoke() {
        Context context = this.this$0.adWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adWidget.context");
        return new ClickCoordinateTracker(context, this.this$0.advertisement, this.this$0.executor);
    }
}
