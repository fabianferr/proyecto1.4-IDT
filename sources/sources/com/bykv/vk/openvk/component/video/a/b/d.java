package com.bykv.vk.openvk.component.video.a.b;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.a.b.b;
import com.bykv.vk.openvk.component.video.a.b.b.c;
import com.bytedance.sdk.component.g.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Preloader */
public class d {
    private static volatile d e;
    private volatile int a = 163840;
    /* access modifiers changed from: private */
    public final SparseArray<Map<String, b>> b;
    /* access modifiers changed from: private */
    public final b<Runnable> c;
    private final ExecutorService d;
    private volatile c f;
    private volatile com.bykv.vk.openvk.component.video.a.b.a.c g;
    private volatile com.bykv.vk.openvk.component.video.a.b.a.b h;
    private final HashSet<a> i;
    private final b.C0030b j;
    private volatile c k;
    private volatile c l;
    private volatile String m;
    private volatile boolean n;

    /* access modifiers changed from: package-private */
    public void a(com.bykv.vk.openvk.component.video.a.b.a.c cVar) {
        this.g = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f = cVar;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.a = i2;
        }
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i2);
        }
    }

    private d() {
        SparseArray<Map<String, b>> sparseArray = new SparseArray<>(2);
        this.b = sparseArray;
        this.i = new HashSet<>();
        this.j = new b.C0030b() {
            public void a(b bVar) {
                int f = bVar.f();
                synchronized (d.this.b) {
                    Map map = (Map) d.this.b.get(f);
                    if (map != null) {
                        map.remove(bVar.h);
                    }
                }
                if (e.c) {
                    Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.h);
                }
            }
        };
        b<Runnable> bVar = new b<>();
        this.c = bVar;
        ExecutorService a2 = a(bVar);
        this.d = a2;
        bVar.a((ThreadPoolExecutor) a2);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public synchronized void a(long j2, long j3, long j4) {
    }

    /* access modifiers changed from: package-private */
    public c a() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return this.l;
    }

    public static d c() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.bykv.vk.openvk.component.video.a.b.b} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v15, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r8, java.lang.String r9) {
        /*
            r7 = this;
            r7.m = r9
            r7.n = r8
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setCurrentPlayKey, "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
        L_0x001b:
            r0 = 0
            if (r9 != 0) goto L_0x0075
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r1 = r7.i
            monitor-enter(r1)
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r8 = r7.i     // Catch:{ all -> 0x0072 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0072 }
            if (r8 != 0) goto L_0x0035
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0072 }
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r8 = r7.i     // Catch:{ all -> 0x0072 }
            r0.<init>(r8)     // Catch:{ all -> 0x0072 }
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r8 = r7.i     // Catch:{ all -> 0x0072 }
            r8.clear()     // Catch:{ all -> 0x0072 }
        L_0x0035:
            monitor-exit(r1)     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0136
            java.util.Iterator r8 = r0.iterator()
        L_0x003c:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0136
            java.lang.Object r9 = r8.next()
            com.bykv.vk.openvk.component.video.a.b.d$a r9 = (com.bykv.vk.openvk.component.video.a.b.d.a) r9
            boolean r1 = r9.a
            boolean r2 = r9.b
            int r3 = r9.c
            java.lang.String r4 = r9.d
            java.util.Map<java.lang.String, java.lang.String> r5 = r9.e
            java.lang.String[] r6 = r9.f
            r0 = r7
            r0.a(r1, r2, r3, r4, r5, r6)
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setCurrentPlayKey, resume preload: "
            r1.<init>(r2)
            java.lang.String r9 = r9.d
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            android.util.Log.i(r0, r9)
            goto L_0x003c
        L_0x0072:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0072 }
            throw r8
        L_0x0075:
            int r1 = com.bykv.vk.openvk.component.video.a.b.e.h
            r2 = 3
            if (r1 == r2) goto L_0x00a4
            r3 = 2
            if (r1 != r3) goto L_0x007e
            goto L_0x00a4
        L_0x007e:
            r2 = 1
            if (r1 != r2) goto L_0x0136
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r1 = r7.b
            monitor-enter(r1)
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r2 = r7.b     // Catch:{ all -> 0x00a1 }
            int r8 = com.bykv.vk.openvk.component.video.a.b.b.b.a(r8)     // Catch:{ all -> 0x00a1 }
            java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x00a1 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ all -> 0x00a1 }
            if (r8 == 0) goto L_0x0099
            java.lang.Object r8 = r8.remove(r9)     // Catch:{ all -> 0x00a1 }
            r0 = r8
            com.bykv.vk.openvk.component.video.a.b.b r0 = (com.bykv.vk.openvk.component.video.a.b.b) r0     // Catch:{ all -> 0x00a1 }
        L_0x0099:
            monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0136
            r0.a()
            goto L_0x0136
        L_0x00a1:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
            throw r8
        L_0x00a4:
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r8 = r7.b
            monitor-enter(r8)
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r9 = r7.b     // Catch:{ all -> 0x0137 }
            int r9 = r9.size()     // Catch:{ all -> 0x0137 }
            r3 = 0
        L_0x00ae:
            if (r3 >= r9) goto L_0x00da
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r4 = r7.b     // Catch:{ all -> 0x0137 }
            int r5 = r4.keyAt(r3)     // Catch:{ all -> 0x0137 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x0137 }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x0137 }
            if (r4 == 0) goto L_0x00d7
            java.util.Collection r5 = r4.values()     // Catch:{ all -> 0x0137 }
            if (r5 == 0) goto L_0x00d4
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x0137 }
            if (r6 != 0) goto L_0x00d4
            if (r0 != 0) goto L_0x00d1
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0137 }
            r0.<init>()     // Catch:{ all -> 0x0137 }
        L_0x00d1:
            r0.addAll(r5)     // Catch:{ all -> 0x0137 }
        L_0x00d4:
            r4.clear()     // Catch:{ all -> 0x0137 }
        L_0x00d7:
            int r3 = r3 + 1
            goto L_0x00ae
        L_0x00da:
            monitor-exit(r8)     // Catch:{ all -> 0x0137 }
            if (r0 == 0) goto L_0x0136
            boolean r8 = r0.isEmpty()
            if (r8 != 0) goto L_0x0136
            java.util.Iterator r8 = r0.iterator()
        L_0x00e7:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0110
            java.lang.Object r9 = r8.next()
            com.bykv.vk.openvk.component.video.a.b.b r9 = (com.bykv.vk.openvk.component.video.a.b.b) r9
            r9.a()
            boolean r3 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r3 == 0) goto L_0x00e7
            java.lang.String r3 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "setCurrentPlayKey, cancel preload: "
            r4.<init>(r5)
            java.lang.String r9 = r9.g
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            android.util.Log.i(r3, r9)
            goto L_0x00e7
        L_0x0110:
            if (r1 != r2) goto L_0x0136
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r8 = r7.i
            monitor-enter(r8)
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x0133 }
        L_0x0119:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0131
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x0133 }
            com.bykv.vk.openvk.component.video.a.b.b r0 = (com.bykv.vk.openvk.component.video.a.b.b) r0     // Catch:{ all -> 0x0133 }
            java.lang.Object r0 = r0.n     // Catch:{ all -> 0x0133 }
            com.bykv.vk.openvk.component.video.a.b.d$a r0 = (com.bykv.vk.openvk.component.video.a.b.d.a) r0     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0119
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r1 = r7.i     // Catch:{ all -> 0x0133 }
            r1.add(r0)     // Catch:{ all -> 0x0133 }
            goto L_0x0119
        L_0x0131:
            monitor-exit(r8)     // Catch:{ all -> 0x0133 }
            goto L_0x0136
        L_0x0133:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0133 }
            throw r9
        L_0x0136:
            return
        L_0x0137:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0137 }
            goto L_0x013b
        L_0x013a:
            throw r9
        L_0x013b:
            goto L_0x013a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.d.a(boolean, java.lang.String):void");
    }

    public void a(boolean z, boolean z2, int i2, String str, String... strArr) {
        a(z, z2, i2, str, (Map<String, String>) null, strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x015a A[Catch:{ all -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0181 A[Catch:{ all -> 0x01cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r23, boolean r24, int r25, java.lang.String r26, java.util.Map<java.lang.String, java.lang.String> r27, java.lang.String... r28) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r9 = r26
            r10 = r28
            java.lang.String r11 = "cancel preload: "
            java.lang.String r12 = "cancel preload: "
            java.lang.String r13 = "cancel preload: "
            boolean r2 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = "TAG_PROXY_Preloader"
            java.lang.String r3 = "preload start ！！！！"
            android.util.Log.d(r2, r3)
        L_0x0019:
            if (r0 == 0) goto L_0x001e
            com.bykv.vk.openvk.component.video.a.b.a.b r2 = r1.h
            goto L_0x0020
        L_0x001e:
            com.bykv.vk.openvk.component.video.a.b.a.c r2 = r1.g
        L_0x0020:
            r14 = r2
            com.bykv.vk.openvk.component.video.a.b.b.c r15 = r1.f
            if (r14 == 0) goto L_0x01d2
            if (r15 != 0) goto L_0x0029
            goto L_0x01d2
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r26)
            if (r2 != 0) goto L_0x01d1
            if (r10 == 0) goto L_0x01d1
            int r2 = r10.length
            if (r2 > 0) goto L_0x0036
            goto L_0x01d1
        L_0x0036:
            if (r25 > 0) goto L_0x003c
            int r2 = r1.a
            r8 = r2
            goto L_0x003e
        L_0x003c:
            r8 = r25
        L_0x003e:
            if (r24 == 0) goto L_0x0042
            r7 = r9
            goto L_0x0047
        L_0x0042:
            java.lang.String r2 = com.bykv.vk.openvk.component.video.api.f.b.a((java.lang.String) r26)
            r7 = r2
        L_0x0047:
            java.io.File r2 = r14.d(r7)
            if (r2 == 0) goto L_0x007a
            long r3 = r2.length()
            long r5 = (long) r8
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 < 0) goto L_0x007a
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x0079
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "no need preload, file size: "
            r3.<init>(r4)
            long r4 = r2.length()
            r3.append(r4)
            java.lang.String r2 = ", need preload size: "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r2 = r3.toString()
            android.util.Log.i(r0, r2)
        L_0x0079:
            return
        L_0x007a:
            com.bykv.vk.openvk.component.video.a.b.f r2 = com.bykv.vk.openvk.component.video.a.b.f.a()
            int r3 = com.bykv.vk.openvk.component.video.a.b.b.b.a(r23)
            boolean r2 = r2.a((int) r3, (java.lang.String) r7)
            if (r2 == 0) goto L_0x00a0
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x009f
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "has running proxy task, skip preload for key: "
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r0, r2)
        L_0x009f:
            return
        L_0x00a0:
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r6 = r1.b
            monitor-enter(r6)
            android.util.SparseArray<java.util.Map<java.lang.String, com.bykv.vk.openvk.component.video.a.b.b>> r2 = r1.b     // Catch:{ all -> 0x01ca }
            r16 = 0
            r5 = 1
            if (r0 == 0) goto L_0x00ac
            r3 = 1
            goto L_0x00ad
        L_0x00ac:
            r3 = 0
        L_0x00ad:
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x01ca }
            r4 = r2
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x01ca }
            boolean r2 = r4.containsKey(r7)     // Catch:{ all -> 0x01ca }
            if (r2 == 0) goto L_0x00bc
            monitor-exit(r6)     // Catch:{ all -> 0x01ca }
            return
        L_0x00bc:
            com.bykv.vk.openvk.component.video.a.b.d$a r3 = new com.bykv.vk.openvk.component.video.a.b.d$a     // Catch:{ all -> 0x01ca }
            r2 = r3
            r10 = r3
            r3 = r23
            r17 = r4
            r4 = r24
            r18 = r15
            r15 = 1
            r5 = r8
            r19 = r6
            r6 = r26
            r20 = r7
            r7 = r27
            r21 = r8
            r8 = r28
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = r1.m     // Catch:{ all -> 0x01cf }
            if (r2 == 0) goto L_0x014e
            int r3 = com.bykv.vk.openvk.component.video.a.b.e.h     // Catch:{ all -> 0x01cf }
            r4 = 3
            if (r3 != r4) goto L_0x010a
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r2 = r1.i     // Catch:{ all -> 0x01cf }
            monitor-enter(r2)     // Catch:{ all -> 0x01cf }
            java.util.HashSet<com.bykv.vk.openvk.component.video.a.b.d$a> r0 = r1.i     // Catch:{ all -> 0x0107 }
            r0.add(r10)     // Catch:{ all -> 0x0107 }
            monitor-exit(r2)     // Catch:{ all -> 0x0107 }
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x0105
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cf }
            r2.<init>(r11)     // Catch:{ all -> 0x01cf }
            r2.append(r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r3 = ", add to pending queue"
            r2.append(r3)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cf }
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cf }
        L_0x0105:
            monitor-exit(r19)     // Catch:{ all -> 0x01cf }
            return
        L_0x0107:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0107 }
            throw r0     // Catch:{ all -> 0x01cf }
        L_0x010a:
            r4 = 2
            if (r3 != r4) goto L_0x0124
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cf }
            r2.<init>(r13)     // Catch:{ all -> 0x01cf }
            r2.append(r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cf }
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cf }
        L_0x0122:
            monitor-exit(r19)     // Catch:{ all -> 0x01cf }
            return
        L_0x0124:
            if (r3 != r15) goto L_0x014e
            boolean r3 = r1.n     // Catch:{ all -> 0x01cf }
            if (r3 != r0) goto L_0x014e
            r0 = r20
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x01cf }
            if (r2 == 0) goto L_0x0150
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x014c
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cf }
            r2.<init>(r12)     // Catch:{ all -> 0x01cf }
            r2.append(r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r3 = ", it is playing"
            r2.append(r3)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cf }
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cf }
        L_0x014c:
            monitor-exit(r19)     // Catch:{ all -> 0x01cf }
            return
        L_0x014e:
            r0 = r20
        L_0x0150:
            java.util.List r2 = com.bykv.vk.openvk.component.video.a.c.a.a((java.util.Map<java.lang.String, java.lang.String>) r27)     // Catch:{ all -> 0x01cf }
            java.util.List r2 = com.bykv.vk.openvk.component.video.a.c.a.a((java.util.List<com.bykv.vk.openvk.component.video.a.b.i.b>) r2)     // Catch:{ all -> 0x01cf }
            if (r2 == 0) goto L_0x0181
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x01cf }
            int r4 = r2.size()     // Catch:{ all -> 0x01cf }
            r3.<init>(r4)     // Catch:{ all -> 0x01cf }
            int r4 = r2.size()     // Catch:{ all -> 0x01cf }
            r5 = 0
        L_0x0168:
            if (r5 >= r4) goto L_0x0182
            java.lang.Object r6 = r2.get(r5)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.i$b r6 = (com.bykv.vk.openvk.component.video.a.b.i.b) r6     // Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x017e
            com.bykv.vk.openvk.component.video.a.b.i$b r7 = new com.bykv.vk.openvk.component.video.a.b.i$b     // Catch:{ all -> 0x01cf }
            java.lang.String r8 = r6.a     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = r6.b     // Catch:{ all -> 0x01cf }
            r7.<init>(r8, r6)     // Catch:{ all -> 0x01cf }
            r3.add(r7)     // Catch:{ all -> 0x01cf }
        L_0x017e:
            int r5 = r5 + 1
            goto L_0x0168
        L_0x0181:
            r3 = 0
        L_0x0182:
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = new com.bykv.vk.openvk.component.video.a.b.b$a     // Catch:{ all -> 0x01cf }
            r2.<init>()     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.a.a) r14)     // Catch:{ all -> 0x01cf }
            r4 = r18
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.b.c) r4)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((java.lang.String) r9)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.b(r0)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.l r4 = new com.bykv.vk.openvk.component.video.a.b.l     // Catch:{ all -> 0x01cf }
            java.util.List r5 = com.bykv.vk.openvk.component.video.a.c.a.a((java.lang.String[]) r28)     // Catch:{ all -> 0x01cf }
            r4.<init>((java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.l) r4)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((java.util.List<com.bykv.vk.openvk.component.video.a.b.i.b>) r3)     // Catch:{ all -> 0x01cf }
            r3 = r21
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((int) r3)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$b r3 = r1.j     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.b.C0030b) r3)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((java.lang.Object) r10)     // Catch:{ all -> 0x01cf }
            com.bykv.vk.openvk.component.video.a.b.b r2 = r2.a()     // Catch:{ all -> 0x01cf }
            r3 = r17
            r3.put(r0, r2)     // Catch:{ all -> 0x01cf }
            monitor-exit(r19)     // Catch:{ all -> 0x01cf }
            java.util.concurrent.ExecutorService r0 = r1.d
            r0.execute(r2)
            return
        L_0x01ca:
            r0 = move-exception
            r19 = r6
        L_0x01cd:
            monitor-exit(r19)     // Catch:{ all -> 0x01cf }
            throw r0
        L_0x01cf:
            r0 = move-exception
            goto L_0x01cd
        L_0x01d1:
            return
        L_0x01d2:
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x01dd
            java.lang.String r0 = "TAG_PROXY_Preloader"
            java.lang.String r2 = "cache or videoProxyDB null in Preloader!!!"
            android.util.Log.e(r0, r2)
        L_0x01dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.d.a(boolean, boolean, int, java.lang.String, java.util.Map, java.lang.String[]):void");
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(boolean z, boolean z2, String str) {
        if (!TextUtils.isEmpty(str)) {
            final boolean z3 = z;
            final boolean z4 = z2;
            final String str2 = str;
            com.bykv.vk.openvk.component.video.a.c.a.a((h) new h("cancel b b S") {
                public void run() {
                    b bVar;
                    synchronized (d.this.b) {
                        Map map = (Map) d.this.b.get(com.bykv.vk.openvk.component.video.a.b.b.b.a(z3));
                        if (map != null) {
                            bVar = (b) map.remove(z4 ? str2 : com.bykv.vk.openvk.component.video.api.f.b.a(str2));
                        } else {
                            bVar = null;
                        }
                    }
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            });
        }
    }

    public void d() {
        com.bykv.vk.openvk.component.video.a.c.a.a((h) new h("cancelAll") {
            public void run() {
                ArrayList<b> arrayList = new ArrayList<>();
                synchronized (d.this.b) {
                    int size = d.this.b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.b.get(d.this.b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.c.clear();
                }
                for (b bVar : arrayList) {
                    bVar.a();
                    if (e.c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* compiled from: Preloader */
    private static final class a {
        final boolean a;
        final boolean b;
        final int c;
        final String d;
        final Map<String, String> e;
        final String[] f;

        a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.a = z;
            this.b = z2;
            this.c = i;
            this.d = str;
            this.e = map;
            this.f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c) {
                return this.d.equals(aVar.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.a ? 1 : 0) * true) + (this.b ? 1 : 0)) * 31) + this.c) * 31) + this.d.hashCode();
        }
    }

    /* compiled from: Preloader */
    private static final class b<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor a;

        private b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                } else if (threadPoolExecutor != null) {
                    this.a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
            return offerFirst(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean offer(T r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.util.concurrent.ThreadPoolExecutor r0 = r3.a     // Catch:{ all -> 0x002b }
                int r0 = r0.getPoolSize()     // Catch:{ all -> 0x002b }
                java.util.concurrent.ThreadPoolExecutor r1 = r3.a     // Catch:{ all -> 0x002b }
                int r1 = r1.getActiveCount()     // Catch:{ all -> 0x002b }
                java.util.concurrent.ThreadPoolExecutor r2 = r3.a     // Catch:{ all -> 0x002b }
                int r2 = r2.getMaximumPoolSize()     // Catch:{ all -> 0x002b }
                if (r1 < r0) goto L_0x0025
                if (r0 >= r2) goto L_0x0025
                boolean r4 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x002b }
                if (r4 == 0) goto L_0x0022
                java.lang.String r4 = "TAG_PROXY_TT"
                java.lang.String r0 = "create new preloader thread"
                android.util.Log.i(r4, r0)     // Catch:{ all -> 0x002b }
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x002b }
                r4 = 0
                return r4
            L_0x0025:
                monitor-exit(r3)     // Catch:{ all -> 0x002b }
                boolean r4 = r3.offerFirst(r4)
                return r4
            L_0x002b:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002b }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.d.b.offer(java.lang.Object):boolean");
        }
    }

    private static ExecutorService a(final b<Runnable> bVar) {
        int a2 = com.bykv.vk.openvk.component.video.a.c.a.a();
        return new ThreadPoolExecutor(0, a2 < 1 ? 1 : a2 > 4 ? 4 : a2, 60, TimeUnit.SECONDS, bVar, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                AnonymousClass1 r0 = new Thread(runnable) {
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                r0.setName("csj_video_preload_" + r0.getId());
                r0.setDaemon(true);
                if (e.c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + r0.getName());
                }
                return r0;
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    bVar.offerFirst(runnable);
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
