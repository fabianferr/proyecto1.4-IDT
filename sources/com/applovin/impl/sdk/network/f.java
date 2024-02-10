package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class f {
    private final m a;
    /* access modifiers changed from: private */
    public final u b;
    private final int c;
    private final g d;
    private final SharedPreferences e;
    /* access modifiers changed from: private */
    public final Object f = new Object();
    /* access modifiers changed from: private */
    public final ArrayList<h> g;
    private final ArrayList<h> h = new ArrayList<>();
    private long i = 0;
    private final Set<h> j = new HashSet();

    public f(m mVar) {
        if (mVar != null) {
            this.a = mVar;
            this.b = mVar.A();
            int intValue = ((Integer) mVar.a(b.cM)).intValue();
            this.c = intValue;
            if (mVar.aa() != null) {
                this.e = mVar.L().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
                this.g = d();
                this.d = null;
                return;
            }
            g gVar = new g(this, mVar);
            this.d = gVar;
            this.g = gVar.a(intValue);
            gVar.a();
            this.e = null;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        r0 = ((java.lang.Integer) r5.a.a(com.applovin.impl.sdk.d.b.cK)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (r6.k() <= r0) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (com.applovin.impl.sdk.u.a() == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r7 = r5.b;
        r7.d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
        d(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        r0 = r5.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r5.j.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r6.f() == null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        r0 = new org.json.JSONObject(r6.f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        r5.a.X().dispatchPostbackRequest(com.applovin.impl.sdk.network.i.b(r5.a).d(r6.b()).e(r6.c()).c(r6.d()).f(r6.a()).d(r6.e()).b(r0).f(r6.h()).e(r6.g()).g(r6.i()).g(r6.j()).b(), new com.applovin.impl.sdk.network.f.AnonymousClass2(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.applovin.impl.sdk.network.h r6, final com.applovin.sdk.AppLovinPostbackListener r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Skip pending postback: "
            boolean r1 = com.applovin.impl.sdk.u.a()
            if (r1 == 0) goto L_0x001d
            com.applovin.impl.sdk.u r1 = r5.b
            java.lang.String r2 = "PersistentPostbackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Preparing to submit postback..."
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r1.b(r2, r3)
        L_0x001d:
            com.applovin.impl.sdk.m r1 = r5.a
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0035
            boolean r6 = com.applovin.impl.sdk.u.a()
            if (r6 == 0) goto L_0x0034
            com.applovin.impl.sdk.u r6 = r5.b
            java.lang.String r7 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r6.b(r7, r0)
        L_0x0034:
            return
        L_0x0035:
            java.lang.Object r1 = r5.f
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.h> r2 = r5.j     // Catch:{ all -> 0x0130 }
            boolean r2 = r2.contains(r6)     // Catch:{ all -> 0x0130 }
            if (r2 == 0) goto L_0x005f
            boolean r7 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0130 }
            if (r7 == 0) goto L_0x005d
            com.applovin.impl.sdk.u r7 = r5.b     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "PersistentPostbackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r3.<init>(r0)     // Catch:{ all -> 0x0130 }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x0130 }
            r3.append(r6)     // Catch:{ all -> 0x0130 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0130 }
            r7.b(r2, r6)     // Catch:{ all -> 0x0130 }
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x0130 }
            return
        L_0x005f:
            r6.l()     // Catch:{ all -> 0x0130 }
            com.applovin.impl.sdk.m r0 = r5.a     // Catch:{ all -> 0x0130 }
            com.applovin.impl.sdk.r r0 = r0.aa()     // Catch:{ all -> 0x0130 }
            if (r0 == 0) goto L_0x006e
            r5.f()     // Catch:{ all -> 0x0130 }
            goto L_0x0071
        L_0x006e:
            r5.e()     // Catch:{ all -> 0x0130 }
        L_0x0071:
            monitor-exit(r1)     // Catch:{ all -> 0x0130 }
            com.applovin.impl.sdk.m r0 = r5.a
            com.applovin.impl.sdk.d.b<java.lang.Integer> r1 = com.applovin.impl.sdk.d.b.cK
            java.lang.Object r0 = r0.a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r6.k()
            if (r1 <= r0) goto L_0x00ae
            boolean r7 = com.applovin.impl.sdk.u.a()
            if (r7 == 0) goto L_0x00a9
            com.applovin.impl.sdk.u r7 = r5.b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Exceeded maximum persisted attempt count of "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = r2.toString()
            r7.d(r1, r0)
        L_0x00a9:
            r5.d((com.applovin.impl.sdk.network.h) r6)
            goto L_0x012c
        L_0x00ae:
            java.lang.Object r0 = r5.f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.h> r1 = r5.j     // Catch:{ all -> 0x012d }
            r1.add(r6)     // Catch:{ all -> 0x012d }
            monitor-exit(r0)     // Catch:{ all -> 0x012d }
            java.util.Map r0 = r6.f()
            if (r0 == 0) goto L_0x00c7
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r6.f()
            r0.<init>(r1)
            goto L_0x00c8
        L_0x00c7:
            r0 = 0
        L_0x00c8:
            com.applovin.impl.sdk.m r1 = r5.a
            com.applovin.impl.sdk.network.i$a r1 = com.applovin.impl.sdk.network.i.b(r1)
            java.lang.String r2 = r6.b()
            com.applovin.impl.sdk.network.i$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = r6.c()
            com.applovin.impl.sdk.network.i$a r1 = r1.c((java.lang.String) r2)
            java.util.Map r2 = r6.d()
            com.applovin.impl.sdk.network.i$a r1 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r2 = r6.a()
            com.applovin.impl.sdk.network.i$a r1 = r1.b((java.lang.String) r2)
            java.util.Map r2 = r6.e()
            com.applovin.impl.sdk.network.i$a r1 = r1.b((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.applovin.impl.sdk.network.i$a r0 = r1.a((org.json.JSONObject) r0)
            boolean r1 = r6.h()
            com.applovin.impl.sdk.network.i$a r0 = r0.d((boolean) r1)
            boolean r1 = r6.g()
            com.applovin.impl.sdk.network.i$a r0 = r0.c((boolean) r1)
            boolean r1 = r6.i()
            com.applovin.impl.sdk.network.i$a r0 = r0.g((boolean) r1)
            java.lang.String r1 = r6.j()
            com.applovin.impl.sdk.network.i$a r0 = r0.g((java.lang.String) r1)
            com.applovin.impl.sdk.network.i r0 = r0.a()
            com.applovin.impl.sdk.m r1 = r5.a
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.X()
            com.applovin.impl.sdk.network.f$2 r2 = new com.applovin.impl.sdk.network.f$2
            r2.<init>(r6, r7)
            r1.dispatchPostbackRequest(r0, r2)
        L_0x012c:
            return
        L_0x012d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x012d }
            throw r6
        L_0x0130:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0130 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.f.a(com.applovin.impl.sdk.network.h, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    /* access modifiers changed from: private */
    public void b(h hVar) {
        synchronized (this.f) {
            if (this.a.aa() != null) {
                this.g.add(hVar);
                f();
            } else {
                while (this.g.size() > this.c) {
                    this.g.remove(0);
                }
                this.g.add(hVar);
                e();
            }
            if (u.a()) {
                u uVar = this.b;
                uVar.b("PersistentPostbackManager", "Enqueued postback: " + hVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(h hVar) {
        a(hVar, (AppLovinPostbackListener) null);
    }

    private ArrayList<h> d() {
        Set<String> set = (Set) this.a.b(d.p, new LinkedHashSet(0), this.e);
        ArrayList<h> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.a.a(b.cK)).intValue();
        u uVar = this.b;
        uVar.b("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
        for (String str : set) {
            try {
                h hVar = new h(new JSONObject(str), this.a);
                if (hVar.k() < intValue) {
                    arrayList.add(hVar);
                } else if (u.a(this.a)) {
                    u uVar2 = this.b;
                    uVar2.b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                }
            } catch (Throwable th) {
                if (u.a(this.a)) {
                    u uVar3 = this.b;
                    uVar3.b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
                }
            }
        }
        if (u.a(this.a)) {
            u uVar4 = this.b;
            uVar4.b("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void d(h hVar) {
        synchronized (this.f) {
            this.j.remove(hVar);
            this.g.remove(hVar);
            if (this.a.aa() != null) {
                f();
            } else {
                e();
            }
        }
        if (u.a()) {
            u uVar = this.b;
            uVar.b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + hVar);
        }
    }

    private void e() {
        this.i = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void e(h hVar) {
        synchronized (this.f) {
            this.j.remove(hVar);
            this.h.add(hVar);
        }
    }

    private void f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.g.size());
        Iterator<h> it = this.g.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(it.next().n().toString());
            } catch (Throwable th) {
                this.b.b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.a.a(d.p, linkedHashSet, this.e);
        this.b.b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* access modifiers changed from: private */
    public void g() {
        synchronized (this.f) {
            Iterator<h> it = this.h.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.h.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.i;
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(h hVar, boolean z) {
        a(hVar, z, (AppLovinPostbackListener) null);
    }

    public void a(final h hVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (StringUtils.isValidString(hVar.b())) {
            if (z) {
                hVar.m();
            }
            AnonymousClass1 r3 = new Runnable() {
                public void run() {
                    synchronized (f.this.f) {
                        f.this.b(hVar);
                        f.this.a(hVar, appLovinPostbackListener);
                    }
                }
            };
            if (Utils.isMainThread()) {
                this.a.S().a((a) new z(this.a, r3), o.a.POSTBACKS);
                return;
            }
            r3.run();
        }
    }

    /* access modifiers changed from: package-private */
    public List<h> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f) {
            arrayList.ensureCapacity(this.g.size());
            arrayList.addAll(this.g);
        }
        return arrayList;
    }

    public void c() {
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                synchronized (f.this.f) {
                    if (f.this.g != null) {
                        for (h d : new ArrayList(f.this.g)) {
                            f.this.c(d);
                        }
                    }
                }
            }
        };
        if (((Boolean) this.a.a(b.cL)).booleanValue()) {
            this.a.S().a((a) new z(this.a, r0), o.a.POSTBACKS);
            return;
        }
        r0.run();
    }
}
