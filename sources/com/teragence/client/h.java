package com.teragence.client;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class h implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }
}
