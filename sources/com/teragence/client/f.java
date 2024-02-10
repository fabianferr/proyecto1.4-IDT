package com.teragence.client;

import android.content.Context;
import com.teragence.library.v0;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class f implements g {
    private Context a;
    private InetAddress b;
    private boolean c;

    public f(Context context, InetAddress inetAddress, boolean z) {
        this.a = context;
        this.b = inetAddress;
        this.c = z;
    }

    public DatagramSocket a(int i) {
        if (v0.c(this.a, this.b) || this.c) {
            Random random = new Random();
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 < 10) {
                    try {
                        return new DatagramSocket(random.nextInt(5000) + i);
                    } catch (IOException unused) {
                        i2 = i3;
                    }
                } else {
                    throw new IOException("No available ports to bind");
                }
            }
        } else {
            throw new IOException("Desired network not available");
        }
    }

    public Socket a(InetAddress inetAddress, int i) {
        if (v0.c(this.a, this.b) || this.c) {
            return new Socket(inetAddress, i);
        }
        throw new IOException("Desired network not available");
    }
}
