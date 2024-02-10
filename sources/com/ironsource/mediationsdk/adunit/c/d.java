package com.ironsource.mediationsdk.adunit.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.j;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.C0212b;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.C0217g;
import com.ironsource.mediationsdk.C0218h;
import com.ironsource.mediationsdk.C0221k;
import com.ironsource.mediationsdk.C0227q;
import com.ironsource.mediationsdk.C0228r;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.S;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.b.d;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.adunit.e.f;
import com.ironsource.mediationsdk.adunit.e.g;
import com.ironsource.mediationsdk.bidding.b;
import com.ironsource.mediationsdk.bidding.d;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.l;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class d<Smash extends c<?>, Listener extends AdapterAdListener> implements j, S, com.ironsource.mediationsdk.adunit.b.c, com.ironsource.mediationsdk.adunit.c.b.c, com.ironsource.mediationsdk.adunit.e.d, C0212b, b, C0214d {
    private Boolean A;
    private com.ironsource.mediationsdk.d.c B;
    private a.C0114a C = MediationServices.getEditor().getSessionDepthServiceEditor();
    private boolean D;
    private com.ironsource.mediationsdk.testSuite.c E;
    private AtomicBoolean F = new AtomicBoolean(false);
    private C0218h a;
    protected com.ironsource.mediationsdk.adunit.e.c<Smash> b;
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> c;
    protected ConcurrentHashMap<String, C0218h.a> d;
    protected C0216f e;
    protected int f;
    protected String g = "";
    protected JSONObject h;
    protected Placement i;
    protected boolean j = false;
    protected com.ironsource.mediationsdk.utils.d k;
    protected com.ironsource.mediationsdk.adunit.c.a.a l;
    protected a m;
    protected a n;
    protected C0228r o;
    protected com.ironsource.mediationsdk.adunit.b.d p;
    protected com.ironsource.mediationsdk.adunit.c.d.a q;
    protected final Object r = new Object();
    final com.ironsource.mediationsdk.services.a s = MediationServices.getProvider().getSessionDepthService();
    private com.ironsource.mediationsdk.adunit.a.a t;
    private NetworkStateReceiver u;
    private m v;
    private com.ironsource.mediationsdk.utils.d w;
    private com.ironsource.mediationsdk.utils.a x;
    private IronSourceSegment y;
    private long z = 0;

    public enum a {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    public d(com.ironsource.mediationsdk.adunit.c.a.a aVar, com.ironsource.mediationsdk.d.c cVar, IronSourceSegment ironSourceSegment, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + aVar.a() + ", loading mode = " + aVar.h().a);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.a());
        sb.append(" initiated object per waterfall mode");
        IronSourceUtils.sendAutomationLog(sb.toString());
        com.ironsource.mediationsdk.utils.d dVar = new com.ironsource.mediationsdk.utils.d();
        this.y = ironSourceSegment;
        this.l = aVar;
        this.p = new com.ironsource.mediationsdk.adunit.b.d(aVar.a(), d.b.MEDIATION, this);
        this.q = b();
        this.n = new a(this.l.h(), this);
        a(a.NONE);
        this.B = cVar;
        this.b = new com.ironsource.mediationsdk.adunit.e.c<>(this.l.d().k, this.l.d().e, this);
        this.p.b.a(e(), this.l.h().a.toString());
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.i = null;
        k();
        this.h = new JSONObject();
        if (this.l.m()) {
            this.e = new C0216f(new C0217g(this.l.d(), z2, IronSourceUtils.getSessionId()));
        }
        this.a = new C0218h(this.l.c(), this.l.d().d);
        t();
        u();
        this.w = new com.ironsource.mediationsdk.utils.d();
        a(a.READY_TO_LOAD);
        this.o = new C0228r(aVar.g(), this);
        this.x = new com.ironsource.mediationsdk.utils.a();
        this.p.b.a(com.ironsource.mediationsdk.utils.d.a(dVar));
        if (this.l.h().b()) {
            IronLog.INTERNAL.verbose("first automatic load");
            i();
        }
    }

    /* access modifiers changed from: private */
    public void A() {
        IronLog.INTERNAL.verbose(a((String) null));
        AsyncTask.execute(new Runnable() {
            public final void run() {
                d.this.h = new JSONObject();
                d.this.p.e.a();
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                d.a(d.this, (Map) hashMap, (List) arrayList, sb, (List) arrayList2);
                if (d.this.l.i()) {
                    d.b(d.this, hashMap, arrayList, sb, arrayList2);
                } else {
                    d.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
                }
            }
        });
    }

    private void B() {
        this.x.a(this.l.a(), false);
    }

    private static String C() {
        return "fallback_" + System.currentTimeMillis();
    }

    private static BaseAdAdapter<?, Listener> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, ?> b2 = C0213c.a().b(networkSettings, ad_unit);
        if (b2 != null) {
            return b2;
        }
        return null;
    }

    private Smash a(com.ironsource.mediationsdk.adunit.a.a aVar, String str) {
        NetworkSettings a2 = this.l.a(aVar.a());
        if (a2 != null) {
            C0213c.a().a(a2, this.l.a());
            BaseAdAdapter a3 = a(a2, this.l.a());
            if (a3 != null) {
                Smash a4 = a(a2, a3, this.s.a(this.l.a()), str);
                this.c.put(a4.n(), aVar);
                this.d.put(aVar.a(), C0218h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return a4;
            }
            IronLog.INTERNAL.error(a("addSmashToWaterfall - could not load ad adapter for " + a2.getProviderInstanceName()));
        } else {
            String str2 = "could not find matching provider settings for auction response item - item = " + aVar.a() + " state = " + this.m;
            IronLog.INTERNAL.error(a(str2));
            this.p.g.a(str2);
        }
        return null;
    }

    private static String a(com.ironsource.mediationsdk.adunit.a.a aVar, int i2) {
        return String.format("%s%s", new Object[]{Integer.valueOf(i2), aVar.a()});
    }

    private String a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("waterfall.size() = " + list.size()));
        this.c.clear();
        this.d.clear();
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.ironsource.mediationsdk.adunit.a.a aVar = list.get(i2);
            c a2 = a(aVar, str);
            if (a2 != null) {
                copyOnWriteArrayList.add(a2);
                sb.append(a(aVar, a2.l()));
            }
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        this.b.a(this.l.h().a, copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(a("updateWaterfall() - next waterfall is " + sb));
        return sb.toString();
    }

    static /* synthetic */ void a(d dVar, NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(dVar.a(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()})));
        AdData a2 = dVar.a(networkSettings, dVar.l.b());
        AdapterBaseInterface a3 = C0213c.a().a(networkSettings, dVar.l.a());
        if (a3 != null) {
            try {
                a3.init(a2, ContextProvider.getInstance().getApplicationContext(), (NetworkInitializationListener) null);
            } catch (Exception e2) {
                com.ironsource.mediationsdk.adunit.b.j jVar = dVar.p.g;
                jVar.n("initProvider - exception while calling networkAdapter.init with " + networkSettings.getProviderName() + " - " + e2);
            }
        }
        IronLog.INTERNAL.verbose(dVar.a(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()})));
    }

    static /* synthetic */ void a(d dVar, Map map, List list, StringBuilder sb, List list2) {
        com.ironsource.mediationsdk.adunit.b.j jVar;
        String str;
        String str2;
        StringBuilder sb2;
        for (NetworkSettings next : dVar.l.c()) {
            com.ironsource.mediationsdk.testSuite.c cVar = dVar.E;
            if (cVar == null || cVar.a(next, dVar.l.a())) {
                if (!dVar.v.b(new l(next.getProviderInstanceName(), next.getMaxAdsPerSession(dVar.l.a()))) && dVar.c(next)) {
                    AdData a2 = dVar.a(next, (String) null);
                    if (next.isBidder(dVar.l.a())) {
                        AdapterBaseInterface a3 = C0213c.a().a(next, dVar.l.a());
                        if (!(a3 instanceof com.ironsource.mediationsdk.bidding.c)) {
                            if (a3 == null) {
                                sb2 = new StringBuilder("prepareAuctionCandidates - could not load network adapter ");
                                str2 = next.getProviderName();
                            } else {
                                sb2 = new StringBuilder("network adapter ");
                                sb2.append(next.getProviderName());
                                str2 = " does not implementing BiddingDataInterface";
                            }
                            sb2.append(str2);
                            str = sb2.toString();
                            jVar = dVar.p.g;
                            jVar.n(str);
                        } else if (dVar.l.i()) {
                            list2.add(new com.ironsource.mediationsdk.bidding.a(next.getInstanceType(dVar.l.a()), next.getProviderInstanceName(), a2, (com.ironsource.mediationsdk.bidding.c) a3, dVar, next));
                        } else {
                            try {
                                Map<String, Object> a4 = ((com.ironsource.mediationsdk.bidding.c) a3).a(a2);
                                if (a4 != null) {
                                    map.put(next.getProviderInstanceName(), a4);
                                    sb.append(next.getInstanceType(dVar.l.a()));
                                    sb.append(next.getProviderInstanceName());
                                    sb.append(",");
                                } else {
                                    dVar.p.g.a(dVar.a(next, a3), "Missing bidding data");
                                }
                            } catch (Exception e2) {
                                jVar = dVar.p.g;
                                str = "prepareAuctionCandidates - exception for " + next.getProviderName() + " while calling networkAdapter.getBiddingData - " + e2;
                            }
                        }
                    } else {
                        list.add(next.getProviderInstanceName());
                        sb.append(next.getInstanceType(dVar.l.a()));
                        sb.append(next.getProviderInstanceName());
                        sb.append(",");
                    }
                }
            }
        }
    }

    private void a(Smash smash) {
        IronLog.INTERNAL.verbose(a((String) null));
        com.ironsource.mediationsdk.adunit.a.a c2 = c((c<?>) smash);
        if (c2 != null) {
            String b2 = c2.b();
            Map<String, Object> a2 = com.ironsource.mediationsdk.d.c.a(c2.c());
            a2.put("adUnit", this.l.a());
            smash.a(b2);
            smash.b(b2, a2);
            return;
        }
        String str = "loadSmash - missing auctionResponseItem for " + smash.n() + " state = " + this.m;
        com.ironsource.mediationsdk.adunit.b.d dVar = this.p;
        if (dVar != null) {
            dVar.g.n(str);
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("auction waterfallString = " + str));
        boolean z2 = false;
        if (map.size() == 0 && list.size() == 0) {
            IronLog.INTERNAL.verbose(a("auction failed - no candidates"));
            this.p.e.a(0, 1005, "No candidates available for auctioning");
            a(com.ironsource.mediationsdk.adunit.a.a.d(this.l.a()), "no available ad to load", false);
            return;
        }
        this.p.e.a(str);
        if (this.e != null) {
            int a2 = this.s.a(this.l.a());
            C0221k kVar = new C0221k(this.l.a());
            kVar.b(IronSourceUtils.isEncryptedResponse());
            kVar.a(map);
            kVar.a(list);
            kVar.a(this.a);
            kVar.a(a2);
            kVar.a(this.y);
            kVar.d(this.D);
            com.ironsource.mediationsdk.testSuite.c cVar = this.E;
            if (cVar != null && cVar.a()) {
                z2 = true;
            }
            kVar.e(z2);
            a(ContextProvider.getInstance().getApplicationContext(), kVar, (C0214d) this);
            return;
        }
        IronLog.INTERNAL.error(a("mAuctionHandler is null"));
    }

    private void b(com.ironsource.mediationsdk.adunit.a.a aVar, String str) {
        if (aVar != null) {
            ImpressionData a2 = aVar.a(str);
            if (a2 != null) {
                for (ImpressionDataListener impressionDataListener : new HashSet(this.B.b())) {
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info(a("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + a2));
                    impressionDataListener.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("reportImpressionDataToPublisher - no auctionResponseItem or listener"));
        com.ironsource.mediationsdk.adunit.b.d dVar = this.p;
        if (dVar != null) {
            dVar.g.n("reportImpressionDataToPublisher - no auctionResponseItem or listener");
        }
    }

    static /* synthetic */ void b(d dVar, final Map map, final List list, final StringBuilder sb, List list2) {
        if (list2.isEmpty()) {
            dVar.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            return;
        }
        com.ironsource.mediationsdk.bidding.d dVar2 = new com.ironsource.mediationsdk.bidding.d();
        AnonymousClass4 r2 = new d.a() {
            public final void a(String str) {
                d.this.p.d.a(str);
                d.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }

            public final void a(List<com.ironsource.mediationsdk.utils.j> list, long j, List<String> list2) {
                d.this.p.d.a(j);
                for (com.ironsource.mediationsdk.utils.j next : list) {
                    NetworkSettings a2 = d.this.l.a(next.b());
                    Map<String, Object> a3 = d.this.a(a2, C0213c.a().a(a2, d.this.l.a()));
                    if (next.c() != null) {
                        map.put(next.b(), next.c());
                        StringBuilder sb = sb;
                        sb.append(next.a());
                        sb.append(next.b());
                        sb.append(",");
                        d.this.p.d.a(a3, next.d());
                    } else {
                        d.this.p.d.a(a3, next.d(), next.e());
                    }
                }
                for (String a4 : list2) {
                    NetworkSettings a5 = d.this.l.a(a4);
                    d.this.p.d.b(d.this.a(a5, C0213c.a().a(a5, d.this.l.a())), j);
                }
                d.this.a((Map<String, Object>) map, (List<String>) list, sb.toString());
            }
        };
        dVar.p.d.a();
        dVar2.a((List<com.ironsource.mediationsdk.bidding.a>) list2, (d.a) r2, dVar.l.j(), TimeUnit.MILLISECONDS);
    }

    private void b(c<?> cVar) {
        com.ironsource.mediationsdk.adunit.a.a c2;
        if (this.l.m() && (c2 = c(cVar)) != null) {
            com.ironsource.mediationsdk.adunit.e.c<Smash> cVar2 = this.b;
            cVar2.a(cVar2.b, c2.a(n()));
        }
    }

    private com.ironsource.mediationsdk.adunit.a.a c(c<?> cVar) {
        return this.c.get(cVar.n());
    }

    private boolean c(NetworkSettings networkSettings) {
        AdapterBaseInterface a2 = C0213c.a().a(networkSettings, this.l.a());
        if (a2 instanceof AdapterSettingsInterface) {
            return this.b.a(this.l.h().a, networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), ((AdapterSettingsInterface) a2).getLoadWhileShowSupportedState(networkSettings), a2, this.l.a());
        }
        return false;
    }

    private boolean q() {
        boolean z2;
        synchronized (this.r) {
            z2 = this.m == a.LOADING;
        }
        return z2;
    }

    private boolean r() {
        boolean z2;
        synchronized (this.r) {
            z2 = this.m == a.AUCTION;
        }
        return z2;
    }

    private boolean s() {
        boolean z2;
        synchronized (this.r) {
            if (this.m != a.LOADING) {
                if (this.m != a.READY_TO_SHOW) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private void t() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : this.l.c()) {
            arrayList.add(new l(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.l.a())));
        }
        this.v = new m(arrayList);
    }

    private void u() {
        IronLog.INTERNAL.verbose(a((String) null));
        ArrayList arrayList = new ArrayList();
        for (final NetworkSettings next : this.l.c()) {
            if (!com.ironsource.mediationsdk.adunit.e.c.a(C0213c.a().a(next, this.l.a()), this.l.a(), next.getProviderInstanceName()) && (next.shouldEarlyInit() || next.isIronSource() || next.isBidder(this.l.a()))) {
                arrayList.add(new Runnable() {
                    public final void run() {
                        d.a(d.this, next);
                    }
                });
            }
        }
        IronSourceThreadManager.INSTANCE.executeTasks(this.l.k(), this.l.l(), arrayList);
    }

    private void v() {
        IronLog.INTERNAL.verbose(a((String) null));
        a(w(), C());
    }

    private List<com.ironsource.mediationsdk.adunit.a.a> w() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings next : this.l.c()) {
            if (!next.isBidder(this.l.a()) && c(next)) {
                l lVar = new l(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.l.a()));
                if (!this.v.b(lVar)) {
                    copyOnWriteArrayList.add(new com.ironsource.mediationsdk.adunit.a.a(lVar.n()));
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void x() {
        g y2 = y();
        if (y2.a()) {
            a(509, "Mediation No fill", false);
        }
        for (c a2 : y2.c()) {
            a(a2);
        }
    }

    private g<Smash> y() {
        IronLog.INTERNAL.verbose();
        return new f(this.l).c(this.b.a(), this.c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r2 <= 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        new java.util.Timer().schedule(new com.ironsource.mediationsdk.adunit.c.d.AnonymousClass2(r5), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r5.F.set(false);
        r2 = r5.l.d().g - com.ironsource.mediationsdk.utils.d.a(r5.w);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z() {
        /*
            r5 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r1 = 0
            java.lang.String r1 = r5.a((java.lang.String) r1)
            r0.verbose(r1)
            java.lang.Object r0 = r5.r
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r5.m     // Catch:{ all -> 0x0048 }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.AUCTION     // Catch:{ all -> 0x0048 }
            if (r1 != r2) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0015:
            com.ironsource.mediationsdk.adunit.c.d$a r1 = com.ironsource.mediationsdk.adunit.c.d.a.AUCTION     // Catch:{ all -> 0x0048 }
            r5.a((com.ironsource.mediationsdk.adunit.c.d.a) r1)     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.F
            r1 = 0
            r0.set(r1)
            com.ironsource.mediationsdk.utils.d r0 = r5.w
            long r0 = com.ironsource.mediationsdk.utils.d.a(r0)
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r5.l
            com.ironsource.mediationsdk.utils.c r2 = r2.d()
            long r2 = r2.g
            long r2 = r2 - r0
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0044
            java.util.Timer r0 = new java.util.Timer
            r0.<init>()
            com.ironsource.mediationsdk.adunit.c.d$2 r1 = new com.ironsource.mediationsdk.adunit.c.d$2
            r1.<init>()
            r0.schedule(r1, r2)
            return
        L_0x0044:
            r5.A()
            return
        L_0x0048:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.d.z():void");
    }

    /* access modifiers changed from: protected */
    public AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(a(networkSettings), this.l.a(), str);
    }

    /* access modifiers changed from: protected */
    public abstract Smash a(NetworkSettings networkSettings, BaseAdAdapter<?, Listener> baseAdAdapter, int i2, String str);

    /* access modifiers changed from: protected */
    public final String a(String str) {
        String name = this.l.a().name();
        if (TextUtils.isEmpty(str)) {
            return name;
        }
        return name + " - " + str;
    }

    public Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        boolean z2 = true;
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.h);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.s.a(this.l.a())));
        if (bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED_WITH_REASON || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_UNIT_CAPPED) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f));
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.g);
            }
        }
        if (bVar == com.ironsource.mediationsdk.adunit.b.b.INIT_STARTED || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_REQUEST || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_REQUEST_WATERFALL || bVar == com.ironsource.mediationsdk.adunit.b.b.COLLECT_TOKEN || bVar == com.ironsource.mediationsdk.adunit.b.b.COLLECT_TOKENS_COMPLETED || bVar == com.ironsource.mediationsdk.adunit.b.b.COLLECT_TOKENS_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.INSTANCE_COLLECT_TOKEN || bVar == com.ironsource.mediationsdk.adunit.b.b.INSTANCE_COLLECT_TOKEN_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.INSTANCE_COLLECT_TOKEN_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.INSTANCE_COLLECT_TOKEN_TIMED_OUT) {
            z2 = false;
        }
        if (z2 && !TextUtils.isEmpty(this.b.b)) {
            hashMap.put("auctionId", this.b.b);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, networkSettings.getProviderDefaultInstance());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface.getAdapterVersion());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface.getNetworkSDKVersion());
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, networkSettings.getSubProviderId());
            hashMap.put("instanceType", Integer.valueOf(networkSettings.getInstanceType(this.l.a())));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.logException(ironSourceTag, "getProviderEventData " + networkSettings.getProviderDefaultInstance(), e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public abstract JSONObject a(NetworkSettings networkSettings);

    public final void a() {
        if (this.l.h().b()) {
            a(a.READY_TO_LOAD);
            a(false, true);
            i();
        }
    }

    public final void a(int i2) {
        com.ironsource.mediationsdk.adunit.b.j jVar = this.p.g;
        jVar.o("waterfalls hold too many with size = " + i2);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        IronLog.INTERNAL.verbose(a((String) null));
        if (r()) {
            String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
            IronLog.INTERNAL.verbose(a(str3));
            IronSourceUtils.sendAutomationLog(f() + ": " + str3);
            this.f = i3;
            this.g = str2;
            this.h = new JSONObject();
            v();
            this.p.e.a(j2, i2, str);
            a(a.LOADING);
            x();
            return;
        }
        this.p.g.e("unexpected auction fail - error = " + i2 + ", " + str + " state = " + this.m);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str, boolean z2) {
        a(a.READY_TO_LOAD);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("errorCode = " + i2 + ", errorReason = " + str));
        if (this.l.h().a()) {
            if (!z2) {
                this.p.c.a(com.ironsource.mediationsdk.utils.d.a(this.k), i2, str);
            }
            a(new IronSourceError(i2, str), false);
        } else {
            if (!z2) {
                this.p.g.a(i2, str);
            }
            a(false, false);
        }
        a aVar = this.n;
        if (aVar.a.b()) {
            IronLog.INTERNAL.verbose();
            aVar.a(aVar.a.c);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Context context, C0221k kVar, C0214d dVar) {
        C0216f fVar = this.e;
        if (fVar != null) {
            fVar.a(context, kVar, dVar);
        } else {
            IronLog.INTERNAL.error(a("mAuctionHandler is null"));
        }
    }

    public final void a(Context context, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("track = " + z2));
        try {
            this.j = z2;
            if (z2) {
                if (this.u == null) {
                    this.u = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.u, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.u != null) {
                context.getApplicationContext().unregisterReceiver(this.u);
            }
        } catch (Exception e2) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.y = ironSourceSegment;
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        synchronized (this.r) {
            this.m = aVar;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(com.ironsource.mediationsdk.adunit.c.d.a aVar) {
        this.q = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(c<?> cVar, AdInfo adInfo) {
        this.q.a(adInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r5 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r6 = r4.r;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r5.b() == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        if (s() == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        r0 = new com.ironsource.mediationsdk.adunit.e.f(r4.l).b(r4.b.a(), r4.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (r0 == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        i(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        r5 = r5.c().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r5.hasNext() == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        a((com.ironsource.mediationsdk.adunit.d.a.c) r5.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.logger.IronSourceError r5, com.ironsource.mediationsdk.adunit.d.a.c<?> r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.r
            monitor-enter(r0)
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00f2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r2.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = r6.o()     // Catch:{ all -> 0x00f2 }
            r2.append(r3)     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = " - error = "
            r2.append(r3)     // Catch:{ all -> 0x00f2 }
            r2.append(r5)     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x00f2 }
            r1.verbose(r5)     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = r6.q()     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.e.c<Smash> r1 = r4.b     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r1.b     // Catch:{ all -> 0x00f2 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x00f2 }
            if (r5 == 0) goto L_0x00b0
            com.ironsource.mediationsdk.adunit.c.d$a r5 = r4.m     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.c.d$a r1 = com.ironsource.mediationsdk.adunit.c.d.a.AUCTION     // Catch:{ all -> 0x00f2 }
            if (r5 != r1) goto L_0x003a
            goto L_0x00b0
        L_0x003a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r5 = r4.d     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = r6.n()     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.h$a r1 = com.ironsource.mediationsdk.C0218h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x00f2 }
            r5.put(r6, r1)     // Catch:{ all -> 0x00f2 }
            boolean r5 = r4.q()     // Catch:{ all -> 0x00f2 }
            if (r5 != 0) goto L_0x0054
            boolean r5 = r4.j()     // Catch:{ all -> 0x00f2 }
            if (r5 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r5 = 0
            goto L_0x0068
        L_0x0054:
            com.ironsource.mediationsdk.adunit.e.g r5 = r4.y()     // Catch:{ all -> 0x00f2 }
            boolean r6 = r5.a()     // Catch:{ all -> 0x00f2 }
            if (r6 == 0) goto L_0x0068
            java.lang.String r5 = "Mediation No fill"
            r6 = 0
            r1 = 509(0x1fd, float:7.13E-43)
            r4.a((int) r1, (java.lang.String) r5, (boolean) r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            return
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            if (r5 != 0) goto L_0x006c
            return
        L_0x006c:
            java.lang.Object r6 = r4.r
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0093
            boolean r0 = r4.s()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0093
            com.ironsource.mediationsdk.adunit.e.f r0 = new com.ironsource.mediationsdk.adunit.e.f     // Catch:{ all -> 0x00ad }
            com.ironsource.mediationsdk.adunit.c.a.a r1 = r4.l     // Catch:{ all -> 0x00ad }
            r0.<init>(r1)     // Catch:{ all -> 0x00ad }
            com.ironsource.mediationsdk.adunit.e.c<Smash> r1 = r4.b     // Catch:{ all -> 0x00ad }
            java.util.List r1 = r1.a()     // Catch:{ all -> 0x00ad }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r2 = r4.c     // Catch:{ all -> 0x00ad }
            com.ironsource.mediationsdk.adunit.d.a.c r0 = r0.b(r1, r2)     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0093
            r4.i(r0)     // Catch:{ all -> 0x00ad }
        L_0x0093:
            monitor-exit(r6)     // Catch:{ all -> 0x00ad }
            java.util.List r5 = r5.c()
            java.util.Iterator r5 = r5.iterator()
        L_0x009c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00ac
            java.lang.Object r6 = r5.next()
            com.ironsource.mediationsdk.adunit.d.a.c r6 = (com.ironsource.mediationsdk.adunit.d.a.c) r6
            r4.a(r6)
            goto L_0x009c
        L_0x00ac:
            return
        L_0x00ad:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ad }
            throw r5
        L_0x00b0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = "onAdLoadFailed was invoked from "
            r5.<init>(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r6.n()     // Catch:{ all -> 0x00f2 }
            r5.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = " with state ="
            r5.append(r1)     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r4.m     // Catch:{ all -> 0x00f2 }
            r5.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = " auctionId: "
            r5.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = r6.q()     // Catch:{ all -> 0x00f2 }
            r5.append(r6)     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = " and the current id is "
            r5.append(r6)     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.e.c<Smash> r6 = r4.b     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = r6.b     // Catch:{ all -> 0x00f2 }
            r5.append(r6)     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00f2 }
            r6.verbose(r5)     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.b.d r6 = r4.p     // Catch:{ all -> 0x00f2 }
            com.ironsource.mediationsdk.adunit.b.j r6 = r6.g     // Catch:{ all -> 0x00f2 }
            r6.h(r5)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            return
        L_0x00f2:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            goto L_0x00f6
        L_0x00f5:
            throw r5
        L_0x00f6:
            goto L_0x00f5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.d.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.mediationsdk.adunit.d.a.c):void");
    }

    /* access modifiers changed from: protected */
    public void a(IronSourceError ironSourceError, boolean z2) {
        C0227q.a().a(this.l.a(), ironSourceError, z2);
    }

    public final void a(com.ironsource.mediationsdk.testSuite.c cVar) {
        this.E = cVar;
        this.D = cVar != null;
        this.A = null;
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog.INTERNAL.verbose(a((String) null));
        if (r()) {
            this.g = "";
            this.f = i2;
            this.t = aVar;
            this.h = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                this.p.g.b(i3, str2);
            }
            boolean z2 = false;
            if (jSONObject2 != null) {
                z2 = jSONObject2.optBoolean("isAdUnitCapped", false);
            }
            this.x.a(this.l.a(), z2);
            if (this.x.a(this.l.a())) {
                this.p.e.c(str);
                a((int) IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped", true);
                return;
            }
            String a2 = a(list, str);
            this.p.e.a(j2);
            this.p.e.b(a2);
            a(a.LOADING);
            x();
            return;
        }
        com.ironsource.mediationsdk.adunit.b.j jVar = this.p.g;
        jVar.d("unexpected auction success for auctionId - " + str + " state = " + this.m);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (g() != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r3.A.booleanValue() != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.j
            if (r0 == 0) goto L_0x004a
            com.ironsource.mediationsdk.adunit.c.a.a r0 = r3.l
            com.ironsource.mediationsdk.adunit.c.c.a r0 = r0.h()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "network availability changed to - "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.verbose(r1)
            java.lang.Boolean r0 = r3.A
            r1 = 0
            if (r0 != 0) goto L_0x002b
        L_0x0029:
            r2 = 0
            goto L_0x0045
        L_0x002b:
            r2 = 1
            if (r4 == 0) goto L_0x003b
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003b
            boolean r0 = r3.g()
            if (r0 == 0) goto L_0x003b
            goto L_0x0045
        L_0x003b:
            if (r4 != 0) goto L_0x0029
            java.lang.Boolean r0 = r3.A
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0029
        L_0x0045:
            if (r2 == 0) goto L_0x004a
            r3.a((boolean) r4, (boolean) r1)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.d.a(boolean):void");
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2, boolean z3) {
        synchronized (this.r) {
            Boolean bool = this.A;
            if (bool == null || bool.booleanValue() != z2) {
                this.A = Boolean.valueOf(z2);
                long j2 = 0;
                if (this.z != 0) {
                    j2 = new Date().getTime() - this.z;
                }
                this.z = new Date().getTime();
                this.p.c.a(z2, j2, z3);
                com.ironsource.mediationsdk.adunit.c.d.a aVar = this.q;
                com.ironsource.mediationsdk.adunit.e.c<Smash> cVar = this.b;
                aVar.a(z2, cVar.a(cVar.b));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(a aVar, a aVar2) {
        boolean z2;
        synchronized (this.r) {
            if (this.m == aVar) {
                this.m = aVar2;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public abstract com.ironsource.mediationsdk.adunit.c.d.a b();

    public final void b(NetworkSettings networkSettings) {
        AdapterBaseInterface a2 = C0213c.a().a(networkSettings, this.l.a());
        if (a2 != null) {
            this.p.d.a(a(networkSettings, a2));
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean c();

    public void d() {
        IronLog.INTERNAL.verbose(a((String) null));
        i();
    }

    /* access modifiers changed from: protected */
    public void d(c<?> cVar) {
        this.q.c(this.b.a(cVar.q()));
    }

    /* access modifiers changed from: package-private */
    public abstract String e();

    /* access modifiers changed from: protected */
    public void e(c<?> cVar) {
        if (this.l.h().a()) {
            a(cVar, this.b.a(cVar.q()));
        } else {
            a(true, false);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String f();

    public final void f(c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        if (!cVar.q().equals(this.b.b)) {
            String str = "invoked from " + cVar.n() + " with state = " + this.m + " auctionId: " + cVar.q() + " and the current id is " + this.b.b;
            IronLog.INTERNAL.verbose(str);
            this.p.g.f(str);
            return;
        }
        List<Smash> a2 = this.b.a();
        f fVar = new f(this.l);
        boolean a3 = fVar.a(cVar, a2, this.c);
        synchronized (this.r) {
            if (a3) {
                if (s()) {
                    i(cVar);
                    b(cVar);
                }
            }
            if (fVar.a(a2)) {
                c b2 = fVar.b(a2, this.c);
                i(b2);
                b((c<?>) b2);
            }
        }
        this.d.put(cVar.n(), C0218h.a.ISAuctionPerformanceLoadedSuccessfully);
        if (a(a.LOADING, a.READY_TO_SHOW)) {
            long a4 = com.ironsource.mediationsdk.utils.d.a(this.k);
            if (c()) {
                this.p.c.a(a4);
            } else {
                this.p.c.a(a4, p());
            }
            if (this.l.h().b()) {
                this.o.a(0);
            }
            e(cVar);
        }
    }

    public final void g(c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        this.p.f.b(n());
        this.b.a(cVar);
        this.v.a(cVar);
        if (this.v.b(cVar)) {
            IronLog.INTERNAL.verbose(a(cVar.n() + " was session capped"));
            cVar.i();
            IronSourceUtils.sendAutomationLog(cVar.n() + " was session capped");
        }
        com.ironsource.mediationsdk.utils.j.b(ContextProvider.getInstance().getApplicationContext(), n(), this.l.a());
        if (com.ironsource.mediationsdk.utils.j.a(ContextProvider.getInstance().getApplicationContext(), n(), this.l.a())) {
            IronLog.INTERNAL.verbose(a("placement " + n() + " is capped"));
            this.p.f.j(n());
        }
        this.C.b(this.l.a());
        if (this.l.m()) {
            com.ironsource.mediationsdk.adunit.a.a c2 = c(cVar);
            if (c2 != null) {
                b(cVar);
                C0216f.a(c2, cVar.l(), this.t, n());
                this.d.put(cVar.n(), C0218h.a.ISAuctionPerformanceShowedSuccessfully);
                if (l()) {
                    b(c2, n());
                }
            } else {
                String n2 = cVar.n();
                String str = "showing instance missing from waterfall - " + n2;
                IronLog.INTERNAL.verbose(a(str));
                this.p.g.a(1011, str, n2);
            }
        }
        d(cVar);
        if (this.l.h().b()) {
            a(false, false);
        }
        a aVar = this.n;
        if (aVar.a.a == a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW) {
            IronLog.INTERNAL.verbose();
            aVar.a(aVar.a.b);
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return false;
    }

    public final void h(c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        this.p.f.c(n());
        this.q.a(this.i, this.b.a(cVar.q()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010e, code lost:
        if (r6.l.m() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0110, code lost:
        com.ironsource.mediationsdk.logger.IronLog.INTERNAL.verbose(a("auction disabled"));
        v();
        x();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r6 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r1 = 0
            java.lang.String r2 = r6.a((java.lang.String) r1)
            r0.verbose(r2)
            java.lang.Object r0 = r6.r
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a r2 = r2.h()     // Catch:{ all -> 0x0122 }
            boolean r2 = r2.b()     // Catch:{ all -> 0x0122 }
            r3 = 0
            if (r2 == 0) goto L_0x003c
            com.ironsource.mediationsdk.utils.m r2 = r6.v     // Catch:{ all -> 0x0122 }
            boolean r2 = r2.a()     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x003c
            java.lang.String r1 = "all smashes are capped"
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r6.a((java.lang.String) r1)     // Catch:{ all -> 0x0122 }
            r2.verbose(r4)     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a()     // Catch:{ all -> 0x0122 }
            int r2 = com.ironsource.mediationsdk.adunit.a.a.e(r2)     // Catch:{ all -> 0x0122 }
            r6.a((int) r2, (java.lang.String) r1, (boolean) r3)     // Catch:{ all -> 0x0122 }
            monitor-exit(r0)     // Catch:{ all -> 0x0122 }
            return
        L_0x003c:
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a r2 = r2.h()     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a$a r2 = r2.a     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a$a r4 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x0122 }
            if (r2 == r4) goto L_0x0083
            com.ironsource.mediationsdk.adunit.c.d$a r2 = r6.m     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.d$a r4 = com.ironsource.mediationsdk.adunit.c.d.a.SHOWING     // Catch:{ all -> 0x0122 }
            if (r2 != r4) goto L_0x0083
            java.lang.String r2 = "load cannot be invoked while showing an ad"
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0122 }
            java.lang.String r5 = r6.a((java.lang.String) r2)     // Catch:{ all -> 0x0122 }
            r4.error(r5)     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.logger.IronSourceError r4 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r5 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = r5.a()     // Catch:{ all -> 0x0122 }
            int r5 = com.ironsource.mediationsdk.adunit.a.a.c(r5)     // Catch:{ all -> 0x0122 }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a r2 = r2.h()     // Catch:{ all -> 0x0122 }
            boolean r2 = r2.a()     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x007c
            boolean r1 = r6.c()     // Catch:{ all -> 0x0122 }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r4, (boolean) r1)     // Catch:{ all -> 0x0122 }
            goto L_0x0081
        L_0x007c:
            com.ironsource.mediationsdk.adunit.c.d.a r2 = r6.q     // Catch:{ all -> 0x0122 }
            r2.a((boolean) r3, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)     // Catch:{ all -> 0x0122 }
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x0122 }
            return
        L_0x0083:
            com.ironsource.mediationsdk.adunit.c.a.a r1 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a r1 = r1.h()     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a$a r1 = r1.a     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.c.a$a r2 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x0122 }
            if (r1 == r2) goto L_0x00b8
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r6.m     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.READY_TO_LOAD     // Catch:{ all -> 0x0122 }
            if (r1 == r2) goto L_0x009b
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r6.m     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.READY_TO_SHOW     // Catch:{ all -> 0x0122 }
            if (r1 != r2) goto L_0x00ab
        L_0x009b:
            com.ironsource.mediationsdk.q r1 = com.ironsource.mediationsdk.C0227q.a()     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r6.l     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a()     // Catch:{ all -> 0x0122 }
            boolean r1 = r1.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r2)     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x00b8
        L_0x00ab:
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "load is already in progress"
            java.lang.String r2 = r6.a((java.lang.String) r2)     // Catch:{ all -> 0x0122 }
            r1.error(r2)     // Catch:{ all -> 0x0122 }
            monitor-exit(r0)     // Catch:{ all -> 0x0122 }
            return
        L_0x00b8:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0122 }
            r1.<init>()     // Catch:{ all -> 0x0122 }
            r6.h = r1     // Catch:{ all -> 0x0122 }
            r6.B()     // Catch:{ all -> 0x0122 }
            boolean r1 = r6.c()     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x00d0
            com.ironsource.mediationsdk.adunit.b.d r1 = r6.p     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.b.h r1 = r1.c     // Catch:{ all -> 0x0122 }
            r1.a()     // Catch:{ all -> 0x0122 }
            goto L_0x00db
        L_0x00d0:
            com.ironsource.mediationsdk.adunit.b.d r1 = r6.p     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.b.h r1 = r1.c     // Catch:{ all -> 0x0122 }
            boolean r2 = r6.p()     // Catch:{ all -> 0x0122 }
            r1.a((boolean) r2)     // Catch:{ all -> 0x0122 }
        L_0x00db:
            com.ironsource.mediationsdk.utils.d r1 = new com.ironsource.mediationsdk.utils.d     // Catch:{ all -> 0x0122 }
            r1.<init>()     // Catch:{ all -> 0x0122 }
            r6.k = r1     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r1 = r6.l     // Catch:{ all -> 0x0122 }
            boolean r1 = r1.m()     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x0102
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r1 = r6.d     // Catch:{ all -> 0x0122 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0122 }
            if (r1 != 0) goto L_0x00fe
            com.ironsource.mediationsdk.h r1 = r6.a     // Catch:{ all -> 0x0122 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r2 = r6.d     // Catch:{ all -> 0x0122 }
            r1.a((java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.C0218h.a>) r2)     // Catch:{ all -> 0x0122 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r1 = r6.d     // Catch:{ all -> 0x0122 }
            r1.clear()     // Catch:{ all -> 0x0122 }
        L_0x00fe:
            r6.z()     // Catch:{ all -> 0x0122 }
            goto L_0x0107
        L_0x0102:
            com.ironsource.mediationsdk.adunit.c.d$a r1 = com.ironsource.mediationsdk.adunit.c.d.a.LOADING     // Catch:{ all -> 0x0122 }
            r6.a((com.ironsource.mediationsdk.adunit.c.d.a) r1)     // Catch:{ all -> 0x0122 }
        L_0x0107:
            monitor-exit(r0)     // Catch:{ all -> 0x0122 }
            com.ironsource.mediationsdk.adunit.c.a.a r0 = r6.l
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x0121
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = "auction disabled"
            java.lang.String r1 = r6.a((java.lang.String) r1)
            r0.verbose(r1)
            r6.v()
            r6.x()
        L_0x0121:
            return
        L_0x0122:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0122 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.d.i():void");
    }

    /* access modifiers changed from: protected */
    public final void i(c<?> cVar) {
        if (this.l.m() && this.F.compareAndSet(false, true)) {
            com.ironsource.mediationsdk.adunit.a.a c2 = c(cVar);
            if (c2 != null) {
                C0216f.a(c2, cVar.l(), this.t);
                ArrayList arrayList = new ArrayList();
                for (Smash n2 : this.b.a()) {
                    arrayList.add(n2.n());
                }
                C0216f.a((ArrayList<String>) arrayList, this.c, cVar.l(), this.t, c2);
                return;
            }
            String n3 = cVar.n();
            String str = "winner instance missing from waterfall - " + n3;
            IronLog.INTERNAL.verbose(a(str));
            this.p.g.a(1010, str, n3);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        boolean z2;
        synchronized (this.r) {
            z2 = this.m == a.READY_TO_SHOW;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void k() {
        C0227q.a().a(this.l.a(), this.l.f());
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final String m() {
        return a((String) null);
    }

    /* access modifiers changed from: protected */
    public final String n() {
        Placement placement = this.i;
        return placement == null ? "" : placement.getPlacementName();
    }

    public final void o() {
        for (NetworkSettings a2 : this.l.c()) {
            C0213c.a().a(a2, this.l.a());
        }
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return false;
    }
}
