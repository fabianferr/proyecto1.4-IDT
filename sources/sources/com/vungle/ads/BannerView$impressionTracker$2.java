package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.ImpressionTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/ImpressionTracker;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BannerView.kt */
final class BannerView$impressionTracker$2 extends Lambda implements Function0<ImpressionTracker> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannerView$impressionTracker$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final ImpressionTracker invoke() {
        return new ImpressionTracker(this.$context);
    }
}
