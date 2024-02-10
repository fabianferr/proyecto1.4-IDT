package com.bytedance.sdk.openadsdk.api.interstitial;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGInterstitialAd implements PAGClientBidding, PangleAd {
    public abstract void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback);

    public abstract void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGInterstitialAdLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createInterstitialAdLoader().loadAd(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, final PAGInterstitialAdLoadCallback pAGInterstitialAdLoadCallback) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGInterstitialAdLoadCallback.onError(new PAGErrorModel(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG));
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createInterstitialAdLoader().loadAd(str, pAGInterstitialRequest, new PAGInterstitialAdLoadListener() {
                public void onError(int i, String str) {
                    pAGInterstitialAdLoadCallback.onError(new PAGErrorModel(i, str));
                }

                public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                    pAGInterstitialAdLoadCallback.onAdLoaded(pAGInterstitialAd);
                }
            });
        }
    }
}
