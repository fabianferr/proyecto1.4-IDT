package com.bytedance.sdk.openadsdk.api.banner;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGBannerAd implements PAGClientBidding, PangleAd {
    public abstract void destroy();

    public abstract View getBannerView();

    public abstract void setAdInteractionCallback(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback);

    public abstract void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener);

    public static void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGBannerAdLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createBannerAdLoader().loadAd(str, pAGBannerRequest, pAGBannerAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGBannerRequest pAGBannerRequest, final PAGBannerAdLoadCallback pAGBannerAdLoadCallback) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGBannerAdLoadCallback.onError(new PAGErrorModel(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG));
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createBannerAdLoader().loadAd(str, pAGBannerRequest, new PAGBannerAdLoadListener() {
                public void onError(int i, String str) {
                    pAGBannerAdLoadCallback.onError(new PAGErrorModel(i, str));
                }

                public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                    pAGBannerAdLoadCallback.onAdLoaded(pAGBannerAd);
                }
            });
        }
    }
}
