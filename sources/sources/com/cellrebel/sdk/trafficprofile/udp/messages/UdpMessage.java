package com.cellrebel.sdk.trafficprofile.udp.messages;

import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UdpMessage {
    public UdpMessageType a;
    public long b;
    public int c;

    public UdpMessage(UdpMessageType udpMessageType) {
        this.a = udpMessageType;
    }

    public UdpMessage(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        this.a = UdpMessageType.a(wrap.getInt());
        this.b = wrap.getLong();
        this.c = wrap.getInt();
    }

    public byte[] a(long j) {
        this.b = j;
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(this.a.a());
        allocate.putLong(j);
        allocate.putInt(this.c);
        return allocate.array();
    }
}
