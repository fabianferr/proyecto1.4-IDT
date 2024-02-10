package com.bytedance.sdk.openadsdk.apiImpl.feed;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: PAGNativeFeedAdWrapperListenerImpl */
public class g implements f {
    /* access modifiers changed from: private */
    public final PAGNativeAdInteractionListener a;

    public g(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.a = pAGNativeAdInteractionListener;
    }

    public void a(View view, PAGNativeAd pAGNativeAd) {
        aa.a((Runnable) new Runnable() {
            public void run() {
                if (g.this.a != null) {
                    g.this.a.onAdClicked();
                }
            }
        });
    }

    public void b(View view, PAGNativeAd pAGNativeAd) {
        aa.a((Runnable) new Runnable() {
            public void run() {
                if (g.this.a != null) {
                    g.this.a.onAdClicked();
                }
            }
        });
    }

    public void a(PAGNativeAd pAGNativeAd) {
        aa.a((Runnable) new Runnable() {
            public void run() {
                if (g.this.a != null) {
                    g.this.a.onAdShowed();
                }
            }
        });
    }

    public void a() {
        aa.a((Runnable) new Runnable() {
            public void run() {
                if (g.this.a != null) {
                    g.this.a.onAdDismissed();
                }
            }
        });
    }

    public boolean b() {
        return this.a != null;
    }
}
