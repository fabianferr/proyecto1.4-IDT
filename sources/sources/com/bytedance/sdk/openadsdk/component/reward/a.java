package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;

/* compiled from: ChooseAdHelper */
public class a {
    public static void a(com.bytedance.sdk.openadsdk.core.model.a aVar, int i) {
        if (aVar != null && aVar.c() != null && aVar.c().size() > 0) {
            if (i >= aVar.c().size()) {
                i = 0;
            }
            q qVar = aVar.c().get(i);
            a(qVar, !TextUtils.isEmpty(d.a(o.a()).a(qVar)));
        }
    }

    public static void a(final q qVar, final boolean z) {
        l.b().post(new Runnable() {
            public void run() {
                if (qVar != null) {
                    try {
                        Context a2 = o.a();
                        AdSlot D = qVar.D();
                        if (D != null) {
                            e.a(a2).a(D.getCodeId());
                            if (z) {
                                e.a(a2).b(D);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
