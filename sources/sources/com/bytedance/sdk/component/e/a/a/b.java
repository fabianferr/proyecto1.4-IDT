package com.bytedance.sdk.component.e.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: CacheManager */
public class b extends a {
    private final d a;
    private final c b = new c();
    private final Queue<String> c;

    public b() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.c = concurrentLinkedQueue;
        this.a = new f(concurrentLinkedQueue);
    }

    public synchronized void a(a aVar, int i) {
        d dVar;
        if (i != 5) {
            if (!(!i.e().m().a(i.e().d()) || (dVar = this.a) == null || aVar == null)) {
                dVar.a(aVar, i);
            }
        }
        c cVar = this.b;
        if (!(cVar == null || aVar == null)) {
            cVar.a(aVar, i);
        }
    }

    public synchronized void a(int i, List<a> list) {
        for (a c2 : list) {
            this.c.remove(c2.c());
        }
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i, list);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(i, list);
        }
    }

    public synchronized List<a> a(int i, int i2, List<String> list) {
        List<a> b2;
        boolean z;
        List<a> a2 = this.a.a(i, i2, list);
        if (a2 == null || a2.size() == 0) {
            ArrayList<String> arrayList = new ArrayList<>(this.c);
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(list);
            }
            a2 = this.b.a(i, i2, arrayList);
            if (!(a2 == null || a2.size() == 0)) {
                HashMap hashMap = new HashMap();
                for (a next : a2) {
                    hashMap.put(next.c(), next);
                }
                c.a("allSendingQueue:" + arrayList.size());
                if (arrayList.size() != 0) {
                    for (String str : arrayList) {
                        if (hashMap.get(str) != null) {
                            c.a("db duplicate delete");
                            hashMap.remove(str);
                        }
                    }
                }
                a2.clear();
                for (String str2 : hashMap.keySet()) {
                    a2.add(hashMap.get(str2));
                }
            }
        } else {
            c.a("memory get " + a2.size());
            if (!((i != 1 && i != 2) || (b2 = this.b.b(a2.get(0), a2.size())) == null || b2.size() == 0)) {
                c.a("db get " + b2.size());
                HashMap hashMap2 = new HashMap();
                for (a next2 : b2) {
                    hashMap2.put(next2.c(), next2);
                }
                ArrayList arrayList2 = new ArrayList(this.c);
                for (a next3 : b2) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (TextUtils.equals(next3.c(), (String) it.next())) {
                            c.a(" duplicate delete ");
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        hashMap2.remove(next3.c());
                    }
                }
                for (a next4 : a2) {
                    hashMap2.put(next4.c(), next4);
                }
                a2.clear();
                for (String str3 : hashMap2.keySet()) {
                    a2.add(hashMap2.get(str3));
                }
            }
        }
        if (a2 != null) {
            if (!a2.isEmpty()) {
                for (a c2 : a2) {
                    this.c.offer(c2.c());
                }
                return a2;
            }
        }
        return new ArrayList();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(int r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.bytedance.sdk.component.e.a.a.d r0 = r2.a     // Catch:{ all -> 0x003a }
            boolean r0 = r0.a((int) r3, (boolean) r4)     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x001a
            java.lang.String r3 = "memory meet"
            com.bytedance.sdk.component.e.a.c.c.c(r3)     // Catch:{ all -> 0x003a }
            com.bytedance.sdk.component.e.a.b.a.a r3 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ all -> 0x003a }
            java.util.concurrent.atomic.AtomicLong r3 = r3.E()     // Catch:{ all -> 0x003a }
            com.bytedance.sdk.component.e.a.c.b.a(r3, r1)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r1
        L_0x001a:
            if (r3 == r1) goto L_0x001f
            r0 = 2
            if (r3 != r0) goto L_0x0037
        L_0x001f:
            com.bytedance.sdk.component.e.a.a.c r0 = r2.b     // Catch:{ all -> 0x003a }
            boolean r3 = r0.a((int) r3, (boolean) r4)     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = "db meet"
            com.bytedance.sdk.component.e.a.c.c.c(r3)     // Catch:{ all -> 0x003a }
            com.bytedance.sdk.component.e.a.b.a.a r3 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ all -> 0x003a }
            java.util.concurrent.atomic.AtomicLong r3 = r3.F()     // Catch:{ all -> 0x003a }
            com.bytedance.sdk.component.e.a.c.b.a(r3, r1)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r1
        L_0x0037:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.b.a(int, boolean):boolean");
    }
}
