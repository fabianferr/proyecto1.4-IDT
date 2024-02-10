package com.umlaut.crowd.internal;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class gd extends SSLSocketFactory {
    private final SSLSocketFactory a;
    private final InetAddress b;

    public gd(InetAddress inetAddress) throws NoSuchAlgorithmException {
        if (Build.VERSION.SDK_INT >= 24) {
            this.a = SSLContext.getDefault().getSocketFactory();
        } else {
            this.a = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        }
        this.b = inetAddress;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (z) {
            socket.close();
        }
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(this.b, i);
        if (Build.VERSION.SDK_INT >= 24) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SNIHostName(str));
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setServerNames(arrayList);
            sSLSocket.setSSLParameters(sSLParameters);
        } else {
            j3.a((SSLCertificateSocketFactory) this.a, (Socket) sSLSocket, str);
        }
        return sSLSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i) throws IOException {
        return this.a.createSocket(str, i);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return this.a.createSocket(str, i, inetAddress, i2);
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return this.a.createSocket(inetAddress, i);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return this.a.createSocket(inetAddress, i, inetAddress2, i2);
    }
}
