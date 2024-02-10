package com.teragence.library;

import com.teragence.client.i;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class x0 {
    private static final String a = "com.teragence.library.x0";

    public static List<y0> a(InetAddress inetAddress, int i, UUID uuid, int i2, int i3, int i4, DatagramSocket datagramSocket) {
        InetAddress inetAddress2 = inetAddress;
        int i5 = i;
        int i6 = i2;
        DatagramSocket datagramSocket2 = datagramSocket;
        datagramSocket2.setSoTimeout(500);
        ArrayList arrayList = new ArrayList(i6);
        byte[] a2 = f5.a(uuid);
        int i7 = i3 - 8;
        int i8 = 4;
        while (true) {
            int i9 = i8 - 1;
            if (i8 > 0 && arrayList.size() == 0) {
                i.a(a, String.format("Sending receive initiator", new Object[0]));
                datagramSocket2.send(new DatagramPacket(a2, a2.length, inetAddress2, i5));
                long j = (long) i4;
                long currentTimeMillis = System.currentTimeMillis() + j;
                while (currentTimeMillis > System.currentTimeMillis()) {
                    try {
                        DatagramPacket datagramPacket = new DatagramPacket(new byte[i7], i7, inetAddress2, i5);
                        datagramSocket2.receive(datagramPacket);
                        if (datagramPacket.getLength() >= i7) {
                            if (arrayList.size() == 0) {
                                currentTimeMillis = System.currentTimeMillis() + j;
                            }
                            arrayList.add(new z0(System.currentTimeMillis(), datagramPacket));
                            currentTimeMillis = currentTimeMillis;
                        }
                        if (arrayList.size() >= i6) {
                            break;
                        }
                    } catch (SocketTimeoutException unused) {
                        i.a(a, String.format("Burst receive timeout", new Object[0]));
                        arrayList.size();
                    }
                }
                i8 = i9;
            }
        }
        return a((z0[]) arrayList.toArray(new z0[arrayList.size()]));
    }

    private static List<y0> a(z0[] z0VarArr) {
        int length = z0VarArr.length;
        y0[] y0VarArr = new y0[length];
        StringBuilder sb = new StringBuilder();
        if (length > 0) {
            long j = z0VarArr[0].a;
            for (int i = 0; i < length; i++) {
                y0 y0Var = new y0((int) (z0VarArr[i].a - j), ByteBuffer.wrap(z0VarArr[i].b.getData()).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
                y0VarArr[i] = y0Var;
                sb.append(y0Var.b);
                sb.append(": ");
                sb.append(y0VarArr[i].c);
                sb.append(", ");
            }
            Arrays.sort(y0VarArr);
        }
        i.a(a, String.format("Received: %s", new Object[]{sb.toString()}));
        return Arrays.asList(y0VarArr);
    }
}
