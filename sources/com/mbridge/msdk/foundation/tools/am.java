package com.mbridge.msdk.foundation.tools;

import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* compiled from: Util */
final class am {

    /* compiled from: Util */
    private static class a {
        static final SecureRandom a = new SecureRandom();
        static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    static String a() {
        byte[] bArr = new byte[16];
        a.a.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = i << 1;
            cArr[i2] = a.b[(b >> 4) & 15];
            cArr[i2 + 1] = a.b[b & Ascii.SI];
        }
        return new String(cArr);
    }

    static int b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get((Object) null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    static boolean a(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || ((!parentFile.isDirectory() && !parentFile.mkdirs()) || !file.createNewFile())) {
            return false;
        }
        return true;
    }

    static byte[] b(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i = (int) length;
            byte[] bArr = new byte[i];
            a(file, bArr, i);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    static void a(File file, byte[] bArr, int i) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i2 = 0;
        while (i2 < i) {
            try {
                int read = randomAccessFile.read(bArr, i2, i - i2);
                if (read < 0) {
                    break;
                }
                i2 += read;
            } catch (Throwable th) {
                a((Closeable) randomAccessFile);
                throw th;
            }
        }
        a((Closeable) randomAccessFile);
    }

    static boolean a(File file, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        try {
            String parent = file.getParent();
            File file2 = new File(parent, file.getName() + ".tmp");
            if (!a(file2)) {
                return false;
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            randomAccessFile.setLength((long) bArr.length);
            randomAccessFile.write(bArr);
            a((Closeable) randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Exception unused) {
        } catch (Throwable th) {
            a((Closeable) randomAccessFile);
            throw th;
        }
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static void c(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Exception unused) {
        }
    }

    private static void d(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File d : listFiles) {
                d(d);
            }
        }
        file.delete();
    }
}
