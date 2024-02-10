package com.mbridge.msdk.foundation.tools;

import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import okio.Utf8;

/* compiled from: FastBuffer */
public final class m {
    public byte[] a;
    public int b;
    private char[] c;

    public m(int i) {
        this(new byte[i], 0);
    }

    public m(byte[] bArr) {
        this(bArr, 0);
    }

    public m(byte[] bArr, int i) {
        this.c = null;
        this.a = bArr;
        this.b = i;
    }

    public final byte a() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i];
    }

    public final void a(byte b2) {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b2;
    }

    public final short b() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2 + 1;
        return (short) ((bArr[i2] << 8) | (bArr[i] & 255));
    }

    public final void a(short s) {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        bArr[i] = (byte) s;
        this.b = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final int c() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        byte b2 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i4 = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & 255) << Ascii.DLE);
        this.b = i4 + 1;
        return (bArr[i4] << Ascii.CAN) | b3;
    }

    public final void a(int i) {
        byte[] bArr = this.a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >> 16);
        this.b = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void a(int i, int i2) {
        byte[] bArr = this.a;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    public final void a(int i, long j) {
        byte[] bArr = this.a;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) j);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j >> 8));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j >> 16));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j >> 24));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j >> 32));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j >> 40));
        bArr[i7] = (byte) ((int) (j >> 48));
        bArr[i7 + 1] = (byte) ((int) (j >> 56));
    }

    public final void a(long j) {
        a(this.b, j);
        this.b += 8;
    }

    private long c(int i) {
        byte[] bArr = this.a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        return (((long) bArr[i7 + 1]) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 40) | ((255 & ((long) bArr[i7])) << 48);
    }

    public final long d() {
        long c2 = c(this.b);
        this.b += 8;
        return c2;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.a, this.b, length);
            this.b += length;
        }
    }

    public final void a(String str) {
        if (str != null && !str.isEmpty()) {
            byte[] bArr = this.a;
            int i = this.b;
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    bArr[i] = (byte) charAt;
                    i2 = i3;
                    i++;
                } else if (charAt < 2048) {
                    int i4 = i + 1;
                    bArr[i] = (byte) ((charAt >>> 6) | 192);
                    i = i4 + 1;
                    bArr[i4] = (byte) ((charAt & '?') | 128);
                    i2 = i3;
                } else if (charAt < 55296 || charAt > 57343) {
                    int i5 = i + 1;
                    bArr[i] = (byte) ((charAt >>> 12) | 224);
                    int i6 = i5 + 1;
                    bArr[i5] = (byte) (((charAt >>> 6) & 63) | 128);
                    bArr[i6] = (byte) ((charAt & '?') | 128);
                    i2 = i3;
                    i = i6 + 1;
                } else {
                    int i7 = i3 + 1;
                    int charAt2 = ((charAt << 10) + str.charAt(i3)) - 56613888;
                    int i8 = i + 1;
                    bArr[i] = (byte) ((charAt2 >>> 18) | 240);
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) (((charAt2 >>> 12) & 63) | 128);
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & 63) | 128);
                    i2 = i7;
                }
            }
            this.b = i;
        }
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                i3++;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final long b(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= c(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (((long) this.a[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }

    public final String b(int i) {
        String str;
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i > 2048) {
            str = new String(this.a, this.b, i, StandardCharsets.UTF_8);
        } else {
            char[] cArr = this.c;
            if (cArr == null) {
                if (i <= 256) {
                    this.c = new char[256];
                } else {
                    this.c = new char[2048];
                }
            } else if (cArr.length < i) {
                this.c = new char[2048];
            }
            char[] cArr2 = this.c;
            byte[] bArr = this.a;
            int i2 = this.b;
            int i3 = i2 + i;
            int i4 = 0;
            while (i2 < i3) {
                int i5 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 > 0) {
                    cArr2[i4] = (char) b2;
                    i2 = i5;
                    i4++;
                } else if (b2 < -32) {
                    cArr2[i4] = (char) (((b2 & Ascii.US) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                    i2 = i5 + 1;
                    i4++;
                } else if (b2 < -16) {
                    int i6 = i5 + 1;
                    cArr2[i4] = (char) (((b2 & Ascii.SI) << Ascii.FF) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                    i2 = i6 + 1;
                    i4++;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i7 + 1;
                    byte b3 = ((b2 & 7) << Ascii.DC2) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << Ascii.FF) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                    int i9 = i4 + 1;
                    cArr2[i4] = (char) ((b3 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i4 = i9 + 1;
                    cArr2[i9] = (char) ((b3 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                    i2 = i8 + 1;
                }
            }
            if (i2 <= i3) {
                str = new String(cArr2, 0, i4);
            } else {
                throw new IllegalArgumentException("Invalid String");
            }
        }
        this.b += i;
        return str;
    }
}
