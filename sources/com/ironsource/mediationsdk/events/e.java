package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.b;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public final class e extends b {
    private static e x;
    private String y;
    private final a z = MediationServices.getProvider().getSessionDepthService();

    private e() {
        this.s = "ironbeast";
        this.r = 2;
        this.t = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.y = "";
    }

    public static synchronized e d() {
        e eVar;
        synchronized (e.class) {
            if (x == null) {
                e eVar2 = new e();
                x = eVar2;
                eVar2.a();
            }
            eVar = x;
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.u.add(2001);
        this.u.add(2002);
        this.u.add(2003);
        this.u.add(2004);
        this.u.add(2200);
        this.u.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL));
        this.u.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_READY_TRUE));
        this.u.add(Integer.valueOf(IronSourceConstants.IS_INSTANCE_READY_FALSE));
        this.u.add(3001);
        this.u.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_LOAD_ERROR));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_RELOAD));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS));
        this.u.add(3002);
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD));
        this.u.add(3005);
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_LOAD_ERROR));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS));
        this.u.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_SHOW));
        this.u.add(4001);
        this.u.add(Integer.valueOf(IronSourceConstants.NT_CALLBACK_LOAD_ERROR));
        this.u.add(4002);
        this.u.add(4005);
        this.u.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.u.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_SHOW));
    }

    /* access modifiers changed from: protected */
    public final boolean c(com.ironsource.environment.c.a aVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String d(int i) {
        return this.y;
    }

    /* access modifiers changed from: protected */
    public final boolean d(com.ironsource.environment.c.a aVar) {
        int a = aVar.a();
        return a == 2004 || a == 2005 || a == 2204 || a == 2301 || a == 2300 || a == 3009 || a == 3502 || a == 3501 || a == 4005 || a == 4009 || a == 4502 || a == 4501;
    }

    /* access modifiers changed from: protected */
    public final int e(com.ironsource.environment.c.a aVar) {
        a aVar2;
        IronSource.AD_UNIT ad_unit;
        int a = b.a(aVar.a(), (IronSource.AD_UNIT) null);
        if (a == b.a.BANNER.g) {
            aVar2 = this.z;
            ad_unit = IronSource.AD_UNIT.BANNER;
        } else if (a == b.a.NATIVE_AD.g) {
            aVar2 = this.z;
            ad_unit = IronSource.AD_UNIT.NATIVE_AD;
        } else {
            aVar2 = this.z;
            ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        }
        return aVar2.a(ad_unit);
    }
}
