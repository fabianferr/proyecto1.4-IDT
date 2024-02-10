package com.applovin.impl.mediation.c;

import android.content.Context;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.applovin.impl.sdk.f.a {
    private static String a;
    private static JSONObject c;
    private static final Object d = new Object();
    /* access modifiers changed from: private */
    public final MaxAdFormat e;
    private final Map<String, Object> f;
    /* access modifiers changed from: private */
    public final Context g;
    private final a h;

    public interface a {
        void a(JSONArray jSONArray);
    }

    /* renamed from: com.applovin.impl.mediation.c.b$b  reason: collision with other inner class name */
    private static class C0013b implements g.a, Runnable {
        private final a a;
        private final Object b;
        private int c;
        private final AtomicBoolean d;
        private final Collection<g> e;
        private final u f;

        private C0013b(int i, a aVar, u uVar) {
            this.c = i;
            this.a = aVar;
            this.f = uVar;
            this.b = new Object();
            this.e = new ArrayList(i);
            this.d = new AtomicBoolean();
        }

        private void a() {
            ArrayList<g> arrayList;
            String str;
            String d2;
            synchronized (this.b) {
                arrayList = new ArrayList<>(this.e);
            }
            JSONArray jSONArray = new JSONArray();
            for (g gVar : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    h a2 = gVar.a();
                    jSONObject.put("name", a2.N());
                    jSONObject.put("class", a2.M());
                    jSONObject.put("adapter_version", gVar.c());
                    jSONObject.put("sdk_version", gVar.b());
                    JSONObject jSONObject2 = new JSONObject();
                    if (StringUtils.isValidString(gVar.e())) {
                        str = AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE;
                        d2 = gVar.e();
                    } else {
                        str = "signal";
                        d2 = gVar.d();
                    }
                    jSONObject2.put(str, d2);
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (u.a()) {
                        u uVar = this.f;
                        uVar.b("TaskCollectSignals", "Collected signal from " + a2);
                    }
                } catch (JSONException e2) {
                    if (u.a()) {
                        this.f.b("TaskCollectSignals", "Failed to create signal data", e2);
                    }
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(jSONArray);
            }
        }

        public void a(g gVar) {
            boolean z;
            synchronized (this.b) {
                this.e.add(gVar);
                int i = this.c - 1;
                this.c = i;
                z = i < 1;
            }
            if (z && this.d.compareAndSet(false, true)) {
                a();
            }
        }

        public void run() {
            if (this.d.compareAndSet(false, true)) {
                a();
            }
        }
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public b(MaxAdFormat maxAdFormat, Map<String, Object> map, Context context, m mVar, a aVar) {
        super("TaskCollectSignals", mVar);
        this.e = maxAdFormat;
        this.f = map;
        this.g = context;
        this.h = aVar;
    }

    private static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", 30000);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    private void a(final h hVar, final g.a aVar) {
        if (hVar.U()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    b.this.b.E().collectSignal(b.this.e, hVar, b.this.g, aVar);
                }
            });
        } else {
            this.b.E().collectSignal(this.e, hVar, this.g, aVar);
        }
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        C0013b bVar = new C0013b(jSONArray.length(), this.h, this.b.A());
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new h(this.f, jSONArray.getJSONObject(i), jSONObject, this.b), (g.a) bVar);
        }
        this.b.S().a((com.applovin.impl.sdk.f.a) new z(this.b, bVar), o.a.MAIN, ((Long) this.b.a(com.applovin.impl.sdk.d.a.j)).longValue());
    }

    public static void a(JSONObject jSONObject) {
        synchronized (d) {
            c = jSONObject;
        }
    }

    private void b(String str, Throwable th) {
        if (u.a()) {
            a("No signals collected: " + str, th);
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(new JSONArray());
        }
    }

    public void run() {
        String str;
        JSONArray jSONArray;
        try {
            if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.eX)).booleanValue()) {
                synchronized (d) {
                    jSONArray = JsonUtils.getJSONArray(c, "signal_providers", (JSONArray) null);
                }
                if (jSONArray != null) {
                    if (jSONArray.length() > 0) {
                        a(jSONArray, c);
                        return;
                    }
                }
                if (u.a()) {
                    c("Unable to find cached signal providers, falling back to old logic.");
                }
            }
            JSONObject jSONObject = new JSONObject((String) this.b.b(d.x, a));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", (JSONArray) null);
            if (jSONArray2 != null) {
                if (jSONArray2.length() != 0) {
                    a(jSONArray2, jSONObject);
                    return;
                }
            }
            b("No signal providers found", (Throwable) null);
        } catch (JSONException e2) {
            th = e2;
            str = "Failed to parse signals JSON";
            b(str, th);
        } catch (InterruptedException e3) {
            th = e3;
            str = "Failed to wait for signals";
            b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            b(str, th);
        }
    }
}
