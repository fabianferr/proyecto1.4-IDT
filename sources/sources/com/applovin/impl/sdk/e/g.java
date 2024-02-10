package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    private final m a;
    private final Map<String, Long> b = CollectionUtils.map();

    public g(m mVar) {
        if (mVar != null) {
            this.a = mVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private void e() {
        try {
            this.a.a(d.q, c().toString());
        } catch (Throwable th) {
            this.a.A().b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    public long a(f fVar) {
        return a(fVar, 1);
    }

    /* access modifiers changed from: package-private */
    public long a(f fVar, long j) {
        long longValue;
        synchronized (this.b) {
            Long l = this.b.get(fVar.a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.b.put(fVar.a(), Long.valueOf(longValue));
        }
        e();
        return longValue;
    }

    public void a() {
        synchronized (this.b) {
            this.b.clear();
        }
        e();
    }

    public long b(f fVar) {
        long longValue;
        synchronized (this.b) {
            Long l = this.b.get(fVar.a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    public void b() {
        synchronized (this.b) {
            for (f a2 : f.b()) {
                this.b.remove(a2.a());
            }
            e();
        }
    }

    public void b(f fVar, long j) {
        synchronized (this.b) {
            this.b.put(fVar.a(), Long.valueOf(j));
        }
        e();
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.b) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.b.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    public void c(f fVar) {
        synchronized (this.b) {
            this.b.remove(fVar.a());
        }
        e();
    }

    public void d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.a.b(d.q, JsonUtils.EMPTY_JSON));
            synchronized (this.b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.a.A().b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
