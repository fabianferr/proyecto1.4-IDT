package com.umlaut.crowd.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class z9 {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8096];
        while (true) {
            int read = inputStream.read(bArr, 0, 8096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static class a {
        public final int a;
        public final String b;
        public final boolean c;

        public a(int i, String str, boolean z) {
            this.a = i;
            this.b = str;
            this.c = z;
        }

        public static a a(InputStream inputStream) throws IOException {
            boolean z;
            byte[] bArr = new byte[1024];
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = inputStream.read();
                z = true;
                i++;
                if (read == 10) {
                    z = false;
                    break;
                } else if (read < 0) {
                    break;
                } else {
                    int i3 = i2 + 1;
                    bArr[i2] = (byte) read;
                    if (i3 == bArr.length) {
                        bArr = Arrays.copyOf(bArr, i3 + 1024);
                    }
                    i2 = i3;
                }
            }
            if (i2 > 0 && bArr[i2 - 1] == 13) {
                i2--;
            }
            return new a(i, new String(bArr, 0, i2, "UTF-8"), z);
        }
    }
}
