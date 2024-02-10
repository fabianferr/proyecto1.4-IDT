package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FileBuffer */
final class b implements a {
    private RandomAccessFile a;
    private AtomicBoolean b = new AtomicBoolean(false);
    private File c;

    b(File file) throws IOException {
        this.c = file;
        file.getParentFile().mkdirs();
        try {
            this.a = new RandomAccessFile(file, "rw");
        } catch (Exception e) {
            CloseableUtils.close((Closeable) this.a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    public final void a() throws IOException {
        if (this.b.get()) {
            throw new IOException("released!");
        }
    }

    public final long b() throws IOException {
        return this.a.length();
    }

    public final void a(int i) throws IOException {
        a(new byte[]{(byte) i});
    }

    public final void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public final synchronized long a(long j) throws IOException {
        int i;
        if (!this.b.get()) {
            i = (int) j;
            if (((long) i) == j) {
            } else {
                throw new IOException("too large:".concat(String.valueOf(j)));
            }
        } else {
            throw new IOException("released!");
        }
        return (long) this.a.skipBytes(i);
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (this.b.get()) {
            throw new IOException("released!");
        } else if (bArr == null || bArr.length == 0 || i2 <= 0 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                this.a.write(bArr, i, i2);
            }
            return i2;
        }
    }

    public final long c() throws IOException {
        if (!this.b.get()) {
            return this.a.getFilePointer();
        }
        throw new IOException("released!");
    }

    public final void b(long j) throws IOException {
        if (!this.b.get()) {
            if (j < 0) {
                j = 0;
            }
            this.a.seek(j);
            return;
        }
        throw new IOException("released!");
    }

    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    public final int b(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.b.get()) {
            throw new IOException("released!");
        } else if (bArr == null || i2 <= 0 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                read = this.a.read(bArr, i, i2);
            }
            return read;
        }
    }

    public final void e() {
        if (!this.b.getAndSet(true)) {
            CloseableUtils.close((Closeable) this.a);
        }
    }

    public final File f() {
        return this.c;
    }
}
