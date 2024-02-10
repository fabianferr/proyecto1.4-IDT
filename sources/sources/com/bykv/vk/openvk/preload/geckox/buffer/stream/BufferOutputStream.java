package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import com.bykv.vk.openvk.preload.geckox.buffer.a;
import java.io.IOException;

public class BufferOutputStream extends b {
    private a mBuffer;

    public void flush() throws IOException {
    }

    public BufferOutputStream(a aVar) {
        this.mBuffer = aVar;
    }

    public void write(int i) throws IOException {
        this.mBuffer.a(i);
    }

    public void write(byte[] bArr) throws IOException {
        this.mBuffer.a(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mBuffer.a(bArr, i, i2);
    }

    public void write(long j, int i) throws IOException {
        synchronized (this) {
            this.mBuffer.b(j);
            this.mBuffer.a(i);
        }
    }

    public void write(long j, byte[] bArr) throws IOException {
        synchronized (this) {
            this.mBuffer.b(j);
            this.mBuffer.a(bArr);
        }
    }

    public void write(long j, byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            this.mBuffer.b(j);
            this.mBuffer.a(bArr, i, i2);
        }
    }

    public void close() throws IOException {
        flush();
    }
}
