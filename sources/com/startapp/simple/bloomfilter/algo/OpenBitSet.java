package com.startapp.simple.bloomfilter.algo;

import java.io.Serializable;

/* compiled from: Sta */
public class OpenBitSet implements Serializable {
    public static final /* synthetic */ boolean a = true;
    private static final long serialVersionUID = -901334831550831262L;
    private final long[][] bits;
    private final int pageCount;
    private int wlen;

    public OpenBitSet(long j) {
        int a2 = a(j);
        this.wlen = a2;
        int i = a2 % 4096;
        int i2 = a2 / 4096;
        int i3 = (i == 0 ? 0 : 1) + i2;
        this.pageCount = i3;
        if (i3 <= 100) {
            this.bits = new long[i3][];
            for (int i4 = 0; i4 < i2; i4++) {
                this.bits[i4] = new long[4096];
            }
            if (i != 0) {
                long[][] jArr = this.bits;
                jArr[jArr.length - 1] = new long[i];
                return;
            }
            return;
        }
        throw new RuntimeException("HighPageCountException pageCount = " + i3);
    }

    public int a() {
        return this.wlen;
    }

    public final int a(long j) {
        return (int) (((j - 1) >>> 6) + 1);
    }

    public void b(long j) {
        int i = (int) (j >> 6);
        int i2 = this.wlen;
        if (i >= i2) {
            int i3 = (int) ((((j + 1) - 1) >>> 6) + 1);
            if (a || i3 <= i2) {
                this.wlen = i + 1;
            } else {
                throw new AssertionError("Growing of paged bitset is not supported");
            }
        }
        long[] jArr = this.bits[i / 4096];
        int i4 = i % 4096;
        jArr[i4] = (1 << (((int) j) & 63)) | jArr[i4];
    }

    public long c() {
        return ((long) this.wlen) << 6;
    }

    public long[] a(int i) {
        return this.bits[i];
    }

    public int b() {
        return this.pageCount;
    }
}
