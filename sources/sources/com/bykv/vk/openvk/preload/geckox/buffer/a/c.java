package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RAFBuffer */
final class c implements a {
    private long a;
    private long b;
    private RandomAccessFile c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private File e;

    c(long j, File file) throws IOException {
        this.a = j;
        this.e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.c = randomAccessFile;
            randomAccessFile.setLength(j);
        } catch (Exception e2) {
            CloseableUtils.close((Closeable) this.c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    public final void a() throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
    }

    public final long b() {
        return this.a;
    }

    public final void a(int i) throws IOException {
        a(new byte[]{(byte) i});
    }

    public final void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public final synchronized long a(long j) throws IOException {
        int skipBytes;
        if (!this.d.get()) {
            int i = (int) j;
            if (((long) i) == j) {
                skipBytes = this.c.skipBytes(i);
                this.b = this.c.getFilePointer();
            } else {
                throw new IOException("too large:".concat(String.valueOf(j)));
            }
        } else {
            throw new IOException("released!");
        }
        return (long) skipBytes;
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (bArr == null || bArr.length == 0 || i2 <= 0 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                long j = this.b;
                long j2 = this.a;
                if (j == j2) {
                    return 0;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                this.c.write(bArr, i, i2);
                this.b += (long) i2;
                return i2;
            }
        }
    }

    public final long c() throws IOException {
        if (!this.d.get()) {
            return this.b;
        }
        throw new IOException("released!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r4 > r0) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(long r4) throws java.io.IOException {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.d
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x001f
            r0 = 0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0010
        L_0x000e:
            r4 = r0
            goto L_0x0017
        L_0x0010:
            long r0 = r3.a
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            r3.b = r4
            java.io.RandomAccessFile r0 = r3.c
            r0.seek(r4)
            return
        L_0x001f:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "released!"
            r4.<init>(r5)
            goto L_0x0028
        L_0x0027:
            throw r4
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.buffer.a.c.b(long):void");
    }

    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) == 0) {
            return -1;
        }
        return bArr[0];
    }

    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    public final int b(byte[] bArr, int i, int i2) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (bArr == null || i2 <= 0 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                long j = this.b;
                long j2 = this.a;
                if (j == j2) {
                    return -1;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                int read = this.c.read(bArr, i, i2);
                if (read == -1) {
                    return -1;
                }
                this.b += (long) read;
                return read;
            }
        }
    }

    public final void e() {
        if (!this.d.getAndSet(true)) {
            CloseableUtils.close((Closeable) this.c);
        }
    }

    public final File f() {
        return this.e;
    }
}
