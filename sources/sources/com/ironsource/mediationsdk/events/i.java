package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.b;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public final class i extends b {
    private static i x;
    private String y;
    private final a z = MediationServices.getProvider().getSessionDepthService();

    private i() {
        this.s = "outcome";
        this.r = 3;
        this.t = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.y = "";
    }

    public static synchronized i d() {
        i iVar;
        synchronized (i.class) {
            if (x == null) {
                i iVar2 = new i();
                x = iVar2;
                iVar2.a();
            }
            iVar = x;
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.u.add(1000);
        this.u.add(1001);
        this.u.add(1002);
        this.u.add(1003);
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_READY_TRUE));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_READY_FALSE));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL));
        this.u.add(Integer.valueOf(IronSourceConstants.RV_MEDIATION_LOAD_ERROR));
    }

    /* access modifiers changed from: protected */
    public final boolean c(com.ironsource.environment.c.a aVar) {
        return aVar.a() == 305;
    }

    /* access modifiers changed from: protected */
    public final String d(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.y : "";
    }

    /* access modifiers changed from: protected */
    public final boolean d(com.ironsource.environment.c.a aVar) {
        int a = aVar.a();
        return a == 14 || a == 514 || a == 305 || a == 1003 || a == 1005 || a == 1203 || a == 1010 || a == 1301 || a == 1302;
    }

    /* access modifiers changed from: protected */
    public final int e(com.ironsource.environment.c.a aVar) {
        return this.z.a(b.a(aVar.a(), (IronSource.AD_UNIT) null) == b.a.OFFERWALL.g ? IronSource.AD_UNIT.OFFERWALL : IronSource.AD_UNIT.REWARDED_VIDEO);
    }
}
