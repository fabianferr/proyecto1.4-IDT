package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: PAGBannerVideoAdImpl */
public class c extends a {
    public c(Context context, q qVar, AdSlot adSlot) {
        super(context, qVar, adSlot);
    }

    public void a(Context context, q qVar, AdSlot adSlot) {
        this.a = new BannerExpressVideoView(context, qVar, adSlot);
        this.a.addOnAttachStateChangeListener(this.f);
    }

    public a c() {
        if (this.a != null) {
            return ((BannerExpressVideoView) this.a).getVideoModel();
        }
        return null;
    }
}
