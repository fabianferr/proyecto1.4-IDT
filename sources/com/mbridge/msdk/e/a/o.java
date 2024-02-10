package com.mbridge.msdk.e.a;

import com.mbridge.msdk.e.a.a;

/* compiled from: Response */
public final class o<T> {
    public final T a;
    public final a.C0133a b;
    public final u c;
    public boolean d;

    /* compiled from: Response */
    public interface a {
        void a(u uVar);
    }

    /* compiled from: Response */
    public interface b<T> {
        void a(T t);
    }

    public static <T> o<T> a(T t, a.C0133a aVar) {
        return new o<>(t, aVar);
    }

    public static <T> o<T> a(u uVar) {
        return new o<>(uVar);
    }

    public final boolean a() {
        return this.c == null;
    }

    private o(T t, a.C0133a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    private o(u uVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = uVar;
    }
}
