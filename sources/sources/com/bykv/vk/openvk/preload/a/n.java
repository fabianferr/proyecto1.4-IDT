package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.b.h;

/* compiled from: JsonObject */
public final class n extends k {
    public final h<String, k> a = new h<>();

    public final void a(String str, k kVar) {
        h<String, k> hVar = this.a;
        if (kVar == null) {
            kVar = m.a;
        }
        hVar.put(str, kVar);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof n) && ((n) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
