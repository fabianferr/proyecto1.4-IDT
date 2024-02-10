package com.applovin.impl.sdk.e;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class e {
    private long a;
    private long b;
    private boolean c;
    private long d;
    private long e;
    private int f;
    private Exception g;

    public void a() {
        this.c = true;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(long j) {
        this.a += j;
    }

    public void a(Exception exc) {
        this.g = exc;
    }

    public void b(long j) {
        this.b += j;
    }

    public boolean b() {
        return this.c;
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public void e() {
        this.d++;
    }

    public void f() {
        this.e++;
    }

    public long g() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    public Exception i() {
        return this.g;
    }

    public int j() {
        return this.f;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.a + ", totalCachedBytes=" + this.b + ", isHTMLCachingCancelled=" + this.c + ", htmlResourceCacheSuccessCount=" + this.d + ", htmlResourceCacheFailureCount=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
