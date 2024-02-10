package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import java.util.Arrays;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class c<T> {
    private String a;
    private String b;
    private Map<String, String> c;
    private Map<String, String> d;
    private final JSONObject e;
    private String f;
    private final T g;
    private final int h;
    private int i;
    private final int j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    public static class a<T> {
        String a;
        String b;
        String c;
        Map<String, String> d;
        Map<String, String> e;
        JSONObject f;
        T g;
        int h = 1;
        int i;
        int j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        public a(m mVar) {
            this.i = ((Integer) mVar.a(b.cP)).intValue();
            this.j = ((Integer) mVar.a(b.cO)).intValue();
            this.l = ((Boolean) mVar.a(b.cN)).booleanValue();
            this.m = ((Boolean) mVar.a(b.es)).booleanValue();
            this.n = ((Boolean) mVar.a(b.ex)).booleanValue();
            this.d = CollectionUtils.map();
        }

        public a<T> a(int i2) {
            this.h = i2;
            return this;
        }

        public a<T> a(T t) {
            this.g = t;
            return this;
        }

        public a<T> a(String str) {
            this.b = str;
            return this;
        }

        public a<T> a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a<T> a(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public a<T> a(boolean z) {
            this.k = z;
            return this;
        }

        public c<T> a() {
            return new c<>(this);
        }

        public a<T> b(int i2) {
            this.i = i2;
            return this;
        }

        public a<T> b(String str) {
            this.a = str;
            return this;
        }

        public a<T> b(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public a<T> b(boolean z) {
            this.l = z;
            return this;
        }

        public a<T> c(int i2) {
            this.j = i2;
            return this;
        }

        public a<T> c(String str) {
            this.c = str;
            return this;
        }

        public a<T> c(boolean z) {
            this.m = z;
            return this;
        }

        public a<T> d(boolean z) {
            this.n = z;
            return this;
        }
    }

    protected c(a<T> aVar) {
        this.a = aVar.b;
        this.b = aVar.a;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.c;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
        this.n = aVar.m;
        this.o = aVar.n;
    }

    public static <T> a<T> a(m mVar) {
        return new a<>(mVar);
    }

    public String a() {
        return this.a;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public Map<String, String> d() {
        return this.d;
    }

    public JSONObject e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.a;
        if (str == null ? cVar.a != null : !str.equals(cVar.a)) {
            return false;
        }
        Map<String, String> map = this.c;
        if (map == null ? cVar.c != null : !map.equals(cVar.c)) {
            return false;
        }
        Map<String, String> map2 = this.d;
        if (map2 == null ? cVar.d != null : !map2.equals(cVar.d)) {
            return false;
        }
        String str2 = this.f;
        if (str2 == null ? cVar.f != null : !str2.equals(cVar.f)) {
            return false;
        }
        String str3 = this.b;
        if (str3 == null ? cVar.b != null : !str3.equals(cVar.b)) {
            return false;
        }
        JSONObject jSONObject = this.e;
        if (jSONObject == null ? cVar.e != null : !jSONObject.equals(cVar.e)) {
            return false;
        }
        T t = this.g;
        if (t == null ? cVar.g == null : t.equals(cVar.g)) {
            return this.h == cVar.h && this.i == cVar.i && this.j == cVar.j && this.k == cVar.k && this.l == cVar.l && this.m == cVar.m && this.n == cVar.n && this.o == cVar.o;
        }
        return false;
    }

    public String f() {
        return this.f;
    }

    public T g() {
        return this.g;
    }

    public int h() {
        return this.i;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.g;
        if (t != null) {
            i2 = t.hashCode();
        }
        int i3 = ((((((((((((((((hashCode4 + i2) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + (this.l ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0);
        Map<String, String> map = this.c;
        if (map != null) {
            i3 = (i3 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.d;
        if (map2 != null) {
            i3 = (i3 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.e;
        if (jSONObject == null) {
            return i3;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i3 * 31) + new String(charArray).hashCode();
    }

    public int i() {
        return this.h - this.i;
    }

    public int j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.o;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.a + ", backupEndpoint=" + this.f + ", httpMethod=" + this.b + ", httpHeaders=" + this.d + ", body=" + this.e + ", emptyResponse=" + this.g + ", initialRetryAttempts=" + this.h + ", retryAttemptsLeft=" + this.i + ", timeoutMillis=" + this.j + ", retryDelayMillis=" + this.k + ", exponentialRetries=" + this.l + ", retryOnAllErrors=" + this.m + ", encodingEnabled=" + this.n + ", gzipBodyEncoding=" + this.o + AbstractJsonLexerKt.END_OBJ;
    }
}
