package com.applovin.impl.sdk.f;

import android.content.Context;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;

public abstract class a implements Runnable {
    private final String a;
    /* access modifiers changed from: protected */
    public final m b;
    private final u c;
    private final Context d;
    private final boolean e;

    public a(String str, m mVar) {
        this(str, mVar, false);
    }

    public a(String str, m mVar, boolean z) {
        this.a = str;
        this.b = mVar;
        this.c = mVar.A();
        this.d = mVar.L();
        this.e = z;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.c.b(this.a, str);
    }

    /* access modifiers changed from: protected */
    public void a(String str, Throwable th) {
        this.c.b(this.a, str, th);
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        this.c.c(this.a, str);
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        this.c.d(this.a, str);
    }

    /* access modifiers changed from: protected */
    public m d() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void d(String str) {
        this.c.e(this.a, str);
    }

    public String e() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public Context f() {
        return this.d;
    }

    public boolean g() {
        return this.e;
    }
}
