package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.f.c;

/* compiled from: Response */
public final class l<T> {
    public T a;
    public a b;
    public c c;

    public static <T> l<T> a(T t, c cVar) {
        return new l<>(t, cVar);
    }

    public static <T> l<T> a(a aVar) {
        return new l<>(aVar);
    }

    private l(T t, c cVar) {
        this.b = null;
        this.a = t;
        this.c = cVar;
    }

    private l(a aVar) {
        this.a = null;
        this.c = null;
        this.b = aVar;
    }
}
