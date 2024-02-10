package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.utils.l;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WebViewRenderInterceptor */
public class p implements j {
    private Context a;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.component.adexpress.d.a b;
    private h c;
    private m d;
    private ScheduledFuture<?> e;
    private AtomicBoolean f = new AtomicBoolean(false);

    public p(Context context, m mVar, com.bytedance.sdk.component.adexpress.d.a aVar, h hVar) {
        this.a = context;
        this.d = mVar;
        this.c = hVar;
        this.b = aVar;
        aVar.a(this.c);
    }

    public boolean a(final j.a aVar) {
        int f2 = this.d.f();
        if (f2 < 0) {
            a(aVar, 107);
        } else {
            this.e = f.f().schedule(new a(1, aVar), (long) f2, TimeUnit.MILLISECONDS);
            this.b.a((g) new g() {
                public void a(View view, n nVar) {
                    o b2;
                    p.this.e();
                    if (!aVar.c() && (b2 = aVar.b()) != null) {
                        b2.a(p.this.b, nVar);
                        aVar.a(true);
                    }
                }

                public void a(int i) {
                    p.this.a(aVar, i);
                }
            });
        }
        return true;
    }

    public void a() {
        this.b.d();
        e();
    }

    public void b() {
        this.b.h();
    }

    public void c() {
        this.b.i();
    }

    public com.bytedance.sdk.component.adexpress.d.a d() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            ScheduledFuture<?> scheduledFuture = this.e;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.e.cancel(false);
                this.e = null;
            }
            l.b("RenderInterceptor", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* compiled from: WebViewRenderInterceptor */
    private class a implements Runnable {
        j.a a;
        private int c;

        public a(int i, j.a aVar) {
            this.c = i;
            this.a = aVar;
        }

        public void run() {
            if (this.c == 1) {
                l.b("RenderInterceptor", "WebView Render timeout");
                p.this.b.a(true);
                p.this.a(this.a, 107);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(j.a aVar, int i) {
        if (!aVar.c() && !this.f.get()) {
            e();
            this.d.e().a(i);
            if (aVar.b(this)) {
                aVar.a((j) this);
            } else {
                o b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                } else {
                    return;
                }
            }
            this.f.getAndSet(true);
        }
    }
}
