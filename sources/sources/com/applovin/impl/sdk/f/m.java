package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import java.util.Map;
import org.json.JSONObject;

public class m extends a {
    /* access modifiers changed from: private */
    public final a a;

    public interface a {
        void a();
    }

    public m(com.applovin.impl.sdk.m mVar, a aVar) {
        super("TaskFetchVariables", mVar);
        this.a = aVar;
    }

    private Map<String, String> a() {
        return Utils.stringifyObjectMap(this.b.V().a((Map<String, String>) null, false, false));
    }

    public void run() {
        AnonymousClass1 r1 = new u<JSONObject>(c.a(this.b).a(h.k(this.b)).c(h.l(this.b)).a(a()).b("GET").a(new JSONObject()).b(((Integer) this.b.a(b.dd)).intValue()).a(), this.b) {
            public void a(int i, String str, JSONObject jSONObject) {
                if (u.a()) {
                    d("Unable to fetch variables: server returned " + i);
                    u.i("AppLovinVariableService", "Failed to load variables.");
                }
                m.this.a.a();
            }

            public void a(JSONObject jSONObject, int i) {
                h.d(jSONObject, this.b);
                h.c(jSONObject, this.b);
                h.f(jSONObject, this.b);
                h.e(jSONObject, this.b);
                m.this.a.a();
            }
        };
        r1.a(b.aZ);
        r1.b(b.ba);
        this.b.S().a((a) r1);
    }
}
