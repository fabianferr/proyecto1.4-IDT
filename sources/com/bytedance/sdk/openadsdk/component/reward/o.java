package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.core.model.a;

/* compiled from: TTRewardVideoAdImpl */
class o implements TTClientBidding {
    private final h a;

    o(Context context, a aVar, AdSlot adSlot) {
        this.a = new h(context, aVar, adSlot);
    }

    public h a() {
        return this.a;
    }

    public void b() {
        this.a.a();
    }

    public void win(Double d) {
        this.a.win(d);
    }

    public void loss(Double d, String str, String str2) {
        this.a.loss(d, str, str2);
    }
}
