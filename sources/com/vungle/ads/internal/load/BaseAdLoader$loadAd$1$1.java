package com.vungle.ads.internal.load;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAdLoader.kt */
final class BaseAdLoader$loadAd$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ AdLoaderCallback $adLoaderCallback;
    final /* synthetic */ BaseAdLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAdLoader$loadAd$1$1(BaseAdLoader baseAdLoader, AdLoaderCallback adLoaderCallback) {
        super(1);
        this.this$0 = baseAdLoader;
        this.$adLoaderCallback = adLoaderCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == 10 || i == 13) {
            if (i == 10) {
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.MRAID_DOWNLOAD_JS_RETRY_SUCCESS, 0, this.this$0.getAdRequest().getPlacement().getReferenceId(), (String) null, (String) null, (String) null, 58, (Object) null);
            }
            this.this$0.requestAd();
            return;
        }
        this.$adLoaderCallback.onFailure(new MraidJsError((String) null, 1, (DefaultConstructorMarker) null));
    }
}
