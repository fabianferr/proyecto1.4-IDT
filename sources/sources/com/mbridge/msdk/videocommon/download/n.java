package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.videocommon.download.l;
import com.mbridge.msdk.videocommon.listener.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: UnitCacheCtroller */
public final class n {
    h a = null;
    h b = null;
    private List<CampaignEx> c = new ArrayList();
    /* access modifiers changed from: private */
    public boolean d = true;
    /* access modifiers changed from: private */
    public a e;
    private String f = "";
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, a> g;
    private d h = new d() {
        public final void a(long j, int i) {
            if (i == 5 || i == 4) {
                boolean unused = n.this.d = true;
                n.this.a();
            }
            if (i == 2) {
                boolean unused2 = n.this.d = true;
            }
        }
    };
    private CopyOnWriteArrayList<Map<String, a>> i = new CopyOnWriteArrayList<>();
    private Context j;
    private ExecutorService k;
    private long l = 3600;
    private String m;
    private c n;
    private int o = 1;
    private int p = 1;
    private m q;
    private boolean r;

    public n(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i2) {
        try {
            boolean a2 = l.a.a.a(i2);
            this.r = a2;
            if (a2) {
                this.m = str;
                this.p = i2;
                this.q = new m(list, str, i2);
                return;
            }
        } catch (Exception unused) {
            this.q = null;
            this.r = false;
        }
        this.j = b.d().g();
        List<CampaignEx> list2 = this.c;
        if (!(list2 == null || list == null)) {
            list2.addAll(list);
        }
        this.k = executorService;
        this.m = str;
        this.p = i2;
        b(this.c);
    }

    public n(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i2) {
        try {
            boolean a2 = l.a.a.a(i2);
            this.r = a2;
            if (a2) {
                this.m = str;
                this.p = i2;
                this.q = new m(campaignEx, str, i2);
                return;
            }
        } catch (Exception unused) {
            this.q = null;
            this.r = false;
        }
        this.j = b.d().g();
        List<CampaignEx> list = this.c;
        if (!(list == null || campaignEx == null)) {
            list.add(campaignEx);
        }
        this.k = executorService;
        this.m = str;
        this.p = i2;
        b(this.c);
    }

