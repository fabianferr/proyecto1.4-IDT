package com.bytedance.sdk.component.b.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpClient */
public abstract class j implements Cloneable {
    public List<h> a;
    public long b;
    public TimeUnit c;
    public long d;
    public TimeUnit e;
    public long f;
    public TimeUnit g;

    public abstract b a(l lVar);

    public abstract d a();

    public j(a aVar) {
        this.b = aVar.b;
        this.d = aVar.d;
        this.f = aVar.f;
        this.a = aVar.a;
        this.c = aVar.c;
        this.e = aVar.e;
        this.g = aVar.g;
        this.a = aVar.a;
    }

    /* compiled from: OkHttpClient */
    public static final class a {
        public final List<h> a = new ArrayList();
        public long b = 10000;
        public TimeUnit c = TimeUnit.MILLISECONDS;
        public long d = 10000;
        public TimeUnit e = TimeUnit.MILLISECONDS;
        public long f = 10000;
        public TimeUnit g = TimeUnit.MILLISECONDS;

        public a() {
        }

        public a(String str) {
        }

        public a(j jVar) {
            this.b = jVar.b;
            this.c = jVar.c;
            this.d = jVar.d;
            this.e = jVar.e;
            this.f = jVar.f;
            this.g = jVar.g;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.b = j;
            this.c = timeUnit;
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.d = j;
            this.e = timeUnit;
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.f = j;
            this.g = timeUnit;
            return this;
        }

        public a a(h hVar) {
            this.a.add(hVar);
            return this;
        }

        public j a() {
            return com.bytedance.sdk.component.b.a.a.a.a(this);
        }
    }

    public a b() {
        return new a(this);
    }
}
