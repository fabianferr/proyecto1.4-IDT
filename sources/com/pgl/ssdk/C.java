package com.pgl.ssdk;

import android.content.Context;
import com.pgl.ssdk.ces.a;

public class C implements Runnable {
    private final byte[] a;
    private final A b;
    private final Context c;

    public C(byte[] bArr, Context context, A a2) {
        this.a = bArr;
        this.b = a2;
        this.c = context;
    }

    public void run() {
        Object meta = a.meta(302, this.c, this.a);
        if ((meta instanceof Integer) && ((Integer) meta).intValue() == 0) {
            A a2 = this.b;
            a2.b = 0;
            a2.quit();
        } else if (meta instanceof String) {
            A a3 = this.b;
            a3.b = 0;
            a3.quit();
            y.c = (String) meta;
        } else {
            A a4 = this.b;
            a4.b++;
            a4.g.sendEmptyMessageDelayed(1, 10000);
            return;
        }
        y.a = 200;
    }
}
