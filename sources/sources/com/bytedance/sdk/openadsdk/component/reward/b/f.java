package com.bytedance.sdk.openadsdk.component.reward.b;

import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.model.t;

/* compiled from: RewardFullTypeFactory */
public class f {
    public static b a(a aVar) {
        q qVar = aVar.a;
        if ((qVar instanceof r) && ((r) qVar).bw()) {
            return new e(aVar);
        }
        if (t.k(qVar)) {
            return new i(aVar);
        }
        if (g.c(qVar)) {
            return new g(aVar);
        }
        if (h.a(qVar)) {
            return new h(aVar);
        }
        if (i.a(qVar)) {
            return new i(aVar);
        }
        if (c.a(qVar)) {
            return new c(aVar);
        }
        return new d(aVar);
    }
}
