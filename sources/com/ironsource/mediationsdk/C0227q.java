package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ironsource.mediationsdk.q  reason: case insensitive filesystem */
public final class C0227q {
    private static final C0227q a = new C0227q();
    private final Map<String, Long> b = new HashMap();
    /* access modifiers changed from: private */
    public final Map<String, Boolean> c = new HashMap();
    private int d;
    private int e;
    private int f;

    private C0227q() {
    }

    public static synchronized C0227q a() {
        C0227q qVar;
        synchronized (C0227q.class) {
            qVar = a;
        }
        return qVar;
    }

    /* access modifiers changed from: private */
    public void b(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, boolean z) {
        this.b.put(ad_unit.toString(), Long.valueOf(System.currentTimeMillis()));
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            P.a().a(ironSourceError);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            C0231u.a().a(ironSourceError);
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            C0222l.a().a(ironSourceError, z);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + ad_unit);
        }
    }

    public final void a(IronSource.AD_UNIT ad_unit, int i) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.e = i;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.d = i;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.f = i;
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + ad_unit);
        }
    }

    public final synchronized void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        a(ad_unit, ironSourceError, false);
    }

    public final synchronized void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, boolean z) {
        int i;
        if (!a(ad_unit)) {
            final String ad_unit2 = ad_unit.toString();
            if (!this.b.containsKey(ad_unit2)) {
                b(ad_unit, ironSourceError, z);
                return;
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                i = this.e;
            } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                i = this.d;
            } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
                i = this.f;
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.warning("ad unit not supported - " + ad_unit);
                i = 0;
            }
            long j = ((long) i) * 1000;
            long currentTimeMillis = System.currentTimeMillis() - this.b.get(ad_unit2).longValue();
            if (currentTimeMillis > j) {
                b(ad_unit, ironSourceError, z);
                return;
            }
            this.c.put(ad_unit2, Boolean.TRUE);
            long j2 = j - currentTimeMillis;
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("delaying callback by " + j2);
            final IronSource.AD_UNIT ad_unit3 = ad_unit;
            final IronSourceError ironSourceError2 = ironSourceError;
            final boolean z2 = z;
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    IronLog.INTERNAL.verbose("onAdLoadFailed - invokeCallback after delaying");
                    C0227q.this.b(ad_unit3, ironSourceError2, z2);
                    C0227q.this.c.put(ad_unit2, Boolean.FALSE);
                }
            }, j2);
        }
    }

    public final synchronized boolean a(IronSource.AD_UNIT ad_unit) {
        if (!this.c.containsKey(ad_unit.toString())) {
            return false;
        }
        return this.c.get(ad_unit.toString()).booleanValue();
    }
}
