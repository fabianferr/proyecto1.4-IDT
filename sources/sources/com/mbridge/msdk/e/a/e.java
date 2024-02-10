package com.mbridge.msdk.e.a;

import android.util.Log;

/* compiled from: DefaultRetryPolicy */
public final class e implements r {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void a(u uVar) throws u {
        Log.d("DefaultRetryPolicy", "============= retry: " + uVar);
        boolean z = true;
        int i = this.b + 1;
        this.b = i;
        int i2 = this.a;
        this.a = i2 + ((int) (((float) i2) * this.d));
        if (i > this.c) {
            z = false;
        }
        if (!z) {
            throw uVar;
        }
    }
}
