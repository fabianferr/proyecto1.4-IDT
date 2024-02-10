package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.a;
import com.ironsource.environment.j;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.B;
import com.ironsource.mediationsdk.C0218h;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.b;
import com.ironsource.mediationsdk.bidding.d;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.m;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class A extends C0225o implements j, C, S, C0212b, C0214d, C0230t {
    private boolean A;
    private long B;
    private Boolean C;
    private C0228r D;
    private final long E;
    long d;
    final ConcurrentHashMap<String, B> e;
    int f = 1;
    a g;
    final Object h = new Object();
    final boolean i;
    private D j;
    private ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> k;
    private ConcurrentHashMap<String, C0218h.a> l;
    private com.ironsource.mediationsdk.adunit.a.a m;
    private C0218h n;
    private C0216f o;
    private JSONObject p;
    private R q;
    private boolean r;
    private String s = "";
    private int t;
    private NetworkStateReceiver u;
    private boolean v = false;
    private m w;
    private String x;
    private int y;
    private boolean z;

    enum a {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public A(List<NetworkSettings> list, q qVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        long time = new Date().getTime();
        a((int) IronSourceConstants.RV_MANAGER_INIT_STARTED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(a.RV_STATE_INITIATING);
        this.C = null;
        this.y = qVar.c;
        this.z = qVar.d;
        this.x = "";
        this.p = null;
        c cVar = qVar.m;
        this.A = false;
        this.j = new D(qVar.m.k, qVar.m.e);
        this.k = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
        this.B = new Date().getTime();
        boolean z2 = cVar.c > 0;
        this.r = z2;
        if (z2) {
            this.o = new C0216f(IronSource.AD_UNIT.REWARDED_VIDEO, cVar, this);
        }
        this.q = new R(cVar, this);
        ConcurrentHashMap<String, B> concurrentHashMap = new ConcurrentHashMap<>();
        this.e = concurrentHashMap;
        a(list, qVar, str, str2);
        this.n = new C0218h(list, cVar.d);
        this.w = new m(new ArrayList(concurrentHashMap.values()));
        this.D = new C0228r(qVar.f, this);
        this.i = qVar.h;
        this.E = qVar.i;
        a((int) IronSourceConstants.RV_MANAGER_INIT_ENDED, a.AnonymousClass1.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}}));
        a(cVar.g);
    }

    private String a(com.ironsource.mediationsdk.adunit.a.a aVar) {
        B b = this.e.get(aVar.a());
        String num = b != null ? Integer.toString(b.l()) : TextUtils.isEmpty(aVar.b()) ? "1" : "2";
        return num + aVar.a();
    }

    private void a(int i2, Map<String, Object> map, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z3 && !TextUtils.isEmpty(this.j.b)) {
            hashMap.put("auctionId", this.j.b);
        }
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.p);
        }
        if (z2 && !TextUtils.isEmpty(this.x)) {
            hashMap.put("placement", this.x);
        }
        if (a(i2)) {
            i.d();
            i.a((Map<String, Object>) hashMap, this.t, this.s);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.f));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        i.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(hashMap)));
    }

    private void a(long j2) {
        if (this.w.a()) {
            a("all smashes are capped");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "all smashes are capped"}}));
            h();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.r) {
            if (!this.l.isEmpty()) {
                this.n.a(this.l);
                this.l.clear();
            }
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    A a2 = A.this;
                    synchronized (a2.h) {
                        if (a2.g != a.RV_STATE_AUCTION_IN_PROGRESS) {
                            a2.a(a.RV_STATE_AUCTION_IN_PROGRESS);
                            AsyncTask.execute(new Runnable() {
                                public final void run() {
                                    A.a("makeAuction()");
                                    A.this.d = new Date().getTime();
                                    HashMap hashMap = new HashMap();
                                    ArrayList arrayList = new ArrayList();
                                    StringBuilder sb = new StringBuilder();
                                    ArrayList arrayList2 = new ArrayList();
                                    A.a(A.this, (Map) hashMap, (List) arrayList, sb, (List) arrayList2);
                                    if (A.this.i) {
                                        A.b(A.this, hashMap, arrayList, sb, arrayList2);
                                    } else {
                                        A.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
                                    }
                                }
                            });
                        }
                    }
                }
            }, j2);
            return;
        }
        a("auction fallback flow starting");
        e();
        if (this.j.a().isEmpty()) {
            a("loadSmashes -  waterfall is empty");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            h();
            return;
        }
        b(1000);
        g();
    }

    static /* synthetic */ void a(A a2, Map map, List list, StringBuilder sb, List list2) {
        StringBuilder sb2;
        for (B next : a2.e.values()) {
            if (!a2.w.b(next) && a2.j.b(next)) {
                if (!next.h()) {
                    list.add(next.n());
                    sb2 = new StringBuilder();
                } else if (a2.i) {
                    list2.add(new com.ironsource.mediationsdk.bidding.a(next.l(), next.n(), (AdData) null, next, (b) null, (NetworkSettings) null));
                } else {
                    Map<String, Object> a3 = next.a((AdData) null);
                    if (a3 != null) {
                        map.put(next.n(), a3);
                        sb2 = new StringBuilder();
                    } else {
                        next.b(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Missing bidding data"}});
                    }
                }
                sb2.append(next.l());
                sb2.append(next.n());
                sb2.append(",");
                sb.append(sb2.toString());
            }
        }
    }

    private static void a(B b, String str) {
        String str2 = b.n() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 0);
    }

    private void a(List<NetworkSettings> list, q qVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (final NetworkSettings next : list) {
            final q qVar2 = qVar;
            final String str3 = str;
            final String str4 = str2;
            arrayList.add(new Runnable() {
                public final void run() {
                    A a2 = A.this;
                    NetworkSettings networkSettings = next;
                    q qVar = qVar2;
                    String str = str3;
                    String str2 = str4;
                    IronLog.INTERNAL.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                    AbstractAdapter a3 = C0213c.a().a(networkSettings, networkSettings.getRewardedVideoSettings(), false, false);
                    if (a3 != null) {
                        B b2 = new B(str, str2, networkSettings, a2, qVar.e, a3, a2.f);
                        a2.e.put(b2.n(), b2);
                    }
                    IronLog.INTERNAL.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                }
            });
        }
        IronSourceThreadManager.INSTANCE.executeTasks(qVar.j, qVar.k, arrayList);
    }

    private void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, JSONObject jSONObject) {
        this.k.clear();
        this.l.clear();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        StringBuilder sb = new StringBuilder();
        for (com.ironsource.mediationsdk.adunit.a.a next : list) {
            sb.append(a(next) + ",");
            B b = this.e.get(next.a());
            if (b != null) {
                AbstractAdapter a2 = C0213c.a().a(b.d.a);
                if (a2 != null) {
                    B b2 = new B(b, this, a2, this.f, str, jSONObject, this.t, this.s);
                    b2.e = true;
                    copyOnWriteArrayList.add(b2);
                    this.k.put(b2.n(), next);
                    this.l.put(next.a(), C0218h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                a("updateWaterfall() - could not find matching smash for auction response item " + next.a());
            }
        }
        this.j.a((CopyOnWriteArrayList<B>) copyOnWriteArrayList, str);
        if (this.j.b()) {
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfalls hold too many with size=" + this.j.a.size()}}));
        }
        a("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            a("Updated waterfall is empty");
        }
        b((int) IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            b((int) IronSourceConstants.RV_AUCTION_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}}));
            a("makeAuction() failed - No candidates available for auctioning");
            h();
            return;
        }
        a("makeAuction() - request waterfall is: " + str);
        b(1000);
        b((int) IronSourceConstants.RV_AUCTION_REQUEST);
        a((int) IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
        this.o.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.n, this.f, this.b);
    }

    private void a(boolean z2, Map<String, Object> map) {
        synchronized (this.h) {
            Boolean bool = this.C;
            if (bool == null || bool.booleanValue() != z2) {
                this.C = Boolean.valueOf(z2);
                long time = new Date().getTime() - this.B;
                this.B = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(time));
                b(z2 ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                P a2 = P.a();
                D d2 = this.j;
                a2.a(z2, d2.a(d2.b));
            }
        }
    }

    private static boolean a(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301 || i2 == 1303;
    }

    private void b(int i2) {
        a(i2, (Map<String, Object>) null, false, false);
    }

    private void b(int i2, Map<String, Object> map) {
        a(i2, map, false, true);
    }

    static /* synthetic */ void b(A a2, final Map map, final List list, final StringBuilder sb, List list2) {
        if (list2.isEmpty()) {
            a2.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            return;
        }
        d dVar = new d();
        AnonymousClass4 r2 = new d.a() {
            public final void a(String str) {
                A.this.a((int) IronSourceConstants.RV_COLLECT_TOKENS_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}}));
                A.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }

            public final void a(List<com.ironsource.mediationsdk.utils.j> list, long j, List<String> list2) {
                A.this.a((int) IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, a.AnonymousClass1.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
                for (com.ironsource.mediationsdk.utils.j next : list) {
                    B b2 = A.this.e.get(next.b());
                    if (next.c() != null) {
                        map.put(next.b(), next.c());
                        StringBuilder sb = sb;
                        sb.append(next.a());
                        sb.append(next.b());
                        sb.append(",");
                        if (b2 != null) {
                            b2.b(1021, new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}});
                        }
                    } else if (b2 != null) {
                        b2.b(1022, new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, next.e()}});
                    }
                }
                for (String str : list2) {
                    B b3 = A.this.e.get(str);
                    if (b3 != null) {
                        b3.b(1023, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                    }
                }
                A.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }
        };
        a2.b((int) IronSourceConstants.RV_COLLECT_TOKENS);
        dVar.a((List<com.ironsource.mediationsdk.bidding.a>) list2, (d.a) r2, a2.E, TimeUnit.MILLISECONDS);
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 3);
    }

    private void c(int i2, Map<String, Object> map) {
        a(i2, map, true, true);
    }

    private static void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void e() {
        List<com.ironsource.mediationsdk.adunit.a.a> f2 = f();
        a(f2, "fallback_" + System.currentTimeMillis(), this.p);
    }

    private List<com.ironsource.mediationsdk.adunit.a.a> f() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (B next : this.e.values()) {
            if (!next.h() && !this.w.b(next) && this.j.b(next)) {
                copyOnWriteArrayList.add(new com.ironsource.mediationsdk.adunit.a.a(next.n()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g() {
        if (this.j.a().isEmpty()) {
            a("loadSmashes -  waterfall is empty");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            h();
            return;
        }
        a(a.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.j.a().size() && i2 < this.y; i3++) {
            B b = this.j.a().get(i3);
            if (b.e) {
                if (!this.z || !b.h()) {
                    g(b);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + b.n() + ". No other instances will be loaded at the same time.";
                    a(str);
                    IronSourceUtils.sendAutomationLog(str);
                    g(b);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + b.n() + " as a non bidder is being loaded";
                    a(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    private void g(B b) {
        String b2 = this.k.get(b.n()).b();
        JSONObject c = this.k.get(b.n()).c();
        b.a(b2);
        b.a(b2, c);
    }

    private void h() {
        a(a.RV_STATE_NOT_LOADED);
        if (!this.A) {
            a(false, (Map<String, Object>) null);
        }
        this.q.c();
    }

    public final void a() {
        a(a.RV_STATE_NOT_LOADED);
        a(false, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        a(0);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        Map<String, Object> map;
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        a(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.t = i3;
        this.s = str2;
        this.p = null;
        e();
        if (TextUtils.isEmpty(str)) {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(j2)}});
        } else {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{"duration", Long.valueOf(j2)}});
        }
        b((int) IronSourceConstants.RV_AUCTION_FAILED, map);
        g();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Map<String, Object> map) {
        a(i2, map, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0213, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0215, code lost:
        a("showVideo()");
        r9.w.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0225, code lost:
        if (r9.w.b(r6) == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0227, code lost:
        r6.a((int) com.ironsource.mediationsdk.utils.IronSourceConstants.RV_CAP_SESSION);
        com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r6.n() + " rewarded video is now session capped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0244, code lost:
        com.ironsource.mediationsdk.utils.j.e(com.ironsource.environment.ContextProvider.getInstance().getApplicationContext(), r11.getPlacementName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0263, code lost:
        if (com.ironsource.mediationsdk.utils.j.c(com.ironsource.environment.ContextProvider.getInstance().getApplicationContext(), r11.getPlacementName()) == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0265, code lost:
        a((int) com.ironsource.mediationsdk.utils.IronSourceConstants.RV_CAP_PLACEMENT, (java.util.Map<java.lang.String, java.lang.Object>) null, true, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x026a, code lost:
        r9.D.a();
        r6.a(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r10, com.ironsource.mediationsdk.model.Placement r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.h
            monitor-enter(r0)
            r1 = 1113(0x459, float:1.56E-42)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r11 != 0) goto L_0x0048
            java.lang.String r10 = "showRewardedVideo error: empty default placement"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0273 }
            r5 = 1021(0x3fd, float:1.431E-42)
            r11.<init>(r5, r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.P r6 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r7 = r9.j     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = r7.b     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r7 = r7.a((java.lang.String) r8)     // Catch:{ all -> 0x0273 }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r7)     // Catch:{ all -> 0x0273 }
            java.lang.Object[][] r11 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0273 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0273 }
            r6[r4] = r5     // Catch:{ all -> 0x0273 }
            r11[r3] = r6     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = "reason"
            r2[r3] = r5     // Catch:{ all -> 0x0273 }
            r2[r4] = r10     // Catch:{ all -> 0x0273 }
            r11[r4] = r2     // Catch:{ all -> 0x0273 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r11)     // Catch:{ all -> 0x0273 }
            r9.a((int) r1, (java.util.Map<java.lang.String, java.lang.Object>) r10, (boolean) r3, (boolean) r4)     // Catch:{ all -> 0x0273 }
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            return
        L_0x0048:
            java.lang.String r5 = r11.getPlacementName()     // Catch:{ all -> 0x0273 }
            r9.x = r5     // Catch:{ all -> 0x0273 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0273 }
            java.lang.String r6 = "showRewardedVideo("
            r5.<init>(r6)     // Catch:{ all -> 0x0273 }
            r5.append(r11)     // Catch:{ all -> 0x0273 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0273 }
            r6.log(r7, r5, r3)     // Catch:{ all -> 0x0273 }
            r5 = 0
            if (r10 == 0) goto L_0x0080
            java.lang.Object[][] r10 = new java.lang.Object[r4][]     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "ext1"
            r6[r3] = r7     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "init_context_flow"
            r6[r4] = r7     // Catch:{ all -> 0x0273 }
            r10[r3] = r6     // Catch:{ all -> 0x0273 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r10)     // Catch:{ all -> 0x0273 }
            goto L_0x0081
        L_0x0080:
            r10 = r5
        L_0x0081:
            r6 = 1100(0x44c, float:1.541E-42)
            r9.c(r6, r10)     // Catch:{ all -> 0x0273 }
            boolean r10 = r9.A     // Catch:{ all -> 0x0273 }
            if (r10 == 0) goto L_0x00c8
            java.lang.String r10 = "showRewardedVideo error: can't show ad while an ad is already showing"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0273 }
            r5 = 1022(0x3fe, float:1.432E-42)
            r11.<init>(r5, r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.P r6 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r7 = r9.j     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = r7.b     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r7 = r7.a((java.lang.String) r8)     // Catch:{ all -> 0x0273 }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r7)     // Catch:{ all -> 0x0273 }
            java.lang.Object[][] r11 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0273 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0273 }
            r6[r4] = r5     // Catch:{ all -> 0x0273 }
            r11[r3] = r6     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = "reason"
            r2[r3] = r5     // Catch:{ all -> 0x0273 }
            r2[r4] = r10     // Catch:{ all -> 0x0273 }
            r11[r4] = r2     // Catch:{ all -> 0x0273 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r11)     // Catch:{ all -> 0x0273 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0273 }
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            return
        L_0x00c8:
            com.ironsource.mediationsdk.A$a r10 = r9.g     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.A$a r6 = com.ironsource.mediationsdk.A.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0273 }
            if (r10 == r6) goto L_0x010c
            java.lang.String r10 = "showRewardedVideo error: show called while no ads are available"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0273 }
            r5 = 1023(0x3ff, float:1.434E-42)
            r11.<init>(r5, r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.P r6 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r7 = r9.j     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = r7.b     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r7 = r7.a((java.lang.String) r8)     // Catch:{ all -> 0x0273 }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r7)     // Catch:{ all -> 0x0273 }
            java.lang.Object[][] r11 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0273 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0273 }
            r6[r4] = r5     // Catch:{ all -> 0x0273 }
            r11[r3] = r6     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = "reason"
            r2[r3] = r5     // Catch:{ all -> 0x0273 }
            r2[r4] = r10     // Catch:{ all -> 0x0273 }
            r11[r4] = r2     // Catch:{ all -> 0x0273 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r11)     // Catch:{ all -> 0x0273 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0273 }
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            return
        L_0x010c:
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0273 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x0273 }
            java.lang.String r6 = r9.x     // Catch:{ all -> 0x0273 }
            boolean r10 = com.ironsource.mediationsdk.utils.j.c(r10, r6)     // Catch:{ all -> 0x0273 }
            if (r10 == 0) goto L_0x016d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0273 }
            java.lang.String r11 = "showRewardedVideo error: placement "
            r10.<init>(r11)     // Catch:{ all -> 0x0273 }
            java.lang.String r11 = r9.x     // Catch:{ all -> 0x0273 }
            r10.append(r11)     // Catch:{ all -> 0x0273 }
            java.lang.String r11 = " is capped"
            r10.append(r11)     // Catch:{ all -> 0x0273 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0273 }
            c((java.lang.String) r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0273 }
            r5 = 524(0x20c, float:7.34E-43)
            r11.<init>(r5, r10)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.P r6 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r7 = r9.j     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = r7.b     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r7 = r7.a((java.lang.String) r8)     // Catch:{ all -> 0x0273 }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r11, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r7)     // Catch:{ all -> 0x0273 }
            java.lang.Object[][] r11 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0273 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0273 }
            r6[r4] = r5     // Catch:{ all -> 0x0273 }
            r11[r3] = r6     // Catch:{ all -> 0x0273 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = "reason"
            r2[r3] = r5     // Catch:{ all -> 0x0273 }
            r2[r4] = r10     // Catch:{ all -> 0x0273 }
            r11[r4] = r2     // Catch:{ all -> 0x0273 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r11)     // Catch:{ all -> 0x0273 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0273 }
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            return
        L_0x016d:
            java.lang.StringBuffer r10 = new java.lang.StringBuffer     // Catch:{ all -> 0x0273 }
            r10.<init>()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r2 = r9.j     // Catch:{ all -> 0x0273 }
            java.util.concurrent.CopyOnWriteArrayList r2 = r2.a()     // Catch:{ all -> 0x0273 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0273 }
        L_0x017c:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0273 }
            if (r6 == 0) goto L_0x01c7
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.B r6 = (com.ironsource.mediationsdk.B) r6     // Catch:{ all -> 0x0273 }
            boolean r7 = r6.a()     // Catch:{ all -> 0x0273 }
            if (r7 == 0) goto L_0x0199
            r9.A = r4     // Catch:{ all -> 0x0273 }
            r6.a((boolean) r4)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.A$a r2 = com.ironsource.mediationsdk.A.a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x0273 }
            r9.a((com.ironsource.mediationsdk.A.a) r2)     // Catch:{ all -> 0x0273 }
            goto L_0x01c8
        L_0x0199:
            java.lang.Long r7 = r6.r()     // Catch:{ all -> 0x0273 }
            if (r7 == 0) goto L_0x01c3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0273 }
            r7.<init>()     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = r6.n()     // Catch:{ all -> 0x0273 }
            r7.append(r8)     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = ":"
            r7.append(r8)     // Catch:{ all -> 0x0273 }
            java.lang.Long r8 = r6.r()     // Catch:{ all -> 0x0273 }
            r7.append(r8)     // Catch:{ all -> 0x0273 }
            java.lang.String r8 = ","
            r7.append(r8)     // Catch:{ all -> 0x0273 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0273 }
            r10.append(r7)     // Catch:{ all -> 0x0273 }
        L_0x01c3:
            r6.a((boolean) r3)     // Catch:{ all -> 0x0273 }
            goto L_0x017c
        L_0x01c7:
            r6 = r5
        L_0x01c8:
            if (r6 != 0) goto L_0x0212
            java.lang.String r11 = "showRewardedVideo(): No ads to show"
            a((java.lang.String) r11)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.P r2 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x0273 }
            java.lang.String r3 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r3 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r3)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.D r4 = r9.j     // Catch:{ all -> 0x0273 }
            java.lang.String r5 = r4.b     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo r4 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0273 }
            r2.a((com.ironsource.mediationsdk.logger.IronSourceError) r3, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r4)     // Catch:{ all -> 0x0273 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0273 }
            r2.<init>()     // Catch:{ all -> 0x0273 }
            java.lang.String r3 = "errorCode"
            r4 = 509(0x1fd, float:7.13E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0273 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0273 }
            java.lang.String r3 = "reason"
            r2.put(r3, r11)     // Catch:{ all -> 0x0273 }
            int r11 = r10.length()     // Catch:{ all -> 0x0273 }
            if (r11 == 0) goto L_0x0208
            java.lang.String r11 = "ext1"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0273 }
            r2.put(r11, r10)     // Catch:{ all -> 0x0273 }
        L_0x0208:
            r9.c(r1, r2)     // Catch:{ all -> 0x0273 }
            com.ironsource.mediationsdk.R r10 = r9.q     // Catch:{ all -> 0x0273 }
            r10.b()     // Catch:{ all -> 0x0273 }
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            return
        L_0x0212:
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            if (r6 == 0) goto L_0x0272
            java.lang.String r10 = "showVideo()"
            a((java.lang.String) r10)
            com.ironsource.mediationsdk.utils.m r10 = r9.w
            r10.a(r6)
            com.ironsource.mediationsdk.utils.m r10 = r9.w
            boolean r10 = r10.b(r6)
            if (r10 == 0) goto L_0x0244
            r10 = 1401(0x579, float:1.963E-42)
            r6.a((int) r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = r6.n()
            r10.append(r0)
            java.lang.String r0 = " rewarded video is now session capped"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r10)
        L_0x0244:
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.String r0 = r11.getPlacementName()
            com.ironsource.mediationsdk.utils.j.e(r10, r0)
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.String r0 = r11.getPlacementName()
            boolean r10 = com.ironsource.mediationsdk.utils.j.c(r10, r0)
            if (r10 == 0) goto L_0x026a
            r10 = 1400(0x578, float:1.962E-42)
            r9.a((int) r10, (java.util.Map<java.lang.String, java.lang.Object>) r5, (boolean) r4, (boolean) r4)
        L_0x026a:
            com.ironsource.mediationsdk.r r10 = r9.D
            r10.a()
            r6.a((com.ironsource.mediationsdk.model.Placement) r11)
        L_0x0272:
            return
        L_0x0273:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0273 }
            goto L_0x0277
        L_0x0276:
            throw r10
        L_0x0277:
            goto L_0x0276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.A.a(android.app.Activity, com.ironsource.mediationsdk.model.Placement):void");
    }

    public final void a(Context context, boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager Should Track Network State: " + z2, 0);
        try {
            this.v = z2;
            if (z2) {
                if (this.u == null) {
                    this.u = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.u, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.u != null) {
                context.getApplicationContext().unregisterReceiver(this.u);
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        a("current state=" + this.g + ", new state=" + aVar);
        this.g = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x011c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.B r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.h
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r2 = "onLoadSuccess mState="
            r1.<init>(r2)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r2 = r12.g     // Catch:{ all -> 0x016e }
            r1.append(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x016e }
            a((com.ironsource.mediationsdk.B) r13, (java.lang.String) r1)     // Catch:{ all -> 0x016e }
            java.lang.String r1 = r13.b     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.D r2 = r12.j     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x016e }
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x011d
            com.ironsource.mediationsdk.A$a r1 = r12.g     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r2 = com.ironsource.mediationsdk.A.a.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x016e }
            if (r1 != r2) goto L_0x0029
            goto L_0x011d
        L_0x0029:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r1 = r12.l     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r13.n()     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.h$a r6 = com.ironsource.mediationsdk.C0218h.a.ISAuctionPerformanceLoadedSuccessfully     // Catch:{ all -> 0x016e }
            r1.put(r2, r6)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r1 = r12.g     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r2 = com.ironsource.mediationsdk.A.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x016e }
            if (r1 != r2) goto L_0x011b
            com.ironsource.mediationsdk.A$a r1 = com.ironsource.mediationsdk.A.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x016e }
            r12.a((com.ironsource.mediationsdk.A.a) r1)     // Catch:{ all -> 0x016e }
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x016e }
            r1.<init>()     // Catch:{ all -> 0x016e }
            long r1 = r1.getTime()     // Catch:{ all -> 0x016e }
            long r6 = r12.d     // Catch:{ all -> 0x016e }
            long r1 = r1 - r6
            java.lang.Object[][] r6 = new java.lang.Object[r5][]     // Catch:{ all -> 0x016e }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r8 = "duration"
            r7[r3] = r8     // Catch:{ all -> 0x016e }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x016e }
            r7[r5] = r1     // Catch:{ all -> 0x016e }
            r6[r3] = r7     // Catch:{ all -> 0x016e }
            java.util.Map r1 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r6)     // Catch:{ all -> 0x016e }
            r2 = 1003(0x3eb, float:1.406E-42)
            r12.b((int) r2, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.r r1 = r12.D     // Catch:{ all -> 0x016e }
            r6 = 0
            r1.a(r6)     // Catch:{ all -> 0x016e }
            boolean r1 = r12.r     // Catch:{ all -> 0x016e }
            if (r1 == 0) goto L_0x0117
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r1 = r12.k     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r13.n()     // Catch:{ all -> 0x016e }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x016e }
            r11 = r1
            com.ironsource.mediationsdk.adunit.a.a r11 = (com.ironsource.mediationsdk.adunit.a.a) r11     // Catch:{ all -> 0x016e }
            if (r11 == 0) goto L_0x00ab
            com.ironsource.mediationsdk.D r1 = r12.j     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r1.b     // Catch:{ all -> 0x016e }
            java.lang.String r3 = ""
            com.ironsource.mediationsdk.impressionData.ImpressionData r3 = r11.a((java.lang.String) r3)     // Catch:{ all -> 0x016e }
            r1.a((java.lang.String) r2, (com.ironsource.mediationsdk.impressionData.ImpressionData) r3)     // Catch:{ all -> 0x016e }
            int r1 = r13.l()     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.adunit.a.a r2 = r12.m     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.C0216f.a((com.ironsource.mediationsdk.adunit.a.a) r11, (int) r1, (com.ironsource.mediationsdk.adunit.a.a) r2)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.f r6 = r12.o     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.D r1 = r12.j     // Catch:{ all -> 0x016e }
            java.util.concurrent.CopyOnWriteArrayList r7 = r1.a()     // Catch:{ all -> 0x016e }
            r1 = r7
            java.util.concurrent.CopyOnWriteArrayList r1 = (java.util.concurrent.CopyOnWriteArrayList) r1     // Catch:{ all -> 0x016e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r8 = r12.k     // Catch:{ all -> 0x016e }
            int r9 = r13.l()     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.adunit.a.a r10 = r12.m     // Catch:{ all -> 0x016e }
            r6.a((java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.O>) r7, (java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a>) r8, (int) r9, (com.ironsource.mediationsdk.adunit.a.a) r10, (com.ironsource.mediationsdk.adunit.a.a) r11)     // Catch:{ all -> 0x016e }
            goto L_0x0117
        L_0x00ab:
            java.lang.String r1 = r13.n()     // Catch:{ all -> 0x016e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "onLoadSuccess winner instance "
            r2.<init>(r6)     // Catch:{ all -> 0x016e }
            r2.append(r1)     // Catch:{ all -> 0x016e }
            java.lang.String r6 = " missing from waterfall. auctionId: "
            r2.append(r6)     // Catch:{ all -> 0x016e }
            java.lang.String r13 = r13.b     // Catch:{ all -> 0x016e }
            r2.append(r13)     // Catch:{ all -> 0x016e }
            java.lang.String r13 = " and the current id is "
            r2.append(r13)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.D r13 = r12.j     // Catch:{ all -> 0x016e }
            java.lang.String r13 = r13.b     // Catch:{ all -> 0x016e }
            r2.append(r13)     // Catch:{ all -> 0x016e }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x016e }
            b((java.lang.String) r13)     // Catch:{ all -> 0x016e }
            r13 = 3
            java.lang.Object[][] r13 = new java.lang.Object[r13][]     // Catch:{ all -> 0x016e }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "errorCode"
            r2[r3] = r6     // Catch:{ all -> 0x016e }
            r6 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x016e }
            r2[r5] = r6     // Catch:{ all -> 0x016e }
            r13[r3] = r2     // Catch:{ all -> 0x016e }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "reason"
            r2[r3] = r6     // Catch:{ all -> 0x016e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r7 = "Loaded missing "
            r6.<init>(r7)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r7 = com.ironsource.mediationsdk.A.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x016e }
            r6.append(r7)     // Catch:{ all -> 0x016e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x016e }
            r2[r5] = r6     // Catch:{ all -> 0x016e }
            r13[r5] = r2     // Catch:{ all -> 0x016e }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "ext1"
            r2[r3] = r6     // Catch:{ all -> 0x016e }
            r2[r5] = r1     // Catch:{ all -> 0x016e }
            r13[r4] = r2     // Catch:{ all -> 0x016e }
            java.util.Map r13 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r13)     // Catch:{ all -> 0x016e }
            r1 = 81317(0x13da5, float:1.1395E-40)
            r12.b((int) r1, (java.util.Map<java.lang.String, java.lang.Object>) r13)     // Catch:{ all -> 0x016e }
        L_0x0117:
            r13 = 0
            r12.a((boolean) r5, (java.util.Map<java.lang.String, java.lang.Object>) r13)     // Catch:{ all -> 0x016e }
        L_0x011b:
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return
        L_0x011d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r2 = "onLoadSuccess was invoked with auctionId: "
            r1.<init>(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r13.b     // Catch:{ all -> 0x016e }
            r1.append(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r2 = " and the current id is "
            r1.append(r2)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.D r2 = r12.j     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x016e }
            r1.append(r2)     // Catch:{ all -> 0x016e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x016e }
            a((java.lang.String) r1)     // Catch:{ all -> 0x016e }
            java.lang.Object[][] r1 = new java.lang.Object[r4][]     // Catch:{ all -> 0x016e }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r6 = "errorCode"
            r2[r3] = r6     // Catch:{ all -> 0x016e }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x016e }
            r2[r5] = r6     // Catch:{ all -> 0x016e }
            r1[r3] = r2     // Catch:{ all -> 0x016e }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            java.lang.String r4 = "reason"
            r2[r3] = r4     // Catch:{ all -> 0x016e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x016e }
            java.lang.String r4 = "onLoadSuccess wrong auction ID "
            r3.<init>(r4)     // Catch:{ all -> 0x016e }
            com.ironsource.mediationsdk.A$a r4 = r12.g     // Catch:{ all -> 0x016e }
            r3.append(r4)     // Catch:{ all -> 0x016e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x016e }
            r2[r5] = r3     // Catch:{ all -> 0x016e }
            r1[r5] = r2     // Catch:{ all -> 0x016e }
            r2 = 81315(0x13da3, float:1.13947E-40)
            r13.b(r2, r1)     // Catch:{ all -> 0x016e }
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return
        L_0x016e:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.A.a(com.ironsource.mediationsdk.B):void");
    }

    public final void a(B b, Placement placement) {
        a(b, "onRewardedVideoAdRewarded");
        P.a().a(placement, this.j.a(b.b));
    }

    public final void a(IronSourceError ironSourceError, B b) {
        com.ironsource.mediationsdk.adunit.a.a aVar;
        if (this.r && (aVar = this.k.get(b.n())) != null) {
            D d2 = this.j;
            d2.a(d2.b, aVar.a(this.x));
        }
        a(b, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.A = false;
        c(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}}));
        P.a().a(ironSourceError, this.j.a(b.b));
        this.l.put(b.n(), C0218h.a.ISAuctionPerformanceFailedToShow);
        if (this.g != a.RV_STATE_READY_TO_SHOW) {
            a(false, (Map<String, Object>) null);
        }
        this.q.b();
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        a("makeAuction(): success");
        this.m = aVar;
        this.t = i2;
        this.p = jSONObject;
        this.s = "";
        if (!TextUtils.isEmpty(str2)) {
            b((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}}));
        }
        a(jSONObject2, IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.a.a(IronSource.AD_UNIT.REWARDED_VIDEO)) {
            b((int) IronSourceConstants.RV_AD_UNIT_CAPPED, a.AnonymousClass1.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
            return;
        }
        a(list, str, this.p);
        b((int) IronSourceConstants.RV_AUCTION_SUCCESS, a.AnonymousClass1.a(new Object[][]{new Object[]{"duration", Long.valueOf(j2)}}));
        g();
    }

    public final void a(boolean z2) {
        if (this.v) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            boolean z3 = false;
            logger.log(ironSourceTag, "Network Availability Changed To: " + z2, 0);
            Boolean bool = this.C;
            if (bool != null && ((z2 && !bool.booleanValue() && b()) || (!z2 && this.C.booleanValue()))) {
                z3 = true;
            }
            if (z3) {
                a(z2, (Map<String, Object>) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0148, code lost:
        r12 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0150, code lost:
        if (r12.hasNext() == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0152, code lost:
        g((com.ironsource.mediationsdk.B) r12.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.ironsource.mediationsdk.B r12) {
        /*
            r11 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            java.lang.Object r1 = r11.h
            monitor-enter(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "onLoadError mState="
            r2.<init>(r3)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r3 = r11.g     // Catch:{ all -> 0x01af }
            r2.append(r3)     // Catch:{ all -> 0x01af }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01af }
            a((com.ironsource.mediationsdk.B) r12, (java.lang.String) r2)     // Catch:{ all -> 0x01af }
            java.lang.String r2 = r12.b     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.D r3 = r11.j     // Catch:{ all -> 0x01af }
            java.lang.String r3 = r3.b     // Catch:{ all -> 0x01af }
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 != r3) goto L_0x015d
            com.ironsource.mediationsdk.A$a r2 = r11.g     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r3 = com.ironsource.mediationsdk.A.a.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x01af }
            if (r2 != r3) goto L_0x002e
            goto L_0x015d
        L_0x002e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r2 = r11.l     // Catch:{ all -> 0x01af }
            java.lang.String r3 = r12.n()     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.h$a r7 = com.ironsource.mediationsdk.C0218h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x01af }
            r2.put(r3, r7)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r2 = r11.g     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r3 = com.ironsource.mediationsdk.A.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x01af }
            if (r2 == r3) goto L_0x0047
            com.ironsource.mediationsdk.A$a r2 = r11.g     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r3 = com.ironsource.mediationsdk.A.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x01af }
            if (r2 == r3) goto L_0x0047
            monitor-exit(r1)     // Catch:{ all -> 0x01af }
            return
        L_0x0047:
            com.ironsource.mediationsdk.D r2 = r11.j     // Catch:{ all -> 0x01af }
            java.util.concurrent.CopyOnWriteArrayList r2 = r2.a()     // Catch:{ all -> 0x01af }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x01af }
            r3 = 0
            r7 = 0
        L_0x0053:
            boolean r8 = r2.hasNext()     // Catch:{ all -> 0x01af }
            if (r8 == 0) goto L_0x00fe
            java.lang.Object r8 = r2.next()     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.B r8 = (com.ironsource.mediationsdk.B) r8     // Catch:{ all -> 0x01af }
            boolean r9 = r8.e     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x00e0
            boolean r9 = r11.z     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x00b8
            boolean r9 = r8.h()     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x00b8
            if (r3 != 0) goto L_0x0090
            if (r7 == 0) goto L_0x0072
            goto L_0x0090
        L_0x0072:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            java.lang.String r10 = "Advanced Loading: Starting to load bidder "
            r9.<init>(r10)     // Catch:{ all -> 0x01af }
            java.lang.String r10 = r8.n()     // Catch:{ all -> 0x01af }
            r9.append(r10)     // Catch:{ all -> 0x01af }
            java.lang.String r10 = ". No other instances will be loaded at the same time."
            r9.append(r10)     // Catch:{ all -> 0x01af }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01af }
            a((java.lang.String) r9)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r9)     // Catch:{ all -> 0x01af }
            goto L_0x00b8
        L_0x0090:
            if (r3 == 0) goto L_0x0095
            java.lang.String r12 = "a non bidder is being loaded"
            goto L_0x0097
        L_0x0095:
            java.lang.String r12 = "a non bidder was already loaded successfully"
        L_0x0097:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            java.lang.String r9 = "Advanced Loading: Won't start loading bidder "
            r2.<init>(r9)     // Catch:{ all -> 0x01af }
            java.lang.String r8 = r8.n()     // Catch:{ all -> 0x01af }
            r2.append(r8)     // Catch:{ all -> 0x01af }
            java.lang.String r8 = " as "
            r2.append(r8)     // Catch:{ all -> 0x01af }
            r2.append(r12)     // Catch:{ all -> 0x01af }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01af }
            a((java.lang.String) r12)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r12)     // Catch:{ all -> 0x01af }
            goto L_0x00fe
        L_0x00b8:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r9 = r11.k     // Catch:{ all -> 0x01af }
            java.lang.String r10 = r8.n()     // Catch:{ all -> 0x01af }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x0053
            r0.add(r8)     // Catch:{ all -> 0x01af }
            boolean r9 = r11.z     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x00fe
            boolean r9 = r12.h()     // Catch:{ all -> 0x01af }
            if (r9 == 0) goto L_0x00fe
            boolean r8 = r8.h()     // Catch:{ all -> 0x01af }
            if (r8 != 0) goto L_0x00fe
            int r8 = r0.size()     // Catch:{ all -> 0x01af }
            int r9 = r11.y     // Catch:{ all -> 0x01af }
            if (r8 >= r9) goto L_0x00fe
            goto L_0x00f2
        L_0x00e0:
            com.ironsource.mediationsdk.B$a r9 = r8.a     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.B$a r10 = com.ironsource.mediationsdk.B.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x01af }
            if (r9 == r10) goto L_0x00ef
            com.ironsource.mediationsdk.B$a r9 = r8.a     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.B$a r10 = com.ironsource.mediationsdk.B.a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x01af }
            if (r9 != r10) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            r9 = 0
            goto L_0x00f0
        L_0x00ef:
            r9 = 1
        L_0x00f0:
            if (r9 == 0) goto L_0x00f5
        L_0x00f2:
            r3 = 1
            goto L_0x0053
        L_0x00f5:
            boolean r8 = r8.a()     // Catch:{ all -> 0x01af }
            if (r8 == 0) goto L_0x0053
            r7 = 1
            goto L_0x0053
        L_0x00fe:
            int r12 = r0.size()     // Catch:{ all -> 0x01af }
            if (r12 != 0) goto L_0x0147
            if (r7 != 0) goto L_0x0147
            if (r3 != 0) goto L_0x0147
            java.lang.String r12 = "onLoadError(): No other available smashes"
            a((java.lang.String) r12)     // Catch:{ all -> 0x01af }
            boolean r12 = r11.A     // Catch:{ all -> 0x01af }
            if (r12 != 0) goto L_0x0115
            r12 = 0
            r11.a((boolean) r6, (java.util.Map<java.lang.String, java.lang.Object>) r12)     // Catch:{ all -> 0x01af }
        L_0x0115:
            java.lang.Object[][] r12 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01af }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "errorCode"
            r2[r6] = r3     // Catch:{ all -> 0x01af }
            r3 = 509(0x1fd, float:7.13E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01af }
            r2[r5] = r3     // Catch:{ all -> 0x01af }
            r12[r6] = r2     // Catch:{ all -> 0x01af }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "reason"
            r2[r6] = r3     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "Mediation No fill"
            r2[r5] = r3     // Catch:{ all -> 0x01af }
            r12[r5] = r2     // Catch:{ all -> 0x01af }
            java.util.Map r12 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r12)     // Catch:{ all -> 0x01af }
            r2 = 81001(0x13c69, float:1.13507E-40)
            r11.b((int) r2, (java.util.Map<java.lang.String, java.lang.Object>) r12)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r12 = com.ironsource.mediationsdk.A.a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x01af }
            r11.a((com.ironsource.mediationsdk.A.a) r12)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.R r12 = r11.q     // Catch:{ all -> 0x01af }
            r12.c()     // Catch:{ all -> 0x01af }
        L_0x0147:
            monitor-exit(r1)     // Catch:{ all -> 0x01af }
            java.util.Iterator r12 = r0.iterator()
        L_0x014c:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x015c
            java.lang.Object r0 = r12.next()
            com.ironsource.mediationsdk.B r0 = (com.ironsource.mediationsdk.B) r0
            r11.g(r0)
            goto L_0x014c
        L_0x015c:
            return
        L_0x015d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            java.lang.String r2 = "onLoadError was invoked with auctionId:"
            r0.<init>(r2)     // Catch:{ all -> 0x01af }
            java.lang.String r2 = r12.b     // Catch:{ all -> 0x01af }
            r0.append(r2)     // Catch:{ all -> 0x01af }
            java.lang.String r2 = " and the current id is "
            r0.append(r2)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.D r2 = r11.j     // Catch:{ all -> 0x01af }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x01af }
            r0.append(r2)     // Catch:{ all -> 0x01af }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01af }
            a((java.lang.String) r0)     // Catch:{ all -> 0x01af }
            java.lang.Object[][] r0 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01af }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "errorCode"
            r2[r6] = r3     // Catch:{ all -> 0x01af }
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01af }
            r2[r5] = r3     // Catch:{ all -> 0x01af }
            r0[r6] = r2     // Catch:{ all -> 0x01af }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x01af }
            java.lang.String r3 = "reason"
            r2[r6] = r3     // Catch:{ all -> 0x01af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            java.lang.String r4 = "loadError wrong auction ID "
            r3.<init>(r4)     // Catch:{ all -> 0x01af }
            com.ironsource.mediationsdk.A$a r4 = r11.g     // Catch:{ all -> 0x01af }
            r3.append(r4)     // Catch:{ all -> 0x01af }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01af }
            r2[r5] = r3     // Catch:{ all -> 0x01af }
            r0[r5] = r2     // Catch:{ all -> 0x01af }
            r2 = 81315(0x13da3, float:1.13947E-40)
            r12.b(r2, r0)     // Catch:{ all -> 0x01af }
            monitor-exit(r1)     // Catch:{ all -> 0x01af }
            return
        L_0x01af:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01af }
            goto L_0x01b3
        L_0x01b2:
            throw r12
        L_0x01b3:
            goto L_0x01b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.A.b(com.ironsource.mediationsdk.B):void");
    }

    public final void b(B b, Placement placement) {
        a(b, "onRewardedVideoAdClicked");
        P.a().b(placement, this.j.a(b.b));
    }

    public final boolean b() {
        if ((!this.v || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.g == a.RV_STATE_READY_TO_SHOW && !this.A) {
            Iterator<B> it = this.j.a().iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c(B b) {
        this.j.a(b);
        this.f++;
        a(b, "onRewardedVideoAdOpened");
        if (this.r) {
            com.ironsource.mediationsdk.adunit.a.a aVar = this.k.get(b.n());
            if (aVar != null) {
                D d2 = this.j;
                d2.a(d2.b, aVar.a(this.x));
                C0216f.a(aVar, b.l(), this.m, this.x);
                this.l.put(b.n(), C0218h.a.ISAuctionPerformanceShowedSuccessfully);
                a(aVar, this.x);
            } else {
                String n2 = b.n();
                b("onRewardedVideoAdOpened showing instance " + n2 + " missing from waterfall");
                b((int) IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.g}, new Object[]{IronSourceConstants.EVENTS_EXT1, n2}}));
            }
        }
        P.a().a(this.j.a(b.b));
        a(false, (Map<String, Object>) null);
        this.q.a();
    }

    public final void d() {
        a("onLoadTriggered: RV load was triggered in " + this.g + " state");
        a(0);
    }

    public final void d(B b) {
        String str;
        a(b, "onRewardedVideoAdClosed, mediation state: " + this.g.name());
        P.a().b(this.j.a(b.b));
        this.A = false;
        boolean z2 = this.g == a.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            Iterator<B> it = this.j.a().iterator();
            while (it.hasNext()) {
                B next = it.next();
                if (next.a == B.a.LOADED) {
                    sb.append(next.n() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = IronSourceConstants.EVENTS_EXT1;
        StringBuilder sb2 = new StringBuilder("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + sb;
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        b.a((int) IronSourceConstants.RV_INSTANCE_CLOSED, objArr);
        if (b.equals(this.j.c)) {
            this.j.a((B) null);
            if (this.g != a.RV_STATE_READY_TO_SHOW) {
                a(false, (Map<String, Object>) null);
            }
        }
    }

    public final void e(B b) {
        a(b, "onRewardedVideoAdStarted");
        P.a().b();
    }

    public final void f(B b) {
        a(b, "onRewardedVideoAdEnded");
        P.a().c();
    }
}
