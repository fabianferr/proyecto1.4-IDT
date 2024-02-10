package com.teragence.library;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class y4 {
    private final int a;
    private final int b;
    private final InetAddress c;
    private final int d;
    private final UUID e;

    public y4(int i, int i2, InetAddress inetAddress, int i3, UUID uuid) {
        this.a = i;
        this.b = i2;
        this.c = inetAddress;
        this.d = i3;
        this.e = uuid;
    }

    public List<DatagramPacket> a() {
        int i = this.b;
        if (i >= 30) {
            byte[] bArr = new byte[0];
            if (i > 30) {
                bArr = new byte[((i - 22) - 8)];
                new Random().nextBytes(bArr);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.a; i2++) {
                ByteBuffer put = ByteBuffer.allocate(this.b - 8).order(ByteOrder.LITTLE_ENDIAN).putShort((short) i2).putInt(0).put(f5.a(this.e));
                if (bArr.length > 0) {
                    put.put(bArr);
                }
                byte[] array = put.array();
                arrayList.add(new DatagramPacket(array, array.length, this.c, this.d));
            }
            return arrayList;
        }
        throw new IllegalArgumentException("packetSize (" + this.b + ") < HEADER_SIZE + UDP_HEADER_SIZE");
    }
}
