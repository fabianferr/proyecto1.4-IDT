package com.m2catalyst.m2sdk;

/* compiled from: Logger */
public final class i2 {
    public String a = "";

    public final void a(String str) {
        synchronized (this) {
            this.a += System.currentTimeMillis() + " " + str + "\n";
        }
    }
}
