package com.teragence.client;

import com.facebook.internal.security.CertificateUtil;

public class b {
    public int a;
    public int b;

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public String toString() {
        return Integer.toString(this.a) + CertificateUtil.DELIMITER + Integer.toString(this.b);
    }
}
