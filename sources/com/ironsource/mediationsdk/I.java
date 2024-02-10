package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.C0218h;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.b;
import com.ironsource.mediationsdk.bidding.d;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.services.IMediationServiceEditor;
import com.ironsource.mediationsdk.services.IMediationServiceProvider;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.d;
import com.ironsource.mediationsdk.utils.j;
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

public final class I extends C0225o implements J, C0214d {
    private final Object A;
    private d B;
    private boolean C;
    private final long D;
    private final Runnable E;
    com.ironsource.mediationsdk.events.d d;
    com.ironsource.lifecycle.a.a e;
    IronSourceBannerLayout f;
    e g;
    K h;
    int i;
    final ConcurrentHashMap<String, K> j;
    C0218h k;
    ConcurrentHashMap<String, C0218h.a> l;
    long m;
    final boolean n;
    private final com.ironsource.mediationsdk.services.a o;
    private final a.C0114a p;
    private a q;
    private int r;
    private CopyOnWriteArrayList<K> s;
    private String t;
    private JSONObject u;
    private String v;
    private int w;
    private C0216f x;
    private com.ironsource.mediationsdk.adunit.a.a y;
    private ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> z;

    enum a {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    private I(IMediationServiceProvider iMediationServiceProvider, IMediationServiceEditor iMediationServiceEditor, List<NetworkSettings> list, com.ironsource.mediationsdk.events.d dVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.q = a.NONE;
        this.v = "";
        this.A = new Object();
        this.C = false;
        AnonymousClass3 r12 = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x006b A[Catch:{ all -> 0x00a4 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[Catch:{ all -> 0x00a4 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r9 = this;
                    r0 = 2
                    r1 = 1
                    r2 = 0
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.IronSourceBannerLayout r3 = r3.f     // Catch:{ all -> 0x00a4 }
                    java.lang.String r4 = "errorCode"
                    r5 = 3200(0xc80, float:4.484E-42)
                    if (r3 != 0) goto L_0x002a
                    com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00a4 }
                    java.lang.String r6 = "mIronSourceBanner is null"
                    r3.verbose(r6)     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    java.lang.Object[][] r6 = new java.lang.Object[r1][]     // Catch:{ all -> 0x00a4 }
                    java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a4 }
                    r7[r2] = r4     // Catch:{ all -> 0x00a4 }
                    r4 = 622(0x26e, float:8.72E-43)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00a4 }
                    r7[r1] = r4     // Catch:{ all -> 0x00a4 }
                    r6[r2] = r7     // Catch:{ all -> 0x00a4 }
                    r3.a((int) r5, (java.lang.Object[][]) r6)     // Catch:{ all -> 0x00a4 }
                    return
                L_0x002a:
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.IronSourceBannerLayout r6 = r3.f     // Catch:{ all -> 0x00a4 }
                    boolean r6 = r6.isShown()     // Catch:{ all -> 0x00a4 }
                    if (r6 != 0) goto L_0x003d
                    com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00a4 }
                    java.lang.String r6 = "banner or one of its parents are INVISIBLE or GONE"
                L_0x0038:
                    r3.verbose(r6)     // Catch:{ all -> 0x00a4 }
                    r3 = 0
                    goto L_0x0069
                L_0x003d:
                    com.ironsource.mediationsdk.IronSourceBannerLayout r6 = r3.f     // Catch:{ all -> 0x00a4 }
                    boolean r6 = r6.hasWindowFocus()     // Catch:{ all -> 0x00a4 }
                    if (r6 != 0) goto L_0x004a
                    com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00a4 }
                    java.lang.String r6 = "banner has no window focus"
                    goto L_0x0038
                L_0x004a:
                    android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ all -> 0x00a4 }
                    r6.<init>()     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.IronSourceBannerLayout r3 = r3.f     // Catch:{ all -> 0x00a4 }
                    boolean r3 = r3.getGlobalVisibleRect(r6)     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00a4 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
                    java.lang.String r8 = "visible = "
                    r7.<init>(r8)     // Catch:{ all -> 0x00a4 }
                    r7.append(r3)     // Catch:{ all -> 0x00a4 }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a4 }
                    r6.verbose(r7)     // Catch:{ all -> 0x00a4 }
                L_0x0069:
                    if (r3 == 0) goto L_0x0071
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.I.a((com.ironsource.mediationsdk.I) r3)     // Catch:{ all -> 0x00a4 }
                    return
                L_0x0071:
                    com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00a4 }
                    java.lang.String r6 = "banner is not visible, reload skipped"
                    r3.verbose(r6)     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    java.lang.Object[][] r6 = new java.lang.Object[r1][]     // Catch:{ all -> 0x00a4 }
                    java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a4 }
                    r7[r2] = r4     // Catch:{ all -> 0x00a4 }
                    r4 = 613(0x265, float:8.59E-43)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00a4 }
                    r7[r1] = r4     // Catch:{ all -> 0x00a4 }
                    r6[r2] = r7     // Catch:{ all -> 0x00a4 }
                    r3.a((int) r5, (java.lang.Object[][]) r6)     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.I r3 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    com.ironsource.lifecycle.a.a r3 = r3.e     // Catch:{ all -> 0x00a4 }
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.I r5 = com.ironsource.mediationsdk.I.this     // Catch:{ all -> 0x00a4 }
                    com.ironsource.mediationsdk.events.d r5 = r5.d     // Catch:{ all -> 0x00a4 }
                    int r5 = r5.g()     // Catch:{ all -> 0x00a4 }
                    long r5 = (long) r5     // Catch:{ all -> 0x00a4 }
                    long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x00a4 }
                    r3.a((long) r4)     // Catch:{ all -> 0x00a4 }
                    return
                L_0x00a4:
                    r3 = move-exception
                    com.ironsource.mediationsdk.I r4 = com.ironsource.mediationsdk.I.this
                    java.lang.Object[][] r5 = new java.lang.Object[r1][]
                    java.lang.Object[] r0 = new java.lang.Object[r0]
                    java.lang.String r6 = "reason"
                    r0[r2] = r6
                    java.lang.String r3 = r3.getMessage()
                    r0[r1] = r3
                    r5[r2] = r0
                    r0 = 83513(0x14639, float:1.17027E-40)
                    r4.a((int) r0, (java.lang.Object[][]) r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.AnonymousClass3.run():void");
            }
        };
        this.E = r12;
        com.ironsource.mediationsdk.services.a sessionDepthService = iMediationServiceProvider.getSessionDepthService();
        this.o = sessionDepthService;
        this.p = iMediationServiceEditor.getSessionDepthServiceEditor();
        long time = new Date().getTime();
        a((int) IronSourceConstants.BN_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_BN_MANAGER_NAME}});
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isAuctionEnabled = " + dVar.c());
        this.d = dVar;
        this.j = new ConcurrentHashMap<>();
        this.s = new CopyOnWriteArrayList<>();
        this.z = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
        this.i = sessionDepthService.a(IronSource.AD_UNIT.BANNER);
        C0227q.a().a(IronSource.AD_UNIT.BANNER, this.d.e());
        if (this.d.c()) {
            this.x = new C0216f(IronSource.AD_UNIT.BANNER, this.d.h(), this);
        }
        this.k = new C0218h(list, this.d.h().d);
        a(list, dVar);
        this.m = new Date().getTime();
        a(a.READY_TO_LOAD);
        this.n = dVar.j();
        this.D = dVar.k();
        this.e = new com.ironsource.lifecycle.a.a(r12, com.ironsource.lifecycle.d.a(), new C0224n());
        a((int) IronSourceConstants.BN_MANAGER_INIT_ENDED, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    public I(List<NetworkSettings> list, com.ironsource.mediationsdk.events.d dVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(MediationServices.getProvider(), MediationServices.getEditor(), list, dVar, hashSet, ironSourceSegment);
    }

    private String a(List<com.ironsource.mediationsdk.adunit.a.a> list) {
        int i2;
        int i3;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("waterfall.size() = " + list.size());
        this.s.clear();
        this.z.clear();
        this.l.clear();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (i4 < list.size()) {
            com.ironsource.mediationsdk.adunit.a.a aVar = list.get(i4);
            K k2 = this.j.get(aVar.a());
            if (k2 != null) {
                AbstractAdapter a2 = C0213c.a().a(k2.d.a);
                if (a2 != null) {
                    com.ironsource.mediationsdk.events.d dVar = this.d;
                    NetworkSettings networkSettings = k2.d.a;
                    int i5 = this.i;
                    String str = this.t;
                    JSONObject jSONObject = this.u;
                    int i6 = this.w;
                    K k3 = r0;
                    String str2 = this.v;
                    i2 = i4;
                    i3 = 1;
                    K k4 = new K(dVar, this, networkSettings, a2, i5, str, jSONObject, i6, str2, d());
                    k3.e = true;
                    this.s.add(k3);
                    this.z.put(k3.n(), aVar);
                    this.l.put(aVar.a(), C0218h.a.ISAuctionPerformanceDidntAttemptToLoad);
                } else {
                    i2 = i4;
                    i3 = 1;
                }
            } else {
                i2 = i4;
                i3 = 1;
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.error("could not find matching smash for auction response item - item = " + aVar.a());
            }
            K k5 = this.j.get(aVar.a());
            String str3 = "1";
            if (k5 == null ? !TextUtils.isEmpty(aVar.b()) : k5.h()) {
                str3 = "2";
            }
            sb.append(str3 + aVar.a());
            int i7 = i2;
            if (i7 != list.size() - i3) {
                sb.append(",");
            }
            i4 = i7 + 1;
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    static /* synthetic */ void a(I i2) {
        IronLog.INTERNAL.verbose("");
        if (i2.a(a.LOADED, a.STARTED_LOADING)) {
            i2.a(true);
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("wrong state = " + i2.q);
    }

    static /* synthetic */ void a(I i2, Map map, List list, StringBuilder sb, List list2) {
        StringBuilder sb2;
        if (!j.b(ContextProvider.getInstance().getApplicationContext(), i2.k())) {
            for (K next : i2.j.values()) {
                AdData createAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(next.f, IronSource.AD_UNIT.BANNER, (String) null, i2.f);
                if (next.h()) {
                    if (i2.n) {
                        list2.add(new com.ironsource.mediationsdk.bidding.a(next.l(), next.n(), createAdDataForNetworkAdapter, next, (b) null, (NetworkSettings) null));
                    } else {
                        Map<String, Object> a2 = next.a(createAdDataForNetworkAdapter);
                        if (a2 != null) {
                            map.put(next.n(), a2);
                            sb2 = new StringBuilder();
                        } else {
                            next.a((int) IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Missing bidding data"}});
                        }
                    }
                } else if (!next.h()) {
                    list.add(next.n());
                    sb2 = new StringBuilder();
                }
                sb2.append(next.l());
                sb2.append(next.n());
                sb2.append(",");
                sb.append(sb2.toString());
            }
        }
    }

    private void a(K k2, com.ironsource.mediationsdk.adunit.a.a aVar) {
        C0216f.a(aVar, k2.l(), this.y, k());
        a(this.z.get(k2.n()), k());
    }

    private void a(List<NetworkSettings> list, com.ironsource.mediationsdk.events.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (final NetworkSettings next : list) {
            arrayList.add(new Runnable() {
                public final void run() {
                    I i = I.this;
                    NetworkSettings networkSettings = next;
                    IronLog.INTERNAL.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                    AbstractAdapter a2 = C0213c.a().a(networkSettings, networkSettings.getBannerSettings(), false, false);
                    if (a2 != null) {
                        K k = new K(i.d, i, networkSettings, a2, i.i, i.d());
                        i.j.put(k.n(), k);
                    } else {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose(networkSettings.getProviderInstanceName() + " can't load adapter");
                    }
                    IronLog.INTERNAL.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
                }
            });
        }
        IronSourceThreadManager.INSTANCE.executeTasks(dVar.i().m, dVar.i().n, arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + sb);
        if (map.size() == 0 && list.size() == 0) {
            a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}});
            if (a(a.AUCTION, a.LOADED)) {
                this.e.a(TimeUnit.SECONDS.toMillis((long) this.d.g()));
                return;
            }
            C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(1005, "No candidates available for auctioning"));
            a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}});
            a(a.READY_TO_LOAD);
            return;
        }
        a((int) IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
        C0216f fVar = this.x;
        if (fVar != null) {
            fVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.k, this.i, this.b, i());
            return;
        }
        IronLog.INTERNAL.error("mAuctionHandler is null");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(org.json.JSONObject r7, com.ironsource.mediationsdk.ISBannerSize r8) {
        /*
            java.lang.String r0 = "ext1"
            java.lang.String r1 = r8.getDescription()     // Catch:{ Exception -> 0x00b0 }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x00b0 }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -387072689: goto L_0x003a;
                case 72205083: goto L_0x0030;
                case 79011241: goto L_0x0026;
                case 1951953708: goto L_0x001c;
                case 1999208305: goto L_0x0012;
                default: goto L_0x0011;
            }     // Catch:{ Exception -> 0x00b0 }
        L_0x0011:
            goto L_0x0044
        L_0x0012:
            java.lang.String r2 = "CUSTOM"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x0044
            r1 = 4
            goto L_0x0045
        L_0x001c:
            java.lang.String r2 = "BANNER"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x0044
            r1 = 0
            goto L_0x0045
        L_0x0026:
            java.lang.String r2 = "SMART"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x0044
            r1 = 3
            goto L_0x0045
        L_0x0030:
            java.lang.String r2 = "LARGE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x0044
            r1 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r2 = "RECTANGLE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x0044
            r1 = 2
            goto L_0x0045
        L_0x0044:
            r1 = -1
        L_0x0045:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L_0x0086
            if (r1 == r6) goto L_0x0082
            if (r1 == r5) goto L_0x007e
            if (r1 == r4) goto L_0x0079
            if (r1 == r3) goto L_0x0052
            goto L_0x0089
        L_0x0052:
            r1 = 6
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r2.<init>()     // Catch:{ Exception -> 0x00b0 }
            int r3 = r8.getWidth()     // Catch:{ Exception -> 0x00b0 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ Exception -> 0x00b0 }
            int r3 = r8.getHeight()     // Catch:{ Exception -> 0x00b0 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b0 }
            r7.put(r1, r2)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0089
        L_0x0079:
            r1 = 5
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0089
        L_0x007e:
            r7.put(r2, r4)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0089
        L_0x0082:
            r7.put(r2, r5)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0089
        L_0x0086:
            r7.put(r2, r6)     // Catch:{ Exception -> 0x00b0 }
        L_0x0089:
            boolean r8 = r8.isAdaptive()     // Catch:{ Exception -> 0x00b0 }
            if (r8 == 0) goto L_0x00af
            java.lang.String r8 = "Adaptive=true"
            boolean r1 = r7.has(r0)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x00ac
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r8.<init>()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r1 = r7.optString(r0)     // Catch:{ Exception -> 0x00b0 }
            r8.append(r1)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r1 = " , Adaptive=true"
            r8.append(r1)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b0 }
        L_0x00ac:
            r7.put(r0, r8)     // Catch:{ Exception -> 0x00b0 }
        L_0x00af:
            return
        L_0x00b0:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            r8.error(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.a(org.json.JSONObject, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.q);
        if (a(a.STARTED_LOADING, this.d.c() ? z2 ? a.AUCTION : a.FIRST_AUCTION : z2 ? a.RELOADING : a.LOADING)) {
            this.B = new d();
            this.t = "";
            this.u = null;
            this.r = 0;
            this.i = this.o.a(IronSource.AD_UNIT.BANNER);
            a(z2 ? IronSourceConstants.BN_RELOAD : 3001, (Object[][]) null);
            if (this.d.c()) {
                a();
                return;
            }
            f();
            e();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.error("wrong state - " + this.q);
    }

    private boolean a(a aVar, a aVar2) {
        boolean z2;
        synchronized (this.A) {
            if (this.q == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("set state from '" + this.q + "' to '" + aVar2 + "'");
                this.q = aVar2;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    static /* synthetic */ void b(I i2, final Map map, final List list, final StringBuilder sb, List list2) {
        if (list2.isEmpty()) {
            i2.a((Map<String, Object>) map, (List<String>) list, sb);
            return;
        }
        com.ironsource.mediationsdk.bidding.d dVar = new com.ironsource.mediationsdk.bidding.d();
        AnonymousClass5 r3 = new d.a() {
            public final void a(String str) {
                I.this.a((int) IronSourceConstants.BN_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{"duration", str}});
                I.this.a((Map<String, Object>) map, (List<String>) list, sb);
            }

            public final void a(List<j> list, long j, List<String> list2) {
                I.this.a((int) IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                for (j next : list) {
                    if (next.c() != null) {
                        map.put(next.b(), next.c());
                        StringBuilder sb = sb;
                        sb.append(next.a());
                        sb.append(next.b());
                        sb.append(",");
                        I.this.j.get(next.b()).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}});
                    } else {
                        I.this.j.get(next.b()).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(next.d())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, next.e()}});
                    }
                }
                for (String str : list2) {
                    ConcurrentHashMap<String, K> concurrentHashMap = I.this.j;
                    concurrentHashMap.get(str).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                }
                I.this.a((Map<String, Object>) map, (List<String>) list, sb);
            }
        };
        i2.a((int) IronSourceConstants.BN_COLLECT_TOKENS, (Object[][]) null);
        dVar.a((List<com.ironsource.mediationsdk.bidding.a>) list2, (d.a) r3, i2.D, TimeUnit.MILLISECONDS);
    }

    private static boolean b(int i2) {
        return i2 == 3201 || i2 == 3110 || i2 == 3111 || i2 == 3116 || i2 == 3119 || i2 == 3112 || i2 == 3115 || i2 == 3501 || i2 == 3502 || i2 == 3506;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r4.isDestroyed() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (r5.h() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r4 = r12.z.get(r5.n()).b();
        r5.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r7 = r12.z.get(r5.n()).c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r8 = r12.f;
        r9 = new com.ironsource.mediationsdk.IronSourceBannerLayout(r8.c, r8.a);
        r9.setPlacementName(r8.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        com.ironsource.mediationsdk.logger.IronLog.INTERNAL.verbose("Failed to make copy of banner layout: " + r8.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a5, code lost:
        if (r12.s.isEmpty() == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a7, code lost:
        r4 = "Empty waterfall";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00aa, code lost:
        r4 = "Mediation No fill";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
        com.ironsource.mediationsdk.logger.IronLog.INTERNAL.verbose("errorReason = " + r4);
        f((com.ironsource.mediationsdk.K) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ce, code lost:
        if (a(com.ironsource.mediationsdk.I.a.f, com.ironsource.mediationsdk.I.a.b) == false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        a((int) com.ironsource.mediationsdk.utils.IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new java.lang.Object[][]{new java.lang.Object[]{com.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_ERROR_CODE, 606}, new java.lang.Object[]{com.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_ERROR_REASON, r4}, new java.lang.Object[]{"duration", java.lang.Long.valueOf(com.ironsource.mediationsdk.utils.d.a(r12.B))}});
        com.ironsource.mediationsdk.C0227q.a().a(com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER, new com.ironsource.mediationsdk.logger.IronSourceError(606, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0118, code lost:
        if (a(com.ironsource.mediationsdk.I.a.g, com.ironsource.mediationsdk.I.a.h) == false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011a, code lost:
        a((int) com.ironsource.mediationsdk.utils.IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, new java.lang.Object[][]{new java.lang.Object[]{"duration", java.lang.Long.valueOf(com.ironsource.mediationsdk.utils.d.a(r12.B))}});
        com.ironsource.mediationsdk.C0227q.a().a(com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER, new com.ironsource.mediationsdk.logger.IronSourceError(606, r4), true);
        r12.e.a(java.util.concurrent.TimeUnit.SECONDS.toMillis((long) r12.d.g()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0154, code lost:
        a(com.ironsource.mediationsdk.I.a.b);
        com.ironsource.mediationsdk.logger.IronLog.INTERNAL.error("wrong state = " + r12.q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        com.ironsource.mediationsdk.logger.IronLog.INTERNAL.verbose("loading smash - " + r5.s());
        r12.r = r4 + 1;
        r4 = r12.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (r4 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r12 = this;
            java.lang.String r0 = "reason"
            r1 = 2
            r2 = 0
            r3 = 1
            int r4 = r12.r     // Catch:{ Exception -> 0x0170 }
        L_0x0007:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.K> r5 = r12.s     // Catch:{ Exception -> 0x0170 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0170 }
            r6 = 0
            if (r4 >= r5) goto L_0x009f
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.K> r5 = r12.s     // Catch:{ Exception -> 0x0170 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.K r5 = (com.ironsource.mediationsdk.K) r5     // Catch:{ Exception -> 0x0170 }
            boolean r7 = r5.e     // Catch:{ Exception -> 0x0170 }
            if (r7 == 0) goto L_0x009b
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0170 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0170 }
            java.lang.String r9 = "loading smash - "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r9 = r5.s()     // Catch:{ Exception -> 0x0170 }
            r8.append(r9)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0170 }
            r7.verbose(r8)     // Catch:{ Exception -> 0x0170 }
            int r4 = r4 + r3
            r12.r = r4     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r4 = r12.f     // Catch:{ Exception -> 0x0170 }
            if (r4 == 0) goto L_0x009a
            boolean r4 = r4.isDestroyed()     // Catch:{ Exception -> 0x0170 }
            if (r4 != 0) goto L_0x009a
            boolean r4 = r5.h()     // Catch:{ Exception -> 0x0170 }
            if (r4 == 0) goto L_0x005a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r4 = r12.z     // Catch:{ Exception -> 0x0170 }
            java.lang.String r7 = r5.n()     // Catch:{ Exception -> 0x0170 }
            java.lang.Object r4 = r4.get(r7)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.adunit.a.a r4 = (com.ironsource.mediationsdk.adunit.a.a) r4     // Catch:{ Exception -> 0x0170 }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x0170 }
            r5.a(r4)     // Catch:{ Exception -> 0x0170 }
            goto L_0x005b
        L_0x005a:
            r4 = r6
        L_0x005b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.a.a> r7 = r12.z     // Catch:{ Exception -> 0x0170 }
            java.lang.String r8 = r5.n()     // Catch:{ Exception -> 0x0170 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.adunit.a.a r7 = (com.ironsource.mediationsdk.adunit.a.a) r7     // Catch:{ Exception -> 0x0170 }
            org.json.JSONObject r7 = r7.c()     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r8 = r12.f     // Catch:{ Exception -> 0x007d }
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = new com.ironsource.mediationsdk.IronSourceBannerLayout     // Catch:{ Exception -> 0x007d }
            android.app.Activity r10 = r8.c     // Catch:{ Exception -> 0x007d }
            com.ironsource.mediationsdk.ISBannerSize r11 = r8.a     // Catch:{ Exception -> 0x007d }
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = r8.b     // Catch:{ Exception -> 0x007d }
            r9.setPlacementName(r8)     // Catch:{ Exception -> 0x007d }
            r6 = r9
            goto L_0x0095
        L_0x007d:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0170 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0170 }
            java.lang.String r11 = "Failed to make copy of banner layout: "
            r10.<init>(r11)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0170 }
            r10.append(r8)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0170 }
            r9.verbose(r8)     // Catch:{ Exception -> 0x0170 }
        L_0x0095:
            com.ironsource.mediationsdk.model.e r8 = r12.g     // Catch:{ Exception -> 0x0170 }
            r5.a(r6, r8, r4, r7)     // Catch:{ Exception -> 0x0170 }
        L_0x009a:
            return
        L_0x009b:
            int r4 = r4 + 1
            goto L_0x0007
        L_0x009f:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.K> r4 = r12.s     // Catch:{ Exception -> 0x0170 }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x0170 }
            if (r4 == 0) goto L_0x00aa
            java.lang.String r4 = "Empty waterfall"
            goto L_0x00ac
        L_0x00aa:
            java.lang.String r4 = "Mediation No fill"
        L_0x00ac:
            com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0170 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0170 }
            java.lang.String r8 = "errorReason = "
            r7.<init>(r8)     // Catch:{ Exception -> 0x0170 }
            r7.append(r4)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0170 }
            r5.verbose(r7)     // Catch:{ Exception -> 0x0170 }
            r12.f(r6)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.I$a r5 = com.ironsource.mediationsdk.I.a.LOADING     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.I$a r6 = com.ironsource.mediationsdk.I.a.READY_TO_LOAD     // Catch:{ Exception -> 0x0170 }
            boolean r5 = r12.a((com.ironsource.mediationsdk.I.a) r5, (com.ironsource.mediationsdk.I.a) r6)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r6 = "duration"
            r7 = 606(0x25e, float:8.49E-43)
            if (r5 == 0) goto L_0x0110
            r5 = 3
            java.lang.Object[][] r5 = new java.lang.Object[r5][]     // Catch:{ Exception -> 0x0170 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0170 }
            java.lang.String r9 = "errorCode"
            r8[r2] = r9     // Catch:{ Exception -> 0x0170 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0170 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0170 }
            r5[r2] = r8     // Catch:{ Exception -> 0x0170 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0170 }
            r8[r2] = r0     // Catch:{ Exception -> 0x0170 }
            r8[r3] = r4     // Catch:{ Exception -> 0x0170 }
            r5[r3] = r8     // Catch:{ Exception -> 0x0170 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0170 }
            r8[r2] = r6     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.utils.d r6 = r12.B     // Catch:{ Exception -> 0x0170 }
            long r9 = com.ironsource.mediationsdk.utils.d.a(r6)     // Catch:{ Exception -> 0x0170 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0170 }
            r8[r3] = r6     // Catch:{ Exception -> 0x0170 }
            r5[r1] = r8     // Catch:{ Exception -> 0x0170 }
            r6 = 3111(0xc27, float:4.36E-42)
            r12.a((int) r6, (java.lang.Object[][]) r5)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x0170 }
            r5.<init>(r7, r4)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.q r4 = com.ironsource.mediationsdk.C0227q.a()     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r6 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ Exception -> 0x0170 }
            r4.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6, (com.ironsource.mediationsdk.logger.IronSourceError) r5)     // Catch:{ Exception -> 0x0170 }
            goto L_0x0191
        L_0x0110:
            com.ironsource.mediationsdk.I$a r5 = com.ironsource.mediationsdk.I.a.RELOADING     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.I$a r8 = com.ironsource.mediationsdk.I.a.LOADED     // Catch:{ Exception -> 0x0170 }
            boolean r5 = r12.a((com.ironsource.mediationsdk.I.a) r5, (com.ironsource.mediationsdk.I.a) r8)     // Catch:{ Exception -> 0x0170 }
            if (r5 == 0) goto L_0x0154
            java.lang.Object[][] r5 = new java.lang.Object[r3][]     // Catch:{ Exception -> 0x0170 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0170 }
            r8[r2] = r6     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.utils.d r6 = r12.B     // Catch:{ Exception -> 0x0170 }
            long r9 = com.ironsource.mediationsdk.utils.d.a(r6)     // Catch:{ Exception -> 0x0170 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0170 }
            r8[r3] = r6     // Catch:{ Exception -> 0x0170 }
            r5[r2] = r8     // Catch:{ Exception -> 0x0170 }
            r6 = 3201(0xc81, float:4.486E-42)
            r12.a((int) r6, (java.lang.Object[][]) r5)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x0170 }
            r5.<init>(r7, r4)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.q r4 = com.ironsource.mediationsdk.C0227q.a()     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r6 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ Exception -> 0x0170 }
            r4.a(r6, r5, r3)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.lifecycle.a.a r4 = r12.e     // Catch:{ Exception -> 0x0170 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.events.d r6 = r12.d     // Catch:{ Exception -> 0x0170 }
            int r6 = r6.g()     // Catch:{ Exception -> 0x0170 }
            long r6 = (long) r6     // Catch:{ Exception -> 0x0170 }
            long r5 = r5.toMillis(r6)     // Catch:{ Exception -> 0x0170 }
            r4.a((long) r5)     // Catch:{ Exception -> 0x0170 }
            goto L_0x0191
        L_0x0154:
            com.ironsource.mediationsdk.I$a r4 = com.ironsource.mediationsdk.I.a.READY_TO_LOAD     // Catch:{ Exception -> 0x0170 }
            r12.a((com.ironsource.mediationsdk.I.a) r4)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0170 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0170 }
            java.lang.String r6 = "wrong state = "
            r5.<init>(r6)     // Catch:{ Exception -> 0x0170 }
            com.ironsource.mediationsdk.I$a r6 = r12.q     // Catch:{ Exception -> 0x0170 }
            r5.append(r6)     // Catch:{ Exception -> 0x0170 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0170 }
            r4.error(r5)     // Catch:{ Exception -> 0x0170 }
            return
        L_0x0170:
            r4 = move-exception
            java.lang.Object[][] r5 = new java.lang.Object[r1][]
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "ext1"
            r6[r2] = r7
            java.lang.String r7 = "loadNextSmash"
            r6[r3] = r7
            r5[r2] = r6
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r4)
            r1[r3] = r0
            r5[r3] = r1
            r0 = 83072(0x14480, float:1.16409E-40)
            r12.a((int) r0, (java.lang.Object[][]) r5)
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.e():void");
    }

    private void f() {
        List<com.ironsource.mediationsdk.adunit.a.a> g2 = g();
        this.t = c();
        a(g2);
    }

    private void f(K k2) {
        Iterator<K> it = this.s.iterator();
        while (it.hasNext()) {
            K next = it.next();
            if (!next.equals(k2)) {
                next.f();
            }
        }
    }

    private List<com.ironsource.mediationsdk.adunit.a.a> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (K next : this.j.values()) {
            if (!next.h() && !j.b(ContextProvider.getInstance().getApplicationContext(), k())) {
                copyOnWriteArrayList.add(new com.ironsource.mediationsdk.adunit.a.a(next.n()));
            }
        }
        return copyOnWriteArrayList;
    }

    private boolean h() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    private ISBannerSize i() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.f.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? ISBannerSize.a : ISBannerSize.BANNER : this.f.getSize();
    }

    private ISBannerSize j() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    private String k() {
        e eVar = this.g;
        return eVar != null ? eVar.getPlacementName() : "";
    }

    private boolean l() {
        boolean z2;
        synchronized (this.A) {
            if (this.q != a.LOADING) {
                if (this.q != a.RELOADING) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private boolean m() {
        boolean z2;
        synchronized (this.A) {
            if (this.q != a.FIRST_AUCTION) {
                if (this.q != a.AUCTION) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private boolean n() {
        boolean z2;
        synchronized (this.A) {
            z2 = this.q == a.LOADED;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        IronLog.INTERNAL.verbose();
        AsyncTask.execute(new Runnable() {
            public final void run() {
                boolean z;
                I i = I.this;
                if (!i.l.isEmpty()) {
                    i.k.a(i.l);
                    i.l.clear();
                }
                I i2 = I.this;
                long d = i2.d.d() - (new Date().getTime() - i2.m);
                if (d > 0) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("waiting before auction - timeToWaitBeforeAuction = " + d);
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            I.this.a();
                        }
                    }, d);
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    I.this.a((int) IronSourceConstants.BN_AUCTION_REQUEST);
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList2 = new ArrayList();
                    I.a(I.this, (Map) hashMap, (List) arrayList, sb, (List) arrayList2);
                    if (I.this.n) {
                        I.b(I.this, hashMap, arrayList, sb, arrayList2);
                    } else {
                        I.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(i2, (Object[][]) null);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        IronLog.INTERNAL.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (m()) {
            this.v = str2;
            this.w = i3;
            this.u = null;
            f();
            a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}});
            a(this.q == a.FIRST_AUCTION ? a.LOADING : a.RELOADING);
            e();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.q);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, this.i);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Object[][] objArr, int i3) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize j2 = j();
            if (j2 != null) {
                a(mediationAdditionalData, j2);
            }
            if (this.g != null) {
                mediationAdditionalData.put("placement", k());
            }
            mediationAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, i3);
            if (!TextUtils.isEmpty(this.t)) {
                mediationAdditionalData.put("auctionId", this.t);
            }
            JSONObject jSONObject = this.u;
            if (jSONObject != null && jSONObject.length() > 0) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.u);
            }
            if (b(i2)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.w);
                if (!TextUtils.isEmpty(this.v)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.v);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        com.ironsource.mediationsdk.events.e.d().a(new com.ironsource.environment.c.a(i2, mediationAdditionalData));
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("from '" + this.q + "' to '" + aVar + "'");
        synchronized (this.A) {
            this.q = aVar;
        }
    }

    public final void a(final IronSourceBannerLayout ironSourceBannerLayout, final e eVar) {
        String str;
        IronLog.INTERNAL.verbose();
        a(IronSource.AD_UNIT.BANNER);
        a_();
        if (!a(a.READY_TO_LOAD, a.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (!C0227q.a().a(IronSource.AD_UNIT.BANNER)) {
            AnonymousClass1 r0 = new C0224n.a() {
                public final void a() {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("placement = " + eVar.getPlacementName());
                    I.this.f = ironSourceBannerLayout;
                    I.this.g = eVar;
                    if (j.b(ContextProvider.getInstance().getApplicationContext(), eVar.getPlacementName())) {
                        IronLog.INTERNAL.verbose("placement is capped");
                        C0227q a2 = C0227q.a();
                        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
                        a2.a(ad_unit, new IronSourceError(604, "placement " + eVar.getPlacementName() + " is capped"));
                        I.this.a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 604}});
                        I.this.a(a.READY_TO_LOAD);
                        return;
                    }
                    I.this.a(false);
                }

                public final void a(String str) {
                    IronLog ironLog = IronLog.API;
                    ironLog.error("can't load banner - errorMessage = " + str);
                }
            };
            if (!C0224n.a(ironSourceBannerLayout)) {
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                str = String.format("can't load banner - %s", objArr);
            } else {
                str = null;
            }
            if (eVar == null || TextUtils.isEmpty(eVar.getPlacementName())) {
                Object[] objArr2 = new Object[1];
                objArr2[0] = eVar == null ? "placement is null" : "placement name is empty";
                str = String.format("can't load banner - %s", objArr2);
            }
            if (!TextUtils.isEmpty(str)) {
                IronLog.INTERNAL.error(str);
                r0.a(str);
                return;
            }
            r0.a();
        } else {
            IronLog.INTERNAL.verbose("can't load banner - already has pending invocation");
        }
    }

    public final void a(K k2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(k2.s());
        if (h()) {
            C0222l.a().d(this.c);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_CLICK, objArr, k2.p());
    }

    public final void a(K k2, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        K k3 = k2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + k2.s());
        if (k3.a != this.t) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("invoked with auctionId: " + k3.a + " and the current id is " + this.t);
            Object[] objArr2 = {IronSourceConstants.EVENTS_ERROR_CODE, 2};
            k3.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr2, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong auction id " + k3.a + " State - " + this.q}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2.n()}});
        } else if (l()) {
            K k4 = this.h;
            if (k4 != null) {
                k4.f();
            }
            f(k2);
            this.h = k3;
            IronSourceBannerLayout ironSourceBannerLayout = this.f;
            if (ironSourceBannerLayout != null) {
                C0224n.a(ironSourceBannerLayout, view, layoutParams);
            }
            this.l.put(k2.n(), C0218h.a.ISAuctionPerformanceShowedSuccessfully);
            if (this.d.c()) {
                com.ironsource.mediationsdk.adunit.a.a aVar = this.z.get(k2.n());
                if (aVar != null) {
                    a(aVar.a(k()));
                    C0216f.a(aVar, k2.l(), this.y);
                    C0216f fVar = this.x;
                    CopyOnWriteArrayList<K> copyOnWriteArrayList = this.s;
                    CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                    fVar.a((CopyOnWriteArrayList<O>) copyOnWriteArrayList, this.z, k2.l(), this.y, aVar);
                    if (!this.d.h().o) {
                        a(k3, aVar);
                    }
                } else {
                    String n2 = k2.n();
                    IronLog ironLog3 = IronLog.INTERNAL;
                    ironLog3.error("onLoadSuccess winner instance " + n2 + " missing from waterfall. auctionId = " + this.t);
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, n2}});
                }
            }
            if (this.q == a.LOADING) {
                if (h()) {
                    C0222l.a().a(this.c, false);
                    objArr = new Object[][]{new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.B))}};
                } else {
                    objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}, new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.B))}};
                }
                a((int) IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, objArr);
            } else {
                if (h()) {
                    C0222l.a().a(this.c, true);
                }
                IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
                a((int) IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.B))}});
            }
            String k5 = k();
            j.f(ContextProvider.getInstance().getApplicationContext(), k5);
            if (j.b(ContextProvider.getInstance().getApplicationContext(), k5)) {
                a((int) IronSourceConstants.BN_PLACEMENT_CAPPED, (Object[][]) null);
            }
            this.p.b(IronSource.AD_UNIT.BANNER);
            a(a.LOADED);
            this.e.a(TimeUnit.SECONDS.toMillis((long) this.d.g()));
        } else {
            IronLog ironLog4 = IronLog.INTERNAL;
            ironLog4.warning("wrong state - mCurrentState = " + this.q);
        }
    }

    public final void a(IronSourceError ironSourceError, K k2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (k2.a != this.t) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("invoked with auctionId: " + k2.a + " and the current id is " + this.t);
            Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 3};
            k2.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong auction " + k2.a + " State - " + this.q}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2.n()}});
        } else if (l()) {
            this.l.put(k2.n(), C0218h.a.ISAuctionPerformanceFailedToLoad);
            e();
        } else {
            IronLog ironLog3 = IronLog.INTERNAL;
            ironLog3.warning("wrong state - mCurrentState = " + this.q);
        }
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (m()) {
            this.v = "";
            this.t = str;
            this.w = i2;
            this.y = aVar;
            this.u = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}});
            }
            a(jSONObject2, IronSource.AD_UNIT.BANNER);
            if (this.a.a(IronSource.AD_UNIT.BANNER)) {
                a((int) IronSourceConstants.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}});
                a aVar2 = this.q;
                a(a.READY_TO_LOAD);
                if (aVar2 == a.FIRST_AUCTION) {
                    C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
                    return;
                }
                return;
            }
            a((int) IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}});
            a(this.q == a.FIRST_AUCTION ? a.LOADING : a.RELOADING);
            a((int) IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, a(list)}});
            e();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mCurrentState = " + this.q);
    }

    public final void b(K k2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(k2.s());
        if (h()) {
            C0222l.a().b(this.c);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, k2.p());
    }

    public final void c(K k2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(k2.s());
        if (h()) {
            C0222l.a().a(this.c);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, k2.p());
    }

    public final void d(K k2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(k2.s());
        if (h()) {
            C0222l.a().c(this.c);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, k2.p());
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.q == a.RELOADING || this.q == a.AUCTION;
    }

    public final void e(K k2) {
        Object[][] objArr;
        int i2;
        com.ironsource.mediationsdk.adunit.a.a aVar;
        IronLog.INTERNAL.verbose(k2.s());
        if (n()) {
            if (this.d.c() && this.d.h().o && (aVar = this.z.get(k2.n())) != null) {
                a(k2, aVar);
            }
            i2 = IronSourceConstants.BN_CALLBACK_SHOW;
            objArr = null;
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("wrong state - mCurrentState = " + this.q);
            String n2 = k2.n();
            Object[] objArr2 = {IronSourceConstants.EVENTS_ERROR_CODE, 1};
            objArr = new Object[][]{objArr2, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong State - " + this.q}, new Object[]{IronSourceConstants.EVENTS_EXT1, n2}};
            i2 = IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE;
        }
        a(i2, objArr);
    }
}
