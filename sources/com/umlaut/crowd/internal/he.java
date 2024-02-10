package com.umlaut.crowd.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Callable;

public class he implements Callable<Integer> {
    private int[] a;
    private int[] b;

    public he(int[] iArr, int[] iArr2) {
        this.a = iArr;
        this.b = iArr2;
    }

    /* renamed from: a */
    public Integer call() {
        int i = this.a[0];
        int i2 = 0;
        while (i <= this.b[0] && i < 255) {
            int i3 = this.a[1];
            while (i3 <= this.b[1] && i3 < 255) {
                int i4 = this.a[2];
                while (i4 <= this.b[2] && i4 < 255) {
                    int i5 = this.a[3];
                    while (i5 <= this.b[3] && i5 < 255) {
                        try {
                            if (InetAddress.getByName(i + "." + i3 + "." + i4 + "." + i5).isReachable(100)) {
                                i2++;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        i5++;
                    }
                    i4++;
                }
                i3++;
            }
            i++;
        }
        return Integer.valueOf(i2);
    }
}
