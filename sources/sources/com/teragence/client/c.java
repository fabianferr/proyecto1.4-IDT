package com.teragence.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class c implements g {
    private InetAddress a;

    public DatagramSocket a(int i) {
        Random random = new Random();
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 10) {
                try {
                    return this.a != null ? new DatagramSocket(random.nextInt(5000) + i, this.a) : new DatagramSocket(random.nextInt(5000) + i);
                } catch (IOException unused) {
                    i2 = i3;
                }
            } else {
                throw new IOException("No available ports to bind");
            }
        }
    }

    public Socket a(InetAddress inetAddress, int i) {
        return this.a != null ? new Socket(inetAddress, i, this.a, 0) : new Socket(inetAddress, i);
    }
}
