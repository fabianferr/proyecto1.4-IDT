package com.ironsource.mediationsdk.adunit.d.a;

import android.app.Activity;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.b.j;
import com.ironsource.mediationsdk.adunit.c.b.b;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Locale;

public abstract class a<Listener extends b> extends c<Listener> implements AdapterAdInteractionListener {
    public a(com.ironsource.mediationsdk.adunit.d.a aVar, BaseAdAdapter<?, ?> baseAdAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        super(aVar, baseAdAdapter, aVar2, listener);
    }

    public final void a(Activity activity, Placement placement) {
        int i;
        IronLog.INTERNAL.verbose(b("placementName = " + placement.getPlacementName()));
        try {
            this.h = placement;
            a(c.a.SHOWING);
            this.f.f.a(activity, x());
            if (this.e instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) this.e).showAd(this.i, this);
                return;
            }
            IronLog.INTERNAL.error(b("showAd - adapter not instance of AdapterAdFullScreenInterface"));
            if (this.f != null) {
                this.f.g.n("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            a(c.a.FAILED);
            String str = "showAd - exception = " + th.getLocalizedMessage() + " - state = " + this.g;
            IronLog.INTERNAL.error(b(str));
            if (this.f != null) {
                this.f.g.n(str);
            }
            IronSource.AD_UNIT ad_unit = this.c.a;
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                i = 1038;
            } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                i = IronSourceError.ERROR_IS_SHOW_EXCEPTION;
            } else {
                IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
                i = 510;
            }
            onAdShowFailed(i, str);
        }
    }

    public final void a(boolean z) {
        if (this.f != null) {
            this.f.f.a(z);
        }
    }

    public final boolean b_() {
        if (this.i == null || !g()) {
            return false;
        }
        try {
            if (this.e instanceof AdapterAdFullScreenInterface) {
                return ((AdapterAdFullScreenInterface) this.e).isAdAvailable(this.i);
            }
            IronLog.INTERNAL.error(b("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
            if (this.f != null) {
                this.f.g.n("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
            }
            return false;
        } catch (Throwable th) {
            String str = "isReadyToShow - exception = " + th.getLocalizedMessage() + " - state = " + this.g;
            IronLog.INTERNAL.error(b(str));
            if (this.f != null) {
                this.f.g.n(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        ((com.ironsource.mediationsdk.adunit.c.b.b) r5.d).b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdClosed() {
        /*
            r5 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = r5.w()
            r0.verbose(r1)
            java.lang.Object r0 = r5.j
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = r5.g     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r2 = com.ironsource.mediationsdk.adunit.d.a.c.a.SHOWING     // Catch:{ all -> 0x0091 }
            if (r1 != r2) goto L_0x0067
            com.ironsource.mediationsdk.adunit.d.a.c$a r1 = com.ironsource.mediationsdk.adunit.d.a.c.a.NONE     // Catch:{ all -> 0x0091 }
            r5.a((com.ironsource.mediationsdk.adunit.d.a.c.a) r1)     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.b.d r1 = r5.f     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = ""
            com.ironsource.mediationsdk.adunit.d.a r2 = r5.c     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.a     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x0091 }
            if (r2 != r3) goto L_0x0053
            com.ironsource.mediationsdk.adunit.c.b.c r1 = r5.d     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.c.b.b r1 = (com.ironsource.mediationsdk.adunit.c.b.b) r1     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r1.h()     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "otherInstanceAvailable = "
            r2.<init>(r3)     // Catch:{ all -> 0x0091 }
            int r3 = r1.length()     // Catch:{ all -> 0x0091 }
            if (r3 <= 0) goto L_0x004a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "true|"
            r3.<init>(r4)     // Catch:{ all -> 0x0091 }
            r3.append(r1)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0091 }
            goto L_0x004c
        L_0x004a:
            java.lang.String r1 = "false"
        L_0x004c:
            r2.append(r1)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0091 }
        L_0x0053:
            com.ironsource.mediationsdk.adunit.b.d r2 = r5.f     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.b.a r2 = r2.f     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r5.x()     // Catch:{ all -> 0x0091 }
            r2.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ all -> 0x0091 }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.c.b.c r0 = r5.d
            com.ironsource.mediationsdk.adunit.c.b.b r0 = (com.ironsource.mediationsdk.adunit.c.b.b) r0
            r0.b(r5)
            return
        L_0x0067:
            com.ironsource.mediationsdk.adunit.b.d r1 = r5.f     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x008f
            com.ironsource.mediationsdk.adunit.b.d r1 = r5.f     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.b.j r1 = r1.g     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "unexpected closed for "
            r2.<init>(r3)     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r5.o()     // Catch:{ all -> 0x0091 }
            r2.append(r3)     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = " - state = "
            r2.append(r3)     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.adunit.d.a.c$a r3 = r5.g     // Catch:{ all -> 0x0091 }
            r2.append(r3)     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0091 }
            r1.k(r2)     // Catch:{ all -> 0x0091 }
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return
        L_0x0091:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.d.a.a.onAdClosed():void");
    }

    public void onAdEnded() {
        IronLog.INTERNAL.verbose(w());
        if (this.f != null) {
            this.f.f.e(x());
        }
        ((b) this.d).d(this);
    }

    public void onAdShowFailed(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("error = " + i + ", " + str));
        if (this.g == c.a.SHOWING) {
            a(c.a.FAILED);
            if (this.f != null) {
                this.f.f.a(x(), i, str, "");
            }
            ((b) this.d).a(new IronSourceError(i, str), this);
        } else if (this.f != null) {
            j jVar = this.f.g;
            String o = o();
            c.a aVar = this.g;
            jVar.j(String.format(Locale.ENGLISH, "unexpected show failed for %s, state - %s, error - %d %s", new Object[]{o, aVar, Integer.valueOf(i), str}));
        }
    }

    public void onAdShowSuccess() {
        IronLog.INTERNAL.verbose(w());
        if (this.f != null) {
            this.f.f.a(x());
        }
        ((b) this.d).a(this);
    }

    public void onAdStarted() {
        IronLog.INTERNAL.verbose(w());
        if (this.f != null) {
            this.f.f.d(x());
        }
        ((b) this.d).c(this);
    }

    public void onAdVisible() {
        IronLog.INTERNAL.verbose(w());
        if (this.f != null) {
            this.f.f.f(x());
        }
    }
}
