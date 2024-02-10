package com.bytedance.sdk.component.adexpress.b;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: RenderRequest */
public class m {
    private JSONObject a;
    private e b;
    private String c;
    private i d;
    private int e;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private int j;
    private long k;
    private int l;
    private String m;
    private Map<String, String> n;
    private int o;
    private boolean p;
    private String q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String v;
    private double w;
    private int x;
    private boolean y;

    public m(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
    }

    public boolean a() {
        return this.y;
    }

    public double b() {
        return this.w;
    }

    public JSONObject c() {
        e eVar;
        if (this.a == null && (eVar = this.b) != null) {
            this.a = eVar.a();
        }
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public i e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.x;
    }

    public boolean h() {
        return this.i;
    }

    public long i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public Map<String, String> k() {
        return this.n;
    }

    public int l() {
        return this.o;
    }

    public boolean m() {
        return this.p;
    }

    public String n() {
        return this.q;
    }

    public int o() {
        return this.r;
    }

    public int p() {
        return this.s;
    }

    public int q() {
        return this.t;
    }

    public int r() {
        return this.u;
    }

    /* compiled from: RenderRequest */
    public static class a {
        /* access modifiers changed from: private */
        public JSONObject a;
        /* access modifiers changed from: private */
        public e b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public i d;
        /* access modifiers changed from: private */
        public int e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public boolean i;
        /* access modifiers changed from: private */
        public int j;
        /* access modifiers changed from: private */
        public long k;
        /* access modifiers changed from: private */
        public int l;
        /* access modifiers changed from: private */
        public String m;
        /* access modifiers changed from: private */
        public Map<String, String> n;
        /* access modifiers changed from: private */
        public int o;
        /* access modifiers changed from: private */
        public boolean p;
        /* access modifiers changed from: private */
        public String q;
        /* access modifiers changed from: private */
        public int r;
        /* access modifiers changed from: private */
        public int s;
        /* access modifiers changed from: private */
        public int t;
        /* access modifiers changed from: private */
        public int u;
        /* access modifiers changed from: private */
        public String v;
        /* access modifiers changed from: private */
        public double w;
        /* access modifiers changed from: private */
        public int x;
        /* access modifiers changed from: private */
        public boolean y = true;

        public a a(e eVar) {
            this.b = eVar;
            return this;
        }

        public a a(boolean z) {
            this.y = z;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(i iVar) {
            this.d = iVar;
            return this;
        }

        public a a(int i2) {
            this.e = i2;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public a b(int i2) {
            this.j = i2;
            return this;
        }

        public a a(long j2) {
            this.k = j2;
            return this;
        }

        public a c(int i2) {
            this.l = i2;
            return this;
        }

        public a a(Map<String, String> map) {
            this.n = map;
            return this;
        }

        public a d(int i2) {
            this.o = i2;
            return this;
        }

        public a c(boolean z) {
            this.p = z;
            return this;
        }

        public a e(String str) {
            this.q = str;
            return this;
        }

        public a e(int i2) {
            this.x = i2;
            return this;
        }

        public m a() {
            return new m(this);
        }

        public a a(double d2) {
            this.w = d2;
            return this;
        }
    }
}
