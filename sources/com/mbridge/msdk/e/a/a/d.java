package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.c;
import com.mbridge.msdk.e.a.m;

/* compiled from: DefaultCacheKeyGenerator */
public final class d implements c {
    public final String a(m<?> mVar) {
        String h = mVar.h();
        int f = mVar.f();
        if (f == 0) {
            return h;
        }
        return Integer.toString(f) + '-' + h;
    }
}
