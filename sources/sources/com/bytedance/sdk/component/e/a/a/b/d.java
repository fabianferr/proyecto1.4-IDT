package com.bytedance.sdk.component.e.a.a.b;

import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: EventMemoryCacheManager */
public abstract class d<T extends a> {
    private com.bytedance.sdk.component.e.a.d.b.a a;
    private Queue<T> b = new ConcurrentLinkedQueue();
    private Queue<String> c;
    private String d;

    public d(com.bytedance.sdk.component.e.a.d.b.a aVar, Queue<String> queue, String str) {
        this.a = aVar;
        this.c = queue;
        this.d = str;
    }

    public void a(T t) {
        Queue<T> queue = this.b;
        if (queue != null && t != null) {
            queue.offer(t);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.component.e.a.d.a> a(int r2, int r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r2 = r1.b(r2, r3)     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002d
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.b.a r3 = r1.a     // Catch:{ all -> 0x0030 }
            int r3 = r3.a()     // Catch:{ all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ all -> 0x0030 }
        L_0x0012:
            java.util.Queue<T> r3 = r1.b     // Catch:{ all -> 0x0030 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.a r3 = (com.bytedance.sdk.component.e.a.d.a) r3     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x002b
            r2.add(r3)     // Catch:{ all -> 0x0030 }
            int r3 = r2.size()     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.a     // Catch:{ all -> 0x0030 }
            int r0 = r0.b()     // Catch:{ all -> 0x0030 }
            if (r3 != r0) goto L_0x0012
        L_0x002b:
            monitor-exit(r1)
            return r2
        L_0x002d:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0030:
            r2 = move-exception
            monitor-exit(r1)
            goto L_0x0034
        L_0x0033:
            throw r2
        L_0x0034:
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.b.d.a(int, int):java.util.List");
    }

    public synchronized void a(int i, List<T> list) {
        if (i == -1 || i == 200 || i == 509) {
            c.c(this.d + " memory size：" + this.b.size());
        } else {
            this.b.addAll(list);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(int r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Queue<T> r6 = r4.b     // Catch:{ all -> 0x0053 }
            int r6 = r6.size()     // Catch:{ all -> 0x0053 }
            com.bytedance.sdk.component.e.a.d.b.a r0 = r4.a     // Catch:{ all -> 0x0053 }
            int r0 = r0.a()     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r1.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r4.d     // Catch:{ all -> 0x0053 }
            r1.append(r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = " size:"
            r1.append(r2)     // Catch:{ all -> 0x0053 }
            r1.append(r6)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = " cacheCount:"
            r1.append(r2)     // Catch:{ all -> 0x0053 }
            r1.append(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = " message:"
            r1.append(r2)     // Catch:{ all -> 0x0053 }
            r1.append(r5)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0053 }
            com.bytedance.sdk.component.e.a.c.c.c(r1)     // Catch:{ all -> 0x0053 }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r5 == r1) goto L_0x0043
            if (r5 != r3) goto L_0x003e
            goto L_0x0043
        L_0x003e:
            if (r6 < r0) goto L_0x0041
            r2 = 1
        L_0x0041:
            monitor-exit(r4)
            return r2
        L_0x0043:
            boolean r5 = com.bytedance.sdk.component.e.a.c.a.b()     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x004e
            if (r6 < r3) goto L_0x004c
            r2 = 1
        L_0x004c:
            monitor-exit(r4)
            return r2
        L_0x004e:
            if (r6 < r0) goto L_0x0051
            r2 = 1
        L_0x0051:
            monitor-exit(r4)
            return r2
        L_0x0053:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.b.d.b(int, int):boolean");
    }
}
