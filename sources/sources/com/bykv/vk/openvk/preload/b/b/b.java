package com.bykv.vk.openvk.preload.b.b;

import com.bykv.vk.openvk.preload.b.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventListenerWrapper */
public final class b extends a {
    private List<a> a;

    public b(a... aVarArr) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(Arrays.asList(aVarArr));
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.a.add(aVar);
        }
    }

    public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a next : this.a) {
            if (next != null) {
                next.a(bVar, dVar);
            }
        }
    }

    public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a next : this.a) {
            if (next != null) {
                next.b(bVar, dVar);
            }
        }
    }

    public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a next : this.a) {
            if (next != null) {
                next.c(bVar, dVar);
            }
        }
    }

    public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a next : this.a) {
            if (next != null) {
                next.a(bVar, dVar, th);
            }
        }
    }

    public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a next : this.a) {
            if (next != null) {
                next.c(bVar, dVar, th);
            }
        }
    }

    public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a next : this.a) {
            if (next != null) {
                next.b(bVar, dVar, th);
            }
        }
    }
}
