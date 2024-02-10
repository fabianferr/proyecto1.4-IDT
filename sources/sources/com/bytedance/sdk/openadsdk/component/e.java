package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.c.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGAppOpenAdWrapper */
public class e implements b {
    private final PAGAppOpenAdInteractionListener a;
    private final AtomicBoolean b = new AtomicBoolean(false);

    public e(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.a = pAGAppOpenAdInteractionListener;
    }

    public void a() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    public void b() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    public void c() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdDismissed();
        }
    }

    public void d() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (!this.b.getAndSet(true) && (pAGAppOpenAdInteractionListener = this.a) != null) {
            pAGAppOpenAdInteractionListener.onAdDismissed();
        }
    }
}
