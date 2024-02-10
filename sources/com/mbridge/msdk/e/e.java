package com.mbridge.msdk.e;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: Event */
public final class e implements Serializable {
    private String a;
    private int b = 0;
    private int c = 0;
    private JSONObject d;
    private String e;
    private long f;
    private long g = 0;
    private long h = 604800000;
    private h i;
    private boolean j = false;
    private boolean k = false;

    public e(String str) {
        this.a = str;
        this.f = System.currentTimeMillis();
        this.e = UUID.randomUUID().toString();
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void a(int i2) {
        this.b = i2;
    }

    public final int c() {
        return this.c;
    }

    public final void b(int i2) {
        this.c = i2;
    }

    public final JSONObject d() {
        return this.d;
    }

    public final void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final String e() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.e = str;
    }

    public final long f() {
        return this.f;
    }

    public final void a(long j2) {
        this.f = j2;
    }

    public final long g() {
        return this.g;
    }

    public final void b(long j2) {
        this.g = j2;
    }

    /* access modifiers changed from: package-private */
    public final void c(long j2) {
        this.h = j2;
    }

    public final long h() {
        return this.h;
    }

    public final h i() {
        return this.i;
    }

    public final void a(h hVar) {
        this.i = hVar;
    }

    public final boolean j() {
        return this.j;
    }

    public final void a(boolean z) {
        this.k = z;
    }

    public final boolean k() {
        return this.k;
    }
}
