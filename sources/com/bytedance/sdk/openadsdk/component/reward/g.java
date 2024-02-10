package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: PAGRewardProxyListener */
public class g implements PAGRewardedAdLoadListener {
    final PAGRewardedAdLoadListener a;

    public g(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (g.this.a != null) {
                        g.this.a.onError(i, str);
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
                    if (g.this.a != null) {
                        g.this.a.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
