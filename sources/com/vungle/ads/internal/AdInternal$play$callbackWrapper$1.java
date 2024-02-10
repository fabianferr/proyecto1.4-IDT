package com.vungle.ads.internal;

import com.vungle.ads.VungleError;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/vungle/ads/internal/AdInternal$play$callbackWrapper$1", "Lcom/vungle/ads/internal/presenter/AdPlayCallbackWrapper;", "onAdEnd", "", "id", "", "onAdStart", "onFailure", "error", "Lcom/vungle/ads/VungleError;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdInternal.kt */
public final class AdInternal$play$callbackWrapper$1 extends AdPlayCallbackWrapper {
    final /* synthetic */ AdInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdInternal$play$callbackWrapper$1(AdPlayCallback adPlayCallback, AdInternal adInternal) {
        super(adPlayCallback);
        this.this$0 = adInternal;
    }

    public void onAdStart(String str) {
        this.this$0.setAdState(AdInternal.AdState.PLAYING);
        super.onAdStart(str);
    }

    public void onAdEnd(String str) {
        this.this$0.setAdState(AdInternal.AdState.FINISHED);
        super.onAdEnd(str);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        this.this$0.setAdState(AdInternal.AdState.ERROR);
        super.onFailure(vungleError);
    }
}
