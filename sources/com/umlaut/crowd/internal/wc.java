package com.umlaut.crowd.internal;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class wc {
    public static int h = 32;
    public static int i = 65535;
    public long a;
    public q0 b = new q0(16);
    public long c;
    public int d;
    public long e;
    public SocketAddress f;
    public DatagramChannel g;

    public void a(ByteBuffer byteBuffer, SocketAddress socketAddress, DatagramChannel datagramChannel) {
        int remaining = byteBuffer.remaining();
        this.d = remaining;
        if (remaining < h || remaining > i) {
            throw new IllegalArgumentException("UDP packages has to be at least 16 bytes long");
        }
        this.c = byteBuffer.getLong();
        byteBuffer.get(this.b.a());
        this.e = byteBuffer.getLong();
        this.a = System.nanoTime();
        this.f = socketAddress;
        this.g = datagramChannel;
    }
}
