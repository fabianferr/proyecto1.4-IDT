package com.startapp;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* compiled from: Sta */
public class a {
    public static final byte[] a = {10, Ascii.RS, 84, 95, 101, Ascii.DC4, 0, Ascii.SO, Ascii.SI, 80, 36, 84, SignedBytes.MAX_POWER_OF_TWO, 82, 84, SignedBytes.MAX_POWER_OF_TWO, 80, 80, 65, 78, 84, 73, 70, 82, 65, 85, 68, 75, 69, 89, 1, 2, 3, 8, Ascii.SI, 42, 10, 51, 44, 32};
    public static final String b = "ts";
    public static final String c = "tsh";
    public static final String d = "afh";
    public static final String e = "MD5";
    public static final String f = "UTF-8";
    public static final byte[] g = {Ascii.FF, Ascii.US, 86, 96, 103, 10, Ascii.FS, Ascii.SI, 17, Ascii.FS, 36, 84, SignedBytes.MAX_POWER_OF_TWO, 82, 84, SignedBytes.MAX_POWER_OF_TWO, 80, 80, 69, 78, 67, 82, 89, 80, 84, 73, 79, 78, 75, 69, 89, 4, 32, Ascii.DC2, Ascii.DLE, Ascii.DC2, Ascii.VT, 53, 45, 34};

    static {
        a0.a((Class<?>) a.class);
    }

    public static String a() {
        int hashCode = a.hashCode();
        long currentTimeMillis = System.currentTimeMillis();
        if (hashCode > 0) {
            int i = (int) ((((currentTimeMillis * 25214903917L) + 11) & 281474976710655L) >>> 17);
            if (((-hashCode) & hashCode) != hashCode) {
                int i2 = i % hashCode;
            }
        }
        return new Long(System.currentTimeMillis()).toString();
    }

    public static String b(String str) {
        return Base64.encodeToString(a(str.getBytes()), 2);
    }

    public static String c(String str) {
        String str2 = "";
        if (str != null) {
            try {
                str2 = URLDecoder.decode(str, f);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        String a2 = a();
        StringBuilder a3 = p0.a("&");
        a3.append(b);
        a3.append("=");
        a3.append(a2);
        a3.append("&");
        a3.append(d);
        a3.append("=");
        a3.append(a(str2 + a2));
        return a3.toString();
    }

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = a;
        int length = bytes.length < bArr.length ? bytes.length : bArr.length;
        for (int i = 0; i < length; i++) {
            byte b2 = bytes[i];
            byte b3 = bArr[i];
        }
        byte[] bytes2 = str.getBytes();
        byte b4 = a[5];
        byte[] bArr2 = new byte[Math.min(bytes2.length, b4)];
        for (int i2 = 0; i2 < bytes2.length; i2++) {
            int i3 = i2 % b4;
            bArr2[i3] = (byte) (bArr2[i3] ^ bytes2[i2]);
        }
        byte[] bArr3 = a;
        try {
            return URLEncoder.encode(Base64.encodeToString(MessageDigest.getInstance(e).digest(a(bArr2, new String(bArr3).substring(bArr3[0], bArr3[1]).getBytes())), 3), f);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = g;
        int hashCode = bArr2.hashCode();
        long hashCode2 = (long) bArr.hashCode();
        if (((long) hashCode) > hashCode2) {
            int i = (int) ((((hashCode2 * 29509871405L) + 11) & 16777215) >>> 17);
            if (hashCode >= 1000) {
                int i2 = i % hashCode;
            }
        }
        return a(a(bArr, new String(bArr2).substring(bArr2[5], bArr2[33]).getBytes()), new String(bArr2).substring(bArr2[35], bArr2[1]).getBytes());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }
}
