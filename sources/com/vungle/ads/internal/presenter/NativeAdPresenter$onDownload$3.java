package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/presenter/NativeAdPresenter$onDownload$3", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "onDeeplinkClick", "", "opened", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeAdPresenter.kt */
public final class NativeAdPresenter$onDownload$3 implements PresenterAdOpenCallback {
    final /* synthetic */ TpatSender $tpatSender;
    final /* synthetic */ NativeAdPresenter this$0;

    NativeAdPresenter$onDownload$3(NativeAdPresenter nativeAdPresenter, TpatSender tpatSender) {
        this.this$0 = nativeAdPresenter;
        this.$tpatSender = tpatSender;
    }

    public void onDeeplinkClick(boolean z) {
        AdPayload access$getAdvertisement$p = this.this$0.advertisement;
        List<String> tpatUrls = access$getAdvertisement$p != null ? access$getAdvertisement$p.getTpatUrls(Constants.DEEPLINK_CLICK, String.valueOf(z)) : null;
        if (tpatUrls != null) {
            TpatSender tpatSender = this.$tpatSender;
            NativeAdPresenter nativeAdPresenter = this.this$0;
            for (String sendTpat : tpatUrls) {
                tpatSender.sendTpat(sendTpat, nativeAdPresenter.executor);
            }
        }
    }
}
