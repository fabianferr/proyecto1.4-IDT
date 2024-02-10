package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.d.a;

/* compiled from: PAGRewardedAdWrapper */
public class i implements a {
    private final PAGRewardedAdInteractionListener a;
    private final PAGRewardedAdInteractionCallback b;

    public i(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.a = pAGRewardedAdInteractionListener;
        this.b = null;
    }

    public i(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.b = pAGRewardedAdInteractionCallback;
        this.a = null;
    }

    public void a() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdShowed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdShowed();
        }
    }

    public void b() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdClicked();
        }
    }

    public void c() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdDismissed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdDismissed();
        }
    }

    public void a(boolean z, int i, String str, int i2, String str2) {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener == null) {
            PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.b;
            if (pAGRewardedAdInteractionCallback == null) {
                return;
            }
            if (z) {
                pAGRewardedAdInteractionCallback.onUserEarnedReward(new PAGRewardItem(i, str));
            } else {
                pAGRewardedAdInteractionCallback.onUserEarnedRewardFail(new PAGErrorModel(i2, str2));
            }
        } else if (z) {
            pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i, str));
        } else {
            pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i2, str2);
        }
    }
}
