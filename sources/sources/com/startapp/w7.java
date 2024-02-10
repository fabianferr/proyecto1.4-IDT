package com.startapp;

import com.startapp.simple.bloomfilter.algo.OpenBitSet;
import com.startapp.simple.bloomfilter.version.BloomVersion;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: Sta */
public class w7 {
    public static String a(List<String> list) {
        d1 d1Var = new d1();
        long currentTimeMillis = System.currentTimeMillis();
        BloomVersion bloomVersion = BloomVersion.FOUR;
        y0 y0Var = d1Var.b.a.get(bloomVersion).b;
        y0Var.getClass();
        OpenBitSet openBitSet = new OpenBitSet((long) (y0Var.a * y0Var.b));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ByteBuffer wrap = ByteBuffer.wrap(it.next().getBytes());
            long c = openBitSet.c();
            int i = y0Var.a;
            long[] jArr = new long[i];
            long j = c / ((long) i);
            long j2 = currentTimeMillis;
            long a = p5.a(wrap, wrap.position(), wrap.remaining(), 0);
            long a2 = p5.a(wrap, wrap.position(), wrap.remaining(), a);
            Iterator<String> it2 = it;
            int i2 = 0;
            while (i2 < y0Var.a) {
                BloomVersion bloomVersion2 = bloomVersion;
                long j3 = (long) i2;
                jArr[i2] = Math.abs(((j3 * a2) + a) % j) + (j3 * j);
                i2++;
                bloomVersion = bloomVersion2;
                y0Var = y0Var;
            }
            BloomVersion bloomVersion3 = bloomVersion;
            y0 y0Var2 = y0Var;
            for (int i3 = 0; i3 < i; i3++) {
                openBitSet.b(jArr[i3]);
            }
            bloomVersion = bloomVersion3;
            currentTimeMillis = j2;
            it = it2;
            y0Var = y0Var2;
        }
        long j4 = currentTimeMillis;
        BloomVersion bloomVersion4 = bloomVersion;
        o8 o8Var = d1Var.a;
        o8Var.getClass();
        try {
            String a3 = o8Var.a.a(openBitSet);
            p8 p8Var = o8Var.b.a.get(bloomVersion4).a;
            return j4 + "-" + bloomVersion4.c() + "-" + p8Var.a(a3);
        } catch (Throwable unused) {
            return null;
        }
    }
}
