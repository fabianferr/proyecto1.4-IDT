package com.bytedance.sdk.component.f;

import android.content.Context;
import com.bytedance.sdk.component.b.a.h;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.f.c.b;
import com.bytedance.sdk.component.f.c.f;
import com.bytedance.sdk.component.f.c.g;
import com.bytedance.sdk.component.f.d.b;
import com.bytedance.sdk.component.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: NetClient */
public class a {
    private j a;
    private f b;
    private int c;

    private a(C0054a aVar) {
        j.a b2 = new j.a().a((long) aVar.a, TimeUnit.MILLISECONDS).c((long) aVar.c, TimeUnit.MILLISECONDS).b((long) aVar.b, TimeUnit.MILLISECONDS);
        if (aVar.d) {
            f fVar = new f();
            this.b = fVar;
            b2.a(fVar);
        }
        if (aVar.e != null && aVar.e.size() > 0) {
            for (h a2 : aVar.e) {
                b2.a(a2);
            }
        }
        this.a = b2.a();
    }

    public void a(Context context, boolean z, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        } else if (bVar != null) {
            int a2 = bVar.a();
            this.c = a2;
            f fVar = this.b;
            if (fVar != null) {
                fVar.a(a2);
            }
            g.a().a(this.c).a(z);
            g.a().a(this.c).a(bVar);
            g.a().a(this.c).a(context, q.a(context));
        } else {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
    }

    public void a(Context context, boolean z) {
        com.bytedance.sdk.component.f.c.a.b(true);
        if (a(context) || (!q.a(context) && z)) {
            g.a().a(this.c, context).d();
            g.a().a(this.c, context).a();
        }
        if (q.a(context)) {
            g.a().a(this.c, context).d();
            g.a().a(this.c, context).a();
        }
    }

    public static void a() {
        com.bytedance.sdk.component.f.d.b.a(b.a.DEBUG);
    }

    public d b() {
        return new d(this.a);
    }

    public com.bytedance.sdk.component.f.b.b c() {
        return new com.bytedance.sdk.component.f.b.b(this.a);
    }

    public com.bytedance.sdk.component.f.b.a d() {
        return new com.bytedance.sdk.component.f.b.a(this.a);
    }

    private static boolean a(Context context) {
        String b2 = q.b(context);
        return b2 != null && (b2.endsWith(":push") || b2.endsWith(":pushservice"));
    }

    public j e() {
        return this.a;
    }

    /* renamed from: com.bytedance.sdk.component.f.a$a  reason: collision with other inner class name */
    /* compiled from: NetClient */
    public static final class C0054a {
        int a = 10000;
        int b = 10000;
        int c = 10000;
        boolean d = true;
        final List<h> e = new ArrayList();

        public C0054a a(long j, TimeUnit timeUnit) {
            this.a = a("timeout", j, timeUnit);
            return this;
        }

        public C0054a b(long j, TimeUnit timeUnit) {
            this.b = a("timeout", j, timeUnit);
            return this;
        }

        public C0054a c(long j, TimeUnit timeUnit) {
            this.c = a("timeout", j, timeUnit);
            return this;
        }

        public C0054a a(boolean z) {
            this.d = z;
            return this;
        }

        private static int a(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || j <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public a a() {
            return new a(this);
        }
    }
}
