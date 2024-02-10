package com.bytedance.sdk.openadsdk.utils;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.SecureRandom;
import java.util.UUID;
import okio.Utf8;

/* compiled from: PangleUUID */
public class r {
    private static final ThreadLocal<SecureRandom> a = new ThreadLocal<>();

    public static String a() {
        byte[] bArr = new byte[16];
        ThreadLocal<SecureRandom> threadLocal = a;
        SecureRandom secureRandom = threadLocal.get();
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
            threadLocal.set(secureRandom);
        }
        secureRandom.nextBytes(bArr);
        byte b = (byte) (bArr[6] & Ascii.SI);
        bArr[6] = b;
        bArr[6] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        byte b2 = (byte) (bArr[8] & Utf8.REPLACEMENT_BYTE);
        bArr[8] = b2;
        bArr[8] = (byte) (b2 | 128);
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 << 8) | ((long) (bArr[i] & 255));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return new UUID(j2, j).toString();
    }
}
