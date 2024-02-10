package com.vungle.ads;

import com.vungle.ads.internal.AdInternal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/AdInternal;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAd.kt */
final class BaseAd$adInternal$2 extends Lambda implements Function0<AdInternal> {
    final /* synthetic */ BaseAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAd$adInternal$2(BaseAd baseAd) {
        super(0);
        this.this$0 = baseAd;
    }

    public final AdInternal invoke() {
        BaseAd baseAd = this.this$0;
        return baseAd.constructAdInternal$vungle_ads_release(baseAd.getContext());
    }
}
