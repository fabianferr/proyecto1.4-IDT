package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.BluetoothConfig;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class f1 extends j6<String> implements g6 {
    public final e j;
    public final u1 k;
    public final i2<BluetoothConfig> l;

    public f1(Context context, e eVar, e eVar2, u1 u1Var, v2 v2Var, i2<BluetoothConfig> i2Var) {
        super(context, eVar2, v2Var, "26787005dc4a1477", "c8ef3e50475fc527");
        this.j = eVar;
        this.k = u1Var;
        this.l = i2Var;
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
        BluetoothConfig a = this.l.a();
        if (a != null) {
            return a.b();
        }
        return 0;
    }

    public boolean f() {
        BluetoothConfig a;
        if (!this.k.c() || (a = this.l.a()) == null || !a.d()) {
            return false;
        }
        return true;
    }

    public void g() {
        if (a0.a(this.a, "android.permission.BLUETOOTH")) {
            Context context = this.a;
            ComponentLocator.a(context).l().execute(new n2(context, this.j, this).d);
        }
    }
}
