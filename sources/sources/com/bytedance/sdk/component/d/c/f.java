package com.bytedance.sdk.component.d.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.b;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.c.a.a;
import com.bytedance.sdk.component.d.c.a.b.e;
import com.bytedance.sdk.component.d.d;
import com.bytedance.sdk.component.d.l;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.p;
import com.bytedance.sdk.component.d.q;
import com.bytedance.sdk.component.d.r;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: LoadFactory */
public class f {
    private Map<String, List<c>> a = new ConcurrentHashMap();
    private final m b;
    private Map<String, q> c = new HashMap();
    private Map<String, r> d = new HashMap();
    private Map<String, c> e = new HashMap();
    private d f;
    private l g;
    private ExecutorService h;
    private p i;

    public f(Context context, m mVar) {
        this.b = (m) h.a(mVar);
        a.a(context, mVar.h());
    }

    public Collection<r> a() {
        return this.d.values();
    }

    public Collection<c> b() {
        return this.e.values();
    }

    public q a(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        q qVar = this.c.get(file);
        if (qVar != null) {
            return qVar;
        }
        q d2 = d(bVar);
        this.c.put(file, d2);
        return d2;
    }

    private q d(b bVar) {
        q d2 = this.b.d();
        if (d2 != null) {
            return com.bytedance.sdk.component.d.c.a.b.a.a(d2);
        }
        return com.bytedance.sdk.component.d.c.a.b.a.a(bVar.b());
    }

    public r b(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        r rVar = this.d.get(file);
        if (rVar != null) {
            return rVar;
        }
        r e2 = e(bVar);
        this.d.put(file, e2);
        return e2;
    }

    private r e(b bVar) {
        r e2 = this.b.e();
        if (e2 != null) {
            return e2;
        }
        return e.a(bVar.b());
    }

    public c c(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        c cVar = this.e.get(file);
        if (cVar != null) {
            return cVar;
        }
        c f2 = f(bVar);
        this.e.put(file, f2);
        return f2;
    }

    public c a(String str) {
        return c(a.a(new File(str)));
    }

    private c f(b bVar) {
        c f2 = this.b.f();
        if (f2 != null) {
            return f2;
        }
        return new com.bytedance.sdk.component.d.c.a.a.b(bVar.e(), bVar.a(), e());
    }

    public d c() {
        if (this.f == null) {
            this.f = h();
        }
        return this.f;
    }

    private d h() {
        d c2 = this.b.c();
        return c2 == null ? com.bytedance.sdk.component.d.b.b.a() : c2;
    }

    public l d() {
        if (this.g == null) {
            this.g = i();
        }
        return this.g;
    }

    private l i() {
        l a2 = this.b.a();
        if (a2 != null) {
            return a2;
        }
        return com.bytedance.sdk.component.d.a.b.a();
    }

    public ExecutorService e() {
        if (this.h == null) {
            this.h = j();
        }
        return this.h;
    }

    private ExecutorService j() {
        ExecutorService b2 = this.b.b();
        if (b2 != null) {
            return b2;
        }
        return com.bytedance.sdk.component.d.a.c.a();
    }

    public Map<String, List<c>> f() {
        return this.a;
    }

    public com.bytedance.sdk.component.d.c.b.a a(c cVar) {
        ImageView.ScaleType d2 = cVar.d();
        if (d2 == null) {
            d2 = com.bytedance.sdk.component.d.c.b.a.a;
        }
        ImageView.ScaleType scaleType = d2;
        Bitmap.Config j = cVar.j();
        if (j == null) {
            j = com.bytedance.sdk.component.d.c.b.a.b;
        }
        return new com.bytedance.sdk.component.d.c.b.a(cVar.b(), cVar.c(), scaleType, j, cVar.f(), cVar.g());
    }

    public p g() {
        if (this.i == null) {
            this.i = k();
        }
        return this.i;
    }

    private p k() {
        p g2 = this.b.g();
        return g2 == null ? new g() : g2;
    }
}
