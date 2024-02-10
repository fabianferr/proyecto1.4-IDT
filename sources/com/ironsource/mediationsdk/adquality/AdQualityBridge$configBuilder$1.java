package com.ironsource.mediationsdk.adquality;

import com.facebook.share.internal.ShareConstants;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitError;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/ironsource/mediationsdk/adquality/AdQualityBridge$configBuilder$1", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityInitListener;", "adQualitySdkInitFailed", "", "isAdQualityInitError", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityInitError;", "message", "", "adQualitySdkInitSuccess", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdQualityBridge$configBuilder$1 implements ISAdQualityInitListener {
    final /* synthetic */ AdQualityBridge this$0;

    AdQualityBridge$configBuilder$1(AdQualityBridge adQualityBridge) {
        this.this$0 = adQualityBridge;
    }

    public final void adQualitySdkInitFailed(ISAdQualityInitError iSAdQualityInitError, String str) {
        Intrinsics.checkNotNullParameter(iSAdQualityInitError, "isAdQualityInitError");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.this$0.logEvent(iSAdQualityInitError == ISAdQualityInitError.AD_QUALITY_ALREADY_INITIALIZED ? 82 : 83, Integer.valueOf(iSAdQualityInitError.getValue()), str);
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "Ad Quality failed to initialize: " + str, 3);
    }

    public final void adQualitySdkInitSuccess() {
        AdQualityBridge.logEvent$default(this.this$0, 81, (Integer) null, (String) null, 6, (Object) null);
    }
}
