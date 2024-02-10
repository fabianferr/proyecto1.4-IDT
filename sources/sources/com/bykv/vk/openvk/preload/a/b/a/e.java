package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.d.a;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.i;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.n;
import com.bykv.vk.openvk.preload.a.p;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: JsonTreeReader */
public final class e extends a {
    private static final Reader c = new Reader() {
        public final int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object d = new Object();
    private Object[] e;
    private int f;
    private String[] g;
    private int[] h;

    public final void a() throws IOException {
        a(b.BEGIN_ARRAY);
        a((Object) ((i) g()).iterator());
        this.h[this.f - 1] = 0;
    }

    public final void b() throws IOException {
        a(b.END_ARRAY);
        s();
        s();
        int i = this.f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final void c() throws IOException {
        a(b.BEGIN_OBJECT);
        a((Object) ((n) g()).a.entrySet().iterator());
    }

    public final void d() throws IOException {
        a(b.END_OBJECT);
        s();
        s();
        int i = this.f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final boolean e() throws IOException {
        b f2 = f();
        return (f2 == b.END_OBJECT || f2 == b.END_ARRAY) ? false : true;
    }

    public final b f() throws IOException {
        while (this.f != 0) {
            Object g2 = g();
            if (g2 instanceof Iterator) {
                boolean z = this.e[this.f - 2] instanceof n;
                Iterator it = (Iterator) g2;
                if (!it.hasNext()) {
                    return z ? b.END_OBJECT : b.END_ARRAY;
                }
                if (z) {
                    return b.NAME;
                }
                a(it.next());
            } else if (g2 instanceof n) {
                return b.BEGIN_OBJECT;
            } else {
                if (g2 instanceof i) {
                    return b.BEGIN_ARRAY;
                }
                if (g2 instanceof p) {
                    p pVar = (p) g2;
                    if (pVar.a instanceof String) {
                        return b.STRING;
                    }
                    if (pVar.a instanceof Boolean) {
                        return b.BOOLEAN;
                    }
                    if (pVar.a instanceof Number) {
                        return b.NUMBER;
                    }
                    throw new AssertionError();
                } else if (g2 instanceof m) {
                    return b.NULL;
                } else {
                    if (g2 == d) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return b.END_DOCUMENT;
    }

    public final Object g() {
        return this.e[this.f - 1];
    }

    private Object s() {
        Object[] objArr = this.e;
        int i = this.f - 1;
        this.f = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + t());
        }
    }

    public final String h() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) g()).next();
        String str = (String) entry.getKey();
        this.g[this.f - 1] = str;
        a(entry.getValue());
        return str;
    }

    public final String i() throws IOException {
        b f2 = f();
        if (f2 == b.STRING || f2 == b.NUMBER) {
            String b = ((p) s()).b();
            int i = this.f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return b;
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f2 + t());
    }

    public final boolean j() throws IOException {
        a(b.BOOLEAN);
        boolean f2 = ((p) s()).f();
        int i = this.f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return f2;
    }

    public final void k() throws IOException {
        a(b.NULL);
        s();
        int i = this.f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final double l() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            double c2 = ((p) g()).c();
            if (this.a || (!Double.isNaN(c2) && !Double.isInfinite(c2))) {
                s();
                int i = this.f;
                if (i > 0) {
                    int[] iArr = this.h;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return c2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(c2)));
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + t());
    }

    public final long m() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            long d2 = ((p) g()).d();
            s();
            int i = this.f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return d2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + t());
    }

    public final int n() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            int e2 = ((p) g()).e();
            s();
            int i = this.f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + t());
    }

    public final void close() throws IOException {
        this.e = new Object[]{d};
        this.f = 1;
    }

    public final void o() throws IOException {
        if (f() == b.NAME) {
            h();
            this.g[this.f - 2] = AbstractJsonLexerKt.NULL;
        } else {
            s();
            int i = this.f;
            if (i > 0) {
                this.g[i - 1] = AbstractJsonLexerKt.NULL;
            }
        }
        int i2 = this.f;
        if (i2 > 0) {
            int[] iArr = this.h;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void a(Object obj) {
        int i = this.f;
        Object[] objArr = this.e;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.e = Arrays.copyOf(objArr, i2);
            this.h = Arrays.copyOf(this.h, i2);
            this.g = (String[]) Arrays.copyOf(this.g, i2);
        }
        Object[] objArr2 = this.e;
        int i3 = this.f;
        this.f = i3 + 1;
        objArr2[i3] = obj;
    }

    public final String p() {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (i < this.f) {
            Object[] objArr = this.e;
            Object obj = objArr[i];
            if (obj instanceof i) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(this.h[i]);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                }
            } else if (obj instanceof n) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String str = this.g[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    private String t() {
        return " at path " + p();
    }
}
