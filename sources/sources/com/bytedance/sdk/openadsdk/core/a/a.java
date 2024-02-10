package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.core.model.b;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: AdCallBackAdapter */
public class a implements p.a {
    /* access modifiers changed from: private */
    public final p.a a;

    public a(p.a aVar) {
        this.a = aVar;
    }

    public void a(final int i, final String str) {
        if (this.a == null) {
            return;
        }
        if (aa.e()) {
            this.a.a(i, str);
        } else {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    a.this.a.a(i, str);
                }
            });
        }
    }

    public void a(final com.bytedance.sdk.openadsdk.core.model.a aVar, final b bVar) {
        if (this.a == null) {
            return;
        }
        if (aa.e()) {
            this.a.a(aVar, bVar);
        } else {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    a.this.a.a(aVar, bVar);
                }
            });
        }
    }
}
