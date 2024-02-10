package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.C0217g;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.h;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.e;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class f {
    public final e a;
    public final ConcurrentHashMap<String, g> b;
    private final n<ISDemandOnlyInterstitialListener> c;
    private final a d = MediationServices.getProvider().getSessionDepthService();
    private final a.C0114a e = MediationServices.getEditor().getSessionDepthServiceEditor();

    public f(List<NetworkSettings> list, h hVar, C0213c cVar, n nVar, String str, String str2, e eVar) {
        h hVar2 = hVar;
        String sessionId = IronSourceUtils.getSessionId();
        boolean z = hVar2.h;
        C0217g gVar = new C0217g(hVar2.g, z, sessionId);
        this.b = new ConcurrentHashMap<>();
        this.a = eVar;
        this.c = nVar;
        for (NetworkSettings next : list) {
            if (next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter a2 = cVar.a(next, next.getInterstitialSettings(), true, false);
                if (a2 != null) {
                    String str3 = str;
                    String str4 = str2;
                    NetworkSettings networkSettings = next;
                    g gVar2 = r6;
                    g gVar3 = new g(str3, str4, networkSettings, this.c.a(next.getSubProviderId()), TimeUnit.SECONDS.toMillis((long) hVar2.e), a2, new C0216f(gVar));
                    gVar2.a(z);
                    this.b.put(next.getSubProviderId(), gVar2);
                }
            } else {
                C0213c cVar2 = cVar;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
            hVar2 = hVar;
        }
    }

    public final void a(p.c cVar) {
        String a2 = cVar.a();
        String b2 = cVar.b();
        try {
            g gVar = this.b.get(a2);
            if (gVar == null) {
                this.a.a(2503, a2);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.INTERSTITIAL_AD_UNIT);
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(a2).onInterstitialAdLoadFailed(a2, buildNonExistentInstanceError);
            } else if (TextUtils.isEmpty(b2)) {
                gVar.a();
            } else {
                gVar.a((o) new o.a(IronSourceAES.decode(e.a().b(), b2)));
            }
        } catch (Exception e2) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e2.getMessage());
            IronLog.API.error(buildLoadFailedError.getErrorMessage());
            this.c.a(a2).onInterstitialAdLoadFailed(a2, buildLoadFailedError);
        }
    }

    public final void a(String str) {
        try {
            g gVar = this.b.get(str);
            if (gVar == null) {
                this.a.a(2507, str);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.INTERSTITIAL_AD_UNIT);
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(str).onInterstitialAdShowFailed(str, buildNonExistentInstanceError);
                return;
            }
            gVar.c();
        } catch (Exception e2) {
            IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.INTERSTITIAL_AD_UNIT, "showInterstitial exception " + e2.getMessage());
            IronLog.API.error(buildShowFailedError.getErrorMessage());
            this.c.a(str).onInterstitialAdShowFailed(str, buildShowFailedError);
        }
    }
}
