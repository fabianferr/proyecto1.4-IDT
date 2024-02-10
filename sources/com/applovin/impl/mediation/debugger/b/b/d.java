package com.applovin.impl.mediation.debugger.b.b;

import android.content.Context;
import com.applovin.impl.sdk.utils.g;

public class d {
    private final String a;
    private final String b;
    private final boolean c;

    d(String str, String str2, Context context) {
        this.a = str.replace("android.permission.", "");
        this.b = str2;
        this.c = g.a(str, context);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
