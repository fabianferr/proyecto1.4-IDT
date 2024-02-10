package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.i;
import com.bykv.vk.openvk.preload.a.k;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.n;
import com.bykv.vk.openvk.preload.a.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class f extends c {
    private static final Writer f = new Writer() {
        public final void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public final void flush() throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final p g = new p("closed");
    public final List<k> a = new ArrayList();
    public k b = m.a;
    private String h;

    public final void flush() throws IOException {
    }

    public f() {
        super(f);
    }

    private k f() {
        List<k> list = this.a;
        return list.get(list.size() - 1);
    }

    private void a(k kVar) {
        if (this.h != null) {
            if (!(kVar instanceof m) || this.e) {
                ((n) f()).a(this.h, kVar);
            }
            this.h = null;
        } else if (this.a.isEmpty()) {
            this.b = kVar;
        } else {
            k f2 = f();
            if (f2 instanceof i) {
                ((i) f2).a(kVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final c a() throws IOException {
        i iVar = new i();
        a((k) iVar);
        this.a.add(iVar);
        return this;
    }

    public final c b() throws IOException {
        if (this.a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof i) {
            List<k> list = this.a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c c() throws IOException {
        n nVar = new n();
        a((k) nVar);
        this.a.add(nVar);
        return this;
    }

    public final c d() throws IOException {
        if (this.a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof n) {
            List<k> list = this.a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof n) {
            this.h = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        a((k) new p(str));
        return this;
    }

    public final c e() throws IOException {
        a((k) m.a);
        return this;
    }

    public final c a(boolean z) throws IOException {
        a((k) new p(Boolean.valueOf(z)));
        return this;
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return e();
        }
        a((k) new p(bool));
        return this;
    }

    public final c a(long j) throws IOException {
        a((k) new p((Number) Long.valueOf(j)));
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        if (!this.c) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(number)));
            }
        }
        a((k) new p(number));
        return this;
    }

    public final void close() throws IOException {
        if (this.a.isEmpty()) {
            this.a.add(g);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
