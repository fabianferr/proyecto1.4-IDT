package com.bytedance.sdk.openadsdk.apiImpl.c;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: PAGAppOpenAdListenerAdapter */
public class a implements PAGAppOpenAdLoadListener {
    /* access modifiers changed from: private */
    public final PAGAppOpenAdLoadListener a;

    public a(PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        this.a = pAGAppOpenAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.onError(i, str);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGAppOpenAd pAGAppOpenAd) {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.onAdLoaded(pAGAppOpenAd);
                    }
                }
            });
        }
    }
}
