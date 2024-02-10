package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.C0218h;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.b;
import com.ironsource.mediationsdk.bidding.d;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.h;
import com.ironsource.mediationsdk.services.IMediationServiceEditor;
import com.ironsource.mediationsdk.services.IMediationServiceProvider;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.j;
import com.ironsource.mediationsdk.utils.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class L extends C0225o implements M, C0214d, C0229s {
    private final com.ironsource.mediationsdk.services.a A;
    private final a.C0114a B;
    final ConcurrentHashMap<String, N> d;
    String e;
    JSONObject f;
    final boolean g;
    long h;
    long i;
    private m j;
    private a k;
    private CopyOnWriteArrayList<N> l;
    private ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> m;
    private ConcurrentHashMap<String, C0218h.a> n;
    private com.ironsource.mediationsdk.adunit.a.a o;
    private String p;
    private int q;
    private boolean r;
    private final long s;
    private boolean t;
    private C0216f u;
    private C0218h v;
    private long w;
    private int x;
    private String y;
    private boolean z;

    enum a {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    private L(IMediationServiceProvider iMediationServiceProvider, IMediationServiceEditor iMediationServiceEditor, List<NetworkSettings> list, h hVar, String str, String str2, int i2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.y = "";
        this.z = false;
        this.A = iMediationServiceProvider.getSessionDepthService();
        this.B = iMediationServiceEditor.getSessionDepthServiceEditor();
        long time = new Date().getTime();
        a((int) IronSourceConstants.IS_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_IS_MANAGER_NAME}});
        a(a.STATE_NOT_INITIALIZED);
        ConcurrentHashMap<String, N> concurrentHashMap = new ConcurrentHashMap<>();
        this.d = concurrentHashMap;
        this.l = new CopyOnWriteArrayList<>();
        this.m = new ConcurrentHashMap<>();
        this.n = new ConcurrentHashMap<>();
        this.p = "";
        this.e = "";
        this.f = null;
        this.q = hVar.c;
        this.r = hVar.d;
        this.g = hVar.i;
        this.s = hVar.j;
        C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, i2);
        c cVar = hVar.g;
        this.i = cVar.g;
        boolean z2 = cVar.c > 0;
        this.t = z2;
        if (z2) {
            this.u = new C0216f(IronSource.AD_UNIT.INTERSTITIAL, cVar, this);
        }
        a(list, hVar, str, str2);
        this.v = new C0218h(list, cVar.d);
        this.j = new m(new ArrayList(concurrentHashMap.values()));
        for (N next : concurrentHashMap.values()) {
            if (next.j()) {
                next.a();
            }
        }
        this.h = new Date().getTime();
        a(a.STATE_READY_TO_LOAD);
        a((int) IronSourceConstants.IS_MANAGER_INIT_ENDED, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    public L(List<NetworkSettings> list, h hVar, String str, String str2, int i2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(MediationServices.getProvider(), MediationServices.getEditor(), list, hVar, str, str2, i2, hashSet, ironSourceSegment);
    }

    private String a(com.ironsource.mediationsdk.adunit.a.a aVar) {
        N n2 = this.d.get(aVar.a());
        String num = n2 != null ? Integer.toString(n2.l()) : TextUtils.isEmpty(aVar.b()) ? "1" : "2";
        return num + aVar.a();
    }

    private void a(int i2, N n2) {
        a(i2, n2, (Object[][]) null, false);
    }

    private void a(int i2, N n2, Object[][] objArr, boolean z2) {
        Map<String, Object> q2 = n2.q();
        if (!TextUtils.isEmpty(this.e)) {
            q2.put("auctionId", this.e);
        }
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.length() > 0) {
            q2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
        }
        if (z2 && !TextUtils.isEmpty(this.p)) {
            q2.put("placement", this.p);
        }
        if (a(i2)) {
            e.d();
            e.a(q2, this.x, this.y);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(q2)));
    }

    private void a(int i2, Object[][] objArr) {
        a(i2, objArr, false);
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.e)) {
            hashMap.put("auctionId", this.e);
        }
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
        }
        if (z2 && !TextUtils.isEmpty(this.p)) {
            hashMap.put("placement", this.p);
        }
        if (a(i2)) {
            e.d();
            e.a((Map<String, Object>) hashMap, this.x, this.y);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                b("sendMediationEvent " + e2.getMessage());
            }
        }
        e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(hashMap)));
    }

    private void a(a aVar) {
        this.k = aVar;
        b("state=" + aVar);
    }

    static /* synthetic */ void a(L l2, Map map, List list, StringBuilder sb, List list2) {
        StringBuilder sb2;
        for (N next : l2.d.values()) {
            if (l2.g(next)) {
                if (!next.h()) {
                    list.add(next.n());
                    sb2 = new StringBuilder();
                } else if (l2.g) {
                    list2.add(new com.ironsource.mediationsdk.bidding.a(next.l(), next.n(), (AdData) null, next, (b) null, (NetworkSettings) null));
                } else {
                    Map<String, Object> a2 = next.a((AdData) null);
                    if (a2 != null) {
                        map.put(next.n(), a2);
                        sb2 = new StringBuilder();
                    } else {
                        l2.a((int) IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, next, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Missing bidding data"}});
                    }
                }
                sb2.append(next.l());
                sb2.append(next.n());
                sb2.append(",");
                sb.append(sb2.toString());
            }
        }
    }

    private static void a(N n2, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + n2.n() + " : " + str, 0);
    }

    private static void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(List<com.ironsource.mediationsdk.adunit.a.a> list) {
        this.l.clear();
        this.m.clear();
        this.n.clear();
        StringBuilder sb = new StringBuilder();
        for (com.ironsource.mediationsdk.adunit.a.a next : list) {
            sb.append(a(next) + ",");
            N n2 = this.d.get(next.a());
            if (n2 != null) {
                n2.e = true;
                this.l.add(n2);
                this.m.put(n2.n(), next);
                this.n.put(next.a(), C0218h.a.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                b("updateWaterfall() - could not find matching smash for auction response item " + next.a());
            }
        }
        b("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            b("Updated waterfall is empty");
        }
        a((int) IronSourceConstants.IS_RESULT_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
    }

    private void a(List<NetworkSettings> list, h hVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (final NetworkSettings next : list) {
            final h hVar2 = hVar;
            final String str3 = str;
            final String str4 = str2;
            arrayList.add(new Runnable() {
                public final void run() {
                    L l = L.this;
                    NetworkSettings networkSettings = next;
                    h hVar = hVar2;
                    String str = str3;
                    String str2 = str4;
                    IronLog.INTERNAL.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                    AbstractAdapter a2 = C0213c.a().a(networkSettings, networkSettings.getInterstitialSettings(), false, false);
                    if (a2 != null) {
                        N n = new N(str, str2, networkSettings, l, hVar.e, a2);
                        l.d.put(n.n(), n);
                    }
                    IronLog.INTERNAL.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                }
            });
        }
        IronSourceThreadManager.INSTANCE.executeTasks(hVar.k, hVar.l, arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.size() == 0 && list.size() == 0) {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}}, false);
            b("makeAuction() failed - No candidates available for auctioning");
            C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(1005, "No candidates available for auctioning"));
            a(2110, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}}, false);
            a(a.STATE_READY_TO_LOAD);
            return;
        }
        a((int) IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str}}, false);
        int a2 = this.A.a(IronSource.AD_UNIT.INTERSTITIAL);
        C0216f fVar = this.u;
        if (fVar != null) {
            fVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.v, a2, this.b);
        }
    }

    private static boolean a(int i2) {
        return i2 == 2002 || i2 == 2003 || i2 == 2200 || i2 == 2213 || i2 == 2005 || i2 == 2204 || i2 == 2201 || i2 == 2203 || i2 == 2006 || i2 == 2004 || i2 == 2110 || i2 == 2301 || i2 == 2300 || i2 == 2303;
    }

    private void b(int i2, N n2) {
        a(i2, n2, (Object[][]) null, true);
    }

    private void b(int i2, N n2, Object[][] objArr) {
        a(i2, n2, objArr, true);
    }

    private void b(int i2, Object[][] objArr) {
        a(i2, objArr, true);
    }

    static /* synthetic */ void b(L l2, final Map map, final List list, final StringBuilder sb, List list2) {
        if (list2.isEmpty()) {
            l2.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            return;
        }
        d dVar = new d();
        AnonymousClass3 r2 = new d.a() {
            public final void a(String str) {
                L.this.a((int) IronSourceConstants.IS_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}}, false);
                L.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }

            public final void a(List<j> list, long j, List<String> list2) {
                L.this.a((int) IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}}, false);
                for (j next : list) {
                    if (next.c() != null) {
                        map.put(next.b(), next.c());
                        StringBuilder sb = sb;
                        sb.append(next.a());
                        sb.append(next.b());
                        sb.append(",");
                        L l = L.this;
                        l.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, l.d.get(next.b()), new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}});
                    } else {
                        L l2 = L.this;
                        l2.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, l2.d.get(next.b()), new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, next.e()}});
                    }
                }
                for (String str : list2) {
                    L l3 = L.this;
                    ConcurrentHashMap<String, N> concurrentHashMap = l3.d;
                    l3.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, concurrentHashMap.get(str), new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                }
                L.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }
        };
        l2.a((int) IronSourceConstants.IS_COLLECT_TOKENS, (Object[][]) null, false);
        dVar.a((List<com.ironsource.mediationsdk.bidding.a>) list2, (d.a) r2, l2.s, TimeUnit.MILLISECONDS);
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgIsManager " + str, 0);
    }

    private void f() {
        List<com.ironsource.mediationsdk.adunit.a.a> g2 = g();
        this.e = c();
        a(g2);
    }

    private List<com.ironsource.mediationsdk.adunit.a.a> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (N next : this.d.values()) {
            if (!next.h() && g(next)) {
                copyOnWriteArrayList.add(new com.ironsource.mediationsdk.adunit.a.a(next.n()));
            }
        }
        return copyOnWriteArrayList;
    }

    private boolean g(N n2) {
        IronLog.INTERNAL.verbose();
        return n2 != null && !n2.k() && !this.j.b(n2);
    }

    private void h() {
        if (this.l.isEmpty()) {
            a(a.STATE_READY_TO_LOAD);
            a(2110, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1035}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Empty waterfall"}}, false);
            C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(1035, "Empty waterfall"));
            return;
        }
        a(a.STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.l.size() && i2 < this.q; i3++) {
            N n2 = this.l.get(i3);
            if (n2.e) {
                if (!this.r || !n2.h()) {
                    h(n2);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + n2.n() + ". No other instances will be loaded at the same time.";
                    b(str);
                    IronSourceUtils.sendAutomationLog(str);
                    h(n2);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + n2.n() + " as a non bidder is being loaded";
                    b(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    private void h(N n2) {
        String b = this.m.get(n2.n()).b();
        JSONObject c = this.m.get(n2.n()).c();
        n2.a(b);
        a(2002, n2);
        n2.a(b, c);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a(a.STATE_AUCTION);
        AsyncTask.execute(new Runnable() {
            public final void run() {
                boolean z;
                L.this.e = "";
                L.this.f = null;
                L l = L.this;
                long time = l.i - (new Date().getTime() - l.h);
                if (time > 0) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("delaying auction by " + time);
                    IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                        public final void run() {
                            L.this.a();
                        }
                    }, time);
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    L.this.a(2000, (Object[][]) null, false);
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList2 = new ArrayList();
                    L.a(L.this, (Map) hashMap, (List) arrayList, sb, (List) arrayList2);
                    if (L.this.g) {
                        L.b(L.this, hashMap, arrayList, sb, arrayList2);
                    } else {
                        L.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, N n2, Object[][] objArr) {
        a(i2, n2, objArr, false);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        b(str3);
        IronSourceUtils.sendAutomationLog("IS: " + str3);
        this.x = i3;
        this.y = str2;
        this.f = null;
        f();
        if (TextUtils.isEmpty(str)) {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(j2)}});
        } else {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{"duration", Long.valueOf(j2)}});
        }
        h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.app.Activity r10, java.lang.String r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.L$a r0 = r9.k     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.L$a r1 = com.ironsource.mediationsdk.L.a.STATE_SHOWING     // Catch:{ all -> 0x01f1 }
            r2 = 2111(0x83f, float:2.958E-42)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 != r1) goto L_0x0040
            java.lang.String r10 = "showInterstitial error: can't show ad while an ad is already showing"
            a((java.lang.String) r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01f1 }
            r0 = 1036(0x40c, float:1.452E-42)
            r11.<init>(r0, r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.u r1 = com.ironsource.mediationsdk.C0231u.a()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r6 = r9.c     // Catch:{ all -> 0x01f1 }
            r1.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r6)     // Catch:{ all -> 0x01f1 }
            java.lang.Object[][] r11 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r6 = "errorCode"
            r1[r4] = r6     // Catch:{ all -> 0x01f1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01f1 }
            r1[r5] = r0     // Catch:{ all -> 0x01f1 }
            r11[r4] = r1     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "reason"
            r0[r4] = r1     // Catch:{ all -> 0x01f1 }
            r0[r5] = r10     // Catch:{ all -> 0x01f1 }
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r9.a((int) r2, (java.lang.Object[][]) r11, (boolean) r4)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r9)
            return
        L_0x0040:
            com.ironsource.mediationsdk.L$a r0 = r9.k     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.L$a r1 = com.ironsource.mediationsdk.L.a.STATE_READY_TO_SHOW     // Catch:{ all -> 0x01f1 }
            r6 = 509(0x1fd, float:7.13E-43)
            if (r0 == r1) goto L_0x0091
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = "showInterstitial() error state="
            r10.<init>(r11)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.L$a r11 = r9.k     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01f1 }
            r10.append(r11)     // Catch:{ all -> 0x01f1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01f1 }
            b((java.lang.String) r10)     // Catch:{ all -> 0x01f1 }
            java.lang.String r10 = "showInterstitial error: show called while no ads are available"
            a((java.lang.String) r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01f1 }
            r11.<init>(r6, r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.u r0 = com.ironsource.mediationsdk.C0231u.a()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r1 = r9.c     // Catch:{ all -> 0x01f1 }
            r0.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)     // Catch:{ all -> 0x01f1 }
            java.lang.Object[][] r11 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "errorCode"
            r0[r4] = r1     // Catch:{ all -> 0x01f1 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01f1 }
            r0[r5] = r1     // Catch:{ all -> 0x01f1 }
            r11[r4] = r0     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "reason"
            r0[r4] = r1     // Catch:{ all -> 0x01f1 }
            r0[r5] = r10     // Catch:{ all -> 0x01f1 }
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r9.a((int) r2, (java.lang.Object[][]) r11)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r9)
            return
        L_0x0091:
            if (r11 != 0) goto L_0x00c7
            java.lang.String r10 = "showInterstitial error: empty default placement"
            a((java.lang.String) r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01f1 }
            r0 = 1020(0x3fc, float:1.43E-42)
            r11.<init>(r0, r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.u r1 = com.ironsource.mediationsdk.C0231u.a()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r6 = r9.c     // Catch:{ all -> 0x01f1 }
            r1.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r6)     // Catch:{ all -> 0x01f1 }
            java.lang.Object[][] r11 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r6 = "errorCode"
            r1[r4] = r6     // Catch:{ all -> 0x01f1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01f1 }
            r1[r5] = r0     // Catch:{ all -> 0x01f1 }
            r11[r4] = r1     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "reason"
            r0[r4] = r1     // Catch:{ all -> 0x01f1 }
            r0[r5] = r10     // Catch:{ all -> 0x01f1 }
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r9.a((int) r2, (java.lang.Object[][]) r11)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r9)
            return
        L_0x00c7:
            r9.p = r11     // Catch:{ all -> 0x01f1 }
            r0 = 0
            if (r10 == 0) goto L_0x00db
            java.lang.Object[][] r10 = new java.lang.Object[r5][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r7 = "ext1"
            r1[r4] = r7     // Catch:{ all -> 0x01f1 }
            java.lang.String r7 = "init_context_flow"
            r1[r5] = r7     // Catch:{ all -> 0x01f1 }
            r10[r4] = r1     // Catch:{ all -> 0x01f1 }
            goto L_0x00dc
        L_0x00db:
            r10 = r0
        L_0x00dc:
            r1 = 2100(0x834, float:2.943E-42)
            r9.b((int) r1, (java.lang.Object[][]) r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01f1 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x01f1 }
            boolean r10 = com.ironsource.mediationsdk.utils.j.a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x01f1 }
            if (r10 == 0) goto L_0x0136
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = "placement "
            r10.<init>(r11)     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = r9.p     // Catch:{ all -> 0x01f1 }
            r10.append(r11)     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = " is capped"
            r10.append(r11)     // Catch:{ all -> 0x01f1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01f1 }
            a((java.lang.String) r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01f1 }
            r0 = 524(0x20c, float:7.34E-43)
            r11.<init>(r0, r10)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.u r1 = com.ironsource.mediationsdk.C0231u.a()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r6 = r9.c     // Catch:{ all -> 0x01f1 }
            r1.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r6)     // Catch:{ all -> 0x01f1 }
            java.lang.Object[][] r11 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r6 = "errorCode"
            r1[r4] = r6     // Catch:{ all -> 0x01f1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01f1 }
            r1[r5] = r0     // Catch:{ all -> 0x01f1 }
            r11[r4] = r1     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "reason"
            r0[r4] = r1     // Catch:{ all -> 0x01f1 }
            r0[r5] = r10     // Catch:{ all -> 0x01f1 }
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r9.b((int) r2, (java.lang.Object[][]) r11)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r9)
            return
        L_0x0136:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.N> r10 = r9.l     // Catch:{ all -> 0x01f1 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01f1 }
        L_0x013c:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x01f1 }
            if (r1 == 0) goto L_0x01c1
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.N r1 = (com.ironsource.mediationsdk.N) r1     // Catch:{ all -> 0x01f1 }
            boolean r7 = r1.g()     // Catch:{ all -> 0x01f1 }
            if (r7 == 0) goto L_0x01a5
            com.ironsource.mediationsdk.L$a r10 = com.ironsource.mediationsdk.L.a.STATE_SHOWING     // Catch:{ all -> 0x01f1 }
            r9.a((com.ironsource.mediationsdk.L.a) r10)     // Catch:{ all -> 0x01f1 }
            r1.b()     // Catch:{ all -> 0x01f1 }
            r10 = 2201(0x899, float:3.084E-42)
            r9.b((int) r10, (com.ironsource.mediationsdk.N) r1)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.utils.m r10 = r9.j     // Catch:{ all -> 0x01f1 }
            r10.a(r1)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.utils.m r10 = r9.j     // Catch:{ all -> 0x01f1 }
            boolean r10 = r10.b(r1)     // Catch:{ all -> 0x01f1 }
            if (r10 == 0) goto L_0x0185
            r10 = 2401(0x961, float:3.365E-42)
            r9.a((int) r10, (com.ironsource.mediationsdk.N) r1)     // Catch:{ all -> 0x01f1 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            r10.<init>()     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = r1.n()     // Catch:{ all -> 0x01f1 }
            r10.append(r1)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = " was session capped"
            r10.append(r1)     // Catch:{ all -> 0x01f1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r10)     // Catch:{ all -> 0x01f1 }
        L_0x0185:
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01f1 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.utils.j.d(r10, r11)     // Catch:{ all -> 0x01f1 }
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01f1 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x01f1 }
            boolean r10 = com.ironsource.mediationsdk.utils.j.a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x01f1 }
            if (r10 == 0) goto L_0x01a3
            r10 = 2400(0x960, float:3.363E-42)
            r9.a((int) r10, (java.lang.Object[][]) r0, (boolean) r5)     // Catch:{ all -> 0x01f1 }
        L_0x01a3:
            monitor-exit(r9)
            return
        L_0x01a5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            java.lang.String r8 = "showInterstitial "
            r7.<init>(r8)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = r1.n()     // Catch:{ all -> 0x01f1 }
            r7.append(r1)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = " isReadyToShow() == false"
            r7.append(r1)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x01f1 }
            b((java.lang.String) r1)     // Catch:{ all -> 0x01f1 }
            goto L_0x013c
        L_0x01c1:
            com.ironsource.mediationsdk.u r10 = com.ironsource.mediationsdk.C0231u.a()     // Catch:{ all -> 0x01f1 }
            java.lang.String r11 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r11)     // Catch:{ all -> 0x01f1 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r0 = r9.c     // Catch:{ all -> 0x01f1 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r0)     // Catch:{ all -> 0x01f1 }
            java.lang.Object[][] r10 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = "errorCode"
            r11[r4] = r0     // Catch:{ all -> 0x01f1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01f1 }
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r10[r4] = r11     // Catch:{ all -> 0x01f1 }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = "reason"
            r11[r4] = r0     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = "Show Fail - No ads to show"
            r11[r5] = r0     // Catch:{ all -> 0x01f1 }
            r10[r5] = r11     // Catch:{ all -> 0x01f1 }
            r9.b((int) r2, (java.lang.Object[][]) r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r9)
            return
        L_0x01f1:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x01f5
        L_0x01f4:
            throw r10
        L_0x01f5:
            goto L_0x01f4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.L.a(android.app.Activity, java.lang.String):void");
    }

    public final void a(N n2) {
        synchronized (this) {
            a(n2, "onInterstitialAdOpened");
            b(2005, n2);
            if (this.t) {
                com.ironsource.mediationsdk.adunit.a.a aVar = this.m.get(n2.n());
                if (aVar != null) {
                    a(aVar.a(this.p));
                    C0216f.a(aVar, n2.l(), this.o, this.p);
                    this.n.put(n2.n(), C0218h.a.ISAuctionPerformanceShowedSuccessfully);
                    a(aVar, this.p);
                } else {
                    String n3 = n2.n();
                    b("onInterstitialAdOpened showing instance " + n3 + " missing from waterfall");
                    Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1011};
                    a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.k}, new Object[]{IronSourceConstants.EVENTS_EXT1, n3}});
                }
            }
            C0231u.a().b(this.c);
        }
    }

    public final void a(N n2, long j2) {
        synchronized (this) {
            a(n2, "onInterstitialAdReady");
            a(2003, n2, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}});
            if (this.n.containsKey(n2.n())) {
                this.n.put(n2.n(), C0218h.a.ISAuctionPerformanceLoadedSuccessfully);
            }
            if (this.k == a.STATE_LOADING_SMASHES) {
                a(a.STATE_READY_TO_SHOW);
                a(2004, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.w)}});
                if (this.t) {
                    com.ironsource.mediationsdk.adunit.a.a aVar = this.m.get(n2.n());
                    if (aVar != null) {
                        a(aVar.a(""));
                        C0216f.a(aVar, n2.l(), this.o);
                        C0216f fVar = this.u;
                        CopyOnWriteArrayList<N> copyOnWriteArrayList = this.l;
                        CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                        fVar.a((CopyOnWriteArrayList<O>) copyOnWriteArrayList, this.m, n2.l(), this.o, aVar);
                    } else {
                        String n3 = n2.n();
                        b("onInterstitialAdReady winner instance " + n3 + " missing from waterfall");
                        a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, n3}});
                    }
                }
                C0231u.a().a(this.c);
            }
        }
    }

    public final void a(IronSourceError ironSourceError, N n2) {
        com.ironsource.mediationsdk.adunit.a.a aVar;
        synchronized (this) {
            if (this.t && (aVar = this.m.get(n2.n())) != null) {
                a(aVar.a(this.p));
            }
            a(n2, "onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
            C0231u.a().a(ironSourceError, this.c);
            b(IronSourceConstants.IS_INSTANCE_SHOW_FAILED, n2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
            this.n.put(n2.n(), C0218h.a.ISAuctionPerformanceFailedToShow);
            a(a.STATE_READY_TO_LOAD);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f0, code lost:
        if (r10 == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f2, code lost:
        r8 = "a non bidder is being loaded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f5, code lost:
        r8 = "a non bidder was already loaded successfully";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f7, code lost:
        r8 = "Advanced Loading: Won't start loading bidder " + r1.n() + " as " + r8;
        b(r8);
        com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.logger.IronSourceError r8, com.ironsource.mediationsdk.N r9, long r10) {
        /*
            r7 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            monitor-enter(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = "onInterstitialAdLoadFailed error="
            r1.<init>(r2)     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = r8.getErrorMessage()     // Catch:{ all -> 0x01ba }
            r1.append(r2)     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = " state="
            r1.append(r2)     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.L$a r2 = r7.k     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = r2.name()     // Catch:{ all -> 0x01ba }
            r1.append(r2)     // Catch:{ all -> 0x01ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01ba }
            a((com.ironsource.mediationsdk.N) r9, (java.lang.String) r1)     // Catch:{ all -> 0x01ba }
            int r1 = r8.getErrorCode()     // Catch:{ all -> 0x01ba }
            r2 = 1158(0x486, float:1.623E-42)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 != r2) goto L_0x005c
            java.lang.Object[][] r1 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = "errorCode"
            r2[r4] = r6     // Catch:{ all -> 0x01ba }
            int r8 = r8.getErrorCode()     // Catch:{ all -> 0x01ba }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01ba }
            r2[r5] = r8     // Catch:{ all -> 0x01ba }
            r1[r4] = r2     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = "duration"
            r8[r4] = r2     // Catch:{ all -> 0x01ba }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01ba }
            r8[r5] = r10     // Catch:{ all -> 0x01ba }
            r1[r5] = r8     // Catch:{ all -> 0x01ba }
            r8 = 2213(0x8a5, float:3.101E-42)
            r7.a((int) r8, (com.ironsource.mediationsdk.N) r9, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x01ba }
            goto L_0x0092
        L_0x005c:
            r1 = 3
            java.lang.Object[][] r1 = new java.lang.Object[r1][]     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = "errorCode"
            r2[r4] = r6     // Catch:{ all -> 0x01ba }
            int r6 = r8.getErrorCode()     // Catch:{ all -> 0x01ba }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01ba }
            r2[r5] = r6     // Catch:{ all -> 0x01ba }
            r1[r4] = r2     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = "reason"
            r2[r4] = r6     // Catch:{ all -> 0x01ba }
            java.lang.String r8 = r8.getErrorMessage()     // Catch:{ all -> 0x01ba }
            r2[r5] = r8     // Catch:{ all -> 0x01ba }
            r1[r5] = r2     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = "duration"
            r8[r4] = r2     // Catch:{ all -> 0x01ba }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01ba }
            r8[r5] = r10     // Catch:{ all -> 0x01ba }
            r1[r3] = r8     // Catch:{ all -> 0x01ba }
            r8 = 2200(0x898, float:3.083E-42)
            r7.a((int) r8, (com.ironsource.mediationsdk.N) r9, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x01ba }
        L_0x0092:
            if (r9 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r8 = r7.n     // Catch:{ all -> 0x01ba }
            java.lang.String r10 = r9.n()     // Catch:{ all -> 0x01ba }
            boolean r8 = r8.containsKey(r10)     // Catch:{ all -> 0x01ba }
            if (r8 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r8 = r7.n     // Catch:{ all -> 0x01ba }
            java.lang.String r10 = r9.n()     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.h$a r11 = com.ironsource.mediationsdk.C0218h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x01ba }
            r8.put(r10, r11)     // Catch:{ all -> 0x01ba }
        L_0x00ab:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.N> r8 = r7.l     // Catch:{ all -> 0x01ba }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01ba }
            r10 = 0
            r11 = 0
        L_0x00b3:
            boolean r1 = r8.hasNext()     // Catch:{ all -> 0x01ba }
            if (r1 == 0) goto L_0x0152
            java.lang.Object r1 = r8.next()     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.N r1 = (com.ironsource.mediationsdk.N) r1     // Catch:{ all -> 0x01ba }
            boolean r2 = r1.e     // Catch:{ all -> 0x01ba }
            if (r2 == 0) goto L_0x0134
            boolean r2 = r7.r     // Catch:{ all -> 0x01ba }
            if (r2 == 0) goto L_0x0118
            boolean r2 = r1.h()     // Catch:{ all -> 0x01ba }
            if (r2 == 0) goto L_0x0118
            if (r10 != 0) goto L_0x00f0
            if (r11 == 0) goto L_0x00d2
            goto L_0x00f0
        L_0x00d2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = "Advanced Loading: Starting to load bidder "
            r2.<init>(r6)     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = r1.n()     // Catch:{ all -> 0x01ba }
            r2.append(r6)     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = ". No other instances will be loaded at the same time."
            r2.append(r6)     // Catch:{ all -> 0x01ba }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01ba }
            b((java.lang.String) r2)     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r2)     // Catch:{ all -> 0x01ba }
            goto L_0x0118
        L_0x00f0:
            if (r10 == 0) goto L_0x00f5
            java.lang.String r8 = "a non bidder is being loaded"
            goto L_0x00f7
        L_0x00f5:
            java.lang.String r8 = "a non bidder was already loaded successfully"
        L_0x00f7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ba }
            java.lang.String r11 = "Advanced Loading: Won't start loading bidder "
            r9.<init>(r11)     // Catch:{ all -> 0x01ba }
            java.lang.String r11 = r1.n()     // Catch:{ all -> 0x01ba }
            r9.append(r11)     // Catch:{ all -> 0x01ba }
            java.lang.String r11 = " as "
            r9.append(r11)     // Catch:{ all -> 0x01ba }
            r9.append(r8)     // Catch:{ all -> 0x01ba }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x01ba }
            b((java.lang.String) r8)     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r8)     // Catch:{ all -> 0x01ba }
            goto L_0x0152
        L_0x0118:
            r0.add(r1)     // Catch:{ all -> 0x01ba }
            boolean r2 = r7.r     // Catch:{ all -> 0x01ba }
            if (r2 == 0) goto L_0x0152
            boolean r2 = r9.h()     // Catch:{ all -> 0x01ba }
            if (r2 == 0) goto L_0x0152
            boolean r1 = r1.h()     // Catch:{ all -> 0x01ba }
            if (r1 != 0) goto L_0x0152
            int r1 = r0.size()     // Catch:{ all -> 0x01ba }
            int r2 = r7.q     // Catch:{ all -> 0x01ba }
            if (r1 >= r2) goto L_0x0152
            goto L_0x0146
        L_0x0134:
            com.ironsource.mediationsdk.N$a r2 = r1.a     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.N$a r6 = com.ironsource.mediationsdk.N.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x01ba }
            if (r2 == r6) goto L_0x0143
            com.ironsource.mediationsdk.N$a r2 = r1.a     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.N$a r6 = com.ironsource.mediationsdk.N.a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x01ba }
            if (r2 != r6) goto L_0x0141
            goto L_0x0143
        L_0x0141:
            r2 = 0
            goto L_0x0144
        L_0x0143:
            r2 = 1
        L_0x0144:
            if (r2 == 0) goto L_0x0149
        L_0x0146:
            r10 = 1
            goto L_0x00b3
        L_0x0149:
            boolean r1 = r1.g()     // Catch:{ all -> 0x01ba }
            if (r1 == 0) goto L_0x00b3
            r11 = 1
            goto L_0x00b3
        L_0x0152:
            int r8 = r0.size()     // Catch:{ all -> 0x01ba }
            if (r8 != 0) goto L_0x018c
            com.ironsource.mediationsdk.L$a r8 = r7.k     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.L$a r9 = com.ironsource.mediationsdk.L.a.STATE_LOADING_SMASHES     // Catch:{ all -> 0x01ba }
            if (r8 != r9) goto L_0x018c
            if (r10 != 0) goto L_0x018c
            com.ironsource.mediationsdk.q r8 = com.ironsource.mediationsdk.C0227q.a()     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r9 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.logger.IronSourceError r10 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01ba }
            java.lang.String r11 = "No ads to show"
            r1 = 509(0x1fd, float:7.13E-43)
            r10.<init>(r1, r11)     // Catch:{ all -> 0x01ba }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r9, (com.ironsource.mediationsdk.logger.IronSourceError) r10)     // Catch:{ all -> 0x01ba }
            java.lang.Object[][] r8 = new java.lang.Object[r5][]     // Catch:{ all -> 0x01ba }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ba }
            java.lang.String r10 = "errorCode"
            r9[r4] = r10     // Catch:{ all -> 0x01ba }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01ba }
            r9[r5] = r10     // Catch:{ all -> 0x01ba }
            r8[r4] = r9     // Catch:{ all -> 0x01ba }
            r9 = 2110(0x83e, float:2.957E-42)
            r7.a((int) r9, (java.lang.Object[][]) r8)     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.L$a r8 = com.ironsource.mediationsdk.L.a.STATE_READY_TO_LOAD     // Catch:{ all -> 0x01ba }
            r7.a((com.ironsource.mediationsdk.L.a) r8)     // Catch:{ all -> 0x01ba }
        L_0x018c:
            monitor-exit(r7)     // Catch:{ all -> 0x01ba }
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "smashesToLoad.size() = "
            r9.<init>(r10)
            int r10 = r0.size()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.verbose(r9)
            java.util.Iterator r8 = r0.iterator()
        L_0x01a9:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01b9
            java.lang.Object r9 = r8.next()
            com.ironsource.mediationsdk.N r9 = (com.ironsource.mediationsdk.N) r9
            r7.h(r9)
            goto L_0x01a9
        L_0x01b9:
            return
        L_0x01ba:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01ba }
            goto L_0x01be
        L_0x01bd:
            throw r8
        L_0x01be:
            goto L_0x01bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.L.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.mediationsdk.N, long):void");
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        this.e = str;
        this.o = aVar;
        this.f = jSONObject;
        this.x = i2;
        this.y = "";
        if (!TextUtils.isEmpty(str2)) {
            a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}}, false);
        }
        a(jSONObject2, IronSource.AD_UNIT.INTERSTITIAL);
        if (this.a.a(IronSource.AD_UNIT.INTERSTITIAL)) {
            a((int) IronSourceConstants.IS_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}}, false);
            a(a.STATE_READY_TO_LOAD);
            C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
            return;
        }
        a((int) IronSourceConstants.IS_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}}, false);
        a(list);
        h();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Should Track Network State: " + z2, 0);
        this.z = z2;
    }

    public final void b(N n2) {
        synchronized (this) {
            a(n2, "onInterstitialAdClosed");
            b(IronSourceConstants.IS_INSTANCE_CLOSED, n2, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.A.a(IronSource.AD_UNIT.INTERSTITIAL))}});
            this.B.b(IronSource.AD_UNIT.INTERSTITIAL);
            C0231u.a().c(this.c);
            a(a.STATE_READY_TO_LOAD);
        }
    }

    public final void b(IronSourceError ironSourceError, N n2) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_FAILED, n2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
    }

    public final void c(N n2) {
        a(n2, "onInterstitialAdShowSucceeded");
        C0231u.a().d(this.c);
        b(2202, n2);
    }

    public final synchronized void d() {
        if (this.k == a.STATE_SHOWING) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "loadInterstitial: load cannot be invoked while showing an ad", 3);
            C0231u.a().a(new IronSourceError(1037, "loadInterstitial: load cannot be invoked while showing an ad"));
        } else if ((this.k == a.STATE_READY_TO_LOAD || this.k == a.STATE_READY_TO_SHOW) && !C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL)) {
            this.e = "";
            this.p = "";
            this.f = null;
            a(IronSource.AD_UNIT.INTERSTITIAL);
            a_();
            a(2001, (Object[][]) null, false);
            this.w = new Date().getTime();
            if (this.t) {
                if (!this.n.isEmpty()) {
                    this.v.a(this.n);
                    this.n.clear();
                }
                a();
                return;
            }
            f();
            h();
        } else {
            b("loadInterstitial: load is already in progress");
        }
    }

    public final void d(N n2) {
        a(n2, "onInterstitialAdClicked");
        C0231u.a().e(this.c);
        b(2006, n2);
    }

    public final void e(N n2) {
        a(n2, "onInterstitialAdVisible");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean e() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.z     // Catch:{ all -> 0x0039 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0039 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0039 }
            boolean r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r0)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x001a
        L_0x0014:
            com.ironsource.mediationsdk.L$a r0 = r3.k     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.L$a r2 = com.ironsource.mediationsdk.L.a.STATE_READY_TO_SHOW     // Catch:{ all -> 0x0039 }
            if (r0 == r2) goto L_0x001c
        L_0x001a:
            monitor-exit(r3)
            return r1
        L_0x001c:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.N> r0 = r3.l     // Catch:{ all -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0039 }
        L_0x0022:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.N r2 = (com.ironsource.mediationsdk.N) r2     // Catch:{ all -> 0x0039 }
            boolean r2 = r2.g()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0022
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0037:
            monitor-exit(r3)
            return r1
        L_0x0039:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x003d
        L_0x003c:
            throw r0
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.L.e():boolean");
    }

    public final void f(N n2) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_SUCCESS, n2);
    }
}
