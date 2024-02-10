package com.applovin.impl.sdk;

import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import java.util.Map;

public class v {
    private final u a;
    private final Map<String, a> b = CollectionUtils.map(4);
    private final Object c = new Object();

    v(m mVar) {
        this.a = mVar.A();
    }

    public a a(String str) {
        a aVar;
        synchronized (this.c) {
            aVar = this.b.get(str);
        }
        return aVar;
    }

    public void a(a aVar) {
        synchronized (this.c) {
            if (u.a()) {
                u uVar = this.a;
                uVar.b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            }
            this.b.put(aVar.getAdUnitId(), aVar);
        }
    }

    public void b(a aVar) {
        synchronized (this.c) {
            String adUnitId = aVar.getAdUnitId();
            f fVar = this.b.get(adUnitId);
            if (aVar == fVar) {
                if (u.a()) {
                    u uVar = this.a;
                    uVar.b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + fVar);
                }
                this.b.remove(adUnitId);
            } else if (u.a()) {
                u uVar2 = this.a;
                uVar2.b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + fVar);
            }
        }
    }
}
