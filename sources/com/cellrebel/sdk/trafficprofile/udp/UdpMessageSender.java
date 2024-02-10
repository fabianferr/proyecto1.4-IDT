package com.cellrebel.sdk.trafficprofile.udp;

import com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UdpMessageSender {
    private final String a;
    private final int b;
    private final DatagramSocket c;
    private final ExecutorService d = Executors.newCachedThreadPool();

    UdpMessageSender(String str, int i, DatagramSocket datagramSocket) {
        this.a = str;
        this.b = i;
        this.c = datagramSocket;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(UdpMessage udpMessage) {
        try {
            byte[] a2 = udpMessage.a(TrafficProfileMeasurementUtils.a().b());
            this.c.send(new DatagramPacket(a2, a2.length, InetAddress.getByName(this.a), this.b));
        } catch (IOException unused) {
        }
    }

    public void b(UdpMessage udpMessage) {
        if (this.c != null) {
            this.d.execute(new UdpMessageSender$$ExternalSyntheticLambda0(this, udpMessage));
        }
    }
}
