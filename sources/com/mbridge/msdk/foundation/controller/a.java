package com.mbridge.msdk.foundation.controller;

import com.mbridge.msdk.foundation.b.d;
import java.util.HashMap;
import org.json.JSONArray;

/* compiled from: CandidateController */
public final class a {
    private HashMap<String, d> a;

    /* renamed from: com.mbridge.msdk.foundation.controller.a$a  reason: collision with other inner class name */
    /* compiled from: CandidateController */
    static class C0137a {
        static a a = new a();
    }

    private a() {
        this.a = new HashMap<>();
    }

    public static a a() {
        return C0137a.a;
    }

    public final d a(String str, JSONArray jSONArray) {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        d dVar = new d(str, jSONArray);
        this.a.put(str, dVar);
        return dVar;
    }
}
