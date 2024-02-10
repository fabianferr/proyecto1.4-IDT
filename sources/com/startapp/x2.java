package com.startapp;

import android.os.HandlerThread;

/* compiled from: Sta */
public class x2 extends HandlerThread {
    public final Object a = new Object();

    public x2(String str) {
        super(str);
    }

    public void onLooperPrepared() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    public void start() {
        synchronized (this.a) {
            super.start();
            try {
                this.a.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
