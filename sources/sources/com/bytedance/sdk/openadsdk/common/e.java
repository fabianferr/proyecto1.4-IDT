package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;

/* compiled from: LandingPageLoadingStyle */
public abstract class e {
    protected final n b;
    protected String c;
    protected String[] d;
    protected View e;
    protected Context f;
    protected p g;

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract void a(int i);

    public abstract void b();

    public abstract void c();

    public e(Context context, String str, String[] strArr, n nVar, p pVar) {
        this.c = str;
        this.d = strArr;
        this.f = context;
        this.b = nVar;
        this.g = pVar;
        a();
    }

    public View e() {
        return this.e;
    }

    public void d() {
        c();
        this.e = null;
        this.f = null;
    }
}
