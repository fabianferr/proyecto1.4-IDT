package com.umlaut.crowd.internal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public abstract class y8 {
    static boolean a = false;
    static TrustManager[] b;
    static SSLContext c;

    static class a implements X509TrustManager {
        a() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static x8 a(s9 s9Var) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        if (!a) {
            d();
        }
        w8 w8Var = new w8();
        w8Var.a(c);
        w8Var.b(true);
        w8Var.a(false);
        x8 x8Var = new x8(s9Var);
        x8Var.a(w8Var);
        return x8Var;
    }

    public static Socket b() throws IOException, KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        return c.getSocketFactory().createSocket();
    }

    public static SSLContext c() throws KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        return c;
    }

    static synchronized void d() throws KeyManagementException, NoSuchAlgorithmException {
        synchronized (y8.class) {
            if (!a) {
                b = new TrustManager[]{new a()};
                SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
                c = instance;
                instance.init((KeyManager[]) null, b, new SecureRandom());
                a = true;
            }
        }
    }

    public static x8 a(SocketChannel socketChannel) throws KeyManagementException, NoSuchAlgorithmException, SSLException {
        if (!a) {
            d();
        }
        w8 w8Var = new w8();
        w8Var.a(c);
        w8Var.b(true);
        w8Var.a(false);
        x8 x8Var = new x8(socketChannel);
        x8Var.a(w8Var);
        return x8Var;
    }

    public static Socket a(String str, int i) throws IOException, UnknownHostException, KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        return c.getSocketFactory().createSocket(str, i);
    }

    public static ServerSocket a(int i) throws IOException, UnknownHostException, KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        return c.getServerSocketFactory().createServerSocket(i);
    }

    public static Socket a(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException, KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        return c.getSocketFactory().createSocket(socket, str, i, z);
    }

    public static w8 a() throws KeyManagementException, NoSuchAlgorithmException {
        if (!a) {
            d();
        }
        w8 w8Var = new w8();
        w8Var.a(c);
        w8Var.b(true);
        w8Var.a(false);
        return w8Var;
    }
}
