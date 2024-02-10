package com.ironsource.mediationsdk.adunit.c;

import com.facebook.internal.security.CertificateUtil;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0218h;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.c.b.b;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.adunit.c.d;
import com.ironsource.mediationsdk.adunit.d.a.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;

public abstract class c<Smash extends a<?>, Listener extends AdapterAdInteractionListener> extends d<Smash, Listener> implements b {
    protected c(com.ironsource.mediationsdk.adunit.c.a.a aVar, com.ironsource.mediationsdk.d.c cVar, IronSourceSegment ironSourceSegment, boolean z) {
        super(aVar, cVar, ironSourceSegment, z);
    }

    private static String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.j() != null) {
                sb.append(smash.n());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(smash.j());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void a(Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash == null || smash2 != smash) {
                smash2.a(false);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(a(smash2.o() + " - not ready to show"));
            } else {
                smash.a(true);
                return;
            }
        }
    }

    private void a(IronSourceError ironSourceError, String str) {
        this.p.f.a(n(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.n.a();
        this.q.a(ironSourceError, this.b.a(this.b.b));
        if (this.l.h().b()) {
            a(false, false);
        }
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [com.ironsource.mediationsdk.adunit.d.a.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r8, com.ironsource.mediationsdk.model.Placement r9) {
        /*
            r7 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "state = "
            r1.<init>(r2)
            com.ironsource.mediationsdk.adunit.c.d$a r2 = r7.m
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r7.a((java.lang.String) r1)
            r0.verbose(r1)
            java.lang.Object r0 = r7.r
            monitor-enter(r0)
            r7.i = r9     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.b.d r1 = r7.p     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.b.a r1 = r1.f     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r7.n()     // Catch:{ all -> 0x0132 }
            r1.a((android.app.Activity) r8, (java.lang.String) r2)     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r7.m     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.SHOWING     // Catch:{ all -> 0x0132 }
            r3 = 0
            if (r1 != r2) goto L_0x0062
            java.lang.String r9 = "can't show ad while an ad is already showing"
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r7.l     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a()     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x0132 }
            if (r2 != r4) goto L_0x0042
            r2 = 1022(0x3fe, float:1.432E-42)
            goto L_0x005e
        L_0x0042:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x0132 }
            if (r2 != r4) goto L_0x0049
            r2 = 1036(0x40c, float:1.452E-42)
            goto L_0x005e
        L_0x0049:
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0132 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            java.lang.String r6 = "ad unit not supported - "
            r5.<init>(r6)     // Catch:{ all -> 0x0132 }
            r5.append(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0132 }
            r4.warning(r2)     // Catch:{ all -> 0x0132 }
            r2 = 510(0x1fe, float:7.15E-43)
        L_0x005e:
            r1.<init>(r2, r9)     // Catch:{ all -> 0x0132 }
            goto L_0x00c6
        L_0x0062:
            com.ironsource.mediationsdk.adunit.c.d$a r1 = r7.m     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.d$a r2 = com.ironsource.mediationsdk.adunit.c.d.a.READY_TO_SHOW     // Catch:{ all -> 0x0132 }
            if (r1 == r2) goto L_0x0072
            java.lang.String r9 = "show called while no ads are available"
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0132 }
            r2 = 509(0x1fd, float:7.13E-43)
            r1.<init>(r2, r9)     // Catch:{ all -> 0x0132 }
            goto L_0x00c6
        L_0x0072:
            if (r9 != 0) goto L_0x0086
            java.lang.String r9 = "empty default placement"
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r7.l     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a()     // Catch:{ all -> 0x0132 }
            int r2 = com.ironsource.mediationsdk.adunit.a.a.b(r2)     // Catch:{ all -> 0x0132 }
            r1.<init>(r2, r9)     // Catch:{ all -> 0x0132 }
            goto L_0x00c6
        L_0x0086:
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0132 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r9.getPlacementName()     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.a.a r4 = r7.l     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = r4.a()     // Catch:{ all -> 0x0132 }
            boolean r1 = com.ironsource.mediationsdk.utils.j.a((android.content.Context) r1, (java.lang.String) r2, (com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x0132 }
            if (r1 == 0) goto L_0x00c5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = "placement "
            r1.<init>(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = r9.getPlacementName()     // Catch:{ all -> 0x0132 }
            r1.append(r9)     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = " is capped"
            r1.append(r9)     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r7.l     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a()     // Catch:{ all -> 0x0132 }
            int r2 = com.ironsource.mediationsdk.adunit.a.a.f(r2)     // Catch:{ all -> 0x0132 }
            r1.<init>(r2, r9)     // Catch:{ all -> 0x0132 }
            goto L_0x00c6
        L_0x00c5:
            r1 = r3
        L_0x00c6:
            if (r1 == 0) goto L_0x00db
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r1.getErrorMessage()     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r7.a((java.lang.String) r2)     // Catch:{ all -> 0x0132 }
            r9.error(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = ""
        L_0x00d7:
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r1, (java.lang.String) r9)     // Catch:{ all -> 0x0132 }
            goto L_0x0118
        L_0x00db:
            com.ironsource.mediationsdk.adunit.e.c r9 = r7.b     // Catch:{ all -> 0x0132 }
            java.util.List r9 = r9.a()     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.e.f r1 = new com.ironsource.mediationsdk.adunit.e.f     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r7.l     // Catch:{ all -> 0x0132 }
            r1.<init>(r2)     // Catch:{ all -> 0x0132 }
            java.util.concurrent.ConcurrentHashMap r2 = r7.c     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.adunit.d.a.c r1 = r1.b(r9, r2)     // Catch:{ all -> 0x0132 }
            r3 = r1
            com.ironsource.mediationsdk.adunit.d.a.a r3 = (com.ironsource.mediationsdk.adunit.d.a.a) r3     // Catch:{ all -> 0x0132 }
            java.util.concurrent.ConcurrentHashMap r1 = r7.c     // Catch:{ all -> 0x0132 }
            java.util.List r1 = com.ironsource.mediationsdk.adunit.e.f.a(r9, r1)     // Catch:{ all -> 0x0132 }
            r7.a(r3, r1)     // Catch:{ all -> 0x0132 }
            if (r3 == 0) goto L_0x0105
            com.ironsource.mediationsdk.adunit.c.d$a r9 = com.ironsource.mediationsdk.adunit.c.d.a.SHOWING     // Catch:{ all -> 0x0132 }
            r7.a((com.ironsource.mediationsdk.adunit.c.d.a) r9)     // Catch:{ all -> 0x0132 }
            r7.i(r3)     // Catch:{ all -> 0x0132 }
            goto L_0x0118
        L_0x0105:
            com.ironsource.mediationsdk.adunit.c.a.a r1 = r7.l     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = r1.a()     // Catch:{ all -> 0x0132 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0132 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r1)     // Catch:{ all -> 0x0132 }
            java.lang.String r9 = a(r9)     // Catch:{ all -> 0x0132 }
            goto L_0x00d7
        L_0x0118:
            monitor-exit(r0)     // Catch:{ all -> 0x0132 }
            if (r3 == 0) goto L_0x0131
            com.ironsource.mediationsdk.model.Placement r9 = r7.i
            com.ironsource.mediationsdk.adunit.c.a.a r0 = r7.l
            com.ironsource.mediationsdk.adunit.c.c.a r0 = r0.h()
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x012e
            com.ironsource.mediationsdk.r r0 = r7.o
            r0.a()
        L_0x012e:
            r3.a(r8, r9)
        L_0x0131:
            return
        L_0x0132:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0132 }
            goto L_0x0136
        L_0x0135:
            throw r8
        L_0x0136:
            goto L_0x0135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.c.a(android.app.Activity, com.ironsource.mediationsdk.model.Placement):void");
    }

    public final void a(a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.o()));
        this.q.b(this.b.a(aVar.q()));
    }

    public final void a(IronSourceError ironSourceError, a<?> aVar) {
        com.ironsource.mediationsdk.adunit.a.a aVar2;
        if (this.l.m() && (aVar2 = (com.ironsource.mediationsdk.adunit.a.a) this.c.get(aVar.n())) != null) {
            this.b.a(this.b.b, aVar2.a(n()));
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(aVar.o() + " - error = " + ironSourceError));
        this.d.put(aVar.n(), C0218h.a.ISAuctionPerformanceFailedToShow);
        a(d.a.READY_TO_LOAD);
        a(ironSourceError, "");
    }

    public final void b(a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.o()));
        if (this.m == d.a.SHOWING) {
            a(d.a.READY_TO_LOAD);
        }
        a aVar2 = this.n;
        if (aVar2.a.a == a.C0109a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            aVar2.a(aVar2.a.b);
        }
        this.q.g(this.b.a(aVar.q()));
    }

    public final void c(com.ironsource.mediationsdk.adunit.d.a.a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.o()));
        this.q.a();
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return false;
    }

    public final void d(com.ironsource.mediationsdk.adunit.d.a.a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.o()));
        this.q.b();
    }

    public final boolean g() {
        if (!j()) {
            return false;
        }
        if (this.j && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        for (com.ironsource.mediationsdk.adunit.d.a.a b_ : this.b.a()) {
            if (b_.b_()) {
                return true;
            }
        }
        return false;
    }

    public final String h() {
        StringBuilder sb = new StringBuilder();
        if (this.m == d.a.READY_TO_SHOW) {
            for (com.ironsource.mediationsdk.adunit.d.a.a aVar : this.b.a()) {
                if (aVar.g()) {
                    sb.append(aVar.n());
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }
}
