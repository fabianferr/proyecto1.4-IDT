package com.startapp;

import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class o2 implements Runnable {
    public final /* synthetic */ ComponentLocator a;
    public final /* synthetic */ com.startapp.sdk.adsbase.remoteconfig.a b;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ Boolean a;

        public a(Boolean bool) {
            this.a = bool;
        }

        public void run() {
            o2.this.b.a(this.a);
        }
    }

    public o2(com.startapp.sdk.adsbase.remoteconfig.a aVar, ComponentLocator componentLocator) {
        this.b = aVar;
        this.a = componentLocator;
    }

    public void run() {
        this.a.h().execute(new a(this.b.a()));
    }
}
