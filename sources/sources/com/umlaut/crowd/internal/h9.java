package com.umlaut.crowd.internal;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class h9 {
    private static final String a = "h9";
    private static final String b = "SHA-256";
    private static final int c = 8192;

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(b);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            String str = a;
            Log.e(str, "hash: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(b);
            instance.update(bArr2);
            return instance.digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            String str = a;
            Log.e(str, "hash: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance(b);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (Exception e) {
            String str = a;
            Log.e(str, "hash File: " + e.getMessage());
            return null;
        }
    }
}
