package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.m;

/* compiled from: LastShowAdManager */
public class k {
    public static void a(final q qVar, final String str) {
        if (qVar != null) {
            h.a().post(new Runnable() {
                public void run() {
                    try {
                        m.a(qVar.ao().toString(), str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
