package com.cellrebel.sdk.trafficprofile.udp.messages;

import com.cellrebel.sdk.trafficprofile.models.TrafficProfile;
import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import com.google.gson.GsonBuilder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class UdpProfileMessage extends UdpMessage {
    public TrafficProfile d;

    public UdpProfileMessage() {
        super(UdpMessageType.DOWNLINK_PROFILE);
    }

    public byte[] a(long j) {
        byte[] bytes = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson((Object) this.d).getBytes(StandardCharsets.UTF_8);
        byte[] a = super.a(j);
        ByteBuffer allocate = ByteBuffer.allocate(a.length + bytes.length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(a);
        allocate.put(bytes);
        return allocate.array();
    }
}
