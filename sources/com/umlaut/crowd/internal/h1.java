package com.umlaut.crowd.internal;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class h1 extends Thread implements AutoCloseable {
    private f3 a = new f3();
    private String b;
    private int c;
    private int d;
    private Socket e;
    private boolean f = false;

    public h1(String str, int i, int i2) {
        this.b = str;
        this.c = i;
        this.d = i2;
    }

    public u5 a(s5 s5Var) throws IOException, u9 {
        u5 b2;
        if (this.f) {
            synchronized (this) {
                Socket socket = this.e;
                if (socket == null || !socket.isConnected()) {
                    throw new IOException("Socket not connected");
                }
                this.a.a(this.e.getOutputStream(), s5Var);
                b2 = this.a.b(this.e.getInputStream());
            }
            return b2;
        }
        throw new IOException("Socket not connected");
    }

    public void close() throws Exception {
        h();
        join();
    }

    public boolean g() throws UnknownHostException {
        try {
            Socket socket = new Socket();
            this.e = socket;
            socket.setSoTimeout(this.d);
            this.e.connect(new InetSocketAddress(this.b, this.c), this.d);
            if (!this.e.isConnected()) {
                this.f = false;
                return false;
            }
            this.f = true;
            start();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void h() {
        this.f = false;
        interrupt();
        try {
            this.e.shutdownOutput();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this.e.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.f = false;
        synchronized (this) {
            this.e = null;
        }
    }

    public void run() {
        c0 c0Var = new c0();
        while (this.f) {
            try {
                if (q9.a((long) ((this.d / 2) + 1))) {
                    a((s5) c0Var);
                }
            } catch (u9 | IOException unused) {
            }
        }
    }

    public void a(int i) {
        this.c = i;
    }
}
