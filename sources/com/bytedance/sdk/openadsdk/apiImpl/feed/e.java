package com.bytedance.sdk.openadsdk.apiImpl.feed;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: PAGNativeAdLoadListenerAdapter */
public class e implements PAGNativeAdLoadListener {
    /* access modifiers changed from: private */
    public final PAGNativeAdLoadListener a;

    public e(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.a = pAGNativeAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            aa.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.onError(i, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGNativeAd pAGNativeAd) {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.onAdLoaded(pAGNativeAd);
                }
            });
        }
    }
}
