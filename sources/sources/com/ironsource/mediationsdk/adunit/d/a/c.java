package com.ironsource.mediationsdk.adunit.d.a;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.adunit.b.d;
import com.ironsource.mediationsdk.adunit.c.b.c;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.c.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c<Listener extends com.ironsource.mediationsdk.adunit.c.b.c> implements AdapterAdListener, NetworkInitializationListener, com.ironsource.mediationsdk.adunit.b.c, b.a, m.a {
    private com.ironsource.mediationsdk.model.a a;
    private JSONObject b;
    protected com.ironsource.mediationsdk.adunit.d.a c;
    protected Listener d;
    protected BaseAdAdapter<?, AdapterAdListener> e;
    protected d f;
    protected a g = a.NONE;
    protected Placement h;
    protected AdData i;
    protected final Object j = new Object();
    private String k;
    private Long l;
    private com.ironsource.mediationsdk.utils.d m;
    private b n = new b(((long) this.c.d) * 1000);

    public enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    public c(com.ironsource.mediationsdk.adunit.d.a aVar, BaseAdAdapter<?, ?> baseAdAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        this.c = aVar;
        this.d = listener;
        this.f = new d(aVar.a, d.b.PROVIDER, this);
        this.a = aVar2;
        this.b = aVar2.b;
        this.e = baseAdAdapter;
    }

    private void a(AdapterErrorType adapterErrorType, int i2, String str, long j2) {
        if (this.f == null) {
            return;
        }
        if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
            if (e()) {
                this.f.c.c(j2, i2);
            } else {
                this.f.c.b(j2, i2);
            }
        } else if (TextUtils.isEmpty(str)) {
            this.f.c.a(j2, i2);
        } else if (e()) {
            this.f.c.b(j2, i2, str);
        } else {
            this.f.c.a(j2, i2, str);
        }
    }

    private boolean y() {
        return this.g == a.INIT_IN_PROGRESS;
    }

    /* access modifiers changed from: protected */
    public AdData a(String str, Map<String, Object> map) {
        return new AdData(str, v(), a(map));
    }

    public Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        HashMap hashMap = new HashMap();
        try {
            BaseAdAdapter baseAdAdapter = this.e;
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : str);
            BaseAdAdapter baseAdAdapter2 = this.e;
            if (baseAdAdapter2 != null) {
                str = baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
        } catch (Exception unused) {
            IronLog.INTERNAL.error(b("could not get adapter version for event data" + o()));
        }
        hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.a.a.getSubProviderId());
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.a.a.getAdSourceNameForEvents());
        hashMap.put("instanceType", Integer.valueOf(l()));
        boolean z = true;
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.k)) {
            hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.k);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, t());
        if (this.c.f != null && this.c.f.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.c.f);
        }
        if (!TextUtils.isEmpty(this.c.g)) {
            hashMap.put("auctionId", this.c.g);
        }
        if (!(bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED_WITH_REASON || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_NO_FILL || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_OPENED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_CLOSED || bVar == com.ironsource.mediationsdk.adunit.b.b.SHOW_AD || bVar == com.ironsource.mediationsdk.adunit.b.b.SHOW_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_CLICKED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_REWARDED)) {
            z = false;
        }
        if (z) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.c.h));
            if (!TextUtils.isEmpty(this.c.i)) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.c.i);
            }
        }
        if (!TextUtils.isEmpty(this.c.c.getCustomNetwork())) {
            hashMap.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.c.c.getCustomNetwork());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(DataKeys.USER_ID, this.c.b);
        return map;
    }

    /* access modifiers changed from: protected */
    public void a() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.e;
        if (baseAdAdapter instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) baseAdAdapter).loadAd(this.i, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(b("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a(String str) {
        C0215e.a();
        this.k = C0215e.d(str);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        String str2 = this.c.a.name() + " - " + o() + " - state = " + this.g;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        r6.d.a(com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError("time out"), r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r6 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "state = "
            r1.<init>(r2)
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = r6.g
            r1.append(r2)
            java.lang.String r2 = ", isBidder = "
            r1.append(r2)
            boolean r2 = r6.k()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r6.b(r1)
            r0.verbose(r1)
            com.ironsource.mediationsdk.utils.d r0 = r6.m
            long r0 = com.ironsource.mediationsdk.utils.d.a(r0)
            java.lang.String r2 = "time out"
            java.lang.Object r3 = r6.j
            monitor-enter(r3)
            boolean r4 = r6.f()     // Catch:{ all -> 0x0081 }
            r5 = 1025(0x401, float:1.436E-42)
            if (r4 == 0) goto L_0x0059
            com.ironsource.mediationsdk.adunit.d.a.c$a r4 = com.ironsource.mediationsdk.adunit.d.a.c.a.FAILED     // Catch:{ all -> 0x0081 }
            r6.g = r4     // Catch:{ all -> 0x0081 }
            com.ironsource.mediationsdk.adunit.b.d r4 = r6.f     // Catch:{ all -> 0x0081 }
            if (r4 == 0) goto L_0x004e
            com.ironsource.mediationsdk.adunit.b.h r4 = r4.c     // Catch:{ all -> 0x0081 }
            r4.a((long) r0, (int) r5)     // Catch:{ all -> 0x0081 }
            com.ironsource.mediationsdk.adunit.b.d r4 = r6.f     // Catch:{ all -> 0x0081 }
            com.ironsource.mediationsdk.adunit.b.h r4 = r4.c     // Catch:{ all -> 0x0081 }
            r4.a((long) r0, (int) r5, (java.lang.String) r2)     // Catch:{ all -> 0x0081 }
        L_0x004e:
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            Listener r0 = r6.d
            com.ironsource.mediationsdk.logger.IronSourceError r1 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r2)
            r0.a(r1, r6)
            return
        L_0x0059:
            java.lang.String r0 = "unexpected timeout for %s, state - %s, error - %s"
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r6.o()     // Catch:{ all -> 0x0081 }
            r4 = 0
            r1[r4] = r2     // Catch:{ all -> 0x0081 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = r6.g     // Catch:{ all -> 0x0081 }
            r4 = 1
            r1[r4] = r2     // Catch:{ all -> 0x0081 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0081 }
            r4 = 2
            r1[r4] = r2     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x0081 }
            com.ironsource.mediationsdk.adunit.b.d r1 = r6.f     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x007f
            com.ironsource.mediationsdk.adunit.b.j r1 = r1.g     // Catch:{ all -> 0x0081 }
            r1.l(r0)     // Catch:{ all -> 0x0081 }
        L_0x007f:
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            return
        L_0x0081:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.d.a.c.b():void");
    }

    public final void b(String str, Map<String, Object> map) {
        try {
            IronLog.INTERNAL.verbose(b((String) null));
            boolean z = false;
            if (e()) {
                this.f.c.a();
            } else {
                this.f.c.a(false);
            }
            this.l = null;
            this.m = new com.ironsource.mediationsdk.utils.d();
            this.i = a(str, map);
            synchronized (this.j) {
                if (this.g != a.NONE) {
                    z = true;
                } else {
                    this.g = a.INIT_IN_PROGRESS;
                }
            }
            if (z) {
                String str2 = "loadAd - incorrect state while loading, state = " + this.g;
                IronLog.INTERNAL.error(b(str2));
                this.f.g.n(str2);
                onInitFailed(com.ironsource.mediationsdk.adunit.a.a.a(this.c.a), str2);
                return;
            }
            this.n.a(this);
            AdapterBaseInterface networkAdapter = this.e.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.i, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str3 = "loadAd - network adapter not available " + o();
            IronLog.INTERNAL.error(b(str3));
            onInitFailed(com.ironsource.mediationsdk.adunit.a.a.a(this.c.a), str3);
        } catch (Throwable th) {
            String str4 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str4));
            d dVar = this.f;
            if (dVar != null) {
                dVar.g.n(str4);
            }
            onInitFailed(com.ironsource.mediationsdk.adunit.a.a.a(this.c.a), str4);
        }
    }

    public boolean b_() {
        return g();
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public final boolean f() {
        return this.g == a.INIT_IN_PROGRESS || this.g == a.LOADING;
    }

    public final boolean g() {
        return this.g == a.LOADED;
    }

    public final boolean h() {
        return this.g == a.FAILED;
    }

    public final void i() {
        IronLog.INTERNAL.verbose(b((String) null));
        d dVar = this.f;
        if (dVar != null) {
            dVar.f.a();
        }
    }

    public final Long j() {
        return this.l;
    }

    public final boolean k() {
        return this.a.d;
    }

    public final int l() {
        return this.a.f;
    }

    public final int m() {
        return this.a.g;
    }

    public final String n() {
        return this.a.a.getProviderName();
    }

    public final String o() {
        return String.format("%s %s", new Object[]{n(), Integer.valueOf(hashCode())});
    }

    public void onAdClicked() {
        IronLog.INTERNAL.verbose(b((String) null));
        d dVar = this.f;
        if (dVar != null) {
            dVar.f.c(x());
        }
        this.d.h(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoadFailed(com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType r8, int r9, java.lang.String r10) {
        /*
            r7 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error = "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r7.b(r1)
            r0.verbose(r1)
            com.ironsource.mediationsdk.c.b r0 = r7.n
            if (r0 == 0) goto L_0x0026
            r0.d()
        L_0x0026:
            com.ironsource.mediationsdk.utils.d r0 = r7.m
            long r5 = com.ironsource.mediationsdk.utils.d.a(r0)
            java.lang.Object r0 = r7.j
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = r7.g     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = com.ironsource.mediationsdk.adunit.d.a.c.a.LOADING     // Catch:{ all -> 0x00d9 }
            if (r1 != r2) goto L_0x004c
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r1.a(r2, r3, r4, r5)     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r8 = com.ironsource.mediationsdk.adunit.d.a.c.a.FAILED     // Catch:{ all -> 0x00d9 }
            r7.g = r8     // Catch:{ all -> 0x00d9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d9 }
            Listener r8 = r7.d
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r0.<init>(r9, r10)
            r8.a(r0, r7)
            return
        L_0x004c:
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = r7.g     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = com.ironsource.mediationsdk.adunit.d.a.c.a.FAILED     // Catch:{ all -> 0x00d9 }
            if (r1 != r2) goto L_0x005b
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r1.a(r2, r3, r4, r5)     // Catch:{ all -> 0x00d9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d9 }
            return
        L_0x005b:
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = r7.g     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = com.ironsource.mediationsdk.adunit.d.a.c.a.LOADED     // Catch:{ all -> 0x00d9 }
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 != r2) goto L_0x0093
            com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED     // Catch:{ all -> 0x00d9 }
            if (r8 != r1) goto L_0x0093
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d9 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00d9 }
            r7.l = r8     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.b.d r8 = r7.f     // Catch:{ all -> 0x00d9 }
            if (r8 == 0) goto L_0x0091
            com.ironsource.mediationsdk.adunit.b.j r8 = r8.g     // Catch:{ all -> 0x00d9 }
            java.lang.String r9 = "ad expired for %s, state = %s"
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.model.a r1 = r7.a     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r1.a     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = r1.getProviderName()     // Catch:{ all -> 0x00d9 }
            r10[r5] = r1     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = r7.g     // Catch:{ all -> 0x00d9 }
            r10[r4] = r1     // Catch:{ all -> 0x00d9 }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x00d9 }
            r8.p(r9)     // Catch:{ all -> 0x00d9 }
        L_0x0091:
            monitor-exit(r0)     // Catch:{ all -> 0x00d9 }
            return
        L_0x0093:
            java.lang.String r8 = "unexpected load failed for %s, state - %s, error - %s, %s"
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = r7.o()     // Catch:{ all -> 0x00d9 }
            r1[r5] = r2     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = r7.g     // Catch:{ all -> 0x00d9 }
            r1[r4] = r2     // Catch:{ all -> 0x00d9 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00d9 }
            r1[r3] = r9     // Catch:{ all -> 0x00d9 }
            r9 = 3
            r1[r9] = r10     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = java.lang.String.format(r8, r1)     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.b.d r9 = r7.f     // Catch:{ all -> 0x00d9 }
            if (r9 == 0) goto L_0x00d7
            boolean r9 = r7.e()     // Catch:{ all -> 0x00d9 }
            if (r9 == 0) goto L_0x00c2
            com.ironsource.mediationsdk.adunit.b.d r9 = r7.f     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.b.j r9 = r9.g     // Catch:{ all -> 0x00d9 }
            r9.i(r8)     // Catch:{ all -> 0x00d9 }
            goto L_0x00d7
        L_0x00c2:
            com.ironsource.mediationsdk.adunit.d.a r9 = r7.c     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r9 = r9.a     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r10 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00d9 }
            if (r9 != r10) goto L_0x00d0
            com.ironsource.mediationsdk.adunit.d.a.c$a r9 = r7.g     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r10 = com.ironsource.mediationsdk.adunit.d.a.c.a.SHOWING     // Catch:{ all -> 0x00d9 }
            if (r9 == r10) goto L_0x00d7
        L_0x00d0:
            com.ironsource.mediationsdk.adunit.b.d r9 = r7.f     // Catch:{ all -> 0x00d9 }
            com.ironsource.mediationsdk.adunit.b.j r9 = r9.g     // Catch:{ all -> 0x00d9 }
            r9.h(r8)     // Catch:{ all -> 0x00d9 }
        L_0x00d7:
            monitor-exit(r0)     // Catch:{ all -> 0x00d9 }
            return
        L_0x00d9:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d9 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.d.a.c.onAdLoadFailed(com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType, int, java.lang.String):void");
    }

    public void onAdLoadSuccess() {
        boolean z;
        IronLog.INTERNAL.verbose(b((String) null));
        b bVar = this.n;
        if (bVar != null) {
            bVar.d();
        }
        synchronized (this.j) {
            z = false;
            if (this.g == a.LOADING) {
                long a2 = com.ironsource.mediationsdk.utils.d.a(this.m);
                if (this.f != null) {
                    if (e()) {
                        this.f.c.a(a2);
                    } else {
                        this.f.c.a(a2, false);
                    }
                }
                this.g = a.LOADED;
                z = d();
            } else if (this.g != a.FAILED) {
                String format = String.format("unexpected load success for %s, state - %s", new Object[]{o(), this.g});
                if (this.f != null) {
                    if (e()) {
                        this.f.g.g(format);
                    } else {
                        this.f.g.f(format);
                    }
                }
            }
        }
        if (z) {
            this.d.f(this);
        }
    }

    public void onAdOpened() {
        IronLog.INTERNAL.verbose(b((String) null));
        this.g = a.SHOWING;
        d dVar = this.f;
        if (dVar != null) {
            dVar.f.b(x());
        }
        this.d.g(this);
    }

    public void onInitFailed(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("error = " + i2 + ", " + str));
        if (y()) {
            b bVar = this.n;
            if (bVar != null) {
                bVar.d();
            }
            this.g = a.FAILED;
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i2, str, com.ironsource.mediationsdk.utils.d.a(this.m));
            this.d.a(new IronSourceError(i2, str), this);
        } else if (this.g != a.FAILED) {
            String format = String.format("unexpected init failed for %s, state - %s, error - %s, %s", new Object[]{o(), this.g, Integer.valueOf(i2), str});
            d dVar = this.f;
            if (dVar != null) {
                dVar.g.c(format);
            }
        }
    }

    public void onInitSuccess() {
        IronLog.INTERNAL.verbose(b((String) null));
        if (y()) {
            b bVar = this.n;
            if (bVar != null) {
                bVar.d();
            }
            this.g = a.READY_TO_LOAD;
            IronLog.INTERNAL.verbose(b((String) null));
            this.g = a.LOADING;
            try {
                this.n.a(this);
                a();
            } catch (Throwable th) {
                String str = "unexpected error while calling adapter.loadAd() - " + th.getLocalizedMessage() + " - state = " + this.g;
                IronLog.INTERNAL.error(b(str));
                d dVar = this.f;
                if (dVar != null) {
                    dVar.g.n(str);
                }
                onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
            }
        } else if (this.g != a.FAILED) {
            String format = String.format("unexpected init success for %s, state - %s", new Object[]{o(), this.g});
            d dVar2 = this.f;
            if (dVar2 != null) {
                dVar2.g.b(format);
            }
        }
    }

    public final String p() {
        return this.a.a.getProviderTypeForReflection();
    }

    public final String q() {
        return this.c.g;
    }

    public final IronSource.AD_UNIT r() {
        return this.c.a;
    }

    public final void s() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.e;
        if (baseAdAdapter != null) {
            try {
                baseAdAdapter.releaseMemory();
                this.e = null;
            } catch (Exception e2) {
                String str = "Exception while calling adapter.releaseMemory() from " + this.a.a.getProviderName() + " - " + e2.getLocalizedMessage() + " - state = " + this.g;
                IronLog.INTERNAL.error(b(str));
                this.f.g.n(str);
            }
        }
        d dVar = this.f;
        if (dVar != null) {
            dVar.a = null;
            dVar.d = null;
            dVar.e = null;
            dVar.b = null;
            dVar.c = null;
            dVar.f = null;
            dVar.g = null;
            this.f = null;
        }
        b bVar = this.n;
        if (bVar != null) {
            bVar.c();
            this.n = null;
        }
    }

    public final Integer t() {
        com.ironsource.mediationsdk.adunit.d.a aVar = this.c;
        if (aVar != null) {
            return Integer.valueOf(aVar.e);
        }
        return null;
    }

    public final boolean u() {
        return this.g == a.SHOWING;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> v() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.ironsource.mediationsdk.d.c.a(this.b));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String w() {
        return b((String) null);
    }

    /* access modifiers changed from: protected */
    public final String x() {
        Placement placement = this.h;
        return placement == null ? "" : placement.getPlacementName();
    }
}
