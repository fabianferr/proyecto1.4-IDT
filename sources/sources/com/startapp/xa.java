package com.startapp;

import android.webkit.WebSettings;

/* compiled from: Sta */
public class xa implements Runnable {
    public final /* synthetic */ wa a;

    public xa(wa waVar) {
        this.a = waVar;
    }

    public void run() {
        wa waVar = this.a;
        waVar.getClass();
        try {
            waVar.c.a().execute(new ya(waVar, WebSettings.getDefaultUserAgent(waVar.a)));
        } catch (Throwable th) {
            if (waVar.a(16)) {
                i3.a(th);
            }
        }
    }
}
