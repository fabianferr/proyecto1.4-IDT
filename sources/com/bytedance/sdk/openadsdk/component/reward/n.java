package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.core.model.a;

/* compiled from: TTFullScreenVideoAdImpl */
class n implements TTClientBidding {
    private final f a;

    n(Context context, a aVar) {
        this.a = new f(context, aVar);
    }

    public f a() {
        return this.a;
    }

    public void a(boolean z) {
        this.a.a(z);
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
