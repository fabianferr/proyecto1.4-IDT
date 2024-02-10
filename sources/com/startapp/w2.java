package com.startapp;

import android.os.Handler;

/* compiled from: Sta */
public class w2 implements v2 {
    public final Handler a;

    public w2(Handler handler) {
        this.a = handler;
    }

    public void a(Runnable runnable, long j) {
        this.a.postDelayed(runnable, j);
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }

    public void a(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
}
