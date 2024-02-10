package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: BufferInputStream */
public final class a extends InputStream {
    private com.bykv.vk.openvk.preload.geckox.buffer.a a;
    private long b;

    public final void close() throws IOException {
    }

    public final boolean markSupported() {
        return true;
    }

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.a = aVar;
    }

    public final int read(byte[] bArr) throws IOException {
        return this.a.b(bArr);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.b(bArr, i, i2);
    }

    public final long skip(long j) throws IOException {
        return this.a.a(j);
    }

    public final int available() throws IOException {
        long b2 = this.a.b() - this.a.c();
        if (b2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b2;
    }

    public final synchronized void mark(int i) {
        this.b = (long) i;
    }

    public final synchronized void reset() throws IOException {
        this.a.b(this.b);
    }

    public final int read() throws IOException {
        return this.a.d();
    }
}
