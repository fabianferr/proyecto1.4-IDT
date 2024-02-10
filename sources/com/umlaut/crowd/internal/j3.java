package com.umlaut.crowd.internal;

import android.net.SSLCertificateSocketFactory;
import android.webkit.URLUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;

public class j3 {
    private static final String a = "j3";
    private static final boolean b = false;

    public static HttpURLConnection a(String str, int i, boolean z) throws IOException {
        boolean isHttpsUrl = URLUtil.isHttpsUrl(str);
        URL url = new URL(str);
        String host = url.getHost();
        if (z && !isHttpsUrl) {
            InetAddress inetAddress = f2.a().a(host, i, true).d()[0];
            String hostAddress = inetAddress.getHostAddress();
            if (inetAddress instanceof Inet6Address) {
                hostAddress = "[" + hostAddress + "]";
            }
            url = new URL(str.replace(host, hostAddress));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (z && isHttpsUrl && (httpURLConnection instanceof HttpsURLConnection)) {
            try {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new gd(f2.a().a(host, i, true).d()[0]));
            } catch (NoSuchAlgorithmException e) {
                throw new IOException(e);
            }
        }
        return httpURLConnection;
    }

    public static void a(SSLCertificateSocketFactory sSLCertificateSocketFactory, Socket socket, String str) {
        sSLCertificateSocketFactory.setHostname(socket, str);
    }
}
