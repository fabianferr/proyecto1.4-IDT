package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.g;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse */
public final class f {
    private final int a;
    private final List<g> b;
    private final int c;
    private final InputStream d;
    private final byte[] e;

    public f(int i, List<g> list) {
        this(i, list, -1, (InputStream) null);
    }

    public f(int i, List<g> list, int i2, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
        this.e = null;
    }

    public final int a() {
        return this.a;
    }

    public final List<g> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }
}
