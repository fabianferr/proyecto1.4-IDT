package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.a.e;
import com.bykv.vk.openvk.preload.a.b;
import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class d implements u, Cloneable {
    public static final d a = new d();
    public double b = -1.0d;
    public int c = 136;
    public boolean d = true;
    public boolean e;
    public List<b> f = Collections.emptyList();
    public List<b> g = Collections.emptyList();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean a(Class<?> cls) {
        if (this.b != -1.0d && !a((com.bykv.vk.openvk.preload.a.a.d) cls.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((this.d || !c(cls)) && !b(cls)) {
            return false;
        }
        return true;
    }

    public final boolean a(boolean z) {
        for (b b2 : z ? this.f : this.g) {
            if (b2.b()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls)) {
            return cls.isAnonymousClass() || cls.isLocalClass();
        }
        return false;
    }

    public static boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private static boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean a(com.bykv.vk.openvk.preload.a.a.d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.a() > this.b;
    }

    public final <T> t<T> a(f fVar, a<T> aVar) {
        boolean a2 = a((Class<?>) aVar.b);
        final boolean z = a2 || a(true);
        final boolean z2 = a2 || a(false);
        if (!z && !z2) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        return new t<T>() {
            private t<T> f;

            public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (!z2) {
                    return b().a(aVar);
                }
                aVar.o();
                return null;
            }

            public final void a(c cVar, T t) throws IOException {
                if (z) {
                    cVar.e();
                } else {
                    b().a(cVar, t);
                }
            }

            private t<T> b() {
                t<T> tVar = this.f;
                if (tVar != null) {
                    return tVar;
                }
                t<T> a2 = fVar2.a((u) d.this, aVar2);
                this.f = a2;
                return a2;
            }
        };
    }
}
