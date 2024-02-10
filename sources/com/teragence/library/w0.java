package com.teragence.library;

import com.teragence.client.i;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.List;

public class w0 {
    private static final String a = "com.teragence.library.w0";

    public static int a(InetAddress inetAddress, int i, DatagramSocket datagramSocket, int i2) {
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1], 1);
        datagramPacket.setAddress(inetAddress);
        datagramPacket.setPort(i);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1], 1);
        datagramSocket.setSoTimeout(i2);
        double d = 0.0d;
        byte b = 0;
        int i3 = 0;
        while (true) {
            byte b2 = (byte) (b + 1);
            if (b >= 10) {
                break;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                datagramPacket.setData(new byte[]{b2});
                datagramSocket.send(datagramPacket);
                a(datagramSocket, datagramPacket2, b2);
                double currentTimeMillis2 = (double) ((int) (System.currentTimeMillis() - currentTimeMillis));
                Double.isNaN(currentTimeMillis2);
                d += currentTimeMillis2;
                i3++;
            } catch (SocketTimeoutException unused) {
                i.c(a, "RTT timeout");
            } catch (IOException e) {
                i.a(a, "RTT error", (Exception) e);
            }
            b = b2;
        }
        if (i3 == 0) {
            return 0;
        }
        double d2 = (double) i3;
        Double.isNaN(d2);
        int i4 = (int) (d / d2);
        i.a(a, String.format("RTT average %d", new Object[]{Integer.valueOf(i4)}));
        return i4;
    }

    private static void a(int i) {
        do {
        } while ((System.currentTimeMillis() + ((long) i)) - System.currentTimeMillis() > 0);
    }

    public static void a(DatagramSocket datagramSocket, DatagramPacket datagramPacket, byte b) {
        while (true) {
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            if (datagramPacket.getLength() == 1) {
                if (data[0] != b) {
                    i.c(a, String.format("RTT measurement OOO packet %d, got %d", new Object[]{Byte.valueOf(b), Byte.valueOf(data[0])}));
                } else {
                    return;
                }
            }
        }
    }

    public static void a(List<DatagramPacket> list, int i, DatagramSocket datagramSocket) {
        int i2;
        try {
            i2 = 0;
            for (DatagramPacket send : list) {
                try {
                    a(i);
                    datagramSocket.send(send);
                    i2++;
                } catch (IOException e) {
                    e = e;
                    i.a(a, "sendBurst: ", (Throwable) e);
                    i.a(a, String.format("sent %d packets", new Object[]{Integer.valueOf(i2)}));
                }
            }
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
            i.a(a, "sendBurst: ", (Throwable) e);
            i.a(a, String.format("sent %d packets", new Object[]{Integer.valueOf(i2)}));
        }
        i.a(a, String.format("sent %d packets", new Object[]{Integer.valueOf(i2)}));
    }
}
