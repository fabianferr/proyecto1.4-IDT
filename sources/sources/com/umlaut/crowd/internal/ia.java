package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpVersion;

public class ia extends x6 {
    public static final String j = "ia";
    private static final boolean k = false;
    private static final String l = "\r\n";
    private final int h;
    private final String i;

    public ia(Context context, w6 w6Var, String str, int i2, int i3, int i4, int i5, String str2) {
        this.a = context;
        this.b = w6Var;
        this.c = str;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.h = i5;
        this.i = str2;
    }

    public boolean a(p4 p4Var) {
        int i2;
        long j2;
        this.b.a();
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(this.f);
        SocketFactory socketFactory = SocketFactory.getDefault();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i3 = 0; i3 < this.d; i3++) {
            if (this.g) {
                return false;
            }
            Socket socket = null;
            try {
                Socket a = a(socketFactory, sSLCertificateSocketFactory, this.i, this.c, this.h, this.f);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a.getInputStream()));
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                this.b.a(i3, elapsedRealtime2);
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                a(this.c, "/garbage", a.getOutputStream());
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.toUpperCase().startsWith(HttpVersion.HTTP)) {
                            j2 = SystemClock.elapsedRealtime();
                            break;
                        }
                    } else {
                        j2 = 0;
                        break;
                    }
                }
                try {
                    a.close();
                } catch (Exception unused) {
                }
                if (j2 > 0) {
                    this.b.b(i3, elapsedRealtime2, (long) ((int) (j2 - elapsedRealtime3)));
                } else {
                    this.b.b(i3, SystemClock.elapsedRealtime() - elapsedRealtime, -1);
                }
                try {
                    i2 = this.e;
                    Thread.sleep((long) i2);
                } catch (InterruptedException unused2) {
                }
            } catch (IOException unused3) {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception unused4) {
                    }
                }
                this.b.b(i3, SystemClock.elapsedRealtime() - elapsedRealtime, -1);
                i2 = this.e;
            } catch (Throwable th) {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception unused5) {
                    }
                }
                this.b.b(i3, SystemClock.elapsedRealtime() - elapsedRealtime, -1);
                try {
                    Thread.sleep((long) this.e);
                } catch (InterruptedException unused6) {
                }
                throw th;
            }
        }
        return true;
    }

    private Socket a(SocketFactory socketFactory, SSLCertificateSocketFactory sSLCertificateSocketFactory, String str, String str2, int i2, int i3) throws IOException {
        Socket socket;
        boolean z = i2 == 443;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str2, i2);
        if (z) {
            socket = sSLCertificateSocketFactory.createSocket();
            socket.connect(inetSocketAddress, i3);
            j3.a(sSLCertificateSocketFactory, socket, str);
            ((SSLSocket) socket).startHandshake();
        } else {
            socket = socketFactory.createSocket();
            socket.connect(inetSocketAddress, i3);
        }
        socket.setTcpNoDelay(true);
        socket.setSoTimeout(i3);
        return socket;
    }

    private void a(String str, String str2, OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.print("GARBAGE ");
        printWriter.print(str2);
        printWriter.print(" HTTP/1.1");
        printWriter.print(l);
        printWriter.print("HOST: ");
        printWriter.print(str);
        printWriter.print(l);
        printWriter.print("Connection: close");
        printWriter.print(l);
        printWriter.print(l);
        printWriter.flush();
    }

    public void a() {
        this.g = true;
    }
}
