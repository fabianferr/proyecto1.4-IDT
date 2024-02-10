package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import java.util.List;

public abstract class PAGNativeAd implements PAGClientBidding, PangleAd {
    public abstract PAGNativeAdData getNativeAdData();

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener);

    public abstract void showPrivacyActivity();

    public static void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGNativeAdLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createNativeAdLoader().loadAd(str, pAGNativeRequest, pAGNativeAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGNativeRequest pAGNativeRequest, final PAGNativeAdLoadCallback pAGNativeAdLoadCallback) {
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory == null) {
            pAGNativeAdLoadCallback.onError(new PAGErrorModel(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG));
        } else {
            sdkTypeFactory.createADTypeLoaderFactory(str).createNativeAdLoader().loadAd(str, pAGNativeRequest, new PAGNativeAdLoadListener() {
                public void onError(int i, String str) {
                    pAGNativeAdLoadCallback.onError(new PAGErrorModel(i, str));
                }

                public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                    pAGNativeAdLoadCallback.onAdLoaded(pAGNativeAd);
                }
            });
        }
    }
}
