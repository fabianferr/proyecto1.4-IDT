package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.j;

/* compiled from: NativeRenderInterceptor */
public class f implements j {
    private Context a;
    /* access modifiers changed from: private */
    public a b;
    private m c;

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public f(Context context, m mVar, a aVar) {
        this.a = context;
        this.b = aVar;
        this.c = mVar;
    }

    public boolean a(final j.a aVar) {
        this.c.e().d();
        this.b.a(new g() {
            public void a(View view, n nVar) {
                if (!aVar.c()) {
                    o b2 = aVar.b();
                    if (b2 != null) {
                        b2.a(f.this.b, nVar);
                    }
                    aVar.a(true);
                }
            }

            public void a(int i) {
                o b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                }
            }
        });
        return true;
    }

    public void a(c cVar) {
        this.b.a(cVar);
    }
}
