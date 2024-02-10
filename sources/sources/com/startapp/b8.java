package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.StaleDcConfig;

/* compiled from: Sta */
public class b8 extends w1<a8> {
    public final e e;
    public final i2<StaleDcConfig> f;

    public b8(Context context, e eVar, i2<StaleDcConfig> i2Var) {
        super(context, 86400000);
        this.e = eVar;
        this.f = i2Var;
    }

    public Object a(boolean z) {
        a8 a8Var = new a8();
        String str = null;
        if (!z) {
            str = this.e.getString("a83b59c2138cbf65", (String) null);
        }
        if (str == null) {
            Context context = this.a;
            context.getPackageName();
            str = k9.b(context);
            e.a a = this.e.edit();
            a.a("a83b59c2138cbf65", str);
            a.a.putString("a83b59c2138cbf65", str);
            a.apply();
        }
        a8Var.a = str;
        return a8Var;
    }

    public Object c() {
        return new a8();
    }
}
