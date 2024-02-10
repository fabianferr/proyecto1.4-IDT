package com.ironsource.mediationsdk.adunit.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0221k;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.C0227q;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.adunit.c.d;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.j;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class b extends d<com.ironsource.mediationsdk.adunit.d.b, AdapterAdViewListener> implements a {
    public IronSourceBannerLayout a;
    private boolean t = false;

    public b(List<NetworkSettings> list, d dVar, String str, c cVar, IronSourceSegment ironSourceSegment, boolean z) {
        super(new com.ironsource.mediationsdk.adunit.c.a.b(str, list, dVar), cVar, ironSourceSegment, z);
    }

    private static boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    /* access modifiers changed from: protected */
    public final AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(networkSettings.getBannerSettings(), this.l.a(), str, this.a);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ com.ironsource.mediationsdk.adunit.d.a.c a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str) {
        return new com.ironsource.mediationsdk.adunit.d.b(new com.ironsource.mediationsdk.adunit.d.a(IronSource.AD_UNIT.BANNER, this.l.b(), i, this.h, str, this.f, this.g, networkSettings, this.l.e()), baseAdAdapter, this.a, this.i, this.t, this);
    }

    public final Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        Map<String, Object> a2 = super.a(bVar);
        if (b(this.a)) {
            C0224n.a(a2, this.a.getSize());
        }
        if (this.i != null) {
            a2.put("placement", n());
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    /* access modifiers changed from: protected */
    public final void a(int i, String str, boolean z) {
        if (this.t) {
            if (!z) {
                this.p.c.b(com.ironsource.mediationsdk.utils.d.a(this.k), i, str);
                C0227q.a().a(this.l.a(), new IronSourceError(i, str), true);
            }
            if (this.t) {
                a(d.a.SHOWING);
            }
            this.n.b();
            return;
        }
        super.a(i, str, z);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, C0221k kVar, C0214d dVar) {
        if (this.e != null) {
            IronSourceBannerLayout ironSourceBannerLayout = this.a;
            kVar.a((ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) ? null : this.a.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? C0224n.a() : ISBannerSize.BANNER : this.a.getSize());
            this.e.a(context, kVar, dVar);
            return;
        }
        IronLog.INTERNAL.error(a("mAuctionHandler is null"));
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout) {
        try {
            if (!b(ironSourceBannerLayout)) {
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                String format = String.format("can't destroy banner - %s", objArr);
                IronLog.API.error("destroy banner failed - errorMessage = " + format);
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            a aVar = this.n;
            if (aVar.a.a == a.C0109a.MANUAL_WITH_AUTOMATIC_RELOAD) {
                aVar.c.a();
            }
            com.ironsource.mediationsdk.adunit.d.b bVar = (com.ironsource.mediationsdk.adunit.d.b) this.b.c;
            if (bVar != null) {
                this.p.c.a(bVar.t() != null ? bVar.t().intValue() : this.s.a(this.l.a()));
                bVar.c();
                this.b.a((com.ironsource.mediationsdk.adunit.d.a.c<?>) null);
            }
            C0224n.b(ironSourceBannerLayout);
            this.a = null;
            this.i = null;
            this.t = false;
            a(d.a.READY_TO_LOAD);
        } catch (Throwable th) {
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.m;
            IronLog.INTERNAL.error(a(str));
            if (this.p != null) {
                this.p.g.n(str);
            }
        }
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout, Placement placement) {
        String str;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placement = " + placement);
        int i = 510;
        if (!b(ironSourceBannerLayout)) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        } else if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
            i = com.ironsource.mediationsdk.adunit.a.a.b(this.l.a());
        } else if (j.a(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName(), this.l.a())) {
            str = String.format("placement %s is capped", new Object[]{placement.getPlacementName()});
            i = com.ironsource.mediationsdk.adunit.a.a.f(this.l.a());
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(a(str));
            a(i, str, false);
            return;
        }
        this.a = ironSourceBannerLayout;
        this.i = placement;
        i();
    }

    public final void a(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        this.q.e(this.b.a(cVar.q()));
    }

    public final void a(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("mState = " + this.m);
        super.f(cVar);
        if (a(d.a.READY_TO_SHOW, d.a.SHOWING)) {
            this.b.a(cVar);
            C0224n.a(this.a, view, layoutParams);
            this.n.b();
            this.q.a(this.b.a(cVar.q()), this.t);
        }
    }

    /* access modifiers changed from: protected */
    public final com.ironsource.mediationsdk.adunit.c.d.a b() {
        return new com.ironsource.mediationsdk.adunit.c.d.b();
    }

    public final void b(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        this.q.f(this.b.a(cVar.q()));
    }

    public final void c(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.o()));
        this.q.d(this.b.a(cVar.q()));
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return this.t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099 A[Catch:{ all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r5 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = r5.m()
            r0.verbose(r1)
            com.ironsource.mediationsdk.IronSourceBannerLayout r0 = r5.a     // Catch:{ all -> 0x00af }
            if (r0 != 0) goto L_0x001e
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00af }
            java.lang.String r1 = "mIronSourceBanner is null"
            r0.error(r1)     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.b.d r0 = r5.p     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.b.h r0 = r0.c     // Catch:{ all -> 0x00af }
            r1 = 622(0x26e, float:8.72E-43)
            r0.b(r1)     // Catch:{ all -> 0x00af }
            return
        L_0x001e:
            boolean r0 = r0.isShown()     // Catch:{ all -> 0x00af }
            r1 = 0
            if (r0 != 0) goto L_0x002e
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "banner or one of its parents are INVISIBLE or GONE"
        L_0x0029:
            r0.verbose(r2)     // Catch:{ all -> 0x00af }
            r0 = 0
            goto L_0x005a
        L_0x002e:
            com.ironsource.mediationsdk.IronSourceBannerLayout r0 = r5.a     // Catch:{ all -> 0x00af }
            boolean r0 = r0.hasWindowFocus()     // Catch:{ all -> 0x00af }
            if (r0 != 0) goto L_0x003b
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "banner has no window focus"
            goto L_0x0029
        L_0x003b:
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ all -> 0x00af }
            r0.<init>()     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.IronSourceBannerLayout r2 = r5.a     // Catch:{ all -> 0x00af }
            boolean r0 = r2.getGlobalVisibleRect(r0)     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "visible = "
            r3.<init>(r4)     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00af }
            r2.verbose(r3)     // Catch:{ all -> 0x00af }
        L_0x005a:
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r5.r     // Catch:{ all -> 0x00af }
            monitor-enter(r0)     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.SHOWING     // Catch:{ all -> 0x0096 }
            com.ironsource.mediationsdk.adunit.c.d$a r3 = com.ironsource.mediationsdk.adunit.c.d.a.READY_TO_LOAD     // Catch:{ all -> 0x0096 }
            boolean r2 = r5.a((com.ironsource.mediationsdk.adunit.c.d.a) r2, (com.ironsource.mediationsdk.adunit.c.d.a) r3)     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x0075
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "start reload"
            r1.verbose(r2)     // Catch:{ all -> 0x0096 }
            r1 = 1
            r5.t = r1     // Catch:{ all -> 0x0096 }
            goto L_0x008b
        L_0x0075:
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "wrong state = "
            r3.<init>(r4)     // Catch:{ all -> 0x0096 }
            com.ironsource.mediationsdk.adunit.c.d$a r4 = r5.m     // Catch:{ all -> 0x0096 }
            r3.append(r4)     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0096 }
            r2.error(r3)     // Catch:{ all -> 0x0096 }
        L_0x008b:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0095
            com.ironsource.mediationsdk.IronSourceBannerLayout r0 = r5.a     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.model.Placement r1 = r5.i     // Catch:{ all -> 0x00af }
            r5.a((com.ironsource.mediationsdk.IronSourceBannerLayout) r0, (com.ironsource.mediationsdk.model.Placement) r1)     // Catch:{ all -> 0x00af }
        L_0x0095:
            return
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r1     // Catch:{ all -> 0x00af }
        L_0x0099:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00af }
            java.lang.String r1 = "banner is not visible, reload skipped"
            r0.verbose(r1)     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.b.d r0 = r5.p     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.b.h r0 = r0.c     // Catch:{ all -> 0x00af }
            r1 = 613(0x265, float:8.59E-43)
            r0.b(r1)     // Catch:{ all -> 0x00af }
            com.ironsource.mediationsdk.adunit.c.a r0 = r5.n     // Catch:{ all -> 0x00af }
            r0.b()     // Catch:{ all -> 0x00af }
            return
        L_0x00af:
            r0 = move-exception
            com.ironsource.mediationsdk.adunit.b.d r1 = r5.p
            com.ironsource.mediationsdk.adunit.b.j r1 = r1.g
            java.lang.String r0 = r0.getMessage()
            r1.q(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.b.d():void");
    }

    /* access modifiers changed from: protected */
    public final void d(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public final void e(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar) {
    }

    /* access modifiers changed from: protected */
    public final String f() {
        return "BN";
    }
}
