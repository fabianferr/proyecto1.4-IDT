package com.mbridge.msdk.foundation.same.report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CommonReportEventGroup */
public final class c {
    private final String a;
    private final Map<String, b> b;

    private c(String str) {
        this.a = str;
        this.b = new ConcurrentHashMap();
    }

    public c() {
        this((String) null);
    }

    public final b a(b bVar, String str, boolean z, boolean z2) {
        b bVar2;
        if (bVar == null) {
            return null;
        }
        if (z) {
            bVar2 = this.b.remove(str);
        } else {
            bVar2 = this.b.get(str);
        }
        if (bVar2 != null) {
            bVar = bVar.a().a(bVar.q() - bVar2.q()).a();
        }
        if (!z2) {
            this.b.put(bVar.i(), bVar);
        }
        return bVar;
    }

    public final b a(b bVar) {
        if (bVar == null) {
            return null;
        }
        this.b.put(bVar.i(), bVar);
        return bVar;
    }
}
