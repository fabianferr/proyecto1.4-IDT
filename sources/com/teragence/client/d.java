package com.teragence.client;

import android.net.Network;
import android.os.Build;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class d implements g {
    private static final String b = "com.teragence.client.d";
    private Network a;

    public d(Network network) {
        this.a = network;
    }

    public DatagramSocket a(int i) {
        DatagramSocket datagramSocket;
        String str;
        StringBuilder sb;
        Random random = new Random();
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 10) {
                try {
                    datagramSocket = new DatagramSocket(random.nextInt(5000) + i);
                    if (Build.VERSION.SDK_INT < 22) {
                        if (Build.VERSION.SDK_INT != 21) {
                            break;
                        }
                        try {
                            int intValue = ((Integer) FileDescriptor.class.getMethod("getInt$", new Class[0]).invoke((FileDescriptor) DatagramSocket.class.getMethod("getFileDescriptor$", new Class[0]).invoke(datagramSocket, new Object[0]), new Object[0])).intValue();
                            int i4 = Network.class.getField("netId").getInt(this.a);
                            Class<?> cls = Class.forName("android.net.NetworkUtils");
                            cls.getMethod("bindSocketToNetwork", new Class[]{Integer.TYPE, Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(intValue), Integer.valueOf(i4)});
                            break;
                        } catch (Exception unused) {
                            i.b(b, "Failed to bind socket to network");
                        } catch (Throwable th) {
                            str = b;
                            sb = new StringBuilder();
                            sb.append("Failed to bind socket to network error:");
                            sb.append(th.getMessage());
                            break;
                        }
                    } else {
                        try {
                            Network.class.getMethod("bindSocket", new Class[]{DatagramSocket.class}).invoke(this.a, new Object[]{datagramSocket});
                            break;
                        } catch (Exception e) {
                            str = b;
                            sb = new StringBuilder();
                            sb.append("Failed to bind datagram socket to network, error: ");
                            sb.append(e.getMessage());
                        } catch (Throwable th2) {
                            str = b;
                            sb = new StringBuilder();
                            sb.append("Failed to bind datagram socket to network, error:");
                            sb.append(th2.getMessage());
                            break;
                        }
                    }
                } catch (IOException unused2) {
                    i2 = i3;
                }
            } else {
                throw new IOException("No available ports to bind");
            }
        }
        i.b(str, sb.toString());
        return datagramSocket;
    }

    public Socket a(InetAddress inetAddress, int i) {
        try {
            return this.a.getSocketFactory().createSocket(inetAddress, i);
        } catch (Exception unused) {
            i.c(b, "newTcpSocket with bound network failed");
            return new Socket(inetAddress, i);
        }
    }
}
