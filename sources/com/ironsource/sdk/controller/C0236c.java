package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.MutableContextWrapper;

/* renamed from: com.ironsource.sdk.controller.c  reason: case insensitive filesystem */
public final class C0236c {
    private MutableContextWrapper a;

    public final Activity a() {
        return (Activity) this.a.getBaseContext();
    }

    public final synchronized void a(Activity activity) {
        if (this.a == null) {
            this.a = new MutableContextWrapper(activity);
        }
        this.a.setBaseContext(activity);
    }

    public final synchronized void b() {
        this.a = null;
    }
}
