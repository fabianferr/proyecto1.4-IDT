package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.C0217g;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.d;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    public ConcurrentHashMap<String, d> a = new ConcurrentHashMap<>();
    public e b;

    public c(List<NetworkSettings> list, d dVar, String str, String str2, e eVar) {
        d dVar2 = dVar;
        String sessionId = IronSourceUtils.getSessionId();
        boolean z = dVar2.j;
        this.b = eVar;
        C0216f fVar = new C0216f(new C0217g(dVar2.i, z, sessionId));
        for (NetworkSettings next : list) {
            if (next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter a2 = C0213c.a().a(next, next.getBannerSettings(), true, false);
                if (a2 != null) {
                    d dVar3 = new d(str, str2, next, dVar2.c, a2, fVar);
                    dVar3.a(z);
                    this.a.put(dVar3.g(), dVar3);
                }
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    public final void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            this.b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_LOAD, str);
            IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.BANNER_AD_UNIT);
            IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
            iSDemandOnlyBannerLayout.getListener().a(str, buildNonExistentInstanceError);
            return;
        }
        dVar.a(iSDemandOnlyBannerLayout);
    }

    public final synchronized void a(String str) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            this.b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_DESTROY, str);
            IronLog.API.error(ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.BANNER_AD_UNIT).getErrorMessage());
            return;
        }
        dVar.a();
    }
}
