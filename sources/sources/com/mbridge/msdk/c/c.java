package com.mbridge.msdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: MBDNSManager */
public final class c {
    public int a;
    private HashMap<String, d> b;

    /* compiled from: MBDNSManager */
    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c();
    }

    private c() {
        this.b = new HashMap<>();
        this.a = 6;
    }

    public static c a() {
        return a.a;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.b == null) {
                    this.b = new HashMap<>();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    d dVar = new d();
                    dVar.a(next);
                    dVar.b(string);
                    this.b.put(next, dVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final String b(String str) {
        HashMap<String, d> hashMap;
        d dVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.b) == null || !hashMap.containsKey(str) || (dVar = this.b.get(str)) == null || dVar.b() >= this.a) {
            return "";
        }
        String a2 = dVar.a();
        if (!TextUtils.isEmpty(a2)) {
            dVar.a(true);
        }
        return a2;
    }

    public final void c(String str) {
        HashMap<String, d> hashMap;
        d dVar;
        if (!TextUtils.isEmpty(str) && (hashMap = this.b) != null && hashMap.containsKey(str) && (dVar = this.b.get(str)) != null && dVar.b() < this.a) {
            dVar.a(dVar.b() + 1);
        }
    }

    public final void d(String str) {
        HashMap<String, d> hashMap;
        d dVar;
        if (!TextUtils.isEmpty(str) && (hashMap = this.b) != null && hashMap.containsKey(str) && (dVar = this.b.get(str)) != null && dVar.b() < this.a) {
            dVar.a(0);
        }
    }

    public final int e(String str) {
        HashMap<String, d> hashMap;
        d dVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.b) == null || !hashMap.containsKey(str) || (dVar = this.b.get(str)) == null) {
            return 0;
        }
        int i = dVar.c() ? 1 : dVar.b() >= this.a ? 2 : 0;
        dVar.a(false);
        return i;
    }
}
