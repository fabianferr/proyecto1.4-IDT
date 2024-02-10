package com.umlaut.crowd.internal;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class a8 {
    private static final String a = "a8";
    private static final String b = "RSA";
    private static final String c = "RSA/ECB/PKCS1Padding";

    public static PrivateKey a(byte[] bArr) {
        try {
            return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(bArr));
        } catch (Exception e) {
            String str = a;
            Log.e(str, "readPublicKey: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static PublicKey b(byte[] bArr) {
        try {
            return KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e) {
            String str = a;
            Log.e(str, "readPublicKey: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static PrivateKey a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                String str = a;
                Log.e(str, "readPrivateKey: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return a(byteArrayOutputStream.toByteArray());
    }

    public static PublicKey b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                String str = a;
                Log.e(str, "readPublicKey: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return b(byteArrayOutputStream.toByteArray());
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(c);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            String str = a;
            Log.e(str, "encrypt: " + e.getMessage());
            return null;
        }
    }

    public static byte[] a(byte[] bArr, PrivateKey privateKey) {
        try {
            Cipher instance = Cipher.getInstance(c);
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            String str = a;
            Log.e(str, "encrypt: " + e.getMessage());
            return null;
        }
    }
}
