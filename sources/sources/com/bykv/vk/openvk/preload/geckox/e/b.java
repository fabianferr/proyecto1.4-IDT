package com.bykv.vk.openvk.preload.geckox.e;

import com.bykv.vk.openvk.preload.b.b.a;
import com.bykv.vk.openvk.preload.b.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ListenerProvider */
public final class b {
    private final Map<Class<? extends d<?, ?>>, com.bykv.vk.openvk.preload.b.b.b> a = new HashMap();

    public final void a(Class<? extends d<?, ?>> cls, a aVar) {
        synchronized (this.a) {
            com.bykv.vk.openvk.preload.b.b.b bVar = this.a.get(cls);
            if (bVar == null) {
                bVar = new com.bykv.vk.openvk.preload.b.b.b(new a[0]);
                this.a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public final a a(Class<? extends d<?, ?>> cls) {
        a aVar;
        synchronized (this.a) {
            aVar = this.a.get(cls);
        }
        return aVar;
    }
}
