package com.applovin.impl.sdk.a;

import com.applovin.array.apphub.aidl.IAppHubService;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;

public class a {
    private final m a;
    private final u b;

    public a(m mVar) {
        this.a = mVar;
        this.b = mVar.A();
    }

    public long a(IAppHubService iAppHubService) {
        if (!((Boolean) this.a.a(b.ap)).booleanValue()) {
            return -1;
        }
        try {
            return iAppHubService.getAppHubVersionCode();
        } catch (Throwable th) {
            this.b.b("ArrayService", "Failed to collect App Hub version code", th);
            return -1;
        }
    }

    public boolean b(IAppHubService iAppHubService) {
        if (!((Boolean) this.a.a(b.aq)).booleanValue()) {
            return false;
        }
        try {
            return iAppHubService.getEnabledFeatures().getBoolean("DIRECT_DOWNLOAD");
        } catch (Throwable th) {
            this.b.b("ArrayService", "Failed to collect App Hub version code", th);
            return false;
        }
    }

    public String c(IAppHubService iAppHubService) {
        if (!((Boolean) this.a.a(b.ar)).booleanValue()) {
            return null;
        }
        try {
            return iAppHubService.getRandomUserToken();
        } catch (Throwable th) {
            this.b.b("ArrayService", "Failed to collect random user token", th);
            return null;
        }
    }
}
