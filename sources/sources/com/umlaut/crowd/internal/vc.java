package com.umlaut.crowd.internal;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Random;
import java.util.UUID;

public class vc {
    private byte[] a;
    private Random b;
    private DatagramChannel c;
    private int d;
    private SocketAddress e;
    private ByteBuffer f;
    private byte[] g;
    private boolean h;

    public vc(UUID uuid, DatagramChannel datagramChannel, SocketAddress socketAddress) throws SocketException {
        this.a = new byte[16];
        this.b = new Random();
        this.d = 0;
        this.h = false;
        this.c = datagramChannel;
        a(uuid.getMostSignificantBits(), this.a, 0);
        a(uuid.getLeastSignificantBits(), this.a, 8);
        this.e = socketAddress;
        a(wc.h);
    }

    private void a(int i) {
        byte[] bArr = new byte[i];
        this.g = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f = wrap;
        wrap.clear();
        if (this.f.hasArray()) {
            this.g = null;
        }
    }

    public void b() throws IOException {
        if (this.h) {
            int i = this.d + 1;
            this.d = i;
            a((long) i, (Long) null);
            a();
            return;
        }
        throw new IllegalStateException("Not allowed to send packages");
    }

    public void c() throws IOException {
        a((Long) null);
    }

    public static void a(long j, byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j >>> 56));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j >>> 48));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j >>> 40));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j >>> 32));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j >>> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j >>> 16));
        bArr[i7] = (byte) ((int) (j >>> 8));
        bArr[i7 + 1] = (byte) ((int) (j >>> 0));
    }

    public static void a(long j, ByteBuffer byteBuffer) {
        byteBuffer.put((byte) ((int) (j >>> 56)));
        byteBuffer.put((byte) ((int) (j >>> 48)));
        byteBuffer.put((byte) ((int) (j >>> 40)));
        byteBuffer.put((byte) ((int) (j >>> 32)));
        byteBuffer.put((byte) ((int) (j >>> 24)));
        byteBuffer.put((byte) ((int) (j >>> 16)));
        byteBuffer.put((byte) ((int) (j >>> 8)));
        byteBuffer.put((byte) ((int) (j >>> 0)));
    }

    private void a(long j, Long l) {
        this.f.clear();
        if (l == null) {
            l = Long.valueOf(System.nanoTime());
        }
        byte[] bArr = this.g;
        if (bArr == null) {
            byte[] array = this.f.array();
            this.b.nextBytes(array);
            a(j, array, 0);
            System.arraycopy(this.a, 0, array, 8, 16);
            a(l.longValue(), array, 24);
            this.f.position(array.length - 1);
            return;
        }
        this.b.nextBytes(bArr);
        this.f.put(this.g);
        this.f.position(0);
        a(j, this.f);
        this.f.put(this.a);
        a(l.longValue(), this.f);
    }

    public vc(UUID uuid, DatagramChannel datagramChannel, SocketAddress socketAddress, int i) throws SocketException {
        this(uuid, datagramChannel, socketAddress);
        if (i > wc.i || i < wc.h) {
            throw new IllegalArgumentException("package size has to be greater than " + wc.h + " and less than " + wc.i + " bytes!");
        }
        a(i);
        this.h = true;
    }

    public void a(Long l) throws IOException {
        a(0, l);
        this.f.position(wc.h);
        a();
    }

    private void a() throws IOException {
        this.f.flip();
        do {
            this.c.send(this.f, this.e);
        } while (this.f.hasRemaining());
    }
}
