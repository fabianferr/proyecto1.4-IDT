package com.umlaut.crowd.internal;

import java.nio.ByteBuffer;
import java.util.Random;

class u3 {
    private static final int b = 65507;
    static final byte c = 8;
    static final byte d = Byte.MIN_VALUE;
    private static final byte e = 0;
    static final int f = 8;
    private final byte a;

    u3(byte b2) {
        this.a = b2;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer a(short s, short s2, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        } else if (bArr.length > 65507) {
            bArr = a(65507);
        }
        int length = bArr.length + 8;
        byte[] bArr2 = new byte[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        wrap.put(this.a);
        wrap.put((byte) 0);
        int position = wrap.position();
        wrap.position(position + 2);
        wrap.putShort(s2);
        wrap.putShort(s);
        wrap.put(bArr);
        wrap.putShort(position, a(bArr2, length));
        wrap.flip();
        return wrap;
    }

    private static short a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 2) {
            int i4 = i2 + ((bArr[i3] & 255) << 8);
            i2 = (i4 >> 16) + (65535 & i4);
        }
        for (int i5 = 1; i5 < i; i5 += 2) {
            int i6 = i2 + (bArr[i5] & 255);
            i2 = (i6 >> 16) + (i6 & 65535);
        }
        return (short) (((i2 & 65535) + (i2 >> 16)) ^ 65535);
    }

    static byte[] a(int i) {
        byte[] bArr = new byte[i];
        new Random().nextBytes(bArr);
        return bArr;
    }
}
