package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

@Deprecated
public interface OfferwallListener {
    @Deprecated
    void onGetOfferwallCreditsFailed(IronSourceError ironSourceError);

    @Deprecated
    boolean onOfferwallAdCredited(int i, int i2, boolean z);

    @Deprecated
    void onOfferwallAvailable(boolean z);

    @Deprecated
    void onOfferwallClosed();

    @Deprecated
    void onOfferwallOpened();

    @Deprecated
    void onOfferwallShowFailed(IronSourceError ironSourceError);
}
