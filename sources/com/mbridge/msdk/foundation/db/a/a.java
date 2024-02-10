package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.same.a.b;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReplaceTempDaoMiddle */
public final class a {
    /* access modifiers changed from: private */
    public m a;
    /* access modifiers changed from: private */
    public b b;

    /* renamed from: com.mbridge.msdk.foundation.db.a.a$a  reason: collision with other inner class name */
    /* compiled from: ReplaceTempDaoMiddle */
    private static class C0138a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    private a() {
        this.b = new b(1000);
        try {
            m a2 = m.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            this.a = a2;
            a(a2.a(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static a a() {
        return C0138a.a;
    }

    public final JSONObject a(String str) {
        m mVar;
        JSONObject a2 = this.b.b(str);
        if (a2 != null || (mVar = this.a) == null) {
            return a2;
        }
        JSONObject a3 = mVar.a(str);
        if (a3 != null) {
            this.b.a(str, a3);
        }
        return a3;
    }

    public final void a(JSONObject jSONObject, final boolean z) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            final b bVar = new b(100);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.b.a(next, optJSONObject);
                bVar.a(next, optJSONObject);
            }
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    if (z && a.this.a != null) {
                        for (String next : bVar.a()) {
                            a.this.a.a(next, a.this.b.b(next));
                        }
                    }
                }
            });
        }
    }

    public final JSONArray b() {
        return new JSONArray(this.b.a());
    }
}
