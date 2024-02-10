package com.teragence.library;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class w4 {
    private final Socket a;
    private final InetAddress b;

    public static class a {
        private final double a;
        private final double b;
        private final int c;

        public a(double d, double d2, int i) {
            this.a = d;
            this.b = d2;
            this.c = i;
        }

        public double a() {
            return this.b;
        }

        public double b() {
            return this.a;
        }

        public int c() {
            return this.c;
        }

        public String toString() {
            return "TestResult{completeTime=" + this.a + ", bodyTime=" + this.b + ", totalCount=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public w4(Socket socket, InetAddress inetAddress) {
        this.a = socket;
        this.b = inetAddress;
    }

    public a a() {
        String bigInteger = new BigInteger(130, new Random()).toString(36);
        DataOutputStream dataOutputStream = new DataOutputStream(new DataOutputStream(this.a.getOutputStream()));
        dataOutputStream.writeBytes("GET /rand/" + bigInteger + " HTTP/1.1\r\n");
        dataOutputStream.writeBytes("Host: " + this.b.getHostName() + "\r\n");
        dataOutputStream.writeBytes("Connection: close\r\n\r\n");
        double currentTimeMillis = (double) System.currentTimeMillis();
        dataOutputStream.flush();
        DataInputStream dataInputStream = new DataInputStream(this.a.getInputStream());
        byte[] bArr = new byte[2048];
        double d = -1.0d;
        boolean z = false;
        int i = 0;
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read != -1) {
                if (!z && new String(bArr, 0, read).indexOf("\r\n\r\n") != -1) {
                    double currentTimeMillis2 = (double) System.currentTimeMillis();
                    Double.isNaN(currentTimeMillis2);
                    Double.isNaN(currentTimeMillis);
                    z = true;
                    d = currentTimeMillis2 - currentTimeMillis;
                }
                i += read;
            } else {
                double currentTimeMillis3 = (double) System.currentTimeMillis();
                Double.isNaN(currentTimeMillis3);
                Double.isNaN(currentTimeMillis);
                return new a(currentTimeMillis3 - currentTimeMillis, d, i);
            }
        }
    }
}
