package com.iab.omid.library.vungle.walking;

import com.iab.omid.library.vungle.walking.async.b;
import com.iab.omid.library.vungle.walking.async.c;
import com.iab.omid.library.vungle.walking.async.d;
import com.iab.omid.library.vungle.walking.async.e;
import com.iab.omid.library.vungle.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0094b {
    private JSONObject a;
    private final c b;

    public b(c cVar) {
        this.b = cVar;
    }

    public JSONObject a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }
}