package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.SensorsConfig;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class q7 extends j6<String> implements g6 {
    public final u1 j;
    public final i2<SensorsConfig> k;

    public q7(Context context, e eVar, u1 u1Var, v2 v2Var, i2<SensorsConfig> i2Var) {
        super(context, eVar, v2Var, "cc8b2544ce91bcdf", "7099d13208ad24ae");
        this.j = u1Var;
        this.k = i2Var;
    }

    public Object a(String str) {
        return str;
    }

    public void a(Object obj) {
        b(obj != null ? obj.toString() : null);
    }

    public /* bridge */ /* synthetic */ Object c() {
        return "";
    }

    public long d() {
        SensorsConfig a = this.k.a();
        if (a != null) {
            return a.h();
        }
        return 0;
    }

    public boolean f() {
        SensorsConfig a;
        if (!this.j.c() || (a = this.k.a()) == null || !a.l()) {
            return false;
        }
        return true;
    }

    public void g() {
        Context context = this.a;
        ComponentLocator.a(context).l().execute(new t2(context, this).d);
    }
}
