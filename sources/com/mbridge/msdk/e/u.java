package com.mbridge.msdk.e;

import com.mbridge.msdk.e.a.e;
import com.mbridge.msdk.e.a.k;
import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.o;
import com.mbridge.msdk.e.a.r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ReportRequest */
public final class u<T> extends m<T> {
    private Map<String, String> a;
    private m.b b;
    private o.b<T> c;
    private v d;
    private e e;

    public u(String str, int i) {
        super(i, str);
    }

    public u(String str, int i, int i2) {
        super(i, str, i2);
    }

    public final void a(v vVar) {
        this.d = vVar;
    }

    public final void a(m.b bVar) {
        this.b = bVar;
    }

    public final void a(Map<String, String> map) {
        this.a = map;
    }

    public final void a(o.b<T> bVar) {
        this.c = bVar;
    }

    public final r a() {
        if (y.a((Object) this.e)) {
            this.e = new e(30000, 5, 1.0f);
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final o<T> a(k kVar) {
        return this.d.a(kVar);
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> b() {
        return this.a;
    }

    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        return hashMap;
    }

    public final m.b d() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public final void a(T t) {
        o.b<T> bVar = this.c;
        this.c = bVar;
        if (bVar != null) {
            bVar.a(t);
        }
    }
}
