package com.cellrebel.sdk.trafficprofile.udp;

import com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils;
import com.cellrebel.sdk.trafficprofile.udp.UdpClient;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UdpMessageReceiver {
    private final DatagramSocket a;
    private Thread b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType[] r0 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.HANDSHAKE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.PING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.DOWNLINK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.DOWNLINK_READY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.trafficprofile.udp.UdpMessageReceiver.a.<clinit>():void");
        }
    }

    UdpMessageReceiver(DatagramSocket datagramSocket) {
        this.a = datagramSocket;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(UdpClient.UdpClientListener udpClientListener) {
        byte[] bArr = new byte[65536];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 65536);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.a.receive(datagramPacket);
                long b2 = TrafficProfileMeasurementUtils.a().b();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.BIG_ENDIAN);
                UdpMessageType a2 = UdpMessageType.a(wrap.getInt());
                if (a2 == null) {
                    udpClientListener.a();
                } else {
                    int i = a.a[a2.ordinal()];
                    UdpMessage udpMessage = i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new UdpMessage(bArr) : new UdpPackageMessage(bArr, datagramPacket.getLength()) : new UdpMessage(bArr) : new UdpMessage(bArr);
                    if (udpMessage != null) {
                        udpClientListener.a(udpMessage, b2);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public void b(UdpClient.UdpClientListener udpClientListener) {
        if (this.a == null) {
            udpClientListener.a();
            return;
        }
        Thread thread = new Thread(new UdpMessageReceiver$$ExternalSyntheticLambda0(this, udpClientListener));
        this.b = thread;
        thread.start();
    }
}
