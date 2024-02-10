package com.cellrebel.sdk.ping;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class EchoPacketBuilder {
    private static AtomicInteger f = new AtomicInteger(0);
    private final byte a;
    private final byte[] b;
    private short c;
    private short d = 3515;
    private boolean e = true;

    public EchoPacketBuilder(byte b2, byte[] bArr) {
        this.a = b2;
        if (bArr == null) {
            this.b = new byte[0];
        } else if (bArr.length <= 65507) {
            this.b = bArr;
        } else {
            throw new IllegalArgumentException("Payload limited to 65507");
        }
    }

    static short a(byte[] bArr, int i) {
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

    public ByteBuffer a() {
        if (this.e) {
            this.d = (short) f.getAndIncrement();
        }
        int length = this.b.length + 8;
        byte[] bArr = new byte[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.put(this.a);
        wrap.put((byte) 0);
        int position = wrap.position();
        wrap.position(position + 2);
        wrap.putShort(this.d);
        wrap.putShort(this.c);
        wrap.put(this.b);
        wrap.putShort(position, a(bArr, length));
        wrap.flip();
        return wrap;
    }
}
