package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.b;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public final class k {
    private final Map<String, c> a = new LinkedHashMap();
    private final Map<String, c> b = new LinkedHashMap();
    private final Map<String, c> c = new LinkedHashMap();

    private void a(d.e eVar, String str, c cVar) {
        Map<String, c> a2;
        if (!TextUtils.isEmpty(str) && (a2 = a(eVar)) != null) {
            a2.put(str, cVar);
        }
    }

    public final c a(d.e eVar, b bVar) {
        c cVar = new c(bVar);
        a(eVar, bVar.b, cVar);
        return cVar;
    }

    public final c a(d.e eVar, String str) {
        Map<String, c> a2;
        if (TextUtils.isEmpty(str) || (a2 = a(eVar)) == null) {
            return null;
        }
        return a2.get(str);
    }

    /* access modifiers changed from: package-private */
    public Map<String, c> a(d.e eVar) {
        if (eVar.name().equalsIgnoreCase(d.e.RewardedVideo.name())) {
            return this.a;
        }
        if (eVar.name().equalsIgnoreCase(d.e.c.name())) {
            return this.b;
        }
        if (eVar.name().equalsIgnoreCase(d.e.a.name())) {
            return this.c;
        }
        return null;
    }

    public final Collection<c> b(d.e eVar) {
        Map<String, c> a2 = a(eVar);
        return a2 != null ? a2.values() : new ArrayList();
    }
}
