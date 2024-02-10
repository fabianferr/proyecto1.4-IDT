package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private final m a;
    private final u b;
    private final AtomicBoolean c = new AtomicBoolean();
    private final JSONArray d = new JSONArray();
    private final LinkedHashSet<String> e = new LinkedHashSet<>();
    private final Object f = new Object();
    private List<f> g;

    public e(m mVar) {
        this.a = mVar;
        this.b = mVar.A();
    }

    private List<f> a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new f(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.a));
        }
        return arrayList;
    }

    public void a(Activity activity) {
        if (this.c.compareAndSet(false, true)) {
            String str = (String) this.a.a(d.y);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<f> a2 = a(JsonUtils.getJSONArray(jSONObject, this.a.J().a() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.g = a2;
                    this.a.S().a((a) new com.applovin.impl.mediation.c.a(a2, activity, this.a));
                } catch (JSONException e2) {
                    if (u.a()) {
                        this.b.b("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.f) {
                z = !a(fVar);
                if (z) {
                    this.e.add(fVar.M());
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, "class", fVar.M());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putString(jSONObject, AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, JSONObject.quote(str));
                    this.d.put(jSONObject);
                }
            }
            if (z) {
                this.a.a(fVar);
                this.a.E().processAdapterInitializationPostback(fVar, j, initializationStatus, str);
                this.a.ag().a(initializationStatus, fVar.M());
            }
        }
    }

    public void a(f fVar, Activity activity) {
        a(fVar, activity, (Runnable) null);
    }

    public void a(f fVar, Activity activity, Runnable runnable) {
        List<f> list;
        if (this.a.J().a() && (list = this.g) != null) {
            Iterator<f> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                f next = it.next();
                if (next.M().equals(fVar.M())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar != null) {
            g a2 = this.a.C().a(fVar);
            if (a2 != null) {
                if (u.a()) {
                    u uVar = this.b;
                    uVar.c("MediationAdapterInitializationManager", "Initializing adapter " + fVar);
                }
                a2.a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.a(fVar), activity, runnable);
            } else if (runnable != null) {
                runnable.run();
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        this.a.ag().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }

    public boolean a() {
        return this.c.get();
    }

    /* access modifiers changed from: package-private */
    public boolean a(f fVar) {
        boolean contains;
        synchronized (this.f) {
            contains = this.e.contains(fVar.M());
        }
        return contains;
    }

    public LinkedHashSet<String> b() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f) {
            linkedHashSet = this.e;
        }
        return linkedHashSet;
    }

    public JSONArray c() {
        JSONArray jSONArray;
        synchronized (this.f) {
            jSONArray = this.d;
        }
        return jSONArray;
    }
}
