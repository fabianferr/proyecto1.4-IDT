package com.cellrebel.sdk.trafficprofile.udp.messages;

import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

public class UdpPackageMessage extends UdpMessage {
    public long d;
    public int e;
    public int f;
    public int g;
    public String h;
    public int i;

    public UdpPackageMessage() {
        super(UdpMessageType.DOWNLINK);
    }

    public UdpPackageMessage(byte[] bArr, int i2) {
        super(bArr);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        wrap.position(16);
        this.d = this.b;
        this.e = wrap.getInt();
        this.f = wrap.getInt();
        this.g = wrap.getInt();
        this.i = i2;
    }

    public byte[] a(long j) {
        byte[] a = super.a(j);
        ByteBuffer allocate = ByteBuffer.allocate(this.i);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(a);
        allocate.putInt(this.e);
        allocate.putInt(this.f);
        allocate.putInt(this.g);
        allocate.put(this.h.getBytes());
        byte[] bArr = new byte[(((((this.i - a.length) - 4) - 4) - 4) - 32)];
        new Random().nextBytes(bArr);
        allocate.put(bArr);
        return allocate.array();
    }

    public String toString() {
        return "UdpPackageMessage{type=" + this.a + ", timestamp=" + this.b + ", packetId=" + this.c + ", serverTimestamp=" + this.d + ", profileId=" + this.e + ", profileConfigId=" + this.f + ", segmentId=" + this.g + "}\n";
    }
}
