package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class D {
    ConcurrentHashMap<String, CopyOnWriteArrayList<B>> a = new ConcurrentHashMap<>();
    String b = "";
    B c;
    ConcurrentHashMap<String, AdInfo> d = new ConcurrentHashMap<>();
    private String e = "";
    private final List<String> f;
    private final int g;
    private final Timer h = new Timer();

    public D(List<String> list, int i) {
        this.f = list;
        this.g = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.mediationsdk.B r0 = r2.c     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.b     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r2.e     // Catch:{ all -> 0x0015 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0012:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0015:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.D.c():boolean");
    }

    private void d() {
        Iterator<B> it = a().iterator();
        while (it.hasNext()) {
            O next = it.next();
            if (!next.equals(this.c)) {
                next.f();
            }
        }
    }

    public final AdInfo a(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    public final CopyOnWriteArrayList<B> a() {
        CopyOnWriteArrayList<B> copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public final synchronized void a(B b2) {
        IronLog.INTERNAL.verbose();
        B b3 = this.c;
        if (b3 != null && !b3.equals(b2)) {
            this.c.f();
        }
        this.c = b2;
    }

    public final void a(String str, ImpressionData impressionData) {
        if (!TextUtils.isEmpty(str) && impressionData != null) {
            this.d.put(str, new AdInfo(impressionData));
        }
    }

    public final void a(CopyOnWriteArrayList<B> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        d();
        this.a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.e)) {
            if (c()) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("ad from previous waterfall " + this.e + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.e;
                this.e = str2;
            }
            final String str3 = this.e;
            this.h.schedule(new TimerTask() {
                public final void run() {
                    try {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose("removing waterfall with id " + str3 + " from memory");
                        D.this.a.remove(str3);
                        IronLog ironLog2 = IronLog.INTERNAL;
                        ironLog2.verbose("waterfall size is currently " + D.this.a.size());
                        IronLog ironLog3 = IronLog.INTERNAL;
                        ironLog3.verbose("removing adInfo with id " + str3 + " from memory");
                        D.this.d.remove(str3);
                        IronLog ironLog4 = IronLog.INTERNAL;
                        ironLog4.verbose("adInfo size is currently " + D.this.d.size());
                    } finally {
                        cancel();
                    }
                }
            }, (long) this.g);
        }
        this.e = this.b;
        this.b = str;
    }

    public final boolean b() {
        return this.a.size() > 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r5.f.contains(r6.o()) == false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r5.c.o().equals(r6.o()) == false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(com.ironsource.mediationsdk.B r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0078 }
            r0.verbose()     // Catch:{ all -> 0x0078 }
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x0054
            boolean r2 = r6.k()     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0011
            goto L_0x0054
        L_0x0011:
            com.ironsource.mediationsdk.B r2 = r5.c     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0017
        L_0x0015:
            r2 = 0
            goto L_0x0055
        L_0x0017:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.b()     // Catch:{ all -> 0x0078 }
            com.ironsource.mediationsdk.LoadWhileShowSupportState r3 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch:{ all -> 0x0078 }
            if (r2 != r3) goto L_0x0030
            com.ironsource.mediationsdk.B r2 = r5.c     // Catch:{ all -> 0x0078 }
            java.lang.String r2 = r2.n()     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = r6.n()     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0030
            goto L_0x0054
        L_0x0030:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.b()     // Catch:{ all -> 0x0078 }
            com.ironsource.mediationsdk.LoadWhileShowSupportState r3 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch:{ all -> 0x0078 }
            if (r2 == r3) goto L_0x0044
            java.util.List<java.lang.String> r2 = r5.f     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = r6.o()     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0015
        L_0x0044:
            com.ironsource.mediationsdk.B r2 = r5.c     // Catch:{ all -> 0x0078 }
            java.lang.String r2 = r2.o()     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = r6.o()     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0015
        L_0x0054:
            r2 = 1
        L_0x0055:
            if (r2 == 0) goto L_0x0073
            if (r6 == 0) goto L_0x0073
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r4.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = r6.n()     // Catch:{ all -> 0x0078 }
            r4.append(r6)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = " will not be added to the auction request"
            r4.append(r6)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0078 }
            r3.verbose(r6)     // Catch:{ all -> 0x0078 }
        L_0x0073:
            monitor-exit(r5)
            if (r2 != 0) goto L_0x0077
            return r1
        L_0x0077:
            return r0
        L_0x0078:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x007c
        L_0x007b:
            throw r6
        L_0x007c:
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.D.b(com.ironsource.mediationsdk.B):boolean");
    }
}
