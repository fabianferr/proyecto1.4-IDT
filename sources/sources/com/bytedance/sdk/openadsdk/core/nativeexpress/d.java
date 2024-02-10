package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.dynamic.a.a;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: DynamicViewRender */
public class d extends a {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public g b;
    private final h c = new h("dynamic_render_template") {
        public void run() {
            d.this.a.c();
            l.c().post(d.this.d);
        }
    };
    /* access modifiers changed from: private */
    public final Runnable d = new Runnable() {
        public void run() {
            if (d.this.b != null) {
                d dVar = d.this;
                d.super.a(dVar.b);
            }
        }
    };

    public d(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.c.g gVar, m mVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        super(context, themeStatusBroadcastReceiver, z, gVar, mVar, aVar);
        this.a = mVar;
    }

    public void a(g gVar) {
        this.b = gVar;
        aa.b(this.c);
    }

    public void b() {
        super.b();
        l.c().removeCallbacks(this.d);
    }
}
