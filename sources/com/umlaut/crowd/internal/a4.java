package com.umlaut.crowd.internal;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class a4 {
    public static String a(String str, int i, int i2) {
        InetAddress inetAddress;
        InetAddress inetAddress2;
        try {
            inetAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet4Address) {
            inetAddress2 = a((Inet4Address) inetAddress, i);
        } else {
            inetAddress2 = inetAddress instanceof Inet6Address ? a((Inet6Address) inetAddress, i2) : null;
        }
        if (inetAddress2 != null) {
            return inetAddress2.getHostAddress();
        }
        return null;
    }

    public static Inet4Address a(Inet4Address inet4Address, int i) {
        try {
            byte[] address = inet4Address.getAddress();
            a(address, i);
            return (Inet4Address) InetAddress.getByAddress(address);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static Inet6Address a(Inet6Address inet6Address, int i) {
        byte[] address = inet6Address.getAddress();
        a(address, i);
        try {
            return (Inet6Address) InetAddress.getByAddress(address);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    private static void a(byte[] bArr, int i) {
        while (i > 0) {
            bArr[bArr.length - i] = 0;
            i--;
        }
    }
}
