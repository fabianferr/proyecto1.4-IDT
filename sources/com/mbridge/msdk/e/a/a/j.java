package com.mbridge.msdk.e.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: PoolingByteArrayOutputStream */
public final class j extends ByteArrayOutputStream {
    private final c a;

    public j(c cVar, int i) {
        this.a = cVar;
        this.buf = cVar.a(Math.max(i, 256));
    }

    public final void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a2 = this.a.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.a.a(this.buf);
            this.buf = a2;
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        if (bArr != null) {
            super.write(bArr, i, i2);
        }
    }

    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
