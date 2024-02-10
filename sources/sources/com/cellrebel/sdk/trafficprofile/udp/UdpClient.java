package com.cellrebel.sdk.trafficprofile.udp;

import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;
import java.net.DatagramSocket;

public class UdpClient {
    private final String a;
    private final int b;
    private final DatagramSocket c;
    private final UdpMessageSender d;
    private final UdpMessageReceiver e;

    public interface UdpClientListener {
        void a();

        void a(UdpMessage udpMessage, long j);
    }

    public UdpClient(String str, int i) {
        this.a = str;
        this.b = i;
        DatagramSocket datagramSocket = new DatagramSocket();
        this.c = datagramSocket;
        this.d = new UdpMessageSender(str, i, datagramSocket);
        this.e = new UdpMessageReceiver(datagramSocket);
    }

    public void a(UdpClientListener udpClientListener) {
        this.e.b(udpClientListener);
    }

    public void a(UdpMessage udpMessage) {
        this.d.b(udpMessage);
    }
}
