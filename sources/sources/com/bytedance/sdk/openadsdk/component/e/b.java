package com.bytedance.sdk.openadsdk.component.e;

import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: TTAppOpenAdCallBackResult */
public class b {
    private int a;
    private int b;
    private q c;
    private int d;
    private String e;
    private boolean f;

    public b(int i, int i2, q qVar) {
        this.a = i;
        this.b = i2;
        this.c = qVar;
    }

    public b(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = str;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean a() {
        return this.f;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public q d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }
}
