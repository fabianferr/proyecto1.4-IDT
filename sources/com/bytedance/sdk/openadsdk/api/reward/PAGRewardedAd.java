package com.bytedance.sdk.openadsdk.api.reward;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGRewardedAd implements PAGClientBidding, PangleAd {
    public abstract void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback);

    public abstract void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGRewardedAdLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createRewardAdLoader().loadAd(str, pAGRewardedRequest, pAGRewardedAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, final PAGRewardedAdLoadCallback pAGRewardedAdLoadCallback) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGRewardedAdLoadCallback.onError(new PAGErrorModel(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG));
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createRewardAdLoader().loadAd(str, pAGRewardedRequest, new PAGRewardedAdLoadListener() {
                public void onError(int i, String str) {
                    pAGRewardedAdLoadCallback.onError(new PAGErrorModel(i, str));
                }

                public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                    pAGRewardedAdLoadCallback.onAdLoaded(pAGRewardedAd);
                }
            });
        }
    }
}
