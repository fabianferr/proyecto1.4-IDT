package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import java.util.Map;
import org.json.JSONObject;

public class i<T> extends c {
    private String a;
    private boolean b;

    public static class a<T> extends c.a<T> {
        /* access modifiers changed from: private */
        public String o;
        /* access modifiers changed from: private */
        public boolean p;

        public a(m mVar) {
            super(mVar);
            this.h = ((Integer) mVar.a(b.cJ)).intValue();
            this.i = ((Integer) mVar.a(b.cI)).intValue();
            this.j = ((Integer) mVar.a(b.cO)).intValue();
        }

        /* renamed from: b */
        public a a(T t) {
            this.g = t;
            return this;
        }

        /* renamed from: b */
        public a a(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public i<T> a() {
            return new i<>(this);
        }

        /* renamed from: c */
        public a a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        /* renamed from: d */
        public a a(int i) {
            this.h = i;
            return this;
        }

        /* renamed from: d */
        public a a(String str) {
            this.b = str;
            return this;
        }

        /* renamed from: d */
        public a b(Map<String, String> map) {
            this.e = map;
            return this;
        }

        /* renamed from: e */
        public a b(int i) {
            this.i = i;
            return this;
        }

        /* renamed from: e */
        public a c(String str) {
            this.c = str;
            return this;
        }

        /* renamed from: e */
        public a c(boolean z) {
            this.m = z;
            return this;
        }

        /* renamed from: f */
        public a c(int i) {
            this.j = i;
            return this;
        }

        /* renamed from: f */
        public a b(String str) {
            this.a = str;
            return this;
        }

        /* renamed from: f */
        public a d(boolean z) {
            this.n = z;
            return this;
        }

        public a g(String str) {
            this.o = str;
            return this;
        }

        public a g(boolean z) {
            this.p = z;
            return this;
        }
    }

    protected i(a aVar) {
        super(aVar);
        this.a = aVar.o;
        this.b = aVar.p;
    }

    public static a b(m mVar) {
        return new a(mVar);
    }

    public boolean p() {
        return this.a != null;
    }

    public String q() {
        return this.a;
    }

    public boolean r() {
        return this.b;
    }
}
