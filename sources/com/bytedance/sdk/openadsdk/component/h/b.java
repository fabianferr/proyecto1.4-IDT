package com.bytedance.sdk.openadsdk.component.h;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.c.a;

/* compiled from: TTAppOpenVideoController */
public class b extends a {
    public b(Context context, ViewGroup viewGroup, q qVar) {
        super(context, viewGroup, qVar, (g) null);
    }

    public void a(o.a aVar) {
        com.bytedance.sdk.openadsdk.b.d.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.f, aVar, (g) null);
    }

    public void r() {
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h());
        aVar.b(f());
        aVar.d(g());
        com.bytedance.sdk.openadsdk.b.d.a.a.e(this.f, aVar);
    }
}
