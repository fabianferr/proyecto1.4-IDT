package com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;

/* compiled from: PAGFeedExpressVideoView */
public class a extends b {
    public a(Context context, q qVar, AdSlot adSlot) {
        super(context, qVar, adSlot);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.j = new NativeExpressVideoView(this.h, this.b, this.i, this.k);
        this.a.a(((NativeExpressVideoView) this.j).getVideoController());
        c();
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a b() {
        if (this.j != null) {
            return ((NativeExpressVideoView) this.j).getVideoModel();
        }
        return null;
    }
}
