package com.bytedance.sdk.openadsdk.apiImpl.d;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: PARewardedAdListenerAdapter */
public class b implements PAGRewardedAdLoadListener {
    /* access modifiers changed from: private */
    public final PAGRewardedAdLoadListener a;

    public b(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.a != null) {
                        b.this.a.onError(i, str);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.a != null) {
                        b.this.a.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
