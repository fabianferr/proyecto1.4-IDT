package com.umlaut.crowd.internal;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a5 {
    private static final String a = "a5";
    private static final String b = "MD5";
    private static final int c = 8192;

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            String str = a;
            Log.e(str, "hash byte[]: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
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
