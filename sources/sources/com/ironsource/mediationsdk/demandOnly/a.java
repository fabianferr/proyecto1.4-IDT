package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.demandOnly.l;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class a extends l.a<ISDemandOnlyBannerListener> {
    public final void a(final String str, final IronSourceError ironSourceError) {
        final ISDemandOnlyBannerListener iSDemandOnlyBannerListener = (ISDemandOnlyBannerListener) a();
        a((Runnable) new Runnable() {
            public final void run() {
                String str = str;
                a.a(str, "onBannerAdLoadFailed() error = " + ironSourceError.getErrorMessage());
                ISDemandOnlyBannerListener iSDemandOnlyBannerListener = iSDemandOnlyBannerListener;
                if (iSDemandOnlyBannerListener != null) {
                    iSDemandOnlyBannerListener.onBannerAdLoadFailed(str, ironSourceError);
                }
            }
        }, iSDemandOnlyBannerListener != null);
    }
}
