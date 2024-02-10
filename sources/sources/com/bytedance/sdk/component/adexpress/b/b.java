package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.dynamic.a.a;
import com.bytedance.sdk.component.adexpress.dynamic.c.f;
import com.bytedance.sdk.component.adexpress.dynamic.c.g;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* compiled from: DynamicRenderInterceptor */
public class b implements j {
    private Context a;
    /* access modifiers changed from: private */
    public a b;
    private ThemeStatusBroadcastReceiver c;
    private h d;
    /* access modifiers changed from: private */
    public m e;
    /* access modifiers changed from: private */
    public int f;

    public void b() {
    }

    public void c() {
    }

    public b(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, h hVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar, a aVar2) {
        this.a = context;
        this.e = mVar;
        this.c = themeStatusBroadcastReceiver;
        this.d = hVar;
        if (aVar2 != null) {
            this.b = aVar2;
        } else {
            this.b = new a(context, themeStatusBroadcastReceiver, z, gVar, mVar, aVar);
        }
        this.b.a(this.d);
        if (gVar instanceof f) {
            this.f = 3;
        } else {
            this.f = 2;
        }
    }

    public boolean a(final j.a aVar) {
        this.e.e().b(this.f);
        this.b.a((g) new g() {
            public void a(View view, n nVar) {
                if (!aVar.c()) {
                    b.this.e.e().f(b.this.f);
                    b.this.e.e().g(b.this.f);
                    b.this.e.e().h();
                    o b2 = aVar.b();
                    if (b2 != null) {
                        b2.a(b.this.b, nVar);
                        aVar.a(true);
                    }
                }
            }

            public void a(int i) {
                b.this.e.e().a(b.this.f, i, aVar.b(b.this));
                if (aVar.b(b.this)) {
                    aVar.a((j) b.this);
                    return;
                }
                o b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                }
            }
        });
        return true;
    }

    public void a() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public d d() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }
}
