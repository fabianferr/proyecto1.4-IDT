package com.cellrebel.sdk.trafficprofile;

import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;

public class TrafficProfileServerSelector {
    private DatagramSocket a;

    public TrafficProfileServerSelector() {
        try {
            this.a = new DatagramSocket();
        } catch (SocketException e) {
            e.getMessage();
        }
    }

    public String a(List<String> list, int i, int i2, int i3) {
        Iterator<String> it;
        String str;
        List<String> list2 = list;
        String str2 = null;
        if (!(this.a == null || list2 == null || list.isEmpty())) {
            if (list.size() == 1) {
                return list2.get(0);
            }
            Iterator<String> it2 = list.iterator();
            long j = Long.MAX_VALUE;
            while (it2.hasNext()) {
                String next = it2.next();
                try {
                    InetAddress byName = InetAddress.getByName(next);
                    byte[] bArr = new byte[1024];
                    long j2 = 0;
                    int i4 = i2;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < i4) {
                        UdpMessage udpMessage = new UdpMessage(UdpMessageType.PING);
                        udpMessage.c = i5;
                        byte[] bArr2 = bArr;
                        long currentTimeMillis = System.currentTimeMillis();
                        udpMessage.b = currentTimeMillis;
                        byte[] a2 = udpMessage.a(currentTimeMillis);
                        it = it2;
                        try {
                            str = next;
                        } catch (Exception unused) {
                            int i7 = i;
                            int i8 = i3;
                            it2 = it;
                        }
                        try {
                            this.a.send(new DatagramPacket(a2, a2.length, byName, i));
                            DatagramPacket datagramPacket = new DatagramPacket(bArr2, 1024);
                            try {
                                this.a.setSoTimeout(i3);
                                try {
                                    this.a.receive(datagramPacket);
                                    j2 += System.currentTimeMillis() - currentTimeMillis;
                                    i6++;
                                } catch (SocketTimeoutException unused2) {
                                }
                                i5++;
                                i4 = i2;
                                bArr = bArr2;
                                it2 = it;
                                next = str;
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            int i82 = i3;
                            it2 = it;
                        }
                    }
                    int i9 = i;
                    it = it2;
                    String str3 = next;
                    int i10 = i3;
                    this.a.close();
                    if (i6 > 0) {
                        long j3 = j2 / ((long) i6);
                        if (j3 < j) {
                            j = j3;
                            it2 = it;
                            str2 = str3;
                        }
                    }
                } catch (Exception unused5) {
                    int i11 = i;
                    int i12 = i3;
                    it = it2;
                }
                it2 = it;
            }
        }
        return str2;
    }
}
