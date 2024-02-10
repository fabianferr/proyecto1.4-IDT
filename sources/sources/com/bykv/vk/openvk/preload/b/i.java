package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* compiled from: RealInterceptorChain */
final class i implements b {
    protected e a;
    private int b;
    private List<h> c;
    private d d;

    i(List<h> list, int i, e eVar, d dVar) {
        this.c = list;
        this.b = i;
        this.a = eVar;
        this.d = dVar;
    }

    public final Object a(Object obj) throws Exception {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c = obj;
            d dVar2 = this.d;
            if (dVar2.d != null) {
                dVar2.d.b(dVar2.e, dVar2);
            }
        }
        if (this.b >= this.c.size()) {
            return obj;
        }
        h hVar = this.c.get(this.b);
        Class<? extends d> cls = hVar.a;
        d dVar3 = (d) this.a.a(cls);
        if (dVar3 != null) {
            com.bykv.vk.openvk.preload.b.b.a aVar = hVar.b;
            i iVar = new i(this.c, this.b + 1, this.a, dVar3);
            dVar3.a(iVar, this.d, obj, aVar, hVar.c);
            if (dVar3.d != null) {
                dVar3.d.a(dVar3.e, dVar3);
            }
            try {
                Object a2 = dVar3.a(iVar, obj);
                if (dVar3.d != null) {
                    dVar3.d.c(dVar3.e, dVar3);
                }
                return a2;
            } catch (a e) {
                Throwable cause = e.getCause();
                if (dVar3.d != null) {
                    dVar3.d.b(dVar3.e, dVar3, cause);
                }
                throw e;
            } catch (Throwable th) {
                if (dVar3.d != null) {
                    dVar3.d.a(dVar3.e, dVar3, th);
                }
                throw new a(th);
            }
        } else {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
    }

    public final Object a(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }

    public final Object b(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }

    private d c(Class cls) {
        d dVar = this.d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.a;
        }
        return dVar;
    }

    /* compiled from: RealInterceptorChain */
    static final class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
