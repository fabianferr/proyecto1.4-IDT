package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.apiImpl.b.b;
import com.bytedance.sdk.openadsdk.core.model.a;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: SingleAppData */
public class s {
    private static s a;
    private a b;
    private q c;
    private com.bytedance.sdk.openadsdk.apiImpl.d.a d;
    private b e;
    private com.bytedance.sdk.openadsdk.apiImpl.c.b f;

    private s() {
    }

    public static s a() {
        if (a == null) {
            a = new s();
        }
        return a;
    }

    public q b() {
        return this.c;
    }

    public void a(q qVar) {
        this.c = qVar;
    }

    public com.bytedance.sdk.openadsdk.apiImpl.d.a c() {
        return this.d;
    }

    public b d() {
        return this.e;
    }

    public com.bytedance.sdk.openadsdk.apiImpl.c.b e() {
        return this.f;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(com.bytedance.sdk.openadsdk.apiImpl.d.a aVar) {
        this.d = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.apiImpl.c.b bVar) {
        this.f = bVar;
    }

    public void f() {
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public a g() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
