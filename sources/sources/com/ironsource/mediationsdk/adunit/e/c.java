package com.ironsource.mediationsdk.adunit.e;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c<Smash extends com.ironsource.mediationsdk.adunit.d.a.c<?>> {
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> a = new ConcurrentHashMap<>();
    public String b = "";
    public com.ironsource.mediationsdk.adunit.d.a.c<?> c;
    ConcurrentHashMap<String, AdInfo> d = new ConcurrentHashMap<>();
    private String e = "";
    private final List<String> f;
    private final int g;
    private final Timer h = new Timer();
    private d i;
    private final int j = 5;

    public c(List<String> list, int i2, d dVar) {
        this.f = list;
        this.g = i2;
        this.i = dVar;
    }

    public static boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog.INTERNAL.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    private synchronized void b() {
        com.ironsource.mediationsdk.adunit.d.a.c<?> cVar = this.c;
        if (cVar != null) {
            cVar.s();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.mediationsdk.adunit.d.a.c<?> r0 = r2.c     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.u()     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001c
            com.ironsource.mediationsdk.adunit.d.a.c<?> r0 = r2.c     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r0.q()     // Catch:{ all -> 0x001f }
            java.lang.String r1 = r2.e     // Catch:{ all -> 0x001f }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x001c:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.e.c.c():boolean");
    }

    private void d() {
        for (com.ironsource.mediationsdk.adunit.d.a.c cVar : a()) {
            if (!cVar.equals(this.c)) {
                cVar.s();
            }
        }
    }

    public final AdInfo a(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    public final List<Smash> a() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    public final void a(a.C0109a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        d();
        if (aVar == a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW) {
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
                            c.this.a.remove(str3);
                            IronLog ironLog2 = IronLog.INTERNAL;
                            ironLog2.verbose("waterfall size is currently " + c.this.a.size());
                            IronLog ironLog3 = IronLog.INTERNAL;
                            ironLog3.verbose("removing adInfo with id " + str3 + " from memory");
                            c.this.d.remove(str3);
                            IronLog ironLog4 = IronLog.INTERNAL;
                            ironLog4.verbose("adInfo size is currently " + c.this.d.size());
                        } finally {
                            cancel();
                        }
                    }
                }, (long) this.g);
            }
        } else {
            this.d.remove(this.e);
            this.a.clear();
            this.a.put(str, copyOnWriteArrayList);
        }
        this.e = this.b;
        this.b = str;
        if (this.a.size() > 5) {
            this.i.a(this.a.size());
        }
    }

    public final synchronized void a(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
        IronLog.INTERNAL.verbose();
        com.ironsource.mediationsdk.adunit.d.a.c<?> cVar2 = this.c;
        if (cVar2 != null && !cVar2.equals(cVar)) {
            b();
        }
        this.c = cVar;
    }

    public final void a(String str, ImpressionData impressionData) {
        if (!TextUtils.isEmpty(str) && impressionData != null) {
            this.d.put(str, new AdInfo(impressionData));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r1.f.contains(r4) == false) goto L_0x000e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r1.c.p().equals(r4) == false) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(com.ironsource.mediationsdk.adunit.c.c.a.C0109a r2, java.lang.String r3, java.lang.String r4, com.ironsource.mediationsdk.LoadWhileShowSupportState r5, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface r6, com.ironsource.mediationsdk.IronSource.AD_UNIT r7) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r6 = a((com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface) r6, (com.ironsource.mediationsdk.IronSource.AD_UNIT) r7, (java.lang.String) r3)     // Catch:{ all -> 0x005e }
            r7 = 0
            if (r6 == 0) goto L_0x0009
            goto L_0x0044
        L_0x0009:
            com.ironsource.mediationsdk.adunit.c.c.a$a r6 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x005e }
            r0 = 1
            if (r2 == r6) goto L_0x0010
        L_0x000e:
            r7 = 1
            goto L_0x0044
        L_0x0010:
            com.ironsource.mediationsdk.adunit.d.a.c<?> r2 = r1.c     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x000e
            boolean r2 = r2.u()     // Catch:{ all -> 0x005e }
            if (r2 != 0) goto L_0x001b
            goto L_0x000e
        L_0x001b:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch:{ all -> 0x005e }
            if (r5 != r2) goto L_0x002c
            com.ironsource.mediationsdk.adunit.d.a.c<?> r2 = r1.c     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r2.n()     // Catch:{ all -> 0x005e }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch:{ all -> 0x005e }
            if (r5 == r2) goto L_0x0038
            java.util.List<java.lang.String> r2 = r1.f     // Catch:{ all -> 0x005e }
            boolean r2 = r2.contains(r4)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x000e
        L_0x0038:
            com.ironsource.mediationsdk.adunit.d.a.c<?> r2 = r1.c     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r2.p()     // Catch:{ all -> 0x005e }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x000e
        L_0x0044:
            if (r7 != 0) goto L_0x005c
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r4.<init>()     // Catch:{ all -> 0x005e }
            r4.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = " will not be added to the auction request"
            r4.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x005e }
            r2.verbose(r3)     // Catch:{ all -> 0x005e }
        L_0x005c:
            monitor-exit(r1)
            return r7
        L_0x005e:
            r2 = move-exception
            monitor-exit(r1)
            goto L_0x0062
        L_0x0061:
            throw r2
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.e.c.a(com.ironsource.mediationsdk.adunit.c.c.a$a, java.lang.String, java.lang.String, com.ironsource.mediationsdk.LoadWhileShowSupportState, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface, com.ironsource.mediationsdk.IronSource$AD_UNIT):boolean");
    }
}
