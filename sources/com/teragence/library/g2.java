package com.teragence.library;

import android.content.Context;
import android.os.PowerManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class g2 implements d2 {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final PowerManager.WakeLock b;
    private final Context c;

    public g2(PowerManager.WakeLock wakeLock, Context context) {
        this.b = wakeLock;
        this.c = context;
    }

    public AtomicBoolean a() {
        return this.a;
    }

    public void b() {
        try {
            if (this.a.get()) {
                v0.a(this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b.release();
    }
}