    public final void a(a aVar) {
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            this.e = aVar;
        } else {
            mVar.a(aVar);
        }
    }

    public final void a(String str, a aVar) {
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            if (this.g == null) {
                this.g = new ConcurrentHashMap<>();
            }
            if (aVar != null && !TextUtils.isEmpty(str)) {
                this.g.put(str, aVar);
                return;
            }
            return;
        }
        mVar.a(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            List<CampaignEx> list2 = this.c;
            if (!(list2 == null || list == null)) {
                list2.addAll(list);
            }
            b(this.c);
            return;
        }
        mVar.a(list);
    }

    public final void a(CampaignEx campaignEx) {
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            List<CampaignEx> list = this.c;
            if (!(list == null || campaignEx == null)) {
                list.add(campaignEx);
            }
            b(this.c);
            return;
        }
        mVar.a(campaignEx);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x01ff */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x021f
            int r0 = r13.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x021f
        L_0x000a:
            r0 = 0
            java.lang.Object r1 = r13.get(r0)
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r13.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1
            java.lang.String r1 = r1.getCurrentLRid()
            r12.f = r1
        L_0x001d:
            r12.e()
            r12.d()
            int r1 = r12.p
            r2 = 94
            r3 = 287(0x11f, float:4.02E-43)
            r4 = 1
            if (r1 == r4) goto L_0x00ff
            if (r1 == r3) goto L_0x00b2
            r5 = 298(0x12a, float:4.18E-43)
            if (r1 == r5) goto L_0x0074
            if (r1 == r2) goto L_0x00b2
            r5 = 95
            if (r1 == r5) goto L_0x003a
            goto L_0x0137
        L_0x003a:
            java.lang.String r1 = r12.m     // Catch:{ Exception -> 0x006c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x006c }
            if (r1 != 0) goto L_0x0137
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x006c }
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x006c }
            java.lang.String r5 = r5.h()     // Catch:{ Exception -> 0x006c }
            java.lang.String r6 = r12.m     // Catch:{ Exception -> 0x006c }
            com.mbridge.msdk.c.h r1 = r1.e(r5, r6)     // Catch:{ Exception -> 0x006c }
            if (r1 != 0) goto L_0x005c
            java.lang.String r1 = r12.m     // Catch:{ Exception -> 0x006c }
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.e(r1)     // Catch:{ Exception -> 0x006c }
        L_0x005c:
            if (r1 == 0) goto L_0x0137
            long r5 = r1.i()     // Catch:{ Exception -> 0x006c }
            r12.l = r5     // Catch:{ Exception -> 0x006c }
            int r1 = r1.k()     // Catch:{ Exception -> 0x006c }
            r12.o = r1     // Catch:{ Exception -> 0x006c }
            goto L_0x0137
        L_0x006c:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put feeds jar into your project"
            com.mbridge.msdk.foundation.tools.aa.d(r13, r0)
            return
        L_0x0074:
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r5 = r5.h()
            java.lang.String r6 = r12.m
            com.mbridge.msdk.c.h r1 = r1.f(r5, r6)
            r12.b = r1
            if (r1 != 0) goto L_0x009e
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r5 = r5.h()
            java.lang.String r6 = r12.m
            com.mbridge.msdk.c.h r1 = r1.d(r5, r6)
            r12.b = r1
        L_0x009e:
            com.mbridge.msdk.c.h r1 = r12.b
            if (r1 == 0) goto L_0x0137
            long r5 = r1.i()
            r12.l = r5
            com.mbridge.msdk.c.h r1 = r12.b
            int r1 = r1.k()
            r12.o = r1
            goto L_0x0137
        L_0x00b2:
            java.lang.String r1 = "com.mbridge.msdk.videocommon.d.a"
            java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x00f7 }
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00f7 }
            com.mbridge.msdk.videocommon.d.a r1 = r1.b()     // Catch:{ Exception -> 0x00f7 }
            if (r1 != 0) goto L_0x00c8
            com.mbridge.msdk.videocommon.d.b r5 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00f7 }
            r5.c()     // Catch:{ Exception -> 0x00f7 }
        L_0x00c8:
            if (r1 == 0) goto L_0x00d0
            long r5 = r1.g()     // Catch:{ Exception -> 0x00f7 }
            r12.l = r5     // Catch:{ Exception -> 0x00f7 }
        L_0x00d0:
            java.lang.String r1 = r12.m     // Catch:{ Exception -> 0x00f7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00f7 }
            if (r1 != 0) goto L_0x00ec
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00f7 }
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r5 = r5.h()     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r6 = r12.m     // Catch:{ Exception -> 0x00f7 }
            com.mbridge.msdk.videocommon.d.c r1 = r1.a(r5, r6)     // Catch:{ Exception -> 0x00f7 }
            r12.n = r1     // Catch:{ Exception -> 0x00f7 }
        L_0x00ec:
            com.mbridge.msdk.videocommon.d.c r1 = r12.n     // Catch:{ Exception -> 0x00f7 }
            if (r1 == 0) goto L_0x0137
            int r1 = r1.w()     // Catch:{ Exception -> 0x00f7 }
            r12.o = r1     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0137
        L_0x00f7:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put reward jar into your project"
            com.mbridge.msdk.foundation.tools.aa.d(r13, r0)
            return
        L_0x00ff:
            java.lang.String r1 = r12.m     // Catch:{ Exception -> 0x0218 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0218 }
            if (r1 != 0) goto L_0x0137
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0218 }
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0218 }
            java.lang.String r5 = r5.h()     // Catch:{ Exception -> 0x0218 }
            java.lang.String r6 = r12.m     // Catch:{ Exception -> 0x0218 }
            com.mbridge.msdk.c.h r1 = r1.e(r5, r6)     // Catch:{ Exception -> 0x0218 }
            r12.a = r1     // Catch:{ Exception -> 0x0218 }
            if (r1 != 0) goto L_0x0125
            java.lang.String r1 = r12.m     // Catch:{ Exception -> 0x0218 }
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.d(r1)     // Catch:{ Exception -> 0x0218 }
            r12.a = r1     // Catch:{ Exception -> 0x0218 }
        L_0x0125:
            com.mbridge.msdk.c.h r1 = r12.a     // Catch:{ Exception -> 0x0218 }
            if (r1 == 0) goto L_0x0137
            long r5 = r1.i()     // Catch:{ Exception -> 0x0218 }
            r12.l = r5     // Catch:{ Exception -> 0x0218 }
            com.mbridge.msdk.c.h r1 = r12.a     // Catch:{ Exception -> 0x0218 }
            int r1 = r1.k()     // Catch:{ Exception -> 0x0218 }
            r12.o = r1     // Catch:{ Exception -> 0x0218 }
        L_0x0137:
            r1 = 0
        L_0x0138:
            int r5 = r13.size()
            if (r1 >= r5) goto L_0x0208
            java.lang.Object r5 = r13.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            if (r5 == 0) goto L_0x0204
            int r6 = r12.p
            if (r6 == r2) goto L_0x016c
            if (r6 != r3) goto L_0x014d
            goto L_0x016c
        L_0x014d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r5.getId()
            r6.append(r7)
            java.lang.String r7 = r5.getVideoUrlEncode()
            r6.append(r7)
            java.lang.String r7 = r5.getBidToken()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x018a
        L_0x016c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r5.getRequestId()
            r6.append(r7)
            java.lang.String r7 = r5.getId()
            r6.append(r7)
            java.lang.String r7 = r5.getVideoUrlEncode()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        L_0x018a:
            boolean r7 = r12.c(r5)
            if (r7 != 0) goto L_0x019b
            java.lang.String r7 = r5.getVideoUrlEncode()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x019b
            goto L_0x0204
        L_0x019b:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r7 = r12.i
            if (r7 == 0) goto L_0x0204
            monitor-enter(r7)
            r8 = 0
        L_0x01a1:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r9 = r12.i     // Catch:{ all -> 0x01ff }
            int r9 = r9.size()     // Catch:{ all -> 0x01ff }
            if (r8 >= r9) goto L_0x01da
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r9 = r12.i     // Catch:{ all -> 0x01ff }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x01ff }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x01ff }
            if (r9 == 0) goto L_0x01d7
            boolean r10 = r9.containsKey(r6)     // Catch:{ all -> 0x01ff }
            if (r10 == 0) goto L_0x01d7
            java.lang.Object r10 = r9.get(r6)     // Catch:{ all -> 0x01ff }
            com.mbridge.msdk.videocommon.download.a r10 = (com.mbridge.msdk.videocommon.download.a) r10     // Catch:{ all -> 0x01ff }
            r10.a((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ all -> 0x01ff }
            int r11 = r12.o     // Catch:{ all -> 0x01ff }
            r10.a((int) r11)     // Catch:{ all -> 0x01ff }
            r10.e((boolean) r0)     // Catch:{ all -> 0x01ff }
            r9.remove(r6)     // Catch:{ all -> 0x01ff }
            r9.put(r6, r10)     // Catch:{ all -> 0x01ff }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r10 = r12.i     // Catch:{ all -> 0x01ff }
            r10.set(r8, r9)     // Catch:{ all -> 0x01ff }
            r8 = 1
            goto L_0x01db
        L_0x01d7:
            int r8 = r8 + 1
            goto L_0x01a1
        L_0x01da:
            r8 = 0
        L_0x01db:
            if (r8 != 0) goto L_0x01ff
            com.mbridge.msdk.videocommon.download.a r8 = new com.mbridge.msdk.videocommon.download.a     // Catch:{ all -> 0x01ff }
            android.content.Context r9 = r12.j     // Catch:{ all -> 0x01ff }
            java.lang.String r10 = r12.m     // Catch:{ all -> 0x01ff }
            int r11 = r12.o     // Catch:{ all -> 0x01ff }
            r8.<init>(r9, r5, r10, r11)     // Catch:{ all -> 0x01ff }
            int r5 = r12.o     // Catch:{ all -> 0x01ff }
            r8.a((int) r5)     // Catch:{ all -> 0x01ff }
            int r5 = r12.p     // Catch:{ all -> 0x01ff }
            r8.d((int) r5)     // Catch:{ all -> 0x01ff }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x01ff }
            r5.<init>()     // Catch:{ all -> 0x01ff }
            r5.put(r6, r8)     // Catch:{ all -> 0x01ff }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r6 = r12.i     // Catch:{ all -> 0x01ff }
            r6.add(r5)     // Catch:{ all -> 0x01ff }
        L_0x01ff:
            monitor-exit(r7)     // Catch:{ all -> 0x0201 }
            goto L_0x0204
        L_0x0201:
            r13 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0201 }
            throw r13
        L_0x0204:
            int r1 = r1 + 1
            goto L_0x0138
        L_0x0208:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13 = r12.c
            if (r13 == 0) goto L_0x0217
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0217
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13 = r12.c
            r13.clear()
        L_0x0217:
            return
        L_0x0218:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put native video jar into your project"
            com.mbridge.msdk.foundation.tools.aa.d(r13, r0)
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.n.b(java.util.List):void");
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.r || this.q == null) && !ac.a().a("u_n_c_e_d", true) && (copyOnWriteArrayList = this.i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    while (i2 < this.i.size()) {
                        Map map = this.i.get(i2);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (currentTimeMillis - aVar.g() > this.l * 1000 && aVar.j() == 1) {
                                    aVar.b("download timeout");
                                    aVar.a(this.o);
                                    aVar.r();
                                    this.i.remove(map);
                                    i2--;
                                }
                                if (!(aVar.j() == 1 || aVar.j() == 5 || aVar.j() == 0)) {
                                    aVar.r();
                                    this.i.remove(map);
                                    i2--;
                                }
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i2 = 0;
                    while (i2 < this.i.size()) {
                        Map map = this.i.get(i2);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (aVar.k() != null) {
                                    if (aVar.f()) {
                                        aVar.q();
                                        this.i.remove(map);
                                        i2--;
                                    }
                                }
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                aa.d("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    public final List<a> a(String str, int i2, boolean z, List<CampaignEx> list, boolean z2) {
        long j2;
        Iterator it;
        m mVar;
        int i3 = i2;
        boolean z3 = z2;
        if (this.r && (mVar = this.q) != null) {
            return mVar.a(list, z3);
        }
        List<CampaignEx> list2 = list;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i4 = 0;
                    while (i4 < this.i.size()) {
                        Map map = this.i.get(i4);
                        Iterator it2 = map.entrySet().iterator();
                        while (it2.hasNext()) {
                            a aVar = (a) ((Map.Entry) it2.next()).getValue();
                            if (aVar != null) {
                                if (aVar.k() != null) {
                                    CampaignEx k2 = aVar.k();
                                    boolean z4 = false;
                                    for (CampaignEx next : list) {
                                        if (k2 != null && next != null && !TextUtils.isEmpty(k2.getRequestId()) && !TextUtils.isEmpty(next.getRequestId()) && k2.getId().equals(next.getId()) && k2.getRequestId().equals(next.getRequestId())) {
                                            if (!TextUtils.isEmpty(next.getLocalRequestId())) {
                                                k2.setLocalRequestId(next.getLocalRequestId());
                                            }
                                            if (!TextUtils.isEmpty(next.getNLRid())) {
                                                k2.setNLRid(next.getNLRid());
                                            }
                                            z4 = true;
                                        }
                                        List<CampaignEx> list3 = list;
                                    }
                                    if (z4) {
                                        if (!z || k2.isBidCampaign()) {
                                            if (z || !k2.isBidCampaign()) {
                                                String str2 = k2.getendcard_url();
                                                String videoUrlEncode = k2.getVideoUrlEncode();
                                                String str3 = "";
                                                if (!(k2 == null || k2.getRewardTemplateMode() == null)) {
                                                    str3 = k2.getRewardTemplateMode().e();
                                                }
                                                k2.getRewardTemplateMode();
                                                it = it2;
                                                if (i3 == 94 || i3 == 287) {
                                                    if (!TextUtils.isEmpty(str3) && !str3.contains(CampaignEx.KEY_IS_CMPT_ENTRY) && !a(i3, k2, str3)) {
                                                        j2 = currentTimeMillis;
                                                        List<CampaignEx> list4 = list;
                                                        it2 = it;
                                                        currentTimeMillis = j2;
                                                    } else if (b(str2, k2)) {
                                                        if (aVar.f()) {
                                                            aVar.q();
                                                        } else if (ak.a(videoUrlEncode)) {
                                                            arrayList.add(aVar);
                                                        } else if (a(aVar, b(k2), z3)) {
                                                            arrayList.add(aVar);
                                                        }
                                                        j2 = currentTimeMillis;
                                                        List<CampaignEx> list42 = list;
                                                        it2 = it;
                                                        currentTimeMillis = j2;
                                                    }
                                                }
                                                boolean isEmpty = TextUtils.isEmpty(aVar.p());
                                                int j3 = aVar.j();
                                                if (j3 != 5) {
                                                    if (!ac.a().a("u_n_c_e_d", true)) {
                                                        long g2 = aVar.g();
                                                        if (aVar.j() == 1) {
                                                            j2 = currentTimeMillis;
                                                            if (currentTimeMillis - g2 > this.l * 1000) {
                                                                aVar.b("download timeout");
                                                                aVar.r();
                                                                this.i.remove(map);
                                                                i4--;
                                                                if (i3 != 1) {
                                                                    if (i3 == 94) {
                                                                    }
                                                                }
                                                                List<CampaignEx> list422 = list;
                                                                it2 = it;
                                                                currentTimeMillis = j2;
                                                            }
                                                        } else {
                                                            j2 = currentTimeMillis;
                                                        }
                                                        if (j3 == 4 || j3 == 2) {
                                                            this.i.remove(map);
                                                            aVar.r();
                                                            i4--;
                                                            List<CampaignEx> list4222 = list;
                                                            it2 = it;
                                                            currentTimeMillis = j2;
                                                        }
                                                    } else {
                                                        j2 = currentTimeMillis;
                                                    }
                                                    if (j3 == 1) {
                                                        if (!aVar.f()) {
                                                            if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(aVar, b(k2), z3) && a(str2, k2)) {
                                                                arrayList.add(aVar);
                                                            }
                                                        }
                                                        List<CampaignEx> list42222 = list;
                                                        it2 = it;
                                                        currentTimeMillis = j2;
                                                    }
                                                    if ((i3 == 94 || i3 == 287) && a(aVar, b(k2), z3) && a(str2, k2)) {
                                                        arrayList.add(aVar);
                                                    }
                                                    List<CampaignEx> list422222 = list;
                                                    it2 = it;
                                                    currentTimeMillis = j2;
                                                } else if (aVar.f()) {
                                                    aVar.q();
                                                    this.i.remove(map);
                                                    i4--;
                                                    List<CampaignEx> list5 = list;
                                                    it2 = it;
                                                } else {
                                                    if (!isEmpty) {
                                                        aVar.a(0, 0);
                                                        if (i3 == 95) {
                                                            arrayList.add(aVar);
                                                        }
                                                    } else if (!a(str2, k2)) {
                                                        return null;
                                                    } else {
                                                        arrayList.add(aVar);
                                                    }
                                                    j2 = currentTimeMillis;
                                                    List<CampaignEx> list4222222 = list;
                                                    it2 = it;
                                                    currentTimeMillis = j2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            j2 = currentTimeMillis;
                            it = it2;
                            List<CampaignEx> list42222222 = list;
                            it2 = it;
                            currentTimeMillis = j2;
                        }
                        long j4 = currentTimeMillis;
                        i4++;
                        List<CampaignEx> list6 = list;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public final boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx = list.get(i2);
            if (campaignEx == null || !a(new a(b.d().g(), campaignEx, str, this.o), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return e(campaignEx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0287, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0289, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x028a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0291, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0033, B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01eb A[Catch:{ Exception -> 0x0289, all -> 0x0287 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0204 A[SYNTHETIC, Splitter:B:142:0x0204] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c A[Catch:{ Exception -> 0x0289, all -> 0x0287 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.download.a a(int r25, boolean r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            java.lang.String r3 = "UnitCache isReady campaignList = "
            boolean r4 = r1.r
            if (r4 == 0) goto L_0x0015
            com.mbridge.msdk.videocommon.download.m r4 = r1.q
            if (r4 == 0) goto L_0x0015
            com.mbridge.msdk.videocommon.download.a r0 = r4.b()
            return r0
        L_0x0015:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r4 = r1.i
            r5 = 0
            if (r4 == 0) goto L_0x0292
            monitor-enter(r4)
            int r6 = r1.p     // Catch:{ Exception -> 0x0289 }
            r7 = 287(0x11f, float:4.02E-43)
            r8 = 94
            r9 = 1
            if (r6 == r8) goto L_0x0035
            if (r6 != r7) goto L_0x0027
            goto L_0x0035
        L_0x0027:
            com.mbridge.msdk.videocommon.a.a r3 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r6 = r1.m     // Catch:{ Exception -> 0x0289 }
            java.util.concurrent.CopyOnWriteArrayList r3 = r3.a((java.lang.String) r6, (int) r9)     // Catch:{ Exception -> 0x0289 }
            if (r3 != 0) goto L_0x006f
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r5
        L_0x0035:
            com.mbridge.msdk.videocommon.a.a r6 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r10 = r1.m     // Catch:{ Exception -> 0x0289 }
            java.util.List r6 = r6.a((java.lang.String) r10, (int) r9, (boolean) r2)     // Catch:{ Exception -> 0x0289 }
            if (r6 == 0) goto L_0x0047
            int r10 = r6.size()     // Catch:{ Exception -> 0x0289 }
            if (r10 != 0) goto L_0x0057
        L_0x0047:
            if (r0 == r8) goto L_0x004b
            if (r0 != r7) goto L_0x0057
        L_0x004b:
            com.mbridge.msdk.videocommon.a.a r6 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r10 = r1.m     // Catch:{ Exception -> 0x0289 }
            java.lang.String r11 = ""
            java.util.List r6 = r6.c(r10, r9, r2, r11)     // Catch:{ Exception -> 0x0289 }
        L_0x0057:
            if (r6 == 0) goto L_0x027d
            java.lang.String r10 = "UnitCacheCtroller"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0289 }
            r11.<init>(r3)     // Catch:{ Exception -> 0x0289 }
            int r3 = r6.size()     // Catch:{ Exception -> 0x0289 }
            r11.append(r3)     // Catch:{ Exception -> 0x0289 }
            java.lang.String r3 = r11.toString()     // Catch:{ Exception -> 0x0289 }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r10, (java.lang.String) r3)     // Catch:{ Exception -> 0x0289 }
            r3 = r6
        L_0x006f:
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0289 }
            r12 = 0
        L_0x0074:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.i     // Catch:{ Exception -> 0x0289 }
            int r13 = r13.size()     // Catch:{ Exception -> 0x0289 }
            if (r12 >= r13) goto L_0x028d
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.i     // Catch:{ Exception -> 0x0289 }
            java.lang.Object r13 = r13.get(r12)     // Catch:{ Exception -> 0x0289 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x0289 }
            java.util.Set r14 = r13.entrySet()     // Catch:{ Exception -> 0x0289 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0289 }
        L_0x008c:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0289 }
            if (r15 == 0) goto L_0x026d
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0289 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ Exception -> 0x0289 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ Exception -> 0x0289 }
            com.mbridge.msdk.videocommon.download.a r15 = (com.mbridge.msdk.videocommon.download.a) r15     // Catch:{ Exception -> 0x0289 }
            if (r15 == 0) goto L_0x025e
            com.mbridge.msdk.foundation.entity.CampaignEx r16 = r15.k()     // Catch:{ Exception -> 0x0289 }
            if (r16 != 0) goto L_0x00a8
            goto L_0x025e
        L_0x00a8:
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r15.k()     // Catch:{ Exception -> 0x0289 }
            java.util.Iterator r17 = r3.iterator()     // Catch:{ Exception -> 0x0289 }
            r18 = 0
        L_0x00b2:
            boolean r19 = r17.hasNext()     // Catch:{ Exception -> 0x0289 }
            if (r19 == 0) goto L_0x00d0
            java.lang.Object r19 = r17.next()     // Catch:{ Exception -> 0x0289 }
            com.mbridge.msdk.foundation.entity.CampaignEx r19 = (com.mbridge.msdk.foundation.entity.CampaignEx) r19     // Catch:{ Exception -> 0x0289 }
            java.lang.String r5 = r9.getId()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r6 = r19.getId()     // Catch:{ Exception -> 0x0289 }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0289 }
            if (r5 == 0) goto L_0x00ce
            r18 = 1
        L_0x00ce:
            r5 = 0
            goto L_0x00b2
        L_0x00d0:
            if (r18 != 0) goto L_0x00d4
            goto L_0x025e
        L_0x00d4:
            if (r2 == 0) goto L_0x00dc
            boolean r5 = r9.isBidCampaign()     // Catch:{ Exception -> 0x0289 }
            if (r5 == 0) goto L_0x025e
        L_0x00dc:
            if (r2 != 0) goto L_0x00e6
            boolean r5 = r9.isBidCampaign()     // Catch:{ Exception -> 0x0289 }
            if (r5 == 0) goto L_0x00e6
            goto L_0x025e
        L_0x00e6:
            java.lang.String r5 = r9.getendcard_url()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r6 = r9.getVideoUrlEncode()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r17 = ""
            if (r9 == 0) goto L_0x0100
            com.mbridge.msdk.foundation.entity.CampaignEx$c r18 = r9.getRewardTemplateMode()     // Catch:{ Exception -> 0x0289 }
            if (r18 == 0) goto L_0x0100
            com.mbridge.msdk.foundation.entity.CampaignEx$c r17 = r9.getRewardTemplateMode()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r17 = r17.e()     // Catch:{ Exception -> 0x0289 }
        L_0x0100:
            r18 = r17
            r9.getRewardTemplateMode()     // Catch:{ Exception -> 0x0289 }
            int r7 = r1.p     // Catch:{ Exception -> 0x0289 }
            if (r7 == r8) goto L_0x010d
            r7 = 287(0x11f, float:4.02E-43)
            if (r0 != r7) goto L_0x0151
        L_0x010d:
            boolean r7 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x0289 }
            if (r7 != 0) goto L_0x0126
            java.lang.String r7 = "cmpt=1"
            r8 = r18
            boolean r7 = r8.contains(r7)     // Catch:{ Exception -> 0x0289 }
            if (r7 != 0) goto L_0x0126
            int r7 = r1.p     // Catch:{ Exception -> 0x0289 }
            boolean r7 = r1.a((int) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (java.lang.String) r8)     // Catch:{ Exception -> 0x0289 }
            if (r7 != 0) goto L_0x0126
            goto L_0x0135
        L_0x0126:
            boolean r7 = r1.b((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            if (r7 == 0) goto L_0x0151
            boolean r7 = r15.f()     // Catch:{ Exception -> 0x0289 }
            if (r7 == 0) goto L_0x013d
            r15.q()     // Catch:{ Exception -> 0x0289 }
        L_0x0135:
            r0 = r3
            r2 = 1
        L_0x0137:
            r6 = 94
            r7 = 287(0x11f, float:4.02E-43)
            goto L_0x0262
        L_0x013d:
            boolean r6 = com.mbridge.msdk.foundation.tools.ak.a(r6)     // Catch:{ Exception -> 0x0289 }
            if (r6 == 0) goto L_0x0145
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x0145:
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r6)     // Catch:{ Exception -> 0x0289 }
            if (r6 == 0) goto L_0x0151
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x0151:
            java.lang.String r6 = r15.p()     // Catch:{ Exception -> 0x0289 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0289 }
            int r7 = r15.j()     // Catch:{ Exception -> 0x0289 }
            int r8 = r1.p     // Catch:{ Exception -> 0x0289 }
            r0 = 298(0x12a, float:4.18E-43)
            if (r8 != r0) goto L_0x016f
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r0)     // Catch:{ Exception -> 0x0289 }
            if (r0 == 0) goto L_0x016f
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x016f:
            r0 = 5
            r8 = 95
            if (r7 != r0) goto L_0x01a5
            boolean r0 = r15.f()     // Catch:{ Exception -> 0x0289 }
            if (r0 == 0) goto L_0x018e
            r15.q()     // Catch:{ Exception -> 0x0289 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.i     // Catch:{ Exception -> 0x0289 }
            r0.remove(r13)     // Catch:{ Exception -> 0x0289 }
            int r12 = r12 + -1
            r0 = r25
            r5 = 0
            r7 = 287(0x11f, float:4.02E-43)
            r8 = 94
            r9 = 1
            goto L_0x008c
        L_0x018e:
            if (r6 != 0) goto L_0x019a
            r0 = 0
            r15.a((int) r0, (int) r0)     // Catch:{ Exception -> 0x0289 }
            int r5 = r1.p     // Catch:{ Exception -> 0x0289 }
            if (r5 != r8) goto L_0x0135
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x019a:
            boolean r0 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            if (r0 == 0) goto L_0x01a2
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x01a2:
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            r2 = 0
            return r2
        L_0x01a5:
            r0 = 0
            com.mbridge.msdk.foundation.tools.ac r6 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r0 = "u_n_c_e_d"
            r8 = 1
            boolean r0 = r6.a((java.lang.String) r0, (boolean) r8)     // Catch:{ Exception -> 0x0289 }
            if (r0 != 0) goto L_0x01e4
            long r20 = r15.g()     // Catch:{ Exception -> 0x0289 }
            int r0 = r15.j()     // Catch:{ Exception -> 0x0289 }
            if (r0 != r8) goto L_0x01e4
            long r20 = r10 - r20
            r0 = r3
            long r2 = r1.l     // Catch:{ Exception -> 0x0289 }
            r22 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r22
            int r6 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x01e5
            java.lang.String r2 = "download timeout"
            r15.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0289 }
            r15.r()     // Catch:{ Exception -> 0x0289 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.i     // Catch:{ Exception -> 0x0289 }
            r2.remove(r13)     // Catch:{ Exception -> 0x0289 }
            int r12 = r12 + -1
            int r2 = r1.p     // Catch:{ Exception -> 0x0289 }
            r3 = 1
            if (r2 == r3) goto L_0x01fb
            r3 = 94
            if (r2 != r3) goto L_0x01e5
            goto L_0x01fb
        L_0x01e4:
            r0 = r3
        L_0x01e5:
            int r2 = r1.p     // Catch:{ Exception -> 0x0289 }
            r3 = 95
            if (r2 != r3) goto L_0x0204
            boolean r2 = r15.f()     // Catch:{ Exception -> 0x0289 }
            if (r2 == 0) goto L_0x0202
            r15.q()     // Catch:{ Exception -> 0x0289 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.i     // Catch:{ Exception -> 0x0289 }
            r2.remove(r13)     // Catch:{ Exception -> 0x0289 }
        L_0x01f9:
            int r12 = r12 + -1
        L_0x01fb:
            r2 = r26
            r3 = r0
            r5 = 0
            r7 = 287(0x11f, float:4.02E-43)
            goto L_0x0266
        L_0x0202:
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x0204:
            com.mbridge.msdk.foundation.tools.ac r2 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ Exception -> 0x0289 }
            java.lang.String r3 = "u_n_c_e_d"
            r6 = 1
            boolean r2 = r2.a((java.lang.String) r3, (boolean) r6)     // Catch:{ Exception -> 0x0289 }
            if (r2 != 0) goto L_0x0221
            r2 = 4
            if (r7 == r2) goto L_0x0218
            r2 = 2
            if (r7 != r2) goto L_0x0221
        L_0x0218:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.i     // Catch:{ Exception -> 0x0289 }
            r2.remove(r13)     // Catch:{ Exception -> 0x0289 }
            r15.r()     // Catch:{ Exception -> 0x0289 }
            goto L_0x01f9
        L_0x0221:
            r2 = 1
            if (r7 != r2) goto L_0x0242
            boolean r3 = r15.f()     // Catch:{ Exception -> 0x0289 }
            if (r3 == 0) goto L_0x022c
            goto L_0x0137
        L_0x022c:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY     // Catch:{ Exception -> 0x0289 }
            if (r3 != 0) goto L_0x0242
            int r3 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            boolean r3 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r3)     // Catch:{ Exception -> 0x0289 }
            if (r3 == 0) goto L_0x0242
            boolean r3 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            if (r3 == 0) goto L_0x0242
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x0242:
            int r3 = r1.p     // Catch:{ Exception -> 0x0289 }
            r6 = 94
            r7 = 287(0x11f, float:4.02E-43)
            if (r3 == r6) goto L_0x024c
            if (r3 != r7) goto L_0x0262
        L_0x024c:
            int r3 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            boolean r3 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r3)     // Catch:{ Exception -> 0x0289 }
            if (r3 == 0) goto L_0x0262
            boolean r3 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x0289 }
            if (r3 == 0) goto L_0x0262
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            return r15
        L_0x025e:
            r0 = r3
            r2 = 1
            r6 = 94
        L_0x0262:
            r2 = r26
            r3 = r0
            r5 = 0
        L_0x0266:
            r8 = 94
            r9 = 1
            r0 = r25
            goto L_0x008c
        L_0x026d:
            r0 = r3
            r2 = 1
            r6 = 94
            int r12 = r12 + 1
            r2 = r26
            r5 = 0
            r8 = 94
            r9 = 1
            r0 = r25
            goto L_0x0074
        L_0x027d:
            java.lang.String r0 = "UnitCacheCtroller"
            java.lang.String r2 = "UnitCache isReady campaignList = 0"
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0289 }
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            r2 = 0
            return r2
        L_0x0287:
            r0 = move-exception
            goto L_0x0290
        L_0x0289:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0287 }
        L_0x028d:
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            r2 = 0
            goto L_0x0293
        L_0x0290:
            monitor-exit(r4)     // Catch:{ all -> 0x0287 }
            throw r0
        L_0x0292:
            r2 = r5
        L_0x0293:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.n.a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public static boolean a(a aVar, int i2) {
        long l2 = aVar.l();
        long i3 = aVar.i();
        if (TextUtils.isEmpty(aVar.e())) {
            aa.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i2 == 0) {
            if (aVar.k() == null || TextUtils.isEmpty(aVar.k().getVideoUrlEncode())) {
                return false;
            }
            return true;
        } else if (i3 > 0 && l2 * 100 >= i3 * ((long) i2)) {
            if (i2 != 100 || aVar.j() == 5) {
                return true;
            }
            aVar.r();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i2, boolean z) {
        long l2 = aVar.l();
        long i3 = aVar.i();
        if (TextUtils.isEmpty(aVar.e())) {
            aa.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx k2 = aVar.k();
        if (k2 != null) {
            if (k2.getRsIgnoreCheckRule() != null && k2.getRsIgnoreCheckRule().size() > 0 && k2.getRsIgnoreCheckRule().contains(0)) {
                aa.b("UnitCacheCtroller", "Is not check video download status");
                return true;
            } else if (k2.getIsTimeoutCheckVideoStatus() == 1 && k2.getVideoCheckType() == 1) {
                return true;
            } else {
                if (z && k2.getVideoCheckType() == 1) {
                    if (i2 == 0) {
                        return true;
                    }
                    if (!(i3 == 0 && l2 == 0) && l2 >= ((long) (i2 / 100)) * i3) {
                        k2.setIsTimeoutCheckVideoStatus(1);
                        return true;
                    }
                }
            }
        }
        return a(aVar, i2);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                aa.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
                return true;
            } else if ((!campaignEx.isDynamicView() || af.j(str)) && !ak.a(str) && !b(str, campaignEx)) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
            aa.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } else if (!ak.b(g.a().b(str)) && !ak.b(h.a.a.b(str))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(int i2, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            aa.b("UnitCacheCtroller", "Is not check template download status");
            return true;
        } else if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0 && g.a().b(str) == null) {
            return false;
        } else {
            return true;
        }
    }

    public final a b(int i2, boolean z) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.c();
        }
        try {
            return a(i2, z);
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final a a(String str) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                Iterator<Map<String, a>> it = this.i.iterator();
                while (it.hasNext()) {
                    Map next = it.next();
                    if (next != null && next.containsKey(str)) {
                        a aVar = (a) next.get(str);
                        return aVar;
                    }
                }
            } catch (Throwable unused) {
                aa.d("UnitCacheCtroller", "failed to get campaignTast by cid");
            }
        }
        return null;
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map next = it.next();
                if (next != null) {
                    for (Map.Entry value : next.entrySet()) {
                        if (((a) value.getValue()).j() == 1) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f3 A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00db A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x012a A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012f A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0163 A[Catch:{ Exception -> 0x01c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r1.r
            if (r0 == 0) goto L_0x000e
            com.mbridge.msdk.videocommon.download.m r0 = r1.q
            if (r0 == 0) goto L_0x000e
            r0.a()
            return
        L_0x000e:
            r16.d()
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.i
            if (r2 == 0) goto L_0x022a
            monitor-enter(r2)
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.i     // Catch:{ all -> 0x0227 }
            boolean r0 = r1.a((java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>) r0)     // Catch:{ all -> 0x0227 }
            r3 = 1
            if (r0 != 0) goto L_0x0021
            r1.d = r3     // Catch:{ all -> 0x0227 }
        L_0x0021:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.i     // Catch:{ all -> 0x0227 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0227 }
        L_0x0027:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x0225
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0227 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x0036
            goto L_0x0027
        L_0x0036:
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0227 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0227 }
        L_0x003e:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0227 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0227 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0227 }
            r6 = r0
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ all -> 0x0227 }
            if (r6 != 0) goto L_0x0054
            goto L_0x003e
        L_0x0054:
            boolean r0 = r6.f()     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x005b
            goto L_0x003e
        L_0x005b:
            int r0 = r1.p     // Catch:{ all -> 0x0227 }
            r7 = 95
            if (r0 != r7) goto L_0x0063
            r1.d = r3     // Catch:{ all -> 0x0227 }
        L_0x0063:
            int r0 = r6.j()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r6.k()     // Catch:{ all -> 0x0227 }
            if (r8 == 0) goto L_0x007f
            if (r0 != 0) goto L_0x007f
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x0227 }
            java.lang.String r9 = r8.getId()     // Catch:{ all -> 0x0227 }
            java.lang.String r10 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x0227 }
            int r0 = r0.b(r9, r10)     // Catch:{ all -> 0x0227 }
        L_0x007f:
            r9 = r0
            com.mbridge.msdk.videocommon.download.n$2 r0 = new com.mbridge.msdk.videocommon.download.n$2     // Catch:{ all -> 0x0227 }
            r0.<init>(r8)     // Catch:{ all -> 0x0227 }
            r6.a((com.mbridge.msdk.videocommon.listener.a) r0)     // Catch:{ all -> 0x0227 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x0227 }
            int r10 = r1.p     // Catch:{ all -> 0x0227 }
            if (r10 != r3) goto L_0x00a0
            com.mbridge.msdk.c.h r0 = r1.a     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x009c
            java.lang.String r0 = r1.m     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.d(r0)     // Catch:{ all -> 0x0227 }
            r1.a = r0     // Catch:{ all -> 0x0227 }
        L_0x009c:
            int r0 = r1.d(r8)     // Catch:{ all -> 0x0227 }
        L_0x00a0:
            r10 = r0
            r6.c((int) r10)     // Catch:{ all -> 0x0227 }
            int r0 = r1.p     // Catch:{ all -> 0x0227 }
            r11 = 94
            r12 = 298(0x12a, float:4.18E-43)
            r13 = 287(0x11f, float:4.02E-43)
            if (r0 == r11) goto L_0x00fc
            if (r0 == r13) goto L_0x00fc
            if (r0 != r7) goto L_0x00b3
            goto L_0x00fc
        L_0x00b3:
            if (r0 != r12) goto L_0x00d6
            com.mbridge.msdk.c.h r0 = r1.b     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x00cd
            com.mbridge.msdk.c.f r0 = com.mbridge.msdk.c.f.a()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.controller.b r15 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0227 }
            java.lang.String r15 = r15.h()     // Catch:{ all -> 0x0227 }
            java.lang.String r14 = r1.m     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.c.h r0 = r0.c(r15, r14)     // Catch:{ all -> 0x0227 }
            r1.b = r0     // Catch:{ all -> 0x0227 }
        L_0x00cd:
            com.mbridge.msdk.c.h r0 = r1.b     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x00d6
            int r0 = r0.g()     // Catch:{ all -> 0x0227 }
            goto L_0x00d7
        L_0x00d6:
            r0 = 0
        L_0x00d7:
            int r14 = r1.p     // Catch:{ all -> 0x0227 }
            if (r14 != r3) goto L_0x0125
            com.mbridge.msdk.c.h r14 = r1.a     // Catch:{ all -> 0x0227 }
            if (r14 != 0) goto L_0x00f3
            com.mbridge.msdk.c.f r14 = com.mbridge.msdk.c.f.a()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.controller.b r15 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0227 }
            java.lang.String r15 = r15.h()     // Catch:{ all -> 0x0227 }
            java.lang.String r7 = r1.m     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.c.h r7 = r14.c(r15, r7)     // Catch:{ all -> 0x0227 }
            r1.a = r7     // Catch:{ all -> 0x0227 }
        L_0x00f3:
            com.mbridge.msdk.c.h r7 = r1.a     // Catch:{ all -> 0x0227 }
            if (r7 == 0) goto L_0x0125
            int r0 = r7.g()     // Catch:{ all -> 0x0227 }
            goto L_0x0125
        L_0x00fc:
            com.mbridge.msdk.videocommon.d.c r0 = r1.n     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x011b
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.controller.b r7 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0227 }
            java.lang.String r7 = r7.h()     // Catch:{ all -> 0x0227 }
            java.lang.String r14 = r1.m     // Catch:{ all -> 0x0227 }
            int r15 = r1.p     // Catch:{ all -> 0x0227 }
            if (r15 != r13) goto L_0x0114
            r15 = 1
            goto L_0x0115
        L_0x0114:
            r15 = 0
        L_0x0115:
            com.mbridge.msdk.videocommon.d.c r0 = r0.a((java.lang.String) r7, (java.lang.String) r14, (boolean) r15)     // Catch:{ all -> 0x0227 }
            r1.n = r0     // Catch:{ all -> 0x0227 }
        L_0x011b:
            com.mbridge.msdk.videocommon.d.c r0 = r1.n     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x0124
            int r0 = r0.s()     // Catch:{ all -> 0x0227 }
            goto L_0x0125
        L_0x0124:
            r0 = 0
        L_0x0125:
            r6.b((int) r0)     // Catch:{ all -> 0x0227 }
            if (r8 == 0) goto L_0x012f
            int r7 = r8.getVideoCtnType()     // Catch:{ all -> 0x0227 }
            goto L_0x0130
        L_0x012f:
            r7 = 1
        L_0x0130:
            r6.e((int) r7)     // Catch:{ all -> 0x0227 }
            java.lang.String r14 = "UnitCacheCtroller"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0227 }
            r15.<init>()     // Catch:{ all -> 0x0227 }
            java.lang.String r13 = "ready_rate : "
            r15.append(r13)     // Catch:{ all -> 0x0227 }
            r15.append(r10)     // Catch:{ all -> 0x0227 }
            java.lang.String r13 = " cd_rate : "
            r15.append(r13)     // Catch:{ all -> 0x0227 }
            r15.append(r0)     // Catch:{ all -> 0x0227 }
            java.lang.String r0 = " videoCtnType : "
            r15.append(r0)     // Catch:{ all -> 0x0227 }
            r15.append(r7)     // Catch:{ all -> 0x0227 }
            java.lang.String r0 = r15.toString()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.tools.aa.d(r14, r0)     // Catch:{ all -> 0x0227 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x0227 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r0)     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x01d4
            com.mbridge.msdk.videocommon.listener.a r0 = r1.e     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x0176
            int r7 = r1.p     // Catch:{ all -> 0x0227 }
            r13 = 297(0x129, float:4.16E-43)
            if (r7 == r13) goto L_0x016f
            if (r7 != r12) goto L_0x0176
        L_0x016f:
            java.lang.String r7 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x0227 }
            r0.a(r7)     // Catch:{ all -> 0x0227 }
        L_0x0176:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r0 = r1.g     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x01d4
            int r0 = r0.size()     // Catch:{ all -> 0x0227 }
            if (r0 <= 0) goto L_0x01d4
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r0 = r1.g     // Catch:{ all -> 0x0227 }
            java.lang.String r7 = r8.getRequestId()     // Catch:{ all -> 0x0227 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0227 }
            r7 = r0
            com.mbridge.msdk.videocommon.listener.a r7 = (com.mbridge.msdk.videocommon.listener.a) r7     // Catch:{ all -> 0x0227 }
            if (r7 == 0) goto L_0x01d4
            if (r8 == 0) goto L_0x01d4
            java.lang.String r0 = r8.getCurrentLRid()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r13 = r1.f     // Catch:{ Exception -> 0x01c3 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x01c3 }
            if (r0 == 0) goto L_0x01cd
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x01c3 }
            r0.<init>()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r13 = "type"
            java.lang.String r14 = "4"
            r0.put(r13, r14)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r13 = "cache"
            java.lang.String r14 = "1"
            r0.put(r13, r14)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r13 = "update"
            java.lang.String r14 = "1"
            r0.put(r13, r14)     // Catch:{ Exception -> 0x01c3 }
            com.mbridge.msdk.foundation.same.report.m r13 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r14 = "2000153"
            r13.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01cd
        L_0x01c3:
            r0 = move-exception
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0227 }
            com.mbridge.msdk.foundation.tools.aa.d(r13, r0)     // Catch:{ all -> 0x0227 }
        L_0x01cd:
            java.lang.String r0 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x0227 }
            r7.a(r0)     // Catch:{ all -> 0x0227 }
        L_0x01d4:
            if (r9 == r3) goto L_0x003e
            r0 = 5
            if (r9 != r0) goto L_0x01df
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r10)     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x003e
        L_0x01df:
            r0 = 4
            if (r9 == r0) goto L_0x003e
            android.content.Context r0 = r1.j     // Catch:{ all -> 0x0227 }
            int r0 = com.mbridge.msdk.foundation.tools.w.r(r0)     // Catch:{ all -> 0x0227 }
            r7 = 9
            r8 = 2
            if (r0 == r7) goto L_0x01f3
            int r0 = r1.o     // Catch:{ all -> 0x0227 }
            if (r0 != r8) goto L_0x01f3
            monitor-exit(r2)     // Catch:{ all -> 0x0227 }
            return
        L_0x01f3:
            if (r9 == r8) goto L_0x01fb
            boolean r0 = r1.d     // Catch:{ all -> 0x0227 }
            if (r0 != 0) goto L_0x01fb
            goto L_0x003e
        L_0x01fb:
            com.mbridge.msdk.videocommon.download.d r0 = r1.h     // Catch:{ all -> 0x0227 }
            r6.a((com.mbridge.msdk.videocommon.download.d) r0)     // Catch:{ all -> 0x0227 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r10)     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x0213
            int r0 = r1.p     // Catch:{ all -> 0x0227 }
            if (r0 == r11) goto L_0x020e
            r7 = 287(0x11f, float:4.02E-43)
            if (r0 != r7) goto L_0x003e
        L_0x020e:
            r6.n()     // Catch:{ all -> 0x0227 }
            goto L_0x003e
        L_0x0213:
            int r0 = r1.p     // Catch:{ all -> 0x0227 }
            if (r0 == r3) goto L_0x021d
            r7 = 95
            if (r0 == r7) goto L_0x021d
            if (r0 != r12) goto L_0x0220
        L_0x021d:
            r7 = 0
            r1.d = r7     // Catch:{ all -> 0x0227 }
        L_0x0220:
            r6.n()     // Catch:{ all -> 0x0227 }
            goto L_0x003e
        L_0x0225:
            monitor-exit(r2)     // Catch:{ all -> 0x0227 }
            goto L_0x022a
        L_0x0227:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0227 }
            throw r0
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.n.a():void");
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.r || this.q == null) && (copyOnWriteArrayList = this.i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, a>> it = this.i.iterator();
                    while (it.hasNext()) {
                        Map next = it.next();
                        if (next != null) {
                            for (Map.Entry value : next.entrySet()) {
                                a aVar = (a) value.getValue();
                                if (aVar != null) {
                                    if (aVar.j() == 1) {
                                        aVar.b("playing and stop download");
                                        aVar.r();
                                        this.i.remove(next);
                                        return;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            return this.i;
        }
        return mVar.d();
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.c.h hVar = this.a;
            if (hVar != null) {
                return hVar.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        m mVar;
        if (!this.r || (mVar = this.q) == null) {
            try {
                synchronized (this.i) {
                    if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.i) != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<Map<String, a>> it = this.i.iterator();
                        while (it.hasNext()) {
                            Map next = it.next();
                            if (next != null) {
                                for (Map.Entry entry : next.entrySet()) {
                                    if (entry != null && TextUtils.equals((CharSequence) entry.getKey(), str)) {
                                        this.i.remove(next);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            mVar.b(str);
        }
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.b == null) {
                    this.b = f.a().c(b.d().h(), this.m);
                }
                return this.b.f();
            } else if (campaignEx.getAdType() == 42) {
                return d((CampaignEx) null);
            } else {
                if (this.n == null) {
                    this.n = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), this.m, false);
                }
                return this.n.r();
            }
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }
}
