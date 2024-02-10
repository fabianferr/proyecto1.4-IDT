package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class O implements m.a {
    private String a;
    protected AbstractAdapter c;
    protected a d;
    boolean e;
    protected JSONObject f;
    protected int g;
    protected Long h = null;

    O(a aVar, AbstractAdapter abstractAdapter) {
        this.d = aVar;
        this.c = abstractAdapter;
        this.f = aVar.b;
    }

    private String a() {
        return this.d.a.isMultipleInstances() ? this.d.a.getProviderTypeForReflection() : this.d.a.getProviderName();
    }

    public final void a(String str) {
        C0215e.a();
        this.a = C0215e.d(str);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, e() + " " + n() + " : " + str, i);
    }

    public int c() {
        return 1;
    }

    public abstract IronSource.AD_UNIT d();

    public abstract String e();

    public void f() {
        try {
            AbstractAdapter abstractAdapter = this.c;
            if (abstractAdapter != null) {
                abstractAdapter.releaseMemory(this.d.c, this.f);
            }
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception - " + th.getMessage());
        }
        this.c = null;
    }

    public final boolean h() {
        return this.d.d;
    }

    public final boolean i() {
        return this.d.e;
    }

    public final boolean j() {
        if (k()) {
            return false;
        }
        return h() || i();
    }

    public final boolean k() {
        IronLog.INTERNAL.verbose();
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !this.c.isUsingActivityBeforeImpression(d())) {
                return false;
            }
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(this.d.a.getProviderName() + " - is using activity before impression and activity is null");
            return true;
        } catch (Throwable th) {
            a("Exception while calling adapter.isUsingActivityBeforeImpression() - " + th.getLocalizedMessage(), 3);
            return true;
        }
    }

    public final int l() {
        return this.d.f;
    }

    public final int m() {
        return this.d.g;
    }

    public final String n() {
        return this.d.a.getProviderName();
    }

    public final String o() {
        return this.d.a.getProviderTypeForReflection();
    }

    public final int p() {
        return this.g;
    }

    public final Map<String, Object> q() {
        HashMap hashMap = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.c;
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : str);
            AbstractAdapter abstractAdapter2 = this.c;
            if (abstractAdapter2 != null) {
                str = abstractAdapter2.getCoreSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.d.a.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.d.a.getAdSourceNameForEvents());
            hashMap.put("instanceType", Integer.valueOf(h() ? 2 : 1));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(c()));
            if (!TextUtils.isEmpty(this.a)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.a);
            }
        } catch (Throwable th) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "getProviderEventData " + n() + ")", th);
        }
        return hashMap;
    }

    public final Long r() {
        return this.h;
    }

    public final String s() {
        return String.format("%s %s", new Object[]{a(), Integer.valueOf(hashCode())});
    }
}
