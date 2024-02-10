package com.iab.omid.library.bytedance2.internal;

import android.content.Context;

public class f {
    private static f b = new f();
    private Context a;

    private f() {
    }

    public static f b() {
        return b;
    }

    public Context a() {
        return this.a;
    }

    public void a(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }
}
