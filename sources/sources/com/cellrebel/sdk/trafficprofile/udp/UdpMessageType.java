package com.cellrebel.sdk.trafficprofile.udp;

public enum UdpMessageType {
    HANDSHAKE(0),
    PING(1),
    UPLINK(2),
    DOWNLINK(3),
    DOWNLINK_PROFILE(4),
    DOWNLINK_READY(5);
    
    private final int a;

    private UdpMessageType(int i) {
        this.a = i;
    }

    public static UdpMessageType a(int i) {
        for (UdpMessageType udpMessageType : values()) {
            if (udpMessageType.a == i) {
                return udpMessageType;
            }
        }
        return null;
    }

    public int a() {
        return this.a;
    }
}
