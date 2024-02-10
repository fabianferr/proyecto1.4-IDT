package com.bykv.vk.openvk.preload.geckox.utils;

import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.Closeable;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: MD5Utils */
public final class g {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                    CloseableUtils.close((Closeable) inputStream);
                    try {
                        byte[] digest = instance.digest();
                        String a2 = a(digest, digest.length);
                        if (!str.equals(a2)) {
                            throw new RuntimeException("md5 check failed file: local md5:" + a2 + " expect md5:" + str);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("md5 check failed:" + e.getMessage(), e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("md5 check failed:" + e2.getMessage(), e2);
                } catch (Throwable th) {
                    CloseableUtils.close((Closeable) inputStream);
                    throw th;
                }
            } catch (Exception e3) {
                throw new RuntimeException("md5 check failed:" + e3.getMessage(), e3);
            }
        } else {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
    }

    private static String a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i + 0 <= bArr.length) {
            int i2 = i * 2;
            char[] cArr = new char[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                byte b = bArr[i4 + 0] & 255;
                int i5 = i3 + 1;
                char[] cArr2 = a;
                cArr[i3] = cArr2[b >> 4];
                i3 = i5 + 1;
                cArr[i5] = cArr2[b & Ascii.SI];
            }
            return new String(cArr, 0, i2);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
