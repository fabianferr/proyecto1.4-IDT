package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends a {
    private static final long a = TimeUnit.SECONDS.toMillis(5);
    private final AtomicLong c = new AtomicLong();
    private final f d;
    private final u e;

    g(f fVar, m mVar) {
        super("PersistentPostbackQueueSaveTask", mVar);
        this.e = mVar.A();
        this.d = fVar;
    }

    private void a(List<h> list) {
        JSONArray jSONArray = new JSONArray();
        for (h n : list) {
            try {
                jSONArray.put(n.n());
            } catch (Throwable th) {
                if (u.a()) {
                    this.e.b("PersistentPostbackQueueSaveTask", "Unable to serialize postback request to JSON.", th);
                }
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pb", jSONArray);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
            q ab = this.b.ab();
            ab.a((InputStream) byteArrayInputStream, ab.a("persistent_postback_cache.json", this.b.L()));
            if (u.a()) {
                this.e.b("PersistentPostbackQueueSaveTask", "Wrote updated postback queue to disk.");
            }
        } catch (Throwable th2) {
            if (u.a()) {
                this.e.b("PersistentPostbackQueueSaveTask", "Failed to persist postbacks", th2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<h> a(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        try {
            q ab = this.b.ab();
            if (ab.b("persistent_postback_cache.json", this.b.L())) {
                String a2 = ab.a(ab.a("persistent_postback_cache.json", this.b.L()));
                if (StringUtils.isValidString(a2)) {
                    JSONArray jSONArray = new JSONObject(a2).getJSONArray("pb");
                    if (u.a()) {
                        u uVar = this.e;
                        uVar.b("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s).");
                    }
                    arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
                    int intValue = ((Integer) this.b.a(b.cK)).intValue();
                    for (int i2 = 0; i2 < jSONArray.length() && arrayList.size() < i; i2++) {
                        h hVar = new h(jSONArray.getJSONObject(i2), this.b);
                        if (hVar.k() < intValue) {
                            arrayList.add(hVar);
                        } else if (u.a()) {
                            u uVar2 = this.e;
                            uVar2.b("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                        }
                    }
                    if (u.a()) {
                        u uVar3 = this.e;
                        uVar3.b("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
                    }
                }
            }
        } catch (Throwable th) {
            if (u.a()) {
                this.e.b("PersistentPostbackQueueSaveTask", "Failed to deserialize postback queue", th);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.c.set(System.currentTimeMillis());
        this.b.S().a((a) this, o.a.POSTBACKS, a);
    }

    public void run() {
        if (this.d.a() > this.c.get()) {
            a(this.d.b());
        }
        a();
    }
}
