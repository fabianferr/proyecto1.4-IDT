package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.d.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class j {
    protected AbstractAdapter a;
    protected com.ironsource.mediationsdk.model.a b;
    protected JSONObject c;
    long d;
    protected String e;
    protected JSONObject f;
    protected List<String> g;
    protected String h;
    private a i;
    private Timer j;
    private final Object k = new Object();
    private final Object l = new Object();

    public enum a {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public j(com.ironsource.mediationsdk.model.a aVar, AbstractAdapter abstractAdapter) {
        this.b = aVar;
        this.a = abstractAdapter;
        this.c = aVar.b;
        this.i = a.NOT_LOADED;
        this.j = null;
        this.e = "";
        this.f = null;
        this.g = new ArrayList();
    }

    protected static void a(List<String> list, String str, int i2, String str2, String str3) {
        for (String a2 : (List) b.a(list, new ArrayList())) {
            C0215e.a();
            String a3 = C0215e.a(a2, str, i2, str2, "", "", "", "");
            C0215e.a();
            C0215e.a(str3, str, a3);
        }
    }

    /* access modifiers changed from: package-private */
    public final a a(a[] aVarArr, a aVar) {
        a aVar2;
        synchronized (this.k) {
            aVar2 = this.i;
            if (Arrays.asList(aVarArr).contains(this.i)) {
                a(aVar);
            }
        }
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        IronLog.INTERNAL.verbose("DemandOnlySmash " + this.b.a.getProviderName() + ": current state=" + this.i + ", new state=" + aVar);
        synchronized (this.k) {
            this.i = aVar;
        }
    }

    public final void a(String str) {
        C0215e.a();
        this.h = C0215e.d(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(TimerTask timerTask) {
        synchronized (this.l) {
            j();
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(timerTask, this.d);
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public final void a(boolean z) {
        try {
            this.c.put("isOneFlow", z);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("Can't set isOneFlow = " + z + ". Error: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(a aVar, a aVar2) {
        synchronized (this.k) {
            if (this.i != aVar) {
                return false;
            }
            a(aVar2);
            return true;
        }
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.a;
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : str);
            AbstractAdapter abstractAdapter2 = this.a;
            if (abstractAdapter2 != null) {
                str = abstractAdapter2.getCoreSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.b.a.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a.getAdSourceNameForEvents());
            hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (this.b.d) {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                hashMap.put("instanceType", 2);
                if (!TextUtils.isEmpty(this.e)) {
                    hashMap.put("auctionId", this.e);
                }
                JSONObject jSONObject = this.f;
                if (jSONObject != null && jSONObject.length() > 0) {
                    hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
                }
            } else {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 0);
                hashMap.put("instanceType", 1);
            }
            if (!TextUtils.isEmpty(this.h)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.h);
            }
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "getProviderEventData " + e() + ")", e2);
        }
        return hashMap;
    }

    public final void b(String str) {
        this.e = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(a aVar) {
        boolean z;
        synchronized (this.k) {
            z = this.i == aVar;
        }
        return z;
    }

    public final String e() {
        return this.b.a.getProviderName();
    }

    public final int f() {
        return this.b.f;
    }

    public final String g() {
        return this.b.a.getSubProviderId();
    }

    public final boolean h() {
        return this.c.optBoolean("isOneFlow", false);
    }

    /* access modifiers changed from: package-private */
    public final String i() {
        a aVar = this.i;
        return aVar == null ? AbstractJsonLexerKt.NULL : aVar.toString();
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        synchronized (this.l) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }
    }

    public final boolean k() {
        return this.b.d;
    }
}
