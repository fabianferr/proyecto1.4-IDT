package com.umlaut.crowd.internal;

import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {
    private static final String a = "c";
    private static final String b = "AES";
    private static final String c = "AES/CBC/PKCS5Padding";

    public static IvParameterSpec a() {
        return new IvParameterSpec(new SecureRandom().generateSeed(16));
    }

    public static SecretKey b() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(b);
            instance.init(256);
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            String str = a;
            Log.e(str, "generateSecretKey: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, SecretKey secretKey, IvParameterSpec ivParameterSpec) {
        try {
            Cipher instance = Cipher.getInstance(c);
            instance.init(1, secretKey, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            String str = a;
            Log.e(str, "encrypt: " + e.getMessage());
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, b);
            Cipher instance = Cipher.getInstance(c);
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            String str = a;
            Log.e(str, "decrypt: " + e.getMessage());
            return null;
        }
    }
}
