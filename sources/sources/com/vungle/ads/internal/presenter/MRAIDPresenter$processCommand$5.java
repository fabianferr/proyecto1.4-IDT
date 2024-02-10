package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/presenter/MRAIDPresenter$processCommand$5", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "onDeeplinkClick", "", "opened", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
public final class MRAIDPresenter$processCommand$5 implements PresenterAdOpenCallback {
    final /* synthetic */ MRAIDPresenter this$0;

    MRAIDPresenter$processCommand$5(MRAIDPresenter mRAIDPresenter) {
        this.this$0 = mRAIDPresenter;
    }

    public void onDeeplinkClick(boolean z) {
        List<String> tpatUrls = this.this$0.advertisement.getTpatUrls(Constants.DEEPLINK_CLICK, String.valueOf(z));
        TpatSender tpatSender = new TpatSender(this.this$0.getVungleApiClient$vungle_ads_release(), this.this$0.placement.getReferenceId(), this.this$0.advertisement.getCreativeId(), this.this$0.advertisement.eventId(), this.this$0.getExecutors().getIoExecutor(), this.this$0.getPathProvider());
        if (tpatUrls != null) {
            MRAIDPresenter mRAIDPresenter = this.this$0;
            for (String sendTpat : tpatUrls) {
                tpatSender.sendTpat(sendTpat, mRAIDPresenter.executor);
            }
        }
    }
}
