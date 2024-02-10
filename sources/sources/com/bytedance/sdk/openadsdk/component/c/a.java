package com.bytedance.sdk.openadsdk.component.c;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.b.b;

/* compiled from: PAGInterstitialAdWrapper */
public class a implements b {
    private final PAGInterstitialAdInteractionListener a;

    public a(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.a = pAGInterstitialAdInteractionListener;
    }

    public void a() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    public void b() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }

    public void c() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }
}
