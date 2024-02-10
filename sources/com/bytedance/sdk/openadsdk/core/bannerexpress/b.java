package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;

/* compiled from: PAGBannerAdWrapper */
public class b implements PAGBannerAdWrapperListener {
    private final PAGBannerAdInteractionListener a;

    public void onRenderFail(View view, String str, int i) {
    }

    public void onRenderSuccess(View view, float f, float f2) {
    }

    public b(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        this.a = pAGBannerAdInteractionListener;
    }

    public void onAdClicked(View view, int i) {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdClicked();
        }
    }

    public void onAdShow(View view, int i) {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdShowed();
        }
    }

    public void onAdDismissed() {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdDismissed();
        }
    }
}
