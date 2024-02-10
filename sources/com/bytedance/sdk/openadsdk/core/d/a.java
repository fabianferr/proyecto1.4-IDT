package com.bytedance.sdk.openadsdk.core.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: FrequentCallController */
public class a {
    private static volatile a a;
    private static volatile boolean b;
    private static volatile long c;
    private final Queue<C0063a> d = new LinkedList();
    private Handler e;
    private final e f = o.d();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005c }
            com.bytedance.sdk.openadsdk.core.settings.e r2 = r9.f     // Catch:{ all -> 0x005c }
            int r2 = r2.x()     // Catch:{ all -> 0x005c }
            com.bytedance.sdk.openadsdk.core.settings.e r3 = r9.f     // Catch:{ all -> 0x005c }
            long r3 = r3.w()     // Catch:{ all -> 0x005c }
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r5 = r9.d     // Catch:{ all -> 0x005c }
            int r5 = r5.size()     // Catch:{ all -> 0x005c }
            r6 = 0
            if (r5 <= 0) goto L_0x004f
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r5 = r9.d     // Catch:{ all -> 0x005c }
            int r5 = r5.size()     // Catch:{ all -> 0x005c }
            if (r5 < r2) goto L_0x004f
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r2 = r9.d     // Catch:{ all -> 0x005c }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x005c }
            com.bytedance.sdk.openadsdk.core.d.a$a r2 = (com.bytedance.sdk.openadsdk.core.d.a.C0063a) r2     // Catch:{ all -> 0x005c }
            long r7 = r2.a     // Catch:{ all -> 0x005c }
            long r7 = r0 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x005c }
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x003f
            long r3 = r3 - r7
            r9.b((long) r3)     // Catch:{ all -> 0x005c }
            monitor-exit(r9)
            r10 = 1
            return r10
        L_0x003f:
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r2 = r9.d     // Catch:{ all -> 0x005c }
            r2.poll()     // Catch:{ all -> 0x005c }
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r2 = r9.d     // Catch:{ all -> 0x005c }
            com.bytedance.sdk.openadsdk.core.d.a$a r3 = new com.bytedance.sdk.openadsdk.core.d.a$a     // Catch:{ all -> 0x005c }
            r3.<init>(r0, r10)     // Catch:{ all -> 0x005c }
            r2.offer(r3)     // Catch:{ all -> 0x005c }
            goto L_0x0059
        L_0x004f:
            java.util.Queue<com.bytedance.sdk.openadsdk.core.d.a$a> r2 = r9.d     // Catch:{ all -> 0x005c }
            com.bytedance.sdk.openadsdk.core.d.a$a r3 = new com.bytedance.sdk.openadsdk.core.d.a$a     // Catch:{ all -> 0x005c }
            r3.<init>(r0, r10)     // Catch:{ all -> 0x005c }
            r2.offer(r3)     // Catch:{ all -> 0x005c }
        L_0x0059:
            monitor-exit(r9)
            r10 = 0
            return r10
        L_0x005c:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.d.a.b(java.lang.String):boolean");
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(c);
        } else {
            a(false);
        }
        return b;
    }

    private synchronized void a(long j) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.postDelayed(new Runnable() {
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z) {
        b = z;
    }

    public synchronized boolean b() {
        return b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0063a aVar : this.d) {
            if (hashMap.containsKey(aVar.b)) {
                hashMap.put(aVar.b, Integer.valueOf(((Integer) hashMap.get(aVar.b)).intValue() + 1));
            } else {
                hashMap.put(aVar.b, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.d.a$a  reason: collision with other inner class name */
    /* compiled from: FrequentCallController */
    private static class C0063a {
        /* access modifiers changed from: private */
        public final long a;
        /* access modifiers changed from: private */
        public final String b;

        private C0063a(long j, String str) {
            this.a = j;
            this.b = str;
        }
    }
}
