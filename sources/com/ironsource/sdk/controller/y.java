package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.StringUtils;
import com.ironsource.environment.e.b;
import com.ironsource.sdk.service.c;
import com.ironsource.sdk.service.d;
import java.util.Iterator;
import org.json.JSONObject;

public class y {
    static final String a = "y";
    d b;
    c c;
    Context d;
    private final String e = "oneToken";
    private b f;

    static class a {
        String a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public y(Context context, d dVar) {
        this.b = dVar;
        this.d = context;
        this.c = new c();
        this.f = new b();
    }

    /* access modifiers changed from: package-private */
    public JSONObject a() {
        JSONObject a2 = this.f.a();
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = a2.get(next);
            if (obj instanceof String) {
                a2.put(next, StringUtils.encodeURI((String) obj));
            }
        }
        return a2;
    }
}
