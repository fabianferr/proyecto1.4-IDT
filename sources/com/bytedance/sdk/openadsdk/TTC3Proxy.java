package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.reward.e;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.j;
import com.bytedance.sdk.openadsdk.component.reward.l;

public class TTC3Proxy {
    public static void verityPlayable(String str, int i, String str2, String str3, String str4) {
        j.a(str, i, str2, str3, str4);
    }

    public static void loadReward(Context context, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        adSlot.setDurationSlotType(7);
        l.a(context).a(adSlot, (b) new g(pAGRewardedAdLoadListener));
    }

    public static void loadFull(Context context, AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        adSlot.setDurationSlotType(8);
        e.a(context).a(adSlot, (b) new com.bytedance.sdk.openadsdk.component.c.b(pAGInterstitialAdLoadListener));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r1) {
        /*
            com.bytedance.sdk.openadsdk.component.reward.l r0 = com.bytedance.sdk.openadsdk.component.reward.l.a((android.content.Context) r1)     // Catch:{ all -> 0x0007 }
            r0.a()     // Catch:{ all -> 0x0007 }
        L_0x0007:
            com.bytedance.sdk.openadsdk.component.reward.e r1 = com.bytedance.sdk.openadsdk.component.reward.e.a((android.content.Context) r1)     // Catch:{ all -> 0x000e }
            r1.a()     // Catch:{ all -> 0x000e }
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.TTC3Proxy.a(android.content.Context):void");
    }
}
